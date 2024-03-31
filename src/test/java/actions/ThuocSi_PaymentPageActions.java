package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import base.driver.DriverManager;
import utilities.CommonFunctions;

public class ThuocSi_PaymentPageActions {
	private static String rdoPaymentTransfer = System.getProperty("Home.Payment.PaymentType.Radio");
	private static final By btnPayment = By.xpath(System.getProperty("Home.Payment.Payment.Button"));
	private static final By msgSuccess = By.xpath(System.getProperty("Home.Payment.Sucess.Message"));
	private static final By btnViewDetail = By.xpath(System.getProperty("Home.Payment.Detail.View.Button"));
	private static final By btnEditOrder = By.xpath(System.getProperty("Home.Payment.Edit.View.Button"));
	private static final By btnEditConfirmOrder = By.xpath(System.getProperty("Home.Payment.Edit.View.Confirm.Button"));
	private static final By btnAddVAT = By.xpath(System.getProperty("Home.Payment.AddVAT.Button"));
	private static final By txtCompanyName = By.xpath(System.getProperty("Home.Payment.CompanyName.Input"));
	private static final By txtTaxCode = By.xpath(System.getProperty("Home.Payment.TaxCode.Input"));
	private static final By txtAddress = By.xpath(System.getProperty("Home.Payment.Address.Input"));
	private static final By iconProcess = By.xpath(System.getProperty("Icon.Progress"));
	@FindBy(how = How.XPATH, using = "")
	private WebElement elem;

	int timeOut = Integer.parseInt(System.getProperty("objectTimeout"));

	private static class SingletonHelper {
		private static final ThuocSi_PaymentPageActions INSTANCE = new ThuocSi_PaymentPageActions();
	}

	public static ThuocSi_PaymentPageActions getInstance() {
		return SingletonHelper.INSTANCE;
	}

	public void clickBtnPayment() {

		try {

			for (int i = 0; i < 10; i++) {

				if (CommonFunctions.getInstance().checkElementsByVisibilityWithTimeInput(btnPayment, 5)) {

					CommonFunctions.getInstance().clickJavascript(btnPayment);

					CommonFunctions.getInstance().waitForElementToDisappear(iconProcess, timeOut);
					
					break;

				}

			}
			
			Thread.sleep(2000);

			CommonFunctions.getInstance().waitForPageLoad(timeOut);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void verifyPaymentSuccess() {

		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(msgSuccess, timeOut);

			elem = CommonFunctions.getInstance().findElementByVisibility(msgSuccess);

			String msg = elem.getText();

			CommonFunctions.getInstance().verifyDataEquals(msg, System.getProperty("paymentSuccessful"));

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void clickDetailBill() {

		try {

			CommonFunctions.getInstance().clickJavascript(btnViewDetail);

			CommonFunctions.getInstance().waitForPageLoad(timeOut);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void clickEditOrder() {

		try {

			CommonFunctions.getInstance().clickElement(btnEditOrder);

			CommonFunctions.getInstance().clickElement(btnEditConfirmOrder);

			CommonFunctions.getInstance().waitForPageLoad(timeOut);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void clickAddVAT() {

		try {

			try {

				CommonFunctions.getInstance().scrollDown();

				elem = DriverManager.getInstance().getDriver().findElement(btnAddVAT);

				CommonFunctions.getInstance().clickByJavascript(elem);

			} catch (Exception e) {
				CommonFunctions.getInstance().scrollDown();

				elem = DriverManager.getInstance().getDriver().findElement(btnAddVAT);

				CommonFunctions.getInstance().clickByJavascript(elem);
			}

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void sendKeysCompanyName() {

		try {

			elem = CommonFunctions.getInstance().findElementByVisibility(txtCompanyName);

			elem.sendKeys(System.getProperty("dCompanyNameVAT"));

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void sendKeysTaxCode() {

		try {

			elem = CommonFunctions.getInstance().findElementByVisibility(txtTaxCode);

			elem.sendKeys(System.getProperty("dTaxCodeVAT"));
			
			CommonFunctions.getInstance().clickElement(txtAddress);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void sendKeysAddress() {

		try {

			CommonFunctions.getInstance().sendkeys(txtAddress, System.getProperty("dAddressVAT"));

			CommonFunctions.getInstance().pressKeys(txtAddress, Keys.ENTER);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void selectPaymentType(String type) {

		try {

			if (type.equals("Bank")) {

				String xpathBankType = rdoPaymentTransfer.replace("option", "PAYMENT_METHOD_BANK");

				CommonFunctions.getInstance().clickElement(By.xpath(xpathBankType));

				Thread.sleep(3000);

			} else {

				String xpathCODType = rdoPaymentTransfer.replace("option", "PAYMENT_METHOD_NORMAL");

				CommonFunctions.getInstance().clickElement(By.xpath(xpathCODType));

				Thread.sleep(3000);

			}

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

}
