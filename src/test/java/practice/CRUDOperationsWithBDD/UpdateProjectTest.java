package practice.CRUDOperationsWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class UpdateProjectTest {
	
	@Test
	public void updateProject()
	{
		
		//Step 1: Create the pre requisites - request Body
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "Nithesh");
		jObj.put("projectName", "Xylem11234");
		jObj.put("status", "Completed");
		jObj.put("teamSize", 30);
		
		baseURI = "http://localhost";
		port = 8084;
		
		given()
		 .body(jObj)
		 .contentType(ContentType.JSON)

		.when()
		 .put("/projects/TY_PROJ_3205")
		 
		.then()
		 .assertThat()
		 .statusCode(200)
		 .contentType(ContentType.JSON)
		 .log().all();
	}

}
