package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.GetElementRect;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import pageObjects.liveGuru.PageGeneratorManager;


public class LoginPageObject extends AbstractPage {
		
		private WebDriver driver;
		
		public LoginPageObject (WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
		@FindBy (how = How.XPATH, using = "//span[contains(text(),'Create an Account')]")
		private WebElement createAccountLink;
		
		public void clickToCreateAccountLink() {
			waitElementClickable(driver, createAccountLink);
			clickToElement(driver, createAccountLink);
		}
	
	
//	public static final String CREATE_ACCOUNT_LINK = "//span[contains(text(),'Create an Account')]";

}
