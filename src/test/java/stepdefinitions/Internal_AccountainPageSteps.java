package stepdefinitions;

import actions.Internal_AccountainActions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Internal_AccountainPageSteps {

	@When("I click menu accountain button on the Internal Detail Ticket WMS page")
	public void i_click_menu_accountain_button_on_the_internal_detail_ticket_wms_page() {
		Internal_AccountainActions.getInstance().clickMenuAccountain();
	}

	@When("I click sub item menu list control hub on the Internal Accountain page")
	public void i_click_sub_item_menu_list_control_hub_on_the_internal_accountain_page() {
		Internal_AccountainActions.getInstance().clickBtnShippingPartner();
		Internal_AccountainActions.getInstance().clickBtnListControlHub();

	}
	
	@When("I click sub item menu customer invoice on the Internal Accountain page")
	public void i_click_sub_item_menu_customer_invoice_on_the_internal_accountain_page() {
		Internal_AccountainActions.getInstance().clickBtnCustomer();
		Internal_AccountainActions.getInstance().clickBtnInvoice();
	}
	
	@When("I click sub item menu customer payment on the Internal Accountain page")
	public void i_click_sub_item_menu_customer_payment_on_the_internal_accountain_page() {
		Internal_AccountainActions.getInstance().clickBtnCustomer();
		Internal_AccountainActions.getInstance().clickBtnPayment();
	}

	@When("I enters so number on the Internal Accountain Invoice page")
	public void i_enters_so_number_on_the_internal_accountain_invoice_page() {
		Internal_AccountainActions.getInstance().sendKeysSO();

	}
	
	@Then("I should see status {string} on the Internal Accountain Invoice page")
	public void i_should_see_status_on_the_internal_accountain_invoice_page(String expectResult) {
		Internal_AccountainActions.getInstance().verifyStatus(expectResult);

	}

	@When("I enters ticket id on the Internal Accountain List Control Hub page")
	public void i_enters_ticket_id_on_the_internal_accountain_list_control_hub_page() {
		Internal_AccountainActions.getInstance().sendKeysTicketId();

	}

	@When("I click detail control session on the Internal Accountain List Control Hub page")
	public void i_click_detail_control_session_on_the_internal_accountain_list_control_hub_page() {
		Internal_AccountainActions.getInstance().clickBtnDetailControlSession();

	}

	@When("I enter money on the Internal Accountain Detail Control Hub page")
	public void i_enter_money_on_the_internal_accountain_detail_control_hub_page() {
		Internal_AccountainActions.getInstance().sendKeysMoney();

	}

	@When("I click start control button on the Internal Accountain Detail Control Hub page")
	public void i_click_start_control_button_on_the_internal_accountain_detail_control_hub_page() {
		Internal_AccountainActions.getInstance().clickBtnStartControl();

	}

}
