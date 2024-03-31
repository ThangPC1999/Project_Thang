package actions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import base.driver.DriverManager;
import utilities.CommonFunctions;

public class Internal_SellerActions {
	private static final By btnMenu = By.xpath(System.getProperty("Internal.Home.Menu.Button"));
	private static final By btnMenuSeller = By.xpath(System.getProperty("Internal.Home.Menu.Seller.Button"));
	private static final By txtProductId = By
			.xpath(System.getProperty("Internal.Home.Menu.Seller.ProductSearch.Input"));
	private static final By iconLoader = By.xpath(System.getProperty("Icon.Loader"));
	private static final By iconProgress = By.xpath(System.getProperty("Icon.Progress"));
	private static final By btnSubMenuProduct = By
			.xpath(System.getProperty("Internal.Home.Menu.Seller.Product.Button"));
	private static final By btnSubMenuRequestApprove = By
			.xpath(System.getProperty("Internal.Home.Menu.Seller.Product.RequestApprove.Button"));
	private static final By btnPendingApprove = By
			.xpath(System.getProperty("Internal.Home.Seller.Product.PendingApprove.Button"));
	private static final By txtProductNameSearch = By
			.xpath(System.getProperty("Internal.Home.Seller.Product.ProductName.Input"));
	private static final By btnApply = By.xpath(System.getProperty("Internal.Home.Seller.Product.Apply.Button"));
	private static final By btnCheckbox = By.xpath(System.getProperty("Internal.Home.Seller.Product.Checkbox.Button"));
	private static final By btnViewDetail = By
			.xpath(System.getProperty("Internal.Home.Seller.Product.ViewDetail.Button"));
	private static final By btnAccept = By
			.xpath(System.getProperty("Internal.Home.Seller.Product.ViewDetail.Accept.Button"));
	private static final By msgSuccess = By
			.xpath(System.getProperty("Internal.Home.Seller.Product.ViewDetail.Message.Text"));
	
	@FindBy(how = How.XPATH, using = "")
	private WebElement elem;

	int timeOut = Integer.parseInt(System.getProperty("objectTimeout"));
	public static WebDriver driver;

	public static WebDriver getDriver() {
		driver = DriverManager.getInstance().getDriver();
		return driver;
	}

	private static class SingletonHelper {
		private static final Internal_SellerActions INSTANCE = new Internal_SellerActions();
	}

	public static Internal_SellerActions getInstance() {
		return SingletonHelper.INSTANCE;
	}

	public void clickMenuSeller() {

		try {

			CommonFunctions.getInstance().waitForElementToDisappear(iconLoader, timeOut);

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnMenu, timeOut);

			CommonFunctions.getInstance().clickElement(btnMenu);

			Thread.sleep(2000);

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnMenuSeller, timeOut);

			CommonFunctions.getInstance().clickElement(btnMenuSeller);

			CommonFunctions.getInstance().waitForElementToDisappear(iconLoader, timeOut);

			CommonFunctions.getInstance().waitForElementToDisappear(iconProgress, timeOut);

			Thread.sleep(3000);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void clickSubMenuRequestApprove() {

		try {

			CommonFunctions.getInstance().waitForElementToDisappear(iconLoader, timeOut);

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnSubMenuProduct, timeOut);

			CommonFunctions.getInstance().clickElement(btnSubMenuProduct);

			Thread.sleep(2000);

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnSubMenuRequestApprove, timeOut);

			CommonFunctions.getInstance().clickElement(btnSubMenuRequestApprove);

			CommonFunctions.getInstance().waitForElementToDisappear(iconLoader, timeOut);

			CommonFunctions.getInstance().waitForElementToDisappear(iconProgress, timeOut);

			Thread.sleep(3000);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void clickBtnPendingApprove() {

		try {

			CommonFunctions.getInstance().clickElement(btnPendingApprove);

			Thread.sleep(5000);
			
			CommonFunctions.getInstance().waitForElementToDisappear(iconLoader, timeOut);

			CommonFunctions.getInstance().waitForElementToDisappear(iconProgress, timeOut);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}
	
	public void clickBtnApply() {

		try {

			CommonFunctions.getInstance().clickElement(btnApply);

			Thread.sleep(5000);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}
	
	public void clickBtnCheckBoxItem() {

		try {

			CommonFunctions.getInstance().clickElement(btnCheckbox);

			Thread.sleep(1000);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}
	
	public void clickBtnViewDetail() {

		try {

			CommonFunctions.getInstance().clickElement(btnViewDetail);

			Thread.sleep(1000);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}
	
	public void clickBtnAccept() {

		try {

			CommonFunctions.getInstance().clickElement(btnAccept);

			Thread.sleep(3000);
			
			

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}
	
	public void verifyMessage() {

		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(msgSuccess, timeOut);
			
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void sendKeysProduct(String productId) {

		try {

			CommonFunctions.getInstance().sendkeys(txtProductId, productId);

			CommonFunctions.getInstance().pressKeys(txtProductId, Keys.ENTER);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void sendKeysProductName() {

		try {

			CommonFunctions.getInstance().sendkeys(txtProductNameSearch, System.getProperty("dProductName"));

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}
	
	public void sendKeysComboName() {

		try {

			CommonFunctions.getInstance().sendkeys(txtProductNameSearch, System.getProperty("dComboName"));

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

}
