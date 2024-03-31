package stepdefinitions;

import actions.Internal_CRMActions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Internal_CRMPageSteps {

	@When("I click menu order button on the Internal CRM page")
	public void i_click_menu_order_button_on_the_internal_crm_page() {
		Internal_CRMActions.getInstance().clickBtnOrder();
	}

	@When("I enters order id on the CRM page")
	public void i_enters_order_id_on_the_crm_page() {
		Internal_CRMActions.getInstance().sendsKeyOrderId();

	}

	@When("I click apply button on the CRM page")
	public void i_click_apply_button_on_the_crm_page() {
		Internal_CRMActions.getInstance().clickBtnApply();

	}

	@When("I click change status order button on the CRM page")
	public void i_click_change_status_order_button_on_the_crm_page() {
		Internal_CRMActions.getInstance().clickBtnChangeStatus();

	}

	@Then("I should see status order changed on the CRM page")
	public void i_should_see_status_order_changed_on_the_crm_page() {
		Internal_CRMActions.getInstance().verifyStatusChange();
	}
	
	@Then("I should see total money using absolute discount on the CRM page")
	public void i_should_see_total_money_using_absolute_discount_on_the_crm_page() {
		Internal_CRMActions.getInstance().verifyTotalMoney();

	}
	
	@Then("I should see total money using percent discount on the CRM page")
	public void i_should_see_total_money_using_percent_discount_on_the_crm_page() {
		Internal_CRMActions.getInstance().verifyTotalMoneyDiscountPercent();

	}
	
	@When("I click number so button on the CRM page")
	public void i_click_number_so_button_on_the_crm_page() {
		Internal_CRMActions.getInstance().clikBtnNumberSO();

	}
	

}
