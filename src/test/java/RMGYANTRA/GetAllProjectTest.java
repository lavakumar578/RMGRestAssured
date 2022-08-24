package RMGYANTRA;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import GenericLibrary.BaseAPIClass;
import GenericLibrary.EndPoints;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class GetAllProjectTest extends BaseAPIClass {
	@Test(priority = 4)
	public void getProjectTest() {
	
		when().get(EndPoints.GETPROJECTS)
		.then().assertThat().statusCode(200).time(Matchers.lessThan(2000L),TimeUnit.MILLISECONDS).log().all();
	}
}
