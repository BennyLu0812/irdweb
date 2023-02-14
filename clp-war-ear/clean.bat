@echo off
echo start clean...
echo start execute mvn -f pom-install.xml clean -Dmaven.test.skip=true -l log-clean.log

echo Please wait...

if not "%JAVA_HOME%" == "" goto gotM2Home
set "JAVA_HOME=C:\Users\atos.dchu\Desktop\jim\jdk1.8.0_92"

:gotM2Home

if not "%M2_HOME%" == "" goto gotHome
set "M2_HOME=C:\apache-maven-3.3.9"

rem set JAVA_HOME=C:\Users\atos.dchu\Desktop\jim\jdk1.8.0_92
rem set M2_HOME=C:\apache-maven-3.3.9


:gotHome


%M2_HOME%\bin\mvn -f pom-install.xml clean -Dmaven.test.skip=true -l log-clean.log 

echo end execute mvn -f pom-install.xml clean -Dmaven.test.skip=true -l log-clean.log 
