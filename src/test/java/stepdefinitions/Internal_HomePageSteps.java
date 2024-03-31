package stepdefinitions;

import actions.Internal_HomePageActions;
import actions.Internal_SellerActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class Internal_HomePageSteps {

	@When("I click menu customer & order button on the Internal Home page")
	public void i_click_menu_customer_order_button_on_the_internal_home_page() {
		Internal_HomePageActions.getInstance().clickBtnCRMMenu();
	}
	
	@Given("I click menu product & setting button on the Internal Home page")
	public void i_click_menu_product_setting_button_on_the_internal_home_page() {
		Internal_HomePageActions.getInstance().clickBtnCMSMenu();

	}
	
}
