package actions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import base.driver.DriverManager;
import utilities.CommonFunctions;

public class Internal_MarketingActions {

	private static final By btnMenu = By.xpath(System.getProperty("Internal.Home.Menu.Button"));
	private static final By btnMenuMarketing = By.xpath(System.getProperty("Internal.Home.Menu.Marketing.Buton"));
	private static final By btnSubMenuVoucher = By
			.xpath(System.getProperty("Internal.Home.Marketing.Menu.Voucher.Button"));
	private static final By btnSubMenuListPromotionCode = By
			.xpath(System.getProperty("Internal.Home.Marketing.Menu.Voucher.PromotionCode.Button"));
	private static final By btnSubMenuListPromotion = By
			.xpath(System.getProperty("Internal.Home.Marketing.Menu.Voucher.ListPromotion.Button"));
	private static final By btnSubMenuListExchangePoint = By
			.xpath(System.getProperty("Internal.Home.Marketing.Menu.Voucher.ExchangePoint.Button"));
	private static final By btnSubMenuDeal = By.xpath(System.getProperty("Internal.Home.Marketing.Menu.Deal.Button"));
	private static final By btnSubMenuDealTicket = By
			.xpath(System.getProperty("Internal.Home.Marketing.Menu.Deal.DealTicket.Button"));
	private static final By btnSubMenuCampaignTicket = By
			.xpath(System.getProperty("Internal.Home.Marketing.Menu.Deal.CampaignTicket.Button"));
	private static final By btnSubMenuCampaign = By
			.xpath(System.getProperty("Internal.Home.Marketing.Menu.Campaign.Button"));
	private static final By btnSubMenuListCampaign = By
			.xpath(System.getProperty("Internal.Home.Marketing.Menu.Campaign.ListCampaign.Button"));
	private static final By titleListCampaign = By
			.xpath(System.getProperty("Internal.Home.Marketing.Menu.Voucher.ListPromotion.Title"));
	private static final By titleListCampaignTicket = By
			.xpath(System.getProperty("Internal.Home.Marketing.Menu.Deal.CampaignTicket.Title"));
	private static final By titleListPromotion = By
			.xpath(System.getProperty("Internal.Home.Marketing.Menu.Voucher.ListPromotion.Title"));
	private static final By titleListPromotionCode = By
			.xpath(System.getProperty("Internal.Home.Marketing.Menu.Voucher.PromotionCode.Title"));
	private static final By titleListDealTicket = By
			.xpath(System.getProperty("Internal.Home.Marketing.Menu.Deal.DealTicket.Title"));
	private static final By titleListExchangePoint = By
			.xpath(System.getProperty("Internal.Home.Marketing.Menu.Voucher.ExchangePoint.Title"));
	private static final By btnCreateTicket = By
			.xpath(System.getProperty("Internal.Home.Marketing.Menu.Deal.DealTicket.CreateTicket.Button"));
	private static final By btnAddNewPromotionCode = By
			.xpath(System.getProperty("Internal.Home.Marketing.Menu.Voucher.PromotionCode.AddNew.Button"));
	private static final By txtCode = By
			.xpath(System.getProperty("Internal.Home.Marketing.Menu.Voucher.PromotionCode.AddNew.Code.Input"));
	private static final By txtCodeName = By
			.xpath(System.getProperty("Internal.Home.Marketing.Menu.Voucher.PromotionCode.AddNew.CodeName.Input"));
	private static final By selectVoucherType = By
			.xpath(System.getProperty("Internal.Home.Marketing.Menu.Voucher.PromotionCode.AddNew.VoucherType.Select"));
	private static final By txtLogo = By
			.xpath(System.getProperty("Internal.Home.Marketing.Menu.Voucher.PromotionCode.AddNew.UploadLogo.Inputext"));
	private static String itemVoucherType = System
			.getProperty("Internal.Home.Marketing.Menu.Voucher.PromotionCode.AddNew.ItemVoucherType.Text");
	private static final By selectRewardType = By
			.xpath(System.getProperty("Internal.Home.Marketing.Menu.Voucher.PromotionCode.AddNew.RewardType.Select"));
	private static String itemRewardType = System
			.getProperty("Internal.Home.Marketing.Menu.Voucher.PromotionCode.AddNew.ItemRewardType.Text");
	private static final By txtAbsoluteDiscount = By.xpath(
			System.getProperty("Internal.Home.Marketing.Menu.Voucher.PromotionCode.AddNew.AbsoluteDiscount.Text"));
	private static final By btnAddCode = By
			.xpath(System.getProperty("Internal.Home.Marketing.Menu.Voucher.PromotionCode.AddNew.AddCode.Button"));
	private static final By checkBoxStatus = By
			.xpath(System.getProperty("Internal.Home.Marketing.Menu.Voucher.PromotionCode.AddNew.Status.CheckBox"));
	private static final By txtStartDate = By
			.xpath(System.getProperty("Internal.Home.Marketing.Menu.Voucher.PromotionCode.AddNew.StartDate.Input"));
	private static final By txtPercentDiscount = By.xpath(
			System.getProperty("Internal.Home.Marketing.Menu.Voucher.PromotionCode.AddNew.PercentageDiscount.Text"));
	private static final By txtMaxDiscount = By
			.xpath(System.getProperty("Internal.Home.Marketing.Menu.Voucher.PromotionCode.AddNew.MaxDiscount.Text"));
	private static final By iconLoader = By.xpath(System.getProperty("Icon.Loader"));
	private static final By iconProgress = By.xpath(System.getProperty("Icon.Progress"));
	private static final By selectProductName = By
			.xpath(System.getProperty("Internal.Home.Marketing.Menu.Deal.DealTicket.CreateTicket.ProductName.Input"));
	private static String itemProductName = System
			.getProperty("Internal.Home.Marketing.Menu.Voucher.PromotionCode.AddNew.Item.Text");
	private static final By btnSaveCreateTicket = By
			.xpath(System.getProperty("Internal.Home.Marketing.Menu.Voucher.PromotionCode.AddNew.Save.button"));
	private static String btnOptionApprove = System
			.getProperty("Internal.Home.Marketing.Menu.Deal.DealTicket.Approve.Button");
	private static String txtStatus = System.getProperty("Internal.Home.Marketing.Menu.Deal.DealTicket.Status.Text");
	private static final By btnApprove = By
			.xpath(System.getProperty("Internal.Home.Marketing.Menu.Deal.DealTicket.Approve.Approve.Button"));
	private static final By btnCreateNewPromotion = By
			.xpath(System.getProperty("Internal.Home.Marketing.Menu.Voucher.ListPromotion.CreatePromotion.Button"));
	private static final By txtPromotionName = By.xpath(System
			.getProperty("Internal.Home.Marketing.Menu.Voucher.ListPromotion.CreatePromotion.PromotionName.Input"));
	private static final By selectPromotionType = By.xpath(System
			.getProperty("Internal.Home.Marketing.Menu.Voucher.ListPromotion.CreatePromotion.PromotionType.Button"));
	private static String itemPromtionType = System.getProperty(
			"Internal.Home.Marketing.Menu.Voucher.ListPromotion.CreatePromotion.PromotionType.Item.Button");
	private static final By txtContentPromotion = By.xpath(System
			.getProperty("Internal.Home.Marketing.Menu.Voucher.ListPromotion.CreatePromotion.PromotionDesc.Button"));
	private static final By txtPublicTime = By.xpath(
			System.getProperty("Internal.Home.Marketing.Menu.Voucher.ListPromotion.CreatePromotion.PublicTime.Input"));
	private static final By btnAddPromotion = By.xpath(System
			.getProperty("Internal.Home.Marketing.Menu.Voucher.ListPromotion.CreatePromotion.AddPromotionCode.Button"));
	private static final By btnConfirmAddPromotion = By.xpath(System.getProperty(
			"Internal.Home.Marketing.Menu.Voucher.ListPromotion.CreatePromotion.AddPromotionCode.Confirm.Button"));
	private static final By btnCreateExchangePoint = By
			.xpath(System.getProperty("Internal.Home.Marketing.Menu.Voucher.ExchangePoint.CreatePoint.Button"));
	private static final By txtPointPromotionName = By.xpath(
			System.getProperty("Internal.Home.Marketing.Menu.Voucher.ExchangePoint.CreatePoint.PromotionName.Input"));
	private static String itemPromotion = System
			.getProperty("Internal.Home.Marketing.Menu.Voucher.ExchangePoint.CreatePoint.PromotionName.Item.Text");
	private static final By txtPoint = By
			.xpath(System.getProperty("Internal.Home.Marketing.Menu.Voucher.ExchangePoint.CreatePoint.Point.Input"));
	private static final By txtStatusDisplay = By.xpath(
			System.getProperty("Internal.Home.Marketing.Menu.Voucher.ExchangePoint.CreatePoint.StatusDisplay.Input"));
	private static String itemStatus = System
			.getProperty("Internal.Home.Marketing.Menu.Voucher.ExchangePoint.CreatePoint.StatusDisplay.Item.Text");
	private static final By btnSavePoint = By
			.xpath(System.getProperty("Internal.Home.Marketing.Menu.Voucher.ExchangePoint.CreatePoint.Save.Button"));
	private static final By btnCreateCampaign = By
			.xpath(System.getProperty("Internal.Home.Marketing.Menu.Campaign.ListCampaign.Create.Button"));
	private static final By txtCampaignName = By
			.xpath(System.getProperty("Internal.Home.Marketing.Menu.Campaign.ListCampaign.Create.CampaignName.Input"));
	private static String rdoCampaignType = System
			.getProperty("Internal.Home.Marketing.Menu.Campaign.ListCampaign.Create.CampaignName.Radio");
	private static final By txtRegistrationStartTime = By.xpath(System
			.getProperty("Internal.Home.Marketing.Menu.Campaign.ListCampaign.Create.RegistrationStartTime.Input"));
	private static final By txtStartTime = By
			.xpath(System.getProperty("Internal.Home.Marketing.Menu.Campaign.ListCampaign.Create.StartTime.Input"));
	private static final By btnSaveCampaign = By
			.xpath(System.getProperty("Internal.Home.Marketing.Menu.Campaign.ListCampaign.Create.Create.Button"));
	private static final By txtBanner = By
			.xpath(System.getProperty("Internal.Home.Marketing.Menu.Campaign.ListCampaign.Create.Banner.Input"));
	private static String checkBoxActive = System
			.getProperty("Internal.Home.Marketing.Menu.Campaign.ListCampaign.Active.CheckBox");
	private static final By btnConfirmActive = By.xpath(System.getProperty(
			"Internal.Home.Marketing.Menu.Voucher.ListPromotion.CreatePromotion.AddPromotionCode.Confirm.Button"));
	private static final By btnCreateCampaignTicket = By
			.xpath(System.getProperty("Internal.Home.Marketing.Menu.Deal.CampaignTicket.CreateTicket.Button"));
	private static final By selectSaleCampaign = By.xpath(
			System.getProperty("Internal.Home.Marketing.Menu.Deal.CampaignTicket.CreateTicket.SaleCampaign.Input"));
	private static String itemSaleCampaign = System
			.getProperty("Internal.Home.Marketing.Menu.Deal.CampaignTicket.CreateTicket.SaleCampaign.Item.Text");
	private static final By selectPricingProductName = By.xpath(
			System.getProperty("Internal.Home.Marketing.Menu.Deal.CampaignTicket.CreateTicket.ProductName.Input"));
	private static String itemPricingProductName = System
			.getProperty("Internal.Home.Marketing.Menu.Deal.CampaignTicket.CreateTicket.ProductName.Item.Text");
	private static final By selectSaleType = By
			.xpath(System.getProperty("Internal.Home.Marketing.Menu.Deal.CampaignTicket.CreateTicket.SaleType.Input"));
	private static String itemSaleType = System
			.getProperty("Internal.Home.Marketing.Menu.Deal.CampaignTicket.CreateTicket.SaleType.Item.Text");
	private static final By txtCampaignPrice = By.xpath(
			System.getProperty("Internal.Home.Marketing.Menu.Deal.CampaignTicket.CreateTicket.CampaignPrice.Input"));
	private static final By txtQuanity = By
			.xpath(System.getProperty("Internal.Home.Marketing.Menu.Deal.CampaignTicket.CreateTicket.Quantity.Input"));
	private static final By btnSaveCampaignTicket = By
			.xpath(System.getProperty("Internal.Home.Marketing.Menu.Deal.CampaignTicket.CreateTicket.Save.Button"));
	private static String btnActiveCampaignTicket = System
			.getProperty("Internal.Home.Marketing.Menu.Deal.CampaignTicket.Active.Button");
	private static final By btnConfirmActiveCampaignTicket = By
			.xpath(System.getProperty("Internal.Home.Marketing.Menu.Deal.CampaignTicket.Active.Confirm.Button"));
	private static final By selectTimeFlashSale = By.xpath(
			System.getProperty("Internal.Home.Marketing.Menu.Deal.CampaignTicket.CreateTicket.TimeFlashSale.Input"));
	private static final By itemTimeFlashSale = By.xpath(System
			.getProperty("Internal.Home.Marketing.Menu.Deal.CampaignTicket.CreateTicket.TimeFlashSale.Item.Text"));
	private static final By selectVoucherGroup = By
			.xpath(System.getProperty("Internal.Home.Marketing.Menu.Voucher.PromotionCode.AddNew.VoucherGroup.Select"));
	private static String itemVoucherGroup = System
			.getProperty("Internal.Home.Marketing.Menu.Voucher.PromotionCode.AddNew.ItemVoucherGroup.Text");

	@FindBy(how = How.XPATH, using = "")
	private WebElement elem;

	int timeOut = Integer.parseInt(System.getProperty("objectTimeout"));
	public static WebDriver driver;

	public static WebDriver getDriver() {
		driver = DriverManager.getInstance().getDriver();
		return driver;
	}

	private static class SingletonHelper {
		private static final Internal_MarketingActions INSTANCE = new Internal_MarketingActions();
	}

	public static Internal_MarketingActions getInstance() {
		return SingletonHelper.INSTANCE;
	}

	public void clickSubMenuListPromotionCode() {

		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnMenu, timeOut);

			CommonFunctions.getInstance().scrollToObject(btnMenu, 0);

			elem = CommonFunctions.getInstance().findElementByVisibility(btnMenu);

			CommonFunctions.getInstance().clickElement(btnMenu);

			elem = CommonFunctions.getInstance().findElementByVisibility(btnMenuMarketing);

			CommonFunctions.getInstance().clickElement(btnMenuMarketing);

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnSubMenuVoucher, timeOut);

			CommonFunctions.getInstance().clickElement(btnSubMenuVoucher);

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnSubMenuListPromotionCode, timeOut);

			CommonFunctions.getInstance().clickElement(btnSubMenuListPromotionCode);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void clickSubMenuListPromotion() {

		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnMenu, timeOut);

			CommonFunctions.getInstance().scrollToObject(btnMenu, 0);

			elem = CommonFunctions.getInstance().findElementByVisibility(btnMenu);

			CommonFunctions.getInstance().clickElement(btnMenu);

			elem = CommonFunctions.getInstance().findElementByVisibility(btnMenuMarketing);

			CommonFunctions.getInstance().clickElement(btnMenuMarketing);

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnSubMenuVoucher, timeOut);

			CommonFunctions.getInstance().clickElement(btnSubMenuVoucher);

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnSubMenuListPromotion, timeOut);

			CommonFunctions.getInstance().clickElement(btnSubMenuListPromotion);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void clickSubMenuListExchangePoint() {

		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnMenu, timeOut);

			CommonFunctions.getInstance().scrollToObject(btnMenu, 0);

			elem = CommonFunctions.getInstance().findElementByVisibility(btnMenu);

			CommonFunctions.getInstance().clickElement(btnMenu);

			elem = CommonFunctions.getInstance().findElementByVisibility(btnMenuMarketing);

			CommonFunctions.getInstance().clickElement(btnMenuMarketing);

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnSubMenuVoucher, timeOut);

			CommonFunctions.getInstance().clickElement(btnSubMenuVoucher);

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnSubMenuListExchangePoint, timeOut);

			CommonFunctions.getInstance().clickElement(btnSubMenuListExchangePoint);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void clickSubMenuListDealTicket() {

		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnMenu, timeOut);

			CommonFunctions.getInstance().scrollToObject(btnMenu, 0);

			CommonFunctions.getInstance().clickElement(btnMenu);

			CommonFunctions.getInstance().clickElement(btnMenuMarketing);

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnSubMenuDeal, timeOut);

			CommonFunctions.getInstance().clickElement(btnSubMenuDeal);

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnSubMenuDealTicket, timeOut);

			CommonFunctions.getInstance().clickElement(btnSubMenuDealTicket);

			CommonFunctions.getInstance().waitForElementToDisappear(iconLoader, timeOut);

			CommonFunctions.getInstance().waitForElementToDisappear(iconProgress, timeOut);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void clickSubMenuListCampaign() {

		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnMenu, timeOut);

			CommonFunctions.getInstance().scrollToObject(btnMenu, 0);

			CommonFunctions.getInstance().clickElement(btnMenu);

			CommonFunctions.getInstance().clickElement(btnMenuMarketing);

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnSubMenuCampaign, timeOut);

			CommonFunctions.getInstance().clickElement(btnSubMenuCampaign);

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnSubMenuListCampaign, timeOut);

			CommonFunctions.getInstance().clickElement(btnSubMenuListCampaign);

			CommonFunctions.getInstance().waitForElementToDisappear(iconLoader, timeOut);

			CommonFunctions.getInstance().waitForElementToDisappear(iconProgress, timeOut);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void clickSubMenuListCampaignTicket() {

		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnMenu, timeOut);

			CommonFunctions.getInstance().scrollToObject(btnMenu, 0);

			CommonFunctions.getInstance().clickElement(btnMenu);

			CommonFunctions.getInstance().clickElement(btnMenuMarketing);

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnSubMenuDeal, timeOut);

			CommonFunctions.getInstance().clickElement(btnSubMenuDeal);

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnSubMenuCampaignTicket, timeOut);

			CommonFunctions.getInstance().clickElement(btnSubMenuCampaignTicket);

			CommonFunctions.getInstance().waitForElementToDisappear(iconLoader, timeOut);

			CommonFunctions.getInstance().waitForElementToDisappear(iconProgress, timeOut);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void verifyCampaignListIsDisplay() {
		try {

			CommonFunctions.getInstance().verifyElemIsDisplay(titleListCampaign);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void verifyCampaignTicketListIsDisplay() {
		try {

			CommonFunctions.getInstance().verifyElemIsDisplay(titleListCampaignTicket);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void verifyDealTicketListIsDisplay() {
		try {

			CommonFunctions.getInstance().verifyElemIsDisplay(titleListDealTicket);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void verifyPromotionCodeListIsDisplay() {
		try {

			CommonFunctions.getInstance().verifyElemIsDisplay(titleListPromotionCode);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void verifyPromotionListIsDisplay() {
		try {

			CommonFunctions.getInstance().verifyElemIsDisplay(titleListPromotion);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void verifyExchangePointListIsDisplay() {
		try {

			CommonFunctions.getInstance().verifyElemIsDisplay(titleListExchangePoint);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void clickBtnCreateTicket() {
		try {

			CommonFunctions.getInstance().clickElement(btnCreateTicket);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void clickBtnAddNew() {
		try {

			CommonFunctions.getInstance().clickElement(btnAddNewPromotionCode);

			CommonFunctions.getInstance().waitForElementToDisappear(iconLoader, timeOut);

			CommonFunctions.getInstance().waitForElementToDisappear(iconProgress, timeOut);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void sendKeysCode() {
		try {

			String code = "CodeDiscount" + CommonFunctions.getInstance().generateRandomAlphaNumeric(5);

			CommonFunctions.getInstance().actionClearAndSendkeys(txtCode, code);

			System.setProperty("codeDiscount", code);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void sendKeysCodeName() {
		try {

			String codeName = "Code Discount Number " + CommonFunctions.getInstance().generateRandomAlphaNumeric(5);

			CommonFunctions.getInstance().actionClearAndSendkeys(txtCodeName, codeName);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void selectVoucherType(String data) {
		try {

			CommonFunctions.getInstance().clickElement(selectVoucherType);

			String xpathItemVoucherType = itemVoucherType.replace("option", data);

			CommonFunctions.getInstance().clickElement(By.xpath(xpathItemVoucherType));

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void selectVoucherGroup(String data) {
		try {

			CommonFunctions.getInstance().clickElement(selectVoucherGroup);

			String xpathItemVoucherGroup = itemVoucherGroup.replace("option", data);

			CommonFunctions.getInstance().clickElement(By.xpath(xpathItemVoucherGroup));

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void uploadImgLogo() {
		try {

			String img = System.getProperty("user.dir") + "\\src\\test\\resources\\img\\" + "discount.png";

			elem = DriverManager.getInstance().getDriver().findElement(txtLogo);

			CommonFunctions.getInstance().uploadImg(elem, img);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void selectRewardType(String data) {
		try {

			CommonFunctions.getInstance().clickElement(selectRewardType);

			String xpathItemRewardType = itemRewardType.replace("option", data);

			CommonFunctions.getInstance().clickElement(By.xpath(xpathItemRewardType));

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void sendKeysAbsoluteDiscount() {
		try {

			String absoluteDiscount = CommonFunctions.getInstance().generateRandomNumeric(2) + "000";

			CommonFunctions.getInstance().actionClearAndSendkeys(txtAbsoluteDiscount, absoluteDiscount);

			System.setProperty("absoluteDiscount", absoluteDiscount);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void sendKeysStartDate() {
		try {

			// Get the current LocalDate
			LocalDate d = LocalDate.now();

			// Define the desired date format
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

			// Format the LocalDate into a String
			String formattedDate = d.format(formatter);

			CommonFunctions.getInstance().sendkeys(txtStartDate, formattedDate);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void sendKeysPublicDate() {
		try {

			// Get the current LocalDate
			LocalDate d = LocalDate.now();

			// Define the desired date format
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

			// Format the LocalDate into a String
			String formattedDate = d.format(formatter);

			CommonFunctions.getInstance().sendkeys(txtPublicTime, formattedDate);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void sendKeysPercentDiscount() {
		try {

			String percentDiscount = CommonFunctions.getInstance().generateRandomNumeric(2);

//			String percentDiscount = "28";

			CommonFunctions.getInstance().actionClearAndSendkeys(txtPercentDiscount, percentDiscount);

			System.setProperty("percentDiscount", percentDiscount);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void sendKeysMaxDiscount() {
		try {

			if (System.getProperty("percentDiscount") == null) {

				String maxDiscount = CommonFunctions.getInstance().generateRandomNumeric(6) + "000";

				CommonFunctions.getInstance().actionClearAndSendkeys(txtMaxDiscount, maxDiscount);

				System.setProperty("maxDiscount", maxDiscount);

			} else {

				String maxDiscount = CommonFunctions.getInstance().generateRandomNumeric(6) + "000";

				CommonFunctions.getInstance().actionClearAndSendkeys(txtMaxDiscount, maxDiscount);

				System.setProperty("maxDiscount", maxDiscount);

			}

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void clickStatus() {
		try {

			CommonFunctions.getInstance().clickElement(checkBoxStatus);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void clickBtnAddCode() {
		try {

			CommonFunctions.getInstance().clickElement(btnAddCode);

			Thread.sleep(2000);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void selectProductName() {
		try {

			CommonFunctions.getInstance().clearAndSenkeys(selectProductName, System.getProperty("dProductName"));

			String xpathItemProductName = itemProductName.replace("option", System.getProperty("dProductName"));

			CommonFunctions.getInstance().clickElement(By.xpath(xpathItemProductName));

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void clickBtnSaveCreateTikcet() {
		try {

			CommonFunctions.getInstance().clickElement(btnSaveCreateTicket);

			Thread.sleep(5000);

			if (CommonFunctions.getInstance().checkElementsByVisibility(btnSaveCreateTicket)) {

				CommonFunctions.getInstance().clickElement(btnSaveCreateTicket);

			}

			DriverManager.getInstance().getDriver().navigate().back();

			CommonFunctions.getInstance().waitForElementToDisappear(iconProgress, timeOut);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void clickBtnApprove() {
		try {

			String xpathApprove = btnOptionApprove.replace("option", System.getProperty("dProductName"));

			CommonFunctions.getInstance().clickElement(By.xpath(xpathApprove));

			CommonFunctions.getInstance().clickElement(btnApprove);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void verifyStatus(String status) {
		try {

			String xpathStatus = txtStatus.replace("option", System.getProperty("dProductName")).replace("status",
					status);

			CommonFunctions.getInstance().verifyDataEquals(status,
					CommonFunctions.getInstance().getText(By.xpath(xpathStatus)));

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void clickBtnCreatePromotion() {
		try {

			CommonFunctions.getInstance().clickElement(btnCreateNewPromotion);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void sendKeysPromotionName() {
		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(txtPromotionName, timeOut);

			String promotionName = "Sale Discount " + CommonFunctions.getInstance().generateRandomNumeric(4);

			CommonFunctions.getInstance().sendkeys(txtPromotionName, promotionName);

			System.setProperty("promotionName", promotionName);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void selectPromotionType(String data) {
		try {

			CommonFunctions.getInstance().clickElement(selectPromotionType);

			String xpathItemPromotionType = itemPromtionType.replace("option", data);

			CommonFunctions.getInstance().clickElement(By.xpath(xpathItemPromotionType));

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void sendKeysContentPromotion() {
		try {

			String content = "Sale Product base on " + CommonFunctions.getInstance().generateRandomNumeric(4);

			CommonFunctions.getInstance().sendkeys(txtContentPromotion, content);

			System.setProperty("contentPromotion", content);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void clickBtnAddPromotion() {
		try {

			CommonFunctions.getInstance().clickElement(btnAddPromotion);

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnConfirmAddPromotion, timeOut);

			CommonFunctions.getInstance().actionClickElement(btnConfirmAddPromotion);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void clickBtnCreateExchangePoint() {
		try {

			CommonFunctions.getInstance().clickElement(btnCreateExchangePoint);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void selectPromotion() {
		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(txtPointPromotionName, timeOut);

			String xpathPromotion = itemPromotion.replace("option", System.getProperty("promotionName"));

			CommonFunctions.getInstance().sendkeys(txtPointPromotionName, System.getProperty("promotionName"));

			CommonFunctions.getInstance().clickElement(By.xpath(xpathPromotion));

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void sendKeysPoint() {
		try {

			CommonFunctions.getInstance().actionClearAndSendkeys(txtPoint, "1");

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void selectStatus(String status) {
		try {

			String xpathDisplayStatus = itemStatus.replace("option", status);

			CommonFunctions.getInstance().sendkeys(txtStatusDisplay, status);

			CommonFunctions.getInstance().clickElement(By.xpath(xpathDisplayStatus));

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void clickBtnSavePoint() {
		try {

			CommonFunctions.getInstance().clickElement(btnSavePoint);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void clickBtnCreateCampaign() {
		try {

			CommonFunctions.getInstance().clickElement(btnCreateCampaign);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void sendKeysPromotionCampaign() {
		try {

			Thread.sleep(2000);

			CommonFunctions.getInstance().waitForVisibilityOfAllElements(txtCampaignName, timeOut);

			if (System.getProperty("campaignType").equals("Flash sale")) {

				String promotionCampaignName = "Flash Sales Discount Promotion Campaign "
						+ CommonFunctions.getInstance().generateRandomNumeric(5);

				CommonFunctions.getInstance().sendkeys(txtCampaignName, promotionCampaignName);

				System.setProperty("promotionCampaignName", promotionCampaignName);

			} else {

				String promotionCampaignName = "Sales Discount Absolute Promotion Campaign "
						+ CommonFunctions.getInstance().generateRandomNumeric(5);

				CommonFunctions.getInstance().sendkeys(txtCampaignName, promotionCampaignName);

				System.setProperty("promotionCampaignName", promotionCampaignName);

			}

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void selectCampaignType(String type) {
		try {

			String xpathCampaignType = rdoCampaignType.replace("option", type);

			CommonFunctions.getInstance().clickElement(By.xpath(xpathCampaignType));

			System.setProperty("campaignType", type);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void sendKeysRegistrationCampaign() {
		try {

			// Get the current LocalDate
			LocalDate d = LocalDate.now();

			// Define the desired date format
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

			// Format the LocalDate into a String
			String formattedDate = d.format(formatter) + " 00:00:00";

			CommonFunctions.getInstance().actionClearAndSendkeys(txtRegistrationStartTime, formattedDate);

			CommonFunctions.getInstance().actionClearAndSendkeys(txtStartTime, formattedDate);

			Thread.sleep(1000);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void uploadBanner() {
		try {

			String img = System.getProperty("user.dir") + "\\src\\test\\resources\\img\\" + "discount.png";

			elem = DriverManager.getInstance().getDriver().findElement(txtBanner);

			CommonFunctions.getInstance().uploadImg(elem, img);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void clickBtnSaveCampaign() {
		try {

			CommonFunctions.getInstance().clickElement(btnSaveCampaign);

			Thread.sleep(5000);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void clickActiveCampaign() {
		try {

			String xpathActiveCampaign = checkBoxActive.replace("option", System.getProperty("promotionCampaignName"));

			CommonFunctions.getInstance().clickElement(By.xpath(xpathActiveCampaign));

			CommonFunctions.getInstance().clickElement(btnConfirmActive);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void clickBtnCreateCampaignTicket() {
		try {

			CommonFunctions.getInstance().clickElement(btnCreateCampaignTicket);

			CommonFunctions.getInstance().waitForElementToDisappear(iconLoader, timeOut);

			CommonFunctions.getInstance().waitForElementToDisappear(iconProgress, timeOut);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void selectSaleCampaign() {
		try {

			CommonFunctions.getInstance().sendkeys(selectSaleCampaign, System.getProperty("promotionCampaignName"));

			String xpathSaleCampaign = itemSaleCampaign.replace("option", System.getProperty("promotionCampaignName"));

			CommonFunctions.getInstance().clickElement(By.xpath(xpathSaleCampaign));

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void selectPricingProductName() {
		try {

			Thread.sleep(3000);

			CommonFunctions.getInstance().sendkeys(selectPricingProductName, System.getProperty("dProductName"));

			String xpathProductName = itemPricingProductName.replace("option", System.getProperty("dProductName"));

			CommonFunctions.getInstance().clickElement(By.xpath(xpathProductName));

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void selectTimeFlashSale() {
		try {

			Thread.sleep(3000);

			CommonFunctions.getInstance().clickElement(selectTimeFlashSale);

			CommonFunctions.getInstance().clickElement(itemTimeFlashSale);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void selectSaleType(String type) {
		try {

			CommonFunctions.getInstance().clickElement(selectSaleType);

			String xpathSaleType = itemSaleType.replace("option", type);

			CommonFunctions.getInstance().clickElement(By.xpath(xpathSaleType));

			System.setProperty("saleType", type);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void sendKeysCampaignPrice() {
		try {

			if (System.getProperty("saleType").equals("Giảm giá tuyệt đối")) {

				CommonFunctions.getInstance().sendkeys(txtCampaignPrice,
						CommonFunctions.getInstance().generateRandomNumeric(3) + "000");

			} else {

				CommonFunctions.getInstance().sendkeys(txtCampaignPrice,
						CommonFunctions.getInstance().generateRandomNumeric(2));

			}

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void sendKeysQuantity() {
		try {

			CommonFunctions.getInstance().sendkeys(txtQuanity, CommonFunctions.getInstance().generateRandomNumeric(2));

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void clickBtnSaveCampaignTicket() {
		try {

			CommonFunctions.getInstance().clickElement(btnSaveCampaignTicket);

			Thread.sleep(5000);

			if (DriverManager.getInstance().getDriver().findElement(btnSaveCampaignTicket).isEnabled()) {

				CommonFunctions.getInstance().clickElement(btnSaveCampaignTicket);

				Thread.sleep(2000);

			}

			DriverManager.getInstance().getDriver().navigate().back();

			CommonFunctions.getInstance().waitForPageLoad(timeOut);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void clickAtiveCampaignTicket() {
		try {

			String xpathActive = btnActiveCampaignTicket.replace("option", System.getProperty("promotionCampaignName"));

			CommonFunctions.getInstance().clickElement(By.xpath(xpathActive));

			CommonFunctions.getInstance().clickElement(btnConfirmActiveCampaignTicket);

			Thread.sleep(5000);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

}
