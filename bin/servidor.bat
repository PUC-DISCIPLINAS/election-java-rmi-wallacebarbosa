@echo
TITLE Server RMI
cd %~dp0\bin
java -Djava.security.policy=rmi.policy -Djava.rmi.server.useCodebaseOnly=false -Djava.rmi.server.hostname=localhost -Djava.rmi.server.codebase=file:%~dp0bin ServerRmi

pause