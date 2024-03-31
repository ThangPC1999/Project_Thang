package com.liveguru.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import commons.AbstractPage;
import pageObjects.liveGuru.HomePageObject;
import pageObjects.liveGuru.LoginPageObject;
import pageObjects.liveGuru.MyAddressBookPageObject;
import pageObjects.liveGuru.MyDashboardPageObject;
import pageObjects.liveGuru.PageGeneratorManager;
import pageObjects.liveGuru.RegisterPageObject;

public class Level_04_Page_Generator_Manager {

	WebDriver driver;
	HomePageObject homePage;
	LoginPageObject loginPage;
	MyDashboardPageObject myDashboardPage;
	RegisterPageObject registerPage;
	MyAddressBookPageObject myAddressBookPage;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", "/Users/thang.phan/Downloads/geckodriver");
		driver = new FirefoxDriver();

		driver.get("http://live.techpanda.org/index.php/");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Get URL -> mở ra home page

		homePage = PageGeneratorManager.getHomePage(driver);

		loginPage = homePage.clickToMyAccountLink();

		// click to create account -> mở ra Register page
		registerPage = loginPage.clickToCreateAccountLink();


	}
	@Test
	public void Register_01_Valid_Data() {

		// nhập liệu vào field frist name
		registerPage.inputToFirstnameTextbox("john");

		// nhập liệu vào field last name
		registerPage.inputToLastnameTextbox("Back");

		// nhập liệu vào field email
		registerPage.inputToEmailTextbox("JohnBack" + randomNumber() + "@gmail.com");

		// nhập liệu vào field password
		registerPage.inputToPassword("123456789");

		// nhập liệu vào field confirm password
		registerPage.inputToConfirmPassword("123456789");

		// click button đăng kí -> chuyển qua MyDashboard
		myDashboardPage = registerPage.clickToRegisterButton();

		myDashboardPage = new MyDashboardPageObject(driver);

		// verify đăng kí thành công
		Assert.assertEquals(myDashboardPage.getWellcomeSuccessMessage(),
				"Thank you for registering with Main Website Store.");

	}

	public int randomNumber() {
		Random rand = new Random();
		return rand.nextInt(99999);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}

