package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.liveGuru.LoginPageUI;

public class LoginPageObject extends AbstractPage {
	
	private WebDriver driver;
	
	public LoginPageObject (WebDriver driver) {
		this.driver = driver;
	}
	public RegisterPageObject clickToCreateAccountLink() {
		waitElementClickable(driver, LoginPageUI.CREATE_ACCOUNT_LINK);
		clickToElement(driver, LoginPageUI.CREATE_ACCOUNT_LINK);
		return PageGeneratorManager.getRegisterPage(driver);
	}

}
