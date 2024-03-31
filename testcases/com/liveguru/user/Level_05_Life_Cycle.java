package com.liveguru.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

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

public class Level_05_Life_Cycle extends AbstractTest {
	WebDriver driver;
	HomePageObject homePage;
	LoginPageObject loginPage;
	MyDashboardPageObject myDashboardPage;
	RegisterPageObject registerPage;
	MyAddressBookPageObject myAddressBookPage;
	AboutUsPageObject aboutUspage;
	ContactUsPageObject contactUsPage;
	CustomerServicePageObject csPage;
	PrivacyPolicyPageObject privacyPolicyPage;
	SiteMapPageObject siteMapPage;
	OrderAndReturnPageObject orderAndReturnPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {

		driver = getBrowser(browserName);

	}

	@Test
	public void TC_01_Switch_Pages() {

		homePage = PageGeneratorManager.getHomePage(driver);
		
		siteMapPage = homePage.clickToSiteMapMenu(driver);
		orderAndReturnPage = siteMapPage.clickToOrderAndReturnMenu(driver);
		privacyPolicyPage = orderAndReturnPage.clickToPrivacyPolicyMenu(driver);
		contactUsPage = privacyPolicyPage.clickToContactUsMenu(driver);
		csPage = contactUsPage.clickToCSMenu(driver);

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
