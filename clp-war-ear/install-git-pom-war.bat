@echo off

echo %M2_HOME%\bin\mvn -f pom-ear.xml clean install -Dmaven.test.skip=true -D%Package_type% -DfinalName=%JOB_NAME%-%dlsVersion%.stable-%buildTime% -DbuildTime=%buildTime% -DdlsVersion=%dlsVersion% -Drun.env=%package_env% -DCOOKIE-NAME=%COOKIE-NAME% -l log-ear.log 
%M2_HOME%\bin\mvn -f pom-ear.xml clean install -Dmaven.test.skip=true -D%Package_type% -DfinalName=%JOB_NAME%-%clpVersion%.stable-%buildTime% -DbuildTime=%buildTime% -DclpVersion=%clpVersion% -Drun.env=%package_env% -DCOOKIE-NAME=%COOKIE-NAME% -l log-ear.log 