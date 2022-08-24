package GenericLibrary;

/**
 * This  interface consists of all endpoints
 * @author LAVA KUMAR
 *
 */
public interface EndPoints{
	String AUTHENTION="/login";
	String CREATEPROJECT = "/addProject";
	String GETPROJECTS = "/projects";
	String UPDATEPROJECT= "/projects/";
	String DELETEPROJECT = "/projects/";
	String GETSINGLEPROJECT = "/projects/{pid}";
}
