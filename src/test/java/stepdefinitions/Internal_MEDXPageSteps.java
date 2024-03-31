package stepdefinitions;

import org.testng.Assert;

import com.google.gson.JsonObject;

import actions.Internal_MEDXActions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.CommonFunctions;
import utilities.ResetAssuredAPIFunctions;

public class Internal_MEDXPageSteps {

	private static final int CODE_SUCCESS = 200;

	@Then("I click menu insider seller button on the Internal Home page")
	public void i_click_menu_insider_seller_button_on_the_internal_home_page() {
		Internal_MEDXActions.getInstance().clickMenuMEDX();
	}

	@Then("I click product button & sales product on the Internal MEDX page")
	public void i_click_product_button_sales_product_on_the_internal_medx_page() {
		Internal_MEDXActions.getInstance().clickBtnSubMenuSalesProduct();
	}

	@When("I click sub menu quote price on the Internal MEDX page")
	public void i_click_sub_menu_quote_price_on_the_internal_medx_page() {
		Internal_MEDXActions.getInstance().clickBtnSubMenuQuotePrice();

	}

	@Then("I get VAT product on the MEDX page")
	public void i_get_vat_product_on_the_medx_page() throws InterruptedException {
		Internal_MEDXActions.getInstance().getVAT();

	}

	@When("I click button sales product on the MEDX page")
	public void i_click_button_sales_product_on_the_medx_page() {
		Internal_MEDXActions.getInstance().clickBtnSalesProduct();

	}

	@When("I enters product code on the MEDX Sales Product page")
	public void i_enters_product_code_on_the_medx_sales_product_page() {
		Internal_MEDXActions.getInstance().selectProductCode();

	}

	@When("I enters location code on the MEDX Sales Product page")
	public void i_enters_location_code_on_the_medx_sales_product_page() {
		Internal_MEDXActions.getInstance().selectLocationCode();

	}

	@When("I enters price on the MEDX Sales Product page")
	public void i_enters_price_on_the_medx_sales_product_page() {
		Internal_MEDXActions.getInstance().sendKeysPrice();

	}

	@When("I click button save on the MEDX Sales Product page")
	public void i_click_button_save_on_the_medx_sales_product_page() {
		Internal_MEDXActions.getInstance().clickBtnSave();

	}

	@When("I click buy product button & ticket PO on the Internal MEDX page")
	public void i_click_buy_product_button_ticket_po_on_the_internal_medx_page() {
		Internal_MEDXActions.getInstance().clickBtnSubMenuTicketPO();

	}

	@When("I click button add new on the Internal MEDX Ticket PO page")
	public void i_click_button_add_new_on_the_internal_medx_ticket_po_page() {
		Internal_MEDXActions.getInstance().clickBtnAddNew();

	}

	@When("I enters vendors on the Internal MEDX Ticket PO page")
	public void i_enters_vendors_on_the_internal_medx_ticket_po_page() {
		Internal_MEDXActions.getInstance().selectVendor();

	}

	@When("I enters ware house {string} on the Internal MEDX Ticket PO page")
	public void i_enters_ware_house_on_the_internal_medx_ticket_po_page(String option) {
		Internal_MEDXActions.getInstance().selectWareHouse(option);

	}

	@When("I enters from ware house {string} on the Internal MEDX Ticket PO page")
	public void i_enters_from_ware_house_on_the_internal_medx_ticket_po_page(String option) {
		Internal_MEDXActions.getInstance().selectFromWareHouse(option);

	}

	@When("I click button add detail product on the Internal MEDX Ticket PO page")
	public void i_click_button_add_detail_product_on_the_internal_medx_ticket_po_page() {
		Internal_MEDXActions.getInstance().clickBtnAddDetailProduct();
	}

	@When("I enters product name search on the Internal MEDX Ticket PO page")
	public void i_enters_product_name_search_on_the_internal_medx_ticket_po_page() {
		Internal_MEDXActions.getInstance().sendKeysProductName();

	}

	@When("I enters quantity on the Internal MEDX Ticket PO page")
	public void i_enters_quantity_on_the_internal_medx_ticket_po_page() {
		Internal_MEDXActions.getInstance().sendKeysQuantity();

	}

	@When("I click button save on the Internal MEDX Ticket PO page")
	public void i_click_button_save_on_the_internal_medx_ticket_po_page() {
		Internal_MEDXActions.getInstance().clickBtnSave();

	}

	@When("I get number PO on the Internal MEDX Ticket PO page")
	public void i_get_number_po_on_the_internal_medx_ticket_po_page() {
		Internal_MEDXActions.getInstance().getNumberPO();

	}

	@When("I click button confirm on the Internal MEDX Ticket PO page")
	public void i_click_button_confirm_on_the_internal_medx_ticket_po_page() {
		Internal_MEDXActions.getInstance().clickBtnConfirm();

	}

	@When("I click button import quote file on the Internal MEDX Quote Price page")
	public void i_click_button_import_quote_file_on_the_internal_medx_quote_price_page() {
		Internal_MEDXActions.getInstance().clickBtnImportFile();

	}

	@When("I upload file quote on the Internal MEDX Quote Price page")
	public void i_upload_file_quote_on_the_internal_medx_quote_price_page() {
		Internal_MEDXActions.getInstance().uploadFile();

	}
	
	@Then("I should see upload success on the Internal MEDX Quote Price page")
	public void i_should_see_upload_success_on_the_internal_medx_quote_price_page() {
		Internal_MEDXActions.getInstance().verifySuccess();

	}

	@When("I call api remove mapping on the Internal WSM page")
	public void i_call_api_remove_mapping_on_the_internal_wsm_page() {
		try {

			Thread.sleep(5000);

			JsonObject jsonObject = new JsonObject();

			String warehouseCode = "";

			if (System.getProperty("regionName").equals("Miền Bắc")) {

				warehouseCode = "HN";

			} else if (System.getProperty("regionName").equals("Miền Nam")) {

				warehouseCode = "BD";

			}

			jsonObject.addProperty("sku", System.getProperty("skus"));

			jsonObject.addProperty("locationCode", System.getProperty("locationsCode"));
			jsonObject.addProperty("type", "MAPPING");

			jsonObject.addProperty("warehouseCode", warehouseCode);

			String response = ResetAssuredAPIFunctions.getInstance().getBodyPutMethod(
					System.getProperty("apiRemoveMapping"), System.getProperty("token"), jsonObject.toString(),
					CODE_SUCCESS);

			System.out.println(response);

			CommonFunctions.getInstance().refresh();

			CommonFunctions.getInstance().waitForPageLoad(120);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

}
