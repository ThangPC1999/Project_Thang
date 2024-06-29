package stepdefinitions;

import actions.Facebook_Actions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Facebook_Login {
	@Given("I open facebook page")
	public void i_open_facebook_page() {
	    // Write code here that turns the phrase above into concrete actions
		Facebook_Actions.getInstance().openFacebookPage();
	    throw new io.cucumber.java.PendingException();
	}
	@When("I click textbox number phone on the Facebook page")
	public void i_click_textbox_number_phone_on_the_facebook_page() {
	    // Write code here that turns the phrase above into concrete actions
		Facebook_Actions.getInstance().senkeysMail();
	    throw new io.cucumber.java.PendingException();
	}
	@When("I enters phone of textbox login Facebook")
	public void i_enters_phone_of_textbox_login_facebook() {
	    // Write code here that turns the phrase above into concrete actions
		Facebook_Actions.getInstance().senkeysMail();
	    throw new io.cucumber.java.PendingException();
	}
	@When("I enters password of textbox login Facebook")
	public void i_enters_password_of_textbox_login_facebook() {
	    // Write code here that turns the phrase above into concrete actions
		Facebook_Actions.getInstance().senkeysPass();
	    throw new io.cucumber.java.PendingException();
	}
	@When("I click button Login on the Facebook page")
	public void i_click_button_login_on_the_facebook_page() {
	    // Write code here that turns the phrase above into concrete actions
		Facebook_Actions.getInstance().clicklLoginBtn();
	    throw new io.cucumber.java.PendingException();
	}
	@Then("I should see message login success on the Facebook page")
	public void i_should_see_message_login_success_on_the_facebook_page() {
	    // Write code here that turns the phrase above into concrete actions
		Facebook_Actions.getInstance().successMgs();
	    throw new io.cucumber.java.PendingException();
	    //update code
	}

}
