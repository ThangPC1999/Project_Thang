package stepdefinitions;

import actions.ThuocSi_PaymentPageActions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ThuocSi_PaymentPageSteps {

	@When("I click payment button on Payment page")
	public void i_click_payment_button_on_payment_page() {
		ThuocSi_PaymentPageActions.getInstance().clickBtnPayment();
	}

	@Then("I should see payment success on Payment page")
	public void i_should_see_payment_success_on_payment_page() {
		ThuocSi_PaymentPageActions.getInstance().verifyPaymentSuccess();
	}

	@When("I click detail bill on Payment page")
	public void i_click_detail_bill_on_payment_page() {
		ThuocSi_PaymentPageActions.getInstance().clickDetailBill();

	}

	@When("I click edit order on Payment page")
	public void i_click_edit_order_on_payment_page() {
		ThuocSi_PaymentPageActions.getInstance().clickEditOrder();

	}

	@When("I click add VAT on Payment page")
	public void i_click_add_vat_on_payment_page() {
		ThuocSi_PaymentPageActions.getInstance().clickAddVAT();

	}

	@When("I enters company name on Payment page")
	public void i_enters_company_name_on_payment_page() {
		ThuocSi_PaymentPageActions.getInstance().sendKeysCompanyName();

	}

	@When("I enters tax code on Payment page")
	public void i_enters_tax_code_on_payment_page() {
		ThuocSi_PaymentPageActions.getInstance().sendKeysTaxCode();

	}

	@When("I enters address on Payment page")
	public void i_enters_address_on_payment_page() {
		ThuocSi_PaymentPageActions.getInstance().sendKeysAddress();

	}
	
	@When("I seletect payment type {string} on Payment pages")
	public void i_seletect_payment_type_on_payment_pages(String type) {
		ThuocSi_PaymentPageActions.getInstance().selectPaymentType(type);

	}


}
