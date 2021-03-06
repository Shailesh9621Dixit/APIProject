package API.APIProject;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import static io.restassured.RestAssured.*;

import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyData;
import io.restassured.response.ValidatableResponse;
import net.minidev.json.JSONObject;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class post_tc_02 {

	    private static final ObjectMapper MAPPER = new ObjectMapper();

	@Test(priority = 1)
	public static void getpatDemo() {
		baseURI = "http://localhost:3000";
		basePath = "/patDemo";
		given().body("").when().get().then().statusCode(200).log().all().body("patDetails[1].patID",equalTo("100457")).
		       body("patDetails.firstName",hasItems("Ram","Shashwat","Shanu"));
	
	}

@Test()
public static void createPost() {
	
	
	baseURI = "https://reqres.in/";
	basePath = "api/users";
	JSONObject reqBody = new JSONObject();
	reqBody.put("firstName", "Seeta");
	reqBody.put("lastName","Narayan");
	reqBody.put("age", 27);
	reqBody.put("patID",150979);
	
	Response response =  given().body(reqBody.toJSONString()).when().post();
	System.out.println(response.getBody().asPrettyString());
	 Headers header =  response.getHeaders();
	 System.out.println(header);
	String cf =  response.header("CF-Cache-Status");
	Assert.assertEquals(cf, "DYNAMIC");
	Assert.assertEquals(response.statusCode(), 201, "HTTP Message");

}
}













