@echo
TITLE Server RMI

java -Djava.security.policy=rmi.policy -Djava.rmi.server.useCodebaseOnly=false -Djava.rmi.server.hostname=localhost -Djava.rmi.server.codebase=file:%~dp0 ServerRmi

pause