package actions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
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

public class ThuocSi_QuickOrderProductPageActions {

	private static final By lTxtProduct = By.xpath(System.getProperty("Home.QuickOder.List.Product"));
	private static String txtWarningProduct = System.getProperty("Home.QuickOder.Product.Warning.Text");
	private static String txtAmmountProduct = System.getProperty("Home.QuickOder.Product.Ammount.Input");
	private static String txtAmmountProductIndex = System.getProperty("Home.QuickOder.Product.OptionAmmount.Input");
	private static String txtPriceProductIndex = System.getProperty("Home.QuickOder.Product.OptionPrice.Input");
	private static String txtPriceProduct = System.getProperty("Home.QuickOder.Product.Price.Input");
	private static final By txtPriceProductV2 = By.xpath(System.getProperty("Home.QuickOder.Product.PriceV2.Input"));
	private static String txtAmmountCart = System.getProperty("Home.QuickOder.Cart.Ammount.Input");
	private static String txtTotalMoneyCart = System.getProperty("Home.QuickOder.Cart.TotalMoney.Input");
	private static final By txtTitle = By.xpath(System.getProperty("Home.QuickOrder.Title"));
	private static final By btnViewCart = By.xpath(System.getProperty("Home.QuickOder.Cart.View.Button"));
	private static final By txtSearch = By.xpath(System.getProperty("Home.QuickOder.Search.Input"));
	private static String txtTagPromotion = System.getProperty("Home.QuickOder.Product.Promotion.Text");
	private static final By menuQuickOrder = By.xpath(System.getProperty("Home.Menu.QuickOrder"));
	private static final By iconProcess = By.xpath(System.getProperty("Icon.Progress"));
	private static final By btnClosed = By.xpath(System.getProperty("Home.QuickOder.Product.Closed.Button"));

	@FindBy(how = How.XPATH, using = "")
	private WebElement elem;
	public static WebDriver driver;

	public static WebDriver getDriver() {
		driver = DriverManager.getInstance().getDriver();
		return driver;
	}

	int timeOut = Integer.parseInt(System.getProperty("objectTimeout"));

	private static class SingletonHelper {
		private static final ThuocSi_QuickOrderProductPageActions INSTANCE = new ThuocSi_QuickOrderProductPageActions();
	}

	public static ThuocSi_QuickOrderProductPageActions getInstance() {
		return SingletonHelper.INSTANCE;
	}

	public void sendKeysAmmount() throws InterruptedException {

//		try {

			// Set list product
			String productName = System.getProperty("dProductName");
			List<String> lProductName = new ArrayList<>();
			List<String> lAmmount = new ArrayList<>();
			String strAmmount = "";

			if (productName.contains(",")) {

				lProductName = Arrays.asList(productName.split(","));
				strAmmount = CommonFunctions.getInstance().generateRandomNumeric(1);

				if (Integer.parseInt(strAmmount) < 5) {

					strAmmount = "10";

				}

			} else {

				lProductName.add(productName);
				strAmmount = CommonFunctions.getInstance().generateRandomNumeric(1);

				if (Integer.parseInt(strAmmount) < 5) {

					strAmmount = "10";

				}

			}

			if (System.getProperty("numerQuantity") != null) {

				strAmmount = System.getProperty("numerQuantity");

			}

			long totalPriceExpect = 0;
			long totalAmmount = 0;

			for (int i = 0; i < lProductName.size(); i++) {

				CommonFunctions.getInstance().waitForVisibilityOfAllElement(txtSearch, timeOut);

				elem = CommonFunctions.getInstance().findElementByVisibility(txtSearch);

				CommonFunctions.getInstance().actionClearAndSendkeys(txtSearch, lProductName.get(i));

				elem.sendKeys(Keys.ENTER);

				CommonFunctions.getInstance().waitForVisibilityOfAllElement(txtTitle, timeOut);

//				String strAmmount = CommonFunctions.getInstance().generateRandomNumeric(2);

				// Get Name Proudct
				productName = lProductName.get(i);

				if (productName.contains("ID")) {

					// Find the last index of "ID "
					int startIndex = productName.lastIndexOf("ID ");

					// Extract the substring starting from the "ID " index
					productName = productName.substring(startIndex);
				}

				// Enters Ammount Buy Product
				// Check Warning Product
				txtWarningProduct = txtWarningProduct.replace("productName", productName);

				if (CommonFunctions.getInstance().checkElementsByVisibilityWithTimeInput(By.xpath(txtWarningProduct),
						5)) {

					String txtWarning = CommonFunctions.getInstance()
							.getText(By.xpath(txtWarningProduct.replace("productName", productName)));

					Pattern pattern = Pattern.compile("\\d+");
					Matcher matcher = pattern.matcher(txtWarning);

					if (matcher.find()) {
						strAmmount = matcher.group();
					}

					// Get xpath input ammount product
					String xpathAmmountProduct = txtAmmountProduct.replace("option", productName);

					elem = CommonFunctions.getInstance().findElementByVisibility(By.xpath(xpathAmmountProduct));

					CommonFunctions.getInstance().actionClearAndSendkeys(By.xpath(xpathAmmountProduct), strAmmount);

					elem.sendKeys(Keys.ENTER);

					strAmmount = elem.getAttribute("value");

					totalAmmount = totalAmmount + Long.parseLong(strAmmount);

					lAmmount.add(strAmmount);

					// Get Price
					String xpathPriceProduct = txtPriceProduct.replace("productName", productName);

					CommonFunctions.getInstance().clickElement(By.xpath(xpathPriceProduct));

					if (CommonFunctions.getInstance().checkElementsByVisibilityWithTimeInput(btnClosed, 10)) {

						CommonFunctions.getInstance().clickElement(btnClosed);

					}

					String strTotalPriceExpect = CommonFunctions.getInstance().getText(txtPriceProductV2);
					// Replace chart "."
					strTotalPriceExpect = strTotalPriceExpect.replace(".", "").replace("đ", "");
					totalPriceExpect = totalPriceExpect
							+ Integer.valueOf(strTotalPriceExpect) * Integer.valueOf(strAmmount);
					System.setProperty("totalPriceExpect", String.valueOf(totalPriceExpect));

					DriverManager.getInstance().getDriver().navigate().back();

					CommonFunctions.getInstance().waitForPageLoad(timeOut);

				} else {

					// Get xpath input ammount product
					String xpathAmmountProduct = txtAmmountProduct.replace("option", productName);

					elem = CommonFunctions.getInstance().findElementByVisibility(By.xpath(xpathAmmountProduct));

					CommonFunctions.getInstance().actionClearAndSendkeys(By.xpath(xpathAmmountProduct), strAmmount);

					elem.sendKeys(Keys.ENTER);

					strAmmount = elem.getAttribute("value");

					totalAmmount = totalAmmount + Long.parseLong(strAmmount);

					lAmmount.add(strAmmount);

					// Get Price
					String xpathPriceProduct = txtPriceProduct.replace("productName", productName);

					CommonFunctions.getInstance().clickElement(By.xpath(xpathPriceProduct));

					if (CommonFunctions.getInstance().checkElementsByVisibility(btnClosed)) {

						CommonFunctions.getInstance().clickElement(btnClosed);

					}

					String strTotalPriceExpect = CommonFunctions.getInstance().getText(txtPriceProductV2);
					// Replace chart "."
					strTotalPriceExpect = strTotalPriceExpect.replace(".", "").replace("đ", "");
					totalPriceExpect = totalPriceExpect
							+ Integer.valueOf(strTotalPriceExpect) * Integer.valueOf(strAmmount);
					System.setProperty("totalPriceExpect", String.valueOf(totalPriceExpect));

					DriverManager.getInstance().getDriver().navigate().back();

					CommonFunctions.getInstance().waitForPageLoad(timeOut);

				}

			}

			System.setProperty("ammountOrder", lAmmount.toString());
			System.setProperty("totalAmmountOder", String.valueOf(totalAmmount));

//		} catch (Exception e) {
//			Assert.fail(e.getMessage());
//		}

	}

	public void verifyCart() {

		try {

			// Wait Cart Update
			String xpathAmmountCart = txtAmmountCart.replace("number", System.getProperty("totalAmmountOder"));

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(By.xpath(xpathAmmountCart), timeOut);

			System.out.println("Price: " + System.getProperty("totalPriceExpect"));

			String totalPriceExpect = CommonFunctions.getInstance()
					.parseStringIntoCurrent(System.getProperty("totalPriceExpect"));

			String xpathTotalPrice = txtTotalMoneyCart.replace("total", totalPriceExpect);

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(By.xpath(xpathTotalPrice), timeOut);

			// Compare
			String actualAmmountCart = DriverManager.getInstance().getDriver().findElement(By.xpath(xpathAmmountCart))
					.getText();

			String actualTotalPriceCart = DriverManager.getInstance().getDriver().findElement(By.xpath(xpathTotalPrice))
					.getText();

			CommonFunctions.getInstance().verifyDataEquals(actualAmmountCart, System.getProperty("totalAmmountOder"));

			CommonFunctions.getInstance().verifyDataEquals(actualTotalPriceCart,
					CommonFunctions.getInstance().parseStringIntoCurrent(System.getProperty("totalPriceExpect")));

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void clickBtnViewCart() {

		try {

			elem = CommonFunctions.getInstance().findElementByVisibility(btnViewCart);

			elem.click();

			CommonFunctions.getInstance().waitForElementToDisappear(iconProcess, timeOut);

			Thread.sleep(3000);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void sendKeysProductName(String productName) {

		try {

			productName = CommonFunctions.getInstance().getValueSystemProperty(productName);

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(txtSearch, timeOut);

			elem = CommonFunctions.getInstance().findElementByVisibility(txtSearch);

			CommonFunctions.getInstance().actionClearAndSendkeys(txtSearch, productName);

			elem.sendKeys(Keys.ENTER);

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(txtTitle, timeOut);

			System.setProperty("productName", productName);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void sendKeysAmmountWithProductName(int ammount, String productName) {

		try {

			long totalPriceExpect = 0;
			long totalAmmount = 0;

			String strAmmount = String.valueOf(ammount);
			String xpathAmmountProduct = "";
			String xpathPriceProduct = "";
			String strTotalPriceExpect = "";
			
			// Get Name Proudct
			if (productName.contains("ID")) {

				// Find the last index of "ID "
				int startIndex = productName.lastIndexOf("ID ");

				// Extract the substring starting from the "ID " index
				productName = productName.substring(startIndex);

				xpathAmmountProduct = txtAmmountProduct.replace("option", productName);

			} else {

				xpathAmmountProduct = txtAmmountProduct.replace("option", productName);

			}

			// Enters Ammount Buy Product

			CommonFunctions.getInstance().actionClearAndSendkeys(By.xpath(xpathAmmountProduct), strAmmount);

			CommonFunctions.getInstance().pressKeys(By.xpath(xpathAmmountProduct), Keys.ENTER);

			strAmmount = CommonFunctions.getInstance().getAttribute(By.xpath(xpathAmmountProduct), "value");

			if (System.getProperty("totalAmmountOder") != null) {

				totalAmmount = Long.parseLong(System.getProperty("totalAmmountOder")) + Long.parseLong(strAmmount);

			} else {

				totalAmmount = totalAmmount + Long.parseLong(strAmmount);

			}

			// Get Price
			xpathPriceProduct = txtPriceProduct.replace("productName", productName);

			CommonFunctions.getInstance().clickElement(By.xpath(xpathPriceProduct));

			if (CommonFunctions.getInstance().checkElementsByVisibilityWithTimeInput(btnClosed, 10)) {

				CommonFunctions.getInstance().clickElement(btnClosed);

			}

			strTotalPriceExpect = CommonFunctions.getInstance().getText(txtPriceProductV2);
			
			// Replace chart "."
			strTotalPriceExpect = strTotalPriceExpect.replace(".", "").replace("đ", "");

			if (System.getProperty("totalPriceExpect") != null) {

				totalPriceExpect = Long.parseLong(System.getProperty("totalPriceExpect"))
						+ Long.parseLong(strTotalPriceExpect) * Long.parseLong(strAmmount);

			} else {

				totalPriceExpect = totalPriceExpect + Long.parseLong(strTotalPriceExpect) * Long.parseLong(strAmmount);

			}

			System.setProperty("totalPriceExpect", String.valueOf(totalPriceExpect));

			System.setProperty("ammountOrder", strAmmount);
			System.setProperty("totalAmmountOder", String.valueOf(totalAmmount));
			
			DriverManager.getInstance().getDriver().navigate().back();

			CommonFunctions.getInstance().waitForPageLoad(timeOut);

		} catch (

		Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void sendKeysAmmountRandomProductName(int ammount) throws InterruptedException {

		if (!CommonFunctions.getInstance().checkElementsByVisibilityWithTimeInput(lTxtProduct, 2)) {

			CommonFunctions.getInstance().clickElement(menuQuickOrder);

		}

		String xpathAmmountProduct = "";
		String xpathPriceProduct = "";
		String strTotalPriceExpect = "";

		Thread.sleep(3000);

		// Get Product
		List<WebElement> lProductName = DriverManager.getInstance().getDriver().findElements(lTxtProduct);

		int index = new Random().nextInt(lProductName.size());

//		int index = 2;

		System.out.println("Index: " + index);

		String productName = CommonFunctions.getInstance().getTextByIndex(lTxtProduct, index);

		String xpathIsCheckPromotion = txtTagPromotion.replace("option", productName);

		if (System.getProperty("productName") != null) {

			if (!CommonFunctions.getInstance().checkElementsByVisibilityWithTimeInput(By.xpath(xpathIsCheckPromotion),
					5) && !productName.contains(System.getProperty("productName"))) {

				// Get Name Proudct
				if (productName.contains("ID")) {

					// Find the last index of "ID "
					int startIndex = productName.lastIndexOf("ID ");

					// Extract the substring starting from the "ID " index
					productName = productName.substring(startIndex);

					xpathAmmountProduct = txtAmmountProduct.replace("option", productName);

					// Get Price
					xpathPriceProduct = txtPriceProduct.replace("productName", productName);

					CommonFunctions.getInstance().clickElement(By.xpath(xpathPriceProduct));

					if (CommonFunctions.getInstance().checkElementsByVisibilityWithTimeInput(btnClosed, 10)) {

						CommonFunctions.getInstance().clickElement(btnClosed);

					}

					strTotalPriceExpect = CommonFunctions.getInstance().getText(txtPriceProductV2);

					// Replace chart "."
					strTotalPriceExpect = strTotalPriceExpect.replace(".", "").replace("đ", "");

					DriverManager.getInstance().getDriver().navigate().back();

					CommonFunctions.getInstance().waitForPageLoad(timeOut);

				} else {

					xpathAmmountProduct = txtAmmountProductIndex.replace("index", String.valueOf(index + 1));

					// Get Price
					xpathPriceProduct = txtPriceProductIndex.replace("index", String.valueOf(index + 1));

					CommonFunctions.getInstance().clickElement(By.xpath(xpathPriceProduct));

					if (CommonFunctions.getInstance().checkElementsByVisibilityWithTimeInput(btnClosed, 10)) {

						CommonFunctions.getInstance().clickElement(btnClosed);

					}

					strTotalPriceExpect = CommonFunctions.getInstance().getText(txtPriceProductV2);

					// Replace chart "."
					strTotalPriceExpect = strTotalPriceExpect.replace(".", "").replace("đ", "");

					DriverManager.getInstance().getDriver().navigate().back();

					CommonFunctions.getInstance().waitForPageLoad(timeOut);

				}

				long totalPriceExpect = 0;
				long totalAmmount = 0;

				String strAmmount = String.valueOf(ammount);

				// Enters Ammount Buy Product

				CommonFunctions.getInstance().actionClearAndSendkeys(By.xpath(xpathAmmountProduct), strAmmount);

				CommonFunctions.getInstance().pressKeys(By.xpath(xpathAmmountProduct), Keys.ENTER);

				strAmmount = CommonFunctions.getInstance().getAttribute(By.xpath(xpathAmmountProduct), "value");

				if (System.getProperty("totalAmmountOder") != null) {

					totalAmmount = Long.parseLong(System.getProperty("totalAmmountOder")) + Long.parseLong(strAmmount);

				} else {

					totalAmmount = totalAmmount + Long.parseLong(strAmmount);

				}

				if (System.getProperty("totalPriceExpect") != null) {

					totalPriceExpect = Long.parseLong(System.getProperty("totalPriceExpect"))
							+ Long.parseLong(strTotalPriceExpect) * Long.parseLong(strAmmount);

				} else {

					totalPriceExpect = totalPriceExpect
							+ Long.parseLong(strTotalPriceExpect) * Long.parseLong(strAmmount);

				}

				System.setProperty("totalPriceExpect", String.valueOf(totalPriceExpect));

				System.setProperty("ammountOrder", strAmmount);
				System.setProperty("totalAmmountOder", String.valueOf(totalAmmount));

//				break;

			}

		} else {

			if (!CommonFunctions.getInstance().checkElementsByVisibilityWithTimeInput(By.xpath(xpathIsCheckPromotion),
					5)) {

				// Get Name Proudct
				if (productName.contains("ID")) {

					// Find the last index of "ID "
					int startIndex = productName.lastIndexOf("ID ");

					// Extract the substring starting from the "ID " index
					productName = productName.substring(startIndex);

					xpathAmmountProduct = txtAmmountProduct.replace("option", productName);

					// Get Price
					xpathPriceProduct = txtPriceProduct.replace("productName", productName);

					CommonFunctions.getInstance().clickElement(By.xpath(xpathPriceProduct));

					if (CommonFunctions.getInstance().checkElementsByVisibilityWithTimeInput(btnClosed, 10)) {

						CommonFunctions.getInstance().clickElement(btnClosed);

					}

					strTotalPriceExpect = CommonFunctions.getInstance().getText(txtPriceProductV2);
					// Replace chart "."
					strTotalPriceExpect = strTotalPriceExpect.replace(".", "").replace("đ", "");

					DriverManager.getInstance().getDriver().navigate().back();

					CommonFunctions.getInstance().waitForPageLoad(timeOut);

				} else {

					xpathAmmountProduct = txtAmmountProductIndex.replace("index", String.valueOf(index + 1));

					// Get Price
					xpathPriceProduct = txtPriceProductIndex.replace("index", String.valueOf(index + 1));

					CommonFunctions.getInstance().clickElement(By.xpath(xpathPriceProduct));

					if (CommonFunctions.getInstance().checkElementsByVisibilityWithTimeInput(btnClosed, 10)) {

						CommonFunctions.getInstance().clickElement(btnClosed);

					}

					strTotalPriceExpect = CommonFunctions.getInstance().getText(txtPriceProductV2);

					// Replace chart "."
					strTotalPriceExpect = strTotalPriceExpect.replace(".", "").replace("đ", "");

					DriverManager.getInstance().getDriver().navigate().back();

					CommonFunctions.getInstance().waitForPageLoad(timeOut);

				}

				long totalPriceExpect = 0;
				long totalAmmount = 0;

				String strAmmount = String.valueOf(ammount);

				// Enters Ammount Buy Product

				CommonFunctions.getInstance().actionClearAndSendkeys(By.xpath(xpathAmmountProduct), strAmmount);

				CommonFunctions.getInstance().pressKeys(By.xpath(xpathAmmountProduct), Keys.ENTER);

				strAmmount = CommonFunctions.getInstance().getAttribute(By.xpath(xpathAmmountProduct), "value");

				if (System.getProperty("totalAmmountOder") != null) {

					totalAmmount = Long.parseLong(System.getProperty("totalAmmountOder")) + Long.parseLong(strAmmount);

				} else {

					totalAmmount = totalAmmount + Long.parseLong(strAmmount);

				}

				if (System.getProperty("totalPriceExpect") != null) {

					totalPriceExpect = Long.parseLong(System.getProperty("totalPriceExpect"))
							+ Integer.valueOf(strTotalPriceExpect) * Integer.valueOf(strAmmount);

				} else {

					totalPriceExpect = totalPriceExpect
							+ Long.parseLong(strTotalPriceExpect) * Long.parseLong(strAmmount);

				}

				System.setProperty("totalPriceExpect", String.valueOf(totalPriceExpect));

				System.setProperty("ammountOrder", strAmmount);
				System.setProperty("totalAmmountOder", String.valueOf(totalAmmount));

//				break;

			}

		}

	}

}
