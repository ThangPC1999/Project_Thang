package actions;

import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import base.driver.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import utilities.CommonFunctions;
import utilities.ExcelUtils;

public class CommonActions {

	int timeOut = Integer.parseInt(System.getProperty("objectTimeout"));

	public static WebDriver driver;

	public static WebDriver getDriver() {
		if (driver == null) {
			driver = DriverManager.getInstance().getDriver();
		}
		return driver;
	}

	private static class SingletonHelper {
		private static final CommonActions INSTANCE = new CommonActions();
	}

	public static CommonActions getInstance() {
		return SingletonHelper.INSTANCE;
	}

	public void openThuocSiPage() {

		try {

			CommonFunctions.getInstance().goToUrl(System.getProperty("thuocsiUrl"));
//			CommonFunctions.getInstance().goToUrl("https://thuocsi.vn/products?q=v-rohto&searchType=1");

			CommonFunctions.getInstance().waitForPageLoad(timeOut);

//			CommonFunctions.getInstance().generateReport();

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	@Given("I open Seller page")
	public void i_open_seller_page() {
		try {

			CommonFunctions.getInstance().goToUrl(System.getProperty("sellerUrl"));

			CommonFunctions.getInstance().waitForPageLoad(timeOut);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void openNewTab() {

		try {

			CommonFunctions.getInstance().openNewTab();

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void openInternalPage() {

		try {
			CommonFunctions.getInstance().goToUrl(System.getProperty("internalUrl"));
			CommonFunctions.getInstance().waitForPageLoad(timeOut);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void openSupplierPage() {

		try {
			CommonFunctions.getInstance().goToUrl(System.getProperty("supplierUrl"));
			CommonFunctions.getInstance().waitForPageLoad(timeOut);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	@When("I switch to old tab")
	public void i_switch_to_old_tab() {
		try {

			DriverManager.getInstance().getDriver().close();

			CommonFunctions.getInstance().switchTab(CommonFunctions.getInstance().getAllTabs().get(0));

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	@When("I closed current tab and switch old tab")
	public void i_closed_current_tab_and_switch_old_tab() {
		try {

			DriverManager.getInstance().getDriver().close();

			CommonFunctions.getInstance().switchTab(CommonFunctions.getInstance().getAllTabs()
					.get(CommonFunctions.getInstance().getAllTabs().size() - 1));

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@When("I open internal wms app page")
	public void i_open_internal_wms_app_page() {
		try {

			CommonFunctions.getInstance().goToUrl(System.getProperty("internalAppLoginUrl"));

			CommonFunctions.getInstance().waitForPageLoad(timeOut);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@When("I redirect to manage account on the Internal WMS App page")
	public void i_redirect_to_manage_account_on_the_internal_wms_app_page() {
		try {

			CommonFunctions.getInstance().refresh();

			CommonFunctions.getInstance().waitForPageLoad(timeOut);

			CommonFunctions.getInstance().goToUrl(System.getProperty("internalAppManage"));

			CommonFunctions.getInstance().waitForPageLoad(timeOut);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@When("I open internal login page")
	public void i_open_internal_login_page() {
		try {

			CommonFunctions.getInstance().goToUrl(System.getProperty("internalLoginUrl"));

			CommonFunctions.getInstance().waitForPageLoad(timeOut);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@When("I redirect url to detail ticket")
	public void i_redirect_url_to_detail_ticket() {
		try {

			CommonFunctions.getInstance().goToUrl(System.getProperty("currentUrl"));

			CommonFunctions.getInstance().waitForPageLoad(timeOut);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@When("I clear property order")
	public void i_clear_property_order() {
		System.clearProperty("totalPriceExpect");

		System.clearProperty("ammountOrder");
		System.clearProperty("totalAmmountOder");
		System.clearProperty("dProductName");

	}

	@When("I open {string} page")
	public void i_open_page(String sheet) {
		try {

			String excelFilePath;

			if (System.getProperty("os.name").contains("Windows")) {
				excelFilePath = System.getProperty("user.dir") + "\\src\\test\\resources\\data\\"
						+ "Performance test for FE.xlsx";
			} else {
				excelFilePath = System.getProperty("user.dir") + "//src//test//resources//data//"
						+ "Performance test for FE.xlsx";
			}

			// Đọc file excel sheet đầu tiên
			Workbook workbook = ExcelUtils.getInstance().getWorkbookByName(excelFilePath, sheet);

			int lastRow = ExcelUtils.getInstance().getRowNum();
			System.out.println("---------------------------------");

			Map<String, String> dataset = new HashMap<String, String>();

			// Lặp qua từng row trong file excel
			for (int i = 3; i <= lastRow; i++) {

				// Lấy dữ liệu key (row thứ 2 trong file excel) và value (row chạy theo i) bỏ vô
				// object
				dataset = ExcelUtils.getInstance().getDataSetByRowIndex(2, i, 3);

				String url = dataset.get("URL ");
				String index = dataset.get("STT");
				String page = dataset.get("Page");

				Thread.sleep(5000);

				CommonFunctions.getInstance().goToUrl(url);

				CommonFunctions.getInstance().waitForPageLoad(timeOut);

				Thread.sleep(5000);

				CommonFunctions.getInstance().generateReport(page, index);

				Thread.sleep(5000);

			}

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

}
