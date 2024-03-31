package pageObjects.jqueryScript;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.jqueryScript.DataTablePageUI;

public class DataTablePageObject extends AbstractPage {
	
	WebDriver driver;
	
	public DataTablePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputDataInDynamicColumn(String columnName, String dataInput) {

		waitForElementVisible(driver, DataTablePageUI.DYNAMIC_INPUT_COLUMN, columnName);
		senkeyToElement(driver, DataTablePageUI.DYNAMIC_INPUT_COLUMN, columnName, dataInput);
		senkeyBoardToElement(driver, DataTablePageUI.DYNAMIC_INPUT_COLUMN, columnName, Keys.ENTER);
	}

	public boolean isOnlyRowDisplayed( String value) {

		waitForElementVisible(driver, DataTablePageUI.DYNAMIC_VERIFY_COLUMN, value);
		int countElement = countElementNumber(driver, DataTablePageUI.DYNAMIC_VERIFY_COLUMN, value);
		boolean status = isElementDisplayed(driver, DataTablePageUI.DYNAMIC_VERIFY_COLUMN, value);
		return countElement == 1 && status == true;
	}

	public void navigateToNumberPage(String numberPage) {
		waitForElementVisible(driver, DataTablePageUI.DYNAMIC_PAGE, numberPage);
		clickToElement(driver, DataTablePageUI.DYNAMIC_PAGE, numberPage);
		
		
	}

	public boolean isDislayed(String numberPage) {
		waitForElementVisible(driver, DataTablePageUI.DYNAMIC_PAGE, numberPage);
		
		return isElementDisplayed(driver, DataTablePageUI.DYNAMIC_PAGE_ACTIVE, numberPage);
		
		
	}
	

}
