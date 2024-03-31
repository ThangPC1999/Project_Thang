package stepdefinitions;

import actions.Seller_HomePageActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Seller_HomePageSteps {

	@When("I click menu {string} on the Seller Home page")
	public void i_click_menu_on_the_seller_home_page(String optionMenu) {
		Seller_HomePageActions.getInstance().clickMenu(optionMenu);
	}

	@When("I enters product name search on the Seller Home page")
	public void i_enters_product_name_search_on_the_seller_home_page() {
		Seller_HomePageActions.getInstance().sendKeysProductNameSearch();

	}

	@When("I click button select buy on the Seller Home page")
	public void i_click_button_select_buy_on_the_seller_home_page() {
		Seller_HomePageActions.getInstance().clickBtnSelectBuy();

	}

	@When("I enters product name on the Seller Home page")
	public void i_enters_product_name_on_the_seller_home_page() {
		Seller_HomePageActions.getInstance().sendKeysProductName();

	}

	@When("I enters seller sku on the Seller Home page")
	public void i_enters_seller_sku_on_the_seller_home_page() {
		Seller_HomePageActions.getInstance().sendKeysSellerPrivateSKU();

	}

	@When("I enters raw price on the Seller Home page")
	public void i_enters_raw_price_on_the_seller_home_page() {
		Seller_HomePageActions.getInstance().sendKeysRawPrice();

	}

	@When("I enters seller inventory on the Seller Home page")
	public void i_enters_seller_inventory_on_the_seller_home_page() {
		Seller_HomePageActions.getInstance().sendKeysSellerInventory();
	}

	@When("I enters volume on the Seller Home page")
	public void i_enters_volume_on_the_seller_home_page() {
		Seller_HomePageActions.getInstance().sendKeysVolume();
	}

	@When("I upload image logo on the Seller Home page")
	public void i_upload_image_logo_on_the_seller_home_page() {
		Seller_HomePageActions.getInstance().sendKeysImage();
	}

	@When("I select unit {string} on the Seller Home page")
	public void i_select_unit_on_the_seller_home_page(String unit) {
		Seller_HomePageActions.getInstance().selectUnit(unit);

	}

	@When("I select status buy {string} on the Seller Home page")
	public void i_select_status_buy_on_the_seller_home_page(String statusBuy) {
		Seller_HomePageActions.getInstance().selectStatusBuy(statusBuy);

	}

	@When("I select category {string} on the Seller Home page")
	public void i_select_category_on_the_seller_home_page(String category) {
		Seller_HomePageActions.getInstance().selectCategory(category);

	}

	@When("I select seller category {string} on the Seller Home page")
	public void i_select_seller_category_on_the_seller_home_page(String sellerCategory) {
		Seller_HomePageActions.getInstance().selectSellerCategory(sellerCategory);

	}

	@When("I select manufacturer {string} on the Seller Home page")
	public void i_select_manufacturer_on_the_seller_home_page(String manufacturer) {
		Seller_HomePageActions.getInstance().selectManufacturer(manufacturer);

	}

	@When("I select efficacy codes {string} on the Seller Home page")
	public void i_select_efficacy_codes_on_the_seller_home_page(String efficacyCodes) {
		Seller_HomePageActions.getInstance().selectEfficacyCodes(efficacyCodes);

	}

	@When("I select locations {string} on the Seller Home page")
	public void i_select_locations_on_the_seller_home_page(String locations) {
		Seller_HomePageActions.getInstance().selectLocations(locations);

	}

	@When("I click button save create product on the Seller Home page")
	public void i_click_button_save_create_product_on_the_seller_home_page() {
		Seller_HomePageActions.getInstance().clickBtnSaveProduct();

	}

	@When("I click create draft ticket button on the Seller Home page")
	public void i_click_create_draft_ticket_button_on_the_seller_home_page() {
		Seller_HomePageActions.getInstance().clickBtnCreateDraftTicket();

	}

	@When("I select warehouse {string} on the Seller Home page")
	public void i_select_warehouse_on_the_seller_home_page(String warehouseId) {
		Seller_HomePageActions.getInstance().selectWarehouseId(warehouseId);
	}

	@When("I select delivery method {string} on the Seller Home page")
	public void i_select_delivery_method_on_the_seller_home_page(String deliveryMethod) {
		Seller_HomePageActions.getInstance().selectDeliveryMethod(deliveryMethod);
	}

	@When("I enter expectdate on the Seller Home page")
	public void i_enter_expectdate_on_the_seller_home_page() {
		Seller_HomePageActions.getInstance().sendKeysExpectDate();

	}

	@When("I enter expecttime on the Sellter Home page")
	public void i_enter_expecttime_on_the_sellter_home_page() {
		Seller_HomePageActions.getInstance().sendKeysExpectTime();

	}

	@When("I click add product on the Seller Home page")
	public void i_click_add_product_on_the_seller_home_page() {
		Seller_HomePageActions.getInstance().clickBtnAddProduct();

	}

	@When("I click add product icon on the Seller Home page")
	public void i_click_add_product_icon_on_the_seller_home_page() {
		Seller_HomePageActions.getInstance().clickIconAddProduct();
	}

	@When("I click closed popup button on the Seller Home page")
	public void i_click_closed_popup_button_on_the_seller_home_page() {
		Seller_HomePageActions.getInstance().clickIconClosed();
	}

	@When("I enters lot on the Seller Home page")
	public void i_enters_lot_on_the_seller_home_page() {
		Seller_HomePageActions.getInstance().sendKeysLot();

	}

	@When("I enters date on the Seller Home page")
	public void i_enters_date_on_the_seller_home_page() {
		Seller_HomePageActions.getInstance().sendKeysDate();

	}

	@When("I click create ticket button on the Seller Home page")
	public void i_click_create_ticket_button_on_the_seller_home_page() {
		Seller_HomePageActions.getInstance().clickBtnCreateTicket();
	}

	@Given("I click print button on the Seller Home page")
	public void i_click_print_button_on_the_seller_home_page() {
		Seller_HomePageActions.getInstance().clickBtnPrint();

	}

	@Given("I click complete gift button on the Seller Home page")
	public void i_click_complete_gift_button_on_the_seller_home_page() {
		Seller_HomePageActions.getInstance().clickBtnCompleteGift();

	}

	@Given("I enters package quantity on the Seller Home page")
	public void i_enters_package_quantity_on_the_seller_home_page() {
		Seller_HomePageActions.getInstance().sendKeysPackageQuantity();

	}

	@Given("I click download button on the Seller Home page")
	public void i_click_download_button_on_the_seller_home_page() {
		Seller_HomePageActions.getInstance().clickBtnDownLoad();

	}

	@Then("I get ticket number on the Seller Home page")
	public void i_get_ticket_number_on_the_seller_home_page() {
		Seller_HomePageActions.getInstance().getTicketNumber();

	}

	@When("I enters combo name on the Seller Home page")
	public void i_enters_combo_name_on_the_seller_home_page() {
		Seller_HomePageActions.getInstance().sendKeysComboName();

	}

	@When("I enters combo code on the Seller Home page")
	public void i_enters_combo_code_on_the_seller_home_page() {
		Seller_HomePageActions.getInstance().sendKeysComboCode();

	}

	@When("I upload image combo on the Seller Home page")
	public void i_upload_image_combo_on_the_seller_home_page() {
		Seller_HomePageActions.getInstance().sendKeysImageCombo();

	}

	@When("I select product on the Seller Home page")
	public void i_select_product_on_the_seller_home_page() {
		Seller_HomePageActions.getInstance().selectProductName();

	}

	@When("I enters ammount product on the Seller Home page")
	public void i_enters_ammount_product_on_the_seller_home_page() {
		Seller_HomePageActions.getInstance().sendKeysQuantity();

	}

	@When("I click add product button on the Seller Home page")
	public void i_click_add_product_button_on_the_seller_home_page() {
		Seller_HomePageActions.getInstance().clickBtnAddProduct();

	}

	@When("I select discount type {string} on the Seller Home page")
	public void i_select_discount_type_on_the_seller_home_page(String discountType) {
		Seller_HomePageActions.getInstance().selectDiscountType(discountType);
	}

	@When("I enters price discount on the Seller Home page")
	public void i_enters_price_discount_on_the_seller_home_page() {
		Seller_HomePageActions.getInstance().sendKeysMoneyPrice();

	}

	@When("I create combo button on the Seller Home page")
	public void i_create_combo_button_on_the_seller_home_page() {
		Seller_HomePageActions.getInstance().clickBtnCreateCombo();

	}
	
	@When("I click button add combo on the Seller Home page")
	public void i_click_button_add_combo_on_the_seller_home_page() {
		Seller_HomePageActions.getInstance().clickBtnAddCombo();

	}

}
