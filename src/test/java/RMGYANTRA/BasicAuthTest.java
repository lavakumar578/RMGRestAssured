package RMGYANTRA;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

import GenericLibrary.ConstantUtility;

public class BasicAuthTest {

	@Test(priority = 1)
	public void basicAuthTest() {
		baseURI = "http://localhost";
		port = 8084;
		
		given()
		  .auth()
		  .basic("rmgyantra", "rmgy@9999")
		.when()
		  .get("/login")
		.then().log().all();
	}
	
}