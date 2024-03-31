package base.driver;

import org.openqa.selenium.WebDriver;

import io.appium.java_client.AppiumDriver;

public class DriverManager {

	private static final ThreadLocal<WebDriver> driver = new InheritableThreadLocal<WebDriver>();
	private static final ThreadLocal<AppiumDriver> driverApp = new InheritableThreadLocal<AppiumDriver>();

	private DriverManager() {
	}

	private static class SingletonDriver {
		private static final DriverManager INSTANCE = new DriverManager();
	}

	public static DriverManager getInstance() {
		return SingletonDriver.INSTANCE;
	}

	public WebDriver getDriver() {
		return driver.get();
	}

	public void setDriver(WebDriver driverT) {
		driver.set(driverT);
	}

	public AppiumDriver getDriverApp() {
		return driverApp.get();
	}

	public void setDriverApp(AppiumDriver driverT) {
		driverApp.set(driverT);
	}

	public void closeBrowser() {
		for (String s : driver.get().getWindowHandles()) {
			driver.get().switchTo().window(s).close();
		}
		
		driver.get().quit();

		driver.remove();
		System.out.println("Quit driver: " + Thread.currentThread().getId());
	}
	

	public void removeAppium() {
		driverApp.get().quit();
		driverApp.remove();
	}


}
