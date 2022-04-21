package differentWaysToPOST;

import java.util.HashMap;

import org.testng.annotations.Test;

import commonLibraries.JavaLibrary;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectUsingHashMap {
	
	@Test
	public void createProject()
	{
		JavaLibrary jLib = new JavaLibrary();
		baseURI = "http://localhost";
		port = 8084;
		
		//Step 1: create pre requisites 
		HashMap map = new HashMap();
		map.put("createdBy", "Chandan");
		map.put("projectName", "Sony "+jLib.getRandomNumber());
		map.put("status", "Created");
		map.put("teamSize", 4);
		
		given()
		 .body(map)
		 .contentType(ContentType.JSON)
		 
		.when()
		 .post("/addProject")
		 
		.then()
		 .assertThat().statusCode(201)
		 .log().all();
		
		//Step 2: perform action
		
		//Step 3: validation
	}

}
