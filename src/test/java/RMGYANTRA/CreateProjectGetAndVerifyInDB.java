package RMGYANTRA;

import org.testng.annotations.Test;

import GenericLibrary.BaseAPIClass;
import GenericLibrary.CreateProjectDetails;
import GenericLibrary.EndPoints;
import GenericLibrary.PropertiesUtility;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import java.sql.SQLException;

public class CreateProjectGetAndVerifyInDB extends BaseAPIClass{
	
		@Test(priority = 2)
		public void endToEndScenarioTest() throws SQLException {
			CreateProjectDetails createProjectDetails=new CreateProjectDetails("Lava", "RMG-"+javaUtility.random(), "Created", 12);
			
			Response resp = given()
							.body(createProjectDetails)
							.contentType(ContentType.JSON)
							.when()
							.post(EndPoints.CREATEPROJECT);
			
			
			//step 2: capture the project id from response
		proId = restAssuredUtility.getJSONData(resp, "projectId");
			System.out.println(proId);
			
////			//Step 3: use it in get request
			given()
			  .pathParam("pid", proId)
			.when()
			  .get(EndPoints.GETSINGLEPROJECT)
			.then().log().all();

			
//			Step 4: verify it in database
			String query = PropertiesUtility.getDataFromProperty("query");
			String data = dataBaseUtility.executeQueryAndReturnData(query, 1, proId);
			System.out.println(data);
			
			
			
		}
}
