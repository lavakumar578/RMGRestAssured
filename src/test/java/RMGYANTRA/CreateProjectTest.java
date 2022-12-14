package RMGYANTRA;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import GenericLibrary.BaseAPIClass;
import GenericLibrary.ConstantUtility;
import GenericLibrary.EndPoints;
import GenericLibrary.JavaUtility;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;
public class CreateProjectTest extends BaseAPIClass{
	@Test(priority = 3)
	public void createProjectTest() {
		
	JavaUtility javaUtility=new JavaUtility();
	JSONObject jobj=new JSONObject();
	jobj.put("createdBy", "rmg"+javaUtility.random());
	jobj.put("createdOn", "string");
	jobj.put("projectId", "string");
	jobj.put("projectName","rmgProject"+javaUtility.random());
	jobj.put("status", "created");
	jobj.put("teamSize", "4");
	given().body(jobj).contentType(ContentType.JSON)
	.when().post(EndPoints.CREATEPROJECT)
	.then().assertThat().statusCode(201).time(Matchers.lessThan(2000L), TimeUnit.MILLISECONDS).log().all();
	}
}
