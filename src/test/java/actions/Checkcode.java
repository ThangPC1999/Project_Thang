package actions;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class Checkcode {
	
	WebDriver driver;
 
  @BeforeClass
  public void beforeClass() {
	  System.getProperty("webdriver.chrome.driver", "/Users/thang.phan/Desktop/Project_Thang/Driver/chromedriver");
	  driver = new ChromeDriver ();
	  driver.get("https://www.geeksforgeeks.org/how-to-open-chrome-browser-using-selenium-in-java/");
  }
  @Test
  public void f() {
  }
  @AfterClass
  public void afterClass() {
	  
	  driver.quit();

  }

}
