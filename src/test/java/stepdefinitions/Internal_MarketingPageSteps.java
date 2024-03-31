package stepdefinitions;

import actions.Internal_MarketingActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Internal_MarketingPageSteps {

	private static final int CODE_SUCCESS = 200;

	@When("I click menu list code promotion button on the Internal Home page")
	public void i_click_menu_list_code_promotion_button_on_the_internal_home_page() {
		Internal_MarketingActions.getInstance().clickSubMenuListPromotionCode();
	}

	@Then("I should see list code promotion on the Internal Marketing page")
	public void i_should_see_list_code_promotion_on_the_internal_marketing_page() {
		Internal_MarketingActions.getInstance().verifyPromotionCodeListIsDisplay();
	}

	@Given("I click menu list deal ticket button on the Internal Home page")
	public void i_click_menu_list_deal_ticket_button_on_the_internal_home_page() {
		Internal_MarketingActions.getInstance().clickSubMenuListDealTicket();

	}

	@Then("I should see list deal ticket on the Internal Marketing page")
	public void i_should_see_list_deal_ticket_on_the_internal_marketing_page() {
		Internal_MarketingActions.getInstance().verifyDealTicketListIsDisplay();

	}

	@When("I click button create ticket on the Internal Marketing page")
	public void i_click_button_create_ticket_on_the_internal_marketing_page() {
		Internal_MarketingActions.getInstance().clickBtnCreateTicket();

	}

	@When("I click button add new code promotion on the Internal Marketing page")
	public void i_click_button_add_new_code_promotion_on_the_internal_marketing_page() {
		Internal_MarketingActions.getInstance().clickBtnAddNew();

	}

	@When("I enters code promotion on the Internal Marketing page")
	public void i_enters_code_promotion_on_the_internal_marketing_page() {
		Internal_MarketingActions.getInstance().sendKeysCode();

	}

	@When("I enters code name promotion on the Internal Marketing page")
	public void i_enters_code_name_promotion_on_the_internal_marketing_page() {
		Internal_MarketingActions.getInstance().sendKeysCodeName();

	}

	@When("I select voucher type {string} on the Internal Marketing page")
	public void i_select_voucher_type_on_the_internal_marketing_page(String data) {
		Internal_MarketingActions.getInstance().selectVoucherType(data);

	}
	
	@When("I select voucher group {string} on the Internal Marketing Promotion page")
	public void i_select_voucher_group_on_the_internal_marketing_promotion_page(String data) {
		Internal_MarketingActions.getInstance().selectVoucherGroup(data);

	}

	@When("I enters start date on the Internal Marketing page")
	public void i_enters_start_date_on_the_internal_marketing_page() {
		Internal_MarketingActions.getInstance().sendKeysStartDate();

	}

	@When("I enters public date on the Internal Marketing page")
	public void i_enters_public_date_on_the_internal_marketing_page() {
		Internal_MarketingActions.getInstance().sendKeysPublicDate();

	}

	@When("I upload logo voucher on the Internal Marketing page")
	public void i_upload_logo_voucher_on_the_internal_marketing_page() {
		Internal_MarketingActions.getInstance().uploadImgLogo();

	}

	@When("I select reward type {string} on the Internal Marketing page")
	public void i_select_reward_type_on_the_internal_marketing_page(String data) {
		Internal_MarketingActions.getInstance().selectRewardType(data);

	}

	@When("I enters absolute discount on the Internal Marketing page")
	public void i_enters_absolute_discount_on_the_internal_marketing_page() {
		Internal_MarketingActions.getInstance().sendKeysAbsoluteDiscount();

	}

	@When("I enters percent discount on the Internal Marketing page")
	public void i_enters_percent_discount_on_the_internal_marketing_page() {
		Internal_MarketingActions.getInstance().sendKeysPercentDiscount();

	}

	@When("I enters max discount on the Internal Marketing page")
	public void i_enters_max_discount_on_the_internal_marketing_page() {
		Internal_MarketingActions.getInstance().sendKeysMaxDiscount();

	}

	@When("I click change status on the Internal Marketing page")
	public void i_click_change_status_on_the_internal_marketing_page() {
		Internal_MarketingActions.getInstance().clickStatus();

	}

	@When("I click button add code promotion on the Internal Marketing page")
	public void i_click_button_add_code_promotion_on_the_internal_marketing_page() {
		Internal_MarketingActions.getInstance().clickBtnAddCode();

	}

	@When("I enters product name on the Internal Marketing page")
	public void i_enters_product_name_on_the_internal_marketing_page() {
		Internal_MarketingActions.getInstance().selectProductName();

	}

	@When("I click button save create ticket on the Internal Marketing page")
	public void i_click_button_save_create_ticket_on_the_internal_marketing_page() {
		Internal_MarketingActions.getInstance().clickBtnSaveCreateTikcet();

	}

	@When("I click button approve ticket on the Internal Marketing page")
	public void i_click_button_approve_ticket_on_the_internal_marketing_page() {
		Internal_MarketingActions.getInstance().clickBtnApprove();

	}

	@Then("should see status ticket approve {string} on the Internal Marketing page")
	public void should_see_status_ticket_approve_on_the_internal_marketing_page(String status) {
		Internal_MarketingActions.getInstance().verifyStatus(status);

	}

	@When("I click menu list promotion button on the Internal Home page")
	public void i_click_menu_list_promotion_button_on_the_internal_home_page() {
		Internal_MarketingActions.getInstance().clickSubMenuListPromotion();

	}

	@Then("I should see list promotion on the Internal Marketing page")
	public void i_should_see_list_promotion_on_the_internal_marketing_page() {
		Internal_MarketingActions.getInstance().verifyPromotionListIsDisplay();

	}

	@When("I click menu list exchange point button on the Internal Home page")
	public void i_click_menu_list_exchange_point_button_on_the_internal_home_page() {
		Internal_MarketingActions.getInstance().clickSubMenuListExchangePoint();

	}

	@Then("I should see list exchange point on the Internal Marketing page")
	public void i_should_see_list_exchange_point_on_the_internal_marketing_page() {
		Internal_MarketingActions.getInstance().verifyExchangePointListIsDisplay();

	}

	@When("I click button add new promotion on the Internal Marketing List Promotion page")
	public void i_click_button_add_new_promotion_on_the_internal_marketing_list_promotion_page() {
		Internal_MarketingActions.getInstance().clickBtnCreatePromotion();

	}

	@When("I enters promotion name on the Internal Marketing Promotion page")
	public void i_enters_promotion_name_on_the_internal_marketing_promotion_page() {
		Internal_MarketingActions.getInstance().sendKeysPromotionName();

	}

	@When("I enters promotion content on the Internal Marketing Promotion page")
	public void i_enters_promotion_content_on_the_internal_marketing_promotion_page() {
		Internal_MarketingActions.getInstance().sendKeysContentPromotion();

	}

	@When("I select promotion type {string} on the Internal Marketing Promotion page")
	public void i_select_promotion_type_on_the_internal_marketing_promotion_page(String type) {
		Internal_MarketingActions.getInstance().selectPromotionType(type);

	}

	@When("I upload logo voucher on the Internal Marketing Promotion page")
	public void i_upload_logo_voucher_on_the_internal_marketing_promotion_page() {
		Internal_MarketingActions.getInstance().uploadImgLogo();

	}

	@When("I enters start date on the Internal Marketing Promotion page")
	public void i_enters_start_date_on_the_internal_marketing_promotion_page() {
		Internal_MarketingActions.getInstance().sendKeysStartDate();

	}

	@When("I enters public date on the Internal Marketing Promotion page")
	public void i_enters_public_date_on_the_internal_marketing_promotion_page() {
		Internal_MarketingActions.getInstance().sendKeysPublicDate();

	}

	@When("I click button add new promotion code on the Internal Marketing List Promotion page")
	public void i_click_button_add_new_promotion_code_on_the_internal_marketing_list_promotion_page() {
		Internal_MarketingActions.getInstance().clickBtnAddPromotion();

	}

	@When("I click button add new exchange point on the Internal Marketing List Exchange Point page")
	public void i_click_button_add_new_exchange_point_on_the_internal_marketing_list_exchange_point_page() {
		Internal_MarketingActions.getInstance().clickBtnCreateExchangePoint();

	}

	@When("I enters promotion name on the Internal Marketing Create Exchange Point page")
	public void i_enters_promotion_name_on_the_internal_marketing_create_exchange_point_page() {
		Internal_MarketingActions.getInstance().selectPromotion();

	}

	@When("I enters point on the Internal Marketing Create Exchange Point page")
	public void i_enters_point_on_the_internal_marketing_create_exchange_point_page() {
		Internal_MarketingActions.getInstance().sendKeysPoint();

	}

	@When("I select status display {string} on the Internal Marketing Create Exchange Point page")
	public void i_select_status_display_on_the_internal_marketing_create_exchange_point_page(String status) {
		Internal_MarketingActions.getInstance().selectStatus(status);

	}

	@When("I click button save point on the Internal Marketing Create Exchange Point page")
	public void i_click_button_save_point_on_the_internal_marketing_create_exchange_point_page() {
		Internal_MarketingActions.getInstance().clickBtnSavePoint();

	}

	@When("I click menu list campaign button on the Internal Home page")
	public void i_click_menu_list_campaign_button_on_the_internal_home_page() {
		Internal_MarketingActions.getInstance().clickSubMenuListCampaign();

	}

	@When("I click menu list campaign ticket button on the Internal Home page")
	public void i_click_menu_list_campaign_ticket_button_on_the_internal_home_page() {
		Internal_MarketingActions.getInstance().clickSubMenuListCampaignTicket();

	}

	@Then("I should see list campaign ticket on the Internal Marketing page")
	public void i_should_see_list_campaign_ticket_on_the_internal_marketing_page() {
		Internal_MarketingActions.getInstance().verifyCampaignTicketListIsDisplay();

	}

	@Then("I should see list campaign on the Internal Marketing page")
	public void i_should_see_list_campaign_on_the_internal_marketing_page() {
		Internal_MarketingActions.getInstance().verifyCampaignListIsDisplay();

	}

	@When("I click button create new campaign on the Internal Marketing List Campaign page")
	public void i_click_button_create_new_campaign_on_the_internal_marketing_list_campaign_page() {
		Internal_MarketingActions.getInstance().clickBtnCreateCampaign();

	}

	@When("I upload banner on the Internal Marketing List Campaign page")
	public void i_upload_banner_on_the_internal_marketing_list_campaign_page() {
		Internal_MarketingActions.getInstance().uploadBanner();

	}

	@When("I enters campaign name on the Internal Marketing List Campaign page")
	public void i_enters_campaign_name_on_the_internal_marketing_list_campaign_page() {
		Internal_MarketingActions.getInstance().sendKeysPromotionCampaign();

	}

	@When("I select campaign type {string} on the Internal Marketing List Campaign page")
	public void i_select_campaign_type_on_the_internal_marketing_list_campaign_page(String type) {
		Internal_MarketingActions.getInstance().selectCampaignType(type);

	}

	@When("I enters registration start date on the Internal Marketing List Campaign page")
	public void i_enters_registration_start_date_on_the_internal_marketing_list_campaign_page() {
		Internal_MarketingActions.getInstance().sendKeysRegistrationCampaign();

	}

	@When("I click button save campaign on the Internal Marketing List Campaign page")
	public void i_click_button_save_campaign_on_the_internal_marketing_list_campaign_page() {
		Internal_MarketingActions.getInstance().clickBtnSaveCampaign();

	}

	@When("I click button active campaign on the Internal Marketing List Campaign page")
	public void i_click_button_active_campaign_on_the_internal_marketing_list_campaign_page() {
		Internal_MarketingActions.getInstance().clickActiveCampaign();

	}

	@When("I click button create new campaign ticket on the Internal Marketing List Campaign Ticket page")
	public void i_click_button_create_new_campaign_ticket_on_the_internal_marketing_list_campaign_ticket_page() {
		Internal_MarketingActions.getInstance().clickBtnCreateCampaignTicket();

	}

	@When("I select sale campaign on the Internal Marketing List Campaign Ticket page")
	public void i_select_sale_campaign_on_the_internal_marketing_list_campaign_ticket_page() {
		Internal_MarketingActions.getInstance().selectSaleCampaign();

	}
	
	@When("I select time flash sale on the Internal Marketing List Campaign Ticket page")
	public void i_select_time_flash_sale_on_the_internal_marketing_list_campaign_ticket_page() {
		Internal_MarketingActions.getInstance().selectTimeFlashSale();
	}

	@When("I select pricing product name on the Internal Marketing List Campaign Ticket page")
	public void i_select_pricing_product_name_on_the_internal_marketing_list_campaign_ticket_page() {
		Internal_MarketingActions.getInstance().selectPricingProductName();

	}

	@When("I select sale type {string} on the Internal Marketing List Campaign Ticket page")
	public void i_select_sale_type_on_the_internal_marketing_list_campaign_ticket_page(String type) {
		Internal_MarketingActions.getInstance().selectSaleType(type);

	}

	@When("I enters campaign price on the Internal Marketing List Campaign Ticket page")
	public void i_enters_campaign_price_on_the_internal_marketing_list_campaign_ticket_page() {
		Internal_MarketingActions.getInstance().sendKeysCampaignPrice();

	}

	@When("I enters quantity on the Internal Marketing List Campaign Ticket page")
	public void i_enters_quantity_on_the_internal_marketing_list_campaign_ticket_page() {
		Internal_MarketingActions.getInstance().sendKeysQuantity();

	}
	
	@When("I click button save on the Internal Marketing List Campaign Ticket page")
	public void i_click_button_save_on_the_internal_marketing_list_campaign_ticket_page() {
		Internal_MarketingActions.getInstance().clickBtnSaveCampaignTicket();

	}
	
	@When("I click button active on the Internal Marketing List Campaign Ticket page")
	public void i_click_button_active_on_the_internal_marketing_list_campaign_ticket_page() {
		Internal_MarketingActions.getInstance().clickAtiveCampaignTicket();

	}

}
