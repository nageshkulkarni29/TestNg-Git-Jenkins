package NKpackage;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class NewTest extends BaseClass{
  private static final Object ChromeDriver = null;

@Test
  public void NewTest() {
	
	driver.navigate().to("https://www.nseindia.com/");
	Reporter.log("Browser Launched", 1,true);

	  
  }
  @BeforeTest
  public void beforeTest() {
	  createwebdriver();
  }

  @AfterTest
  public void afterTest() {
	  CloseWebdriver();
	  Reporter.log("Browser Closed", 1,true);
  }

}
