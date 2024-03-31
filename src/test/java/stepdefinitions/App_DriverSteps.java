package stepdefinitions;

import actions.App_DriverActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class App_DriverSteps {

	@When("I click skip button on App Driver ThuocSi")
	public void i_click_skip_button_on_app_driver_thuoc_si() {
		App_DriverActions.getInstance().clickBtnIgnore();
	}

	@When("I enters username on App Driver ThuocSi")
	public void i_enters_username_on_app_driver_thuoc_si() {
		App_DriverActions.getInstance().sendKeysUserName();
	}

	@When("I enters password on App Driver ThuocSi")
	public void i_enters_password_on_app_driver_thuoc_si() {
		App_DriverActions.getInstance().sendKeysPassword();
	}

	@When("I click signin button on App Driver ThuocSi")
	public void i_click_signin_button_on_app_driver_thuoc_si() {
		App_DriverActions.getInstance().clickBtnSignIn();

	}

	@When("I click location button on App Driver ThuocSi")
	public void i_click_location_button_on_app_driver_thuoc_si() {
		App_DriverActions.getInstance().clickBtnLocation();

	}

	@When("I click continous button on App Driver ThuocSi")
	public void i_click_continous_button_on_app_driver_thuoc_si() {
		App_DriverActions.getInstance().clickBtnContinous();

	}

	@When("I click location using button on App Driver ThuocSi")
	public void i_click_location_using_button_on_app_driver_thuoc_si() {
		App_DriverActions.getInstance().clickBtnUsing();

	}

	@Given("I click menu home button on App Driver ThuocSi")
	public void i_click_menu_home_button_on_app_driver_thuoc_si() {
		App_DriverActions.getInstance().clickBtnHome();

	}

}
