package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;



public class PageGeneratorManager {
	
	public static HomePageObject getHomePage (WebDriver driver) {
		return new HomePageObject(driver);
	}
	public static MyDashboardPageObject getMyDashBoardPage (WebDriver driver) {
		return new MyDashboardPageObject(driver);
	}
	public static LoginPageObject getLoginPage (WebDriver driver) {
		return new LoginPageObject(driver);
	}
	public static RegisterPageObject getRegisterPage (WebDriver driver) {
		return new RegisterPageObject(driver);
	}
	public static AboutUsPageObject getAboutUsPage(WebDriver driver) {
		return new AboutUsPageObject(driver);
	}
	public static ContactUsPageObject getContactUsPage(WebDriver driver) {
		return new ContactUsPageObject(driver);
	}
	public static CustomerServicePageObject getCustomerServicePage(WebDriver driver) {
		return new CustomerServicePageObject(driver);
	}
	public static SiteMapPageObject getSiteMapPage(WebDriver driver) {
		return new SiteMapPageObject(driver);
	}
	public static PrivacyPolicyPageObject getPrivacyPolicyPage(WebDriver driver) {
		return new PrivacyPolicyPageObject(driver);
	}
	public static OrderAndReturnPageObject getOrderAndReturnPage(WebDriver driver) {
		return new OrderAndReturnPageObject(driver);
	}

}
