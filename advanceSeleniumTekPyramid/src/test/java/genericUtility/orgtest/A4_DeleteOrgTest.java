package genericUtility.orgtest;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class A4_DeleteOrgTest {

	public static void main(String[] args) throws Throwable {
		//Step-1: Navigate to application
		
		//read common data from properties file for navigation
		FileInputStream fis = new FileInputStream("./src/test/resources/vtigerCommondata.properties");
		Properties obj = new Properties();
		obj.load(fis);
		//common data
		String BROWSER = obj.getProperty("browser");
		String URL=obj.getProperty("url");
		String USERNAME=obj.getProperty("username");
		String PASSWORD=obj.getProperty("password");
		
	    

		WebDriver driver = null;
		
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
		
	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get(URL);
		//Step 2 :Login to application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		
		//Step 3: navigate to Organization module
		driver.findElement(By.linkText("Organizations")).click();
		
		//Step 4 : click on "+" icon for create  new organization
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		//Step 5 : Create organization with mandatory fields

		//generate random number for multiple organization creation
		Random rn = new Random();
		int randomInt = rn.nextInt(10);
		
		FileInputStream fis1 =new FileInputStream("./src/test/resources/vTigerScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		String orgName = wb.getSheet("Organization").getRow(1).getCell(2).toString()+randomInt;
		
		System.out.println("Entered organization name is : "+orgName);
		
		//Enter all the details and create new Organization
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgName);
	    wb.close();
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]' and @type='button']")).click();
		
		//Verify the headear message Excepted Result
		String headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(headerInfo.contains(orgName)) {
			
			System.out.println(orgName+"is created ===PASS");
			
		}
		else {
			System.out.println(orgName+"is not created ===FAIL");
		}
		
		//verify the  Header org info Excepted Result
		String actualInfo = driver.findElement(By.id("dtlview_Organization Name")).getText();
		if(actualInfo.contains(orgName)) {
             System.out.println(orgName+"is created ===PASS");
			
		}
		else {
			System.out.println(orgName+"is not created ===FAIL");
		}
	
         // go back to organization page 
		// search for organization 
		//inndynamic web table select a org  and delete it
		//Step-6: logout
		driver.quit();


	}

}
