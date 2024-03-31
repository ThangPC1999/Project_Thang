package stepdefinitions;

import actions.CommonActions;
import actions.Internal_LoginPageActions;
import io.cucumber.java.en.When;

public class Internal_LoginPageSteps {
	
	public final static int CODE_SUCCESS = 200;

	@When("I open new tab")
	public void i_open_new_tab() {
		CommonActions.getInstance().openNewTab();
	}

	@When("I open internal page")
	public void i_open_internal_page() {
		CommonActions.getInstance().openInternalPage();
	}

	@When("I enters name on the Login Internal page")
	public void i_enters_name_on_the_login_internal_page() {
		Internal_LoginPageActions.getInstance().sendKeysUserName();
	}

	@When("I enters password on the Login Internal page")
	public void i_enters_password_on_the_login_internal_page() {
		Internal_LoginPageActions.getInstance().sendKeysPassword();

	}

	@When("I click sign in button on the Login Internal page")
	public void i_click_sign_in_button_on_the_login_internal_page() {
		Internal_LoginPageActions.getInstance().clickBtnSignIn();

	}

}
