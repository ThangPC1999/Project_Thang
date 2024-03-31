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

public class Level_01_Repeat_Yourself {
	
	WebDriver driver;
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", "/Users/thang.phan/Downloads/geckodriver");
		driver = new FirefoxDriver();
		driver.get("http://live.techpanda.org/index.php/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@BeforeMethod
	public void beforeMethod() {
		driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Create an Account')]")).click();
		
	}

	@Test
	public void Register_01_Emty_Data() {
		driver.findElement(By.xpath("//span[contains(text(),'Register')]")).click();
		//Verify
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-required-entry-firstname']")).getText(), "This is a required field.");
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-required-entry-lastname']")).getText(), "This is a required field.");
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-required-entry-email_address']")).getText(), "This is a required field.");
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-required-entry-password']")).getText(), "This is a required field.");
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-required-entry-confirmation']")).getText(), "This is a required field.");

	}

	@Test
	public void Register_02_Invalid_Email() {
		driver.findElement(By.xpath("//input[@id='email_address']")).sendKeys("123@124");
		driver.findElement(By.xpath("//span[contains(text(),'Register')]")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-validate-email-email_address']")).getText(), "Please enter a valid email address. For example johndoe@domain.com.");

	}

	@Test
	public void Register_03_Password_Less_Than_6_chars() {
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123");
		driver.findElement(By.xpath("//span[contains(text(),'Register')]")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-validate-password-password']")).getText(), "Please enter 6 or more characters without leading or trailing spaces.");

	}

	@Test
	public void Register_04_Confirm_Password_Not_Matching_Password() {
		driver.findElement(By.xpath("//input[@id='confirmation']")).sendKeys("1233");
		driver.findElement(By.xpath("//span[contains(text(),'Register')]")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-validate-cpassword-confirmation']")).getText(), "Please make sure your passwords match.");

	}
	@Test
	public void Register_05_Valid_Data() {
		driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("John");
		driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("Back");
		driver.findElement(By.xpath("//input[@id='email_address']")).sendKeys("JohnBack" + randomNumber()+"@gmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456789");
		driver.findElement(By.xpath("//input[@id='confirmation']")).sendKeys("123456789");
		driver.findElement(By.xpath("//span[contains(text(),'Register')]")).click();
		
		
		
		// verify đăng kí thành công
		Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'Thank you for registering with Main Website Store.')]")).isDisplayed());
		
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
