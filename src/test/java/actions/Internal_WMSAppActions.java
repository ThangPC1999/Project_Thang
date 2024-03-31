package actions;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import base.driver.DriverManager;
import utilities.CommonFunctions;

public class Internal_WMSAppActions {
	private static final By txtUserName = By.xpath(System.getProperty("Internal.WMSApp.UserName.Input"));
	private static final By txtPassword = By.xpath(System.getProperty("Internal.WMSApp.Password.Input"));
	private static final By btnSignIn = By.xpath(System.getProperty("Internal.WMSApp.SignIn.Button"));
	private static final By btnAccount = By.xpath(System.getProperty("Internal.WMSApp.Account.Button"));
	private static final By btnSignOut = By.xpath(System.getProperty("Internal.WMSApp.SignOut.Button"));
	private static final By btnSignOutConfirm = By.xpath(System.getProperty("Internal.WMSApp.SignOut.Confirm.Button"));
	private static final By btnDepartment = By.xpath(System.getProperty("Internal.WMSApp.Account.Department.Button"));
	private static String txtWareHouse = System.getProperty("Internal.WMSApp.Account.Department.Warehouse.Item");
	private static final By btnPack = By.xpath(System.getProperty("Internal.WMSApp.Pack.Button"));
	private static final By btnOrder = By.xpath(System.getProperty("Internal.WMSApp.Order.Button"));
	private static final By btnStartPut = By.xpath(System.getProperty("Internal.WMSApp.Order.StartPut.Button"));
	private static final By txtSearchLocation = By.xpath(System.getProperty("Internal.WMSApp.SearchLocation.Input"));
	private static final By txtSearchSO = By.xpath(System.getProperty("Internal.WMSApp.Pack.SearchSO.Input"));
	private static final By btnStackPack = By.xpath(System.getProperty("Internal.WMSApp.Pack.StartPack.Button"));
	private static final By btnPopUp = By.xpath(System.getProperty("Internal.WMSApp.Pack.StratPack.PopUp.Know.Button"));
	private static final By txtNumberPacket = By
			.xpath(System.getProperty("Internal.WMSApp.Pack.StratPack.NumberPacket.Input"));
	private static final By btnNotification = By
			.xpath(System.getProperty("Internal.WMSApp.Pack.StratPack.Notification.Button"));
	private static final By btnCheckBox = By
			.xpath(System.getProperty("Internal.WMSApp.Pack.StratPack.Notification.CheckBox.Button"));
	private static final By btnConfirm = By
			.xpath(System.getProperty("Internal.WMSApp.Pack.StratPack.Notification.Confirm.Button"));
	private static final By btnAddImg = By.xpath(System.getProperty("Internal.WMSApp.Pack.StratPack.AddImage.Button"));
	private static final By btnFinish = By.xpath(System.getProperty("Internal.WMSApp.Pack.StratPack.Finish.Button"));
	private static final By btnFinishDisable = By
			.xpath(System.getProperty("Internal.WMSApp.Pack.StratPack.FinishDisable.Button"));
	private static final By btnConfirmUpload = By
			.xpath(System.getProperty("Internal.WMSApp.Pack.StratPack.AddImage.Confirm.Input"));
	private static final By txtWarningUpload = By
			.xpath(System.getProperty("Internal.WMSApp.Pack.StratPack.WarningAddImg.Text"));
	private static final By iconLoader = By.xpath(System.getProperty("Icon.Loader"));
	private static final By txtUploadImage = By
			.xpath(System.getProperty("Internal.WMSApp.Pack.StratPack.AddImage.Upload.Input"));
	private static final By txtWattingUpload = By
			.xpath(System.getProperty("Internal.WMSApp.Pack.StratPack.AddImage.Watting.Text"));
	private static final By txtWattingUploadV2 = By
			.xpath(System.getProperty("Internal.WMSApp.Pack.StratPack.AddImage.WattingV2.Text"));
	private static final By txtSearchBasket = By.xpath(System.getProperty("Internal.WMSApp.Order.NumberBasket.Input"));
	private static final By txtScanLocation = By.xpath(System.getProperty("Internal.WMSApp.Order.ScanLocation.Input"));
	private static final By btnConfirmV2 = By
			.xpath(System.getProperty("Internal.WMSApp.Order.Confirm.Button"));
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
		private static final Internal_WMSAppActions INSTANCE = new Internal_WMSAppActions();
	}

	public static Internal_WMSAppActions getInstance() {
		return SingletonHelper.INSTANCE;
	}

	public void openWMSApp() {

		try {

			CommonFunctions.getInstance().goToUrl(System.getProperty("internalAppLoginUrl"));

			CommonFunctions.getInstance().waitForPageLoad(timeOut);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void sendKeysUserName(String data) {

		try {

			elem = DriverManager.getInstance().getDriver().findElement(txtUserName);

			elem.sendKeys(System.getProperty(data));
			
			System.setProperty("dataUserName", data);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void sendKeysPassword(String data) {

		try {

			elem = DriverManager.getInstance().getDriver().findElement(txtPassword);

			elem.sendKeys(System.getProperty(data));
			
			System.setProperty("dataPassword", data);


		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void clickBtnSignIn() {

		try {
			
			elem = DriverManager.getInstance().getDriver().findElement(btnSignIn);

			elem.click();
			
			if(CommonFunctions.getInstance().checkElementsByVisibilityWithTimeInput(txtUserName,5)) {
				
				this.sendKeysUserName(System.getProperty("dataUserName"));
				this.sendKeysPassword(System.getProperty("dataPassword"));
				
				elem = DriverManager.getInstance().getDriver().findElement(btnSignIn);

				CommonFunctions.getInstance().clickElement(btnSignIn);
				
			}

			
			CommonFunctions.getInstance().waitForPageLoad(timeOut);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void clickBtnAccount() {

		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnAccount, timeOut);

			elem = CommonFunctions.getInstance().findElementByVisibility(btnAccount);

			elem.click();

			CommonFunctions.getInstance().waitForPageLoad(timeOut);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}
	
	public void clickBtnSignOut() {

		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnSignOut, timeOut);

			elem = CommonFunctions.getInstance().findElementByVisibility(btnSignOut);

			elem.click();

			CommonFunctions.getInstance().clickElement(btnSignOutConfirm);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void clickBtnDepartment() {

		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnDepartment, timeOut);

			elem = CommonFunctions.getInstance().findElementByVisibility(btnDepartment);

			elem.click();

			CommonFunctions.getInstance().waitForPageLoad(timeOut);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void clickBtnWarehouse() {

		try {

			WebDriver driver = getDriver();

			// Call API Search

			String option = "";

			if (System.getProperty("regionName").equals("Miền Bắc")) {

				option = "Hà Nội";

			} else if (System.getProperty("regionName").equals("Miền Nam")) {

				option = "Bình Dương";

			} else {

				option = "Đà Nẵng";

			}

			String xpathWarehouse = txtWareHouse.replace("option", option);

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(By.xpath(xpathWarehouse), timeOut);

			elem = CommonFunctions.getInstance().findElementByVisibility(By.xpath(xpathWarehouse));

			elem.click();

			driver.navigate().back();

			CommonFunctions.getInstance().waitForPageLoad(timeOut);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void clickBtnPack() {

		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnPack, timeOut);

			elem = CommonFunctions.getInstance().findElementByVisibility(btnPack);

			elem.click();

			CommonFunctions.getInstance().waitForPageLoad(timeOut);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void sendKeysSearchLocation() {

		try {

			elem = CommonFunctions.getInstance().findElementByVisibility(txtSearchLocation);

			elem.sendKeys(System.getProperty("dShiftCode"));

			elem.sendKeys(Keys.ENTER);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void sendKeysSearchSO() {

		try {

			elem = CommonFunctions.getInstance().findElementByVisibility(txtSearchSO);

			elem.sendKeys(System.getProperty("numberSO"));

			elem.sendKeys(Keys.ENTER);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void clickBtnStartPack() {

		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnStackPack, timeOut);

			elem = CommonFunctions.getInstance().findElementByVisibility(btnStackPack);

			elem.click();

			CommonFunctions.getInstance().waitForPageLoad(timeOut);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void clickBtnPopUp() {

		try {

			CommonFunctions.getInstance().waitForElementToDisappear(iconLoader, timeOut);

			if (CommonFunctions.getInstance().checkElementsByVisibility(btnPopUp)) {

				CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnPopUp, timeOut);

				elem = CommonFunctions.getInstance().findElementByVisibility(btnPopUp);

				elem.click();

			}

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void clickBtnNotification() {

		try {

			if (CommonFunctions.getInstance().checkElementsByVisibility(btnPopUp)) {

				CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnPopUp, timeOut);

				elem = CommonFunctions.getInstance().findElementByVisibility(btnPopUp);

				elem.click();

			}

			elem = CommonFunctions.getInstance().findElementByVisibility(btnNotification);

			elem.click();

			elem = CommonFunctions.getInstance().findElementByVisibility(btnCheckBox);

			elem.click();

			elem = CommonFunctions.getInstance().findElementByVisibility(btnConfirm);

			elem.click();

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void sendKeysNumberPacket() {

		try {

			elem = CommonFunctions.getInstance().findElementByVisibility(txtNumberPacket);

			elem.sendKeys("1");

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void uploadImage() throws InterruptedException {

//		try {

			WebDriver driver = getDriver();

			elem = CommonFunctions.getInstance().findElementByVisibility(txtWarningUpload);

			String warningUpdate = elem.getText();

			// Create a regular expression pattern to match the number
			Pattern pattern = Pattern.compile("\\d+");

			// Create a matcher to search for the pattern in the input string
			Matcher matcher = pattern.matcher(warningUpdate);

			int number = 0;

			// Check if a match is found
			if (matcher.find()) {
				String numberString = matcher.group();
				number = Integer.parseInt(numberString);
				System.out.println("Extracted number: " + number);
			}

			for (int i = 0; i < number; i++) {

				String img = System.getProperty("user.dir") + "\\src\\test\\resources\\img\\" + "panadol.jpeg";

				CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnAddImg, timeOut);

				elem = CommonFunctions.getInstance().findElementByVisibility(btnAddImg);

				CommonFunctions.getInstance().scrollToObject(btnAddImg, 0);

				if (elem.isEnabled()) {

					CommonFunctions.getInstance().clickJavascript(btnAddImg);

					CommonFunctions.getInstance().waitForElementToDisappear(iconLoader, timeOut);
					
					Thread.sleep(5000);

				}

				try {

					elem = driver.findElement(txtUploadImage);

					CommonFunctions.getInstance().uploadImg(elem, img);
					//
					elem = CommonFunctions.getInstance().findElementByVisibility(btnConfirmUpload);

					CommonFunctions.getInstance().clickByJavascript(elem);

					CommonFunctions.getInstance().waitForElementToDisappear(iconLoader, timeOut);
					
					Thread.sleep(5000);

				} catch (Exception e) {

					CommonFunctions.getInstance().clickJavascript(btnAddImg);

					CommonFunctions.getInstance().waitForElementToDisappear(iconLoader, timeOut);

					elem = driver.findElement(txtUploadImage);

					CommonFunctions.getInstance().uploadImg(elem, img);
					//
					elem = CommonFunctions.getInstance().findElementByVisibility(btnConfirmUpload);

					CommonFunctions.getInstance().clickByJavascript(elem);

					CommonFunctions.getInstance().waitForElementToDisappear(iconLoader, timeOut);
				}

				CommonFunctions.getInstance().waitForElementToDisappear(txtWattingUpload, 240);
				CommonFunctions.getInstance().waitForElementToDisappear(txtWattingUploadV2, 240);

//

			}

			if (CommonFunctions.getInstance().checkElementsByVisibilityWithTimeInput(btnAddImg, 5)) {

				String img = System.getProperty("user.dir") + "\\src\\test\\resources\\img\\" + "panadol.jpeg";

				CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnAddImg, timeOut);

				elem = CommonFunctions.getInstance().findElementByVisibility(btnAddImg);

				CommonFunctions.getInstance().scrollToObject(btnAddImg, 0);

				if (elem.isEnabled()) {

					CommonFunctions.getInstance().clickJavascript(btnAddImg);

					CommonFunctions.getInstance().waitForElementToDisappear(iconLoader, timeOut);

					CommonFunctions.getInstance().waitForElementToDisappear(txtWattingUpload, 240);
					
					CommonFunctions.getInstance().waitForElementToDisappear(txtWattingUploadV2, 240);
					
					Thread.sleep(5000);

				}

				try {

					elem = driver.findElement(txtUploadImage);

					CommonFunctions.getInstance().uploadImg(elem, img);
					//
					elem = CommonFunctions.getInstance().findElementByVisibility(btnConfirmUpload);

					CommonFunctions.getInstance().clickByJavascript(elem);

					CommonFunctions.getInstance().waitForElementToDisappear(iconLoader, timeOut);

					CommonFunctions.getInstance().waitForElementToDisappear(txtWattingUpload, 240);
					
					CommonFunctions.getInstance().waitForElementToDisappear(txtWattingUploadV2, 240);
					
					Thread.sleep(5000);


				} catch (Exception e) {

					CommonFunctions.getInstance().clickJavascript(btnAddImg);

					CommonFunctions.getInstance().waitForElementToDisappear(iconLoader, timeOut);

					elem = driver.findElement(txtUploadImage);

					CommonFunctions.getInstance().uploadImg(elem, img);
					//
					elem = CommonFunctions.getInstance().findElementByVisibility(btnConfirmUpload);

					CommonFunctions.getInstance().clickByJavascript(elem);

					CommonFunctions.getInstance().waitForElementToDisappear(iconLoader, timeOut);

					CommonFunctions.getInstance().waitForElementToDisappear(txtWattingUpload, 240);
					
					CommonFunctions.getInstance().waitForElementToDisappear(txtWattingUploadV2, 240);
					
					Thread.sleep(5000);

				}

			}

			CommonFunctions.getInstance().waitForElementToDisappear(txtWattingUpload, 240);
			
			CommonFunctions.getInstance().waitForElementToDisappear(txtWattingUploadV2, 240);

			System.out.println("Test");

//		} catch (Exception e) {
//			Assert.fail(e.getMessage());
//		}

	}

	public void clickBtnFinish() {

		try {

			Thread.sleep(5000);

			CommonFunctions.getInstance().waitForElementToDisappear(txtWattingUpload, 240);

			CommonFunctions.getInstance().waitForElementToDisappear(txtWattingUploadV2, 240);

			CommonFunctions.getInstance().waitForElementToDisappear(btnFinishDisable, 240);

			elem = CommonFunctions.getInstance().findElementByVisibility(btnFinish);

			elem.click();
			
			Thread.sleep(5000);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void clickBtnOrder() {

		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnOrder, timeOut);

			elem = CommonFunctions.getInstance().findElementByVisibility(btnOrder);

			elem.click();

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void clickBtnStartPut() {

		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnStartPut, timeOut);

			CommonFunctions.getInstance().clickElement(btnStartPut);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}
	
	public void clickBtnConfirm() {

		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnConfirmV2, timeOut);

			CommonFunctions.getInstance().clickElement(btnConfirmV2);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void sendKeysBasketCode() {

		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(txtSearchBasket, timeOut);

			CommonFunctions.getInstance().sendkeys(txtSearchBasket, System.getProperty("dBasketCode"));

			CommonFunctions.getInstance().pressKeys(txtSearchBasket, Keys.ENTER);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void sendKeysScanLocations() {

		try {
			
			Thread.sleep(2000);

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(txtScanLocation, timeOut);

            CommonFunctions.getInstance().clickElement(txtScanLocation);
            
            Thread.sleep(5000);
            
			CommonFunctions.getInstance().copyPasteByRobot(System.getProperty("locationsCode"));

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}
	
	public void sendKeysQrPO() {

		try {
			
			Thread.sleep(2000);

            CommonFunctions.getInstance().clickElement(By.xpath("//html"));
            
			CommonFunctions.getInstance().copyPasteByRobot(System.getProperty("qrCodePO"));

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

}
