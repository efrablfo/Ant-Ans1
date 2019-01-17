package com.asn1;

import static com.asn1.Util.copy;
import com.asn1.exception.Asn1SchemaException;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.ProjectHelper;

/**
 * Clase que construye decodificador asn1 basado en el compilador que ofrece
 * la libreria <a href="https://www.openmuc.org/asn1/">jASN1</a> 
 * @author Efrain Blanco
 * @author Jhon Fernandez
 * @version 1.0
 */
public class AntAsn1 implements Configuration{

    private String asnDirectory;
    private static String configPath;
    private static String classesDirectory;
    private static Properties configurations;
    private String asnFileName;
    private JTextPane txtPaneOutput;
    private JScrollPane scrollPaneOutput;
    private String packageName;
    
    static{
        try {
            configPath = System.getProperty(PROJECT_PATH);
            configurations = Util.getPropertiesConfigFile(configPath); 
        } catch (Exception ex) {
            ex.printStackTrace();
            System.exit(0);
        }
    }
    
    /**
     * Inicializa Objecto con la ubicación del archivo .asn y configura 
     * directorio de salida de clases generadas por el compilador jAsn1
     * @param asnDirectory  ubicacion del esquema asn1 (file.asn)
     */
    public AntAsn1(String asnDirectory){
        this.asnDirectory = asnDirectory;
        classesDirectory = configPath + File.separator + OUTPUT_CLASSES_FOLDER_NAME;
    }
    
    /**
     * Inicia secuencia de ejecución.
     * <ol>
     * <li>valida el esquema</li>
     * <li>ejecuta compilador jAsn1</li>
     * <li>Limpia directorio destino (Clases Asn1 generadas)</li>
     * <li>Copia clases generadas a directorio destino</li>
     * <li>Compila proyecto decoder y genera jar con las nuevas clases asn1</li>
     * <li>Crea directorio de esquema en folder principal de CDRs</li>
     * <li>Copia ejecutables a folder principal de CDRs</li>
     * <li>Copia esquema .asn a folder principal de CDRs</li>
     * </ol>
     * @see #validateSchema() 
     * @see #runJasn1Compiler()  
     * @see #prepareDestFolder() 
     * @see #copyClassesFolder() 
     * @see #callAntFile() 
     * @see #createDirAsn() 
     * @see #copyExecutables() 
     * @see #copyAsnFile() 
     * @throws Exception si la ejecución no fué exitosa
     */
    public void run() throws Exception {
        validateSchema();
        runJasn1Compiler();
        //configPackage();
        prepareDestFolder();
        copyClassesFolder();
        callAntFile();
        createDirAsn();
        copyExecutables();
        copyAsnFile();
        enableTextPane();
    }

    /**
     * Valida que el esquema cargado no haya sido procesado anteriormente
     * @see #buildAsnFileName() 
     * @see #printMessage(java.lang.String, boolean) 
     * @throws Asn1SchemaException  si el esquema ya existe en 
     *                              directorio principal de CDRs
     */
    private void validateSchema() throws Asn1SchemaException   {
        buildAsnFileName();
        String asnFolder = configurations.getProperty(CDR_MAIN_DIR_PROPERTY_NAME) + File.separator + asnFileName;
        
        if (Files.exists( Paths.get(asnFolder) )){
            printMessage("El esquema " + asnFileName + " ya existe", true);
            throw new Asn1SchemaException("El esquema ya existe");
        }
    }

    /**
     * Habilita area de texto de salida
     */
    private void enableTextPane() {
        txtPaneOutput.setEnabled(true);
    }
    
    /**
     * Crea folder de esquema junto con su estructura de subdirectorios 
     * (<code>ARRAY_DIR</code>) en Directorio principal de CDRs. 
     * Ejemplo: si el esquema cargado es air.asn se creara un folder llamado asn
     * @see Configuration#ARRAY_DIR
     * @see Configuration#CDR_MAIN_DIR_PROPERTY_NAME
     * @see #printMessage(java.lang.String, boolean) 
     * @see #createChildDir(java.lang.String, java.lang.String) 
     * @throws IOException  si el directorio <code>pathHomeAsn</code> está errado
     */
    private void createDirAsn() throws IOException {
        String dirHomeAsn = configurations.getProperty(CDR_MAIN_DIR_PROPERTY_NAME) + File.separator + asnFileName;
        printMessage("\n\nCreando directorio de esquema en " + dirHomeAsn, false);
        Path pathHomeAsn = Paths.get(dirHomeAsn);
        
        if (!Files.exists(pathHomeAsn)){
            Files.createDirectories(pathHomeAsn);
        }
        Arrays.asList(ARRAY_DIR).forEach(dir -> createChildDir(dir,dirHomeAsn));
    }

    /**
     * Extrae nombre del archivo .asn. 
     * Ejemplo: si el esquema cargado se llama air.asn entonces <code>asnFileName="air"</code>
     */
    private void buildAsnFileName() {
        asnFileName = asnDirectory.substring(asnDirectory.lastIndexOf("\\")).split("\\.")[0];
    }

    /**
     * Crea subdirectorio dentro de folder de esquema
     * @see #printMessage(java.lang.String, boolean) 
     * @param childDir  subdirectorio de folder de esquema
     * @param dirHomeAsn    directorio o folder de esquema
     */
    private void createChildDir(String childDir, String dirHomeAsn){
        Path pathChildDir = Paths.get(dirHomeAsn + File.separator + childDir);
        if (!Files.exists(pathChildDir)){
            try {
                printMessage("\nCreando subdirectorio de esquema " + pathChildDir.toString(), false);
                Files.createDirectories(pathChildDir);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
    /**
     * Copia ejecutable del decodificador y sus dependencias 
     * y lo pega en directorio destino (folder de esquema) <code>destDir</code>
     * @see #printMessage(java.lang.String, boolean) 
     * @see #filterExecutableFolder(java.nio.file.Path) 
     * @see #copyExePropertiesFile() 
     * @see Configuration#CDR_MAIN_DIR_PROPERTY_NAME
     * @see Configuration#EXE_FOLDERNAME
     * @see Configuration#DIST_DIR_PROPERTY_NAME
     * @throws IOException  si ocurre algun error en el copiado
     */
    private void copyExecutables() throws IOException{
        String destDir = configurations.getProperty(CDR_MAIN_DIR_PROPERTY_NAME) + 
                File.separator + asnFileName + File.separator + EXE_FOLDERNAME;
        printMessage("\nCopiando ejecutable a directorio " + destDir, false);
        Path distDir = Paths.get(configurations.getProperty(DIST_DIR_PROPERTY_NAME));
        Path destASNDir = Paths.get(destDir);
        
        Files.walk(distDir).filter(path ->  filterExecutableFolder(path) ).
                forEach(source -> copy(source, destASNDir.resolve(distDir.relativize(source))));
        copyExePropertiesFile();
    }
    
    /**
     * Copia archivo de configuración de ejecutable a folder de esquema
     * @see Util#copy(java.nio.file.Path, java.nio.file.Path) 
     * @see #printMessage(java.lang.String, boolean) 
     * @see Configuration#CDR_MAIN_DIR_PROPERTY_NAME
     * @see Configuration#EXE_FOLDERNAME
     * @see Configuration#EXE_PROPERTIES_FILE
     */
    private void copyExePropertiesFile(){
        String destDir = configurations.getProperty(CDR_MAIN_DIR_PROPERTY_NAME) + 
                File.separator + asnFileName + File.separator + EXE_FOLDERNAME + 
                File.separator + EXE_PROPERTIES_FILE;
        printMessage("\nCopiando arhivo de configuracion de ejecutable a directorio " + destDir, false);
        Path exePropertiesPath = Paths.get( configPath + File.separator + EXE_PROPERTIES_FILE);
        Path destASNDir = Paths.get(destDir);
        Util.copy(exePropertiesPath, destASNDir);
    }
    
    /**
     * Valida que <code>path</code> no sea un archivo 
     * de texto o pertenezca a la carpeta javadoc
     * @param path  Directorio
     * @return  <code>true</code> si <code>path</code> cumple con el filtro
     */
    private static boolean filterExecutableFolder(Path path) {
        return !(path.toString().toLowerCase().endsWith(".txt") || path.toString().contains("javadoc"));
    }
    
    /**
     * Copia archivo .asn a folder de esquema
     * @see #printMessage(java.lang.String, boolean) 
     * @see Util#copy(java.nio.file.Path, java.nio.file.Path) 
     * @see Configuration#CDR_MAIN_DIR_PROPERTY_NAME
     * @see Configuration#ASN_FOLDERNAME
     * @see Configuration#ASN_EXTENSION_FILE
     */
    private void copyAsnFile(){
        String destDir = configurations.getProperty(CDR_MAIN_DIR_PROPERTY_NAME) + 
                File.separator + asnFileName + File.separator + ASN_FOLDERNAME + 
                File.separator + asnFileName + ASN_EXTENSION_FILE;
        printMessage("\nCopiando archivo .asn a directorio " + destDir, false);
        Path asnDir = Paths.get(asnDirectory);
        Path destASNDir = Paths.get(destDir);
        Util.copy(asnDir, destASNDir);
    }
    
    /**
     * Ejecuta build.xml del proyecto decoder para generar ejecutable y sus dependencias
     * @see Configuration#ANT_BUILD_DIR_PROPERTY_NAME
     * @see Configuration#ANTFILE_PROPERTY_NAME
     * @see Configuration#ANT_PROJECT_HELPER_PROPERTY_NAME
     * @see #printMessage(java.lang.String, boolean) 
     */
    private void callAntFile(){
        printMessage("\n\nGenerando ejecutable... ", false);
        File buildFile = new File( configurations.get(ANT_BUILD_DIR_PROPERTY_NAME).toString() );
        Project antProject = new Project();
        antProject.setUserProperty( ANTFILE_PROPERTY_NAME, buildFile.getAbsolutePath() );
        antProject.init();
        ProjectHelper helper = ProjectHelper.getProjectHelper();
        antProject.addReference( ANT_PROJECT_HELPER_PROPERTY_NAME, helper);
        helper.parse(antProject, buildFile);
        antProject.executeTarget(antProject.getDefaultTarget());
    }    

    /**
     * Crea folder destino sino existe 
     * (carpeta del proyecto decoder donde se copiaran posteriormente las clases Asn1 generadas), 
     * en caso contrario limpia el directorio
     * @see #printMessage(java.lang.String, boolean) 
     * @see Configuration#PACKAGE_NAME_PROPERTY_NAME
     * @see Configuration#PACKAGE_DIR_PROPERTY_NAME
     * @throws IOException  si ocurre algun error 
     *                      en la configuración del folder destino
     */
    private void prepareDestFolder() throws IOException{
        packageName = Util.getPackageName( Paths.get(classesDirectory) );
        Util.setExeProperty(PACKAGE_NAME_PROPERTY_NAME, packageName);
        String destDir = configurations.get(PACKAGE_DIR_PROPERTY_NAME) + File.separator + packageName;        
        Path destDirPath = Paths.get(destDir);
        
        if (!Files.exists(destDirPath)){
            printMessage("\n\nCreando directorio " + destDir, false);
            Files.createDirectories(destDirPath);
        }
        
        printMessage("\n\nLimpiando directorio " + destDir, false);
        Files.walk(Paths.get(destDir ))
                .sorted(Comparator.reverseOrder())
                .map(Path::toFile)
                .forEach(File::delete);
    }
    
    /**
     * Copia las clases Asn1 generadas al folder src del proyecto decoder
     * @see #printMessage(java.lang.String, boolean) 
     * @see Configuration#PACKAGE_DIR_PROPERTY_NAME
     * @throws IOException si el copiado no es exitoso
     */
    private void copyClassesFolder() throws IOException{
        String destDir = configurations.get(PACKAGE_DIR_PROPERTY_NAME) + File.separator + packageName;
        printMessage("\n\nCopiando clases a directorio " + destDir, false);
        Path dest = Paths.get(destDir);
        Path src = Paths.get(classesDirectory + File.separator + packageName );
        Util.copyFolder(src, dest);
    }

    @Deprecated
    private void configPackage() throws Exception {
        printMessage("\n\nConfigurando paquetes de clases generadas", false);
        try (Stream<Path> paths = Files.walk(Paths.get(classesDirectory))) {
            List<Path> listPaths = paths.filter(Files::isRegularFile).collect(Collectors.toList());
            
            if( listPaths.isEmpty() ){
                printMessage("\n\nERROR: El paquete de clases generadas está vacio", true);
                throw new Exception("El paquete de clases generadas está vacio");
            }
            
            for (Path path : listPaths) {
                try (Stream<String> lines = Files.lines(path)) {
                    List<String> javaFile = lines.filter(line -> !line.startsWith( PACKAGE_STMT )).collect(Collectors.toList());
                    javaFile.add(0, PACKAGE_STMT + " " + packageName +  ";");
                    Files.write(path, javaFile);
                }
            }
        }
    }

    /**
     * ejecuta script <code>jasn1-compliler.bat</code> para generar clases Asn1
     * @see #printMessage(java.lang.String, boolean) 
     * @see Configuration#JASN1_BAT_FILE
     * @throws IOException si la ejecución no es exitosa
     */
    private void runJasn1Compiler() throws IOException{
        printMessage("***Compilando***", false);
        String command = configPath + File.separator + JASN1_BAT_FILE
                + " -f \"" + asnDirectory + "\" -o \"" + classesDirectory + "/\" ";
        
        Process process = Runtime.getRuntime().exec(command);
        printMessage("\nJASN1 Compiler output stream: " + process.getOutputStream(), false);
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            printMessage("\nJASN1 Compiler input stream: " + line, false);
        }
    }
    
    /**
     * Agrega mensaje en area de texto de salida
     * @param message   mensaje a agregar
     * @param isErrorMessage indica si es un mensaje de error
     */
    private void printMessage(String message, boolean isErrorMessage){
        StyledDocument document = txtPaneOutput.getStyledDocument();
        SimpleAttributeSet keyWord = null;
        
        if( isErrorMessage ){
            keyWord = new SimpleAttributeSet();
            StyleConstants.setForeground(keyWord, Color.RED);
            StyleConstants.setBackground(keyWord, Color.YELLOW);
            StyleConstants.setBold(keyWord, true);
        }
        try {
            document.insertString(document.getLength(), message, keyWord);
        } catch (BadLocationException ex) {
            ex.printStackTrace();
        }
    }

    public JTextPane getTxtPaneOutput() {
        return txtPaneOutput;
    }

    public void setTxtPaneOutput(JTextPane txtPaneOutput) {
        this.txtPaneOutput = txtPaneOutput;
    }

    public JScrollPane getScrollPaneOutput() {
        return scrollPaneOutput;
    }

    public void setScrollPaneOutput(JScrollPane scrollPaneOutput) {
        this.scrollPaneOutput = scrollPaneOutput;
    }

    public String getAsnDirectory() {
        return asnDirectory;
    }

    public void setAsnDirectory(String asnDirectory) {
        this.asnDirectory = asnDirectory;
    }
}
