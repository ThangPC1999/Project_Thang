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

public class Supplier_LoginPageActions {

	private static final By btnSignIn = By.xpath(System.getProperty("Supplier.Login.SignIn.Button"));
	private static final By txtUserName = By.xpath(System.getProperty("Supplier.Login.Username.Input"));
	private static final By txtPassword = By.xpath(System.getProperty("Supplier.Login.Password.Input"));
	private static final By iconProcess = By.xpath(System.getProperty("Icon.Progress"));
	private static final By iconClosed = By.xpath(System.getProperty("Supplier.Home.Logo.Closed.Button"));

	@FindBy(how = How.XPATH, using = "")
	private WebElement elem;
	public static WebDriver driver;

	public static WebDriver getDriver() {
		driver = DriverManager.getInstance().getDriver();
		return driver;
	}

	int timeOut = Integer.parseInt(System.getProperty("objectTimeout"));

	private static class SingletonHelper {
		private static final Supplier_LoginPageActions INSTANCE = new Supplier_LoginPageActions();
	}

	public static Supplier_LoginPageActions getInstance() {
		return SingletonHelper.INSTANCE;
	}

	public void sendKeysUserName() {

		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(txtUserName, timeOut);

			CommonFunctions.getInstance().sendkeys(txtUserName,System.getProperty("dSupplierUserName"));

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void sendKeysPassword() {

		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(txtPassword, timeOut);

			CommonFunctions.getInstance().sendkeys(txtPassword,System.getProperty("dSupplierPassword"));


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
			
			if(CommonFunctions.getInstance().checkElementsByVisibilityWithTimeInput(iconClosed, 10)) {
				
				CommonFunctions.getInstance().clickElement(iconClosed);
				
			}

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

}
