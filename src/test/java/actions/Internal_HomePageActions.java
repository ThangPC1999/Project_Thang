package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import base.driver.DriverManager;
import utilities.CommonFunctions;

public class Internal_HomePageActions {

	private static final By btnMenu = By.xpath(System.getProperty("Internal.Home.Menu.Button"));
	private static final By btnMenuCRM = By.xpath(System.getProperty("Internal.Home.Menu.CRM.Button"));
	private static final By btnMenuCMS = By.xpath(System.getProperty("Internal.Home.Menu.CMS.Button"));
	private static final By titleProduct = By.xpath(System.getProperty("Internal.Home.Product.Title"));
	private static final By iconLoader = By.xpath(System.getProperty("Icon.Loader"));
	private static final By iconProgress = By.xpath(System.getProperty("Icon.Progress"));
	public static WebDriver driver;

	public static WebDriver getDriver() {

		driver = DriverManager.getInstance().getDriver();
		return driver;
	}

	@FindBy(how = How.XPATH, using = "")
	private WebElement elem;

	int timeOut = Integer.parseInt(System.getProperty("objectTimeout"));

	private static class SingletonHelper {
		private static final Internal_HomePageActions INSTANCE = new Internal_HomePageActions();
	}

	public static Internal_HomePageActions getInstance() {
		return SingletonHelper.INSTANCE;
	}

	public void clickBtnCRMMenu() {

		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnMenu, timeOut);

			elem = CommonFunctions.getInstance().findElementByVisibility(btnMenu);

			elem.click();

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnMenuCRM, timeOut);

			elem = CommonFunctions.getInstance().findElementByVisibility(btnMenuCRM);

			elem.click();

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void clickBtnCMSMenu() {

		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnMenu, timeOut);
			
			CommonFunctions.getInstance().scrollToObject(btnMenu, 0);

			elem = CommonFunctions.getInstance().findElementByVisibility(btnMenu);
			
			CommonFunctions.getInstance().clickByJavascript(elem);

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnMenuCMS, timeOut);

			elem = CommonFunctions.getInstance().findElementByVisibility(btnMenuCMS);

			CommonFunctions.getInstance().clickByJavascript(elem);

			CommonFunctions.getInstance().waitForPageLoad(Integer.parseInt(System.getProperty("objectTimeout")));
			
			if(CommonFunctions.getInstance().checkElementsByVisibilityWithTimeInput(titleProduct, 5)) {
				
				CommonFunctions.getInstance().clickElement(titleProduct);
				
				CommonFunctions.getInstance().waitForElementToDisappear(iconLoader, timeOut);
				
				CommonFunctions.getInstance().waitForElementToDisappear(iconProgress, timeOut);
				
			}
			

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

}
