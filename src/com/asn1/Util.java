package com.asn1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Properties;

/**
 * Clase utilitaria para el procesamiento de esquemas .asn
 * @author Efrain.Blanco
 * @version 1.0
 */
public class Util implements Configuration{
    
    /**
     * Copia los archivos de un folder origen en un directorio destino
     * @param src   path origen
     * @param dest  path destino
     * @throws IOException  si la copia no es exitosa
     */
    public static void copyFolder(Path src, Path dest) throws IOException {
        Files.walk(src).forEach(source -> copy(source, dest.resolve(src.relativize(source))));
    }
    
    /**
     * Obtiene el nombre del paquete de las clases generadas.
     * @param basePackage   folder base donde se generan las clases Asn1 
     * @return  nombre del paquete (ModuleName-OutpuRecord) de las clases Asn1 generadas
     * @throws IOException  si la ejecución no fue existosa
     */
    public static String getPackageName(Path basePackage) throws IOException {
        Path packageNamePath = Files.walk(basePackage).filter(p -> {
            try {
                return Files.isDirectory(p) && !Files.isSameFile(basePackage, p);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            return false;
        }).findFirst().get();
        return packageNamePath.getFileName().toString();
    }
    
    /**
     * Copia un archivo a un directorio destino
     * @param source path origen
     * @param dest path destino 
     */
    public static void copy(Path source, Path dest) {
        try {
            Files.copy(source, dest, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
    
    /**
     * Retorna objeto con la información de config.properties
     * @see Configuration#CONFIG_PROPERTIES_FILENAME
     * @param configPath directorio actual
     * @return objeto <code>Properties</code>
     * @throws FileNotFoundException si no encuentra el arhivo config.properties
     * @throws IOException si ocurre un error en la lectura del archivo config.properties
     */
    public static Properties getPropertiesConfigFile(String configPath) throws FileNotFoundException, IOException{
        Properties prop = new Properties();
        FileInputStream input = new FileInputStream(configPath + File.separator + CONFIG_PROPERTIES_FILENAME);
        prop.load(input);
        return prop;
    }
    
    /**
     * Modifica valor de una propiedad en archivo exe.properties
     * @param key clave de propiedad
     * @param value valor de propiedad
     * @throws IOException si ocurre un error en la lectura o escritura del archivo exe.properties
     */
    public static void setExeProperty(String key, String value) throws IOException{
        Properties prop = new Properties();
        FileOutputStream output = null;
        String exePropertiesFile = System.getProperty(PROJECT_PATH) + File.separator + EXE_PROPERTIES_FILE ;

        try {
            FileInputStream input = new FileInputStream(exePropertiesFile);
            prop.load(input);
            prop.setProperty( key, value);
            output = new FileOutputStream(exePropertiesFile);
            prop.store(output, null);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            output.close();
        }
    }
}
