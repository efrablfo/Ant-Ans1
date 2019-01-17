::BATCH file to windows
ECHO compiling

set LIBDIR=C:\Users\efrain.blanco\Documents\NetBeansProjects\AntAsn1\lib\libs-all

java -Djava.ext.dirs=%LIBDIR% org.openmuc.jasn1.compiler.Compiler %*
