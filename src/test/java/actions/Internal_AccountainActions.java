package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import base.driver.DriverManager;
import utilities.CommonFunctions;

public class Internal_AccountainActions {

	private static final By btnMenu = By.xpath(System.getProperty("Internal.Home.Menu.Button"));
	private static final By btnMenuAccountain = By.xpath(System.getProperty("Internal.Home.Menu.Accountain.Button"));
	private static final By btnMenuShippingPartner = By
			.xpath(System.getProperty("Internal.Home.Accountain.ShippingPartner.Button"));
	private static final By btnSubMenuListControlHub = By
			.xpath(System.getProperty("Internal.Home.Accountain.ShippingPartner.ListControlHub.Button"));
	private static final By btnMenuCustomer = By.xpath(System.getProperty("Internal.Home.Accountain.Customer.Button"));
	private static final By btnSubMenuInvoice = By
			.xpath(System.getProperty("Internal.Home.Accountain.Customer.Invoice.Button"));
	private static final By btnSubMenuPayment = By
			.xpath(System.getProperty("Internal.Home.Accountain.Customer.Payment.Button"));
	private static final By txtTicketId = By
			.xpath(System.getProperty("Internal.Home.Accountain.ShippingPartner.ListControlHub.TicketId.Input"));
	private static final By iconProcess = By.xpath(System.getProperty("Icon.Progress"));
	private static final By txtDetailControlSession = By
			.xpath(System.getProperty("Internal.Home.Accountain.ShippingPartner.ListControlHub.ControlSession.Text"));
	private static final By txtMoney = By
			.xpath(System.getProperty("Internal.Home.Accountain.ShippingPartner.ListControlHub.Detail.PayMoney.Input"));
	private static final By btnStartControl = By.xpath(
			System.getProperty("Internal.Home.Accountain.ShippingPartner.ListControlHub.Detail.StartControl.Button"));
	private static final By txtSO = By.xpath(System.getProperty("Internal.Home.Accountain.Customer.Invoice.SO.Input"));
	private static final By txtStatus = By
			.xpath(System.getProperty("Internal.Home.Accountain.Customer.Invoice.Status.Text"));
	private static final By txtTitle = By
			.xpath(System.getProperty("Internal.Home.Accountain.Customer.Invoice.Title.Text"));

	@FindBy(how = How.XPATH, using = "")
	private WebElement elem;

	int timeOut = Integer.parseInt(System.getProperty("objectTimeout"));

	public static WebDriver driver;

	public static WebDriver getDriver() {
		driver = DriverManager.getInstance().getDriver();
		return driver;
	}

	private static class SingletonHelper {
		private static final Internal_AccountainActions INSTANCE = new Internal_AccountainActions();
	}

	public static Internal_AccountainActions getInstance() {
		return SingletonHelper.INSTANCE;
	}

	public void clickMenuAccountain() {

		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnMenu, timeOut);

			elem = CommonFunctions.getInstance().findElementByVisibility(btnMenu);

			CommonFunctions.getInstance().clickByJavascript(elem);

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnMenuAccountain, timeOut);

			elem = CommonFunctions.getInstance().findElementByVisibility(btnMenuAccountain);

			CommonFunctions.getInstance().clickByJavascript(elem);

			CommonFunctions.getInstance().waitForPageLoad(timeOut);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void clickBtnShippingPartner() {

		try {

			elem = CommonFunctions.getInstance().findElementByVisibility(btnMenuShippingPartner);

			elem.click();

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void clickBtnListControlHub() {

		try {

			elem = CommonFunctions.getInstance().findElementByVisibility(btnSubMenuListControlHub);

			elem.click();

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void clickBtnCustomer() {

		try {

			elem = CommonFunctions.getInstance().findElementByVisibility(btnMenuCustomer);

			elem.click();

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void clickBtnInvoice() {

		try {

			elem = CommonFunctions.getInstance().findElementByVisibility(btnSubMenuInvoice);

			elem.click();

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(txtTitle, timeOut);

			Thread.sleep(3000);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void clickBtnPayment() {

		try {

			elem = CommonFunctions.getInstance().findElementByVisibility(btnSubMenuPayment);

			elem.click();

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void sendKeysTicketId() {

		try {

			elem = CommonFunctions.getInstance().findElementByVisibility(txtTicketId);

			elem.click();

			elem.sendKeys(System.getProperty("numberSOHub"));

			elem.sendKeys(Keys.ENTER);

			CommonFunctions.getInstance().waitForElementToDisappear(iconProcess, timeOut);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void clickBtnDetailControlSession() {

		try {

			Thread.sleep(5000);

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(txtDetailControlSession, timeOut);

			elem = CommonFunctions.getInstance().findElementByVisibility(txtDetailControlSession);

			CommonFunctions.getInstance().clickByJavascript(elem);

			CommonFunctions.getInstance().waitForElementToDisappear(iconProcess, timeOut);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void sendKeysMoney() {

		try {

			elem = CommonFunctions.getInstance().findElementByVisibility(txtMoney);

			elem.sendKeys(System.getProperty("totalMoney"));

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void clickBtnStartControl() {

		try {

			elem = CommonFunctions.getInstance().findElementByVisibility(btnStartControl);

			elem.click();

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void sendKeysSO() {

		try {

			elem = CommonFunctions.getInstance().findElementByVisibility(txtSO);

			elem.sendKeys(System.getProperty("numberSO"));

			elem.sendKeys(Keys.ENTER);

			CommonFunctions.getInstance().waitForElementToDisappear(iconProcess, timeOut);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void verifyStatus(String expectStatus) {

		try {

			CommonFunctions.getInstance().refresh();

			CommonFunctions.getInstance().waitForPageLoad(timeOut);

			elem = CommonFunctions.getInstance().findElementByVisibility(txtStatus);

			String actualStatus = elem.getText();

			CommonFunctions.getInstance().verifyDataEquals(actualStatus, expectStatus);

			DriverManager.getInstance().getDriver().close();

			CommonFunctions.getInstance().switchTab(CommonFunctions.getInstance().getAllTabs()
					.get(CommonFunctions.getInstance().getAllTabs().size() - 1));

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

}
