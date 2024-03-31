package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import pageObjects.liveGuru.PageGeneratorManager;


public class RegisterPageObject extends AbstractPage {
	private WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Register')]")
	private WebElement registerButton;
	
	@FindBy(how = How.ID_OR_NAME, using = "firstname")
	private WebElement firstNameTextbox;
	
	@FindBy(how = How.ID_OR_NAME, using = "lastname")
	private WebElement lastNameTextbox;
	
	@FindBy(how = How.ID_OR_NAME, using = "email_address")
	private WebElement emailTextbox;

	@FindBy(how = How.ID_OR_NAME, using = "password")
	private WebElement passwordTextbox;
	
	@FindBy(how = How.ID_OR_NAME, using = "confirmation")
	private WebElement confirmPasswordTextbox;

	public void clickToRegisterButton() {
		waitElementClickable(driver, registerButton);
		clickToElement(driver, registerButton);

	}

//	public String getRequiredErrorMessageAtFirstnameTextbox() {
//		waitElementClickable(driver, RegisterPageUI.REQUIRED_ERROR_MASSAGE_FIRSTNAME_TEXTBOX);
//		return getTextElement(driver, RegisterPageUI.REQUIRED_ERROR_MASSAGE_FIRSTNAME_TEXTBOX);
//	}
//
//	public String getRequiredErrorMessageAtLastnameTextbox() {
//		waitElementClickable(driver, RegisterPageUI.REQUIRED_ERROR_MASSAGE_LASTNAME_TEXTBOX);
//		return getTextElement(driver, RegisterPageUI.REQUIRED_ERROR_MASSAGE_LASTNAME_TEXTBOX);
//	}
//
//	public String getRequiredErrorMessageAtEmailTextbox() {
//		waitElementClickable(driver, RegisterPageUI.REQUIRED_ERROR_MASSAGE_EMAIL_TEXTBOX);
//		return getTextElement(driver, RegisterPageUI.REQUIRED_ERROR_MASSAGE_EMAIL_TEXTBOX);
//	}
//
//	public String getRequiredErrorMessageAtPasswordTextbox() {
//		waitElementClickable(driver, RegisterPageUI.REQUIRED_ERROR_MASSAGE_PASSWORD_TEXTBOX);
//		return getTextElement(driver, RegisterPageUI.REQUIRED_ERROR_MASSAGE_PASSWORD_TEXTBOX);
//	}
//
//	public String getRequiredErrorMessageAtConfirmPasswordTextbox() {
//		waitElementClickable(driver, RegisterPageUI.REQUIRED_ERROR_MASSAGE_CONFIRM_PASSWORD_TEXTBOX);
//		return getTextElement(driver, RegisterPageUI.REQUIRED_ERROR_MASSAGE_CONFIRM_PASSWORD_TEXTBOX);
//	}

	public void inputToEmailTextbox(String emailValue) {
		waitElementClickable(driver, emailTextbox);
		senkeyToElement(driver, emailTextbox, emailValue);

	}

//	public String getInvalidErrorMessageAtEmailTextbox() {
//		waitElementClickable(driver, RegisterPageUI.INVALID_ERROR_MASSAGE_EMAIL_TEXTBOX);
//		return getTextElement(driver, RegisterPageUI.INVALID_ERROR_MASSAGE_EMAIL_TEXTBOX);
//	}

	public void inputToPassword(String passwordValue) {
		waitElementClickable(driver, passwordTextbox);
		senkeyToElement(driver, passwordTextbox, passwordValue);

	}

//	public String getInvalidErrorMessageAtPasswordTextbox() {
//		waitElementClickable(driver, RegisterPageUI.INVALID_ERROR_MASSAGE_PASSWORD_TEXTBOX);
//		return getTextElement(driver, RegisterPageUI.INVALID_ERROR_MASSAGE_PASSWORD_TEXTBOX);
//	}

	public void inputToConfirmPassword(String confirmPasswordValue) {
		waitElementClickable(driver, confirmPasswordTextbox);
		senkeyToElement(driver, confirmPasswordTextbox, confirmPasswordValue);

	}

//	public String getInvalidErrorMessageAtConfirmPasswordTextbox() {
//		waitElementClickable(driver, RegisterPageUI.INVALID_ERROR_MASSAGE_CONFIRM_PASSWORD_TEXTBOX);
//		return getTextElement(driver, RegisterPageUI.INVALID_ERROR_MASSAGE_CONFIRM_PASSWORD_TEXTBOX);
//	}

	public void inputToFirstnameTextbox(String firstNameValue) {
		waitElementClickable(driver, firstNameTextbox);
		senkeyToElement(driver, firstNameTextbox, firstNameValue);

	}
	
	public void inputToLastnameTextbox(String lastNameValue) {
		waitElementClickable(driver, lastNameTextbox);
		senkeyToElement(driver, lastNameTextbox, lastNameValue);
		// TODO Auto-generated method stub

	}
	
//	public static final String REGISTER_BUTTON = "//span[contains(text(),'Register')]";
//	public static final String REQUIRED_ERROR_MASSAGE_FIRSTNAME_TEXTBOX = "//div[@id='advice-required-entry-firstname']";
//	public static final String REQUIRED_ERROR_MASSAGE_LASTNAME_TEXTBOX = "//div[@id='advice-required-entry-lastname']";
//	public static final String REQUIRED_ERROR_MASSAGE_EMAIL_TEXTBOX = "//div[@id='advice-required-entry-email_address']";
//	public static final String REQUIRED_ERROR_MASSAGE_PASSWORD_TEXTBOX = "//div[@id='advice-required-entry-password']";
//	public static final String REQUIRED_ERROR_MASSAGE_CONFIRM_PASSWORD_TEXTBOX = "//div[@id='advice-required-entry-confirmation']";
//	public static final String INVALID_ERROR_MASSAGE_EMAIL_TEXTBOX = "//div[@id='advice-validate-email-email_address']";
//	public static final String INVALID_ERROR_MASSAGE_PASSWORD_TEXTBOX = "//div[@id='advice-validate-password-password']";
//	public static final String INVALID_ERROR_MASSAGE_CONFIRM_PASSWORD_TEXTBOX = "//div[@id='advice-validate-cpassword-confirmation']";
//	public static final String FIRST_NAME_TEXTBOX = "//input[@id='firstname']";
//	public static final String LAST_NAME_TEXTBOX = "//input[@id='lastname']";
//	public static final String EMAIL_TEXTBOX = "//input[@id='email_address']";
//	public static final String PASSWORD_TEXTBOX = "//input[@id='password']";
//	public static final String CONFIRM_PASSWORD_TEXTBOX = "//input[@id='confirmation']";
}
