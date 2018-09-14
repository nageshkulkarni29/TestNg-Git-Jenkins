package NKpackage;

import java.io.File;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class BaseClass implements ISuiteListener, ITestListener  {
	WebDriver driver;
	
	
	public void createwebdriver(){
    	File file1 = new File("N:\\eclipseprojects\\chromedriver.exe");
    	System.setProperty("webdriver.chrome.driver", file1.getAbsolutePath());
    	driver= new ChromeDriver();
    	driver.manage().window().maximize();
    	System.out.println("driver launched");
    	return;
	}
	
	public void CloseWebdriver(){
		driver.quit();
		System.out.println("quit");
	}

	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		Reporter.log("Test Finish" + arg0.getName(), true);
		
	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		Reporter.log("Test Start" + arg0.getName(), true);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		Reporter.log("Test Failed success" + arg0.getName(), true);
	}

	@Override
	public void onTestFailure(ITestResult arg0) {
		// TODO Auto-generated method stub
		Reporter.log("Test Failure" + arg0.getName(), true);
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		Reporter.log("Test Skipped" + arg0.getName(), true);
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		Reporter.log("Test Start" + arg0.getName(), true);
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		Reporter.log("Test Success" + arg0.getName(), true);
	}

	@Override
	public void onFinish(ISuite arg0) {
		// TODO Auto-generated method stub
		Reporter.log("Testsuite Finish" + arg0.getName(), true);
	}

	@Override
	public void onStart(ISuite arg0) {
		// TODO Auto-generated method stub
		Reporter.log("Testsuite Finish" + arg0.getName(), true);
	}

}
