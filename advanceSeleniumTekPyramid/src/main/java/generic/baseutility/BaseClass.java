package generic.baseutility;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
	
	@BeforeSuite
	public void confifBS() {
		System.out.println("========================connect to DataBase , Report Config================================");
		
	}
	
	@AfterSuite
	public void confifAS() {
		System.out.println("=========================Close DataBase , Report Backup ===================================");
	}
	
	
	@BeforeClass
	public void configBC() {
		System.out.println("Launch a browser");
	}
	
	@AfterClass
	public void configAC() {
		System.out.println("Close the  browser");
	}
	
	
	@BeforeMethod
	public void configBeforeMethod() {
		System.out.println("Login to application");
	}
	@AfterMethod
	public void configAfterMethod() {
		System.out.println("LogOut from application");
	}
	
	
	
	

}
