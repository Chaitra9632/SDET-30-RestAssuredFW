package practice.CRUDOperationsWithBDD;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetAllProjects {
	
	@Test
	public void getAllProjects()
	{
		baseURI = "http://localhost";
		port = 8084;
		
		when()
		 .get("/projects")
		.then()
		 .log().all();
	}

}
