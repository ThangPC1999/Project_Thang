package stepdefinitions;

import actions.ThuocSi_ManageAccountPageActions;
import actions.ThuocSi_ManageOrderPageActions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ThuocSi_AccountPageSteps {

	@When("I upload file on Manage Account page")
	public void i_upload_file_on_manage_account_page() {
		ThuocSi_ManageAccountPageActions.getInstance().uploadFile();

	}

	@When("I select district on Manage Account page")
	public void i_select_district_on_manage_account_page() {
		ThuocSi_ManageAccountPageActions.getInstance().selectDistrict();
	}

	@When("I select ward on Manage Account page")
	public void i_select_ward_on_manage_account_page() {
		ThuocSi_ManageAccountPageActions.getInstance().selectWard();
	}

	@When("I enters address on Manage Account page")
	public void i_enters_address_on_manage_account_page() {
		ThuocSi_ManageAccountPageActions.getInstance().sendKeysAddress();

	}

	@When("I click update button on Manage Account page")
	public void i_click_update_button_on_manage_account_page() {
		ThuocSi_ManageAccountPageActions.getInstance().clickBtnUpdate();

	}

	@Then("I should see message update account success on the Home page")
	public void i_should_see_message_update_account_success_on_the_home_page() {
		ThuocSi_ManageAccountPageActions.getInstance().verifyMsgUpdate();

	}

	@When("I click menu quick order on Manage Account page")
	public void i_click_menu_quick_order_on_manage_account_page() {
		ThuocSi_ManageAccountPageActions.getInstance().clickMenuQuickOrder();

	}

	@Then("I should see status bill on Manage Account page")
	public void i_should_see_status_bill_on_manage_account_page() {
		ThuocSi_ManageOrderPageActions.getInstance().verifyBill();
	}

	@Then("I should see status order changed on Manage Account page")
	public void i_should_see_status_order_changed_on_manage_account_page() {
		ThuocSi_ManageOrderPageActions.getInstance().verifyStatusChange();

	}

	@Then("I should see status order changed {string} on Manage Account page")
	public void i_should_see_status_order_changed_on_manage_account_page(String data) {
		ThuocSi_ManageOrderPageActions.getInstance().verifyStatusChange(data);

	}

}
