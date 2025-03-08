package DDTwithMySQLDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleUnitTestCheckProjectInBackEndwithTestNG {
	
	@Test
	public void projectCheckTest()throws SQLException  {
		Connection conn=null;
		
		try {
		     String exceptedProjectName = "apple751";
		     
		     boolean flag = false;
		
		      //step 1: load/ register the database driver
				com.mysql.jdbc.Driver driverRef = new com.mysql.jdbc.Driver();
				DriverManager.registerDriver(driverRef);
				
				//step 2: connect to database
				 conn = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/ninza_hrm", "root", "root");
				System.out.println("+++++++++++++++++++++++++connection done++++++++++++++++++++");
				
				//step 3: create SQL statement
				Statement stat = conn.createStatement();
				
				//step 4: execute select query & get result
				ResultSet resultset = stat.executeQuery("select * from project;");
				
				while(resultset.next()) {
					String Projectname = resultset.getString(4);
					if(exceptedProjectName.equals(Projectname)) {
						flag=true;
						System.out.println(exceptedProjectName +": is availble===PASS");
					}
					
				}
				if(flag==false) {
					System.out.println(exceptedProjectName +": is not availble===FAIL");
					Assert.fail();
				}
				
		}catch(Exception e) {
			System.out.println("handle exception");
		}
		
			finally {	
				//step 5: close the connection
				conn.close();
				System.out.println("====================connection closed=========================");
			}
			}
	}
