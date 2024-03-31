package pageUIs.jqueryScript;

public class DataTablePageUI {
	public static final String DYNAMIC_INPUT_COLUMN = "//div[contains(text(),'%s')]/parent::div/following-sibling::input";
	public static final String DYNAMIC_VERIFY_COLUMN = "//td[text()='%s']/parent::tr";
	public static final String DYNAMIC_PAGE = "//a[text()='%s']";
	public static final String DYNAMIC_PAGE_ACTIVE = "//a[@class='qgrd-pagination-page-link active' and text()='%s']";

}
