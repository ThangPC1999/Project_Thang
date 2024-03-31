package runner;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;

public class TestPerformance {

	 public static void main(String[] args) {
	        // Replace the following array with your URLs to test
	        String[] urlList = {
	                "https://example.com",
	                "https://www.google.com",
	                "https://github.com",
	                // Add more URLs to the array as needed
	        };

	        List<URLPerformanceResult> results = testConcurrentURLPerformance(urlList, 100);

	        // Export the results to a JSON file
	        
	      
	        exportJSONReport(results, System.getProperty("user.dir") + "//target//PerformanceReportHide.json");
	        
	        System.out.println("END");
	    }

	    public static List<URLPerformanceResult> testConcurrentURLPerformance(String[] urls, int numUsers) {
	        ExecutorService executorService = Executors.newFixedThreadPool(numUsers);
	        List<URLPerformanceResult> results = new ArrayList<>();

	        for (int i = 0; i < numUsers; i++) {
	            executorService.execute(() -> {
	                HttpClient httpClient = HttpClients.createDefault();

	                for (String url : urls) {
	                    long startTime = System.currentTimeMillis();
	                    HttpGet httpGet = new HttpGet(url);

	                    try {
	                        HttpResponse response = httpClient.execute(httpGet);
	                        int statusCode = response.getStatusLine().getStatusCode();
	                        long responseTime = System.currentTimeMillis() - startTime;
	                        double responseTimeInSeconds = responseTime / 1000.0; // Convert to seconds
	                        String responseBody = getResponseBody(response);

	                        URLPerformanceResult result = new URLPerformanceResult(url, statusCode, responseTimeInSeconds, responseBody);
	                        results.add(result);
	                    } catch (IOException e) {
	                        e.printStackTrace();
	                    }
	                }
	            });
	        }

	        executorService.shutdown();
	        while (!executorService.isTerminated()) {
	            // Wait for all threads to finish
	        }

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
	            Gson gson = new Gson();
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
	    }

}
