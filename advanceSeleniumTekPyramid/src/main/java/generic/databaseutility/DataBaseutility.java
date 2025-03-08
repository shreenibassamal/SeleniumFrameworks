package generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBaseutility {
	Connection conn = null;
	Statement stat;
	
	
	
	public void getDbconnection() throws Throwable {
		//step 1: load/ register the database driver
		Driver driverRef = new com.mysql.jdbc.Driver();
		DriverManager.registerDriver(driverRef);
		
		//step 2: connect to database
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "Shree@500");
		System.out.println("---------------------------------------------connection done----------------------------------------------------");
		
		
		
	}

	
		public void executeConSelectQuery(String query) throws Throwable {
			
			//step 3: create SQL statement
			Statement stat = conn.createStatement();
			System.out.println("query entered");

			
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
			
			
	}

		

		public void closeDbconnection() throws Throwable {
			
			//step 5: close the connection
			conn.close();
			
		}
				
					
	}

