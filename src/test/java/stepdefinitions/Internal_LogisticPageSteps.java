package stepdefinitions;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;

import org.json.JSONException;
import org.testng.Assert;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import actions.Internal_LogisticActions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.CommonFunctions;
import utilities.ResetAssuredAPIFunctions;

public class Internal_LogisticPageSteps {

	public static final int CODE_SUCCESS = 200;
	
	@When("I click menu logistic button on the Internal Detail Ticket WMS page")
	public void i_click_menu_logistic_button_on_the_internal_detail_ticket_wms_page() {
		Internal_LogisticActions.getInstance().clickMenuLogistic();

	}
	
	
	@When("I click HUB button on the Internal Logistic page")
	public void i_click_hub_button_on_the_internal_logistic_page() {
		Internal_LogisticActions.getInstance().clickBtnHUB();

	}

	@When("I enters hub search on the Internal Logistic page")
	public void i_enters_hub_search_on_the_internal_logistic_page() {
		Internal_LogisticActions.getInstance().sendKeysHub();

	}

	@When("I enters my hub search on the Internal Logistic page")
	public void i_enters_my_hub_search_on_the_internal_logistic_page() {
		Internal_LogisticActions.getInstance().sendKeysMyHub();

	}

	@When("I click item hub on the Internal Logistic page")
	public void i_click_item_hub_on_the_internal_logistic_page() {
		Internal_LogisticActions.getInstance().clickItemHub();

	}

	@When("I click item my hub on the Internal Logistic page")
	public void i_click_item_my_hub_on_the_internal_logistic_page() {
		Internal_LogisticActions.getInstance().clickItemMyHub();

	}

	@When("I get number so on the Internal Logistic Manage Hub page")
	public void i_get_number_so_on_the_internal_logistic_manage_hub_page() {
		Internal_LogisticActions.getInstance().getNumberSOHub();

	}

	@When("I click handover button on the Internal Logistic Manage Hub page")
	public void i_click_handover_button_on_the_internal_logistic_manage_hub_page() {
		Internal_LogisticActions.getInstance().clickBtnHandOver();

	}

	@When("I click submenu handover button on the Internal Logistic Manage Hub page")
	public void i_click_submenu_handover_button_on_the_internal_logistic_manage_hub_page() {
		Internal_LogisticActions.getInstance().clickBtnSubHandOver();

	}

	@When("I select option handover on the Internal Logistic Handover page")
	public void i_select_option_handover_on_the_internal_logistic_handover_page() {
		Internal_LogisticActions.getInstance().selectOptionHandover();

	}

	@When("I select name from hub handover on the Internal Logistic Handover page")
	public void i_select_name_from_hub_handover_on_the_internal_logistic_handover_page() {
		Internal_LogisticActions.getInstance().selectNameFromHub();

	}

	@When("I select name to hub handover on the Internal Logistic Handover page")
	public void i_select_name_to_hub_handover_on_the_internal_logistic_handover_page() {
		Internal_LogisticActions.getInstance().selectNameToHub();

	}

	@When("I select license plate on the Internal Logistic Handover page")
	public void i_select_license_plate_on_the_internal_logistic_handover_page() {
		Internal_LogisticActions.getInstance().selectLicensePlate();

	}

	@When("I click start delivery button Internal Logistic Handover page")
	public void i_click_start_delivery_button_internal_logistic_handover_page() {
		Internal_LogisticActions.getInstance().clickBtnStartDelivery();

	}

	@When("I get ticket transport on the Internal Logistic Handover page")
	public void i_get_ticket_transport_on_the_internal_logistic_handover_page() {
		Internal_LogisticActions.getInstance().getTicketTransport();

	}

	@When("I scan ticket number so on the Internal Logistic Handover page")
	public void i_scan_ticket_number_so_on_the_internal_logistic_handover_page() {
		Internal_LogisticActions.getInstance().scanTicket();

	}

	@When("I click complete rotation button on the Internal Logistic Handover page")
	public void i_click_complete_rotation_button_on_the_internal_logistic_handover_page() {
		Internal_LogisticActions.getInstance().clickBtnCompleteRotation();

	}

	@When("I click wating for stock button on the Internal Logistic Managehub page")
	public void i_click_wating_for_stock_button_on_the_internal_logistic_managehub_page() {

		Internal_LogisticActions.getInstance().clickBtnWaitingSTock();

		Internal_LogisticActions.getInstance().clickCheckbox();

	}

	@When("I click receipt button on the Internal Logistic Managehub page")
	public void i_click_receipt_button_on_the_internal_logistic_managehub_page() {
		Internal_LogisticActions.getInstance().clickBtnReceipt();

	}

	@When("I click finish ticket button on the Internal Logistic Managehub page")
	public void i_click_finish_ticket_button_on_the_internal_logistic_managehub_page() {
		Internal_LogisticActions.getInstance().clickBtnFinishTicket();

	}

	@When("I enters scan oders on the Internal Logistic Managehub page")
	public void i_enters_scan_oders_on_the_internal_logistic_managehub_page() {
		Internal_LogisticActions.getInstance().sendKeysScanOrder();

	}

	@When("I click confirm finish button on the Internal Logistic Managehub page")
	public void i_click_confirm_finish_button_on_the_internal_logistic_managehub_page() {
		Internal_LogisticActions.getInstance().clickBtnConfirm();

	}

	@When("I click assign driver button on the Internal Logistic Managehub page")
	public void i_click_assign_driver_button_on_the_internal_logistic_managehub_page() {

		Internal_LogisticActions.getInstance().clickCheckbox();

		Internal_LogisticActions.getInstance().clickBtnAssignDriver();

	}

	@When("I select driver on the Internal Logistic Managehub page")
	public void i_select_driver_on_the_internal_logistic_managehub_page() {
		Internal_LogisticActions.getInstance().selectDriver();

	}

	@When("I call api login account driver get token")
	public void i_call_api_login_account_driver_get_token() {
		try {

			HashMap<String, String> filter = new HashMap<>();

			String input;
			// Call API Login

			filter.put("username", System.getProperty("dUserNameDriver"));
			filter.put("password", System.getProperty("dPasswordDriver"));
			filter.put("type", "EMPLOYEE");

			input = CommonFunctions.getInstance().mapToJson(filter);

			String response = ResetAssuredAPIFunctions.getInstance()
					.getBodyPostMethod(System.getProperty("apiLoginAccount"), input, CODE_SUCCESS);

			JsonObject jsonObject = new JsonParser().parse(response).getAsJsonObject();

			JsonArray jsonArray = jsonObject.getAsJsonArray("data");

			JsonElement item = jsonArray.get(0).getAsJsonObject();

			System.setProperty("bearerTokenDriver", item.getAsJsonObject().get("bearerToken").getAsString());

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@When("I call api change status delivering")
	public void i_call_api_change_status_delivering() {
		try {

			Thread.sleep(5000);

			HashMap<String, String> filter = new HashMap<>();

			String input;

			// Call API get Account data

			filter.put("hubCode", System.getProperty("myHubSearch"));
			filter.put("referenceCode", System.getProperty("numberSOHub"));
			filter.put("trackingCode", System.getProperty("trackingCode"));
			filter.put("status", "DELIVERING");

			input = CommonFunctions.getInstance().mapToJson(filter);

			String response = ResetAssuredAPIFunctions.getInstance().getBodyPutMethod(
					System.getProperty("apiChangeStatusDeliver"), System.getProperty("bearerTokenDriver"), input,
					CODE_SUCCESS);

			System.out.println(response);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@When("I call api change status delivered")
	public void i_call_api_change_status_delivered() {
		try {

			JsonObject jsonObject = new JsonObject();

			// Call API get Account data

			jsonObject.addProperty("hubCode", System.getProperty("myHubSearch")); // Update with the desired hubCode
			jsonObject.addProperty("referenceCode", System.getProperty("numberSOHub")); // Update with the desired
																						// referenceCode
			jsonObject.addProperty("trackingCode", System.getProperty("trackingCode")); // Update with the desired
																						// trackingCode
			jsonObject.addProperty("status", "DELIVERED"); // Update with the desired status

			// Create the extraInfo object
			JsonObject extraInfoObject = new JsonObject();

			// Create the pod array and add the URL
			JsonArray podArray = new JsonArray();
			podArray.add("https://storage.googleapis.com/thuocsi-testing/WMS/2023-06/2023bfb79a174f8a3cfdd60e5853171c");
			extraInfoObject.add("pod", podArray);

			// Create the signature object
			JsonObject signatureObject = new JsonObject();
			signatureObject.addProperty("signatureImage",
					"https://storage.googleapis.com/thuocsi-testing/WMS/2023-06/2023e21d2740d4f24b77d6ca94288350");
			signatureObject.addProperty("signerName", "Thịnh Trần");
			signatureObject.addProperty("type", "SENDER_SIGN");

			// Create the signature array and add the signature object
			JsonArray signatureArray = new JsonArray();
			signatureArray.add(signatureObject);
			extraInfoObject.add("signature", signatureArray);

			// Add the extraInfo object to the main jsonObject
			jsonObject.add("extraInfo", extraInfoObject);

			String response = ResetAssuredAPIFunctions.getInstance().getBodyPutMethod(
					System.getProperty("apiChangeStatusDeliver"), System.getProperty("bearerTokenDriver"),
					jsonObject.toString(), CODE_SUCCESS);

			System.out.println(response);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@When("I call api get reconcile code")
	public void i_call_api_get_reconcile_code() throws JSONException, IOException {

		// Call API Search
		String queryParam = "{\"isDraft\":false,\"hubCode\":\"" + System.getProperty("myHubSearch")
				+ "\",\"reconcileType\":\"RIDER_HUB\",\"statuses\":[\"WAIT_TO_PAYMENT\"]}&offset=0&limit=10";
		;

		String encodedQueryParam = URLEncoder.encode(queryParam, "UTF-8");

		String url = System.getProperty("apiGetListWatting") + encodedQueryParam;

		String response = ResetAssuredAPIFunctions.getInstance().getBodyGetMethod(url,
				System.getProperty("bearerTokenDriver"), CODE_SUCCESS);

		JsonObject jsonObject = new JsonParser().parse(response).getAsJsonObject();

		JsonArray jsonArray = jsonObject.getAsJsonArray("data");

		JsonElement item = jsonArray.get(0).getAsJsonObject();

		System.setProperty("code", item.getAsJsonObject().get("code").getAsString());
	}

	@When("I call api get line id")
	public void i_call_api_get_line_id() throws JSONException, IOException {
		// Call API Search
		String queryParam = "{\"reconcileCode\":\"" + System.getProperty("code") + "\",\"statuses\":[\"INIT\"]}";

		String encodedQueryParam = URLEncoder.encode(queryParam, "UTF-8");

		String url = System.getProperty("apiGetDetailOrder") + encodedQueryParam;

		String response = ResetAssuredAPIFunctions.getInstance().getBodyGetMethod(url,
				System.getProperty("bearerTokenDriver"), CODE_SUCCESS);

		JsonObject jsonObject = new JsonParser().parse(response).getAsJsonObject();

		JsonArray jsonArray = jsonObject.getAsJsonArray("data");

		JsonElement item = jsonArray.get(0).getAsJsonObject();

		String referenceCode = item.getAsJsonObject().get("referenceCode").getAsString();

		if (referenceCode.equals(System.getProperty("numberSOHub"))) {

			System.setProperty("lineID", item.getAsJsonObject().get("lineID").getAsString());

		}

	}

	@When("I call api change status order checking")
	public void i_call_api_change_status_order_checking() {
		try {

			JsonObject jsonObject = new JsonObject();

			String input;

			jsonObject.addProperty("lineID", Integer.parseInt(System.getProperty("lineID"))); // Update with the desired
																								// hubCode
			jsonObject.addProperty("hubCode", System.getProperty("myHubSearch")); // Update with the desired hubCode
			jsonObject.addProperty("referenceCode", System.getProperty("numberSOHub")); // Update with the desired
																						// referenceCode
			jsonObject.addProperty("trackingCode", System.getProperty("trackingCode")); // Update with the desired
																						// trackingCode
			jsonObject.addProperty("reconcileType", "RIDER_HUB"); // Update with the desired trackingCode
			jsonObject.addProperty("carrierCodAmount", Integer.parseInt(System.getProperty("totalMoney")));
			jsonObject.addProperty("status", "CHECKING"); // Update with the desired status

			JsonArray jsonArray = new JsonArray();
			jsonArray.add(jsonObject);

			input = jsonArray.toString();

			String response = ResetAssuredAPIFunctions.getInstance().getBodyPutMethod(
					System.getProperty("apiChangeStatusReconcileOrder"), System.getProperty("bearerTokenDriver"), input,
					CODE_SUCCESS);

			System.out.println(response);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@When("I call api change status reconcile seesion")
	public void i_call_api_change_status_reconcile_seesion() {
		try {

			JsonObject jsonObject = new JsonObject();

			String input;

			jsonObject.addProperty("code", System.getProperty("code")); // Update with the desired hubCode
			jsonObject.addProperty("status", "WAIT_TO_APPROVE"); // Update with the desired status
			jsonObject.addProperty("reconcileType", "RIDER_HUB");

			input = jsonObject.toString();

			String response = ResetAssuredAPIFunctions.getInstance().getBodyPutMethod(
					System.getProperty("apiChangeStatusReconcileSession"), System.getProperty("bearerTokenDriver"),
					input, CODE_SUCCESS);

			System.out.println(response);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@When("I click control driver button on the Internal Logistic Managehub page")
	public void i_click_control_driver_button_on_the_internal_logistic_managehub_page() {
		Internal_LogisticActions.getInstance().clickBtnControl();
		Internal_LogisticActions.getInstance().clickBtnControlDriver();

	}

	@When("I enter number ticket on the Internal Logistic Managehub Control Driver page")
	public void i_enter_number_ticket_on_the_internal_logistic_managehub_control_driver_page() {
		Internal_LogisticActions.getInstance().sendKeysNumberTicket();

	}

	@When("I click detail ticket on the Internal Logistic Managehub Control Driver page")
	public void i_click_detail_ticket_on_the_internal_logistic_managehub_control_Driver_page() {
		Internal_LogisticActions.getInstance().clicBtnDetailTicket();

	}

	@Then("I should see total money on the Internal Logistic Managehub Control Driver page")
	public void i_should_see_total_money_on_the_internal_logistic_managehub_control_driver_page() {
		Internal_LogisticActions.getInstance().verifyCodMoney();

	}

	@When("I click for control button on the Internal Logistic Managehub Control Driver page")
	public void i_click_for_control_button_on_the_internal_logistic_managehub_control_driver_page() {
		Internal_LogisticActions.getInstance().clickBtnForControl();

	}

	@When("I click control accountant button on the Internal Logistic Managehub page")
	public void i_click_control_accountant_button_on_the_internal_logistic_managehub_page() {
		Internal_LogisticActions.getInstance().clickBtnControl();
		Internal_LogisticActions.getInstance().clickBtnControlAccountain();

	}

	@When("I click detail ticket accountain on the Internal Logistic Managehub Control Accountain page")
	public void i_click_detail_ticket_accountain_on_the_internal_logistic_managehub_control_accountainpage() {
		Internal_LogisticActions.getInstance().clickBtnAccountingTicket();

	}

	@When("I enters ticket numbers on the Internal Logistic Managehub Control Accountain page")
	public void i_enters_ticket_numbers_on_the_internal_logistic_managehub_control_accountain_page() {
		Internal_LogisticActions.getInstance().sendKeysNumberTicketAccountain();

	}

	@When("I click item ticket on the Internal Logistic Managehub Control Accountain page")
	public void i_click_item_ticket_on_the_internal_logistic_managehub_control_accountain_page() {
		Internal_LogisticActions.getInstance().clickItemNumberTicket();

	}
	
	@When("I enters money on the Internal Logistic Managehub Control Accountain page")
	public void i_enters_money_on_the_internal_logistic_managehub_control_accountain_page() {
		Internal_LogisticActions.getInstance().sendKeysMoney();

	}
	
	@When("I click payment button on the Internal Logistic Managehub Control Accountain page")
	public void i_click_payment_button_on_the_internal_logistic_managehub_control_accountain_page() {
		Internal_LogisticActions.getInstance().clickBtnPayment();

	}

}
