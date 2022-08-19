package RMGYANTRA;

import java.io.File;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

import GenericLibrary.EndPoints;
import io.restassured.http.ContentType;

public class CreateProjectUsingJSONFileTest {

	@Test(priority = 6)
	public void createProjectUsingJSONFileTest() {
		baseURI="http://localhost";
		port=8084;
		File file=new File(".//src//test//resources//data.json");
		
		given().body(file).contentType(ContentType.JSON)
		.when().post(EndPoints.CreateProject)
		.then().log().all();
	}
}
