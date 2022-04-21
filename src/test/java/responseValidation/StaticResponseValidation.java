package responseValidation;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import commonLibraries.JavaLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import projectLibrary.ProjectLibrary;

import static io.restassured.RestAssured.*;

public class StaticResponseValidation {
	
	@Test
	public void staticResponse()
	{
		JavaLibrary jLib = new JavaLibrary();
		baseURI = "http://localhost";
		port = 8084;
		
		//Step 1: create pre requisites
		ProjectLibrary pLib = new ProjectLibrary("Sudhakar", "Amdocs "+jLib.getRandomNumber(), "Created", 30);
		
		 Response resp = given()
		 .body(pLib)
		 .contentType(ContentType.JSON)
		
		//Step 2: perform action
		.when()
		 .post("/addProject");
		
		//Step 3: validation
		String actData = resp.jsonPath().get("projectName");
		Assert.assertTrue(actData.contains("Amdocs"));
		 
		resp.then()
		 .assertThat().statusCode(201)
		 .log().all();
	}
	
	

}
