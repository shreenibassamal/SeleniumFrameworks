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

public class A3_CreateOrganizationWithPhoneNumberTest {

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
		

		//Step 5 :  Creating new  Organization with phone number using test script data by using Excel file
		FileInputStream fis1 =new FileInputStream("./src/test/resources/vTigerScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		String sel1 = wb.getSheet("Organization").getRow(7).getCell(3).toString();
		
		//generate random number for multiple organization creation with phone number
		Random rn = new Random();
		int randomInt = rn.nextInt(100);
		
		String phoneNumber = sel1+randomInt;	
        System.out.println("Entered phone numbetr is :"+phoneNumber);
        driver.findElement(By.id("phone")).sendKeys(phoneNumber);
        
        String orgName = wb.getSheet("Organization").getRow(4).getCell(2).toString()+randomInt;	
		System.out.println("Entered organization name is : "+orgName);
		
		
		//Enter all the details and create new Organization with phone number
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgName);
	    wb.close();

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]' and @type='button']")).click();
		
		 
	    //Verify the phone number and type info
		String actPnumber = driver.findElement(By.id("dtlview_Phone")).getText();
	    
	if(actPnumber.equals(phoneNumber)) {
		System.out.println(phoneNumber +": information of phone number is verified ==PASS");
	}
	else {
		System.out.println(phoneNumber +": information of phone number is not verified ==FAIL");
	}
	
	    driver.close();
		
	}
}
