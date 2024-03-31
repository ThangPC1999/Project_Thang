package actions;

import java.awt.AWTException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import base.driver.DriverManager;
import net.bytebuddy.asm.Advice.Local;
import utilities.CommonFunctions;

public class Internal_WMSActions {
	private static final By btnMenu = By.xpath(System.getProperty("Internal.Home.Menu.Button"));
	private static final By btnMenuWarehouse = By.xpath(System.getProperty("Internal.Home.Menu.WMS.Button"));
	private static String txtNameWareHouse = System.getProperty("Internal.Home.WMS.NameWareHouse.Text");
	private static String txtNumberAdmin = System.getProperty("Internal.Home.WMS.NumberAdmin.Input");
	private static final By txtNumberSKU = By.xpath(System.getProperty("Internal.Home.WMS.SKU.Input"));
	private static final By txtStatus = By.xpath(System.getProperty("Internal.Home.WMS.Status.Input"));
	private static final By listProduct = By.xpath(System.getProperty("Internal.Home.WMS.ListProduct.Input"));
	private static final By btnManageWareHouse = By.xpath(System.getProperty("Internal.Home.WMS.Menu.ManageWareHouse"));
	private static final By btnInventory = By
			.xpath(System.getProperty("Internal.Home.WMS.Menu.ManageWareHouse.Inventory"));
	private static final By btnInternalTransfer = By
			.xpath(System.getProperty("Internal.Home.WMS.Menu.ManageWareHouse.Inventory.InternalTransfer"));
	private static final By btnCreateRequest = By
			.xpath(System.getProperty("Internal.Home.WMS.InternalTransfer.CreateRequest.Button"));
	private static final By btnFromWarehouse = By
			.xpath(System.getProperty("Internal.Home.WMS.InternalTransfer.CreateRequest.FromWareHouse.Input"));
	private static final By txtItemFromWareHouse = By
			.xpath(System.getProperty("Internal.Home.WMS.InternalTransfer.CreateRequest.FromWareHouse.CUSTOMER"));
	private static final By btnToWarehouse = By
			.xpath(System.getProperty("Internal.Home.WMS.InternalTransfer.CreateRequest.ToWareHouse.Input"));
	private static final By txtItemToWareHouse = By
			.xpath(System.getProperty("Internal.Home.WMS.InternalTransfer.CreateRequest.ToWareHouse.MAIN"));
	private static final By btnAddProduct = By
			.xpath(System.getProperty("Internal.Home.WMS.InternalTransfer.CreateRequest.AddProduct.Button"));
	private static final By txtProductName = By
			.xpath(System.getProperty("Internal.Home.WMS.InternalTransfer.CreateRequest.ProductName.Input"));
	private static final By txtConsignment = By
			.xpath(System.getProperty("Internal.Home.WMS.InternalTransfer.CreateRequest.Consignment.Input"));
	private static final By txtExpire = By
			.xpath(System.getProperty("Internal.Home.WMS.InternalTransfer.CreateRequest.Expire.Input"));
	private static final By txtLocation = By
			.xpath(System.getProperty("Internal.Home.WMS.InternalTransfer.CreateRequest.ToTheLocation.Input"));
	private static final By txtNumberTransfer = By
			.xpath(System.getProperty("Internal.Home.WMS.InternalTransfer.CreateRequest.NumberTransfer.Input"));
	private static final By btnViewTicketPick = By.xpath(System.getProperty("Internal.Home.WMS.ViewTicketPick.Button"));
	private static final By btnActiveTicket = By
			.xpath(System.getProperty("Internal.Home.WMS.DetailTicketPick.ActiveTicket.Button"));
	private static final By txtActiveReason = By
			.xpath(System.getProperty("Internal.Home.WMS.DetailTicketPick.ActiveReason.Input"));
	private static final By btnActive = By
			.xpath(System.getProperty("Internal.Home.WMS.DetailTicketPick.Active.Button"));
	private static final By txtZoneCode = By
			.xpath(System.getProperty("Internal.Home.WMS.DetailTicketPick.ZoneCode.Text"));
	private static final By txtListIdTicket = By
			.xpath(System.getProperty("Internal.Home.WMS.DetailTicketPick.TicketId.Text"));
	private static String txtAmmount = System.getProperty("Internal.Home.WMS.DetailTicketPick.Ammount.Text");
	private static final By btnLocation = By
			.xpath(System.getProperty("Internal.Home.WMS.ManageWarehouse.Location.Button"));
	private static final By btnManageLocation = By
			.xpath(System.getProperty("Internal.Home.WMS.ManageWarehouse.Location.ManageLocation.Button"));
	private static final By selectLocation = By
			.xpath(System.getProperty("Internal.Home.WMS.ManageWarehouse.ListLocaion.Status.Select"));
	private static final By txtEmptyLocation = By
			.xpath(System.getProperty("Internal.Home.WMS.ManageWarehouse.ListLocaion.Empty.Text"));
	private static final By btnBasket = By
			.xpath(System.getProperty("Internal.Home.WMS.ManageWarehouse.ListLocaion.Basket.Button"));
	private static final By txtBasketCode = By
			.xpath(System.getProperty("Internal.Home.WMS.ManageWarehouse.ListLocaion.BasketCode.Text"));
	private static final By listIdProduct = By
			.xpath(System.getProperty("Internal.Home.WMS.DetailTicketPick.ListIdProduct.Text"));
	private static final By listSkus = By.xpath(System.getProperty("Internal.Home.WMS.DetailTicketPick.ListSkus.Text"));
	private static final By btnQCMenu = By.xpath(System.getProperty("Internal.Home.WMS.Menu.QC.Button"));
	private static final By btnStartShift = By.xpath(System.getProperty("Internal.Home.WMS.QC.StartShift.Button"));
	private static final By txtLocationSearch = By.xpath(System.getProperty("Internal.Home.WMS.QC.Location.Input"));
	private static final By txtSearchPick = By.xpath(System.getProperty("Internal.Home.WMS.QC.Location.Input"));
	private static final By btnConfirm = By.xpath(System.getProperty("Internal.Home.WMS.QC.Confirm.Button"));
	private static final By txtQrCode = By.xpath(System.getProperty("Internal.Home.WMS.QC.QR.Text"));
	private static final By btnFinish = By.xpath(System.getProperty("Internal.Home.WMS.QC.Finish.Button"));
	private static final By btnBookLogistic = By
			.xpath(System.getProperty("Internal.Home.WMS.DetailTicketPick.BookLogistic.Button"));
	private static final By btnConfirmBooking = By
			.xpath(System.getProperty("Internal.Home.WMS.DetailTicketPick.BookLogistic.Confirm.Button"));
	private static final By txtPercent = By.xpath(System.getProperty("Internal.Home.WMS.PercentTicket.Text"));
	private static final By iconLoader = By.xpath(System.getProperty("Icon.Loader"));
	private static final By iconProgress = By.xpath(System.getProperty("Icon.Progress"));
	private static final By btnSubMenuProduct = By
			.xpath(System.getProperty("Internal.Home.WMS.ManageWarehouse.Product.Button"));
	private static final By btnSettingProduct = By
			.xpath(System.getProperty("Internal.Home.WMS.ManageWarehouse.Product.Setting.Button"));
	private static final By txtSearchProduct = By
			.xpath(System.getProperty("Internal.Home.WMS.ManageWarehouse.Product.Setting.SearchProduct.Input"));
	private static String txtOptionItem = System
			.getProperty("Internal.Home.WMS.ManageWarehouse.Product.Setting.Item.Text");
	private static final By txtSettingLocation = By
			.xpath(System.getProperty("Internal.Home.WMS.ManageWarehouse.Product.Setting.SearchLocation.Input"));
	private static final By txtListSkus = By
			.xpath(System.getProperty("Internal.Home.WMS.ManageWarehouse.Product.Setting.Sku.Text"));
	private static final By btnSubMenuCheckIn = By
			.xpath(System.getProperty("Internal.Home.WMS.Menu.Inbound.ReceiveMerchandise.CheckIn.Button"));
	private static final By btnMenuInbound = By.xpath(System.getProperty("Internal.Home.WMS.Menu.Inbound.Button"));
	private static final By btnSubMenuReceiveMerchandise = By
			.xpath(System.getProperty("Internal.Home.WMS.Menu.Inbound.ReceiveMerchandise.Button"));
	private static final By btnSubMenuReceiveSession = By
			.xpath(System.getProperty("Internal.Home.WMS.Menu.Inbound.ReceiveMerchandise.ReceiveSession.Button"));
	private static final By btnClosed = By
			.xpath(System.getProperty("Internal.Home.WMS.Inbound.ReceiveMerchandise.CheckIn.Close.Button"));
	private static final By txtNumberTicket = By
			.xpath(System.getProperty("Internal.Home.WMS.Inbound.ReceiveMerchandise.CheckIn.NumberTicket.Input"));
	private static final By btnCheckIn = By
			.xpath(System.getProperty("Internal.Home.WMS.Inbound.ReceiveMerchandise.CheckIn.CheckIn.Button"));
	private static final By txtCheckInNum = By
			.xpath(System.getProperty("Internal.Home.WMS.Inbound.ReceiveMerchandise.CheckIn.CheckInNumber.Input"));
	private static final By txtSearchPO = By
			.xpath(System.getProperty("Internal.Home.WMS.Inbound.ReceiveMerchandise.ReceiveSession.SearchPO.Input"));
	private static final By txtNumberSession = By.xpath(
			System.getProperty("Internal.Home.WMS.Inbound.ReceiveMerchandise.ReceiveSession.NumberSession.Input"));
	private static final By btnCheckConveyor = By.xpath(
			System.getProperty("Internal.Home.WMS.Inbound.ReceiveMerchandise.ReceiveSession.CheckConveyor.Button"));
	private static final By btnLinkPO = By.xpath(System.getProperty("Internal.Home.MEDX.Buy.PO.AddNew.NumberPO.Link"));
	private static final By btnConnect = By
			.xpath(System.getProperty("Internal.Home.WMS.Inbound.DetailTicket.Connect.Button"));
	private static final By btnCreateCode = By.xpath(System.getProperty("Internal.Home.WMS.Inbound.CreateCode.Button"));
	private static final By btnViewDetail = By
			.xpath(System.getProperty("Internal.Home.WMS.Inbound.DetailTicket.ViewDetail.Button"));
	private static final By txtCode = By.xpath(System.getProperty("Internal.Home.WMS.Inbound.Code.Input"));
	private static final By txtEmptyCode = By
			.xpath(System.getProperty("Internal.Home.WMS.Inbound.DetailTicket.ScanBasket.Input"));
	private static final By txtLot = By.xpath(System.getProperty("Internal.Home.WMS.Inbound.DetailTicket.Lot.Input"));
	private static final By txtDate = By.xpath(System.getProperty("Internal.Home.WMS.Inbound.DetailTicket.Date.Input"));
	private static final By btnUpdateLotDate = By
			.xpath(System.getProperty("Internal.Home.WMS.Inbound.DetailTicket.UpdateLotDate.Button"));
	private static final By btnEditAmmount = By
			.xpath(System.getProperty("Internal.Home.WMS.Inbound.DetailTicket.EditAmmount.Button"));
	private static final By txtNewAmmount = By
			.xpath(System.getProperty("Internal.Home.WMS.Inbound.DetailTicket.NewAmmount.Button"));
	private static final By btnUpdateAmmount = By
			.xpath(System.getProperty("Internal.Home.WMS.Inbound.DetailTicket.UpdateAmmount.Button"));
	private static final By btnFinishDetail = By
			.xpath(System.getProperty("Internal.Home.WMS.Inbound.DetailTicket.Finish.Button"));
	private static final By txtMsgSuccess = By.xpath(System.getProperty("Message.Success"));
	private static String txtLinkPO = System.getProperty("Internal.Home.WMS.Inbound.LinkPO.Text");
	private static final By btnScanQR = By
			.xpath(System.getProperty("Internal.Home.WMS.Inbound.DetailPO.ScanQR.Button"));
	private static final By qrCodePO = By.xpath(System.getProperty("Internal.Home.WMS.Inbound.DetailPO.QR.Text"));
	private static final By imgQR = By.xpath(System.getProperty("Internal.Home.WMS.Inbound.DetailPO.QR.Image"));
	private static final By txtAmmountAvailability = By
			.xpath(System.getProperty("Internal.Home.WMS.Inbound.ListSkus.Availability.Text"));
	private static final By txtLinkSkus = By
			.xpath(System.getProperty("Internal.Home.WMS.Inbound.DetailPO.LinkSkus.Text"));

	@FindBy(how = How.XPATH, using = "")
	private WebElement elem;
	private List<WebElement> lElems;

	int timeOut = Integer.parseInt(System.getProperty("objectTimeout"));

	private static class SingletonHelper {
		private static final Internal_WMSActions INSTANCE = new Internal_WMSActions();
	}

	public static Internal_WMSActions getInstance() {
		return SingletonHelper.INSTANCE;
	}

	public void clickMenuWarehouse() {

		try {

			CommonFunctions.getInstance().waitForElementToDisappear(iconLoader, timeOut);

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnMenu, timeOut);

			elem = CommonFunctions.getInstance().findElementByVisibility(btnMenu);

			elem.click();

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnMenuWarehouse, timeOut);

			elem = CommonFunctions.getInstance().findElementByVisibility(btnMenuWarehouse);

			elem.click();
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void clickNameWarehouse(String optionName) {

		try {

			String xpathName = txtNameWareHouse.replace("option", optionName);

			CommonFunctions.getInstance().waitForElementToDisappear(iconLoader, timeOut);

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(By.xpath(xpathName), timeOut);

			elem = CommonFunctions.getInstance().findElementByVisibility(By.xpath(xpathName));

			elem.click();

			CommonFunctions.getInstance().waitForElementToDisappear(iconProgress, timeOut);

			CommonFunctions.getInstance().waitForElementToDisappear(iconLoader, timeOut);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void clickBtnManageWareHouse() {

		try {

			Thread.sleep(2000);

			// Hover over the btnManageWareHouse element using CommonFunctions
			CommonFunctions.getInstance().hoverElement(btnManageWareHouse);

			CommonFunctions.getInstance().clickElement(btnManageWareHouse);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void clickSubMenuSetting() {

		try {

			CommonFunctions.getInstance().clickElement(btnSubMenuProduct);

			elem = CommonFunctions.getInstance().findElementByVisibility(btnSettingProduct);

			elem.click();

			CommonFunctions.getInstance().waitForElementToDisappear(iconLoader, timeOut);
			CommonFunctions.getInstance().waitForElementToDisappear(iconProgress, timeOut);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void clickMenuInbound() {

		try {

			Thread.sleep(3000);

			if (CommonFunctions.getInstance().checkElementsByVisibilityWithTimeInput(btnClosed, 5)) {

				CommonFunctions.getInstance().clickElement(btnClosed);

			}
//Đóng
			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnMenuInbound, timeOut);

			elem = CommonFunctions.getInstance().findElementByVisibility(btnMenuInbound);

			elem.click();

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void clickSubMenuReceive() {

		try {

			CommonFunctions.getInstance().clickElement(btnSubMenuReceiveMerchandise);

			elem = CommonFunctions.getInstance().findElementByVisibility(btnSubMenuReceiveMerchandise);

			elem.click();

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void clickSubMenuSubInboundCheckIn() {

		try {
			
			CommonFunctions.getInstance().clickElement(btnSubMenuCheckIn);

			CommonFunctions.getInstance().waitForElementToDisappear(iconLoader, timeOut);
			
			CommonFunctions.getInstance().waitForElementToDisappear(iconProgress, timeOut);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void clickSubMenuSubReceiveSession() {

		try {

			elem = CommonFunctions.getInstance().findElementByVisibility(btnSubMenuReceiveSession);

			elem.click();

			CommonFunctions.getInstance().waitForElementToDisappear(iconLoader, timeOut);
			CommonFunctions.getInstance().waitForElementToDisappear(iconProgress, timeOut);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void clickMenuQC() {

		elem = CommonFunctions.getInstance().findElementByVisibility(btnQCMenu);

		// Create Actions object
		Actions actions = new Actions(DriverManager.getInstance().getDriver());

		// Open the link in a new tab
		actions.keyDown(Keys.CONTROL).click(elem).keyUp(Keys.CONTROL).perform();

		// Switch to the new tab
		CommonFunctions.getInstance().switchTab(CommonFunctions.getInstance().getAllTabs().get(CommonFunctions.getInstance().getAllTabs().size() - 1));

		CommonFunctions.getInstance().waitForPageLoad(timeOut);

	}

	public void clickBtnStartShift() {

		elem = CommonFunctions.getInstance().findElementByVisibility(btnStartShift);

		elem.click();

	}

	public void sendKeysLocationSearch() {

		elem = CommonFunctions.getInstance().findElementByVisibility(txtLocationSearch);

		elem.sendKeys(System.getProperty("dShiftCode"));

	}

	public void sendKeysNumberPick() throws InterruptedException {

		Thread.sleep(2000);

		elem = CommonFunctions.getInstance().findElementByVisibility(txtSearchPick);

		elem.sendKeys(System.getProperty("dBasketCode"));

		elem.sendKeys(Keys.ENTER);

	}

	public void sendKeysQR() throws AWTException, InterruptedException {

		Thread.sleep(1000);

		// Quantity
		String quantity = System.getProperty("quantity");

		// Remove the square brackets from the numberSku
		quantity = quantity.substring(1, quantity.length() - 1);

		// Split the string using commas as the delimiter and store the values into a
		// List<String>
		List<String> lQuantity = Arrays.asList(quantity.split(", "));

		/// Qr code
		String qrCode = System.getProperty("qrCode");

		// Remove the square brackets from the numberSku
		qrCode = qrCode.substring(1, qrCode.length() - 1);

		List<Integer> lItem = lQuantity.stream().map(Integer::valueOf).collect(Collectors.toList());

		// Split the string using commas as the delimiter and store the values into a
		// List<String>
		List<String> lQrCode = Arrays.asList(qrCode.split(", "));

		for (int i = 0; i < lItem.size(); i++) {

			int item = lItem.get(i);

			for (int y = 0; y < item; y++) {

				elem = CommonFunctions.getInstance().findElementByVisibility(txtQrCode);

				elem.click();

//				Thread.sleep(3000);
					
				CommonFunctions.getInstance().copyPasteByRobot(lQrCode.get(i).replace("[", "").replace("]", "") + (y + 1));

				Thread.sleep(1500);

			}

		}

		System.out.println("Test");

	}

	public void clickBtnApply() {

		elem = CommonFunctions.getInstance().findElementByVisibility(btnConfirm);

		elem.click();

	}

	public void clickBtnFinish() {

		elem = CommonFunctions.getInstance().findElementByVisibility(btnFinish);

		elem.click();

		// Wait for the visibility of all elements with txtStatus locator
		CommonFunctions.getInstance().waitForVisibilityOfAllElement(txtStatus, timeOut);

		String currentUrl = DriverManager.getInstance().getDriver().getCurrentUrl();

		System.setProperty("currentUrl", currentUrl);

	}

	public void clickBtnInternalTransfer() {

		try {

			Thread.sleep(2000);

			elem = CommonFunctions.getInstance().findElementByVisibility(btnInternalTransfer);

			// Create Actions object
			Actions actions = new Actions(DriverManager.getInstance().getDriver());

			// Open the link in a new tab
			actions.keyDown(Keys.CONTROL).click(elem).keyUp(Keys.CONTROL).perform();

			// Switch to the new tab
			CommonFunctions.getInstance().switchTab(CommonFunctions.getInstance().getAllTabs().get(CommonFunctions.getInstance().getAllTabs().size()-1));

			CommonFunctions.getInstance().waitForPageLoad(timeOut);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void clickBtnInventory() {

		try {

			CommonFunctions.getInstance().hoverElement(btnInventory);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void clickBtnCreateRequest() {

		try {

			elem = CommonFunctions.getInstance().findElementByVisibility(btnCreateRequest);

			elem.click();

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void clickFromWarehouse() {

		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnFromWarehouse, timeOut);

			elem = CommonFunctions.getInstance().findElementByVisibility(btnFromWarehouse);

			elem.click();

			elem = CommonFunctions.getInstance().findElementByVisibility(txtItemFromWareHouse);

			elem.click();

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void clickToWarehouse() {

		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnToWarehouse, timeOut);

			elem = CommonFunctions.getInstance().findElementByVisibility(btnToWarehouse);

			elem.click();

			if (CommonFunctions.getInstance().checkElementsByVisibility(txtItemToWareHouse)) {

				elem = CommonFunctions.getInstance().findElementByVisibility(txtItemToWareHouse);

				elem.click();

			} else {

				elem = CommonFunctions.getInstance().findElementByVisibility(btnToWarehouse);

				elem.click();

				elem = CommonFunctions.getInstance().findElementByVisibility(txtItemToWareHouse);

				elem.click();

			}

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void clickAddLineProduct() {

		try {

			String numberSku = System.getProperty("numberSKU");

			// Remove the square brackets from the numberSku
			numberSku = numberSku.substring(1, numberSku.length() - 1);

			// Split the string using commas as the delimiter and store the values into a
			// List<String>
			List<String> lNumberSku = Arrays.asList(numberSku.split(", "));

			for (int i = 0; i < lNumberSku.size(); i++) {

				CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnAddProduct, timeOut);

				elem = CommonFunctions.getInstance().findElementByVisibility(btnAddProduct);

				elem.click();

			}

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void sendKeysProduct() {

		try {

			String numberSku = System.getProperty("numberSKU");

			// Remove the square brackets from the numberSku
			numberSku = numberSku.substring(1, numberSku.length() - 1);

			List<WebElement> lElemsProductName = DriverManager.getInstance().getDriver().findElements(txtProductName);
			List<WebElement> ltxtConsignment = DriverManager.getInstance().getDriver().findElements(txtConsignment);
			List<WebElement> lElemsExprire = DriverManager.getInstance().getDriver().findElements(txtExpire);
			List<WebElement> lElemsLocation = DriverManager.getInstance().getDriver().findElements(txtLocation);
			List<WebElement> lElemsNumberTransfer = DriverManager.getInstance().getDriver()
					.findElements(txtNumberTransfer);
			// Split the string using commas as the delimiter and store the values into a
			// List<String>
			List<String> lNumberSku = Arrays.asList(numberSku.split(", "));

			for (int i = 0; i < lNumberSku.size(); i++) {

				if (lNumberSku.size() > 1) {

					lElemsProductName.get(i).sendKeys(lNumberSku.get(i + 1));
					ltxtConsignment.get(i).sendKeys("1");
					lElemsExprire.get(i).sendKeys("1");
					lElemsLocation.get(i).sendKeys("1");
					lElemsNumberTransfer.get(i).sendKeys(lNumberSku.get(i + 1));

				}

			}

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void clickViewTicketPick() {

		try {

			for (int i = 0; i < 20; i++) {

				elem = CommonFunctions.getInstance().findElementByVisibility(txtPercent);

				String percent = elem.getText();

				if (!percent.contains("100")) {

					DriverManager.getInstance().getDriver().navigate().refresh();

					CommonFunctions.getInstance().waitForPageLoad(timeOut);

				} else {

					break;

				}

			}

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnViewTicketPick, timeOut);

			elem = CommonFunctions.getInstance().findElementByVisibility(btnViewTicketPick);

			CommonFunctions.getInstance().clickByJavascript(elem);

			CommonFunctions.getInstance().switchTab(CommonFunctions.getInstance().getAllTabs()
					.get(CommonFunctions.getInstance().getAllTabs().size() - 1));

			CommonFunctions.getInstance().waitForPageLoad(timeOut);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void clickBtnActiveTicket() {

		try {

			if (CommonFunctions.getInstance().checkElementsByVisibilityWithTimeInput(btnActiveTicket, 10)) {

				CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnActiveTicket, timeOut);

				elem = CommonFunctions.getInstance().findElementByVisibility(btnActiveTicket);

				CommonFunctions.getInstance().clickByJavascript(elem);

			}

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void sendKeysReasonActive() {

		try {

			if (CommonFunctions.getInstance().checkElementsByVisibilityWithTimeInput(txtActiveReason, 5)) {

				CommonFunctions.getInstance().waitForVisibilityOfAllElement(txtActiveReason, timeOut);

				elem = CommonFunctions.getInstance().findElementByVisibility(txtActiveReason);

				elem.sendKeys("1 2 3 4 5");

			}

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void clickBtnActive() {

		try {

			if (CommonFunctions.getInstance().checkElementsByVisibilityWithTimeInput(btnActive, 15)) {

				CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnActive, timeOut);

				elem = CommonFunctions.getInstance().findElementByVisibility(btnActive);

				CommonFunctions.getInstance().clickByJavascript(elem);

				CommonFunctions.getInstance().refresh();

				CommonFunctions.getInstance().waitForPageLoad(timeOut);

			}

			CommonFunctions.getInstance().refresh();

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void verifyStatusChange(String data) throws InterruptedException {

		if (data.equals("CHỜ ĐÓNG GÓI") || data.equals("ĐÃ HOÀN THÀNH")) {

			// Refresh the page
			CommonFunctions.getInstance().refresh();

			// Refresh the page
			CommonFunctions.getInstance().refresh();

			// Wait for the page to load
			CommonFunctions.getInstance().waitForPageLoad(timeOut);

			// Wait for the visibility of all elements with txtStatus locator
			CommonFunctions.getInstance().waitForVisibilityOfAllElement(txtStatus, timeOut);

			// Find the element by visibility using CommonFunctions and store it in elem
			elem = CommonFunctions.getInstance().findElementByVisibility(txtStatus);

			// Get the text of the element and store it in status
			String status = elem.getText();

			// Verify that the status is "Chờ lấy hàng" using CommonFunctions
			CommonFunctions.getInstance().verifyDataEquals(status, data);

		} else {

			// Refresh the page
			CommonFunctions.getInstance().refresh();

			// Wait for the page to load
			CommonFunctions.getInstance().waitForPageLoad(timeOut);

			// Wait for the visibility of all elements with txtStatus locator
			CommonFunctions.getInstance().waitForVisibilityOfAllElement(txtStatus, timeOut);

			// Find the element by visibility using CommonFunctions and store it in elem
			elem = CommonFunctions.getInstance().findElementByVisibility(txtStatus);

			// Get the text of the element and store it in status
			String status = elem.getText();

			// Verify that the status is "Chờ lấy hàng" using CommonFunctions
			CommonFunctions.getInstance().verifyDataEquals(status, data);

			// Find the element by visibility using CommonFunctions and store it in elem
			elem = CommonFunctions.getInstance().findElementByVisibility(txtZoneCode);

			Thread.sleep(3000);

			// Get the text of the element and store it in zoneCode
			String zoneCode = elem.getText();

			// Set the "zoneCode" system property to the value of zoneCode
			System.setProperty("zoneCode", zoneCode);
			
			// Find elements by visibility using driver and store them in lElems
			lElems = DriverManager.getInstance().getDriver().findElements(txtListIdTicket);

			// Create a new ArrayList to store the text values of the elements in
			// listIdTicket
			List<String> listIdTicket = new ArrayList<String>();

			// Iterate over each WebElement in lElems
			for (WebElement item : lElems) {
				// Get the text of the WebElement and add it to listIdTicket
				listIdTicket.add(item.getText());
			}

			// Set the "listIdTicket" system property to the string representation of
			// listIdTicket
			System.setProperty("listIdTicket", listIdTicket.toString());

			if (!data.equals("Chờ QC")) {

				// Remove the square brackets from the string
				// List<String>
				List<String> lProductIdList = new ArrayList<>();;
				List<String> lPosition = new ArrayList<>();
				List<String> lQuantity = new ArrayList<>();
				List<String> lQrCode = new ArrayList<>();
				List<String> lSales = new ArrayList<>();
				List<String> numberSKU = new ArrayList<String>();

				
				lElems = CommonFunctions.getInstance().findElementsByVisibility(listIdProduct);
				

				for (int i = 0; i < lElems.size(); i++) {

					lProductIdList.add(lElems.get(i).getText());

					lQrCode.add(System.getProperty("qrCode"));

				}

				System.out.println(
						"#####################################################################################");

				// Set Number Admin
				for (int i = 0; i < lQrCode.size(); i++) {

					int length = lProductIdList.get(i).replace("[", "").replace("]", "").length();

					String newQrCode = lQrCode.get(i)
							.replaceAll("\\[numberCharacterAdmin\\]", String.format("%02d", length))
							.replaceAll("\\[numberAdmin\\]", lProductIdList.get(i).replace("[", "").replace("]", ""));

					lQrCode.set(i, newQrCode);

					System.out.println(newQrCode);

				}

				// Set Skus
				System.out.println(
						"#####################################################################################");
				for (int i = 0; i < lQrCode.size(); i++) {

					List<WebElement> lSkus = CommonFunctions.getInstance().findElementsByVisibility(listSkus);
					// Get the text of the WebElement and add it to numberSKU
					String sku = lSkus.get(i).getText().substring(0, lSkus.get(i).getText().indexOf("."));
					String newQrCode = lQrCode.get(i)
							.replaceAll("\\[numberCharacterSKU\\]", String.valueOf(String.format("%02d", sku.length())))
							.replaceAll("\\[numberSKU\\]", sku);
					lQrCode.set(i, newQrCode);
					System.out.println(newQrCode);
					numberSKU.add(lSkus.get(i).getText());
					
					//Set
					if(sku.contains("MEDX")) {
						
						lSales.add("MEDX");
						
					} else {
						
						lSales.add("Seller");
					}

				}

				for (int i = 0; i < lProductIdList.size(); i++) {

					// ammount
					int offsetAmmount = 2;
					int incrementAmmount = 2; // Increment value for each iteration
					String xpathAmmount = txtAmmount.replace("option",
							String.valueOf(i * incrementAmmount + offsetAmmount));
					// Find the element by visibility using CommonFunctions and store it in elem
					elem = CommonFunctions.getInstance().findElementByVisibility(By.xpath(xpathAmmount));
					String inputString = elem.getText();

					String[] parts = inputString.split(":");
					String position = parts[1].split("-")[0].trim();
					String quantity = parts[2].trim();

					lPosition.add(position);
					lQuantity.add(quantity);

				}

				System.setProperty("position", lPosition.toString());
				System.setProperty("quantity", lQuantity.toString());
				System.setProperty("lProductIdList", lProductIdList.toString());
				System.setProperty("qrCode", lQrCode.toString());
				System.setProperty("lProductId", lProductIdList.toString());
				System.setProperty("lSales", lSales.toString());
				System.setProperty("numberSKU", numberSKU.toString());

			}

		}

	}

	public void getBasketCode() throws InterruptedException {

		// Find the element by visibility using CommonFunctions and store it in elem
		elem = CommonFunctions.getInstance().findElementByVisibility(btnLocation);

		// Click the element
		elem.click();

		// Find the element by visibility using CommonFunctions and store it in elem
		elem = CommonFunctions.getInstance().findElementByVisibility(btnManageLocation);

		// Create Actions object
		Actions actions = new Actions(DriverManager.getInstance().getDriver());

		// Open the link in a new tab
		actions.keyDown(Keys.CONTROL).click(elem).keyUp(Keys.CONTROL).perform();

		// Switch to the new tab
		CommonFunctions.getInstance().switchTab(CommonFunctions.getInstance().getAllTabs().get(CommonFunctions.getInstance().getAllTabs().size() - 1));

		CommonFunctions.getInstance().waitForPageLoad(timeOut);

		// Wait
		CommonFunctions.getInstance().waitForElementToDisappear(iconProgress, timeOut);

		// Find the element by visibility using CommonFunctions and store it in elem
		elem = CommonFunctions.getInstance().findElementByVisibility(selectLocation);

		// Click the element
		elem.click();

		// Find the element by visibility using CommonFunctions and store it in elem
		elem = CommonFunctions.getInstance().findElementByVisibility(txtEmptyLocation);

		// Click the element
		elem.click();

		// Wait
		CommonFunctions.getInstance().waitForElementToDisappear(iconProgress, timeOut);

		// Find the element by visibility using CommonFunctions and store it in elem
		elem = CommonFunctions.getInstance().findElementByVisibility(btnBasket);

		// Click the element
		elem.click();

		// Wait
		CommonFunctions.getInstance().waitForElementToDisappear(iconProgress, timeOut);

		// Find elements by visibility using driver and store them in lElems
		lElems = DriverManager.getInstance().getDriver().findElements(txtBasketCode);

		// Generate a random index within the range of lElems size
		int randomIndex = new Random().nextInt(lElems.size());

		// Set the "dBasketCode" system property to the text of the element at the
		// random index
		System.setProperty("dBasketCode", lElems.get(randomIndex).getText());

		// Switch to the new tab

		CommonFunctions.getInstance().closeTab(CommonFunctions.getInstance().getAllTabs().get(CommonFunctions.getInstance().getAllTabs().size() - 1));

		CommonFunctions.getInstance().switchTab(CommonFunctions.getInstance().getAllTabs().get(CommonFunctions.getInstance().getAllTabs().size() - 1));

		CommonFunctions.getInstance().waitForPageLoad(timeOut);

	}

	public void clickBtnBookLogistic() throws InterruptedException, AWTException {

		// Find the element by visibility using CommonFunctions and store it in elem
		elem = CommonFunctions.getInstance().findElementByVisibility(btnBookLogistic);

		// Click the element
		elem.click();

		// Find the element by visibility using CommonFunctions and store it in elem
		elem = CommonFunctions.getInstance().findElementByVisibility(btnConfirmBooking);

		// Click the element
		elem.click();

		Thread.sleep(15000);

		// Switch to the 6th tab
		// Switch to the 8th tab
		// Close the 8th tab

		ArrayList<String> windowHandles = new ArrayList<>(DriverManager.getInstance().getDriver().getWindowHandles());

		try {

			if (windowHandles.size() > 1) {

				CommonFunctions.getInstance().switchTab(CommonFunctions.getInstance().getAllTabs().get(CommonFunctions.getInstance().getAllTabs().size() - 2));
				
				CommonFunctions.getInstance().closeTab(CommonFunctions.getInstance().getAllTabs().get(CommonFunctions.getInstance().getAllTabs().size() - 2));

			}

		} catch (Exception e) {

			if (windowHandles.size() > 1) {

				String eighthTabHandle = windowHandles.get(CommonFunctions.getInstance().getAllTabs().size() - 1);

				DriverManager.getInstance().getDriver().switchTo().window(eighthTabHandle);

				CommonFunctions.getInstance().closeTab(CommonFunctions.getInstance().getAllTabs()
						.get(CommonFunctions.getInstance().getAllTabs().size() - 1));

			}
		}

		CommonFunctions.getInstance().switchTab(CommonFunctions.getInstance().getAllTabs().get(CommonFunctions.getInstance().getAllTabs().size() - 1));

	}

	public void sendKeysSearchProduct() {

		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(txtSearchProduct, timeOut);
			
			if(System.getProperty("productId") == null) {
				
				CommonFunctions.getInstance().sendkeys(txtSearchProduct, System.getProperty("dProductName"));
				
				Thread.sleep(5000);

				String xpathItem = txtOptionItem.replace("option", System.getProperty("dProductName"));
				
				CommonFunctions.getInstance().clickJavascript(By.xpath(xpathItem));

				
			} else {
				
				CommonFunctions.getInstance().sendkeys(txtSearchProduct, System.getProperty("productId"));
				
				Thread.sleep(5000);

				String xpathItem = txtOptionItem.replace("option", System.getProperty("productId"));
				
				CommonFunctions.getInstance().clickJavascript(By.xpath(xpathItem));

			}

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void settingLocations() {

		try {
			
			CommonFunctions.getInstance().waitForVisibilityOfAllElement(txtSettingLocation, timeOut);

			CommonFunctions.getInstance().sendkeys(txtSettingLocation, System.getProperty("locationsCode"));

			CommonFunctions.getInstance().clickElement(txtSettingLocation);

			String xpathItem = txtOptionItem.replace("option", System.getProperty("locationsCode"));

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(By.xpath(xpathItem), timeOut);

			CommonFunctions.getInstance().clickElement(By.xpath(xpathItem));

			String skus = CommonFunctions.getInstance().getText(txtListSkus);

			System.setProperty("skus", skus);

		} catch (Exception e) {
 
		}

	}

	public void clickBtnClosed() {

		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnClosed, timeOut);

			CommonFunctions.getInstance().clickElement(btnClosed);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void sendKeysTicketCode() {

		try {

			CommonFunctions.getInstance().waitForElementToDisappear(iconLoader, timeOut);

			CommonFunctions.getInstance().waitForElementToDisappear(iconProgress, timeOut);

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(txtNumberTicket, timeOut);

			CommonFunctions.getInstance().sendkeys(txtNumberTicket, System.getProperty("numberPO"));

			CommonFunctions.getInstance().pressKeys(txtNumberTicket, Keys.ENTER);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void clickBtnCheckIn() {

		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnCheckIn, timeOut);

			CommonFunctions.getInstance().clickElement(btnCheckIn);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void clickBtnNumberSession() {

		try {

			Thread.sleep(2000);

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(txtNumberSession, timeOut);

			CommonFunctions.getInstance().clickElement(txtNumberSession);

			CommonFunctions.getInstance().switchTab(CommonFunctions.getInstance().getAllTabs()
					.get(CommonFunctions.getInstance().getAllTabs().size() - 1));

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void clickBtnCheckConveyor() {

		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnCheckConveyor, timeOut);

			CommonFunctions.getInstance().clickElement(btnCheckConveyor);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void sendKeysCheckInNum() {

		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(txtCheckInNum, timeOut);

			CommonFunctions.getInstance().sendkeys(txtCheckInNum, "1");

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void sendKeysSearchPO() {

		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(txtSearchPO, timeOut);

			CommonFunctions.getInstance().sendkeys(txtSearchPO, System.getProperty("numberPO"));

			CommonFunctions.getInstance().pressKeys(txtSearchPO, Keys.ENTER);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void getEmptyBasketCode() throws InterruptedException {

		// Find the element by visibility using CommonFunctions and store it in elem
		elem = CommonFunctions.getInstance().findElementByVisibility(btnLocation);

		// Click the element
		elem.click();

		Thread.sleep(3000);

		// Find the element by visibility using CommonFunctions and store it in elem
		CommonFunctions.getInstance().clickElement(btnManageLocation);

		Thread.sleep(3000);

		// Wait
		CommonFunctions.getInstance().waitForElementToDisappear(iconProgress, timeOut);

		// Find the element by visibility using CommonFunctions and store it in elem
		CommonFunctions.getInstance().clickElement(selectLocation);

		Thread.sleep(3000);

		// Find the element by visibility using CommonFunctions and store it in elem
		CommonFunctions.getInstance().clickElement(txtEmptyLocation);

		Thread.sleep(3000);

		// Wait
		CommonFunctions.getInstance().waitForElementToDisappear(iconProgress, timeOut);

		// Find the element by visibility using CommonFunctions and store it in elem
		CommonFunctions.getInstance().clickElement(btnBasket);

		Thread.sleep(3000);

		// Wait
		CommonFunctions.getInstance().waitForElementToDisappear(iconProgress, timeOut);

		CommonFunctions.getInstance().waitForElementToDisappear(iconLoader, timeOut);

		// Find elements by visibility using driver and store them in lElems
		lElems = DriverManager.getInstance().getDriver().findElements(txtBasketCode);

		// Generate a random index within the range of lElems size
		int randomIndex = new Random().nextInt(lElems.size());

		// Set the "dBasketCode" system property to the text of the element at the
		// random index
		System.setProperty("dBasketCode", lElems.get(randomIndex).getText());

		// Switch to the new tab

		CommonFunctions.getInstance().closeTab(CommonFunctions.getInstance().getAllTabs().get(CommonFunctions.getInstance().getAllTabs().size() - 1));

		CommonFunctions.getInstance().switchTab(CommonFunctions.getInstance().getAllTabs().get(CommonFunctions.getInstance().getAllTabs().size() - 1));

		CommonFunctions.getInstance().waitForPageLoad(timeOut);

	}

	public void clickBtnLinkPO() {
		try {

			Thread.sleep(3000);

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnLinkPO, timeOut);

			CommonFunctions.getInstance().clickElement(btnLinkPO);

			CommonFunctions.getInstance().switchTab(CommonFunctions.getInstance().getAllTabs()
					.get(CommonFunctions.getInstance().getAllTabs().size() - 1));

			CommonFunctions.getInstance().waitForElementToDisappear(iconLoader, timeOut);

			CommonFunctions.getInstance().waitForElementToDisappear(iconProgress, timeOut);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void clickBtnConnect() {
		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnConnect, timeOut);

			CommonFunctions.getInstance().clickElement(btnConnect);

			CommonFunctions.getInstance().switchTab(CommonFunctions.getInstance().getAllTabs()
					.get(CommonFunctions.getInstance().getAllTabs().size() - 1));

			CommonFunctions.getInstance().waitForElementToDisappear(iconLoader, timeOut);

			CommonFunctions.getInstance().waitForElementToDisappear(iconProgress, timeOut);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void clickBtnCreateCode() {
		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnCreateCode, timeOut);

			CommonFunctions.getInstance().clickElement(btnCreateCode);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void clickBtnViewDetail() {
		try {

			CommonFunctions.getInstance().refresh();

			CommonFunctions.getInstance().waitForPageLoad(timeOut);

			Thread.sleep(2000);

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnViewDetail, timeOut);

			CommonFunctions.getInstance().clickElement(btnViewDetail);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void clickBtnUpdateLotDate() {
		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnUpdateLotDate, timeOut);

			CommonFunctions.getInstance().clickElement(btnUpdateLotDate);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void clickBtnEditAmmount() {
		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnEditAmmount, timeOut);

			CommonFunctions.getInstance().clickElement(btnEditAmmount);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void clickBtnUpdateAmmount() {
		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnUpdateAmmount, timeOut);

			CommonFunctions.getInstance().clickElement(btnUpdateAmmount);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void clickBtnFinishDetail() {
		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnFinishDetail, timeOut);

			CommonFunctions.getInstance().clickElement(btnFinishDetail);

			CommonFunctions.getInstance().waitForElementToDisappear(txtMsgSuccess, timeOut);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void clickLinkDetailPO() {
		try {

			String xpathLinkDetailPO = txtLinkPO.replace("option", System.getProperty("numberPO"));

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(By.xpath(xpathLinkDetailPO), timeOut);

			CommonFunctions.getInstance().clickElement(By.xpath(xpathLinkDetailPO));

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void getQrPO() {
		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(btnScanQR, timeOut);

			CommonFunctions.getInstance().clickJavascript(btnScanQR);

			CommonFunctions.getInstance().clickElement(imgQR);

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(qrCodePO, timeOut);

			System.setProperty("qrCodePO", CommonFunctions.getInstance().getText(qrCodePO));

			CommonFunctions.getInstance().refresh();

			CommonFunctions.getInstance().waitForPageLoad(timeOut);

			CommonFunctions.getInstance().clickElement(txtLinkSkus);

			CommonFunctions.getInstance().waitForPageLoad(timeOut);

			String currentUrl = DriverManager.getInstance().getDriver().getCurrentUrl();

			System.setProperty("currentUrlDetail", currentUrl);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void sendKeysCode() {
		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(txtCode, timeOut);

			String randCharacter = CommonFunctions.getInstance().generateRandomAlpha(2);

			CommonFunctions.getInstance().actionClearAndSendkeys(txtCode, randCharacter);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void sendKeysLot() {
		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(txtLot, timeOut);

			String randCharacter = CommonFunctions.getInstance().generateRandomAlpha(2);

			CommonFunctions.getInstance().actionClearAndSendkeys(txtLot, randCharacter);

			CommonFunctions.getInstance().pressKeys(txtLot, Keys.ENTER);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void sendKeysDate() {
		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(txtDate, timeOut);

			String year = String.valueOf(LocalDate.now().getYear() + 1);

			String date = "2508" + year;

			CommonFunctions.getInstance().actionClearAndSendkeys(txtDate, date);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void sendKeysBasketCode() {
		try {

			CommonFunctions.getInstance().refresh();

			CommonFunctions.getInstance().waitForPageLoad(timeOut);

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(txtEmptyCode, timeOut);

			CommonFunctions.getInstance().actionClearAndSendkeys(txtEmptyCode, System.getProperty("dBasketCode"));

			CommonFunctions.getInstance().pressKeys(txtEmptyCode, Keys.ENTER);
			
			Thread.sleep(3000);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void sendKeysNewAmmount() {
		try {

			CommonFunctions.getInstance().waitForVisibilityOfAllElement(txtNewAmmount, timeOut);

			CommonFunctions.getInstance().actionClearAndSendkeys(txtNewAmmount, System.getProperty("numerQuantity"));

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void redirectToListSkus() {
		try {
			
			CommonFunctions.getInstance().refresh();

			CommonFunctions.getInstance().waitForPageLoad(timeOut);

			CommonFunctions.getInstance().clickElement(By.xpath("//html"));

			CommonFunctions.getInstance().goToUrl(System.getProperty("currentUrlDetail"));

			CommonFunctions.getInstance().waitForPageLoad(timeOut);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void verifyAmmount() {
		try {

			String expectResult = CommonFunctions.getInstance().getText(txtAmmountAvailability);

			CommonFunctions.getInstance().verifyDataEquals(expectResult, System.getProperty("numerQuantity"));

			List<String> listTab = CommonFunctions.getInstance().getAllTabs();

			for (int i = listTab.size(); i >= 0; i--) {

				if (i == 1) {

					CommonFunctions.getInstance().switchTab(CommonFunctions.getInstance().getAllTabs()
							.get(CommonFunctions.getInstance().getAllTabs().size() - 1));

					break;

				} else {
					CommonFunctions.getInstance().closeTab(CommonFunctions.getInstance().getAllTabs().get(i - 1));
				}
			}

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}
}
