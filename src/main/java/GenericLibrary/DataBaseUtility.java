package GenericLibrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.protocol.Resultset;

import io.restassured.response.Response;

/**
 * This class contains all specific methods of DataBaseUtility
 * @author LAVA KUMAR
 *
 */
public class DataBaseUtility {
	Driver driver;
	Connection connection;
	Statement statement;

	/**
	 * This method is used to get connection with database
	 * @throws SQLException
	 */
	public void connetToDataBase() throws SQLException {
		driver=new Driver();
		DriverManager.registerDriver(driver);
		connection=DriverManager.getConnection(ConstantUtility.dbURL,ConstantUtility.dbUser,ConstantUtility.dbPassword);
		statement=connection.createStatement();
	}
	/**
	 * This method is to disconnect With DataBase
	 * @throws SQLException
	 */
	public void disconnectWithDataBase() throws SQLException {
		connection.close();
	}
	/**
	 * This method is used to validate for executeQuery And ReturnData
	 * @param query
	 * @param columnIndex
	 * @param expData
	 * @return
	 * @throws SQLException
	 */
	public String executeQueryAndReturnData(String query,int columnIndex,String expData) throws SQLException 
	{
		boolean flag=false;
		ResultSet resultset=statement.executeQuery(query);
		while(resultset.next())
		{
			String actData=resultset.getString(columnIndex);
			if(expData.equalsIgnoreCase(actData))
			{
				flag=true;
				break;
			}
		}
			if(flag==true)
			{
				System.out.println("Data is verified");
				return expData;
			}
			else
			{
				System.out.println("Data is not verified");
				return " ";
			}
		
	}
}

