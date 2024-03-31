package stepdefinitions;

import actions.Internal_SellerActions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Internal_SellerPageSteps {

	private static final int CODE_SUCCESS = 200;

	@When("I click menu seller button on the Internal Home page")
	public void i_click_menu_seller_button_on_the_internal_home_page() {
		Internal_SellerActions.getInstance().clickMenuSeller();
	}

	@When("I click sub menu request approve button on the Internal Seller page")
	public void i_click_sub_menu_request_approve_button_on_the_internal_seller_page() {
		Internal_SellerActions.getInstance().clickSubMenuRequestApprove();

	}

	@When("I click status pending approve button on the Internal Seller page")
	public void i_click_status_pending_approve_button_on_the_internal_seller_page() {
		Internal_SellerActions.getInstance().clickBtnPendingApprove();

	}

	@When("I enters product name on the Internal Seller page")
	public void i_enters_product_name_on_the_internal_seller_page() {
		Internal_SellerActions.getInstance().sendKeysProductName();

	}
	
	@When("I enters combo name on the Internal Seller page")
	public void i_enters_combo_name_on_the_internal_seller_page() {
		Internal_SellerActions.getInstance().sendKeysComboName();

	}

	@When("I click apply button on the Internal Seller page")
	public void i_click_apply_button_on_the_internal_seller_page() {
		Internal_SellerActions.getInstance().clickBtnApply();
	}

	@When("I click checkbox item product on the Internal Seller page")
	public void i_click_checkbox_item_product_on_the_internal_seller_page() {
		Internal_SellerActions.getInstance().clickBtnCheckBoxItem();
	}

	@When("I click view detail item product on the Internal Seller page")
	public void i_click_view_detail_item_product_on_the_internal_seller_page() {
		Internal_SellerActions.getInstance().clickBtnViewDetail();

	}

	@When("I click accept button on the Internal Seller page")
	public void i_click_accept_button_on_the_internal_seller_page() {
		Internal_SellerActions.getInstance().clickBtnAccept();

	}
	
	@Then("I should see post for sale sucess on the Internal Seller page")
	public void i_should_see_post_for_sale_sucess_on_the_internal_seller_page() {
		Internal_SellerActions.getInstance().verifyMessage();

	}
	
}
