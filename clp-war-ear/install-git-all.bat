@echo off
setlocal enabledelayedexpansion
rem set params 
set /p envNumber=Please enter the ENV Number(d:dev):
set /p clpVersion=Please enter the SYS_VERSION:

for %%i in (A B C D E F G H I J K L M N O P Q R S T U V W X Y Z) do call set envNumber=%%envNumber:%%i=%%i%%
if %envNumber%==D (
	set package_env=dev
	set Package_type=DEV
	set JOB_NAME=CLP_DEV
	set COOKIE-NAME=CLPCookie_dev
)  

rem set time
for /f "delims=" %%a in ('reg query "HKEY_CURRENT_USER/Control Panel/International" /v sShortDate') do (
  set "RegDateOld=%%a"
)
set RegDateOld=%RegDateOld:~-8%
reg add "HKEY_CURRENT_USER/Control Panel/International" /v sShortDate /t REG_SZ /d yyyy-M-d /f>nul
set Today=%date: =%
reg add "HKEY_CURRENT_USER/Control Panel/International" /v sShortDate /t REG_SZ /d %RegDateOld% /f>nul
if "%Today:~0,1%" gtr "9" (
  set Today=%Today:~-10%
) else (
  set Today=%Today:~0,10%
)
set month=%Today:~5,2%
set month=%month: =0%

set day=%Today:~8,2%
set day=%day: =0%

set hour=%time:~0,2%
set hour=%hour: =0%

set minute=%time:~3,2%
set minute=%minute: =0%

set buildTime=%Today:~0,4%%month%%day%%hour%%minute%

rem clean
cd ../clp-web/src/main/webapp/
git checkout . && git clean -xdf

rem gulp
cd ../../../../clp-war-ear/
call install-gulp.bat

rem start install...
echo start install...
echo Please wait...

if not "%JAVA_HOME%" == "" goto gotM2Home
set "JAVA_HOME=C:\Users\BennyLu\Desktop\ird\zulu8.54.0.21-jdk8.0.292"

:gotM2Home

if not "%M2_HOME%" == "" goto gotHome
set "M2_HOME=D:\apache-maven-3.3.9"

rem set JAVA_HOME=C:\Users\BennyLu\Desktop\ird\zulu8.54.0.21-jdk8.0.292
rem set M2_HOME=D:\apache-maven-3.3.9

:gotHome

call install-git-pom-install.bat


call install-git-pom-war.bat
echo install war, Please wait...
echo end	
	
	
pause

