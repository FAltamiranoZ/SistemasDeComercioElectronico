set cb="tstRMIPractica1_3.2.jar"

if [%1] NEQ [] goto conHost
java -Djava.rmi.server.codebase=file:///%cb% -jar %cb% example.hello.Master localhost reporta
goto fin

:conHost
java -Djava.rmi.server.codebase=file:///%cb% -jar %cb% example.hello.Master %1 reporta
:fin


