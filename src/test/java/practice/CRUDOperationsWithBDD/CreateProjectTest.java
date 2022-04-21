package practice.CRUDOperationsWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import commonLibraries.JavaLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;

public class CreateProjectTest {
	
	@Test
	public void createProject()
	{
		JavaLibrary jLib = new JavaLibrary();
		
		//Step 1: craete pre requisite
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "Nithesh");
		jObj.put("projectName", "Xylem "+jLib.getRandomNumber());
		jObj.put("status", "Completed");
		jObj.put("teamSize", 12);
		
		baseURI ="http://localhost";
		port = 8084;
		
		given()
		 .body(jObj)
		 .contentType(ContentType.JSON)
		
		.when()  //Step 2: perform action
		 .post("/addProject")
		 
		.then()  //Step 3: Validation
		 .assertThat()
		 .statusCode(201)
		 .contentType(ContentType.JSON)
		 .log().all();
		
	
		
		
	}

}
