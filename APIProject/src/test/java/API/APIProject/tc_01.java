package API.APIProject;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class tc_01 {

	
	
	@Test(priority =0)
	public void setup() {	 	 	
		Response response = get("https://reqres.in/api/users?page=2");
		
		int status = response.getStatusCode();
		Assert.assertEquals(status,200);
		System.out.println(response.asPrettyString());
		System.out.println(response.contentType());
		String content = response.contentType();
		System.out.println(response.getCookies());
		Assert.assertEquals(content,"application/json; charset=utf-8");
	
		
		
	}
	
	@Test(priority =1)
	public void testc_1() {
		
		baseURI = "https://reqres.in";
	given().get("/api/users?page=2").then().statusCode(200).body("data[2].first_name",equalTo("Tobias")).log().all();
		
		
	}
}
