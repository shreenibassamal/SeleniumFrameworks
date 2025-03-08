package miscaThing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBU3 {
	Connection conn;
	Statement stat;
	
	
	
	public void getDbconnection() throws Throwable {
		//step 1: load/ register the database driver
		com.mysql.jdbc.Driver driverRef = new com.mysql.jdbc.Driver();
		DriverManager.registerDriver(driverRef);
		
		//step 2: connect to database
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "Shree@500");
		System.out.println("---------------------------------------------connection done----------------------------------------------------");
		
		//step 3: create SQL statement
		Statement stat = conn.createStatement();
		
	}

	
		public void executeConSelectQuery(String query) throws Throwable {
//			//step 1: load/ register the database driver
//			com.mysql.jdbc.Driver driverRef = new com.mysql.jdbc.Driver();
//			DriverManager.registerDriver(driverRef);
//			
//			//step 2: connect to database
//			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "Shree@500");
//			System.out.println("---------------------------------------------connection done----------------------------------------------------");
			
//			//step 3: create SQL statement
			
			Statement stat = conn.createStatement();
			
			
			//step 4: execute select query & get result
			ResultSet resultset = stat.executeQuery(query);
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

		

		public void closeDbconnection() throws Throwable {
			
			//step 5: close the connection
			conn.close();
			
		}

}
