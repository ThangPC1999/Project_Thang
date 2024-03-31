package stepdefinitions;

import java.io.IOException;
import java.util.HashMap;

import org.json.JSONException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import io.cucumber.java.en.Given;
import utilities.CommonFunctions;
import utilities.ResetAssuredAPIFunctions;

public class teststeps {
	
    @FindBy(xpath = "")
    private WebElement elem;
	
	
	@Given("I open page")
	public void i_open_page() throws JSONException, IOException {

		HashMap<String, String> filter = new HashMap<>();
		HashMap<String, String> filter1 = new HashMap<>();


		String input;
		String input1;

		// Call API get Account data

		filter.put("code", "G8DYWQL9");
		filter.put("status", "ACTIVE");

		input = CommonFunctions.getInstance().mapToJson(filter);
		
		filter1.put("username", "thinh.tranphuc@buymed.com");
		filter1.put("password", "Thinh!1910@");
		filter1.put("type", "EMPLOYEE");

		input1 = CommonFunctions.getInstance().mapToJson(filter1);

		String response = ResetAssuredAPIFunctions.getInstance().getBodyPostMethod("https://api.v2-stg.thuocsi.vn/core/account/v1/authentication",input1,200);
		
		JsonObject jsonObject = new JsonParser().parse(response).getAsJsonObject();
		
		JsonArray jsonArray = jsonObject.getAsJsonArray("data");
		JsonElement item = jsonArray.get(0).getAsJsonObject();

		System.setProperty("token", item.getAsJsonObject().get("bearerToken").getAsString());
		
		ResetAssuredAPIFunctions.getInstance().callPutMethodResponse(
				"https://internal.v2-stg.thuocsi.vn/backend/marketplace/customer/v1/account/active",
				System.getProperty("token"),
				input,400);

	}

}
