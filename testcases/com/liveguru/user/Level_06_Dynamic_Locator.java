package com.liveguru.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractPage;
import commons.AbstractTest;
import pageObjects.liveGuru.AboutUsPageObject;
import pageObjects.liveGuru.ContactUsPageObject;
import pageObjects.liveGuru.CustomerServicePageObject;
import pageObjects.liveGuru.HomePageObject;
import pageObjects.liveGuru.LoginPageObject;
import pageObjects.liveGuru.MyAddressBookPageObject;
import pageObjects.liveGuru.MyDashboardPageObject;
import pageObjects.liveGuru.OrderAndReturnPageObject;
import pageObjects.liveGuru.PageGeneratorManager;
import pageObjects.liveGuru.PrivacyPolicyPageObject;
import pageObjects.liveGuru.RegisterPageObject;
import pageObjects.liveGuru.SiteMapPageObject;

public class Level_06_Dynamic_Locator extends AbstractTest {
	WebDriver driver;
	HomePageObject homePage;
	LoginPageObject loginPage;
	MyDashboardPageObject myDashboardPage;
	RegisterPageObject registerPage;
	MyAddressBookPageObject myAddressBookPage;
	AboutUsPageObject aboutUspage;
	ContactUsPageObject contactUsPage;
	AbstractPage csPage;
	PrivacyPolicyPageObject privacyPolicyPage;
	SiteMapPageObject siteMapPage;
	OrderAndReturnPageObject orderAndReturnPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {

		driver = getBrowser(browserName);

	}

	@Test
	public void TC_01_Switch_Less_Pages() {

		homePage = PageGeneratorManager.getHomePage(driver);
		
		siteMapPage = (SiteMapPageObject) homePage.clickToDynamicLessPageMenu(driver, "Site Map");
		orderAndReturnPage = (OrderAndReturnPageObject) siteMapPage.clickToDynamicLessPageMenu(driver, "Orders and Returns");
		privacyPolicyPage = (PrivacyPolicyPageObject) orderAndReturnPage.clickToDynamicLessPageMenu(driver, "Privacy Policy");
		contactUsPage = (ContactUsPageObject) privacyPolicyPage.clickToDynamicLessPageMenu(driver,"Contact Us");
		csPage = (CustomerServicePageObject) contactUsPage.clickToDynamicLessPageMenu(driver, "CustomerService");

	}
	public void TC_02_Switch_More_Pages() {
		
		homePage = PageGeneratorManager.getHomePage(driver);
		
		homePage.clickToDynamicMorePageMenu(driver, "Site Map");
		siteMapPage = PageGeneratorManager.getSiteMapPage(driver);
		siteMapPage.clickToDynamicMorePageMenu(driver, "Orders and Returns");
		orderAndReturnPage = PageGeneratorManager.getOrderAndReturnPage(driver);
		orderAndReturnPage.clickToDynamicMorePageMenu(driver, "Privacy Policy");
		privacyPolicyPage = PageGeneratorManager.getPrivacyPolicyPage(driver);
		privacyPolicyPage.clickToDynamicMorePageMenu(driver,"Contact Us");
		contactUsPage = PageGeneratorManager.getContactUsPage(driver);
		contactUsPage.clickToDynamicMorePageMenu(driver, "CustomerService");
		csPage = PageGeneratorManager.getCustomerServicePage(driver);
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
