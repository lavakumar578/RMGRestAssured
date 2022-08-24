package RMGYANTRA;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.*;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import GenericLibrary.BaseAPIClass;
import GenericLibrary.EndPoints;
import io.restassured.http.ContentType;

public class CreateProjectUsingJSONFileTest extends BaseAPIClass {

	@Test(priority = 6)
	public void createProjectUsingJSONFileTest() {
		
		File file=new File(".//src//test//resources//data.json");
		given().body(file).contentType(ContentType.JSON)
		.when().post(EndPoints.CREATEPROJECT)
		.then().assertThat().statusCode(201).time(Matchers.lessThan(2000L),TimeUnit.MILLISECONDS).log().all();
	}
}
