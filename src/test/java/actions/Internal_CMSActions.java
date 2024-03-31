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
import io.appium.java_client.AppiumDriver;
import utilities.CommonFunctions;

public class Internal_CMSActions {
	private static final By titleProduct = By.xpath(System.getProperty("Internal.Home.Product.Title"));
	private static final By btnArea = By.xpath(System.getProperty("Internal.Home.Menu.CMS.Area.Button"));
	private static final By txtTitleCMS = By.xpath(System.getProperty("Internal.Home.Menu.CMS.Title"));
	private static final By txtTitleArea = By.xpath(System.getProperty("Internal.Home.Menu.CMS.Area.Title"));
	private static final By lTxtAreaSouth = By.xpath(System.getProperty("Internal.Home.Menu.CMS.Area.Southern"));
	private static final By lTxtAreaNorth = By.xpath(System.getProperty("Internal.Home.Menu.CMS.Area.North"));
	private static final By btnNumberPageShow = By
			.xpath(System.getProperty("Internal.Home.Menu.CMS.Area.NumberPageShow.Button"));
	private static final By btnIndexPageShow = By
			.xpath(System.getProperty("Internal.Home.Menu.CMS.Area.IndexPageShow.Button"));
	private static final By txtSearchProductName = By
			.xpath(System.getProperty("Internal.Home.Menu.CMS.Search.ProductName.Input"));
	private static String btnEditProduct = System.getProperty("Internal.Home.Menu.CMS.EditProduct.Button");
	private static String btnViewListSkus = System.getProperty("Internal.Home.Menu.CMS.ViewListSkus.Button");
	private static final By txtSku = By.xpath(System.getProperty("Internal.Home.Menu.CMS.ViewListSkus.Skus.Text"));
	private static final By listSku = By.xpath(System.getProperty("Internal.Home.Menu.CMS.EditProduct.ListSku.Text"));
	private static String txtProductId = System.getProperty("Internal.Home.Menu.CMS.ProductId.Text");
	private static final By listAmmountConversion = By
			.xpath(System.getProperty("Internal.Home.Menu.CMS.EditProduct.AmmountConversion.Text"));
	private static final By btnCreateProduct = By
			.xpath(System.getProperty("Internal.Home.Menu.CMS.Product.Create.Button"));
	private static final By txtProductName = By
			.xpath(System.getProperty("Internal.Home.Menu.CMS.Product.ProductName.Input"));
	private static final By selectCategoryProduct = By
			.xpath(System.getProperty("Internal.Home.Menu.CMS.Product.CategoryProduct.Select"));
	private static final By txtImgProduct = By
			.xpath(System.getProperty("Internal.Home.Menu.CMS.Product.imgProduct.Input"));
	private static final By selectEfficaciesProduct = By
			.xpath(System.getProperty("Internal.Home.Menu.CMS.Product.EfficaciesProduct.Select"));
	private static final By selectInitProduct = By
			.xpath(System.getProperty("Internal.Home.Menu.CMS.Product.InitProduct.Select"));
	private static final By txtOptionPacking = By
			.xpath(System.getProperty("Internal.Home.Menu.CMS.Product.OptionPacking.Input"));
	private static final By txtOriginProduct = By
			.xpath(System.getProperty("Internal.Home.Menu.CMS.Product.OriginProduct.Input"));
	private static final By txtManufacturerProduct = By
			.xpath(System.getProperty("Internal.Home.Menu.CMS.Product.ManufacturerProduct.Input"));
	private static final By txtIndustryProduct = By
			.xpath(System.getProperty("Internal.Home.Menu.CMS.Product.IndustryProduct.Input"));
	private static final By selectOwner = By.xpath(System.getProperty("Internal.Home.Menu.CMS.Product.Owner.Select"));
	private static final By btnSave = By.xpath(System.getProperty("Internal.Home.Menu.CMS.Product.Save.Button"));
	private static final By txtProductList = By
			.xpath(System.getProperty("Internal.Home.Menu.CMS.Product.ProductList.Text"));
	private static String txtItem = System.getProperty("Internal.Home.Menu.CMS.Product.Option.Item.Text");
	private static final By iconLoader = By.xpath(System.getProperty("Icon.Loader"));
	private static final By iconProgress = By.xpath(System.getProperty("Icon.Progress"));
	private static final By txtLength = By.xpath(System.getProperty("Internal.Home.Menu.CMS.Product.Length.Input"));
	private static final By txtWidth = By.xpath(System.getProperty("Internal.Home.Menu.CMS.Product.Width.Input"));
	private static final By txtHeight = By.xpath(System.getProperty("Internal.Home.Menu.CMS.Product.Height.Input"));
	private static final By txtWeight = By.xpath(System.getProperty("Internal.Home.Menu.CMS.Product.Weight.Input"));
	private static final By btnCreateCombo = By
			.xpath(System.getProperty("Internal.Home.Menu.CMS.Product.CreateCombo.Button"));
	private static final By selectProductName = By
			.xpath(System.getProperty("Internal.Home.Menu.CMS.Product.CreateCombo.ProductNameSearch.Input"));
	private static final By txtQuantity = By
			.xpath(System.getProperty("Internal.Home.Menu.CMS.Product.CreateCombo.ProductNameQuantity.Input"));
	private static final By btnAdd = By.xpath(System.getProperty("Internal.Home.Menu.CMS.Product.CreateCombo.Add.Button"));
	private static final By btnUsingName = By.xpath(System.getProperty("Internal.Home.Menu.CMS.Product.CreateCombo.UsingName.Button"));
	
	@FindBy(how = How.XPATH, using = "")
	private WebElement elem;
	private List<WebElement> lElems;

	public static WebDriver driver;

	public static WebDriver getDriver() {

		driver = DriverManager.getInstance().getDriver();
		return driver;
	}

	int timeOut = Integer.parseInt(System.getProperty("objectTimeout"));

	private static class SingletonHelper {
		private static final Internal_CMSActions INSTANCE = new Internal_CMSActions();
	}

	public static Internal_CMSActions getInstance() {
		return SingletonHelper.INSTANCE;
	}

	public void clickBtnArea() {

		try {

			CommonFunctions.getInstance().waitForElementToDisappear(iconLoader, timeOut);

			Thread.sleep(2000);

			// Wait for the visibility of all elements with the specified text in the title
//			CommonFunctions.getInstance().waitForVisibilityOfAllElement(txtTitleCMS, timeOut);

			// Hover over the "btnArea" element
			CommonFunctions.getInstance().hoverElement(btnArea);

			// Find the "btnArea" element by visibility
			CommonFunctions.getInstance().clickElement(btnArea);

			// Wait for the visibility of all elements with the specified text in the title
			CommonFunctions.getInstance().waitForVisibilityOfAllElement(txtTitleArea, timeOut);

			// Click on the "btnNumberPageShow" element
			elem = CommonFunctions.getInstance().findElementByVisibility(btnNumberPageShow);
			elem.click();

			// Click on the "btnIndexPageShow" element
			elem = CommonFunctions.getInstance().findElementByVisibility(btnIndexPageShow);
			elem.click();

			CommonFunctions.getInstance().waitForElementToDisappear(iconLoader, timeOut);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void verifyGetArea() {

		try {

			WebDriver driver = getDriver();

			// Find elements using the locator lTxtAreaSouth and store them in lElems
			lElems = driver.findElements(lTxtAreaSouth);

			// Create a new ArrayList to store the text values of the elements in lAreaSouth
			List<String> lAreaSouth = new ArrayList<>();

			// Check if lElems is not null and not empty
			if (lElems != null && !lElems.isEmpty()) {
				// Iterate over each WebElement in lElems
				for (WebElement elem : lElems) {
					// Get the text of the WebElement and add it to lAreaSouth
					lAreaSouth.add(elem.getText());
				}

				// Store the lAreaSouth list as a system property with the key "lAreaSouth"
				System.setProperty("lAreaSouth", lAreaSouth.toString());

				System.out.println(lAreaSouth.toString());
			}

			// Find elements using the locator lTxtAreaNorth and store them in lElems
			lElems = driver.findElements(lTxtAreaNorth);

			// Create a new ArrayList to store the text values of the elements in lAreaNorth
			List<String> lAreaNorth = new ArrayList<>();

			// Check if lElems is not null and not empty
			if (lElems != null && !lElems.isEmpty()) {
				// Iterate over each WebElement in lElems
				for (WebElement elem : lElems) {
					// Get the text of the WebElement and add it to lAreaNorth
					lAreaNorth.add(elem.getText());
				}

				// Store the lAreaNorth list as a system property with the key "lAreaNorth"
				System.setProperty("lAreaNorth", lAreaNorth.toString());

				System.out.println(lAreaNorth.toString());
			}

		} catch (Exception e) {

			Assert.fail(e.getMessage());
		}

	}

	public void getProductId() {

		try {

			// Set list product
			String productName = System.getProperty("dProductName");
			List<String> lProductName = new ArrayList<>();
			List<String> lProductId = new ArrayList<>();
			List<String> lAmmountConvert = new ArrayList<>();
			List<String> lSales = new ArrayList<>();

			if (productName.contains(",")) {

				lProductName = Arrays.asList(productName.split(","));

			} else {

				lProductName.add(productName);

			}

			for (int i = 0; i < lProductName.size(); i++) {

				String saleName = "";

				Thread.sleep(1000);

				CommonFunctions.getInstance().actionClearAndSendkeys(txtSearchProductName, lProductName.get(i));

				CommonFunctions.getInstance().pressKeys(txtSearchProductName, Keys.ENTER);

				CommonFunctions.getInstance().waitForPageLoad(timeOut);

				CommonFunctions.getInstance().waitForElementToDisappear(iconLoader, timeOut);

				Thread.sleep(1000);

				// Go to get MEDX or Seller

				String xpathViewListSkus = btnViewListSkus.replace("option", lProductName.get(i));

				CommonFunctions.getInstance().clickElement(By.xpath(xpathViewListSkus));

				CommonFunctions.getInstance().waitForElementToDisappear(iconLoader, timeOut);

				Thread.sleep(5000);

				String sku = CommonFunctions.getInstance().getText(txtSku);

				if (sku.contains("MEDX")) {

					saleName = sku.substring(0, sku.indexOf('.'));

				} else {

					saleName = sku.substring(0, sku.indexOf('.'));

				}

				DriverManager.getInstance().getDriver().navigate().back();

				CommonFunctions.getInstance().waitForPageLoad(timeOut);

				String xpathEdit = btnEditProduct.replace("option", lProductName.get(i));

				CommonFunctions.getInstance().clickElement(By.xpath(xpathEdit));

				CommonFunctions.getInstance().waitForElementToDisappear(iconLoader, timeOut);

				Thread.sleep(5000);

				if (CommonFunctions.getInstance().checkElementsByVisibilityWithTimeInput(listSku, 5)) {

					lElems = DriverManager.getInstance().getDriver().findElements(listSku);

					if (lElems.get(0).getText().isEmpty()) {

						DriverManager.getInstance().getDriver().navigate().back();

						CommonFunctions.getInstance().waitForPageLoad(timeOut);

						CommonFunctions.getInstance().waitForElementToDisappear(iconLoader, timeOut);

						String xpathProductId = txtProductId.replace("option", lProductName.get(i));

						CommonFunctions.getInstance().waitForVisibilityOfAllElement(By.xpath(xpathProductId), timeOut);

						String productId = CommonFunctions.getInstance().getText(By.xpath(xpathProductId));

						lProductId.add(productId);

						break;

					} else {

						for (WebElement elem : lElems) {

							String id = elem.getText().split("\\s+")[0];

							lProductId.add(id);

							lSales.add(saleName);

						}

						lElems = CommonFunctions.getInstance().findElementsByVisibility(listAmmountConversion);

						for (WebElement elem : lElems) {

							String ammountCovert = elem.getText();

							lAmmountConvert.add(ammountCovert);

						}

						DriverManager.getInstance().getDriver().navigate().back();

						CommonFunctions.getInstance().waitForPageLoad(timeOut);

					}

				} else {

					DriverManager.getInstance().getDriver().navigate().back();

					CommonFunctions.getInstance().waitForPageLoad(timeOut);

					CommonFunctions.getInstance().waitForElementToDisappear(iconLoader, timeOut);

					String xpathProductId = txtProductId.replace("option", lProductName.get(i));

					CommonFunctions.getInstance().waitForVisibilityOfAllElement(By.xpath(xpathProductId), timeOut);

					String productId = CommonFunctions.getInstance().getText(By.xpath(xpathProductId));

					lProductId.add(productId);

					// Go to get MEDX or Seller

					lSales.add(saleName);
				}

				DriverManager.getInstance().getDriver().navigate().back();

				CommonFunctions.getInstance().waitForPageLoad(timeOut);

			}

			lProductId.removeIf(String::isEmpty);

			if (lProductId.size() > 1) {

				System.setProperty("lProductId", lProductId.toString());
				System.setProperty("lAmmountConvert", lAmmountConvert.toString());

			} else {

				System.setProperty("lProductId", lProductId.get(0));

				System.setProperty("productId", lProductId.get(0));

			}

			System.out.println(lSales);
			System.setProperty("lSales", lSales.toString());

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void verifyProductListIsDisPlay() {
		try {

			CommonFunctions.getInstance().verifyElemIsDisplay(txtProductList);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void clickBtnCreateProduct() {
		try {

			if (CommonFunctions.getInstance().checkElementsByVisibilityWithTimeInput(titleProduct, 5)) {

				CommonFunctions.getInstance().clickElement(titleProduct);

				CommonFunctions.getInstance().waitForElementToDisappear(iconLoader, timeOut);

				CommonFunctions.getInstance().waitForElementToDisappear(iconProgress, timeOut);
			}

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnCreateProduct, timeOut);

			CommonFunctions.getInstance().clickElement(btnCreateProduct);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void inputNameProduct() {
		try {

			String nameProduct = "Panadol cảm cúm extra " + CommonFunctions.getInstance().generateRandomNumeric(5);

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(txtProductName, timeOut);

			CommonFunctions.getInstance().sendkeys(txtProductName, nameProduct);

			System.setProperty("dProductName", nameProduct);
			
			System.getProperty("dProductName");

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void selectCategoryProduct() {
		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(selectCategoryProduct, timeOut);

			CommonFunctions.getInstance().actionClearAndSendkeys(selectCategoryProduct, "kháng sinh");

			String xpathItem = txtItem.replace("option", "10073 - MN kháng sinh");

			CommonFunctions.getInstance().clickElement(By.xpath(xpathItem));

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void inputImgProduct() {
		try {

			String img = System.getProperty("user.dir") + "\\src\\test\\resources\\img\\" + "panadol.jpeg";

			WebDriver driver = getDriver();

			elem = driver.findElement(txtImgProduct);

			CommonFunctions.getInstance().uploadImg(elem, img);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void selectEfficaciesProduct() {
		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(selectEfficaciesProduct, timeOut);

			CommonFunctions.getInstance().actionClearAndSendkeys(selectEfficaciesProduct, "Kháng vi rút");

			String xpathItem = txtItem.replace("option", "Kháng vi rút");

			CommonFunctions.getInstance().clickElement(By.xpath(xpathItem));

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void txtBrandProduct() {
		try {

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void selectInitProduct() {
		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(selectInitProduct, timeOut);

			CommonFunctions.getInstance().actionClearAndSendkeys(selectInitProduct, "Hộp");

			String xpathItem = txtItem.replace("option", "Hộp");

			CommonFunctions.getInstance().clickElement(By.xpath(xpathItem));

			CommonFunctions.getInstance().sendkeys(txtLength, CommonFunctions.getInstance().generateRandomNumeric(2));

			CommonFunctions.getInstance().sendkeys(txtWidth, CommonFunctions.getInstance().generateRandomNumeric(2));

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void selectOptionPacking() {
		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(txtOptionPacking, timeOut);

			CommonFunctions.getInstance().sendkeys(txtOptionPacking, "1 hộp x 10 Chai");

			CommonFunctions.getInstance().sendkeys(txtHeight, CommonFunctions.getInstance().generateRandomNumeric(2));

			CommonFunctions.getInstance().sendkeys(txtWeight, CommonFunctions.getInstance().generateRandomNumeric(2));

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void selectOriginProduct() {
		try {
			CommonFunctions.getInstance().waitForVisibilityOfAllElement(txtOriginProduct, timeOut);
			CommonFunctions.getInstance().actionClearAndSendkeys(txtOriginProduct, "Anguilla");

			String xpathItem = txtItem.replace("option", "Anguilla");

			CommonFunctions.getInstance().clickElement(By.xpath(xpathItem));

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void selectManufacturerProduct() {
		try {
			CommonFunctions.getInstance().waitForVisibilityOfAllElement(txtManufacturerProduct, timeOut);
			CommonFunctions.getInstance().actionClearAndSendkeys(txtManufacturerProduct, "Curaprox");

			String xpathItem = txtItem.replace("option", "Curaprox");

			CommonFunctions.getInstance().clickElement(By.xpath(xpathItem));

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void selectIndustryProduct() {
		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(txtIndustryProduct, timeOut);

			CommonFunctions.getInstance().actionClearAndSendkeys(txtIndustryProduct, "CATEGORY 1");

			String xpathItem = txtItem.replace("option", "CATEGORY 1");

			CommonFunctions.getInstance().clickElement(By.xpath(xpathItem));

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void selectProductName() {
		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(selectProductName, timeOut);

			CommonFunctions.getInstance().actionClearAndSendkeys(selectProductName, System.getProperty("dProductName"));

			String xpathItem = txtItem.replace("option", System.getProperty("dProductName"));

			CommonFunctions.getInstance().clickElement(By.xpath(xpathItem));

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void sendKeysQuantity() {
		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(txtQuantity, timeOut);

			CommonFunctions.getInstance().sendkeys(txtQuantity, "10");

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}
	
	public void clickBtnAdd() {
		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnAdd, timeOut);

			CommonFunctions.getInstance().scrollToObject(btnAdd, 0);

			CommonFunctions.getInstance().clickElement(btnAdd);

			CommonFunctions.getInstance().waitForElementToDisappear(iconProgress, timeOut);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void clickSaveBtn() {
		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnSave, timeOut);

			CommonFunctions.getInstance().scrollToObject(btnSave, 0);

			CommonFunctions.getInstance().clickElement(btnSave);
			
			CommonFunctions.getInstance().waitForElementToDisappear(iconProgress, timeOut);

			Thread.sleep(5000);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}
	
	public void clickBtnUsingName() {
		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnUsingName, timeOut);

			CommonFunctions.getInstance().scrollToObject(btnUsingName, 0);

			CommonFunctions.getInstance().clickElement(btnUsingName);

			Thread.sleep(2000);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void clickBtnCreateCombo() {
		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnCreateCombo, timeOut);

			CommonFunctions.getInstance().clickElement(btnCreateCombo);

			CommonFunctions.getInstance().waitForElementToDisappear(iconProgress, timeOut);

			Thread.sleep(5000);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void selectOwner(String owner) {
		try {

			CommonFunctions.getInstance().actionClearAndSendkeys(selectOwner, owner);

			String xpathItem = txtItem.replace("option", owner);

			CommonFunctions.getInstance().clickElement(By.xpath(xpathItem));

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}
	
}
