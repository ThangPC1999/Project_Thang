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
import pageObjects.liveGuru.MyDashboardPageObject;
import pageObjects.liveGuru.RegisterPageObject;

public class Level_03_Page_Object_Part_I extends AbstractPage {
	
	
	WebDriver driver;
	HomePageObject homePage;
	LoginPageObject loginPage;
	MyDashboardPageObject myDashboardPage;
	RegisterPageObject registerPage;
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", "/Users/thang.phan/Downloads/geckodriver");
		driver = new FirefoxDriver();
		
		driver.get("http://live.techpanda.org/index.php/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		// Get URL -> mở ra home page
		
		homePage = new HomePageObject(driver);
		
	}
	@BeforeMethod
	public void beforeMethod() {
		// click to My account -> mở ra login page
		homePage.clickToMyAccountLink();
		
		loginPage = new LoginPageObject(driver);
		// click to create account -> mở ra Register page
		loginPage.clickToCreateAccountLink();
		
		registerPage = new RegisterPageObject(driver);
		
 	}

	@Test
	public void Register_01_Emty_Data() {
		// click button Register
		registerPage.clickToRegisterButton();
		
		// hàm verify dữ liệu
		Assert.assertEquals(registerPage.getRequiredErrorMessageAtFirstnameTextbox(), "This is a required field.");
		Assert.assertEquals(registerPage.getRequiredErrorMessageAtLastnameTextbox(), "This is a required field.");
		Assert.assertEquals(registerPage.getRequiredErrorMessageAtEmailTextbox(), "This is a required field.");
		Assert.assertEquals(registerPage.getRequiredErrorMessageAtPasswordTextbox(), "This is a required field.");
		Assert.assertEquals(registerPage.getRequiredErrorMessageAtConfirmPasswordTextbox(), "This is a required field.");

	}

	@Test
	public void Register_02_Invalid_Email() {
		
		// nhập liệu vào field email 
		registerPage.inputToEmailTextbox("123@124");
		
		// click button Register
		registerPage.clickToRegisterButton();
		
		// hàm veryfy dữ liệu

		Assert.assertEquals(registerPage.getInvalidErrorMessageAtEmailTextbox(), "Please enter a valid email address. For example johndoe@domain.com.");

	}

	@Test
	public void Register_03_Password_Less_Than_6_chars() {
		
		// nhập liệu vào field password
		registerPage.inputToPassword("123");
		
		// click button Register
		registerPage.clickToRegisterButton();
		
		// hàm verify dữ liệu
		
		Assert.assertEquals(registerPage.getInvalidErrorMessageAtPasswordTextbox(), "Please enter 6 or more characters without leading or trailing spaces.");
	}

	@Test
	public void Register_04_Confirm_Password_Not_Matching_Password() {
		
		// nhập liệu vào field confirm password
		registerPage.inputToConfirmPassword("1233");
		
		// click button Register
		registerPage.clickToRegisterButton();
		
		// hàm verify dữ liệu
		Assert.assertEquals(registerPage.getInvalidErrorMessageAtConfirmPasswordTextbox(), "Please make sure your passwords match.");

	}
	@Test
	public void Register_05_Valid_Data() {
		
		// nhập liệu vào field frist name
		registerPage.inputToFirstnameTextbox("john");
		
		// nhập liệu vào field last name
		registerPage.inputToLastnameTextbox("Back");
		
		// nhập liệu vào field email
		registerPage.inputToEmailTextbox("JohnBack" + randomNumber()+"@gmail.com");
		
		// nhập liệu vào field password
		registerPage.inputToPassword("123456789");
		
		// nhập liệu vào field confirm password
		registerPage.inputToConfirmPassword("123456789");
		
		// click button đăng kí -> chuyển qua MyDashboard
		registerPage.clickToRegisterButton();
		
		myDashboardPage = new MyDashboardPageObject(driver);
		
		
		// verify đăng kí thành công
		Assert.assertEquals(myDashboardPage.getWellcomeSuccessMessage(), "Thank you for registering with Main Website Store.");
		
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
