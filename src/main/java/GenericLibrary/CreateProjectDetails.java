package GenericLibrary;
/**
 * This class is specific to declare create project Details
 * @author LAVA KUMAR
 *
 */
public class CreateProjectDetails {

	public String createdBy;
	public String projectName;
	public String status;
	public int teamSize;
	public CreateProjectDetails(String createdBy,String projectName,String status,int teamSize) {
		this.createdBy=createdBy;
		this.projectName=projectName;
		this.status=status;
		this.teamSize=teamSize;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy)
	{
		this.createdBy=createdBy;
	}
	public String getprojectName() {
		return projectName;
	}
	public void setprojectName(String projectName)
	{
		this.projectName=projectName;
	}		
	public String getstatus() {
		return status;
	}
	public void setstatus(String status)
	{
		this.status=status;
	}		
	public int getteamSize() {
		return teamSize;
	}
	public void setteamSize(int teamSize)
	{
		this.teamSize=teamSize;
	}		
	}
