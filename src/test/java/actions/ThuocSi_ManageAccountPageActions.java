package actions;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import base.driver.DriverManager;
import utilities.CommonFunctions;

public class ThuocSi_ManageAccountPageActions {

	private static final By btnUpdate = By
			.xpath(System.getProperty("ManageAccount.Account.InforEnterprise.Update.Button"));
	private static final By selectDistrict = By
			.xpath(System.getProperty("ManageAccount.Account.InforEnterprise.District.Select"));
	private static final By txtUploadFile = By
			.xpath(System.getProperty("ManageAccount.Account.InforEnterprise.UploadFile.Input"));
	private static final By txtAddress = By
			.xpath(System.getProperty("ManageAccount.Account.InforEnterprise.Address.Input"));
	private static final By msgUpdateSuccess = By
			.xpath(System.getProperty("ManageAccount.Account.InforEnterprise.Update.Success.Message"));
	private static final By menuQuickOrder = By.xpath(System.getProperty("Home.Menu.QuickOrder"));
	private static String txtItem = System.getProperty("ManageAccount.Account.InforEnterprise.Select.Item");
	private static String txtSubMenu = System.getProperty("ManageAccount.SubMenu.Text");
	private static final By btnExchangePoint = By.xpath(System.getProperty("ManageAccount.AccumulatedPoints.ExchangePoint.Button"));
	private static final By btnShowMore = By.xpath(System.getProperty("ManageAccount.AccumulatedPoints.ExchangePoint.ShowMore.Button"));
	private static String txtItemCode = System.getProperty("ManageAccount.AccumulatedPoints.ExchangePoint.ItemCode.Text");
	private static final By btnUsing = By.xpath(System.getProperty("ManageAccount.AccumulatedPoints.ExchangePoint.ItemCode.Using.Button"));
	private static final By btnConfirm = By.xpath(System.getProperty("ManageAccount.AccumulatedPoints.ExchangePoint.ItemCode.Using.Confirm.Button"));
	private static final By txtCodeExchange = By.xpath(System.getProperty("ManageAccount.AccumulatedPoints.ExchangePoint.ItemCode.Using.Confirm.Code.Text"));

	
	
	@FindBy(how = How.XPATH, using = "")
	private WebElement elem;
	public static WebDriver driver;

	public static WebDriver getDriver() {
		driver = DriverManager.getInstance().getDriver();
		return driver;
	}

	int timeOut = Integer.parseInt(System.getProperty("objectTimeout"));

	private static class SingletonHelper {
		private static final ThuocSi_ManageAccountPageActions INSTANCE = new ThuocSi_ManageAccountPageActions();
	}

	public static ThuocSi_ManageAccountPageActions getInstance() {
		return SingletonHelper.INSTANCE;
	}
	
	public void uploadFile() {

		try {

			String img = System.getProperty("user.dir") + "\\src\\test\\resources\\img\\" + "File.png";
			
			List<WebElement> lElem = DriverManager.getInstance().getDriver().findElements(txtUploadFile);

			for(WebElement elem : lElem) {
				
				CommonFunctions.getInstance().uploadImg(elem, img);

				
			}

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void selectDistrict() {

		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(selectDistrict, timeOut);

			CommonFunctions.getInstance().hoverElement(selectDistrict);

			CommonFunctions.getInstance().clickElement(selectDistrict);

			String xpathItem = txtItem.replaceAll("\\bopt\\b", System.getProperty("dDistrict"));

			elem = CommonFunctions.getInstance().findElementByVisibility(By.xpath(xpathItem));

			elem.click();

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void selectWard() {

		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(selectDistrict, timeOut);

			CommonFunctions.getInstance().hoverElement(selectDistrict);

			CommonFunctions.getInstance().clickElement(selectDistrict);

			String xpathItem = txtItem.replaceAll("\\bopt\\b", System.getProperty("dWard"));

			elem = CommonFunctions.getInstance().findElementByVisibility(By.xpath(xpathItem));

			elem.click();

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void sendKeysAddress() {

		try {

			elem = CommonFunctions.getInstance().findElementByVisibility(txtAddress);

			CommonFunctions.getInstance().hoverElement(txtAddress);

			elem.sendKeys(System.getProperty("dAddress"));

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void clickBtnUpdate() {

		try {

			elem = CommonFunctions.getInstance().findElementByVisibility(btnUpdate);

			CommonFunctions.getInstance().hoverElement(btnUpdate);

			elem.click();

			CommonFunctions.getInstance().waitForPageLoad(timeOut);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void verifyMsgUpdate() {

		try {

			if (!CommonFunctions.getInstance().checkElementsByVisibility(msgUpdateSuccess)) {

				Assert.fail("Update fail");
			}

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void clickMenuQuickOrder() {

		try {

			Thread.sleep(3000);

			elem = CommonFunctions.getInstance().findElementByVisibility(menuQuickOrder);

			CommonFunctions.getInstance().clickByJavascript(elem);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}
	
	public void clickSubMenu(String optionMenu) {

		try {

			String xpathSubMenu = txtSubMenu.replace("option", optionMenu);
			
			CommonFunctions.getInstance().clickElement(By.xpath(xpathSubMenu));
			
			Thread.sleep(3000);
			

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}
	
	public void clickBtnExchangePoint() {

		try {

			CommonFunctions.getInstance().clickElement(btnExchangePoint);
			
			if(CommonFunctions.getInstance().checkElementsByVisibilityWithTimeInput(btnShowMore,5)){
				
				CommonFunctions.getInstance().clickElement(btnShowMore);
				
				Thread.sleep(3000);
				
			}
			
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}
	
	public void verifyCodeExchangePoint() {

		try {
			
			String xpathCodeExchange = txtItemCode.replace("option", System.getProperty("contentPromotion"));

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(By.xpath(xpathCodeExchange),timeOut);
			
			CommonFunctions.getInstance().clickElement(By.xpath(xpathCodeExchange));

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}
	
	public void clickBtnUsingExchangePoint() {

		try {
			
			CommonFunctions.getInstance().clickElement(btnUsing);
			
			if(CommonFunctions.getInstance().checkElementsByVisibilityWithTimeInput(btnConfirm,5)){
				
				CommonFunctions.getInstance().clickElement(btnConfirm);
				
				Thread.sleep(3000);
				
			}
			
			String code = CommonFunctions.getInstance().getText(txtCodeExchange);
			
			System.setProperty("codeDiscount", code);
			

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	
}
