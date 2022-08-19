package RMGYANTRA;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import GenericLibrary.EndPoints;

import static io.restassured.RestAssured.*;

public class GetAllProjectTest {
	@Test(priority = 3)
	public void getProjectTest() {
		baseURI="http://localhost";
		port=8084;
		when().get(EndPoints.GetProjects)
		.then().log().all();
	}
}
