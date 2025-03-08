package generic.baseutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import generic.databaseutility.DataBaseutility;
import generic.fileutility.ExcelUtility;
import generic.fileutility.FileUtility;
import generic.webdriverutility.JavaUtility;
import listenerUtility.ListenerImpClass;
import objectrepositoryutility.HomePage;
import objectrepositoryutility.LoginPage;

public class BaseClassIListener extends ListenerImpClass {
	//create object for Listener
	public DataBaseutility  dbLib = new DataBaseutility();
	public FileUtility fLib = new FileUtility();
	public ExcelUtility eLib= new ExcelUtility();
	public JavaUtility jLib = new JavaUtility();
	public  WebDriver driver = null;
	public  static WebDriver sdriver = null;
	
	@BeforeSuite
	public void confifBS() throws Throwable {
		System.out.println("========================connect to DataBase , Report Config================================");
		dbLib.getDbconnection();
	}
	
	@AfterSuite
	public void confifAS() throws Throwable {
		System.out.println("=========================Close DataBase , Report Backup ===================================");
		dbLib.closeDbconnection();
	}
	
	@BeforeClass
	public void configBC() throws Throwable {
		System.out.println("Launch a browser");
		String BROWSER = fLib.getDataFromPropertiesFile("browser");
		
		if(BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		}
else if(BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		}
else if(BROWSER.equals("edge")) {
	driver = new EdgeDriver();
		}
else if(BROWSER.equals("safari")) {
	driver = new SafariDriver();
}
else {
	System.out.println("fix your browser instance");
}
		sdriver = driver; //

		
		
	}
	
	@AfterClass
	public void configAC() {
		System.out.println("Close the  browser");
		driver.close();
		driver.quit();
	}
	
	@BeforeMethod
	public void configBeforeMethod() throws Throwable {
		System.out.println("Login to application");
		String URL = fLib.getDataFromPropertiesFile("url");
		String USERNAME = fLib.getDataFromPropertiesFile("username");
		String PASSWORD = fLib.getDataFromPropertiesFile("password");
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(URL, USERNAME, PASSWORD);
	}
	
	@AfterMethod
	public void configAfterMethod() {
		System.out.println("LogOut from application");
		HomePage hp = new HomePage(driver);
		hp.logout();
	}
	
	
	
	
	
	
	
	
	
	

}
