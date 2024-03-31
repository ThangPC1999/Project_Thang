package com.liveguru.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import commons.AbstractPages;

public class Level_02_Common_Function_01 {
	
	AbstractPages abstractPage;
	
	WebDriver driver;
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", "/Users/thang.phan/Downloads/geckodriver");
		driver = new FirefoxDriver();
		
		abstractPage = new AbstractPages();
		
		driver.get("http://live.techpanda.org/index.php/");
		
		abstractPage.openPageURL(driver, "http://live.techpanda.org/index.php/");
		abstractPage.setEmplicitWait(driver, 30);
		
	}
	@BeforeMethod
	public void beforeMethod() {
		abstractPage.clickToElement(driver, "//div[@class='footer']//a[text()='My Account']");
		
		abstractPage.clickToElement(driver, "//span[contains(text(),'Create an Account')]");
		
 	}

	@Test
	public void Register_01_Emty_Data() {
		abstractPage.clickToElement(driver, "//span[contains(text(),'Register')]");
		//Verify
		Assert.assertEquals(abstractPage.getTextElement(driver, "//div[@id='advice-required-entry-firstname']"), "This is a required field.");
		Assert.assertEquals(abstractPage.getTextElement(driver, "//div[@id='advice-required-entry-lastname']"), "This is a required field.");
		Assert.assertEquals(abstractPage.getTextElement(driver, "//div[@id='advice-required-entry-email_address']"), "This is a required field.");
		Assert.assertEquals(abstractPage.getTextElement(driver, "//div[@id='advice-required-entry-password']"), "This is a required field.");
		Assert.assertEquals(abstractPage.getTextElement(driver, "//div[@id='advice-required-entry-confirmation']"), "This is a required field.");

	}

	@Test
	public void Register_02_Invalid_Email() {
		abstractPage.sendkeyToElementByJS(driver, "//input[@id='email_address']", "123@124");
		
		abstractPage.clickToElement(driver, "//span[contains(text(),'Register')]");
		
		Assert.assertEquals(abstractPage.getTextElement(driver, "//div[@id='advice-validate-email-email_address']"), "Please enter a valid email address. For example johndoe@domain.com.");

	}

	@Test
	public void Register_03_Password_Less_Than_6_chars() {
		abstractPage.senkeyToElement(driver, "//input[@id='password']", "123");
		
		abstractPage.clickToElement(driver, "//span[contains(text(),'Register')]");
		
		Assert.assertEquals(abstractPage.getTextElement(driver, "//div[@id='advice-validate-password-password']") , "Please enter 6 or more characters without leading or trailing spaces.");
	}

	@Test
	public void Register_04_Confirm_Password_Not_Matching_Password() {
		abstractPage.senkeyToElement(driver, "//input[@id='confirmation']", "1233");
		
		abstractPage.clickToElement(driver, "//span[contains(text(),'Register')]");
		
		Assert.assertEquals(abstractPage.getTextElement(driver, "//div[@id='advice-validate-cpassword-confirmation']"), "Please make sure your passwords match.");

	}
	@Test
	public void Register_05_Valid_Data() {
		driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("John");
		abstractPage.senkeyToElement(driver, "//input[@id='firstname']", "John");
		
		abstractPage.senkeyToElement(driver, "//input[@id='lastname']", "Back");
		
		abstractPage.senkeyToElement(driver, "//input[@id='email_address']", "JohnBack" + randomNumber()+"@gmail.com");
		
		abstractPage.senkeyToElement(driver, "//input[@id='password']", "123456789");
		
		abstractPage.senkeyToElement(driver, "//input[@id='confirmation']", "123456789");
		
		abstractPage.clickToElement(driver, "//span[contains(text(),'Register')]");
		
		
		
		// verify đăng kí thành công
		abstractPage.isElementDisplayed(driver, "//span[contains(text(),'Thank you for registering with Main Website Store.')]");
		
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
