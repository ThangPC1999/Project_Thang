package actions;

import java.text.Normalizer;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
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

public class ThuocSi_HomePageActions {

	private static final By btnAccept = By.xpath(System.getProperty("Home.Popup.Information.Accept.Button"));
	private static final By btnReject = By.xpath(System.getProperty("Home.Popup.Information.Reject.Button"));
	private static final By btnSignIn = By.xpath(System.getProperty("Home.SignIn.Button"));
	private static final By btnRegister = By.xpath(System.getProperty("Home.Register.Button"));
	private static final By btnCheckAgree = By.xpath(System.getProperty("Home.Register.CheckAgree.Button"));
	private static final By btnRegisterAccount = By.xpath(System.getProperty("Home.Register.RegisterAccount.Button"));
	private static final By txtRegisterName = By.xpath(System.getProperty("Home.Register.Name.Input"));
	private static final By txtRegisterPhone = By.xpath(System.getProperty("Home.Register.Phone.Input"));
	private static final By txtRegisterEmail = By.xpath(System.getProperty("Home.Register.Email.Input"));
	private static final By txtRegisterPassword = By.xpath(System.getProperty("Home.Register.Password.Input"));
	private static final By selectProvinceCode = By.xpath(System.getProperty("Home.Register.ProvinceCode.Select"));
	private static final By radioScope = By.xpath(System.getProperty("Home.Register.Scope.Radio"));
	private static final By msgSucess = By.xpath(System.getProperty("Home.Register.Success.Message"));
	private static final By txtSignInUserName = By.xpath(System.getProperty("Home.SignIn.UserName.Input"));
	private static final By txtSignInPassword = By.xpath(System.getProperty("Home.SignIn.Password.Input"));
	private static final By btnSignInAccount = By.xpath(System.getProperty("Home.SignIn.SignIn.Button"));
	private static final By txtProfileName = By.xpath(System.getProperty("Home.ProfileName.Input"));
	private static final By txtRadio = By.xpath(System.getProperty("Home.Register.Scope.Radio.Text"));
	private static String txtItem = System.getProperty("ManageAccount.Account.InforEnterprise.Select.Item");
	private static final By txtSearchInput = By.xpath(System.getProperty("Home.Search.Search.Input"));
	private static final By amountImage = By.xpath(System.getProperty("Home.Search.Product.Image"));
	private static final By productTitle = By.xpath(System.getProperty("Home.Search.Product.Title"));
	private static final By btnClosed = By.xpath(System.getProperty("Home.Popup.Information.Close.Button"));
	private static final By txtQuickOrderSearch = By.xpath(System.getProperty("Home.QuickOder.Search.Input"));
	private static final By iconManageAccount = By.xpath(System.getProperty("Home.SignIn.IconManageAccount.Button"));

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
		private static final ThuocSi_HomePageActions INSTANCE = new ThuocSi_HomePageActions();
	}

	public static ThuocSi_HomePageActions getInstance() {
		return SingletonHelper.INSTANCE;
	}

	public void clickBtnAccept() {

		try {

			CommonFunctions.getInstance().clickElement(btnAccept);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void clickBtnRegister() {

		try {

			elem = CommonFunctions.getInstance().findElementByVisibility(btnRegister);

			elem.click();

			Thread.sleep(1000);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void sendKeysName() {

		try {

			String name = "qcautotest" + CommonFunctions.getInstance().generateRandomNumeric(7);

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(txtRegisterName, timeOut);

			elem = CommonFunctions.getInstance().findElementByVisibility(txtRegisterName);

			CommonFunctions.getInstance().scrollToObject(txtRegisterName, 0);

			elem.sendKeys(name);

			System.setProperty("accountName", name);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void sendKeysPhone() {

		try {

			String phone = "09" + CommonFunctions.getInstance().generateRandomNumeric(8);

			elem = CommonFunctions.getInstance().findElementByVisibility(txtRegisterPhone);

			CommonFunctions.getInstance().scrollToObject(txtRegisterPhone, 0);

			elem.sendKeys(phone);

			System.setProperty("accountPhone", phone);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void sendKeysEmail() {

		try {

			String email = System.getProperty("accountName") + "@gmail.com";

			elem = CommonFunctions.getInstance().findElementByVisibility(txtRegisterEmail);

			CommonFunctions.getInstance().scrollToObject(txtRegisterEmail, 0);

			elem.sendKeys(email);

			System.setProperty("accountEmail", email);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void sendKeysPassword() {

		try {

			String password = System.getProperty("accountEmail");

			elem = CommonFunctions.getInstance().findElementByVisibility(txtRegisterPassword);

			CommonFunctions.getInstance().scrollToObject(txtRegisterPassword, 0);

			elem.sendKeys(password);

			System.setProperty("accountPassword", password);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void selectProvinceCode() {

		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(selectProvinceCode, timeOut);

			CommonFunctions.getInstance().hoverElement(selectProvinceCode);

			CommonFunctions.getInstance().clickElement(selectProvinceCode);

			String xpathItem = txtItem.replaceAll("\\bopt\\b", System.getProperty("dProvinceCode"));

			CommonFunctions.getInstance().selectByVisibileText(selectProvinceCode, System.getProperty("dProvinceCode"));

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

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void chooseRadioScope() {

		try {
			WebDriver driver = getDriver();

			lElems = driver.findElements(radioScope);

			int randomIndex = new Random().nextInt(lElems.size());

			List<WebElement> lElemsRaioText = driver.findElements(txtRadio);

			for (int i = 0; i < 100; i++) {

				if (lElemsRaioText.get(randomIndex).getText().equals("Nha khoa")
						|| lElemsRaioText.get(randomIndex).getText().equals("Nhà thuốc")
						|| lElemsRaioText.get(randomIndex).getText().equals("Quầy thuốc")) {

					randomIndex = 1;

				} else {

					break;
				}

				randomIndex = new Random().nextInt(lElems.size());

			}

			System.out.println(lElemsRaioText.get(randomIndex).getText());

			CommonFunctions.getInstance().scrollToObject(radioScope, randomIndex);

			lElems.get(randomIndex).click();

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void clickCheckAgree() {

		try {

			elem = CommonFunctions.getInstance().findElementByVisibility(btnCheckAgree);

			CommonFunctions.getInstance().scrollToObject(btnCheckAgree, 0);

			elem.click();

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void clickBtnRegisterAccount() {

		try {

			elem = CommonFunctions.getInstance().findElementByVisibility(btnRegisterAccount);

			CommonFunctions.getInstance().scrollToObject(btnRegisterAccount, 0);

			elem.click();

			// Get messsage
			elem = CommonFunctions.getInstance().findElementByVisibility(msgSucess);

			String expectMsg = elem.getText();

			System.setProperty("messageRegister", expectMsg);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void verifyMessageSucess() {

		try {

			CommonFunctions.getInstance().waitForPageLoad(timeOut);

			if (System.getProperty("messageRegister").trim()
					.equals(System.getProperty("msgWarningAccountActive").trim())) {

				CommonFunctions.getInstance().verifyDataEquals(System.getProperty("messageRegister".trim()),
						System.getProperty("msgWarningAccountActive").trim());

			} else if (System.getProperty("messageRegister").trim()
					.equals(System.getProperty("msgWarningAccountActiveV2").trim())) {

				CommonFunctions.getInstance().verifyDataEquals(System.getProperty("messageRegister").trim(),
						System.getProperty("msgWarningAccountActiveV2").trim());

				CommonFunctions.getInstance().goToUrl("https://web.v2-stg.thuocsi.vn/my-account?tab=3");

				CommonFunctions.getInstance().waitForPageLoad(timeOut);

			} else {

				CommonFunctions.getInstance().verifyDataEquals(System.getProperty("messageRegister").trim(),
						System.getProperty("sendVerifyEmailSuccessful").trim());

			}

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void clickBtnSignIn() {

		try {

			CommonFunctions.getInstance().waitForPageLoad(timeOut);

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnSignIn, timeOut);

			elem = CommonFunctions.getInstance().findElementByVisibility(btnSignIn);

			elem.click();

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void clickBtnSignInAccount() {

		try {

			elem = CommonFunctions.getInstance().findElementByVisibility(btnSignInAccount);

			elem.click();

			CommonFunctions.getInstance().waitForPageLoad(timeOut);

			if (CommonFunctions.getInstance().checkElementsByVisibilityWithTimeInput(btnClosed, 10)) {

				CommonFunctions.getInstance().clickElement(btnClosed);

			}

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void sendKeysSignInUserName(String accountPhone) {

		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(txtSignInUserName, timeOut);

			elem = CommonFunctions.getInstance().findElementByVisibility(txtSignInUserName);

			CommonFunctions.getInstance().scrollToObject(txtSignInUserName, 0);

			elem.sendKeys(CommonFunctions.getInstance().getValueSystemProperty(accountPhone));

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void sendKeysSignInPassword(String accountPassword) {

		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(txtSignInPassword, timeOut);

			elem = CommonFunctions.getInstance().findElementByVisibility(txtSignInPassword);

			CommonFunctions.getInstance().scrollToObject(txtSignInPassword, 0);

			elem.sendKeys(CommonFunctions.getInstance().getValueSystemProperty(accountPassword));

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void verifyLoginSuccess() {

		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(txtProfileName, timeOut);

			elem = CommonFunctions.getInstance().findElementByVisibility(txtProfileName);

			String profileName = elem.getText();

			CommonFunctions.getInstance().verifyDataEquals(profileName, System.getProperty("accountName"));

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void verifyDataSearch(String dataSearch) {

		try {

			System.clearProperty("actualTotal");

			if (dataSearch.contains(",")) {

				String dataSearchList[] = dataSearch.toString().trim().split(",");

				for (int i = 0; i < dataSearchList.length; i++) {

					CommonFunctions.getInstance().actionClearAndSendkeys(txtSearchInput, dataSearchList[i]);

					CommonFunctions.getInstance().pressKeys(txtSearchInput, Keys.ENTER);

					CommonFunctions.getInstance().waitForVisibilityOfAllElement(amountImage, timeOut);

					Thread.sleep(2000);

					int totalProductShow = CommonFunctions.getInstance().findElementsByVisibility(amountImage).size();

					if (System.getProperty("actualTotal") != null) {

						CommonFunctions.getInstance().verifyDataEquals(String.valueOf(totalProductShow),
								System.getProperty("actualTotal"));

					} else {

						System.setProperty("actualTotal", String.valueOf(totalProductShow));

					}

					List<WebElement> lElem = CommonFunctions.getInstance().findElementsByVisibility(productTitle);

					for (WebElement elem : lElem) {

						String actualResult = removeDiacriticalMarks(elem.getText()).replaceAll("\\W+", "");

						dataSearchList[i] = dataSearchList[i].replaceAll("\\W+", "");

						dataSearchList[i] = removeDiacriticalMarks(dataSearchList[i]);

						CommonFunctions.getInstance().verifyDataContains(actualResult, dataSearchList[i]);

					}
				}

			} else {

				CommonFunctions.getInstance().sendkeys(txtSearchInput, dataSearch);

				CommonFunctions.getInstance().pressKeys(txtSearchInput, Keys.ENTER);

				CommonFunctions.getInstance().waitForVisibilityOfAllElement(amountImage, timeOut);

				Thread.sleep(2000);

				List<WebElement> lElem = CommonFunctions.getInstance().findElementsByVisibility(productTitle);

				for (WebElement elem : lElem) {

					String actualResult = removeDiacriticalMarks(elem.getText()).replaceAll("\\W+", "");

					dataSearch = removeDiacriticalMarks(dataSearch);

					dataSearch = dataSearch.replaceAll("\\W+", "");

					CommonFunctions.getInstance().verifyDataContains(actualResult, dataSearch);

				}

			}

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void verifyDataQuickOrderSearch(String dataSearch) {

		try {

			System.clearProperty("actualTotal");

			if (dataSearch.contains(",")) {

				String dataSearchList[] = dataSearch.toString().trim().split(",");

				for (int i = 0; i < dataSearchList.length; i++) {

					CommonFunctions.getInstance().waitForVisibilityOfAllElement(txtQuickOrderSearch, 120);

					CommonFunctions.getInstance().actionClearAndSendkeys(txtQuickOrderSearch, dataSearchList[i]);

					CommonFunctions.getInstance().pressKeys(txtQuickOrderSearch, Keys.ENTER);

					CommonFunctions.getInstance().waitForVisibilityOfAllElement(amountImage, timeOut);

					Thread.sleep(2000);

					int totalProductShow = CommonFunctions.getInstance().findElementsByVisibility(amountImage).size();

					if (System.getProperty("actualTotal") != null) {

						CommonFunctions.getInstance().verifyDataEquals(String.valueOf(totalProductShow),
								System.getProperty("actualTotal"));

					} else {

						System.setProperty("actualTotal", String.valueOf(totalProductShow));

					}

					List<WebElement> lElem = CommonFunctions.getInstance().findElementsByVisibility(productTitle);

					for (WebElement elem : lElem) {

						String actualResult = removeDiacriticalMarks(elem.getText()).replaceAll("\\W+", "");

						dataSearchList[i] = dataSearchList[i].replaceAll("\\W+", "");

						dataSearchList[i] = removeDiacriticalMarks(dataSearchList[i]);

						CommonFunctions.getInstance().verifyDataContains(actualResult, dataSearchList[i]);

					}
				}

			} else {

				CommonFunctions.getInstance().waitForVisibilityOfAllElement(txtQuickOrderSearch, 120);

				CommonFunctions.getInstance().actionClearAndSendkeys(txtQuickOrderSearch, dataSearch);

				CommonFunctions.getInstance().pressKeys(txtQuickOrderSearch, Keys.ENTER);

				CommonFunctions.getInstance().waitForVisibilityOfAllElement(amountImage, timeOut);

				Thread.sleep(2000);

				List<WebElement> lElem = CommonFunctions.getInstance().findElementsByVisibility(productTitle);

				for (WebElement elem : lElem) {

					String actualResult = removeDiacriticalMarks(elem.getText()).replaceAll("\\W+", "");

					dataSearch = removeDiacriticalMarks(dataSearch);

					dataSearch = dataSearch.replaceAll("\\W+", "");

					CommonFunctions.getInstance().verifyDataContains(actualResult, dataSearch);

				}

			}

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	private static String removeDiacriticalMarks(String input) {
		String normalized = Normalizer.normalize(input, Normalizer.Form.NFD);
		Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
		return pattern.matcher(normalized).replaceAll("");
	}

	public void clickIconManageAccount() {

		try {

			CommonFunctions.getInstance().clickElement(iconManageAccount);

			CommonFunctions.getInstance().waitForPageLoad(timeOut);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}
}
