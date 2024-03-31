package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import base.driver.DriverManager;
import utilities.CommonFunctions;

public class Seller_LoginPageActions {

	private static final By btnSignIn = By.xpath(System.getProperty("Seller.Login.SignIn.Button"));
	private static final By txtUserName = By.xpath(System.getProperty("Seller.Login.Username.Input"));
	private static final By txtPassword = By.xpath(System.getProperty("Seller.Login.Password.Input"));
	private static final By iconProcess = By.xpath(System.getProperty("Icon.Progress"));

	@FindBy(how = How.XPATH, using = "")
	private WebElement elem;
	public static WebDriver driver;

	public static WebDriver getDriver() {
		driver = DriverManager.getInstance().getDriver();
		return driver;
	}

	int timeOut = Integer.parseInt(System.getProperty("objectTimeout"));

	private static class SingletonHelper {
		private static final Seller_LoginPageActions INSTANCE = new Seller_LoginPageActions();
	}

	public static Seller_LoginPageActions getInstance() {
		return SingletonHelper.INSTANCE;
	}

	public void sendKeysUserName() {

		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(txtUserName, timeOut);

			CommonFunctions.getInstance().sendkeys(txtUserName,System.getProperty("dSellerUserName"));

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void sendKeysPassword() {

		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(txtPassword, timeOut);

			CommonFunctions.getInstance().sendkeys(txtPassword,System.getProperty("dSellerPassword"));


		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void clickBtnSignIn() {

		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnSignIn, timeOut);
			
			CommonFunctions.getInstance().clickElement(btnSignIn);

			CommonFunctions.getInstance().waitForPageLoad(timeOut);
			
			CommonFunctions.getInstance().waitForElementToDisappear(iconProcess, timeOut);
			
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

}
