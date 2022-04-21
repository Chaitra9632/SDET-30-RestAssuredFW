package responseValidation;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class ResponseTimeValidation {
	
	@Test
	public void responseTimeValidation()
	{
		//prerequisite
		baseURI = "http://localhost";
		port = 8084;
		
		//Action
		Response resp = when()
		 .get("/projects");
		 
		//validation
		resp.then()
		  .assertThat().time(Matchers.lessThan(800L),TimeUnit.MILLISECONDS)
		  .log().all();
		long ti = resp.time();
		System.out.println(ti);
		
		
		 
	}

}
