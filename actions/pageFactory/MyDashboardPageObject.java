package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MyDashboardPageObject extends AbstractPage {
	
	private WebDriver driver;
	
	public MyDashboardPageObject(WebDriver driver) {
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(how = How.XPATH, using = "//li//span")
	private WebElement wellcomeSuccessMgs;

	public String getWellcomeSuccessMessage() {
		waitForElementVisible(driver, wellcomeSuccessMgs);
		return getTextElement(driver, wellcomeSuccessMgs);
	}

	
	
	
//	public static final String WELLCOME_SUCCESS_MESSAGE = "//li//span";
}
