package stepdefinitions;

import actions.CommonActions;
import actions.Supplier_LoginPageActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class Supplier_LoginSteps {
	
	@Given("I open Supplier page")
	public void i_open_supplier_page() {
		CommonActions.getInstance().openSupplierPage();
	}

	@When("I enters name on the Login Supplier page")
	public void i_enters_name_on_the_login_supplier_page() {
		Supplier_LoginPageActions.getInstance().sendKeysUserName();

	}

	@When("I enters password on the Login Supplier page")
	public void i_enters_password_on_the_login_supplier_page() {
		Supplier_LoginPageActions.getInstance().sendKeysPassword();
	}

	@When("I click sign in button on the Login Supplier page")
	public void i_click_sign_in_button_on_the_login_supplier_page() {
		Supplier_LoginPageActions.getInstance().clickBtnSignIn();
	}
}
