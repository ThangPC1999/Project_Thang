package actions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import base.driver.DriverManager;
import utilities.CommonFunctions;

public class Internal_MEDXActions {
	private static final By btnMenu = By.xpath(System.getProperty("Internal.Home.Menu.Button"));
	private static final By btnMenuMEDX = By.xpath(System.getProperty("Internal.Home.Menu.MEDX.Button"));
	private static final By btnMenuProduct = By.xpath(System.getProperty("Internal.Home.MEDX.Product.Button"));
	private static final By btnMenuBuyProduct = By.xpath(System.getProperty("Internal.Home.MEDX.Buy.Button"));
	private static final By btnSubMenuTicketPO = By.xpath(System.getProperty("Internal.Home.MEDX.Buy.PO.Button"));
	private static final By btnSubMenuQuotePrice = By
			.xpath(System.getProperty("Internal.Home.MEDX.Buy.QuotePrice.Button"));
	private static final By btnAddNew = By.xpath(System.getProperty("Internal.Home.MEDX.Buy.PO.AddNew.Button"));
	private static final By btnSubMenuSalesProduct = By
			.xpath(System.getProperty("Internal.Home.MEDX.Product.SalesProduct.Button"));
	private static final By txtProductId = By
			.xpath(System.getProperty("Internal.Home.MEDX.SalesProduct.ProductId.Input"));
	private static final By btnApply = By.xpath(System.getProperty("Internal.Home.MEDX.SalesProduct.Apply.Button"));
	private static String txtProvinceProduct = System.getProperty("Internal.Home.MEDX.SalesProduct.Province.Text");
	private static String txtListProduct = System.getProperty("Internal.Home.MEDX.SalesProduct.ListProduct.Text");
	private static String txtVAT = System.getProperty("Internal.Home.MEDX.SalesProduct.VAT.Text");
	private static final By iconLoader = By.xpath(System.getProperty("Icon.Loader"));
	private static final By iconProgress = By.xpath(System.getProperty("Icon.Progress"));
	private static final By btnSalesProduct = By
			.xpath(System.getProperty("Internal.Home.MEDX.SalesProduct.SalesProduct.Button"));
	private static final By txtProductCode = By
			.xpath(System.getProperty("Internal.Home.MEDX.SalesProduct.ProductCode.Input"));
	private static final By txtLocationCode = By
			.xpath(System.getProperty("Internal.Home.Menu.SalesProduct.LocationCode.Input"));
	private static final By txtPrice = By
			.xpath(System.getProperty("Internal.Home.Menu.SalesProduct.RetailPrice.Input"));
	private static String optionItem = System.getProperty("Internal.Home.Menu.SalesProduct.Option.Item.Text");
	private static final By btnSave = By.xpath(System.getProperty("Internal.Home.Menu.SalesProduct.Save.Button"));
	private static final By txtVendor = By.xpath(System.getProperty("Internal.Home.MEDX.Buy.PO.AddNew.Vendor.Input"));
	private static final By txtWarehouse = By
			.xpath(System.getProperty("Internal.Home.MEDX.Buy.PO.AddNew.Warehouse.Input"));
	private static final By txtFromWarehouse = By
			.xpath(System.getProperty("Internal.Home.MEDX.Buy.PO.AddNew.FromWarehouse.Input"));
	private static final By btnAddDetailProduct = By
			.xpath(System.getProperty("Internal.Home.MEDX.Buy.PO.AddNew.AddDetailProduct.Button"));
	private static final By txtProductName = By
			.xpath(System.getProperty("Internal.Home.MEDX.Buy.PO.AddNew.ProductName.Input"));
	private static final By txtQuantity = By
			.xpath(System.getProperty("Internal.Home.MEDX.Buy.PO.AddNew.Quantity.Input"));
	private static final By txtNumberPO = By
			.xpath(System.getProperty("Internal.Home.MEDX.Buy.PO.AddNew.NumberPO.Input"));
	private static final By btnConfirm = By
			.xpath(System.getProperty("Internal.Home.MEDX.Buy.PO.AddNew.Confirm.Button"));
	private static final By txtMsgSuccess = By.xpath(System.getProperty("Message.Success"));
	private static final By btnImportFile = By
			.xpath(System.getProperty("Internal.Home.MEDX.Buy.QuotePrice.ImportFile.Button"));
	private static final By txtFile = By.xpath(System.getProperty("Internal.Home.MEDX.Buy.QuotePrice.File.Input"));
	private static final By btnConfirmUpload = By
			.xpath(System.getProperty("Internal.Home.MEDX.Buy.QuotePrice.ImportFile.Confirm.Button"));
	private static final By txtUploadSuccess = By
			.xpath(System.getProperty("Internal.Home.MEDX.Buy.QuotePrice.ImportFile.Sucess.Text"));
	@FindBy(how = How.XPATH, using = "")
	private WebElement elem;

	int timeOut = Integer.parseInt(System.getProperty("objectTimeout"));
	public static WebDriver driver;

	public static WebDriver getDriver() {
		driver = DriverManager.getInstance().getDriver();
		return driver;
	}

	private static class SingletonHelper {
		private static final Internal_MEDXActions INSTANCE = new Internal_MEDXActions();
	}

	public static Internal_MEDXActions getInstance() {
		return SingletonHelper.INSTANCE;
	}

	public void clickMenuMEDX() {

		try {

			CommonFunctions.getInstance().waitForElementToDisappear(iconLoader, timeOut);

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnMenu, timeOut);

			CommonFunctions.getInstance().clickElement(btnMenu);

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnMenuMEDX, timeOut);

			CommonFunctions.getInstance().clickElement(btnMenuMEDX);
			
			Thread.sleep(2000);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void clickBtnSubMenuSalesProduct() {

		try {

			CommonFunctions.getInstance().waitForElementToDisappear(iconLoader, timeOut);

			// Wait for the visibility of all elements with the specified text in the title
			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnMenuProduct, timeOut);

			// Hover over the "btnProduct" element
			CommonFunctions.getInstance().hoverElement(btnMenuProduct);

			// Find the "btnArea" element by visibility
			elem = CommonFunctions.getInstance().findElementByVisibility(btnMenuProduct);

			// Click on the "btnProduct" element
			elem.click();

			// Wait for the visibility of all elements with the specified text in the title
			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnSubMenuSalesProduct, timeOut);

			// Click on the "btnSalesProduct" element
			elem = CommonFunctions.getInstance().findElementByVisibility(btnSubMenuSalesProduct);
			elem.click();

			CommonFunctions.getInstance().waitForElementToDisappear(iconLoader, timeOut);

			Thread.sleep(3000);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void clickBtnSubMenuTicketPO() {

		try {

			CommonFunctions.getInstance().waitForElementToDisappear(iconLoader, timeOut);

			// Wait for the visibility of all elements with the specified text in the title
			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnMenuBuyProduct, timeOut);

			// Hover over the "btnProduct" element
			CommonFunctions.getInstance().hoverElement(btnMenuBuyProduct);

			// Find the "btnArea" element by visibility
			elem = CommonFunctions.getInstance().findElementByVisibility(btnMenuBuyProduct);

			// Click on the "btnProduct" element
			elem.click();

			// Wait for the visibility of all elements with the specified text in the title
			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnSubMenuTicketPO, timeOut);

			// Click on the "btnSalesProduct" element
			elem = CommonFunctions.getInstance().findElementByVisibility(btnSubMenuTicketPO);
			elem.click();

			CommonFunctions.getInstance().waitForElementToDisappear(iconLoader, timeOut);
			CommonFunctions.getInstance().waitForElementToDisappear(iconProgress, timeOut);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void clickBtnSubMenuQuotePrice() {

		try {

			CommonFunctions.getInstance().waitForElementToDisappear(iconLoader, timeOut);

			// Wait for the visibility of all elements with the specified text in the title
			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnMenuBuyProduct, timeOut);

			// Hover over the "btnProduct" element
			CommonFunctions.getInstance().hoverElement(btnMenuBuyProduct);

			// Click on the "btnProduct" element
			CommonFunctions.getInstance().clickElement(btnMenuBuyProduct);

			// Wait for the visibility of all elements with the specified text in the title
			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnSubMenuQuotePrice, timeOut);

			// Click on the "btnSalesProduct" element
			CommonFunctions.getInstance().clickElement(btnSubMenuQuotePrice);

			CommonFunctions.getInstance().waitForElementToDisappear(iconLoader, timeOut);
			CommonFunctions.getInstance().waitForElementToDisappear(iconProgress, timeOut);

			Thread.sleep(3000);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void clickBtnAddNew() {

		try {

			CommonFunctions.getInstance().clickElement(btnAddNew);

			CommonFunctions.getInstance().waitForElementToDisappear(iconLoader, timeOut);
			CommonFunctions.getInstance().waitForElementToDisappear(iconProgress, timeOut);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void getVAT() throws InterruptedException {

		Thread.sleep(5000);

		String lSales = System.getProperty("lSales");

		// Remove the square brackets from the string
		lSales = lSales.substring(1, lSales.length() - 1);

		// Split the string using commas as the delimiter and store the values into a
		// List<String>
		List<String> lSellerName = Arrays.asList(lSales.split(", "));

		if (System.getProperty("lAreaNorth") != null) {
			// Retrieve the lAreaNorth string value from the system properties
			String lAreaNorthString = System.getProperty("lAreaNorth");

			// Remove the square brackets from the string
			lAreaNorthString = lAreaNorthString.substring(1, lAreaNorthString.length() - 1);

			// Split the string using commas as the delimiter and store the values into a
			// List<String>
			List<String> lAreaNorthList = Arrays.asList(lAreaNorthString.split(", "));

			for (String item : lAreaNorthList) {
				if (item.equals(System.getProperty("dProvinceCode"))) {
					// Set the regionName system property to "Miền Bắc"
					System.setProperty("regionName", "Miền Bắc");

					// Print "Miền Bắc"
					System.out.println("Miền Bắc");

					break;
				}
			}
		}

		if (System.getProperty("lAreaSouth") != null) {
			// Retrieve the lAreaSouth string value from the system properties
			String lAreaSouthString = System.getProperty("lAreaSouth");

			// Remove the square brackets from the string
			lAreaSouthString = lAreaSouthString.substring(1, lAreaSouthString.length() - 1);

			// Split the string using commas as the delimiter and store the values into a
			// List<String>
			List<String> lAreaSouthList = Arrays.asList(lAreaSouthString.split(", "));

			for (String item : lAreaSouthList) {
				if (item.equals(System.getProperty("dProvinceCode"))) {
					// Set the regionName system property to "Miền Nam"
					System.setProperty("regionName", "Miền Nam");

					// Print "Miền Nam"
					System.out.println("Miền Nam");
				}
			}
		}

		String lProdutIdString = System.getProperty("lProductId");

		List<String> lProductIdList = new ArrayList<String>();

		if (lProdutIdString.contains(",")) {

			// Remove the square brackets from the string
			lProdutIdString = lProdutIdString.substring(1, lProdutIdString.length() - 1);

			// Split the string using commas as the delimiter and store the values into a
			// List<String>
			lProductIdList = Arrays.asList(lProdutIdString.split(", "));

		} else {

			lProductIdList.add(lProdutIdString);
		}

		/// Qr code
		String qrCode = System.getProperty("qrCode");

		// Remove the square brackets from the numberSku
		qrCode = qrCode.substring(1, qrCode.length() - 1);

		// Split the string using commas as the delimiter and store the values into a
		// List<String>
		List<String> lQrCode = Arrays.asList(qrCode.split(", "));
		
		for (int i = 0; i < lSellerName.size(); i++) {

			// Check Seller or MEDX
			if (lSellerName.get(i).equals("MEDX")) {

				clickMenuMEDX();

				clickBtnSubMenuSalesProduct();

				// Find the "txtProductId" element by visibility
				// Click on the "txtProductId" element
				CommonFunctions.getInstance().actionClearAndSendkeys(txtProductId, lProductIdList.get(i).replace("[", "").replace("]", ""));

				// Wait for the visibility of all elements with the specified text in the title
				CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnApply, timeOut);

				// Click on the "btnApply" element
				CommonFunctions.getInstance().clickElement(btnApply);

				CommonFunctions.getInstance().waitForElementToDisappear(iconLoader, timeOut);

				String xpathListProduct = txtListProduct.replace("option", lProductIdList.get(i).replace("[", "").replace("]", ""));

				List<WebElement> provinceProductList = DriverManager.getInstance().getDriver()
						.findElements(By.xpath(xpathListProduct));

				String xpathProvinceProduct = txtProvinceProduct.replace("option", lProductIdList.get(i).replace("[", "").replace("]", ""));
				int index = 0;
				// Get Index
				for (int k = 0; k < provinceProductList.size(); k++) {

					// status
					int offsetStatus = 9;
					int incrementStaus = 10; // Increment value for each iteration

					String xpathStatusProduct = xpathProvinceProduct.replace("index",
							String.valueOf(k * incrementStaus + offsetStatus));
					// Find the element by visibility using CommonFunctions and store it in elem
					String status = CommonFunctions.getInstance().getText(By.xpath(xpathStatusProduct));

					// province
					int offsetPronvince = 3;
					int incrementPronvince = 10; // Increment value for each iteration

					xpathProvinceProduct = xpathProvinceProduct.replace("index",
							String.valueOf(k * incrementPronvince + offsetPronvince));

					index = k * incrementPronvince + offsetPronvince;

					String province = CommonFunctions.getInstance().getText(By.xpath(xpathProvinceProduct));

					if (status.equals("Đang bán") && province.contains(System.getProperty("regionName"))) {

						xpathProvinceProduct = xpathProvinceProduct.replace("index", String.valueOf(index));

					} else {

						xpathProvinceProduct = xpathProvinceProduct.replace(String.valueOf(index), "index");

					}

				}

				// Find the "txtProvinceProduct" element by visibility
				String province = CommonFunctions.getInstance().getText(By.xpath(xpathProvinceProduct));

				if (province.contains(System.getProperty("regionName"))) {

					String xpathVAT = txtVAT.replace("option", lProductIdList.get(i).replace("[", "").replace("]", ""));

					// Find the "txtVAT" element by visibility
					elem = CommonFunctions.getInstance().findElementByVisibility(By.xpath(xpathVAT));

					// Get VAT
					String vat = elem.getText().trim().replace("%", "");

					String numberCharacterVAT;

					if (vat.contains("-")) {

						numberCharacterVAT = "1";

						String newQrCode = lQrCode.get(i).replace("[numberCharacterVAT]", numberCharacterVAT)
								.replace("[numberVAT]", "0");

						System.out.println(newQrCode);

						lQrCode.set(i,newQrCode);

					} else {

						if (Integer.parseInt(vat) >= 1 && Integer.parseInt(vat) <= 9) {

							numberCharacterVAT = String.valueOf(vat.length());

						} else if (Integer.parseInt(vat) >= 10 && Integer.parseInt(vat) <= 99) {

							numberCharacterVAT = String.valueOf(vat.length());

						} else {

							numberCharacterVAT = String.valueOf(vat.length());
						}

						String newQrCode = lQrCode.get(i).replace("[numberCharacterVAT]", numberCharacterVAT)
								.replace("[numberVAT]", String.format("%d", Integer.parseInt(vat)));

						System.out.println(newQrCode);

						lQrCode.set(i,newQrCode);

					}

					xpathProvinceProduct = xpathProvinceProduct.replace(String.valueOf(index), "index");
				}

			} else {

				Internal_SellerActions.getInstance().clickMenuSeller();

				// Find the "txtProductId" element by visibility
				// Click on the "txtProductId" element
				CommonFunctions.getInstance().actionClearAndSendkeys(txtProductId, lProductIdList.get(i).replace("[", "").replace("]", ""));

				// Wait for the visibility of all elements with the specified text in the title
				CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnApply, timeOut);

				// Click on the "btnApply" element
				CommonFunctions.getInstance().clickElement(btnApply);

				CommonFunctions.getInstance().waitForElementToDisappear(iconLoader, timeOut);

				String xpathVAT = txtVAT.replace("option", lProductIdList.get(i).replace("[", "").replace("]", ""));

				// Find the "txtVAT" element by visibility
				elem = CommonFunctions.getInstance().findElementByVisibility(By.xpath(xpathVAT));

				// Get VAT
				String vat = elem.getText().trim().replace("%", "");

				String numberCharacterVAT;

				if (vat.contains("-")) {

					numberCharacterVAT = "1";

					String newQrCode = lQrCode.get(i).replace("[numberCharacterVAT]", numberCharacterVAT)
							.replace("[numberVAT]", "0");

					System.out.println(newQrCode);

					lQrCode.set(i,newQrCode);

				} else {

					if (vat.length() >= 1 && vat.length() <= 9) {

						numberCharacterVAT = "1";

					} else if (vat.length() >= 10 && vat.length() <= 99) {

						numberCharacterVAT = "2";

					} else {

						numberCharacterVAT = "3";
					}

					String newQrCode = lQrCode.get(i).replace("[numberCharacterVAT]", numberCharacterVAT)
							.replace("[numberVAT]", String.format("%d", Integer.parseInt(vat)));

					System.out.println(newQrCode);

					lQrCode.set(i,newQrCode);

				}
			}

		}

		System.setProperty("qrCode", lQrCode.toString());
		


	}

	public void clickBtnSalesProduct() {

		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnSalesProduct, timeOut);

			elem = CommonFunctions.getInstance().findElementByVisibility(btnSalesProduct);

			elem.click();

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void selectProductCode() {
		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(txtProductCode, timeOut);

			CommonFunctions.getInstance().actionClearAndSendkeys(txtProductCode, System.getProperty("dProductName"));

			String xpathItem = optionItem.replace("option", System.getProperty("dProductName"));

			CommonFunctions.getInstance().clickElement(By.xpath(xpathItem));

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void selectLocationCode() {
		try {

			Thread.sleep(5000);

			if (System.getProperty("lAreaNorth") != null) {
				// Retrieve the lAreaNorth string value from the system properties
				String lAreaNorthString = System.getProperty("lAreaNorth");

				// Remove the square brackets from the string
				lAreaNorthString = lAreaNorthString.substring(1, lAreaNorthString.length() - 1);

				// Split the string using commas as the delimiter and store the values into a
				// List<String>
				List<String> lAreaNorthList = Arrays.asList(lAreaNorthString.split(", "));

				for (String item : lAreaNorthList) {
					if (item.equals(System.getProperty("dProvinceCode"))) {
						// Set the regionName system property to "Miền Bắc"
						System.setProperty("regionName", "Miền Bắc");

						// Print "Miền Bắc"
						System.out.println("Miền Bắc");

						break;
					}
				}
			}

			if (System.getProperty("lAreaSouth") != null) {
				// Retrieve the lAreaSouth string value from the system properties
				String lAreaSouthString = System.getProperty("lAreaSouth");

				// Remove the square brackets from the string
				lAreaSouthString = lAreaSouthString.substring(1, lAreaSouthString.length() - 1);

				// Split the string using commas as the delimiter and store the values into a
				// List<String>
				List<String> lAreaSouthList = Arrays.asList(lAreaSouthString.split(", "));

				for (String item : lAreaSouthList) {
					if (item.equals(System.getProperty("dProvinceCode"))) {
						// Set the regionName system property to "Miền Nam"
						System.setProperty("regionName", "Miền Nam");

						// Print "Miền Nam"
						System.out.println("Miền Nam");
					}
				}
			}

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(txtLocationCode, timeOut);

			CommonFunctions.getInstance().actionClearAndSendkeys(txtLocationCode, System.getProperty("regionName"));

			String xpathItem = optionItem.replace("option", System.getProperty("regionName"));

			CommonFunctions.getInstance().clickElement(By.xpath(xpathItem));

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void sendKeysPrice() {
		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(txtPrice, timeOut);

			Thread.sleep(1000);

			CommonFunctions.getInstance().actionClearAndSendkeys(txtPrice,
					CommonFunctions.getInstance().generateRandomNumeric(4) + "000");

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void clickBtnSave() {
		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnSave, timeOut);

			CommonFunctions.getInstance().clickElement(btnSave);

			CommonFunctions.getInstance().waitForElementToDisappear(txtMsgSuccess, timeOut);

			CommonFunctions.getInstance().waitForElementToDisappear(iconLoader, timeOut);

			CommonFunctions.getInstance().waitForElementToDisappear(iconProgress, timeOut);

			Thread.sleep(3000);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void selectVendor() {
		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(txtVendor, timeOut);

			CommonFunctions.getInstance().actionClearAndSendkeys(txtVendor, System.getProperty("dVentor"));

			String xpathItem = optionItem.replace("option", System.getProperty("dVentor"));

			CommonFunctions.getInstance().clickElement(By.xpath(xpathItem));

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void selectWareHouse(String option) {
		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(txtWarehouse, timeOut);

			CommonFunctions.getInstance().clickElement(txtWarehouse);

			String xpathItem = optionItem.replace("option", option);

			CommonFunctions.getInstance().clickElement(By.xpath(xpathItem));

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void selectFromWareHouse(String option) {
		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(txtFromWarehouse, timeOut);

			CommonFunctions.getInstance().clickElement(txtFromWarehouse);

			String xpathItem = optionItem.replace("option", option);

			CommonFunctions.getInstance().clickElement(By.xpath(xpathItem));

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void clickBtnAddDetailProduct() {
		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnAddDetailProduct, timeOut);

			CommonFunctions.getInstance().clickElement(btnAddDetailProduct);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void sendKeysProductName() {
		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(txtProductName, timeOut);

			CommonFunctions.getInstance().actionClearAndSendkeys(txtProductName, System.getProperty("productId"));

			String xpathItem = optionItem.replace("option", System.getProperty("productId"));

			CommonFunctions.getInstance().clickElement(By.xpath(xpathItem));

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void sendKeysQuantity() {
		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(txtQuantity, timeOut);

			String numerQuantity = "10";

			CommonFunctions.getInstance().actionClearAndSendkeys(txtQuantity, numerQuantity);

			System.setProperty("numerQuantity", numerQuantity);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void getNumberPO() {
		try {

			String numberPO = CommonFunctions.getInstance().getText(txtNumberPO);

			System.setProperty("numberPO", numberPO);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void clickBtnConfirm() {
		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnConfirm, timeOut);

			CommonFunctions.getInstance().clickElement(btnConfirm);

			CommonFunctions.getInstance().waitForElementToDisappear(iconLoader, timeOut);

			CommonFunctions.getInstance().waitForElementToDisappear(iconProgress, timeOut);

			CommonFunctions.getInstance().waitForElementToDisappear(txtMsgSuccess, timeOut);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void clickBtnImportFile() {

		try {

			CommonFunctions.getInstance().clickElement(btnImportFile);

			CommonFunctions.getInstance().waitForElementToDisappear(iconLoader, timeOut);

			CommonFunctions.getInstance().waitForElementToDisappear(iconProgress, timeOut);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void uploadFile() {

		try {

			String img = System.getProperty("user.dir") + "\\src\\test\\resources\\data\\" + "import-quotation.xlsx";

			elem = DriverManager.getInstance().getDriver().findElement(txtFile);

			CommonFunctions.getInstance().uploadImg(elem, img);

			CommonFunctions.getInstance().clickElement(btnConfirmUpload);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void verifySuccess() {

		try {

			String result = CommonFunctions.getInstance().getText(txtUploadSuccess);

			CommonFunctions.getInstance().verifyDataEquals("COMPLETED", result);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}
}
