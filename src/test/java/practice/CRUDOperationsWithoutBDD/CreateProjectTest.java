package practice.CRUDOperationsWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateProjectTest {
	
	@Test
    public void createProjectTest()
    {
		//Step 1: Create the pre requisites - request Body
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "Chaitra");
		jObj.put("projectName", "Xylem1");
		jObj.put("status", "Completed");
		jObj.put("teamSize", 12);
		
		RequestSpecification req = RestAssured.given();
		req.body(jObj);
		req.contentType(ContentType.JSON);
		
		//Step 2: Perform the Action
		
		Response response = req.post("http://localhost:8084/addProject");
		
		//Step 3: Validate the response
		System.out.println(response.getContentType());
		System.out.println(response.asString());
		System.out.println(response.prettyPrint());
		System.out.println(response.prettyPeek());
    }

}
