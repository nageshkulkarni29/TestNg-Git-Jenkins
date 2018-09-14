package NKpackage;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class NewTest1 extends BaseClass {
  @Test
  public void NewTest1() {
	  driver.navigate().to("https://amazon.com/");
	  Reporter.log("Browser Launched", 1,true);
  }
  @BeforeTest
  public void beforeTest() {
	  createwebdriver();
  }

  @AfterTest
  public void afterTest() {
	  CloseWebdriver();
	  Reporter.log("Browser Closed", 2,true);
  }

}
