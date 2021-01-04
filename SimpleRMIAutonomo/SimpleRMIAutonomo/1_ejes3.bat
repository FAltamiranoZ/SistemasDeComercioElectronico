
rem -Djava.rmi.server.useCodebaseOnly=false
rem java -Djava.rmi.server.useCodebaseOnly=false -Djava.rmi.server.codebase=file:///%cb% -jar %cb% Server 
rem java -Djava.rmi.server.codebase=file:///%cb% -jar %cb% Server 

echo off
echo inicia el servidor
echo uso:
echo 1_ejes HOSTNAME (en caso de omitirlo se usa localhost)
echo on

set cb=%cd%\tstRMIPractica1_3.2.jar

if [%1] NEQ [] goto conHost
java -Djava.rmi.server.codebase=file:%cb% -jar %cb% example.hello.Server 
goto fin

:conHost
java -Djava.rmi.server.codebase=file:%cb% -jar %cb% example.hello.Server %1

:fin
