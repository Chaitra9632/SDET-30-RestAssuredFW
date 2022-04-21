package parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PathParameter {
	
	@Test
	public void getSingleProject()
	{
		//Pre requisites
		baseURI ="http://localhost";
		port = 8084;
				
		
		given()
	      .pathParam("pid", "TY_PROJ_3215")
	      
		//Actions
	    .when()
	      .get("/projects/{pid}")
		
		//Validations
	     .then()
	      .log().all();
	}

}
