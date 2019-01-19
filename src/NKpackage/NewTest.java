package NKpackage;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

@Listeners(NKpackage.BaseClass.class)
public class NewTest extends BaseClass{
  //private static final Object ChromeDriver = null;
	
@Test(retryAnalyzer=BaseClass.class)
  public void NewTest() {
	Assert.assertEquals(true, true);	
try{
	driver.navigate().to("https://www.nseindia.com/");
	Reporter.log("Browser Launched", 1,true);
	extenttest.log(LogStatus.PASS, "driver launched","NSE application lauched");
	}
	catch(Exception e){
		extenttest.log(LogStatus.FAIL, "driver launched to fail","NSE application lauch failed");
	}
	  
  }

  @BeforeTest
  @Parameters("sBrowser")
  public void beforeTest(String sBrowser) {
	  createwebdriver(sBrowser);
	  extenttest.log(LogStatus.INFO, "test started with browser"+sBrowser);
  }

  @AfterTest
  public void afterTest() {
	  CloseWebdriver();
	  Reporter.log("Browser Closed", 1,true);
	  //extenttest.log(LogStatus.PASS,"driver closed succesfully");
	  extenttest.log(LogStatus.PASS, "driver closed","NSE application closed");
  }
}
