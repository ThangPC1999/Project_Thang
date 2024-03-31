package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import base.driver.DriverManager;
import utilities.CommonFunctions;

public class ThuocSi_CartPageActions {

	private static final By btnContinousPayment = By.xpath(System.getProperty("Home.Cart.Payment.Continous.Button"));
	private static final By btnIgnore = By.xpath(System.getProperty("Home.Cart.Payment.Ignore.Button"));
	private static final By btnAddPromotion = By.xpath(System.getProperty("Home.Cart.Payment.AddPromotion.Button"));
	private static final By txtPromotionCode = By.xpath(System.getProperty("Home.Cart.Payment.CodePromotion.Input"));
	private static final By btnUseNow = By.xpath(System.getProperty("Home.Cart.Payment.UseNow.Button"));
	private static String txtAmmountCart = System.getProperty("Home.QuickOder.Cart.Ammount.Input");
	private static String txtTotalMoneyCart = System.getProperty("Home.QuickOder.Cart.TotalMoney.Input");
	private static final By iconProcess = By.xpath(System.getProperty("Icon.Progress"));
	private static final By txtAutoCharge = By.xpath(System.getProperty("Home.QuickOder.Cart.AutoCharge.Input"));

	@FindBy(how = How.XPATH, using = "")
	private WebElement elem;

	int timeOut = Integer.parseInt(System.getProperty("objectTimeout"));
	public static WebDriver driver;

	public static WebDriver getDriver() {
		driver = DriverManager.getInstance().getDriver();
		return driver;
	}

	private static class SingletonHelper {
		private static final ThuocSi_CartPageActions INSTANCE = new ThuocSi_CartPageActions();
	}

	public static ThuocSi_CartPageActions getInstance() {
		return SingletonHelper.INSTANCE;
	}

	public void clickBtnContinousPayment() {

		try {

			if (CommonFunctions.getInstance().checkElementsByVisibilityWithTimeInput(btnIgnore, 5)) {

				CommonFunctions.getInstance().clickJavascript(btnIgnore);

				CommonFunctions.getInstance().refresh();

				CommonFunctions.getInstance().waitForPageLoad(timeOut);

			}

			elem = CommonFunctions.getInstance().findElementByVisibility(btnContinousPayment);

			elem.click();

			CommonFunctions.getInstance().waitForElementToDisappear(iconProcess, timeOut);

			Thread.sleep(3000);

			// Execute JavaScript to modify the element's style
			JavascriptExecutor jsExecutor = (JavascriptExecutor) DriverManager.getInstance().getDriver();
			jsExecutor.executeScript("document.body.style.overflow = 'visible';");

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void clickBtnAddPromotion() {

		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnAddPromotion, timeOut);

			CommonFunctions.getInstance().clickElement(btnAddPromotion);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void sendKeysPromotionCode() {

		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(txtPromotionCode, timeOut);

			Thread.sleep(2000);

			CommonFunctions.getInstance().actionClearAndSendkeys(txtPromotionCode, System.getProperty("codeDiscount"));

			CommonFunctions.getInstance().actionClearAndSendkeys(txtPromotionCode, System.getProperty("codeDiscount"));

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void clickBtnUseNow() {

		try {

			Thread.sleep(3000);

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnUseNow, timeOut);

			CommonFunctions.getInstance().clickElement(btnUseNow);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void verifyTotalMoney() {

		try {

			WebDriver driver = getDriver();

			int autoCharge = 0;

			if (CommonFunctions.getInstance().checkElementsByVisibilityWithTimeInput(txtAutoCharge, 5)) {

				autoCharge = Integer.parseInt(CommonFunctions.getInstance().getText(txtAutoCharge).replace("đ", "")
						.replace(".", "").replace("-", ""));
				
				System.setProperty("autoCharge", String.valueOf(autoCharge));

			}

			int afterTotalUseDiscount = Integer.parseInt(System.getProperty("totalPriceExpect")) - autoCharge
					- Integer.parseInt(System.getProperty("absoluteDiscount"));

			// Wait Cart Update
			System.out.println("Price: " + System.getProperty("totalPriceExpect"));

			String totalPriceExpect = CommonFunctions.getInstance()
					.parseStringIntoCurrent(String.valueOf(afterTotalUseDiscount));

			String xpathTotalPrice = txtTotalMoneyCart.replace("total", String.valueOf(totalPriceExpect));

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(By.xpath(xpathTotalPrice), timeOut);

			String actualTotalPriceCart = driver.findElement(By.xpath(xpathTotalPrice)).getText();

			CommonFunctions.getInstance().verifyDataEquals(actualTotalPriceCart, totalPriceExpect);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void verifyTotalMoneyPercent() {

		try {

			// Get the WebDriver instance from the method getDriver()
			WebDriver driver = getDriver();

			double autoCharge = 0;

			if (CommonFunctions.getInstance().checkElementsByVisibilityWithTimeInput(txtAutoCharge, 5)) {

				autoCharge = Integer.parseInt(CommonFunctions.getInstance().getText(txtAutoCharge).replace("đ", "")
						.replace(".", "").replace("-", ""));
				
				System.setProperty("autoCharge", String.valueOf(autoCharge));

			}

			// Read the percentDiscount and totalPriceExpect from System properties and
			// parse them into double variables
			double percentDiscount = Double.parseDouble(System.getProperty("percentDiscount"));
			double totalPriceExpect = Double.parseDouble(System.getProperty("totalPriceExpect"));

			// Calculate the total discount amount based on percentDiscount and
			// totalPriceExpect
			double totalPercent = (percentDiscount / 100) * totalPriceExpect;

			// Round the result to the nearest hundred using the roundToNearestPercent
			// method from CommonFunctions
			double roundedResult = CommonFunctions.getInstance().roundToNearestPercent(totalPercent);

			// Calculate the total price after applying the discount
			double afterTotalUseDiscount = totalPriceExpect - roundedResult - autoCharge;

			// Wait Cart Update
			System.out.println("Price: " + System.getProperty("totalPriceExpect"));

			// Convert the roundedResult into a formatted string with the appropriate
			// currency representation
			String totalMoneyExpect = CommonFunctions.getInstance()
					.parseStringIntoCurrent(String.valueOf(afterTotalUseDiscount));

			// Generate the XPath expression using txtTotalMoneyCart and the formatted
			// totalMoneyExpect
			String xpathTotalMoney = txtTotalMoneyCart.replace("total", String.valueOf(totalMoneyExpect));

			// Wait for the visibility of the element matching the XPath expression
			CommonFunctions.getInstance().waitForVisibilityOfAllElement(By.xpath(xpathTotalMoney), timeOut);

			// Get the actual total price from the web page
			String actualTotalPriceCart = driver.findElement(By.xpath(xpathTotalMoney)).getText();

			// Verify that the actualTotalPriceCart matches the formatted totalMoneyExpect
			CommonFunctions.getInstance().verifyDataEquals(actualTotalPriceCart, totalMoneyExpect);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

}
