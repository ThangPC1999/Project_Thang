package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import pageObjects.liveGuru.PageGeneratorManager;


public class HomePageObject extends AbstractPage {
	
	private WebDriver driver;
	
	
	public HomePageObject (WebDriver driver) {
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (how = How.XPATH, using = "//div[@class='footer']//a[text()='My Account']")
	private WebElement myAccountLink;

	public void clickToMyAccountLink() {
		waitElementClickable(driver, myAccountLink);
		clickToElement(driver, myAccountLink);
	}


	
	
//	public static final String MY_ACCOUNT_LINK = "//div[@class='footer']//a[text()='My Account']";
}
