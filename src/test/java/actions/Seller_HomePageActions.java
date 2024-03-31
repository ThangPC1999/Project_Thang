package actions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import base.driver.DriverManager;
import utilities.CommonFunctions;

public class Seller_HomePageActions {

	private static String btnMenu = System.getProperty("Seller.HomePage.Menu.Button");
	private static final By txtProductNameSearch = By
			.xpath(System.getProperty("Seller.HomePage.ManageProduct.AddProduct.ProductNameSearch.Input"));
	private static final By txtProductName = By
			.xpath(System.getProperty("Seller.HomePage.ManageProduct.AddProduct.ProductName.Input"));
	private static final By iconProcess = By.xpath(System.getProperty("Icon.Progress"));
	private static String btnSelectBuy = System
			.getProperty("Seller.HomePage.ManageProduct.AddProduct.SelectBuy.Button");
	private static String itemSelect = System.getProperty("Seller.Item.Select");
	private static final By btnStatusBuy = By
			.xpath(System.getProperty("Seller.HomePage.ManageProduct.AddProduct.StatusBuy.Button"));
	private static final By txtCategory = By
			.xpath(System.getProperty("Seller.HomePage.ManageProduct.AddProduct.Category.Input"));
	private static final By txtSellerCategory = By
			.xpath(System.getProperty("Seller.HomePage.ManageProduct.AddProduct.SellerCategory.Input"));
	private static final By txtManufacturer = By
			.xpath(System.getProperty("Seller.HomePage.ManageProduct.AddProduct.Manufacturer.Input"));
	private static final By txtSellerPrivateSKU = By
			.xpath(System.getProperty("Seller.HomePage.ManageProduct.AddProduct.SellerPrivateSKU.Input"));
	private static final By txtRawPrice = By
			.xpath(System.getProperty("Seller.HomePage.ManageProduct.AddProduct.RawPrice.Input"));
	private static final By txtSellerInventory = By
			.xpath(System.getProperty("Seller.HomePage.ManageProduct.AddProduct.SellerInventory.Input"));
	private static final By txtSelectedEfficacyCodes = By
			.xpath(System.getProperty("Seller.HomePage.ManageProduct.AddProduct.SelectedEfficacyCodes.Input"));
	private static final By txtSelectedLocations = By
			.xpath(System.getProperty("Seller.HomePage.ManageProduct.AddProduct.Locations.Input"));
	private static final By txtSelectedUnit = By
			.xpath(System.getProperty("Seller.HomePage.ManageProduct.AddProduct.Unit.Input"));
	private static final By txtVolume = By
			.xpath(System.getProperty("Seller.HomePage.ManageProduct.AddProduct.Volume.Input"));
	private static final By btnSaveProduct = By
			.xpath(System.getProperty("Seller.HomePage.ManageProduct.AddProduct.Save.Button"));
	private static final By iconClosed = By
			.xpath(System.getProperty("Seller.HomePage.ManageProduct.AddProduct.Closed.Button"));
	private static final By txtImage = By
			.xpath(System.getProperty("Seller.HomePage.ManageProduct.AddProduct.Image.Input"));
	private static final By btnCreateDraftTicket = By
			.xpath(System.getProperty("Seller.HomePage.ManageWareHouse.CreateDraftTicket.Button"));
	private static final By selectWarehouseId = By
			.xpath(System.getProperty("Seller.HomePage.ManageWareHouse.CreateDraftTicket.WarehouseId.Input"));
	private static final By selectDeliveryMethod = By
			.xpath(System.getProperty("Seller.HomePage.ManageWareHouse.CreateDraftTicket.DeliveryMethod.Input"));
	private static final By txtExpectDate = By
			.xpath(System.getProperty("Seller.HomePage.ManageWareHouse.CreateDraftTicket.ExpectDate.Input"));
	private static final By txtExpectTime = By
			.xpath(System.getProperty("Seller.HomePage.ManageWareHouse.CreateDraftTicket.ExpectTime.Input"));
	private static final By btnEditTime = By
			.xpath(System.getProperty("Seller.HomePage.ManageWareHouse.CreateDraftTicket.ExpectTime.Edit.Button"));
	private static final By btnAddProduct = By
			.xpath(System.getProperty("Seller.HomePage.ManageWareHouse.CreateDraftTicket.AddProduct.Button"));
	private static final By iconAddProduct = By
			.xpath(System.getProperty("Seller.HomePage.ManageWareHouse.CreateDraftTicket.AddProduct.Icon"));
	private static final By txtProductLot = By
			.xpath(System.getProperty("Seller.HomePage.ManageWareHouse.CreateDraftTicket.ProductLot.Input"));
	private static final By txtDate = By
			.xpath(System.getProperty("Seller.HomePage.ManageWareHouse.CreateDraftTicket.Date.Input"));
	private static final By btnCreateTicket = By
			.xpath(System.getProperty("Seller.HomePage.ManageWareHouse.CreateDraftTicket.CreateTicket.Button"));
	private static final By btnOK = By
			.xpath(System.getProperty("Seller.HomePage.ManageWareHouse.CreateDraftTicket.ExpectTime.Edit.OK.Button"));
	private static final By btnPrint = By
			.xpath(System.getProperty("Seller.HomePage.ManageWareHouse.CreateDraftTicket.Print.Button"));
	private static final By btnCompleteGift = By
			.xpath(System.getProperty("Seller.HomePage.ManageWareHouse.CreateDraftTicket.Print.CompleteGift.Button"));
	private static final By txtPackageQuantity = By.xpath(System
			.getProperty("Seller.HomePage.ManageWareHouse.CreateDraftTicket.Print.CompleteGift.PackageQuantity.Input"));
	private static final By btnDownload = By.xpath(
			System.getProperty("Seller.HomePage.ManageWareHouse.CreateDraftTicket.Print.CompleteGift.Download.Button"));
	private static final By txtTicketNumber = By
			.xpath(System.getProperty("Seller.HomePage.ManageWareHouse.CreateDraftTicket.TicketNumber.Text"));
	private static final By txtExpectQuantity = By
			.xpath(System.getProperty("Seller.HomePage.ManageWareHouse.CreateDraftTicket.ExpectQuantity.Input"));
	private static final By txtComboName = By.xpath(System.getProperty("Seller.HomePage.ManageCombo.ComboName.Input"));
	private static final By txtComboCode = By.xpath(System.getProperty("Seller.HomePage.ManageCombo.ComboCode.Input"));
	private static final By imgCombo = By.xpath(System.getProperty("Seller.HomePage.ManageCombo.Image.Input"));
	private static final By selectProductName = By
			.xpath(System.getProperty("Seller.HomePage.ManageCombo.ProductName.Input"));
	private static final By txtQuantity = By.xpath(System.getProperty("Seller.HomePage.ManageCombo.Quantity.Input"));
	private static final By selectDiscountType = By
			.xpath(System.getProperty("Seller.HomePage.ManageCombo.DiscountType.Input"));
	private static final By txtMoneyPrice = By
			.xpath(System.getProperty("Seller.HomePage.ManageCombo.MoneyPrice.Input"));
	private static final By btnCreateCombo = By
			.xpath(System.getProperty("Seller.HomePage.ManageCombo.CreateCombo.Button"));
	private static final By btnAddCombo = By
			.xpath(System.getProperty("Seller.HomePage.ManageCombo.AddCombo.Button"));
	private static final By txtLength = By.xpath(System.getProperty("Internal.Home.Menu.CMS.Product.Length.Input"));
	private static final By txtWidth = By.xpath(System.getProperty("Internal.Home.Menu.CMS.Product.Width.Input"));
	private static final By txtHeight = By.xpath(System.getProperty("Internal.Home.Menu.CMS.Product.Height.Input"));
	private static final By txtWeight = By.xpath(System.getProperty("Internal.Home.Menu.CMS.Product.Weight.Input"));
	@FindBy(how = How.XPATH, using = "")
	private WebElement elem;
	public static WebDriver driver;

	public static WebDriver getDriver() {
		driver = DriverManager.getInstance().getDriver();
		return driver;
	}

	int timeOut = Integer.parseInt(System.getProperty("objectTimeout"));

	private static class SingletonHelper {
		private static final Seller_HomePageActions INSTANCE = new Seller_HomePageActions();
	}

	public static Seller_HomePageActions getInstance() {
		return SingletonHelper.INSTANCE;
	}

	public void clickMenu(String optionMenu) {

		try {

			String xpathMenu = btnMenu.replace("option", optionMenu);

			CommonFunctions.getInstance().clickElement(By.xpath(xpathMenu));

			CommonFunctions.getInstance().waitForElementToDisappear(iconProcess, timeOut);

			CommonFunctions.getInstance().waitForPageLoad(timeOut);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void sendKeysSellerPrivateSKU() {

		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(txtSellerPrivateSKU, timeOut);

			CommonFunctions.getInstance().sendkeys(txtSellerPrivateSKU,
					System.getProperty("dProductName").toUpperCase());

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void sendKeysProductNameSearch() {
		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(txtProductNameSearch, timeOut);

			CommonFunctions.getInstance().sendkeys(txtProductNameSearch, System.getProperty("dProductName"));

			CommonFunctions.getInstance().pressKeys(txtProductNameSearch, Keys.ENTER);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void sendKeysProductName() {

		try {

			if (CommonFunctions.getInstance().checkElementsByVisibility(iconClosed)) {

				CommonFunctions.getInstance().clickElement(iconClosed);

			}

			String nameProduct = "Panadol cảm cúm extra " + CommonFunctions.getInstance().generateRandomNumeric(5);

			System.setProperty("dProductName", nameProduct);

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(txtProductName, timeOut);

			CommonFunctions.getInstance().sendkeys(txtProductName, nameProduct);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void sendKeysRawPrice() {

		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(txtRawPrice, timeOut);

			CommonFunctions.getInstance().sendkeys(txtRawPrice,
					CommonFunctions.getInstance().generateRandomNumeric(4) + "000");

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void sendKeysImage() {

		try {

			String img = System.getProperty("user.dir") + "\\src\\test\\resources\\img\\" + "panadol.jpeg";

			elem = DriverManager.getInstance().getDriver().findElement(txtImage);

			CommonFunctions.getInstance().uploadImg(elem, img);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void sendKeysSellerInventory() {

		try {

			String numberQuantity = CommonFunctions.getInstance().generateRandomNumeric(3);

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(txtSellerInventory, timeOut);

			CommonFunctions.getInstance().sendkeys(txtSellerInventory, numberQuantity);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void sendKeysExpectDate() {

		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(txtExpectDate, timeOut);

			String date = String.valueOf(LocalDate.now().getDayOfMonth() + 1);

			CommonFunctions.getInstance().actionClearAndSendkeys(txtExpectDate, date);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void sendKeysExpectTime() {

		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(txtExpectTime, timeOut);

			String time = "12:00";

			CommonFunctions.getInstance().clickElement(txtExpectTime);

			CommonFunctions.getInstance().clickElement(btnEditTime);

			CommonFunctions.getInstance().sendkeys(txtExpectTime, time);

			CommonFunctions.getInstance().clickElement(btnOK);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void sendKeysDate() {

		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(txtDate, timeOut);

			// Get the current LocalDate
			LocalDate d = LocalDate.now();

			// Get the current year and increase it by 1
			int currentYear = d.getYear();
			int desiredYear = currentYear + 1;

			// Set the desired year
			d = d.withYear(desiredYear);

			// Define the desired date format
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

			// Format the LocalDate into a String
			String formattedDate = d.format(formatter);

			CommonFunctions.getInstance().clearAndSenkeys(txtDate, formattedDate);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void sendKeysVolume() {

		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(txtVolume, timeOut);

			CommonFunctions.getInstance().sendkeys(txtVolume, CommonFunctions.getInstance().generateRandomNumeric(3));

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void sendKeysLot() {
		try {

//			// WorkAround
//
//			System.clearProperty("dProductName");
//
//			String dProductName = CommonFunctions.getInstance().getText(By.xpath("//div[@data-sku]//p"));
//
//			System.setProperty("dProductName", dProductName);

			String expectQuantity = CommonFunctions.getInstance().getAttribute(txtExpectQuantity, "value");

			System.setProperty("numerQuantity", expectQuantity);

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(txtProductLot, timeOut);

			String randCharacter = CommonFunctions.getInstance().generateRandomAlpha(2);

			CommonFunctions.getInstance().actionClearAndSendkeys(txtProductLot, randCharacter);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void sendKeysPackageQuantity() {
		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(txtPackageQuantity, timeOut);

			CommonFunctions.getInstance().clearAndSenkeys(txtPackageQuantity, "1");

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void sendKeysComboName() {

		try {

			if (CommonFunctions.getInstance().checkElementsByVisibility(iconClosed)) {

				CommonFunctions.getInstance().clickElement(iconClosed);

			}

			String comboName = "Panadol cảm cúm extra " + CommonFunctions.getInstance().generateRandomNumeric(5);

			System.setProperty("dComboName", comboName);

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(txtComboName, timeOut);

			CommonFunctions.getInstance().sendkeys(txtComboName, comboName);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void sendKeysComboCode() {

		try {

			// Remove spaces and replace special characters with dashes
			String formatted = System.getProperty("dComboName").replaceAll("[^\\p{L}\\p{N}]+", "-");

			// Replace consecutive dashes with a single dash
			formatted = formatted.replaceAll("-+", "-");

			// Remove leading and trailing dashes
			formatted = formatted.replaceAll("^-|-$", "");

			String comboCode = "Combo-" + formatted;

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(txtComboCode, timeOut);

			CommonFunctions.getInstance().sendkeys(txtComboCode, comboCode);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void sendKeysImageCombo() {

		try {

			String img = System.getProperty("user.dir") + "\\src\\test\\resources\\img\\" + "panadol.jpeg";

			elem = DriverManager.getInstance().getDriver().findElement(imgCombo);

			CommonFunctions.getInstance().uploadImg(elem, img);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void sendKeysQuantity() {

		try {

			CommonFunctions.getInstance().sendkeys(txtQuantity, CommonFunctions.getInstance().generateRandomNumeric(2));

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void sendKeysMoneyPrice() {

		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(txtMoneyPrice, timeOut);

			CommonFunctions.getInstance().sendkeys(txtMoneyPrice,
					CommonFunctions.getInstance().generateRandomNumeric(3) + "000");

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void getTicketNumber() {
		try {

			String ticketNumber = CommonFunctions.getInstance().getText(txtTicketNumber);

			String pattern = "[A-Za-z]+\\d+"; // A sequence of letters followed by numbers

			Pattern regex = Pattern.compile(pattern);
			Matcher matcher = regex.matcher(ticketNumber);

			if (matcher.find()) {

				String extractedSubString = matcher.group();

				System.out.println("Extracted substring: " + extractedSubString);

				System.setProperty("numberPO", extractedSubString);

			} else {
				System.out.println("Pattern not found in the input string.");
			}

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void selectStatusBuy(String optionStatus) {

		try {

			String xpathSelectStatusBuy = itemSelect.replace("option", optionStatus);

			CommonFunctions.getInstance().clickElement(btnStatusBuy);

			CommonFunctions.getInstance().clickElement(By.xpath(xpathSelectStatusBuy));

			CommonFunctions.getInstance().waitForElementToDisappear(iconProcess, timeOut);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void selectCategory(String optionCategory) {

		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(txtCategory, timeOut);

			String xpathSelectCategory = itemSelect.replace("option", optionCategory);

			CommonFunctions.getInstance().actionClearAndSendkeys(txtCategory, optionCategory);

			CommonFunctions.getInstance().actionClearAndSendkeys(txtCategory, optionCategory);

			CommonFunctions.getInstance().clickElement(By.xpath(xpathSelectCategory));

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void selectSellerCategory(String optionSellerCategory) {

		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(txtSellerCategory, timeOut);

			String xpathSelectSellerCategory = itemSelect.replace("option", optionSellerCategory);

			CommonFunctions.getInstance().actionClearAndSendkeys(txtSellerCategory, optionSellerCategory);

			CommonFunctions.getInstance().clickElement(By.xpath(xpathSelectSellerCategory));

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void selectManufacturer(String optionManufacturer) {

		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(txtManufacturer, timeOut);

			String xpathSelectManufacturer = itemSelect.replace("option", optionManufacturer);

			CommonFunctions.getInstance().actionClearAndSendkeys(txtManufacturer, optionManufacturer);

			CommonFunctions.getInstance().clickElement(By.xpath(xpathSelectManufacturer));

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void selectEfficacyCodes(String optionEfficacyCodes) {

		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(txtSelectedEfficacyCodes, timeOut);

			String xpathSelectEfficacyCodes = itemSelect.replace("option", optionEfficacyCodes);

			CommonFunctions.getInstance().actionClearAndSendkeys(txtSelectedEfficacyCodes, optionEfficacyCodes);

			CommonFunctions.getInstance().clickElement(By.xpath(xpathSelectEfficacyCodes));

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void selectLocations(String optionLocations) {

		try {

			optionLocations = CommonFunctions.getInstance().getValueSystemProperty(optionLocations);

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(txtSelectedLocations, timeOut);

			String xpathSelectLocations = itemSelect.replace("option", optionLocations);

			CommonFunctions.getInstance().actionClearAndSendkeys(txtSelectedLocations, optionLocations);

			CommonFunctions.getInstance().clickElement(By.xpath(xpathSelectLocations));

			System.setProperty("regionName", optionLocations);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void selectUnit(String optionUnit) {

		try {

			optionUnit = CommonFunctions.getInstance().getValueSystemProperty(optionUnit);

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(txtSelectedUnit, timeOut);

			String xpathSelectUnit = itemSelect.replace("option", optionUnit);

			CommonFunctions.getInstance().actionClearAndSendkeys(txtSelectedUnit, optionUnit);

			CommonFunctions.getInstance().clickElement(By.xpath(xpathSelectUnit));
			
			CommonFunctions.getInstance().sendkeys(txtLength, CommonFunctions.getInstance().generateRandomNumeric(2));

			CommonFunctions.getInstance().sendkeys(txtWidth, CommonFunctions.getInstance().generateRandomNumeric(2));
			
			CommonFunctions.getInstance().sendkeys(txtHeight, CommonFunctions.getInstance().generateRandomNumeric(2));

			CommonFunctions.getInstance().sendkeys(txtWeight, CommonFunctions.getInstance().generateRandomNumeric(2));

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void selectWarehouseId(String optionWarehouseId) {

		try {

			optionWarehouseId = CommonFunctions.getInstance().getValueSystemProperty(optionWarehouseId);

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(selectWarehouseId, timeOut);

			String xpathSelectWarehouseId = itemSelect.replace("option", optionWarehouseId);

			CommonFunctions.getInstance().clickElement(selectWarehouseId);

			CommonFunctions.getInstance().clickElement(By.xpath(xpathSelectWarehouseId));

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void selectDeliveryMethod(String optionDeliveryMethod) {

		try {

			optionDeliveryMethod = CommonFunctions.getInstance().getValueSystemProperty(optionDeliveryMethod);

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(selectDeliveryMethod, timeOut);

			String xpathSelectDeliveryMethod = itemSelect.replace("option", optionDeliveryMethod);

			CommonFunctions.getInstance().clickElement(selectDeliveryMethod);

			CommonFunctions.getInstance().clickElement(By.xpath(xpathSelectDeliveryMethod));

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void selectDiscountType(String optionDiscountType) {

		try {

			optionDiscountType = CommonFunctions.getInstance().getValueSystemProperty(optionDiscountType);

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(selectDiscountType, timeOut);

			String xpathSelectDiscountType = itemSelect.replace("option", optionDiscountType);

			CommonFunctions.getInstance().clickElement(selectDiscountType);

			CommonFunctions.getInstance().clickElement(By.xpath(xpathSelectDiscountType));

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void selectProductName() {

		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(selectProductName, timeOut);

			String xpathSelectProductName = itemSelect.replace("option", System.getProperty("dProductName"));

			CommonFunctions.getInstance().sendkeys(selectProductName, System.getProperty("dProductName"));

			CommonFunctions.getInstance().clickElement(By.xpath(xpathSelectProductName));

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void clickBtnSaveProduct() {

		try {

			CommonFunctions.getInstance().clickElement(btnSaveProduct);

			Thread.sleep(5000);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void clickBtnCreateDraftTicket() {

		try {

			CommonFunctions.getInstance().clickElement(btnCreateDraftTicket);

			Thread.sleep(3000);

			CommonFunctions.getInstance().waitForElementToDisappear(iconProcess, timeOut);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void clickBtnAddProduct() {

		try {

			CommonFunctions.getInstance().clickJavascript(btnAddProduct);

			Thread.sleep(3000);

			CommonFunctions.getInstance().waitForElementToDisappear(iconProcess, timeOut);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void clickIconAddProduct() {

		try {

			CommonFunctions.getInstance().clickElement(iconAddProduct);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void clickIconClosed() {

		try {

			CommonFunctions.getInstance().clickElement(iconClosed);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void clickBtnSelectBuy() {

		try {

			String xpathSelectBuy = btnSelectBuy.replace("option", System.getProperty("dProductName"));

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(By.xpath(xpathSelectBuy), timeOut);

			CommonFunctions.getInstance().clickElement(By.xpath(xpathSelectBuy));

			CommonFunctions.getInstance().waitForElementToDisappear(iconProcess, timeOut);

			Thread.sleep(5000);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void clickBtnCreateTicket() {

		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnCreateTicket, timeOut);

			CommonFunctions.getInstance().clickElement(btnCreateTicket);

			CommonFunctions.getInstance().waitForElementToDisappear(iconProcess, timeOut);

			Thread.sleep(5000);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void clickBtnPrint() {

		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnPrint, timeOut);

			CommonFunctions.getInstance().clickElement(btnPrint);

			CommonFunctions.getInstance().waitForElementToDisappear(iconProcess, timeOut);

			Thread.sleep(5000);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void clickBtnCompleteGift() {

		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnCompleteGift, timeOut);

			CommonFunctions.getInstance().clickElement(btnCompleteGift);

			CommonFunctions.getInstance().waitForElementToDisappear(iconProcess, timeOut);

			Thread.sleep(5000);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void clickBtnDownLoad() {

		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnDownload, timeOut);

			CommonFunctions.getInstance().clickElement(btnDownload);

			CommonFunctions.getInstance().waitForElementToDisappear(iconProcess, timeOut);

			Thread.sleep(5000);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void clickBtnCreateCombo() {

		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnCreateCombo, timeOut);

			CommonFunctions.getInstance().clickElement(btnCreateCombo);

			CommonFunctions.getInstance().waitForElementToDisappear(iconProcess, timeOut);

			Thread.sleep(5000);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}
	
	public void clickBtnAddCombo() {

		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnAddCombo, timeOut);

			CommonFunctions.getInstance().clickElement(btnAddCombo);

			CommonFunctions.getInstance().waitForElementToDisappear(iconProcess, timeOut);

			Thread.sleep(2000);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

}
