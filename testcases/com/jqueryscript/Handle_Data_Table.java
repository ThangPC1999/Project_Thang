package com.jqueryscript;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.jqueryScript.DataTablePageObject;

public class Handle_Data_Table extends AbstractTest {

	WebDriver driver;
	DataTablePageObject dataTablePage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String drowserName) {
		driver = getBrowser(drowserName);
		
	}

	@Test
	public void TC_01_Senkey_Edit_Remove() {
		dataTablePage = new DataTablePageObject(driver);
		dataTablePage.inputDataInDynamicColumn("Country", "AFRICA");
		
		Assert.assertTrue(dataTablePage.isOnlyRowDisplayed("AFRICA"));
		System.out.println("Có verify");
		
	}
	@Test
	public void TC_02_Pagenation_Jquery() throws InterruptedException {
		dataTablePage = new DataTablePageObject(driver);
		dataTablePage.navigateToNumberPage("3");
		dataTablePage.isDislayed("3");
		Thread.sleep(3);
		dataTablePage.navigateToNumberPage("15");
		dataTablePage.isDislayed("15");
		Thread.sleep(3);
		

		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
