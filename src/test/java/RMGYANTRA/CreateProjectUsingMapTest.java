package RMGYANTRA;

import java.util.HashMap;

import org.testng.annotations.Test;

import GenericLibrary.EndPoints;
import GenericLibrary.JavaUtility;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectUsingMapTest {
	
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
		.when().post(EndPoints.CreateProject)
		.then().assertThat().statusCode(201).log().all();
	}
	
}
