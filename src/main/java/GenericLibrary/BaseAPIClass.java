package GenericLibrary;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;

import java.sql.SQLException;

import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
/**
 * This class is baseclass where all API classes will extend from here
 * @author LAVA KUMAR
 *
 */
public class BaseAPIClass {

	public DataBaseUtility dataBaseUtility=new DataBaseUtility();
	public JavaUtility javaUtility=new JavaUtility();
	public RestAssuredUtility restAssuredUtility=new RestAssuredUtility();
	public String proId;
	@BeforeSuite
	public void beforeConfiguration() throws SQLException {
		dataBaseUtility.connetToDataBase();
		Reporter.log("----DB is connected--------",true);
		baseURI = "http://localhost";
		port = 8084;
	}
	
	@AfterSuite
	public void afterConfiguration() throws SQLException {
		dataBaseUtility.connetToDataBase();
		Reporter.log("---------DB is disconnected--------",true);
		
	}
}
