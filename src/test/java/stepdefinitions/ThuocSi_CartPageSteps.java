package stepdefinitions;

import actions.ThuocSi_CartPageActions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ThuocSi_CartPageSteps {

	@When("I click contiunous payment button on Cart page")
	public void i_click_contiunous_payment_button_on_cart_page() {
		ThuocSi_CartPageActions.getInstance().clickBtnContinousPayment();
	}

	@When("I click button add promotion code on Payment page")
	public void i_click_button_add_promotion_code_on_payment_page() {
		ThuocSi_CartPageActions.getInstance().clickBtnAddPromotion();

	}

	@When("I enters promotion code on Payment page")
	public void i_enters_promotion_code_on_payment_page() {
		ThuocSi_CartPageActions.getInstance().sendKeysPromotionCode();

	}

	@When("I click button use now on Payment page")
	public void i_click_button_use_now_on_payment_page() {
		ThuocSi_CartPageActions.getInstance().clickBtnUseNow();

	}
	
	@Then("I should see total money before use discount absolute on Payment page")
	public void i_should_see_total_money_before_use_discount_absolute_on_payment_page() {
		ThuocSi_CartPageActions.getInstance().verifyTotalMoney();

	}
	
	@Then("I should see total money before use discount percent on Payment page")
	public void i_should_see_total_money_before_use_discount_percent_on_payment_page() {
		ThuocSi_CartPageActions.getInstance().verifyTotalMoneyPercent();

	}


}
