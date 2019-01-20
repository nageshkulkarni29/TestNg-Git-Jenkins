set projectLocation=N:\eclipseprojects\TestNgPractice
cd %projectLocation%
set classpath=%projectLocation%\bin;%projectLocation%\jars\*
java org.testng.TestNG %projectLocation%\testng.xml
pause