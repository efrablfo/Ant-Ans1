INSTRUCTIVO

-Configurar propiedades del archivo .../dist/config.properties:
1. decoder-dir = Ruta del proyecto decoder
2. dist-dir = Ruta de folder "dist" del proyecto decoder
3. ant-build-dir = Ruta del archivo "build-impl.xml" del proyecto decoder
4. package-dir = Ruta de folder "src" del proyecto decoder
5. cdr-dir = Ruta de folder principal de CDRs.

-Ejecutar aplicativo:
1. Modificar archivo .../dist/jasn1-compiler.bat -> LIBDIR = ...AntAsn1\lib\libs-all 
2. Abrir consola CMD.
3. Entrar al folder que contiene el jar  [ cd ...AntAsn1/dist/ ]
4. Ejecutar jar [ java -jar AntAsn1.jar ]
5. Ubicamos esquema .asn y pulsamos el botón "Compilar".