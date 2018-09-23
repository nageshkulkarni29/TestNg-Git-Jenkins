package NKpackage;

import java.io.File;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.IRetryAnalyzer;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseClass implements ISuiteListener, ITestListener , IRetryAnalyzer {
	WebDriver driver;
	 protected static ExtentReports extent;
	 protected static ExtentTest extenttest;
	int counter = 0;
	int retryLimit = 3; 	
	   
	
	public void createwebdriver(String Browsername){
		File file1;
		switch (Browsername){		
		case "IE":
	    	file1 = new File("N:\\eclipseprojects\\IEDriverServer.exe");
	    	System.setProperty("webdriver.ie.driver", file1.getAbsolutePath());
	    	driver= new InternetExplorerDriver();
	    	driver.manage().window().maximize();
	   break; 	
	    	
		case "Chrome":
	    	file1 = new File("N:\\eclipseprojects\\chromedriver.exe");
	    	System.setProperty("webdriver.chrome.driver", file1.getAbsolutePath());
	    	driver= new ChromeDriver();
	    	driver.manage().window().maximize();
	    break;	
	    default:
	    	System.out.println("browser not found");
	    break;
		}
				

	}
	
	public void CloseWebdriver(){
		driver.quit();
		System.out.println("quit");
	}

	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		//Reporter.log("Reporter Test Finish" + arg0.getName(), true);
		System.out.println("Test Finish level");
		
		
	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		//Reporter.log("Reporter Test Start" + arg0.getName(), true);
		extenttest = extent.startTest(arg0.getName());
		//extenttest=arg0.getName();
		System.out.println("Test Start Level");
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		//Reporter.log("Reporter Test Failed success" + arg0.getName(), true);
		System.out.println("on test failed with % Level");
		extenttest.log(LogStatus.FAIL, "Test failure reported");
		extent.flush();
		
	}

	@Override
	public void onTestFailure(ITestResult arg0) {
		// TODO Auto-generated method stub
		//Reporter.log("Reporter Test Failure" + arg0.getName(), true);
		System.out.println("on Test Failure");
		extenttest.log(LogStatus.FAIL, "Test failure reported");
		extent.flush();
		
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		//Reporter.log("Test Skipped" + arg0.getName(), true);
		System.out.println("On Test Skipped ");
		extenttest.log(LogStatus.INFO, "Test skipped reported");
		extent.flush();
		
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		//Reporter.log("Test Start" + arg0.getName(), true);
		//extent.startTest(arg0.getName());
		//ExtentTest extenttest = extent.startTest(arg0.getName());
		System.out.println("On Test Start Level");
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		//Reporter.log("Reporter logs Test Success" + arg0.getName(), true);
		//extent.startTest(arg0.getName());
		System.out.println("On Test Success");
		extenttest.log(LogStatus.PASS, arg0.getName());
		extent.flush();
		
	}

	@Override
	public void onFinish(ISuite arg0) {
		// TODO Auto-generated method stub
		//Reporter.log("Reporter Testsuite Finish" + arg0.getName(), true);
		extent.flush();
		System.out.println("Suite End");
	}

	@Override
	public void onStart(ISuite arg0) {
		// TODO Auto-generated method stub
		if (extent==null){
		String workingDir = System.getProperty("user.dir");
        extent = new ExtentReports(workingDir+"\\ExtentReports\\ExtentReportResults.html", true);
	      //extent= ExtentReport.Instance();
	      extent.assignProject("Demo Project");
	       System.out.println("Suite Start");
		}
	    }

	@Override
	public boolean retry(ITestResult arg0) {
		// TODO Auto-generated method stub
		if(counter < retryLimit)
		{
			counter++;
			return true;
		}
		return false;
	}

}
