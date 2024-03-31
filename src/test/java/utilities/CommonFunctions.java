package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Stack;
import java.util.stream.Collectors;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Function;

import base.driver.DriverManager;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.Scenario;

public class CommonFunctions {

	private static class SingletonHelper {
		private static final CommonFunctions INSTANCE = new CommonFunctions();
	}

	public static CommonFunctions getInstance() {
		return SingletonHelper.INSTANCE;
	}

	int waitTimeout = 60;

	// Read properties file
	public void funcReadPropertiesFile(String fileProperties) throws IOException {
		// String strValue = null;
		Properties prop = new Properties();
		FileInputStream input = null;
		fileProperties = new String(fileProperties.getBytes(Charset.forName("utf-8")));

		try {

			input = new FileInputStream(fileProperties);

			// load a properties file
			prop.load(input);

			for (String key : prop.stringPropertyNames()) {
				String val = prop.getProperty(key);

				if (val == null)
					val = "";
				else
					val = val.trim();

				System.setProperty(key, val);

				// System.out.println(key);
				// System.out.println(val);
			}

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		// return prop;
	}

	public String getConfigProperties(String path, String propName) throws IOException {

		InputStream inputStream = new FileInputStream(path);
		Properties prop = new Properties();
		prop.load(inputStream);

		return prop.getProperty(propName);
	}

	public void goToUrl(String url) {
		DriverManager.getInstance().getDriver().get(url);
	}

	public void clickElement(By by) {
		waitForVisibilityOfElement(by, waitTimeout).click();
	}

	public void clearAndSenkeys(By by, String text) {
		waitForVisibilityOfElement(by, waitTimeout).clear();
		waitForVisibilityOfElement(by, waitTimeout).sendKeys(text);
	}

	public List<WebElement> findElementsByVisibility(By by) {
		return waitForVisibilityOfAllElements(by, waitTimeout);
	}

	public boolean checkElementsByVisibility(By by) {
		List<WebElement> lElement = waitForVisibilityOfAllElements(by, 10);

		if (lElement.size() != 0) {
			return true;
		}

		return false;
	}

	public WebElement findElementByVisibility(By by) {
		return waitForVisibilityOfAllElement(by, waitTimeout);
	}

	public List<WebElement> findElementsByVisibility(By by, int timeOut) {
		return waitForVisibilityOfAllElements(by, timeOut);
	}

	public void selectByVisibileText(By by, String text) {
		Select select = new Select(waitForVisibilityOfElement(by, waitTimeout));
		select.selectByVisibleText(text);
	}

	public void selectByVisibileTextElement(WebElement elem, String text) {
		Select select = new Select(elem);
		select.selectByVisibleText(text);
	}

	public WebElement waitForVisibilityOfElement(By by, long timeOut) {
		WebDriverWait wait = new WebDriverWait(DriverManager.getInstance().getDriver(), Duration.ofSeconds(timeOut));

		return wait.ignoring(NoSuchElementException.class).pollingEvery(Duration.ofSeconds(1))
				.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public List<WebElement> waitForVisibilityOfAllElements(By by, int timeOut) {
		WebDriverWait wait = new WebDriverWait(DriverManager.getInstance().getDriver(), Duration.ofSeconds(timeOut));

		try {
			return wait.ignoring(NoSuchElementException.class).pollingEvery(Duration.ofSeconds(1))
					.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
		} catch (Exception e) {
		}
		return new ArrayList<WebElement>();
	}

	public WebElement waitForVisibilityOfAllElement(By by, int timeOut) {
		WebDriverWait wait = new WebDriverWait(DriverManager.getInstance().getDriver(), Duration.ofSeconds(timeOut));

		WebElement elem;

		elem = wait.ignoring(NoSuchElementException.class).pollingEvery(Duration.ofSeconds(1))
				.until(ExpectedConditions.visibilityOfElementLocated(by));

		return elem;
	}

	public void waitForElementToDisappear(By by, int timeOut) {
		WebDriverWait wait = new WebDriverWait(DriverManager.getInstance().getDriver(), Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
	}

	public String getText(By by) {
		WebDriverWait wait = new WebDriverWait(DriverManager.getInstance().getDriver(), Duration.ofSeconds(120));

		return wait.ignoring(NoSuchElementException.class).pollingEvery(Duration.ofSeconds(1))
				.until(ExpectedConditions.visibilityOfElementLocated(by)).getText().trim();
	}

	public String getTextByIndex(By by, int index) {
		return DriverManager.getInstance().getDriver().findElements(by).get(index).getText();
	}

	public String getText(By by, int timeOut) {
		return waitForVisibilityOfElement(by, timeOut).getText().trim();
	}

	public void setClipboardData(String string) {
		StringSelection stringSelection = new StringSelection(string);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
	}

	public void copyPasteByRobot(String text) throws AWTException, InterruptedException {

		StringSelection stringSelection = new StringSelection(text);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, null);

		Robot rb = new Robot();
		// press Contol+V for pasting
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		// release Contol+V for pasting
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		// for pressing and releasing Enter
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
	}

	public void takeScreenshotIntoReport(Scenario scenario) {
		final byte[] screenshot = ((TakesScreenshot) DriverManager.getInstance().getDriver())
				.getScreenshotAs(OutputType.BYTES);

		scenario.attach(screenshot, "image/png", "Fail Img");
	}

	public void sendkeys(By by, String text) {
		DriverManager.getInstance().getDriver().findElement(by).sendKeys(text);
	}

	public void pressKeys(By by, Keys key) {
		DriverManager.getInstance().getDriver().findElement(by).sendKeys(key);
	}

	public void clickByJavascript(WebElement ele) {
		((JavascriptExecutor) DriverManager.getInstance().getDriver()).executeScript("arguments[0].click();", ele);
	}

	public void actionClearAndSendkeys(By by, String text) throws InterruptedException {
		Actions actions = new Actions(DriverManager.getInstance().getDriver());
		
		CommonFunctions.getInstance().clickElement(by);

		actions.doubleClick(CommonFunctions.getInstance().waitForVisibilityOfElement(by, 20)).keyDown(Keys.CONTROL)
				.sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).build().perform();

		Thread.sleep(1000);

		CommonFunctions.getInstance().waitForVisibilityOfElement(by, 20).sendKeys(text);
	}

	public String getPageTitle(String title, int timeOut) {
		WebDriverWait wait = new WebDriverWait(DriverManager.getInstance().getDriver(), Duration.ofSeconds(timeOut));

		try {
			wait.ignoring(NoSuchElementException.class).pollingEvery(Duration.ofSeconds(1))
					.until(ExpectedConditions.titleContains(title));
			return DriverManager.getInstance().getDriver().getTitle();
		} catch (Exception e) {
			return "";
		}
	}

	public String generateRandomAlphaNumeric(int length) {
		return RandomStringUtils.randomAlphanumeric(length);
	}

	public String generateRandomAlpha(int length) {
		return RandomStringUtils.randomAlphabetic(length);
	}

	public String generateRandomNumeric(int length) {

		String randomNumericString;

		do {
			randomNumericString = RandomStringUtils.randomNumeric(length);
		} while (randomNumericString.startsWith("0"));

		return randomNumericString;
	}

	public List<String> getAllTabs() {
		return DriverManager.getInstance().getDriver().getWindowHandles().stream().collect(Collectors.toList());
	}

	public void openNewTab() {
		DriverManager.getInstance().getDriver().switchTo().newWindow(WindowType.TAB);
	}

	public void switchTab(String tab) {
		DriverManager.getInstance().getDriver().switchTo().window(tab);
	}

	public void switchFrame(WebElement element) {
		DriverManager.getInstance().getDriver().switchTo().frame(element);
	}

	public void closeTab(String tab) {
		DriverManager.getInstance().getDriver().switchTo().window(tab).close();
	}

	public String mapToJson(Object obj) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(obj);
	}

	public void waitForPageLoad(int timeout) {
		Wait<WebDriver> wait = new WebDriverWait(DriverManager.getInstance().getDriver(), Duration.ofSeconds(timeout));

		wait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				System.out.println("Current Window State       : "
						+ String.valueOf(((JavascriptExecutor) DriverManager.getInstance().getDriver())
								.executeScript("return document.readyState")));

				return String.valueOf(((JavascriptExecutor) DriverManager.getInstance().getDriver())
						.executeScript("return document.readyState")).equals("complete");
			}
		});
	}

	public void setAttribute(WebElement elem, String value) {
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getInstance().getDriver();
		js.executeScript("arguments[0].setAttribute(arguments[1],arguments[2])", elem, "value", value);
	}

	public void scrollDown() {

		JavascriptExecutor jse = (JavascriptExecutor) DriverManager.getInstance().getDriver();
		jse.executeScript("window.scrollBy(0,300)");
	}

	public void scrollUp() {

		JavascriptExecutor jse = (JavascriptExecutor) DriverManager.getInstance().getDriver();
		jse.executeScript("window.scrollBy(0,-300)");
	}

	public void scrollUpOrDown(int index) {

		JavascriptExecutor jse = (JavascriptExecutor) DriverManager.getInstance().getDriver();
		jse.executeScript("window.scrollBy(0," + index + ")");

	}
//
//	public String readPdfContent(String url) throws IOException {
//		System.setProperty("https.protocols", "TLSv1.2,TLSv1.1,SSLv3");
//		URL pdfUrl = new URL(url);
//		InputStream in = pdfUrl.openStream();
//		BufferedInputStream bf = new BufferedInputStream(in);
//		PDDocument doc = null;
//		System.out.println("The total number of pages");
//		String content = "";
//		try {
//			doc = PDDocument.load(bf);
//			content = new PDFTextStripper().getText(doc);
//			System.out.println(doc);
//
//		} finally {
//			if (doc != null) {
//				doc.close();
//			}
//			bf.close();
//			in.close();
//		}
//		return content;
//	}

	public String numberFormat(int total) throws IOException {

		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		String moneyString = formatter.format(total);

		if (System.getProperty("os.name").contains("Windows")) {

			if (moneyString.endsWith(".00")) {
				int centsIndex = moneyString.lastIndexOf(".00");
				if (centsIndex != -1) {
					moneyString = moneyString.substring(1, centsIndex);
				}
			}

		} else {

			moneyString = moneyString.substring(1, moneyString.length());

			if (moneyString.endsWith(".00")) {
				int centsIndex = moneyString.lastIndexOf(".00");
				if (centsIndex != -1) {
					moneyString = moneyString.substring(1, centsIndex);
				}
			}

		}

		return moneyString;

	}

	public void hoverElement(By by) {

		WebElement elem = DriverManager.getInstance().getDriver().findElement(by);
		Actions action = new Actions(DriverManager.getInstance().getDriver());
		action.moveToElement(elem).build().perform();
	}

	public void actionClickElement(By by) {

		WebElement elem = DriverManager.getInstance().getDriver().findElement(by);
		Actions action = new Actions(DriverManager.getInstance().getDriver());
		action.click(elem).build().perform();
	}

	// Lấy số tuần số ngày chạy
	public String getDayRunning(String totalRunning) {

		String dayRunning = "";

		if ((Integer.valueOf(totalRunning) / 7) == 0) {
			dayRunning = Integer.valueOf(totalRunning) + " ngày";
		} else {
			if ((Integer.valueOf(totalRunning) % 7) == 0) {
				dayRunning = (Integer.valueOf(totalRunning) / 7) + " tuần";
			} else {
				dayRunning = (Integer.valueOf(totalRunning) / 7) + " tuần " + (Integer.valueOf(totalRunning) % 7)
						+ " ngày";
			}

		}

		return dayRunning;
	}

	// Verify Data Equals
	public void verifyDataEquals(String expectResult, String actualResult) {

		if (!expectResult.toLowerCase().equals(actualResult.toLowerCase())) {

			Assert.fail(expectResult + " " + "#" + " " + actualResult);

		}

	}

	// Verify Data Contains
	public void verifyDataContains(String actualResult, String expectResult) {

		if (!actualResult.toLowerCase().contains(expectResult.toLowerCase())) {

			Assert.fail(actualResult + " " + "#" + " " + expectResult);

		}

	}

	// Verify Data Element Display
	public void verifyElemIsDisplay(By by) {

		List<WebElement> lElement = waitForVisibilityOfAllElements(by, 10);

		if (lElement.size() == 0) {

			Assert.fail("Element can't display");
		}

	}

	// Verify Data Different
	public void verifyDataDifferent(String expectResult, String actualResult) {

		if (expectResult.toLowerCase().equals(actualResult.toLowerCase())) {

			Assert.fail(expectResult + " " + "==" + " " + actualResult);

		}

	}

	// Check biến truyền vào
	public String getValueSystemProperty(String textname) {
		// Lấy cái biến truyền vào check trong System

		if (!textname.isEmpty()) {

			if (System.getProperty(textname) != null) {
				// Nếu có thì lấy trong System
				textname = System.getProperty(textname);
			}

		}

		// Không có thì return biến truyền vào
		return textname;

	}

	public void clickJavascript(By by) {

		((JavascriptExecutor) DriverManager.getInstance().getDriver()).executeScript("arguments[0].click();",
				DriverManager.getInstance().getDriver().findElement(by));

	}

	public String getAttribute(By by, String optionAttribute) {
		WebDriverWait wait = new WebDriverWait(DriverManager.getInstance().getDriver(), Duration.ofSeconds(120));

		return wait.ignoring(NoSuchElementException.class).pollingEvery(Duration.ofSeconds(1))
				.until(ExpectedConditions.visibilityOfElementLocated(by)).getAttribute(optionAttribute).trim();
	}

	public void refresh() {
		DriverManager.getInstance().getDriver().navigate().refresh();
	}

	public boolean checkElementsByVisibilityWithTimeInput(By by, int time) {
		List<WebElement> lElement = waitForVisibilityOfAllElements(by, time);

		if (lElement.size() != 0) {
			return true;
		}

		return false;
	}

	// Check biến truyền vào
	public String getXpathByVariable(String txtXpath, String variable) {

		String xpath = null;

		if (!txtXpath.isEmpty() && !variable.isEmpty()) {
			xpath = String.format(txtXpath, variable);
		} else {
			xpath = null;
		}

		return xpath;

	}

	// Check biến truyền vào
	public String getXpathTwoVariable(String txtXpath, String variableFirst, String variableSecond) {

		String xpath = null;

		if (!txtXpath.isEmpty() && !variableFirst.isEmpty() && !variableSecond.isEmpty()) {
			xpath = String.format(txtXpath, variableFirst, variableSecond);
		} else {
			xpath = null;
		}

		return xpath;

	}

	// Check biến truyền vào
	public String getXpathByReplace(String txtXpath, String variable) {

		String xpath = null;

		if (!txtXpath.isEmpty() && !variable.isEmpty()) {
			xpath = txtXpath.replace("Option", variable);
		} else {
			xpath = null;
		}

		return xpath;

	}

	public int countFeature(String path) {

		File directory = new File(path);
		int fileCount = 0;
		Stack<File> s = new Stack<>();
		s.push(directory);
		// initially stack is not empty
		System.out.println("Content of Directory " + directory + " is");
		while (!s.empty()) {
			File tmpF = s.pop();
			// check if it is a file or not
			if (tmpF.isFile()) {
				// print file name can code here according
				// to our need
			} else if (tmpF.isDirectory()) {
				// It's an directory hence list and push all
				// files in stack
				File[] f = tmpF.listFiles();
				for (File fpp : f) {

					if (fpp.getName().endsWith(".feature")) {

						s.push(fpp);

						fileCount++;
					} else {

						s.push(fpp);

					}
				}

			} // else if ends here
		}

		System.out.println("File Count:" + fileCount);

		return fileCount;

	}

	public void scrollToObject(By by, int index) {

		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getInstance().getDriver();

		List<WebElement> lElements = DriverManager.getInstance().getDriver().findElements(by);

		js.executeScript("arguments[0].scrollIntoView(true);", lElements.get(index));
	}

	// Parse Currentcy
	public String parseStringIntoCurrent(String data) {

		BigDecimal amount = new BigDecimal(data);

		DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance();
		symbols.setGroupingSeparator('.');
		DecimalFormat decimalFormat = new DecimalFormat("#,###", symbols);
		String formattedValue = decimalFormat.format(amount) + "đ";

		System.out.println(formattedValue);

		return formattedValue;
	}

	public void waitUntilAndroidElementLocated(AppiumDriver driver, By locator, int timeOutInSec) {
		try {
			WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSec));
			driverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (Exception e) {
			Assert.fail("Unable to locate web element: " + e.getMessage());
		}
	}

	public void waitUntilAndroidElementNotLocated(AppiumDriver driver, By locator, int timeOutInSec) {
		try {
			WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSec));
			driverWait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
		} catch (Exception e) {
			Assert.fail("Unable to locate web element: " + e.getMessage());
		}
	}

	public void uploadImg(WebElement elem, String pathFile) {

		try {

			// Make the input element visible using JavaScriptExecutor
			JavascriptExecutor jsExecutor = (JavascriptExecutor) DriverManager.getInstance().getDriver();
			jsExecutor.executeScript("arguments[0].className = ''; " + "arguments[0].style.display = 'block'; "
					+ "arguments[0].style.position = 'fixed'; " + "arguments[0].style.bottom = '0'; "
					+ "arguments[0].style.left = '0';", elem);

			// Set the file using sendKeys
			elem.sendKeys(pathFile);

		} catch (Exception e) {
			Assert.fail("Unable to locate web element: " + e.getMessage());
		}

	}

    public double roundToNearestPercent(double value) {
    	
        double roundedValue = Math.round(value / 100.0) * 100.0;
       
        return roundedValue;
    }

	public String formatWithCommas(double value) {
		DecimalFormat decimalFormat = new DecimalFormat("#,###");
		return decimalFormat.format(value);
	}

////	DriverManager.getInstance().getDriver()
	public void generateReport(String page,String index) throws IOException, InterruptedException {

		String URL = DriverManager.getInstance().getDriver().getCurrentUrl();

		if (System.getProperty("index") == null) {

			ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "lighthouse", URL, "--port=9222",
					"--preset=desktop","--headless", "--output=json",
					"--output-path=" + System.getProperty("user.dir") + "//target//"+page+"_" +index+ ".json");

			System.setProperty("index", String.valueOf(index));

			builder.redirectErrorStream(true);
			Process p = builder.start();

			BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line;
			while (true) {
				line = r.readLine();
				if (line == null) {
					break;
				}
				System.out.println(line);
			}

			r.close(); //
			p.destroy();

		} else {
			
			ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "lighthouse", URL, "--port=9222",
					"--preset=desktop", "--output=json","--headless", "--output-path=" + System.getProperty("user.dir")
							+ "//target//"+page+"_" +index+ ".json");
			
			System.setProperty("index", String.valueOf(index));

			builder.redirectErrorStream(true);
			Process p = builder.start();

			BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line;
			while (true) {
				line = r.readLine();
				if (line == null) {
					break;
				}
				System.out.println(line);
			}
			
			r.close(); //
			p.destroy();

		}
	}

//		ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "lighthouse", URL, "--port=9222","--preset=desktop", "--output=html", "--output-path="+System.getProperty("user.dir") + "//target//report.html");

}
