set ProjectPath=%~dp0
cd %ProjectPath%
set p=%PATH%
java -classpath "%ProjectPath%bin;%ProjectPath%libSelenium\*" org.testng.TestNG "%ProjectPath%bin\runNopCommerce.xml"
pause