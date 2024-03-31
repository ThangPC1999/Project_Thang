package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.liveGuru.MyAddressBookPageUI;

public class MyAddressBookPageObject extends AbstractPage {
	
	WebDriver driver;
	
	public MyAddressBookPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToTelephoneTextbox(String telephonevalue) {
		waitForElementVisible(driver, MyAddressBookPageUI.TELEPHONE_TEXTBOX);
		senkeyToElement(driver, MyAddressBookPageUI.TELEPHONE_TEXTBOX, telephonevalue);
	}

	public void inputToStreetAddressTextBox(String streetAddressValue) {

		waitForElementVisible(driver, MyAddressBookPageUI.STREET_ADDRESS_TEXTBOX);
		senkeyToElement(driver, MyAddressBookPageUI.STREET_ADDRESS_TEXTBOX, streetAddressValue);
	}
	

	public void inputToCityTextBox(String cityValue) {

		waitForElementVisible(driver, MyAddressBookPageUI.CITY_TEXTBOX);
		senkeyToElement(driver, MyAddressBookPageUI.CITY_TEXTBOX, cityValue);
	}

	public void inputToZipTextbox(String zipvalue) {

		waitForElementVisible(driver, MyAddressBookPageUI.ZIP_TEXTBOX);
		senkeyToElement(driver, MyAddressBookPageUI.ZIP_TEXTBOX, zipvalue);
	}

	public void selectValueInCountryDropdown(String countryValue) {
		waitForElementVisible(driver, MyAddressBookPageUI.COUNTRY_DROPDOWN);
		selectIteamInDropdown(driver, MyAddressBookPageUI.COUNTRY_DROPDOWN, countryValue);
	}

	public void clickToSaveAddressButton() {

		waitElementClickable(driver, MyAddressBookPageUI.SAVE_BUTTON);
		clickToElement(driver, MyAddressBookPageUI.SAVE_BUTTON);
	}

	public boolean isAddAddressSuccessMsgDisplay() {
		waitForElementVisible(driver, MyAddressBookPageUI.SUCCESS_MESSAGE);
		return isElementDisplayed(driver, MyAddressBookPageUI.SUCCESS_MESSAGE);
	}

	
	

}
