package RMGYANTRA;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import GenericLibrary.EndPoints;
import GenericLibrary.JavaUtility;
import io.restassured.http.ContentType;

public class CreateProjectUsingJSONObjectTest {

	@Test(priority = 7)
	public void createProjectUsingJSONObjectTest() {
		baseURI="http://localhost";
		port=8084;
		JavaUtility javaUtility=new JavaUtility();
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "rmg"+javaUtility.random());
		jobj.put("createdOn", "string");
		jobj.put("projectId", "string");
		jobj.put("projectName","rmgProject"+javaUtility.random());
		jobj.put("status", "created");
		jobj.put("teamSize", "4");
    				 
    			given().body(jobj).contentType(ContentType.JSON)
    			.when().post(EndPoints.CreateProject)
    			.then().assertThat().statusCode(201).log().all();
	}
}
