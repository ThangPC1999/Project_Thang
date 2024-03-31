package stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import actions.Internal_CMSActions;
import base.driver.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Internal_CMSPageSteps {
	WebDriver driver;
	WebDriverWait wait;

	public Internal_CMSPageSteps() throws Throwable {
		driver = DriverManager.getInstance().getDriver();

		wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(System.getProperty("objectTimeout"))));
	}

	@Given("I click menu area button on the CMS page")
	public void i_click_menu_area_button_on_the_cms_page() {
		Internal_CMSActions.getInstance().clickBtnArea();
	}

	@When("I get product id on the CMS page")
	public void i_get_product_id_on_the_cms_page() {
		Internal_CMSActions.getInstance().getProductId();

	}

	@Then("I should see area division on the CMS page")
	public void i_should_see_area_division_on_the_cms_page() {
		Internal_CMSActions.getInstance().verifyGetArea();

	}

	@Then("I should see list product on the CMS page")
	public void i_should_see_list_product_on_the_cms_page() {
		Internal_CMSActions.getInstance().verifyProductListIsDisPlay();
	}

	@When("I click button create product on the CMS Product page")
	public void i_click_button_create_product_on_the_cms_product_page() {
		Internal_CMSActions.getInstance().clickBtnCreateProduct();
	}

	@When("I select owner {string} on the CMS Create Product page")
	public void i_select_owner_on_the_cms_create_product_page(String owner) {
		Internal_CMSActions.getInstance().selectOwner(owner);

	}

	@When("I enter name product on the CMS Create Product page")
	public void i_enter_name_product_on_the_cms_create_product_page() {
		Internal_CMSActions.getInstance().inputNameProduct();
	}

	@When("I select category product on the CMS Create Product page")
	public void i_select_category_product_on_the_cms_create_product_page() {
		Internal_CMSActions.getInstance().selectCategoryProduct();
	}

	@When("I enter image product on the CMS Create Product page")
	public void i_enter_image_product_on_the_cms_create_product_page() {
		Internal_CMSActions.getInstance().inputImgProduct();
	}

	@When("I select product of use on the CMS Create Product page")
	public void i_select_product_of_use_on_the_cms_create_product_page() {
		Internal_CMSActions.getInstance().selectEfficaciesProduct();
	}

	@When("I enter brand product on the CMS Create Product page")
	public void i_enter_brand_product_on_the_cms_create_product_page() {
	}

	@When("I sellect unit product on the CMS Create Product page")
	public void i_sellect_unit_product_on_the_cms_create_product_page() {
		Internal_CMSActions.getInstance().selectInitProduct();
	}

	@When("I enter option packing product on the CMS Create Product page")
	public void i_enter_option_packing_product_on_the_cms_create_product_page() {
		Internal_CMSActions.getInstance().selectOptionPacking();
	}

	@When("I select origin product on the CMS Create Product page")
	public void i_select_origin_product_on_the_cms_create_product_page() {
		Internal_CMSActions.getInstance().selectOriginProduct();
	}

	@When("I select manufacturer product on the CMS Create Product page")
	public void i_select_manufatuner_product_on_the_cms_create_product_page() {
		Internal_CMSActions.getInstance().selectManufacturerProduct();
	}

	@When("I select industry product on the CMS Create Product page")
	public void i_select_industry_product_on_the_cms_create_product_page() {
		Internal_CMSActions.getInstance().selectIndustryProduct();

	}

	@When("I click button save on the CMS Create Product page")
	public void i_click_button_save_on_the_cms_create_product_page() {
		Internal_CMSActions.getInstance().clickSaveBtn();
	}
	
	@When("I click create combo button on the CMS Create Product page")
	public void i_click_create_combo_button_on_the_cms_create_product_page() {
		Internal_CMSActions.getInstance().clickBtnCreateCombo();

	}

	@When("I select product name on the CMS Create Combo page")
	public void i_select_product_name_on_the_cms_create_combo_page() {
		Internal_CMSActions.getInstance().selectProductName();

	}

	@When("I enters quantity on the CMS Create Combo page")
	public void i_enters_quantity_on_the_cms_create_combo_page() {
		Internal_CMSActions.getInstance().sendKeysQuantity();

	}

	@When("I click add button on the CMS Create Combo page")
	public void i_click_add_button_on_the_cms_create_combo_page() {
		Internal_CMSActions.getInstance().clickBtnAdd();

	}

	@When("I click using name on the CMS Create Combo page")
	public void i_click_using_name_on_the_cms_create_combo_page() {
		Internal_CMSActions.getInstance().clickBtnUsingName();

	}

	@When("I click save button on the CMS Create Combo page")
	public void i_click_save_button_on_the_cms_create_combo_page() {
		Internal_CMSActions.getInstance().clickSaveBtn();

	}
	
	@When("I select category product on the CMS Create Combo page")
	public void i_select_category_product_on_the_cms_create_combo_page() {
		Internal_CMSActions.getInstance().selectCategoryProduct();

	}

}
