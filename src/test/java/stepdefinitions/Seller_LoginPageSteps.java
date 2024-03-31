package stepdefinitions;

import actions.Seller_LoginPageActions;
import io.cucumber.java.en.Given;

public class Seller_LoginPageSteps {

	@Given("I enters name on the Login Seller page")
	public void i_enters_name_on_the_login_seller_page() {
		Seller_LoginPageActions.getInstance().sendKeysUserName();
	}

	@Given("I enters password on the Login Seller page")
	public void i_enters_password_on_the_login_seller_page() {
		Seller_LoginPageActions.getInstance().sendKeysPassword();
	}

	@Given("I click sign in button on the Login Seller page")
	public void i_click_sign_in_button_on_the_login_seller_page() {
		Seller_LoginPageActions.getInstance().clickBtnSignIn();
	}
}
