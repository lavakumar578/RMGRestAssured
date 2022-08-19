package GenericLibrary;

/**
 * This  interface consists of all endpoints
 * @author LAVA KUMAR
 *
 */
public interface EndPoints{
	String CreateProject = "/addProject";
	String GetProjects = "/projects";
	String UpdateProject = "/projects/";
	String DeleteProject = "/projects/";
	String GetSingleProject = "/projects/{pid}";
}
