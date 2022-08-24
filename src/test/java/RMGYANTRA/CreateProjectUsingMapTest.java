package RMGYANTRA;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import GenericLibrary.BaseAPIClass;
import GenericLibrary.EndPoints;
import GenericLibrary.JavaUtility;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectUsingMapTest extends BaseAPIClass {
	
	@Test(priority = 8)
	public void createProjectUsingMapTest() {
		baseURI="http://localhost";
		port=8084;
		JavaUtility javaUtility=new JavaUtility();
		HashMap jobj=new HashMap();
		jobj.put("createdBy", "rmg"+javaUtility.random());
		jobj.put("createdOn", "string");
		jobj.put("projectId", "string");
		jobj.put("projectName","Tex Store"+javaUtility.random());
		jobj.put("status", "on going");
		jobj.put("teamSize", "5");
		
		given().body(jobj).contentType(ContentType.JSON)
		.when().post(EndPoints.CREATEPROJECT)
		.then().assertThat().statusCode(201).time(Matchers.lessThan(2000L),TimeUnit.MILLISECONDS).log().all();
	}
	
}
