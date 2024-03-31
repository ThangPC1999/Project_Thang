package stepdefinitions;

import actions.Internal_WMSAppActions;
import io.cucumber.java.en.When;

public class Internal_WMSAppSteps {

	private static final int CODE_SUCCESS = 200;
	
	@When("I click button sign out on the Internal WMS App page")
	public void i_click_button_sign_out_on_the_internal_wms_app_page() {
		Internal_WMSAppActions.getInstance().clickBtnSignOut();

	}

	@When("I enters name {string} on the Login Internal WMS App page")
	public void i_enters_name_on_the_login_internal_wms_app_page(String username) {
		Internal_WMSAppActions.getInstance().sendKeysUserName(username);
	}

	@When("I enters password {string} on the Login Internal WMS App page")
	public void i_enters_password_on_the_login_internal_wms_app_page(String password) {
		Internal_WMSAppActions.getInstance().sendKeysPassword(password);
	}

	@When("I click sign in button on the Login Internal WMS App page")
	public void i_click_sign_in_button_on_the_login_internal_wms_app_page() {
		Internal_WMSAppActions.getInstance().clickBtnSignIn();
	}

	@When("I click account button on the Internal WMS App page")
	public void i_click_account_button_on_the_internal_wms_app_page() {
		Internal_WMSAppActions.getInstance().clickBtnAccount();
	}

	@When("I click department button on the Internal WMS App Account page")
	public void i_click_department_button_on_the_internal_wms_app_account_page() {
		Internal_WMSAppActions.getInstance().clickBtnDepartment();
	}

	@When("I click warehouse button on the Internal WMS App Account page")
	public void i_click_warehouse_button_on_the_internal_wms_app_account_page() {
		Internal_WMSAppActions.getInstance().clickBtnWarehouse();
	}

	@When("I click pack button on the Internal WMS App Account page")
	public void i_click_pack_button_on_the_internal_wms_app_account_page() {
		Internal_WMSAppActions.getInstance().clickBtnPack();

	}

	@When("I enters search location on the Internal WMS App page")
	public void i_enters_search_location_on_the_internal_wms_app_page() {
		Internal_WMSAppActions.getInstance().sendKeysSearchLocation();

	}

	@When("I enters search so on the Internal WMS App Pack page")
	public void i_enters_search_so_on_the_internal_wms_app_pack_page() {
		Internal_WMSAppActions.getInstance().sendKeysSearchSO();

	}

	@When("I click start pack button on the Internal WMS App Pack page")
	public void i_click_start_pack_button_on_the_internal_wms_app_pack_page() {
		Internal_WMSAppActions.getInstance().clickBtnStartPack();

	}

	@When("I click popup information button on the Internal WMS App Pack page")
	public void i_click_popup_information_button_on_the_internal_wms_app_pack_page() {
		Internal_WMSAppActions.getInstance().clickBtnPopUp();

	}

	@When("I click notification button on the Internal WMS App Pack page")
	public void i_click_notification_button_on_the_internal_wms_app_pack_page() {
		Internal_WMSAppActions.getInstance().clickBtnNotification();

	}

	@When("I enters search number packet on the Internal WMS App Pack page")
	public void i_enters_search_number_packet_on_the_internal_wms_app_pack_page() {
		Internal_WMSAppActions.getInstance().sendKeysNumberPacket();

	}

	@When("I upload image on the Internal WMS App Pack page")
	public void i_upload_image_on_the_internal_wms_app_pack_page() throws InterruptedException {
		Internal_WMSAppActions.getInstance().uploadImage();

	}

	@When("I click finish button on the Internal WMS App Pack page")
	public void i_click_finish_button_on_the_internal_wms_app_pack_page() {
		Internal_WMSAppActions.getInstance().clickBtnFinish();

	}

	@When("I click order button on the Internal WMS App Account page")
	public void i_click_order_button_on_the_internal_wms_app_account_page() {
		Internal_WMSAppActions.getInstance().clickBtnOrder();

	}

	@When("I enters basket code on the Internal WMS App Account page")
	public void i_enters_basket_code_on_the_internal_wms_app_account_page() {
		Internal_WMSAppActions.getInstance().sendKeysBasketCode();
		;

	}

	@When("I click start put button on the Internal WMS App Account page")
	public void i_click_start_put_button_on_the_internal_wms_app_account_page() {
		Internal_WMSAppActions.getInstance().clickBtnStartPut();

	}

	@When("I coppy locations code on the Internal WMS App PUT page")
	public void i_coppy_locations_code_on_the_internal_wms_app_put_page() {
		Internal_WMSAppActions.getInstance().sendKeysScanLocations();

	}

	@When("I coppy qr po code on the Internal WMS App PUT page")
	public void i_coppy_qr_po_code_on_the_internal_wms_app_put_page() {
		Internal_WMSAppActions.getInstance().sendKeysQrPO();

	}
	
	@When("I click button confirm on the Internal WMS App PUT page")
	public void i_click_button_confirm_on_the_internal_wms_app_put_page() {
		Internal_WMSAppActions.getInstance().clickBtnConfirm();

	}


}
