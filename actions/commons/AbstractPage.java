package commons;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.liveGuru.AboutUsPageObject;
import pageObjects.liveGuru.ContactUsPageObject;
import pageObjects.liveGuru.CustomerServicePageObject;
import pageObjects.liveGuru.OrderAndReturnPageObject;
import pageObjects.liveGuru.PageGeneratorManager;
import pageObjects.liveGuru.PrivacyPolicyPageObject;
import pageObjects.liveGuru.SiteMapPageObject;
import pageUIs.liveGuru.AbstractPageUI;

public abstract class AbstractPage {
	// Global
	// WebDriver driver;

	// 1 - Set access modifier là public hết
	// 2 - Tên hàm: Lowercase
	// 3 - Tham số của hàm(Param)
	// 4 - Kiểu trả về (Return type)
	// 5 - Sử dụng biến toàn cục(dùng lại nhiều lần\ cục bộ(dùng 1 lần)

	public void openPageURL(WebDriver driver, String pageURL) {
		driver.get(pageURL);
	}

	public void setEmplicitWait(WebDriver driver, long timeout) {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getPageURL(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}

	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public void fowardToPage(WebDriver driver) {
		driver.navigate().forward();
	}

	public void accessAlert(WebDriver driver) {
		waitForAlertPresence(driver);
		alert = driver.switchTo().alert();
		alert.accept();
	}

	public void cancelAlert(WebDriver driver) {
		waitForAlertPresence(driver);
		alert = driver.switchTo().alert();
		alert.dismiss();
	}

	public String getAlertText(WebDriver driver) {
		waitForAlertPresence(driver);
		alert = driver.switchTo().alert();
		return alert.getText();
	}

	public void sendkeyToAlert(WebDriver driver, String text) {
		waitForAlertPresence(driver);
		alert = driver.switchTo().alert();
		alert.sendKeys(text);
	}

	public void switchToWindowByID(WebDriver driver, String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindow : allWindows) {
			if (!runWindow.equals(parentID)) {
				driver.switchTo().window(runWindow);
				break;
			}
		}
	}

	public void switchToWindowByTitle(WebDriver driver, String title) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			driver.switchTo().window(runWindows);
			String currentWin = driver.getTitle();
			if (currentWin.equals(title)) {
				break;
			}
		}
	}

	public void closeAllWindowsWithoutParent(WebDriver driver, String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			if (!runWindows.equals(parentID)) {
				driver.switchTo().window(runWindows);
				driver.close();
			}
		}
		driver.switchTo().window(parentID);
	}

	public WebElement find(WebDriver driver, String locator) {
		return driver.findElement(By.xpath(locator));
	}

	public List<WebElement> finds(WebDriver driver, String locator) {
		return driver.findElements(By.xpath(locator));
	}

	public By byXpath(String locator) {
		return By.xpath(locator);
	}

	public void clickToElement(WebDriver driver, String locator) {
		find(driver, locator).click();
	}

	public void clickToElement(WebDriver driver, String locator, String... values) {
		find(driver, castToObject(locator, values)).click();
	}

	public void senkeyToElement(WebDriver driver, String locator, String text) {
		element = find(driver, locator);
		element.clear();
		element.sendKeys(text);
	}

	public void senkeyToElement(WebDriver driver, String locator, String value, String text) {
		element = find(driver, castToObject(locator, value));
		element.clear();
		element.sendKeys(text);
	}

	public void selectIteamInDropdown(WebDriver driver, String locator, String iteamValue) {
		select = new Select(find(driver, locator));
		select.selectByVisibleText(iteamValue);
	}

	public String getSelectedInDropdown(WebDriver driver, String locator) {
		select = new Select(find(driver, locator));
		return select.getFirstSelectedOption().getText();
	}

	public boolean isDropdownMultiple(WebDriver driver, String locator) {
		select = new Select(find(driver, locator));
		return select.isMultiple();
	}

	public void sleepInSecond(long time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator,
			String expectedItem) {
		find(driver, parentLocator).click();
		sleepInSecond(1);

		explicitWait = new WebDriverWait(driver, timeout);
		List<WebElement> allItems = explicitWait
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(byXpath(childItemLocator)));

		for (WebElement item : allItems) {
			if (item.getText().trim().equals(expectedItem)) {
				jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
				sleepInSecond(1);

				item.click();
				sleepInSecond(1);
				break;
			}
		}
	}

	public String getElementAttribute(WebDriver driver, String locator, String Attribute) {
		return find(driver, locator).getAttribute(Attribute);
	}

	public String getTextElement(WebDriver driver, String locator) {
		return find(driver, locator).getText();
	}

	public int countElementNumber(WebDriver driver, String locator) {
		return finds(driver, locator).size();
	}
	public int countElementNumber(WebDriver driver, String locator, String value) {
		return finds(driver, castToObject(locator, value)).size();
	}

	public void checkToCheckBox(WebDriver driver, String locator) {
		element = find(driver, locator);
		if (!element.isSelected()) {
			element.click();
		}
	}

	public void uncheckToCheckBox(WebDriver driver, String locator) {
		element = find(driver, locator);
		if (element.isSelected()) {
			element.click();
		}
	}

	public boolean isElementDisplayed(WebDriver driver, String locator) {
		return find(driver, locator).isDisplayed();
	}

	public boolean isElementDisplayed(WebDriver driver, String locator, String... values) {
		return find(driver, castToObject(locator, values)).isDisplayed();
	}

	public boolean isElementSelected(WebDriver driver, String locator) {
		return find(driver, locator).isSelected();
	}

	public boolean isElementEnabled(WebDriver driver, String locator) {
		return find(driver, locator).isEnabled();
	}

	public void switchToFrameOrIframe(WebDriver driver, String locator) {
		driver.switchTo().frame(find(driver, locator));
	}

	public void switchToDefaulContent(WebDriver driver, String locator) {
		driver.switchTo().defaultContent();
	}

	public void hoverToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.moveToElement(find(driver, locator)).perform();
	}

	public void senkeyBoardToElement(WebDriver driver, String locator, Keys key) {
		action = new Actions(driver);
		action.sendKeys(find(driver, locator), key).perform();
	}
	public void senkeyBoardToElement(WebDriver driver, String locator, String value, Keys key) {
		action = new Actions(driver);
		action.sendKeys(find(driver, castToObject(locator, value)), key).perform();
	}

	public Object executeForBrowser(WebDriver driver, String javaScript) {
		jsExecutor = (JavascriptExecutor) driver;
		return jsExecutor.executeScript(javaScript);
	}

	public String getInnerText(WebDriver driver) {
		jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return document.documentElement.innerText;");
	}

	public boolean areExpectedTextInInnerText(WebDriver driver, String textExpected) {
		jsExecutor = (JavascriptExecutor) driver;
		String textActual = (String) jsExecutor
				.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0]");
		return textActual.equals(textExpected);
	}

	public void scrollToBottomPage(WebDriver driver) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void navigateToUrlByJS(WebDriver driver, String url) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.location = '" + url + "'");
	}

	public void highlightElement(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		WebElement element = find(driver, locator);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				"border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", find(driver, locator));
	}

	public void scrollToElement(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", find(driver, locator));
	}

	public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", find(driver, locator));
	}

	public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", find(driver, locator));
	}

	public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
		explicitWait = new WebDriverWait(driver, timeout);
		jsExecutor = (JavascriptExecutor) driver;

		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};

		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

	public String getElementValidationMessage(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", find(driver, locator));
	}

	public boolean isImageLoaded(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				find(driver, locator));
		if (status) {
			return true;
		} else {
			return false;
		}
	}

	public void waitForElementPresent(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, timeout);
		explicitWait.until(ExpectedConditions.presenceOfElementLocated(byXpath(locator)));
	}

	public void waitForElementVisible(WebDriver driver, String locator, String... values) {
		explicitWait = new WebDriverWait(driver, timeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(byXpath(castToObject(locator, values))));
	}

	public void waitForElementInvisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, timeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(byXpath(locator)));
	}

	public void waitElementClickable(WebDriver driver, String locator, String... values) {
		explicitWait = new WebDriverWait(driver, timeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(byXpath(castToObject(locator, values))));
	}

	public void waitForAlertPresence(WebDriver driver) {
		explicitWait = new WebDriverWait(driver, timeout);
		explicitWait.until(ExpectedConditions.alertIsPresent());
	}

	public AboutUsPageObject clickToAboutUsMenu(WebDriver driver) {
		waitForElementVisible(driver, AbstractPageUI.ABOUT_US_LINK);
		clickToElement(driver, AbstractPageUI.ABOUT_US_LINK);
		return PageGeneratorManager.getAboutUsPage(driver);

	}

	public ContactUsPageObject clickToContactUsMenu(WebDriver driver) {
		waitForElementVisible(driver, AbstractPageUI.CONTACT_US_LINK);
		clickToElement(driver, AbstractPageUI.CONTACT_US_LINK);
		return PageGeneratorManager.getContactUsPage(driver);

	}

	public CustomerServicePageObject clickToCSMenu(WebDriver driver) {
		waitForElementVisible(driver, AbstractPageUI.CUSTOMER_SERVICE_LINK);
		clickToElement(driver, AbstractPageUI.CUSTOMER_SERVICE_LINK);
		return PageGeneratorManager.getCustomerServicePage(driver);

	}

	public PrivacyPolicyPageObject clickToPrivacyPolicyMenu(WebDriver driver) {
		waitForElementVisible(driver, AbstractPageUI.PRIVATE_POLOCY_LINK);
		clickToElement(driver, AbstractPageUI.PRIVATE_POLOCY_LINK);
		return PageGeneratorManager.getPrivacyPolicyPage(driver);

	}

	public SiteMapPageObject clickToSiteMapMenu(WebDriver driver) {
		waitForElementVisible(driver, AbstractPageUI.SITE_MAP_LINK);
		clickToElement(driver, AbstractPageUI.SITE_MAP_LINK);
		return PageGeneratorManager.getSiteMapPage(driver);

	}

	public OrderAndReturnPageObject clickToOrderAndReturnMenu(WebDriver driver) {
		waitForElementVisible(driver, AbstractPageUI.ORDER_AND_RETURN_LINK);
		clickToElement(driver, AbstractPageUI.ORDER_AND_RETURN_LINK);
		return PageGeneratorManager.getOrderAndReturnPage(driver);

	}

	public AbstractPage clickToDynamicLessPageMenu(WebDriver driver, String pageName) {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_LINK, pageName);
		clickToElement(driver, AbstractPageUI.DYNAMIC_LINK, pageName);

		if (pageName.equals("About Us")) {
			return PageGeneratorManager.getAboutUsPage(driver);
		} else if (pageName.equals("Contact Us")) {
			return PageGeneratorManager.getContactUsPage(driver);
		} else if (pageName.equals("Contact Us")) {
			return PageGeneratorManager.getContactUsPage(driver);
		} else if (pageName.equals("Customer Service")) {
			return PageGeneratorManager.getCustomerServicePage(driver);
		} else if (pageName.equals("Privacy Policy")) {
			return PageGeneratorManager.getPrivacyPolicyPage(driver);
		} else if (pageName.equals("Site Map")) {
			return PageGeneratorManager.getSiteMapPage(driver);
		} else if (pageName.equals("Site Map")) {
			return PageGeneratorManager.getSiteMapPage(driver);
		} else {
			return PageGeneratorManager.getOrderAndReturnPage(driver);
		}
	}

	public void clickToDynamicMorePageMenu(WebDriver driver, String pageName) {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_LINK, pageName);
		clickToElement(driver, AbstractPageUI.DYNAMIC_LINK, pageName);

	}

	public String castToObject(String locator, String... valueName) {
		return locator = String.format(locator, (Object[]) valueName);
	}

	private long timeout = 30;
	private List<WebElement> elements;
	private Alert alert;
	private WebElement element;
	private Select select;
	private JavascriptExecutor jsExecutor;
	private WebDriverWait explicitWait;
	private Actions action;
}
