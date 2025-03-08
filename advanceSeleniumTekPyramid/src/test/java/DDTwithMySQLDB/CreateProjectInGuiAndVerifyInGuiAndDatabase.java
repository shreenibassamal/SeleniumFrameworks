package DDTwithMySQLDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateProjectInGuiAndVerifyInGuiAndDatabase {
	public static void main(String[] args) throws Throwable {
		
		//create a projent in GUI
		String projectName="apple751_2";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("http://49.249.28.218:8091/");
		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		driver.findElement(By.linkText("Projects")).click();
		
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		
		driver.findElement(By.name("projectName")).sendKeys(projectName);
		driver.findElement(By.name("createdBy")).sendKeys("Shreenibas");
		
		driver.findElement(By.xpath("(//select[@name='status'])[2]")).click();
		driver.findElement(By.xpath("(//option[@value='Completed'])[2]")).click();
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		System.out.println("project created with name: "+projectName);
		
		driver.close();
		
		//Verify the project in DATABASE
		
		  //step 1: load/ register the database driver
				com.mysql.jdbc.Driver driverRef = new com.mysql.jdbc.Driver();
				DriverManager.registerDriver(driverRef);
				
				//step 2: connect to database
				 Connection conn = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/ninza_hrm", "root", "root");
				System.out.println("+++++++++++++++++++++++++connection done for back end testing++++++++++++++++++++");
				
				//step 3: create SQL statement
				Statement stat = conn.createStatement();
				
				//step 4: execute select query & get result
				ResultSet resultset = stat.executeQuery("select * from project;");
				
				while(resultset.next()) {
					String ProjectnameDB = resultset.getString(4);
					if(ProjectnameDB.equals(projectName)) {
						System.out.println(ProjectnameDB +": is availble===PASS");
					}
					
				
				}
				
				//step 5: close the connection
				conn.close();
		
	}

}
