echo off
echo inicializa el servidor de disparo
echo uso:
echo 2_ejesd HOSTNAME (en caso de omitirlo se usa localhost)
echo on

set cb=%cd%\tstTiendaElectronica.jar

if [%1] NEQ [] goto conHost
java -Djava.rmi.server.codebase=file:%cb% -jar %cb% tsttiendaelectronica.ServidorDeDisparo 
goto fin

:conHost
java -Djava.rmi.server.codebase=file:///%cb% -jar %cb% tsttiendaelectronica.ServidorDeDisparo %1

:fin
