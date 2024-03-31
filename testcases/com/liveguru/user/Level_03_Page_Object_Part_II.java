package com.liveguru.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.liveGuru.HomePageObject;
import pageObjects.liveGuru.LoginPageObject;
import pageObjects.liveGuru.MyAddressBookPageObject;
import pageObjects.liveGuru.MyDashboardPageObject;
import pageObjects.liveGuru.RegisterPageObject;

public class Level_03_Page_Object_Part_II {

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
		
//		System.setProperty("webdriver.chrome.driver", "/Users/thang.phan/Downloads/chromedriver_mac64/chromedriver");
//		driver = new ChromeDriver();
		
//		System.setProperty("webdriver.edge.driver", "/Users/thang.phan/Downloads/msedgedriver");
//		driver = new EdgeDriver();

		driver.get("http://live.techpanda.org/index.php/");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Get URL -> mở ra home page

		homePage = new HomePageObject(driver);

		homePage.clickToMyAccountLink();

		loginPage = new LoginPageObject(driver);
		// click to create account -> mở ra Register page
		loginPage.clickToCreateAccountLink();

		registerPage = new RegisterPageObject(driver);

	}
	@Test
	public void TC_01_Register_Valid_Data() {

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
		registerPage.clickToRegisterButton();

		myDashboardPage = new MyDashboardPageObject(driver);

		// verify đăng kí thành công
		Assert.assertEquals(myDashboardPage.getWellcomeSuccessMessage(),
				"Thank you for registering with Main Website Store.");

	}

	@Test
	public void TC_02_Addrress_Add_Address_Book() {
		myDashboardPage.clickToManageAddressLink();
		myAddressBookPage = new MyAddressBookPageObject(driver);
		myAddressBookPage.inputToTelephoneTextbox("0978987654");
		myAddressBookPage.inputToStreetAddressTextBox("28Bis Mac Dinh Chi P.Dakao Q.1");
		myAddressBookPage.inputToCityTextBox("Ho Chi Minh");
		myAddressBookPage.inputToZipTextbox("726571");
		myAddressBookPage.selectValueInCountryDropdown("Vietnam");
		myAddressBookPage.clickToSaveAddressButton();
		Assert.assertTrue(myAddressBookPage.isAddAddressSuccessMsgDisplay());
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

