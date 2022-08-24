package RMGYANTRA;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import GenericLibrary.BaseAPIClass;
import GenericLibrary.ConstantUtility;
import GenericLibrary.EndPoints;
import GenericLibrary.PropertiesUtility;

public class BasicAuthTest extends BaseAPIClass{

	@Test(priority = 1)
	public void basicAuthTest() {
		
		given()
		  .auth()
		  .basic(PropertiesUtility.getDataFromProperty("username"), PropertiesUtility.getDataFromProperty("password"))
		.when()
		  .get(EndPoints.AUTHENTION)
		.then().assertThat().statusCode(202).time(Matchers.lessThan(2000L),TimeUnit.MILLISECONDS).log().all();
	}
	
}