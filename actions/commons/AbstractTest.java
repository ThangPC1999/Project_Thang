package commons;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class AbstractTest {
	// Dùng chung cho tầng testcases (Test Class)

	WebDriver driver;
	
	public WebDriver getBrowser(String browserName) {
		if(browserName.equalsIgnoreCase("firefox")) {
//			System.setProperty("webdriver.gecko.driver", "/Users/thang.phan/Downloads/geckodriver");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			} else if (browserName.equalsIgnoreCase("chrome")) {
//				System.setProperty("webdriver.chrome.driver", "/Users/thang.phan/Downloads/chromedriver_mac64/chromedriver");
			WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			} else if (browserName.equalsIgnoreCase("edge")) {
//				System.setProperty("webdriver.edge.driver", "/Users/thang.phan/Downloads/msedgedriver");
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			} else {
				System.out.println("Please choose your browser");
			}
			driver.manage().window().maximize();
			
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

//			driver.get("http://live.techpanda.org/index.php/");
			driver.get("https://www.jqueryscript.net/demo/CRUD-Data-Grid-Plugin-jQuery-Quickgrid/");
			return driver;
	}
}
