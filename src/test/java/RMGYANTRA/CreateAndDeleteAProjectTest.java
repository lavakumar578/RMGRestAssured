package RMGYANTRA;

import org.testng.annotations.Test;

import GenericLibrary.BaseAPIClass;
import GenericLibrary.CreateProjectDetails;
import GenericLibrary.EndPoints;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
public class CreateAndDeleteAProjectTest extends BaseAPIClass {
	@Test(priority = 10)
	public void deleteSingleProjectTest() {
CreateProjectDetails createProjectDetails=new CreateProjectDetails("LavaKumar", "RMG-"+javaUtility.random(), "Created", 12);
		
		Response resp = given()
						.body(createProjectDetails)
						.contentType(ContentType.JSON)
						.when()
						.post(EndPoints.CreateProject);
		
		
		//step 2: capture the project id from response
	proId = restAssuredUtility.getJSONData(resp, "projectId");
		System.out.println(proId);
		baseURI="http://localhost";
		port=8084;
		
		when().delete("/projects/"+proId)
		.then().statusCode(204).log().all();
	}
}
