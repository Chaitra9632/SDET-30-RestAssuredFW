package practice.CRUDOperationsWithoutBDD;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetSingleProjectTest {
	
	@Test
	public void getSingleProject()
	{
		//Step 1: Create Pre requisites
		//Step 2: Perform action
		Response resp = RestAssured.get("http://localhost:8084/projects/TY_PROJ_1604");
		
		//Step 3: Validation
		resp.then().log().all();
		int actStatus = resp.getStatusCode();
		Assert.assertEquals(actStatus, 200);
	}

}
