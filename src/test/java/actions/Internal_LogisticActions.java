package actions;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import base.driver.DriverManager;
import utilities.CommonFunctions;

public class Internal_LogisticActions {
	private static final By btnMenuLogistic = By.xpath(System.getProperty("Internal.Home.Menu.Logistic.Button"));
	private static final By btnMenu = By.xpath(System.getProperty("Internal.Home.Menu.Button"));
	private static final By btnHUB = By.xpath(System.getProperty("Internal.Home.Logistic.Menu.Hub.Button"));
	private static final By txtHubSearch = By
			.xpath(System.getProperty("Internal.Home.Logistic.Menu.Hub.SearchHub.Input"));
	private static String linkHubItem = System.getProperty("Internal.Home.Logistic.Menu.Hub.ItemHub.Link");
	private static final By listHub = By
			.xpath(System.getProperty("Internal.Home.Logistic.Menu.Hub.ManageHub.ListHub.Input"));
	private static final By btnHandover = By.xpath(System.getProperty("Internal.Home.Logistic.Menu.Handover.Button"));
	private static final By btnShipping = By
			.xpath(System.getProperty("Internal.Home.Logistic.Menu.Handover.Shipping.Button"));
	private static final By txtOptionHandover = By
			.xpath(System.getProperty("Internal.Home.Logistic.Handover.OptionHandOver.input"));
	private static final By txtItemOptionHandover = By
			.xpath(System.getProperty("Internal.Home.Logistic.Handover.OptionHandOver.Item.Text"));
	private static final By txtNameFromHub = By
			.xpath(System.getProperty("Internal.Home.Logistic.Handover.NameFromHub.Text"));
	private static final By txtNameToHub = By
			.xpath(System.getProperty("Internal.Home.Logistic.Handover.NameToHub.Text"));
	private static String nameHub = System.getProperty("Internal.Home.Logistic.Handover.NameHub.Item.Text");
	private static final By txtLicensePlate = By
			.xpath(System.getProperty("Internal.Home.Logistic.Handover.LicensePlate.Text"));
	private static final By txtItemLicensePlate = By
			.xpath(System.getProperty("Internal.Home.Logistic.Handover.LicensePlate.Item.Text"));
	private static final By btnStartDelivery = By
			.xpath(System.getProperty("Internal.Home.Logistic.Handover.StartDelivery.Button"));
	private static final By txtTransportTicket = By
			.xpath(System.getProperty("Internal.Home.Logistic.Handover.TransportTicket.Text"));
	private static final By txtScanTicket = By
			.xpath(System.getProperty("Internal.Home.Logistic.Handover.ScanTciket.Input"));
	private static final By btnCompleteRotation = By
			.xpath(System.getProperty("Internal.Home.Logistic.Handover.CompleteRotation.Button"));
	private static final By btnCheckboxSo = By
			.xpath(System.getProperty("Internal.Home.Logistic.ManageHub.Checkbox.Button"));
	private static final By btnReceipt = By
			.xpath(System.getProperty("Internal.Home.Logistic.ManageHub.Receipt.Button"));
	private static final By btnSetting = By
			.xpath(System.getProperty("Internal.Home.Logistic.ManageHub.Setting.Button"));
	private static final By txtScanOrder = By
			.xpath(System.getProperty("Internal.Home.Logistic.ManageHub.ScanOder.Input"));
	private static final By btnWaitingStock = By
			.xpath(System.getProperty("Internal.Home.Logistic.ManageHub.WatingForStock.Button"));
	private static final By btnConfirm = By
			.xpath(System.getProperty("Internal.Home.Logistic.ManageHub.FinishTicket.Confirm.Button"));
	private static final By btnFinishTicket = By
			.xpath(System.getProperty("Internal.Home.Logistic.ManageHub.FinishTicket.Button"));
	private static final By iconProcess = By.xpath(System.getProperty("Icon.Progress"));
	private static final By btnAssignDriver = By
			.xpath(System.getProperty("Internal.Home.Logistic.ManageHub.AssignDriver.Button"));
	private static final By txtDriver = By
			.xpath(System.getProperty("Internal.Home.Logistic.ManageHub.AssignDriver.Driver.Input"));
	private static String txtNameDriver = System
			.getProperty("Internal.Home.Logistic.Handover.AssignDriver.Driver.Item.Text");
	private static String txtTrackingCode = System
			.getProperty("Internal.Home.Logistic.Menu.Hub.ManageHub.TrackingCode.Text");
	private static final By btnControl = By.xpath(System.getProperty("Internal.Home.Logistic.Control.Button"));
	private static final By btnControlDriver = By
			.xpath(System.getProperty("Internal.Home.Logistic.Control.Driver.Button"));
	private static final By txtSearchNumberTicket = By
			.xpath(System.getProperty("Internal.Home.Logistic.Control.Driver.NumerTicket.Input"));
	private static final By btnDetailTicket = By
			.xpath(System.getProperty("Internal.Home.Logistic.Control.Driver.SessionCode.Input"));
	private static String txtCodMoney = System.getProperty("Internal.Home.Logistic.Control.Driver.MoneyCOD.Text");
	private static final By btnForControl = By
			.xpath(System.getProperty("Internal.Home.Logistic.Control.Driver.Control.Button"));
	private static final By txtNumberTicket = By
			.xpath(System.getProperty("Internal.Home.Logistic.Control.Accountain.NumberTicket.Text"));
	private static final By btnControlAccountain = By
			.xpath(System.getProperty("Internal.Home.Logistic.Control.Accountain.Button"));
	private static final By btnCheckbox = By
			.xpath(System.getProperty("Internal.Home.Logistic.Control.Accountain.Checkbox.RadioButton"));
	private static final By txtAccountainNumberTicket = By
			.xpath(System.getProperty("Internal.Home.Logistic.Control.Accountain.NumberTicket.TextArea"));
	private static final By txtMoney = By
			.xpath(System.getProperty("Internal.Home.Logistic.Control.Accountain.Money.Input"));
	private static final By btnPayment = By
			.xpath(System.getProperty("Internal.Home.Logistic.Control.Accountain.Payment.Button"));
	private static final By btnIconLoader = By.xpath(System.getProperty("Icon.Loader"));

	@FindBy(how = How.XPATH, using = "")
	private WebElement elem;
	private List<WebElement> lElems;

	int timeOut = Integer.parseInt(System.getProperty("objectTimeout"));
	public static WebDriver driver;

	public static WebDriver getDriver() {
		driver = DriverManager.getInstance().getDriver();
		return driver;
	}

	private static class SingletonHelper {
		private static final Internal_LogisticActions INSTANCE = new Internal_LogisticActions();
	}

	public static Internal_LogisticActions getInstance() {
		return SingletonHelper.INSTANCE;
	}

	public void clickMenuLogistic() {

		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnMenu, timeOut);

			elem = CommonFunctions.getInstance().findElementByVisibility(btnMenu);

			CommonFunctions.getInstance().clickByJavascript(elem);

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnMenuLogistic, timeOut);

			elem = CommonFunctions.getInstance().findElementByVisibility(btnMenuLogistic);

			CommonFunctions.getInstance().clickByJavascript(elem);

			CommonFunctions.getInstance().waitForPageLoad(timeOut);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void clickBtnLogisticMenu() {

		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnMenu, timeOut);

			elem = CommonFunctions.getInstance().findElementByVisibility(btnMenu);

			CommonFunctions.getInstance().clickByJavascript(elem);

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnMenuLogistic, timeOut);

			elem = CommonFunctions.getInstance().findElementByVisibility(btnMenuLogistic);

			CommonFunctions.getInstance().clickByJavascript(elem);

			CommonFunctions.getInstance().waitForPageLoad(timeOut);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void clickBtnHUB() {

		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnHUB, timeOut);

			elem = CommonFunctions.getInstance().findElementByVisibility(btnHUB);

			elem.click();

			CommonFunctions.getInstance().waitForPageLoad(timeOut);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void sendKeysHub() {

		try {

			String hubSearch = "";

			if (System.getProperty("regionName").equals("Miền Bắc")) {

				hubSearch = "HUB - Hà Nội";

			} else if (System.getProperty("regionName").equals("Miền Nam")) {

				hubSearch = "HUB Bình Dương";

			} else {

				hubSearch = "HUB Đà Nẵng";

			}

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(txtHubSearch, timeOut);

			elem = CommonFunctions.getInstance().findElementByVisibility(txtHubSearch);

			elem.sendKeys(hubSearch);

			elem.sendKeys(Keys.ENTER);

			Thread.sleep(3000);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void clickItemHub() {

		try {

			Thread.sleep(2000);

			String hubSearch = "";

			if (System.getProperty("regionName").equals("Miền Bắc")) {

				hubSearch = "HUB - Hà Nội";

			} else if (System.getProperty("regionName").equals("Miền Nam")) {

				hubSearch = "HUB Bình Dương";

			} else {

				hubSearch = "Hub Đà Nẵng";

			}

			String xpathItem = linkHubItem.replace("hubSearch", hubSearch);

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(By.xpath(xpathItem), timeOut);

			elem = CommonFunctions.getInstance().findElementByVisibility(By.xpath(xpathItem));

			elem.click();

			CommonFunctions.getInstance().switchTab(CommonFunctions.getInstance().getAllTabs().get(CommonFunctions.getInstance().getAllTabs().size() - 1));

			CommonFunctions.getInstance().waitForPageLoad(timeOut);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void clickItemMyHub() {

		try {

			WebDriver driver = getDriver();

			String hubSearch = System.getProperty("myHubSearch");

			String xpathItem = linkHubItem.replace("hubSearch", hubSearch);

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(By.xpath(xpathItem), timeOut);

			elem = CommonFunctions.getInstance().findElementByVisibility(By.xpath(xpathItem));

			CommonFunctions.getInstance().clickElement(By.xpath(xpathItem));

			CommonFunctions.getInstance().switchTab(CommonFunctions.getInstance().getAllTabs().get(CommonFunctions.getInstance().getAllTabs().size() - 1));

			CommonFunctions.getInstance().waitForPageLoad(timeOut);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void getNumberSOHub() {

		try {


			lElems = DriverManager.getInstance().getDriver().findElements(listHub);

			for (int i = 0; i < lElems.size(); i++) {

				if (lElems.get(i).getText().contains(System.getProperty("numberSO"))) {

					System.setProperty("numberSOHub", lElems.get(i).getText());
					System.setProperty("indexNumberSoHub", String.valueOf(i));

				}

			}

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void clickBtnHandOver() {

		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnHandover, timeOut);

			elem = CommonFunctions.getInstance().findElementByVisibility(btnHandover);

			elem.click();

			CommonFunctions.getInstance().waitForPageLoad(timeOut);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void clickBtnSubHandOver() {

		try {

			if (System.getProperty("numberSOHub").contains("SO") || System.getProperty("numberSOHub").contains("RO")
					|| System.getProperty("numberSOHub").contains("SOR")) {

				elem = CommonFunctions.getInstance().findElementByVisibility(btnShipping);

				elem.click();

			}

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void selectOptionHandover() {

		try {

			elem = CommonFunctions.getInstance().findElementByVisibility(txtOptionHandover);

			elem.click();

			elem = CommonFunctions.getInstance().findElementByVisibility(txtItemOptionHandover);

			elem.click();

			Thread.sleep(1000);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void selectLicensePlate() {

		try {

			WebDriver driver = getDriver();

			Thread.sleep(1000);

			elem = CommonFunctions.getInstance().findElementByVisibility(txtLicensePlate);

			elem.click();

			lElems = driver.findElements(txtItemLicensePlate);

			int index = new Random().nextInt(lElems.size());

			lElems.get(index).click();

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void selectNameFromHub() {

		try {

			elem = CommonFunctions.getInstance().findElementByVisibility(txtNameFromHub);

			elem.click();

			String hubSearch = "";

			if (System.getProperty("regionName").equals("Miền Bắc")) {

				hubSearch = "HUB - Hà Nội";

			} else if (System.getProperty("regionName").equals("Miền Nam")) {

				hubSearch = "HUB Bình Dương";

			} else {

				hubSearch = "Hub Đà Nẵng";

			}

			elem.sendKeys(hubSearch);

			String xpathItem = nameHub.replace("option", hubSearch);

			elem = CommonFunctions.getInstance().findElementByVisibility(By.xpath(xpathItem));

			elem.click();

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void selectNameToHub() {

		try {

			elem = CommonFunctions.getInstance().findElementByVisibility(txtNameToHub);

			elem.click();

			String hubSearch = System.getProperty("myHubSearch");

			elem.sendKeys(hubSearch);

			String xpathItem = nameHub.replace("option", hubSearch);

			elem = CommonFunctions.getInstance().findElementByVisibility(By.xpath(xpathItem));

			elem.click();

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void clickBtnStartDelivery() {

		try {

			elem = CommonFunctions.getInstance().findElementByVisibility(btnStartDelivery);

			elem.click();

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void getTicketTransport() {

		try {

			elem = CommonFunctions.getInstance().findElementByVisibility(txtTransportTicket);

			String ticketTransport = elem.getText();

			System.setProperty("ticketTransport", ticketTransport);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void scanTicket() {

		try {

			elem = CommonFunctions.getInstance().findElementByVisibility(txtScanTicket);

			elem.sendKeys(System.getProperty("numberSOHub"));

			elem.sendKeys(Keys.ENTER);

			Thread.sleep(2000);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void clickBtnCompleteRotation() {

		try {

			elem = CommonFunctions.getInstance().findElementByVisibility(btnCompleteRotation);

			elem.click();

			DriverManager.getInstance().getDriver().close();

			CommonFunctions.getInstance().switchTab(CommonFunctions.getInstance().getAllTabs().get(CommonFunctions.getInstance().getAllTabs().size() - 1));

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void sendKeysMyHub() {

		try {

			String hubSearch = System.getProperty("myHubSearch");

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(txtHubSearch, timeOut);

			CommonFunctions.getInstance().actionClearAndSendkeys(txtHubSearch, hubSearch);

			CommonFunctions.getInstance().waitForElementToDisappear(btnIconLoader, timeOut);

			CommonFunctions.getInstance().waitForElementToDisappear(iconProcess, timeOut);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void clickCheckbox() {

		try {

			lElems = driver.findElements(btnCheckboxSo);

			lElems.get(Integer.parseInt(System.getProperty("indexNumberSoHub"))).click();

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void clickBtnWaitingSTock() {

		try {

			elem = CommonFunctions.getInstance().findElementByVisibility(btnWaitingStock);

			elem.click();

			CommonFunctions.getInstance().waitForElementToDisappear(iconProcess, timeOut);

			Thread.sleep(5000);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void clickBtnReceipt() {

		try {
			
			CommonFunctions.getInstance().clickElement(btnSetting);

			elem = CommonFunctions.getInstance().findElementByVisibility(btnReceipt);

			elem.click();

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void sendKeysScanOrder() {

		try {

			elem = CommonFunctions.getInstance().findElementByVisibility(txtScanOrder);

			elem.sendKeys(System.getProperty("ticketTransport"));

			elem.sendKeys(Keys.ENTER);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void clickBtnFinishTicket() {

		try {

			Thread.sleep(5000);

			CommonFunctions.getInstance().waitForVisibilityOfElement(btnFinishTicket, timeOut);

			CommonFunctions.getInstance().clickElement(btnFinishTicket);
			
			if(!CommonFunctions.getInstance().checkElementsByVisibilityWithTimeInput(btnConfirm,5)) {
				
				CommonFunctions.getInstance().clickElement(btnFinishTicket);
				
			}

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void clickBtnConfirm() {

		try {
			
			elem = CommonFunctions.getInstance().findElementByVisibility(btnConfirm);

			elem.click();

			Thread.sleep(5000);

			DriverManager.getInstance().getDriver().close();

			CommonFunctions.getInstance().switchTab(CommonFunctions.getInstance().getAllTabs()
					.get(CommonFunctions.getInstance().getAllTabs().size() - 1));

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void clickBtnAssignDriver() {

		try {

			Thread.sleep(5000);
			
			// Get Tracking Code
			String xpath = txtTrackingCode.replace("option",
					String.valueOf(Integer.parseInt(System.getProperty("indexNumberSoHub") + 1)));

			elem = CommonFunctions.getInstance().findElementByVisibility(By.xpath(xpath));

			String trackingCode = elem.getText();

			System.setProperty("trackingCode", trackingCode);
			
			CommonFunctions.getInstance().clickElement(btnSetting);

			elem = CommonFunctions.getInstance().findElementByVisibility(btnAssignDriver);

			elem.click();

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void selectDriver() {

		try {

			elem = CommonFunctions.getInstance().findElementByVisibility(txtDriver);

			elem.click();

			String xpathDriver = txtNameDriver.replace("nameDriver", System.getProperty("dNameDriver"));

			elem = CommonFunctions.getInstance().findElementByVisibility(By.xpath(xpathDriver));

			elem.click();

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void clickBtnControl() {

		try {

			elem = CommonFunctions.getInstance().findElementByVisibility(btnControl);

			elem.click();

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void clickBtnControlDriver() {

		try {

			elem = CommonFunctions.getInstance().findElementByVisibility(btnControlDriver);

			elem.click();

			CommonFunctions.getInstance().waitForElementToDisappear(iconProcess, timeOut);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void clickBtnControlAccountain() {

		try {
			
			Thread.sleep(2000);

			elem = CommonFunctions.getInstance().findElementByVisibility(btnControlAccountain);

			elem.click();

			CommonFunctions.getInstance().waitForElementToDisappear(iconProcess, timeOut);
			
			Thread.sleep(3000);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void sendKeysNumberTicket() {

		try {

			elem = CommonFunctions.getInstance().findElementByVisibility(txtSearchNumberTicket);

			elem.sendKeys(System.getProperty("numberSOHub"));

			elem.sendKeys(Keys.ENTER);

			CommonFunctions.getInstance().waitForElementToDisappear(iconProcess, timeOut);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void clicBtnDetailTicket() {

		try {

			Thread.sleep(5000);

			elem = CommonFunctions.getInstance().findElementByVisibility(btnDetailTicket);

			CommonFunctions.getInstance().clickByJavascript(elem);

			CommonFunctions.getInstance().waitForElementToDisappear(iconProcess, timeOut);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void verifyCodMoney() {

		try {

			String expectCod = System.getProperty("totalMoney");

			// parse money
			long number = Long.parseLong(expectCod);

			NumberFormat moneyFormat = NumberFormat.getNumberInstance(Locale.US);
			String formattedMoney = moneyFormat.format(number);

			String xpathMoney = txtCodMoney.replace("option", formattedMoney);

			elem = CommonFunctions.getInstance().findElementByVisibility(By.xpath(xpathMoney));

			String actualCod = elem.getText();

			CommonFunctions.getInstance().verifyDataContains(actualCod, formattedMoney);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void clickBtnForControl() {

		try {

			elem = CommonFunctions.getInstance().findElementByVisibility(btnForControl);

			elem.click();

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void clickBtnAccountingTicket() {

		try {

			Thread.sleep(3000);

			elem = CommonFunctions.getInstance().findElementByVisibility(txtNumberTicket);

			elem.click();

			CommonFunctions.getInstance().waitForElementToDisappear(iconProcess, timeOut);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void sendKeysNumberTicketAccountain() {

		try {

			elem = CommonFunctions.getInstance().findElementByVisibility(txtAccountainNumberTicket);

			elem.sendKeys(System.getProperty("numberSOHub"));

			elem.sendKeys(Keys.ENTER);

			CommonFunctions.getInstance().waitForElementToDisappear(iconProcess, timeOut);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void clickItemNumberTicket() {

		try {
			
			Thread.sleep(2000);

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnCheckbox, timeOut);

			CommonFunctions.getInstance().scrollToObject(btnCheckbox, 0);

			CommonFunctions.getInstance().scrollToObject(btnCheckbox, 0);
			
			Thread.sleep(2000);
			
			CommonFunctions.getInstance().actionClickElement(btnCheckbox);

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

	public void clickBtnPayment() {

		try {

			elem = CommonFunctions.getInstance().findElementByVisibility(btnPayment);

			CommonFunctions.getInstance().scrollToObject(btnPayment, 0);

			elem.click();

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

}
