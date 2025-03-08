package practice.test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBp {

	public static void main(String[] args) throws SQLException {
		com.mysql.jdbc.Driver driverRef = new com.mysql.jdbc.Driver();
		
		DriverManager.registerDriver(driverRef);
		Connection connn = DriverManager.getConnection("", "", "");
		 Statement stat = connn.createStatement();
		 ResultSet resultset = stat.executeQuery(" ");
		 
		 resultset.next();
		 resultset.get
		 
		
		

	}

}
