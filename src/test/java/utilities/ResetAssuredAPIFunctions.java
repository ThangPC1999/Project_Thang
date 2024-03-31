package utilities;

import java.io.IOException;

import org.hamcrest.Matchers;
import org.json.JSONException;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class ResetAssuredAPIFunctions {

	private static class SingletonHelper {
		private static final ResetAssuredAPIFunctions INSTANCE = new ResetAssuredAPIFunctions();
	}

	public static ResetAssuredAPIFunctions getInstance() {
		return SingletonHelper.INSTANCE;
	}

	
	public void callGetMethodResponse(String url, String token,String input,int statusCode) throws IOException, JSONException {
		
		RestAssured.given()
				.baseUri(url)
				.contentType(ContentType.JSON)
				.header("Authorization", "Bearer " + token)
				.body(input)
   //When
				.when()
				.get()
  //Then
				.then()
				.assertThat()
				.statusCode(statusCode);
	}
	
	public void callPostMethodResponse(String url, String token,String input,int statusCode) throws IOException, JSONException {
		
			RestAssured.given()
			.baseUri(url)
			.contentType(ContentType.JSON)
			.header("Authorization", "Bearer " + token)
			.body(input)
	//When
			.when()
			.post()
	//Then
			.then()
			.assertThat()
			.statusCode(statusCode);
	}
	
	public void callPostMethodResponse(String url,String input,int statusCode) throws IOException, JSONException {
		
			RestAssured.given()
			.baseUri(url)
			.contentType(ContentType.JSON)
			.body(input)
	//When
			.when()
			.post()
	//Then
			.then()
			.assertThat()
			.statusCode(statusCode);
	}

	public String getBodyPostMethod(String url, String token,String input,int statusCode) throws IOException, JSONException, InterruptedException {
		
		int maxRetries = 3;
		int retryDelayMillis = 1000;
		String requestBody = "";
		
		for (int retry = 0; retry < maxRetries; retry++) {
		    try {
		    	
				requestBody = RestAssured.given()
						.baseUri(url)
						.contentType(ContentType.JSON)
						.header("Authorization", "Bearer " + token)
						.body(input)
		   //When
						.when()
						.post()
		  //Then
						.then()
						.assertThat()
						.statusCode(statusCode)
						.extract()
						.body().asString();
		        break; // If successful, exit the loop
		    
		    } catch (Exception e) {
		        if (retry == maxRetries - 1) {
		            throw e; // Rethrow the exception if max retries reached
		        }
		        Thread.sleep(retryDelayMillis);
		    }
		}

		return requestBody;
	}
	
	public String getBodyPostMethod(String url,String input,int statusCode) throws IOException, JSONException {
		
		String requestBody = RestAssured.given()
				.baseUri(url)
				.contentType(ContentType.JSON)
				.body(input)
   //When
				.when()
				.post()
  //Then
				.then()
				.assertThat()
				.statusCode(statusCode)
				.extract()
				.body().asString();
		
		return requestBody;
	}
	
	public String getBodyGetMethod(String url, String token,String input,int statusCode) throws IOException, JSONException {
		
		String requestBody = RestAssured.given()
				.baseUri(url)
				.contentType(ContentType.JSON)
				.header("Authorization", "Bearer " + token)
				.body(input)
   //When
				.when()
				.get()
  //Then
				.then()
				.assertThat()
				.statusCode(statusCode)
				.body("code",Matchers.is(200))
				.extract()
				.body().asString();
		
		return requestBody;
	}
	
	public String getBodyGetMethod(String url, String token,int statusCode) throws IOException, JSONException {
		
		String requestBody = RestAssured.given()
				.baseUri(url)
				.contentType(ContentType.JSON)
				.header("Authorization", "Bearer " + token)
   //When
				.when()
				.get()
  //Then
				.then()
				.assertThat()
				.statusCode(statusCode)
				.extract()
				.body().asString();
		
		return requestBody;
	}
	
	public String getBodyPutMethod(String url, String token,String input,int statusCode) throws IOException, JSONException {
		
		String requestBody = RestAssured.given()
				.baseUri(url)
				.contentType(ContentType.JSON)
				.header("Authorization", "Bearer " + token)
				.body(input)
   //When
				.when()
				.put()
  //Then
				.then()
//				.assertThat()
//				.statusCode(statusCode)
				.extract()
				.body().asString();
		
		return requestBody;
	}
	
	public void callPutMethodResponse(String url, String token,String input,int statusCode) throws IOException, JSONException {
		
			RestAssured.given()
			.baseUri(url)
			.contentType(ContentType.JSON)
			.header("Authorization", "Bearer " + token)
			.body(input)
	//When
			.when()
			.put()
	//Then
			.then()
			.assertThat()
			.statusCode(statusCode);
	}
			
}
