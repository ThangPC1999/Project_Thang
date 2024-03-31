package stepdefinitions;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import actions.Internal_MEDXActions;
import actions.Internal_WMSActions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.CommonFunctions;
import utilities.ResetAssuredAPIFunctions;

public class Internal_WMSPageSteps {

	private static final int CODE_SUCCESS = 200;

	@When("I click menu warehouse on the Internal Home page")
	public void i_click_menu_warehouse_on_the_internal_home_page() {
		Internal_WMSActions.getInstance().clickMenuWarehouse();

	}

	@When("I click warehouse {string} on the Internal WMS page")
	public void i_click_warehouse_on_the_internal_wms_page(String optionName) {
		Internal_WMSActions.getInstance().clickNameWarehouse(optionName);

	}

	@When("I click menu manage warehouse on the Internal WSM page")
	public void i_click_menu_manage_warehouse_on_the_internal_wsm_page() {
		Internal_WMSActions.getInstance().clickBtnManageWareHouse();
	}

	@When("I click sub menu setting location product on the Internal WSM page")
	public void i_click_sub_menu_setting_location_product_on_the_internal_wsm_page() {
		Internal_WMSActions.getInstance().clickSubMenuSetting();

	}

	@When("I enters product search on the Internal WSM page")
	public void i_enters_product_search_on_the_internal_wsm_page() {
		Internal_WMSActions.getInstance().sendKeysSearchProduct();

	}

	@When("I click item internal transfer on the WSM page")
	public void i_click_item_internal_transfer_on_the_wsm_page() {
		Internal_WMSActions.getInstance().clickBtnInternalTransfer();

	}

	@When("I click create request button on the WSM page")
	public void i_click_create_request_button_on_the_wsm_page() {
		Internal_WMSActions.getInstance().clickBtnCreateRequest();

	}

	@When("I enters information from wareshouse on the WSM page")
	public void i_enters_information_from_wareshouse_on_the_wsm_page() {
		Internal_WMSActions.getInstance().clickFromWarehouse();

	}

	@When("I enters information to wareshouse on the WSM page")
	public void i_enters_information_to_wareshouse_on_the_wsm_page() {
		Internal_WMSActions.getInstance().clickToWarehouse();

	}

	@When("I enters location search on the Internal WSM page")
	public void i_enters_location_search_on_the_internal_wsm_page() {
		Internal_WMSActions.getInstance().settingLocations();

	}

	@When("I click add line product on the WSM page")
	public void i_click_add_line_product_on_the_wsm_page() {
		Internal_WMSActions.getInstance().clickAddLineProduct();

	}

	@When("I get button empty bakset on Manage Warehouse WSM page")
	public void i_get_button_empty_bakset_on_manage_warehouse_wsm_page() throws InterruptedException {
		Internal_WMSActions.getInstance().getEmptyBasketCode();

	}

	@When("I click item inventory on the WSM page")
	public void i_click_item_inventory_on_the_wsm_page() {
		Internal_WMSActions.getInstance().clickBtnInventory();

	}

	@When("I click view ticket pick button on the WSM page")
	public void i_click_view_ticket_pick_button_on_the_wsm_page() {
		Internal_WMSActions.getInstance().clickViewTicketPick();

	}

	@When("I click active ticket on the Detail Ticket WSM page")
	public void i_click_active_ticket_on_the_detail_ticket_wsm_page() {
		Internal_WMSActions.getInstance().clickBtnActiveTicket();

	}

	@When("I enters reason active ticket on the Detail Ticket WSM page")
	public void i_enters_reason_active_ticket_on_the_detail_ticket_wsm_page() {
		Internal_WMSActions.getInstance().sendKeysReasonActive();

	}

	@When("I click active button on Detail Ticket WSM page")
	public void i_click_active_button_on_detail_ticket_wsm_page() {
		Internal_WMSActions.getInstance().clickBtnActive();

	}

	@Then("I should see status change {string} on the Internal Detail Ticket WMS page")
	public void i_should_see_status_change_on_the_internal_detail_ticket_wms_page(String data) {
		try {

			Internal_WMSActions.getInstance().verifyStatusChange(data);

		} catch (Exception e) {

			i_call_api_delete_ticket();

			Assert.fail(e.getMessage());
		}

	}

	@When("I click button empty bakset on Manage Warehouse WSM page")
	public void i_click_buttonempty_bakset_on_manage_warehouse_wsm_page() {
		try {

			Internal_WMSActions.getInstance().getBasketCode();

		} catch (Exception e) {

			i_call_api_delete_ticket();

			Assert.fail(e.getMessage());
		}
	}

	@When("I click menu QC on the WSM page")
	public void i_click_menu_qc_on_the_wsm_page() {
		try {

			Internal_WMSActions.getInstance().clickMenuQC();

		} catch (Exception e) {

			i_call_api_delete_ticket();

			Assert.fail(e.getMessage());
		}
	}

	@When("I click button start shift on the QC WSM page")
	public void i_click_button_start_shift_on_the_qc_wsm_page() {
		try {

			Internal_WMSActions.getInstance().clickBtnStartShift();

		} catch (Exception e) {

			i_call_api_delete_ticket();

			Assert.fail(e.getMessage());
		}
	}

	@When("I enters number pick on the QC WSM page")
	public void i_enters_number_pick_on_the_qc_wsm_page() {
		try {

			Internal_WMSActions.getInstance().sendKeysNumberPick();

		} catch (Exception e) {

			i_call_api_delete_ticket();

			Assert.fail(e.getMessage());
		}
	}

	@When("I enters location on the QC WSM page")
	public void i_enters_location_on_the_qc_wsm_page() {
		try {

			Internal_WMSActions.getInstance().sendKeysLocationSearch();

		} catch (Exception e) {

			i_call_api_delete_ticket();

			Assert.fail(e.getMessage());
		}
	}

	@When("I click apply on the QC WSM page")
	public void i_click_apply_on_the_qc_wsm_page() {
		try {

			Internal_WMSActions.getInstance().clickBtnApply();

		} catch (Exception e) {

			i_call_api_delete_ticket();

			Assert.fail(e.getMessage());
		}
	}

	@When("I coppy qr code on the QC WSM page")
	public void i_coppy_qr_code_on_the_qc_wsm_page() {
		try {

			Internal_WMSActions.getInstance().sendKeysQR();

		} catch (Exception e) {

			i_call_api_delete_ticket();

			Assert.fail(e.getMessage());
		}
	}

	@When("I click book logistic button on the Internal Detail Ticket WMS page")
	public void i_click_book_logistic_button_on_the_internaldetail_ticket_wms_page() {
		try {

			Internal_WMSActions.getInstance().clickBtnBookLogistic();

		} catch (Exception e) {

			i_call_api_delete_ticket();

			Assert.fail(e.getMessage());
		}
	}

	@When("I click button finished on the QC WSM page")
	public void i_click_button_finished_on_the_qc_wsm_page() {
		try {

			Internal_WMSActions.getInstance().clickBtnFinish();

		} catch (Exception e) {

			i_call_api_delete_ticket();

			Assert.fail(e.getMessage());
		}
	}

	@When("I click menu checkin inbound on the Internal WMS page")
	public void i_click_menu_checkin_inbound_on_the_internal_wms_page() {

		Internal_WMSActions.getInstance().clickMenuInbound();

		Internal_WMSActions.getInstance().clickSubMenuReceive();

		Internal_WMSActions.getInstance().clickSubMenuSubInboundCheckIn();

	}

	@When("I click button close popup on the Internal WMS Inbound Checkin page")
	public void i_click_button_close_popup_on_the_internal_wms_inbound_checkin_page() {
		Internal_WMSActions.getInstance().clickBtnClosed();

	}

	@When("I enters number ticket on the Internal WMS Inbound Checkin page")
	public void i_enters_number_ticket_on_the_internal_wms_inbound_checkin_page() {
		Internal_WMSActions.getInstance().sendKeysTicketCode();

	}

	@When("I click button checkin on the Internal WMS Inbound Checkin page")
	public void i_click_button_checkin_on_the_internal_wms_inbound_checkin_page() {
		Internal_WMSActions.getInstance().clickBtnCheckIn();

	}

	@When("I enters checkin number on the Internal WMS Inbound Checkin page")
	public void i_enters_checkin_number_on_the_internal_wms_inbound_checkin_page() {
		Internal_WMSActions.getInstance().sendKeysCheckInNum();

	}

	@When("I click menu receive session inbound on the Internal WMS Inbound Checkin page")
	public void i_click_menu_receive_session_inbound_on_the_internal_wms_Inbound_checkin_page() {
		Internal_WMSActions.getInstance().clickMenuInbound();

		Internal_WMSActions.getInstance().clickSubMenuReceive();

		Internal_WMSActions.getInstance().clickSubMenuSubReceiveSession();

	}

	@When("I enters search on the Internal WMS Inbound Checkin page")
	public void i_enters_search_on_the_internal_wms_inbound_checkin_page() {
		Internal_WMSActions.getInstance().sendKeysSearchPO();

	}

	@When("I click number session on the Internal WMS Inbound Checkin page")
	public void i_click_number_session_on_the_internal_wms_inbound_checkin_page() {
		Internal_WMSActions.getInstance().clickBtnNumberSession();

	}

	@When("I click button check conveyor on the Internal WMS Inbound Checkin page")
	public void i_click_button_check_conveyor_on_the_internal_wms_inbound_checkin_page() {
		Internal_WMSActions.getInstance().clickBtnCheckConveyor();

	}

	@When("I click button link PO on the Internal MEDX Ticket PO page")
	public void i_click_button_link_po_on_the_internal_medx_ticket_po_page() {
		Internal_WMSActions.getInstance().clickBtnLinkPO();

	}

	@When("I click button connect on the Internal WMS Inbound Checkin page")
	public void i_click_button_connect_on_the_internal_wms_inbound_checkin_page() {
		Internal_WMSActions.getInstance().clickBtnConnect();

	}

	@When("I click button create code on the Internal WMS Inbound Checkin page")
	public void i_click_button_create_code_on_the_internal_wms_inbound_checkin_page() {
		Internal_WMSActions.getInstance().clickBtnCreateCode();

	}

	@When("I enters code on the Internal WMS Inbound Checkin page")
	public void i_enters_code_on_the_internal_wms_inbound_checkin_page() {
		Internal_WMSActions.getInstance().sendKeysCode();

	}

	@When("I enters empty basket code on the Internal WMS Inbound Checkin page")
	public void i_enters_empty_basket_code_on_the_internal_wms_inbound_checkin_page() {
		Internal_WMSActions.getInstance().sendKeysBasketCode();

	}

	@When("I click button view detail on the Internal WMS Inbound Checkin page")
	public void i_click_button_view_detail_on_the_internal_wms_inbound_checkin_page() {
		Internal_WMSActions.getInstance().clickBtnViewDetail();

	}

	@When("I enters lot on the Internal WMS Inbound Checkin page")
	public void i_enters_lot_on_the_internal_wms_inbound_checkin_page() {
		Internal_WMSActions.getInstance().sendKeysLot();

	}

	@When("I enters date on the Internal WMS Inbound Checkin page")
	public void i_enters_date_on_the_internal_wms_inbound_checkin_page() {
		Internal_WMSActions.getInstance().sendKeysDate();

	}

	@When("I click button update lot date on the Internal WMS Inbound Checkin page")
	public void i_click_button_update_lot_date_on_the_internal_wms_inbound_checkin_page() {
		Internal_WMSActions.getInstance().clickBtnUpdateLotDate();

	}

	@When("I click button edit on the Internal WMS Inbound Checkin page")
	public void i_click_button_edit_on_the_internal_wms_inbound_checkin_page() {
		Internal_WMSActions.getInstance().clickBtnEditAmmount();

	}

	@When("I enter new ammounts on the Internal WMS Inbound Checkin page")
	public void i_enter_new_ammounts_on_the_internal_wms_inbound_checkin_page() {
		Internal_WMSActions.getInstance().sendKeysNewAmmount();

	}

	@When("I click button update on the Internal WMS Inbound Checkin page")
	public void i_click_button_update_on_the_internal_wms_inbound_checkin_page() {
		Internal_WMSActions.getInstance().clickBtnUpdateAmmount();
	}

	@When("I click button finish on the Internal WMS Inbound Checkin page")
	public void i_click_button_finish_on_the_internal_wms_inbound_checkin_page() {
		Internal_WMSActions.getInstance().clickBtnFinishDetail();

	}

	@When("I click button detail PO on the Internal WMS Inbound Checkin page")
	public void i_click_button_detail_po_on_the_internal_wms_inbound_checkin_page() {
		Internal_WMSActions.getInstance().clickLinkDetailPO();

	}

	@When("I get qr po on the Internal WMS Inbound Detail PO page")
	public void i_get_qr_po_on_the_internal_wms_inbound_detail_po_page() {
		Internal_WMSActions.getInstance().getQrPO();

	}

	@When("I redirect to detail product skus on the Internal WMS Warehouse page")
	public void i_redirect_to_detail_product_skus_on_the_internal_wms_warehouse_page() {
		Internal_WMSActions.getInstance().redirectToListSkus();

	}

	@Then("I should see ammount availability increase on the Internal WMS Warehouse page")
	public void i_should_see_ammount_availability_increase_on_the_internal_wms_warehouse_page() {
		Internal_WMSActions.getInstance().verifyAmmount();

	}

	@When("I call api login account pick get token")
	public void i_call_api_login_account_pick_get_token() {
		try {

			HashMap<String, String> filter = new HashMap<>();

			String input;
			// Call API Login

			filter.put("username", System.getProperty("dUserNamePick"));
			filter.put("password", System.getProperty("dPasswordPick"));
			filter.put("type", "EMPLOYEE");

			input = CommonFunctions.getInstance().mapToJson(filter);

			String response = ResetAssuredAPIFunctions.getInstance()
					.getBodyPostMethod(System.getProperty("apiLoginAccount"), input, CODE_SUCCESS);

			JsonObject jsonObject = new JsonParser().parse(response).getAsJsonObject();

			JsonArray jsonArray = jsonObject.getAsJsonArray("data");

			JsonElement item = jsonArray.get(0).getAsJsonObject();

			System.setProperty("tokenPick", item.getAsJsonObject().get("bearerToken").getAsString());

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@When("I call api checkin zone pick")
	public void i_call_api_checkin_zone_pick() {
		try {

			HashMap<String, String> filter = new HashMap<>();

			String warehouseCode = "";

			if (System.getProperty("regionName").equals("Miền Bắc")) {

				warehouseCode = "HN";

			} else if (System.getProperty("regionName").equals("Miền Nam")) {

				warehouseCode = "BD";

			}

			String input;
			// Call API Login

			filter.put("zoneCode", System.getProperty("zoneCode"));
			filter.put("status", "CHECK_IN_ZONE");
			filter.put("jobType", "PICK");
			filter.put("warehouseCode", warehouseCode);

			input = CommonFunctions.getInstance().mapToJson(filter);

			String response = ResetAssuredAPIFunctions.getInstance().getBodyPostMethod(
					System.getProperty("apiCheckinZone"), System.getProperty("tokenPick"), input, CODE_SUCCESS);

			JsonObject jsonObject = new JsonParser().parse(response).getAsJsonObject();

			JsonArray jsonArray = jsonObject.getAsJsonArray("data");

			JsonElement item = jsonArray.get(0).getAsJsonObject();

			System.setProperty("staffId", item.getAsJsonObject().get("staffId").getAsString());

			System.setProperty("staffName", item.getAsJsonObject().get("staffName").getAsString());

			System.setProperty("warehouseCode", item.getAsJsonObject().get("warehouseCode").getAsString());

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@When("I call api assign sub pick")
	public void i_call_api_assign_sub_pick() {
		try {

			String idTicket = System.getProperty("listIdTicket");

			// Remove the square brackets from the numberSku
			idTicket = idTicket.substring(1, idTicket.length() - 1);

			// List<String>
			List<String> lIdTicket = Arrays.asList(idTicket.split(", "));

			// Create the JSON object
			JsonObject jsonObject = new JsonObject();

			// Create the listTicketIds array
			JsonArray listTicketIdsArray = new JsonArray();

			for (String item : lIdTicket) {

				listTicketIdsArray.add(Integer.parseInt(item));

			}
			// Set the values in the JSON object
			jsonObject.add("listTicketIds", listTicketIdsArray);
			jsonObject.addProperty("employee", System.getProperty("staffName"));
			jsonObject.addProperty("employeeId", Integer.parseInt(System.getProperty("staffId")));
			jsonObject.addProperty("warehouseCode", System.getProperty("warehouseCode"));

			// Convert the JSON object to a String
			String jsonString = jsonObject.toString();

			String response = ResetAssuredAPIFunctions.getInstance().getBodyPutMethod(
					System.getProperty("apiAssignSubPick"), System.getProperty("token"), jsonString, CODE_SUCCESS);
			
			System.out.println(response);
			
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@When("I call api delete ticket")
	public void i_call_api_delete_ticket() {
		try {

			String numberSO = System.getProperty("numberSO").substring(4);

			int numberSOInt = Integer.parseInt(numberSO);

			// Create the JSON object
			JsonObject jsonObject = new JsonObject();

			// Set the values in the JSON object
			jsonObject.addProperty("orderId", numberSOInt);
			jsonObject.addProperty("status", "CANCEL");
			jsonObject.addProperty("note", "");

			// Convert the JSON object to a String
			String jsonString = jsonObject.toString();

			ResetAssuredAPIFunctions.getInstance().callPutMethodResponse(System.getProperty("apiDeleteTicket"),
					System.getProperty("token"), jsonString, CODE_SUCCESS);

			System.out.println("Delete");

		} catch (Exception e) {

			i_call_api_delete_ticket();

			Assert.fail(e.getMessage());
		}
	}

	@When("I call api receive order ticket")
	public void I_call_api_receive_order_ticket() {
		try {

			HashMap<String, String> filter = new HashMap<>();

			String warehouseCode = "";

			if (System.getProperty("regionName").equals("Miền Bắc")) {

				warehouseCode = "HN";

			} else if (System.getProperty("regionName").equals("Miền Nam")) {

				warehouseCode = "BD";

			}

			String input;
			// Call API Login

			filter.put("warehouseCode", warehouseCode);

			input = CommonFunctions.getInstance().mapToJson(filter);

			String response = ResetAssuredAPIFunctions.getInstance().getBodyPostMethod(
					System.getProperty("apiReceiveOrder"), System.getProperty("tokenPick"), input, CODE_SUCCESS);

			JsonObject jsonObject = new JsonParser().parse(response).getAsJsonObject();

			JsonArray jsonArray = jsonObject.getAsJsonArray("data");

			JsonElement item = jsonArray.get(0).getAsJsonObject();

			System.setProperty("ticketId", item.getAsJsonObject().get("ticketId").getAsString());

			System.out.println(response);

		} catch (Exception e) {

			i_call_api_delete_ticket();

			Assert.fail(e.getMessage());
		}
	}

	@Then("I call api assign basket code for pick ticket")
	public void i_call_api_assign_basket_code_for_pick_ticket() {
		try {

			String warehouseCode = "";

			if (System.getProperty("regionName").equals("Miền Bắc")) {

				warehouseCode = "HN";

			} else if (System.getProperty("regionName").equals("Miền Nam")) {

				warehouseCode = "BD";

			}

			// Create the JSON object
			JsonObject jsonObject = new JsonObject();

			// Set the values in the JSON object
			jsonObject.addProperty("warehouseCode", warehouseCode);
			jsonObject.addProperty("basketCode", System.getProperty("dBasketCode"));
			jsonObject.addProperty("ticketId", Integer.parseInt(System.getProperty("ticketId")));

			// Convert the JSON object to a String
			String jsonString = jsonObject.toString();

			String response = ResetAssuredAPIFunctions.getInstance().getBodyPostMethod(
					System.getProperty("apiAddBasket"), System.getProperty("tokenPick"), jsonString, CODE_SUCCESS);

			System.out.println(response);

			jsonObject = new JsonParser().parse(response).getAsJsonObject();

			JsonArray jsonArray = jsonObject.getAsJsonArray("data");

			JsonElement item = jsonArray.get(0).getAsJsonObject();

			System.setProperty("ticketId", item.getAsJsonObject().get("ticketId").getAsString());

			System.out.println(response);

		} catch (Exception e) {

			i_call_api_delete_ticket();

			Assert.fail(e.getMessage());
		}
	}

	@When("I call api pick sub pick ticket")
	public void i_call_api_pick_sub_pick_ticket() {
		try {
			
			// Set list product
			String productName = System.getProperty("dProductName");
			List<String> lProductName = new ArrayList<>();

			if (productName.contains(",")) {

				lProductName = Arrays.asList(productName.split(","));

			} else {

				lProductName.add(productName);

			}

			String warehouseCode = "";

			if (System.getProperty("regionName").equals("Miền Bắc")) {

				warehouseCode = "HN";

			} else if (System.getProperty("regionName").equals("Miền Nam")) {

				warehouseCode = "BD";

			}

			String numberSku = System.getProperty("numberSKU");

			// Remove the square brackets from the numberSku
			numberSku = numberSku.substring(1, numberSku.length() - 1);

			// Split the string using commas as the delimiter and store the values into a
			// List<String>
			List<String> lNumberSku = Arrays.asList(numberSku.split(", "));

			// Position
			String position = System.getProperty("position");

			// Remove the square brackets from the numberSku
			position = position.substring(1, position.length() - 1);

			// Split the string using commas as the delimiter and store the values into a
			// List<String>
			List<String> lPosition = Arrays.asList(position.split(", "));

			// Quantity
			String quantity = System.getProperty("quantity");

			// Remove the square brackets from the numberSku
			quantity = quantity.substring(1, quantity.length() - 1);

			// Split the string using commas as the delimiter and store the values into a
			// List<String>
			List<String> lQuantity = Arrays.asList(quantity.split(", "));

			// Create the JSON object
			JsonObject jsonObject = new JsonObject();
			Collections.reverse(lNumberSku);

			for (int i = 0; i < lNumberSku.size(); i++) {

				// Set the values in the JSON object
				jsonObject.addProperty("pickedQuantity", Integer.parseInt(lQuantity.get(i)));
				jsonObject.addProperty("ticketId", Integer.parseInt(System.getProperty("ticketId")));
				jsonObject.addProperty("name", lProductName.get(i).toLowerCase());
				jsonObject.addProperty("sku", lNumberSku.get(i));
				jsonObject.addProperty("location", lPosition.get(i));
				jsonObject.addProperty("warehouseCode", warehouseCode);

				// Convert the JSON object to a String
				String jsonString = jsonObject.toString();

				String response = ResetAssuredAPIFunctions.getInstance().getBodyPostMethod(
						System.getProperty("apiPickSubPick"), System.getProperty("tokenPick"), jsonString,
						CODE_SUCCESS);

			}

		} catch (Exception e) {

			i_call_api_delete_ticket();

			Assert.fail(e.getMessage());
		}
	}

	@When("I call api complete sub pick ticket")
	public void i_call_api_complete_sub_pick_ticket() {
		try {

			String warehouseCode = "";

			if (System.getProperty("regionName").equals("Miền Bắc")) {

				warehouseCode = "HN";

			} else if (System.getProperty("regionName").equals("Miền Nam")) {

				warehouseCode = "BD";

			}

			Thread.sleep(5000);

			// Create the JSON object
			JsonObject jsonObject = new JsonObject();

			// Set the values in the JSON object
			jsonObject.addProperty("ticketId", Integer.parseInt(System.getProperty("ticketId")));
			jsonObject.addProperty("status", "DONE");
			jsonObject.addProperty("warehouseCode", warehouseCode);

			// Convert the JSON object to a String
			String jsonString = jsonObject.toString();

			String response = ResetAssuredAPIFunctions.getInstance().getBodyPutMethod(
					System.getProperty("apiCompleteSubPick"), System.getProperty("tokenPick"), jsonString,
					CODE_SUCCESS);

			System.out.println(response);

		} catch (Exception e) {

			i_call_api_delete_ticket();

			Assert.fail(e.getMessage());
		}
	}

}
