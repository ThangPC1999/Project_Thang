package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import base.driver.DriverManager;
import utilities.CommonFunctions;

public class ThuocSi_ManageOrderPageActions {

	private static final By txtOrderNumber = By.xpath(System.getProperty("ManageAccount.Order.OrderNumber"));
	private static final By txtOrderStatus = By.xpath(System.getProperty("ManageAccount.Order.OderStatus"));

	@FindBy(how = How.XPATH, using = "")
	private WebElement elem;
	public static WebDriver driver;

	public static WebDriver getDriver() {
		driver = DriverManager.getInstance().getDriver();
		return driver;
	}

	int timeOut = Integer.parseInt(System.getProperty("objectTimeout"));

	private static class SingletonHelper {
		private static final ThuocSi_ManageOrderPageActions INSTANCE = new ThuocSi_ManageOrderPageActions();
	}

	public static ThuocSi_ManageOrderPageActions getInstance() {
		return SingletonHelper.INSTANCE;
	}

	public void verifyBill() {

		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(txtOrderNumber, timeOut);

			elem = CommonFunctions.getInstance().findElementByVisibility(txtOrderNumber);

			String oderNumber = elem.getText();

			int startIndex = oderNumber.indexOf("#");

			oderNumber = oderNumber.substring(startIndex + 1);

			System.setProperty("oderNumber", oderNumber);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void verifyStatusChange() {

		try {

			CommonFunctions.getInstance().refresh();

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(txtOrderStatus, timeOut);

			elem = CommonFunctions.getInstance().findElementByVisibility(txtOrderStatus);

			String status = elem.getText();

			CommonFunctions.getInstance().verifyDataEquals(status, System.getProperty("acceptStatus"));

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void verifyStatusChange(String data) {

		try {

			if (data.equals("Đã hoàn tất")) {

				for (int i = 0; i < 5; i++) {

					CommonFunctions.getInstance().refresh();

					CommonFunctions.getInstance().waitForPageLoad(timeOut);

				}
			}

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(txtOrderStatus, timeOut);

			elem = CommonFunctions.getInstance().findElementByVisibility(txtOrderStatus);

			String status = elem.getText();

			CommonFunctions.getInstance().verifyDataEquals(status, data);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

}
