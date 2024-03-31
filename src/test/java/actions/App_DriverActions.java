package actions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import base.driver.DriverManager;
import io.appium.java_client.AppiumDriver;
import utilities.CommonFunctions;

public class App_DriverActions {
	private static final By btnIgnore = By.xpath(System.getProperty("App.Login.Ignore.Input"));
	private static final By txtUserName = By.xpath(System.getProperty("App.Login.UserName.Input"));
	private static final By txtPassword = By.xpath(System.getProperty("App.Login.Password.Input"));
	private static final By btnSignIn = By.xpath(System.getProperty("App.Login.SignIn.Button"));
	private static final By btnLocation = By.xpath(System.getProperty("App.Home.PopUp.Location.Text"));
	private static final By btnContinous = By.xpath(System.getProperty("App.Home.PopUp.Continous.Button"));
	private static final By btnUsingLocation = By.xpath(System.getProperty("App.Home.PopUp.Location.Using.Button"));
	private static final By txtUpdate = By.xpath(System.getProperty("App.Home.PopUp.Update.Text"));
	private static final By btnMenuHome = By.xpath(System.getProperty("App.Home.Menu.Home.Button"));
	
	@FindBy(how = How.XPATH, using = "")
	private WebElement elem;
	private List<WebElement> lElems;

	int timeOut = Integer.parseInt(System.getProperty("objectTimeout"));
	private AppiumDriver androidDriver = DriverManager.getInstance().getDriverApp();

	private static class SingletonHelper {
		private static final App_DriverActions INSTANCE = new App_DriverActions();
	}

	public static App_DriverActions getInstance() {
		return SingletonHelper.INSTANCE;
	}

	public void clickBtnIgnore() {
		try {
			
			CommonFunctions.getInstance().waitUntilAndroidElementLocated(androidDriver, btnIgnore, timeOut);

			androidDriver.findElement(btnIgnore).click();
		
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}
	
	public void sendKeysUserName() {
		try {
			
			CommonFunctions.getInstance().waitUntilAndroidElementLocated(androidDriver, txtUserName, timeOut);

			androidDriver.findElement(txtUserName).sendKeys(System.getProperty("dUserNameDriver"));;
		
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}
	
	public void sendKeysPassword() {
		try {
			
			CommonFunctions.getInstance().waitUntilAndroidElementLocated(androidDriver, txtPassword, timeOut);

			androidDriver.findElement(txtPassword).sendKeys(System.getProperty("dPasswordDriver"));;
		
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			
		}
	}
	
	public void clickBtnSignIn() {
		try {
			
			CommonFunctions.getInstance().waitUntilAndroidElementLocated(androidDriver, btnSignIn, timeOut);

			androidDriver.findElement(btnSignIn).click();
			
			Thread.sleep(10000);
		
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}
	
	public void clickBtnLocation() {
		try {
			
			Thread.sleep(10000);
			
			CommonFunctions.getInstance().waitUntilAndroidElementLocated(androidDriver, btnLocation, timeOut);

			androidDriver.findElement(btnLocation).click();
			
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}
	
	public void clickBtnContinous() {
		try {
			
			CommonFunctions.getInstance().waitUntilAndroidElementLocated(androidDriver, btnContinous, timeOut);

			androidDriver.findElement(btnContinous).click();
			
			Thread.sleep(5000);
		
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}
	
	public void clickBtnUsing() {
		try {
			
			CommonFunctions.getInstance().waitUntilAndroidElementLocated(androidDriver, btnUsingLocation, timeOut);

			androidDriver.findElement(btnUsingLocation).click();
			
			CommonFunctions.getInstance().waitUntilAndroidElementNotLocated(androidDriver,txtUpdate, 360);
			
			Thread.sleep(20000);
		
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}
	
	public void clickBtnHome() {
		try {
			
			CommonFunctions.getInstance().waitUntilAndroidElementLocated(androidDriver, btnMenuHome, timeOut);

			androidDriver.findElement(btnMenuHome).click();
			
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

}
