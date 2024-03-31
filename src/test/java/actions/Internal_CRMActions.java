package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import base.driver.DriverManager;

import org.openqa.selenium.interactions.Actions;
import utilities.CommonFunctions;

public class Internal_CRMActions {

	private static final By btnOrder = By.xpath(System.getProperty("Internal.Home.Menu.CRM.Order.Button"));
	private static final By btnSubItemOrder = By
			.xpath(System.getProperty("Internal.Home.Menu.CRM.Order.OderSubItem.Button"));
	private static final By txtOrderId = By.xpath(System.getProperty("Internal.Home.CRM.OderId.Input"));
	private static final By txtTitleCRM = By.xpath(System.getProperty("Internal.Home.Menu.CRM.Title"));
	private static final By txtTitleOrder = By.xpath(System.getProperty("Internal.Home.Menu.CRM.Order.Title"));
	private static final By btnApply = By.xpath(System.getProperty("Internal.Home.CRM.Apply.Button"));
	private static final By btnStatus = By.xpath(System.getProperty("Internal.Home.CRM.Status.Button"));
	private static final By btnUpdateStatus = By.xpath(System.getProperty("Internal.Home.CRM.Update.Status.Button"));
	private static final By btnConfirmStatus = By.xpath(System.getProperty("Internal.Home.CRM.Status.Confirm.Button"));
	private static final By btnAccept = By.xpath(System.getProperty("Internal.Home.CRM.Accept.Button"));
	private static final By btnNumberSO = By.xpath(System.getProperty("Internal.Home.CRM.NumberSO.Button"));
	private static final By btnLoader = By.xpath(System.getProperty("Icon.Loader"));
	private static final By txtTotalMoney = By.xpath(System.getProperty("Internal.Home.CRM.TotalMoney.Text"));
	@FindBy(how = How.XPATH, using = "")
	private WebElement elem;

	int timeOut = Integer.parseInt(System.getProperty("objectTimeout"));
	public static WebDriver driver;

	public static WebDriver getDriver() {
		driver = DriverManager.getInstance().getDriver();
		return driver;
	}

	private static class SingletonHelper {
		private static final Internal_CRMActions INSTANCE = new Internal_CRMActions();
	}

	public static Internal_CRMActions getInstance() {
		return SingletonHelper.INSTANCE;
	}

	public void clickBtnOrder() {

		try {

			elem = CommonFunctions.getInstance().findElementByVisibility(btnOrder);

			elem.click();

			elem = CommonFunctions.getInstance().findElementByVisibility(btnSubItemOrder);

			elem.click();

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(txtTitleOrder, timeOut);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void sendsKeyOrderId() {

		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(txtOrderId, timeOut);

			elem = CommonFunctions.getInstance().findElementByVisibility(txtOrderId);

			elem.sendKeys(System.getProperty("oderNumber"));

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void clickBtnApply() {

		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnApply, timeOut);

			CommonFunctions.getInstance().hoverElement(btnOrder);

			elem = CommonFunctions.getInstance().findElementByVisibility(btnApply);

			elem.click();

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void clickBtnChangeStatus() {

		try {

			// Wait for the btnLoader element to disappear using CommonFunctions
			CommonFunctions.getInstance().waitForElementToDisappear(btnLoader, timeOut);

			// Wait for the page to load using CommonFunctions
			// Wait for the visibility of all elements with btnStatus locator using
			// CommonFunctions
			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnStatus, timeOut);

			// Hover over the btnStatus element using CommonFunctions
			CommonFunctions.getInstance().hoverElement(btnStatus);

			// Find the element by visibility using CommonFunctions and store it in elem
			elem = CommonFunctions.getInstance().findElementByVisibility(btnStatus);

			// Click the element
			elem.click();

			// Find the element by visibility using CommonFunctions and store it in elem
			elem = CommonFunctions.getInstance().findElementByVisibility(btnUpdateStatus);

			// Click the element
			elem.click();

			// Find the element by visibility using CommonFunctions and store it in elem
			elem = CommonFunctions.getInstance().findElementByVisibility(btnConfirmStatus);

			// Click the element
			elem.click();

			// Find the element by visibility using CommonFunctions and store it in elem
			elem = CommonFunctions.getInstance().findElementByVisibility(btnAccept);

			// Click the element
			elem.click();

			Thread.sleep(2000);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void verifyStatusChange() {

		try {

			Thread.sleep(5000);

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnStatus, timeOut);

			elem = CommonFunctions.getInstance().findElementByVisibility(btnStatus);

			String status = elem.getText();

			CommonFunctions.getInstance().verifyDataEquals(status, System.getProperty("acceptStatus"));

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void verifyTotalMoney() {

		try {

			Thread.sleep(3000);

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(txtTotalMoney, timeOut);

			elem = CommonFunctions.getInstance().findElementByVisibility(txtTotalMoney);

			String totalMoney = elem.getText();

			int afterTotalUseDiscount = Integer.parseInt(System.getProperty("totalPriceExpect"))
					- Integer.parseInt(System.getProperty("absoluteDiscount"));

			if (System.getProperty("autoCharge") != null) {

				afterTotalUseDiscount = afterTotalUseDiscount - Integer.parseInt(System.getProperty("autoCharge"));

			}

			String totalMoneyExpect = CommonFunctions.getInstance()
					.parseStringIntoCurrent(String.valueOf(afterTotalUseDiscount));

			totalMoneyExpect = totalMoneyExpect.replace(".", ",").replace("đ", "");

			CommonFunctions.getInstance().verifyDataContains(totalMoney, totalMoneyExpect);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void verifyTotalMoneyDiscountPercent() {

		try {

			// Sleep for 3 seconds (3000 milliseconds) - Note: Thread.sleep is generally
			// discouraged for waiting in test automation
			Thread.sleep(3000);

			// Wait for the visibility of the txtTotalMoney element
			CommonFunctions.getInstance().waitForVisibilityOfAllElement(txtTotalMoney, timeOut);

			// Find the element with visibility matching txtTotalMoney
			WebElement elem = CommonFunctions.getInstance().findElementByVisibility(txtTotalMoney);

			// Get the text content of the element, which represents the total money
			String totalMoney = elem.getText();

			// Read the percentDiscount and totalPriceExpect from System properties and
			// parse them into double variables
			double percentDiscount = Double.parseDouble(System.getProperty("percentDiscount"));
			double totalPriceExpect = Double.parseDouble(System.getProperty("totalPriceExpect"));

			// Calculate the total discount amount based on percentDiscount and
			// totalPriceExpect
			double totalPercent = (percentDiscount / 100) * totalPriceExpect;

			// Calculate the total price after applying the discount
			double afterTotalUseDiscount = totalPriceExpect - totalPercent;

			if (System.getProperty("autoCharge") != null) {

				afterTotalUseDiscount = afterTotalUseDiscount - Double.parseDouble(System.getProperty("autoCharge"));

			}

			// Round the result to the nearest hundred using the roundToNearestPercent
			// method from CommonFunctions
			double roundedResult = CommonFunctions.getInstance().roundToNearestPercent(afterTotalUseDiscount);

			// Wait Cart Update
			System.out.println("Price: " + System.getProperty("totalPriceExpect"));

			// Convert the roundedResult into a formatted string with the appropriate
			// currency representation
			String totalMoneyExpect = CommonFunctions.getInstance()
					.parseStringIntoCurrent(String.valueOf(roundedResult));

			// Replace dots with commas and remove currency symbol 'đ' from the
			// totalMoneyExpect string
			totalMoneyExpect = totalMoneyExpect.replace(".", ",").replace("đ", "");

			// Verify that the totalMoney contains the formatted totalMoneyExpect as a
			// substring
			CommonFunctions.getInstance().verifyDataContains(totalMoney, totalMoneyExpect);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void clikBtnNumberSO() {

		try {

			WebDriver driver = getDriver();

			CommonFunctions.getInstance().refresh();

			for (int i = 0; i < 10; i++) {

				if (CommonFunctions.getInstance().checkElementsByVisibilityWithTimeInput(txtTotalMoney, 10)) {

					break;

				} else {

					CommonFunctions.getInstance().refresh();

				}

			}

			// Get Total Money
			String totalMoney = CommonFunctions.getInstance().getText(txtTotalMoney);

			totalMoney = totalMoney.replaceAll("[^0-9]", "").replaceAll(",", "");
			System.setProperty("totalMoney", totalMoney);
			//
			elem = CommonFunctions.getInstance().findElementByVisibility(btnNumberSO);

			String numberSO = elem.getText();

			System.setProperty("numberSO", numberSO);

			Thread.sleep(3000);

			// Create Actions object
			Actions actions = new Actions(driver);

			// Open the link in a new tab
			actions.keyDown(Keys.CONTROL).click(elem).keyUp(Keys.CONTROL).perform();

			// Switch to the new tab
			CommonFunctions.getInstance().switchTab(CommonFunctions.getInstance().getAllTabs()
					.get(CommonFunctions.getInstance().getAllTabs().size() - 1));

			CommonFunctions.getInstance().waitForPageLoad(timeOut);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

}
