package DDTwithMySQLDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class LogInVtigerAppWithMySQL {
	public static void main(String[] args) throws Throwable {
		//get commont data from MySQL database from a local server.
		
		

		//step 1: load/ register the database driver
		com.mysql.jdbc.Driver driverRef = new com.mysql.jdbc.Driver();
		DriverManager.registerDriver(driverRef);  
		
		//step 2: connect to database
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "Shree@500");  //Syntax-->"jdbc:mysql://localhost:3306/projects"
		System.out.println("+++++++++++++++++++++++++connection done++++++++++++++++++++");
		
		//step 3: create SQL statement
		Statement stat = conn.createStatement( );
		
		//step 4: execute select query & get result
		ResultSet resultset = stat.executeQuery("SELECT * FROM vTigerCommonData LIMIT 1;");
		resultset.next();
		String browser = resultset.getString(1);
		String url = resultset.getString(2);
		String username = resultset.getString(3);
		String password = resultset.getString(4);
		System.out.println("these data are getting from MySQL database from local server");
		
		System.out.println(browser);
		System.out.println(url);
		System.out.println(username);
		System.out.println(password);
		
		//step 5: close the connection
		conn.close();
WebDriver driver = null;
		
		if(browser.equals("Chrome")) {
			driver = new ChromeDriver();
		}
else if(browser.equals("firefox")) {
			driver = new FirefoxDriver();
		}
else if(browser.equals("edge")) {
	driver = new EdgeDriver();
		}
else if(browser.equals("safari")) {
	driver = new SafariDriver();
}
else {
	System.out.println("fix your browser instance");
}
		
	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get(url);
		
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
		
		driver.quit();

	}


}
