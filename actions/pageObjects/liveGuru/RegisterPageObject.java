package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.liveGuru.RegisterPageUI;

public class RegisterPageObject extends AbstractPage {

	private WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public MyDashboardPageObject clickToRegisterButton() {
		waitElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
		return PageGeneratorManager.getMyDashBoardPage(driver);

	}

	public String getRequiredErrorMessageAtFirstnameTextbox() {
		waitElementClickable(driver, RegisterPageUI.REQUIRED_ERROR_MASSAGE_FIRSTNAME_TEXTBOX);
		return getTextElement(driver, RegisterPageUI.REQUIRED_ERROR_MASSAGE_FIRSTNAME_TEXTBOX);
	}

	public String getRequiredErrorMessageAtLastnameTextbox() {
		waitElementClickable(driver, RegisterPageUI.REQUIRED_ERROR_MASSAGE_LASTNAME_TEXTBOX);
		return getTextElement(driver, RegisterPageUI.REQUIRED_ERROR_MASSAGE_LASTNAME_TEXTBOX);
	}

	public String getRequiredErrorMessageAtEmailTextbox() {
		waitElementClickable(driver, RegisterPageUI.REQUIRED_ERROR_MASSAGE_EMAIL_TEXTBOX);
		return getTextElement(driver, RegisterPageUI.REQUIRED_ERROR_MASSAGE_EMAIL_TEXTBOX);
	}

	public String getRequiredErrorMessageAtPasswordTextbox() {
		waitElementClickable(driver, RegisterPageUI.REQUIRED_ERROR_MASSAGE_PASSWORD_TEXTBOX);
		return getTextElement(driver, RegisterPageUI.REQUIRED_ERROR_MASSAGE_PASSWORD_TEXTBOX);
	}

	public String getRequiredErrorMessageAtConfirmPasswordTextbox() {
		waitElementClickable(driver, RegisterPageUI.REQUIRED_ERROR_MASSAGE_CONFIRM_PASSWORD_TEXTBOX);
		return getTextElement(driver, RegisterPageUI.REQUIRED_ERROR_MASSAGE_CONFIRM_PASSWORD_TEXTBOX);
	}

	public void inputToEmailTextbox(String emailValue) {
		waitElementClickable(driver, RegisterPageUI.EMAIL_TEXTBOX);
		senkeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, emailValue);

	}

	public String getInvalidErrorMessageAtEmailTextbox() {
		waitElementClickable(driver, RegisterPageUI.INVALID_ERROR_MASSAGE_EMAIL_TEXTBOX);
		return getTextElement(driver, RegisterPageUI.INVALID_ERROR_MASSAGE_EMAIL_TEXTBOX);
	}

	public void inputToPassword(String passwordValue) {
		waitElementClickable(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		senkeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, passwordValue);

	}

	public String getInvalidErrorMessageAtPasswordTextbox() {
		waitElementClickable(driver, RegisterPageUI.INVALID_ERROR_MASSAGE_PASSWORD_TEXTBOX);
		return getTextElement(driver, RegisterPageUI.INVALID_ERROR_MASSAGE_PASSWORD_TEXTBOX);
	}

	public void inputToConfirmPassword(String confirmPasswordValue) {
		waitElementClickable(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		senkeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPasswordValue);

	}

	public String getInvalidErrorMessageAtConfirmPasswordTextbox() {
		waitElementClickable(driver, RegisterPageUI.INVALID_ERROR_MASSAGE_CONFIRM_PASSWORD_TEXTBOX);
		return getTextElement(driver, RegisterPageUI.INVALID_ERROR_MASSAGE_CONFIRM_PASSWORD_TEXTBOX);
	}

	public void inputToFirstnameTextbox(String firstNameValue) {
		waitElementClickable(driver, RegisterPageUI.FIRST_NAME_TEXTBOX);
		senkeyToElement(driver, RegisterPageUI.FIRST_NAME_TEXTBOX, firstNameValue);

	}
	
	public void inputToLastnameTextbox(String lastNameValue) {
		waitElementClickable(driver, RegisterPageUI.LAST_NAME_TEXTBOX);
		senkeyToElement(driver, RegisterPageUI.LAST_NAME_TEXTBOX, lastNameValue);
		// TODO Auto-generated method stub

	}

}
