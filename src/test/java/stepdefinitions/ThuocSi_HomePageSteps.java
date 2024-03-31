package stepdefinitions;

import java.net.URLEncoder;
import java.util.HashMap;

import org.testng.Assert;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import actions.CommonActions;
import actions.ThuocSi_HomePageActions;
import actions.ThuocSi_ManageAccountPageActions;
import actions.ThuocSi_QuickOrderProductPageActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.CommonFunctions;
import utilities.ResetAssuredAPIFunctions;

public class ThuocSi_HomePageSteps {

	@When("I enter ammount product on Quick Order page")
	public void i_enter_ammount_product_on_quick_order_page() throws InterruptedException {
		ThuocSi_QuickOrderProductPageActions.getInstance().sendKeysAmmount();
	}

	@Then("I should see information product matches with cart on Quick Order page")
	public void i_should_see_information_product_matches_with_cart_on_quick_order_page() {
		ThuocSi_QuickOrderProductPageActions.getInstance().verifyCart();

	}

	@When("I click view cart on Quick Order page")
	public void i_click_view_cart_on_quick_order_page() {
		ThuocSi_QuickOrderProductPageActions.getInstance().clickBtnViewCart();

	}

	private static final int CODE_SUCCESS = 200;

	@Given("I open thuocsi page")
	public void i_open_thuocsi_page() {
		CommonActions.getInstance().openThuocSiPage();
	}

	@Given("I click button accept popup on the Home page")
	public void i_click_button_accept_popup_on_the_home_page() {
		ThuocSi_HomePageActions.getInstance().clickBtnAccept();
	}

	@When("I click button register on the Home Page")
	public void i_click_button_register_on_the_home_page() {
		ThuocSi_HomePageActions.getInstance().clickBtnRegister();
	}

	@When("I enters name of popup register on the Home page")
	public void i_enters_name_of_popup_register_on_the_home_page() {
		ThuocSi_HomePageActions.getInstance().sendKeysName();
	}

	@When("I enters phone of popup register on the Home page")
	public void i_enters_phone_of_popup_register_on_the_home_page() {
		ThuocSi_HomePageActions.getInstance().sendKeysPhone();
	}

	@When("I enters email of popup register on the Home page")
	public void i_enters_email_of_popup_register_on_the_home_page() {
		ThuocSi_HomePageActions.getInstance().sendKeysEmail();
	}

	@When("I enters password of popup register on the Home page")
	public void i_enters_password_of_popup_register_on_the_home_page() {
		ThuocSi_HomePageActions.getInstance().sendKeysPassword();
	}

	@When("I select province code of popup register on the Home page")
	public void i_select_province_code_of_popup_register_on_the_home_page() {
		ThuocSi_HomePageActions.getInstance().selectProvinceCode();
	}

	@When("I choose option radio of popup register on the Home page")
	public void i_choose_option_radio_of_popup_register_on_the_home_page() {
		ThuocSi_HomePageActions.getInstance().chooseRadioScope();
	}

	@When("I click check agree button of popup register on the Home page")
	public void i_click_check_agree_button_of_popup_register_on_the_home_page() {
		ThuocSi_HomePageActions.getInstance().clickCheckAgree();
	}

	@When("I click button register account of popup register on the Home page")
	public void i_click_button_register_account_of_popup_register_on_the_home_page() {
		ThuocSi_HomePageActions.getInstance().clickBtnRegisterAccount();
	}

	@Then("I should see message register success on the Home page")
	public void i_should_see_message_register_success_on_the_home_page() {
		ThuocSi_HomePageActions.getInstance().verifyMessageSucess();

	}

	@When("I click button sign in on the Home Page")
	public void i_click_button_sign_in_on_the_home_page() {
		ThuocSi_HomePageActions.getInstance().clickBtnSignIn();

	}

	@When("I enters phone {string} of popup sign in on the Home page")
	public void i_enters_phone_of_popup_sign_in_on_the_home_page(String accountPhone) {
		ThuocSi_HomePageActions.getInstance().sendKeysSignInUserName(accountPhone);

	}

	@When("I enters password {string} of popup sign in on the Home page")
	public void i_enters_password_of_popup_sign_in_on_the_home_page(String accountPassword) {
		ThuocSi_HomePageActions.getInstance().sendKeysSignInPassword(accountPassword);

	}

	@When("I click button sign in of popup sign in on the Home Page")
	public void i_click_button_sign_in_of_popup_sign_in_on_the_home_page() {
		ThuocSi_HomePageActions.getInstance().clickBtnSignInAccount();

	}

	@Then("I should see login success on the Home page")
	public void i_should_see_login_success_on_the_home_page() {
		ThuocSi_HomePageActions.getInstance().verifyLoginSuccess();

	}

	@Then("I should see product search with {string} on the Home page")
	public void i_should_see_product_search_with_on_the_home_page(String dataSearch) {
		ThuocSi_HomePageActions.getInstance().verifyDataSearch(dataSearch);

	}

	@Then("I should see product quick order search with {string} on the Home page")
	public void i_should_see_product_quick_order_search_with_on_the_home_page(String dataSearch) {
		ThuocSi_HomePageActions.getInstance().verifyDataQuickOrderSearch(dataSearch);

	}

	@When("I enters product name {string} on Quick Order page")
	public void i_enters_product_name_on_quick_order_page(String productName) {
		ThuocSi_QuickOrderProductPageActions.getInstance().sendKeysProductName(productName);

	}

	@When("I entes ammount {int} with product name {string} on Quick Order page")
	public void i_entes_ammount_with_product_name_on_quick_order_page(Integer ammount, String productName) {
		ThuocSi_QuickOrderProductPageActions.getInstance().sendKeysAmmountWithProductName(ammount, productName);

	}

	@When("I entes ammount {int} with random product name on Quick Order page")
	public void i_entes_ammount_with_random_product_name_on_quick_order_page(Integer ammount)
			throws InterruptedException {
		ThuocSi_QuickOrderProductPageActions.getInstance().sendKeysAmmountRandomProductName(ammount);

	}

	@When("I click button icon manage account on the Home page")
	public void i_click_button_icon_manage_account_on_the_home_page() {
		ThuocSi_HomePageActions.getInstance().clickIconManageAccount();

	}

	@When("I click button sub menu {string} on the Home page")
	public void i_click_button_sub_menu_on_the_home_page(String subMenu) {
		ThuocSi_ManageAccountPageActions.getInstance().clickSubMenu(subMenu);
		;

	}

	@When("I click button accumulated points on the Home page")
	public void i_click_button_accumulated_points_on_the_home_page() {
		ThuocSi_ManageAccountPageActions.getInstance().clickBtnExchangePoint();

	}

	@Then("I should see code accumulated points on the Home Page")
	public void i_should_see_code_accumulated_points_on_the_home_page() {
		ThuocSi_ManageAccountPageActions.getInstance().verifyCodeExchangePoint();

	}

	@When("I click button using exchange accumulated points on the Home Page")
	public void i_click_button_using_exchange_accumulated_points_on_the_home_page() {
		ThuocSi_ManageAccountPageActions.getInstance().clickBtnUsingExchangePoint();

	}

	@When("I call api login get token")
	public void i_call_api_login_get_token() {

		try {

			HashMap<String, String> filter = new HashMap<>();

			String input;
			// Call API Login

			filter.put("username", System.getProperty("dInternalUserName"));
			filter.put("password", System.getProperty("dInternalPassword"));
			filter.put("type", "EMPLOYEE");

			input = CommonFunctions.getInstance().mapToJson(filter);

			String response = ResetAssuredAPIFunctions.getInstance()
					.getBodyPostMethod(System.getProperty("apiLoginAccount"), input, CODE_SUCCESS);

			JsonObject jsonObject = new JsonParser().parse(response).getAsJsonObject();

			JsonArray jsonArray = jsonObject.getAsJsonArray("data");

			JsonElement item = jsonArray.get(0).getAsJsonObject();

			System.setProperty("token", item.getAsJsonObject().get("bearerToken").getAsString());

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@When("I call api get account code")
	public void i_call_api_get_account_code() {

		try {

			// Call API Search
			String phoneParam = "{\"phone\":\"" + System.getProperty("accountPhone") + "\"}";

			String encodedPhoneParam = URLEncoder.encode(phoneParam, "UTF-8");

			String url = System.getProperty("apiSearchAccountByPhone") + encodedPhoneParam;

			String response = ResetAssuredAPIFunctions.getInstance().getBodyGetMethod(url, System.getProperty("token"),
					CODE_SUCCESS);

			JsonObject jsonObject = new JsonParser().parse(response).getAsJsonObject();

			JsonArray jsonArray = jsonObject.getAsJsonArray("data");

			JsonElement item = jsonArray.get(0).getAsJsonObject();

			System.setProperty("accountCode", item.getAsJsonObject().get("code").getAsString());

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@When("I call api active account")
	public void i_call_api_active_account() {

		try {

			HashMap<String, String> filter = new HashMap<>();

			String input;

			// Call API get Account data

			filter.put("code", System.getProperty("accountCode"));
			filter.put("status", "ACTIVE");

			input = CommonFunctions.getInstance().mapToJson(filter);

			ResetAssuredAPIFunctions.getInstance().callPutMethodResponse(System.getProperty("apiActiveAccount"),
					System.getProperty("token"), input, CODE_SUCCESS);

			CommonFunctions.getInstance().refresh();

			CommonFunctions.getInstance().waitForPageLoad(Integer.parseInt(System.getProperty("objectTimeout")));

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@When("I call api delete account")
	public void i_call_api_delete_account() {
		try {

			HashMap<String, String> filter = new HashMap<>();

			String input;

			// Call API get Account data

			filter.put("code", System.getProperty("accountCode"));
			filter.put("status", "DELETED");

			input = CommonFunctions.getInstance().mapToJson(filter);

			ResetAssuredAPIFunctions.getInstance().callPutMethodResponse(System.getProperty("apiDeleteAccount"),
					System.getProperty("token"), input, CODE_SUCCESS);

			CommonFunctions.getInstance().refresh();

			CommonFunctions.getInstance().waitForPageLoad(Integer.parseInt(System.getProperty("objectTimeout")));

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

}
