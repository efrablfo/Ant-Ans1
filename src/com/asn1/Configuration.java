package com.asn1;

/**
 * Interfaz con parametros de configuración para el procesamiento de un esquema .asn
 * @author Efrain.Blanco
 * @version 1.0
 */
public interface Configuration {
    public static final String PROJECT_PATH = "user.dir";
    public static final String CONFIG_PROPERTIES_FILENAME = "config.properties";
    public static final String EXE_PROPERTIES_FILE = "exe.properties";
    public static final String ASN1_DIR_PROPERTY_NAME = "asn1-dir";
    public static final String ANTFILE_PROPERTY_NAME = "ant.file";
    public static final String ANT_PROJECT_HELPER_PROPERTY_NAME = "ant.projectHelper";
    public static final String ANT_BUILD_DIR_PROPERTY_NAME = "ant-build-dir";
    public static final String PACKAGE_DIR_PROPERTY_NAME = "package-dir";
    public static final String CDR_MAIN_DIR_PROPERTY_NAME = "cdr-dir";
    //public static final String JAR_PACKAGE_NAME = "genericdr";
    public static final String DIST_DIR_PROPERTY_NAME = "dist-dir";
    public static final String PACKAGE_STMT = "package";
    public static final String ASN_FOLDERNAME = "asn";
    public static final String EXE_FOLDERNAME = "exe";
    public static final String ASN_EXTENSION_FILE = ".asn";
    public static final String JASN1_BAT_FILE = "jasn1-compiler.bat";
    public static final String OUTPUT_CLASSES_FOLDER_NAME = "generado";
    public static final String PACKAGE_NAME_PROPERTY_NAME = "package-name";
    public static final String[] ARRAY_DIR ={"cdr-out","err","in","out","prc","asn","exe","logs"};
}
