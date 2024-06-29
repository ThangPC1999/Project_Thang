package actions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import base.driver.DriverManager;
import utilities.CommonFunctions;

public class Facebook_Actions {
	public static final By txtInputEmail = By.xpath(System.getProperty("Facebook.Login.Username.Input"));
	public static final By txtInputPass = By.xpath(System.getProperty("Facebook.Login.Password.Input"));
	public static final By btnLogin = By.xpath(System.getProperty("Facebook.Login.Login.Button"));
	public static final By msgSuccess = By.xpath(System.getProperty("Facebook.Login.Success.Message"));
	
	@FindBy(how = How.XPATH, using = "")
	private WebElement elem;
	private List<WebElement> lElems;
	public static WebDriver driver;

	public static WebDriver getDriver() {
		driver = DriverManager.getInstance().getDriver();
		return driver;
	}

	int timeOut = Integer.parseInt(System.getProperty("objectTimeout"));

	private static class SingletonHelper {
		private static final Facebook_Actions INSTANCE = new Facebook_Actions();
	}

	public static Facebook_Actions getInstance() {
		return SingletonHelper.INSTANCE;
	}
	
	public void openFacebookPage () {
		
		try {

			CommonFunctions.getInstance().goToUrl("https://www.facebook.com/");
			
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}
	
	public void senkeysMail() {
		try {
		CommonFunctions.getInstance().sendkeys(txtInputEmail, "0345060612");
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}
	
	public void senkeysPass() {
		try {
		CommonFunctions.getInstance().sendkeys(txtInputPass, "Thang100699");
		} catch (Exception e) {
			
		
			Assert.fail(e.getMessage());
		}
	}
		
	public void clicklLoginBtn() {
		try {
		CommonFunctions.getInstance().clickElement(btnLogin);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}
	
	public void successMgs() {
		try {
			
			CommonFunctions.getInstance().verifyElemIsDisplay(msgSuccess);
			
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

}
