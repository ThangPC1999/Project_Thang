package base;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;

import base.driver.DriverManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.CommonFunctions;

public class TestBase {
	private WebDriver driver;
	private AppiumDriver appiumDriver;

	@Before
	public void setUp(Scenario scenario) throws InterruptedException, IOException {
		System.out.println("Set up");

		setUpDriver();

	}

	@AfterStep
	public void afterStep(Scenario scenario) throws IOException, InterruptedException {
//        CommonFunctions.getInstance().genarateReport();

		if (scenario.isFailed()) {
			final byte[] sceenshot = ((TakesScreenshot) DriverManager.getInstance().getDriver())
					.getScreenshotAs(OutputType.BYTES);
			scenario.attach(sceenshot, "image/png", scenario.getName() + "_Fail");
			System.setProperty("scenario_fail", scenario.getName());
		}
	}

	@After
	public void tearDown() throws IOException {
		System.out.println("Tear down thread: " + Thread.currentThread().getId());

		DriverManager.getInstance().closeBrowser();

//		if (DriverManager.getInstance().getDriverApp() != null)
//			DriverManager.getInstance().removeAppium();
	}

	@SuppressWarnings("deprecation")
	public void setUpDriver() throws IOException {
		// Read properties files
		CommonFunctions.getInstance().funcReadPropertiesFile("src/test/resources/config/enviroment.properties");

		if (System.getProperty("env").equals("stg")) {

			CommonFunctions.getInstance()
					.funcReadPropertiesFile("src/test/resources/config/application-stg.properties");
			CommonFunctions.getInstance().funcReadPropertiesFile("src/test/resources/config/api-stg.properties");

		} else {

			CommonFunctions.getInstance()
					.funcReadPropertiesFile("src/test/resources/config/application-prod.properties");

		}

		CommonFunctions.getInstance().funcReadPropertiesFile("src/test/resources/config/object.properties");
		CommonFunctions.getInstance().funcReadPropertiesFile("src/test/resources/data/data.properties");
		CommonFunctions.getInstance().funcReadPropertiesFile("src/test/resources/data/errorMsg.properties");
		CommonFunctions.getInstance().funcReadPropertiesFile("src/test/resources/data/successMsg.properties");
		CommonFunctions.getInstance().funcReadPropertiesFile("src/test/resources/data/warningMsg.properties");
		CommonFunctions.getInstance().funcReadPropertiesFile("src/test/resources/data/status.properties");

//		// ANDROID
//		DesiredCapabilities desCaps = new DesiredCapabilities();
//
//		desCaps.setCapability("platformName", "Android");
//		desCaps.setCapability("platformVersion", System.getProperty("androidVersion").trim());
//		desCaps.setCapability("deviceName", System.getProperty("androidDeviceName").trim());
//		desCaps.setCapability("appPackage", System.getProperty("androidAppPackage").trim());
//		desCaps.setCapability("appActivity", System.getProperty("androidAppActivity").trim());
//		desCaps.setCapability("automationName", "Appium");
//        desCaps.setCapability(AndroidMobileCapabilityType.APP_WAIT_ACTIVITY, "*"); // Set noReset capability to true
//
//		appiumDriver = new AndroidDriver(new URL("http://" + System.getProperty("androidAppiumServerIP").trim() + ":"
//				+ System.getProperty("appiumPort").trim() + "/wd/hub"), desCaps);
//
//		appiumDriver.manage().timeouts().implicitlyWait(Integer.parseInt(System.getProperty("objectTimeout")),
//				TimeUnit.SECONDS);
//
//		DriverManager.getInstance().setDriverApp(appiumDriver);
//
//		appiumDriver = DriverManager.getInstance().getDriverApp();

		switch (System.getProperty("browserName")) {
		case "chrome":

			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("useAutomationExtension", false);
			options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
			// options.setBinary("C:\\Users\\11E00003\\Downloads\\GoogleChromePortable64\\App\\Chrome-bin\\chrome.exe");
			// options.addArguments("chrome.switches", "--disable-extensions");
			options.addArguments("--start-maximized");
			options.addArguments("--disable-web-security");
			options.addArguments("--no-proxy-server");
			options.addArguments("test-type");
			options.addArguments("disable-popup-blocking");
			options.addArguments("--use-fake-ui-for-media-stream");
			options.addArguments("--disable-notifications");
			options.addArguments("--remote-debugging-port=9222");

			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
//	        options.addArguments("auto-open-devtools-for-tabs");

			options.setExperimentalOption("prefs", prefs);

			// options.addArguments("--disable-gpu");

			DesiredCapabilities caps = new DesiredCapabilities();
			LoggingPreferences logPrefs = new LoggingPreferences();
			logPrefs.enable(LogType.BROWSER, Level.ALL);
			caps.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
			options.addArguments("--remote-allow-origins=*");
			caps.setCapability(ChromeOptions.CAPABILITY, options);
			caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

			options.setCapability(ChromeOptions.CAPABILITY, caps);

			// WebDriver driver = new ChromeDriver(options);
			driver = new ChromeDriver(options);

			driver.manage().window().maximize();

			DriverManager.getInstance().setDriver(driver);

			System.out.println("Start driver: " + Thread.currentThread().getId());
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			FirefoxDriver firefoxDriver = new FirefoxDriver();
			firefoxDriver.manage().window().maximize();
			DriverManager.getInstance().setDriver(firefoxDriver);

			System.out.println("Start driver: " + Thread.currentThread().getId());
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			EdgeDriver edgeDriver = new EdgeDriver();
			edgeDriver.manage().window().maximize();
			DriverManager.getInstance().setDriver(edgeDriver);

			System.out.println("Start driver: " + Thread.currentThread().getId());
			break;

		case "safari":
			WebDriverManager.safaridriver().setup();
			SafariDriver safariDriver = new SafariDriver();
			safariDriver.manage().window().maximize();
			DriverManager.getInstance().setDriver(safariDriver);

			System.out.println("Start driver: " + Thread.currentThread().getId());
			break;

		}
	}
}
