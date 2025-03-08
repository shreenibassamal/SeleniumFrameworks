package DDTwithMySQLDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * test class for Contact module
 * @author Shreenibas samal/n
 * contains login page and doing sample test
 * 
 */

public class SampleTest {
	public static void main(String[] args) throws Throwable {
		//STEPS TO ACHEIVE THE CONNECTION AND FETCH THE DATA IN JAVA PROGRAM
		
		//step 1: load/ register the database driver
		//step 2: connect to database
		//step 3: create SQL statement
		//step 4: execute select query & get result
		//step 5: close the connection
		
		

		//step 1: load/ register the database driver
		com.mysql.jdbc.Driver driverRef = new com.mysql.jdbc.Driver();
		DriverManager.registerDriver(driverRef);
		
		//step 2: connect to database
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "Shree@500");  //Syntax-->"jdbc:mysql://localhost:3306/projects"
		System.out.println("+++++++++++++++++++++++++connection done++++++++++++++++++++");
		
		//step 3: create SQL statement
		Statement stat = conn.createStatement();
		
		//step 4: execute select query & get result
		ResultSet resultset = stat.executeQuery("SELECT * FROM commontData LIMIT 1;");
		resultset.next();
		
		String browser = resultset.getString(1);
		String url = resultset.getString(2);
		String username = resultset.getString(3);
		String password = resultset.getString(4);
		
		System.out.println(browser);
		System.out.println(url);
		System.out.println(username);
		System.out.println(password);
		
		//step 5: close the connection
		conn.close();
	}

}
