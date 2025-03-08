package miscaThing;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBU2 {
	Connection conn;
	Statement stat;
	ResultSet resultset;
	
		//STEPS TO ACHEIVE THE CONNECTION AND FETCH THE DATA IN JAVA PROGRAM
		
		//step 1: load/ register the database driver
		//step 2: connect to database
		//step 3: create SQL statement
		//step 4: execute select query & get result
		//step 5: close the connection
		
		

		
		public void getDbconnection() throws Throwable {
			try {
			//step 1: load/ register the database driver
				com.mysql.jdbc.Driver driverRef = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(driverRef);
			
			//step 2: connect to database
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "Shree@500");
			}catch(Exception e) {}
			System.out.println("+++++++++++++++++++++++++connection done++++++++++++++++++++");
			
		}
		
		
		
		
		
		public ResultSet executeConSelectQuery(String query) throws Throwable {
			
			try {
				//step 1: load/ register the database driver
				com.mysql.jdbc.Driver driverRef = new com.mysql.jdbc.Driver();
			   DriverManager.registerDriver(driverRef);
			

			//step 2: connect to database
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "Shree@500");
			}catch(Exception e) {}
			System.out.println("+++++++++++++++++++++++++connection done++++++++++++++++++++");
			System.out.println("entered the query");
				//step 3: create SQL statement
				Statement stat = conn.prepareStatement("SELECT * FROM commontData LIMIT 1;");
			//step 4: execute select query & get result
			ResultSet resultset = stat.executeQuery(query);
			System.out.println("passer the query");
			boolean r = resultset.next();
			System.out.println(r);
			
			System.out.println("value fetched");
			String browser = resultset.getString(1);
			String url = resultset.getString(2);
			String username = resultset.getString(3);
			String password = resultset.getString(4);
			
			System.out.println(browser);
			System.out.println(url);
			System.out.println(username);
			System.out.println(password);
			
			return resultset;
			
		}
		
		
		
		
		public void closeDbconnection() throws Throwable {
			try {
			//step 5: close the connection
			conn.close();
			
			System.out.println("++++++++++++++++++++++++++++++++++++++close the connection++++++++++++++++++++++++++++++");
			}catch(Exception e) {}
		}

}
