package RMGYANTRA;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import GenericLibrary.EndPoints;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class GetAllProjectTest {
	@Test(priority = 3)
	public void getProjectTest() {
		baseURI="http://localhost";
		port=8084;
		when().get(EndPoints.GetProjects)
		.then().assertThat().statusCode(200).time(Matchers.lessThan(2000L),TimeUnit.MILLISECONDS).log().all();
	}
}
