package commonLibraries;

import io.restassured.RestAssured;
import io.restassured.response.Response;

/**
 * this class consists of generic methods related to restassured
 * @author Chaitra M
 *
 */
public class RestAssuredLibrary {
	
	/**
	 * This method will return the json path
	 * @param resp
	 * @param jsonPath
	 * @return
	 */
	public String getJsonPath(Response resp, String jsonPath)
	{  
		String value = resp.jsonPath().get(jsonPath);
		return value;
      
	}

}
