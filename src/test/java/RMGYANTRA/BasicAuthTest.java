package RMGYANTRA;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
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
		.then().assertThat().statusCode(202).time(Matchers.lessThan(1500L),TimeUnit.MILLISECONDS).log().all();
	}
	
}