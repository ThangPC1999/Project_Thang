package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {
	public void clickToElement(WebDriver driver, WebElement element) {
		element.click();
	}
	public void waitForElementVisible (WebDriver driver, WebElement element) {
		explicitWait = new WebDriverWait(driver, timeout);
		explicitWait.until(ExpectedConditions.visibilityOf(element));
	}
	public void senkeyToElement(WebDriver driver, WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}
	public void waitElementClickable (WebDriver driver, WebElement element) {
		explicitWait = new WebDriverWait(driver, timeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public String getTextElement(WebDriver driver, WebElement element) {
		return element.getText();
	}
	
	private long timeout = 30;
	private WebDriverWait explicitWait;

}
