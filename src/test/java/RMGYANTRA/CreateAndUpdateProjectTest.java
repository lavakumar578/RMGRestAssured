package RMGYANTRA;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import GenericLibrary.BaseAPIClass;
import GenericLibrary.CreateProjectDetails;
import GenericLibrary.EndPoints;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class CreateAndUpdateProjectTest extends BaseAPIClass{
	@Test(priority = 9)
	public void updateProjectTest() {
		CreateProjectDetails createProjectDetails=new CreateProjectDetails("LavaKumar", "RMG-"+javaUtility.random(), "Created", 12);
		
		Response resp = given()
						.body(createProjectDetails)
						.contentType(ContentType.JSON)
						.when()
						.post(EndPoints.CreateProject);
		
		
		//step 2: capture the project id from response
	proId = restAssuredUtility.getJSONData(resp, "projectId");
		baseURI="http://localhost";
		port=8084;
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "LK");
		jobj.put("projectName", "TexStore");
		jobj.put("status", "On Going");
		jobj.put("teamSize", 5);
		given().body(jobj).contentType(ContentType.JSON).
		when().put("/projects/"+proId).then().assertThat().statusCode(200).time(Matchers.lessThan(1500L),TimeUnit.MILLISECONDS).log().all();
	}
}
