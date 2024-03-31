package common.utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DateUtils {

	public DateUtils() {
		super();
	}

	// strFormatFrom = "yyyy-MM-dd"
	// strFormatTo = "dd/MM/yyyy"
	public String funcConvertDate(String strDate, String strFormatFrom, String strFormatTo) {
		try {
			DateFormat formatters = new SimpleDateFormat(strFormatTo);

			if (strDate.length() > 0) {
				Date date1 = new SimpleDateFormat(strFormatFrom).parse(strDate);
				strDate = formatters.format(date1);
			}
		} catch (Exception ex) {
			Assert.fail(ex.getMessage());
		}

		return strDate;
	}

	// strFormatFrom = "hh:mm:ss"
	// strFormatTo = "hh:mm a"
	// strFormatTo = "hh:mma"
	public String funcConvertTime(String strTime, String strFormatFrom, String strFormatTo) {
		try {
			DateFormat formatters = new SimpleDateFormat(strFormatTo);

			if (strTime.length() > 0) {
				Date date1 = new SimpleDateFormat(strFormatFrom).parse(strTime);
				strTime = formatters.format(date1);
			}
		} catch (Exception ex) {
			Assert.fail(ex.getMessage());
		}

		return strTime;
	}

	// Format date dd/MM/yyyy
	public String funcFormatDate(WebDriver driver, String strObject, String strFormat) {
		String strDate = "";

		try {

			strDate = driver.findElement(By.xpath(System.getProperty(strObject))).getAttribute("value");

			Date date1 = null;

			DateFormat formatters = new SimpleDateFormat("yyyy-MM-dd");

			if (strDate.length() > 0) {
				date1 = new SimpleDateFormat(strFormat).parse(strDate);
				strDate = formatters.format(date1);
			}

		} catch (Exception ex) {
			Assert.fail(ex.getMessage());
		}

		return strDate;
	}

	public boolean isValidDate(String input) {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

		try {
			format.parse(input);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
}
