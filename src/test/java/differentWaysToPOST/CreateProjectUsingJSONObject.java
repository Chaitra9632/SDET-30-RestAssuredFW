package differentWaysToPOST;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import commonLibraries.JavaLibrary;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectUsingJSONObject {
	
	@Test
	public void createProject()
	{
		JavaLibrary jLib = new JavaLibrary();
		
		//Step 1: create pre requisites
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "Prakash");
		jObj.put("projectName", "Allstates "+jLib.getRandomNumber());
		jObj.put("status", "Completed");
		jObj.put("teamSize", 100);
		
		baseURI = "http://localhost";
		port = 8084;
		
		given()
		 .body(jObj)
		 .contentType(ContentType.JSON)
		 
		.when()
		 .post("/addProject")
		 
		.then()
		 .assertThat()
		 .statusCode(201)
		 .log().all();
		
		//Step 2: perform action
		
		//Step 3: Validation
	}

}
