package commonLibraries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

/**
 * This class contains generic method related to database
 * @author Chaitra M
 *
 */
public class DatabaseLibrary {
	
	
	//Step 1: register the database
	//Step 2: Get connection with db
	//Step 3: issue create statement
	//Step 4: execute a query
	//Step 5: Close the db connection
	
	Driver driver;
	Connection con;
	
	/**
	 * This method will establish the connection with databse
	 * @throws SQLException
	 */
	public void connectToDB() throws SQLException
	{
		driver = new Driver();
		DriverManager.registerDriver(driver);
		con=DriverManager.getConnection(ContantsLibrary.dbURL, ContantsLibrary.dbUsername, ContantsLibrary.dbPassword);
	}
	
	
	/**
	 * this method will close the databse
	 * @throws Throwable
	 */
	public void closeDB() throws Throwable
	{
		con.close();
	}
	
	
	/**
	 * This method will check the database for exp data and return
	 * the value if the expdata matches actual data
	 * @param query
	 * @param expData
	 * @param column
	 * @return
	 * @throws Throwable
	 */
	public String executeQueryAndGetData(String query, String expData, int column) throws Throwable
	{
		boolean flag=false;
		ResultSet result = con.createStatement().executeQuery(query);
		while(result.next())
		{
			String Data = result.getString(column).toString();
			if(Data.equalsIgnoreCase(expData))
			{
				flag = true;
				break;
			}
		}
		
		if(flag)
		{
			System.out.println(expData +"data verified");
			return expData;
		}
		else
		{
			System.out.println("data not matched");
			return "";
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
