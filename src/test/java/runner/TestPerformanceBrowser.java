package runner;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.CountDownLatch;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestPerformanceBrowser {

	public static void main(String[] args) {
		// Replace the following array with your URLs to test
		String[] urlList = { "https://example.com", "https://www.google.com", "https://github.com",
				// Add more URLs to the array as needed
		};

		List<URLPerformanceResult> results = testConcurrentURLPerformance(urlList, 100);

		// Export the results to a JSON file
		exportJSONReport(results, System.getProperty("user.dir") + "//target//PerformanceReportBrowserWait.json");

		System.out.println("END");

	}

	public static List<URLPerformanceResult> testConcurrentURLPerformance(String[] urls, int numUsers) {
		ExecutorService executorService = Executors.newFixedThreadPool(numUsers);
		List<URLPerformanceResult> results = new ArrayList<>();
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("useAutomationExtension", false);
		options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
		// options.setBinary("C:\\Users\\11E00003\\Downloads\\GoogleChromePortable64\\App\\Chrome-bin\\chrome.exe");
		// options.addArguments("chrome.switches", "--disable-extensions");
		options.addArguments("--start-maximized");
		options.addArguments("--disable-web-security");
		options.addArguments("--no-proxy-server");
		options.addArguments("test-type");
		options.addArguments("disable-popup-blocking");
		options.addArguments("--use-fake-ui-for-media-stream");
		options.addArguments("--disable-notifications");
		options.addArguments("--remote-debugging-port=9222");

		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
//        options.addArguments("auto-open-devtools-for-tabs");

		options.setExperimentalOption("prefs", prefs);

		// options.addArguments("--disable-gpu");

		DesiredCapabilities caps = new DesiredCapabilities();
		LoggingPreferences logPrefs = new LoggingPreferences();
		logPrefs.enable(LogType.BROWSER, Level.ALL);
		caps.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
		options.addArguments("--remote-allow-origins=*");
		caps.setCapability(ChromeOptions.CAPABILITY, options);
		caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

		options.setCapability(ChromeOptions.CAPABILITY, caps);

		// WebDriver driver = new ChromeDriver(options);
		WebDriver driver = new ChromeDriver(options);

		// Use CountDownLatch to synchronize the threads
		CountDownLatch latch = new CountDownLatch(numUsers);

		for (int i = 0; i < numUsers; i++) {
			executorService.execute(() -> {
				// Wait for all threads to be ready
				try {
					latch.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				HttpClient httpClient = HttpClients.createDefault();

				for (String url : urls) {
					long startTime = System.currentTimeMillis();
					HttpGet httpGet = new HttpGet(url);

					try {
						// Use Selenium WebDriver to open the URL in the browser
						driver.get(url);

						// Wait for the page to be fully loaded
						WebDriverWait wait = new WebDriverWait(driver, 30); // Maximum wait time of 30 seconds
						wait.until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd)
								.executeScript("return document.readyState").equals("complete"));

						HttpResponse response = httpClient.execute(httpGet);
						int statusCode = response.getStatusLine().getStatusCode();
						long responseTime = System.currentTimeMillis() - startTime;
						double responseTimeInSeconds = responseTime / 1000.0; // Convert to seconds
						String responseBody = getResponseBody(response);

						URLPerformanceResult result = new URLPerformanceResult(url, statusCode, responseTimeInSeconds,
								responseBody);
						results.add(result);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			});
			// Decrease the latch count to signal that a thread is ready
			latch.countDown();
		}

		executorService.shutdown();
		while (!executorService.isTerminated()) {
			// Wait for all threads to finish
		}

		driver.quit(); // Close the browser after the tests are completed

		return results;
	}

	public static String getResponseBody(HttpResponse response) throws IOException {
		HttpEntity entity = response.getEntity();
		if (entity != null) {
			return EntityUtils.toString(entity);
		}
		return "";
	}

	public static void exportJSONReport(List<URLPerformanceResult> results, String filename) {
		try (FileWriter writer = new FileWriter(filename)) {
			com.google.gson.Gson gson = new com.google.gson.Gson();
			gson.toJson(results, writer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Data structure to hold URL performance results
	public static class URLPerformanceResult {
		private String url;
		private int statusCode;
		private double responseTime;
		private String responseBody;

		public URLPerformanceResult(String url, int statusCode, double responseTime, String responseBody) {
			this.url = url;
			this.statusCode = statusCode;
			this.responseTime = responseTime;
			this.responseBody = responseBody;
		}

		public String getUrl() {
			return url;
		}

		public int getStatusCode() {
			return statusCode;
		}

		public double getResponseTime() {
			return responseTime;
		}

		public String getResponseBody() {
			return responseBody;
		}
	}

}