package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.liveGuru.MyDashboardPageUI;

public class MyDashboardPageObject extends AbstractPage {
	
	private WebDriver driver;
	
	public MyDashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}
	

	public String getWellcomeSuccessMessage() {
		waitForElementVisible(driver, MyDashboardPageUI.WELLCOME_SUCCESS_MESSAGE);
		return getTextElement(driver, MyDashboardPageUI.WELLCOME_SUCCESS_MESSAGE);
	}


	public void clickToManageAddressLink() {
		
		waitElementClickable(driver, MyDashboardPageUI.MANAGE_ADDRESS_LINK);
		clickToElement(driver, MyDashboardPageUI.MANAGE_ADDRESS_LINK);
	}


	

}
