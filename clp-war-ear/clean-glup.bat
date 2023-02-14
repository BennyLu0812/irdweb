@echo off
echo cd ..\dls-web\src\main\webapp\
cd ..\dls-web\src\main\webapp\

echo svn revert -R .
svn revert -R .

echo svn cleanup --remove-unversioned
svn cleanup --remove-unversioned

echo cd ../../../../dls-war-ear
cd ../../../../dls-war-ear

echo finish clean gulp