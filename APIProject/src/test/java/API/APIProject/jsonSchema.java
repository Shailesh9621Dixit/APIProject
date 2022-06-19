package API.APIProject;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyData;
import io.restassured.response.ValidatableResponse;
import net.minidev.json.JSONObject;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class jsonSchema {

	@Test
	public void schemaTest() {
		baseURI = "https://reqres.in/";
		basePath = "api/users?page=2";
		
		given().get().then().assertThat().body(matchesJsonSchemaInClasspath("..\\APIECILIPSE\\APIProject\\jsonSchema\\schema.json")).statusCode(200);
		
		
		
	}
	
	
}
