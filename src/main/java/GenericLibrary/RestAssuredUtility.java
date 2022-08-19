package GenericLibrary;

import io.restassured.response.Response;
/**
 * This class contains specific methods for RestAssuredUtility
 * @author LAVA KUMAR
 *
 */
public class RestAssuredUtility {
	/**
	 * This method is used to accept jsonPath and return json data
	 * @param resp
	 * @param path
	 * @return
	 */
	public String getJSONData(Response resp,String path)
	{
		String jsonData=resp.jsonPath().get(path);
		return jsonData;
	}
	
}
