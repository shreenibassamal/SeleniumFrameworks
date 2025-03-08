package genericUtility.contacttest;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;

public class A4_CreateContactTest {

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
				
				//Step 3: navigate to contact module by place the mouse cursor and click on "Contact" Link
				driver.findElement(By.linkText("Contacts")).click();
				
				//Navigate to "Create new  Contact" page by click on "+" image
                driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
                
              //Step 5 :  Creating new  Organization with phone number using test script data by using Excel file
        		FileInputStream fis1 =new FileInputStream("./src/test/resources/vTigerScriptData.xlsx");
        		Workbook wb = WorkbookFactory.create(fis1);
        		String firstName = wb.getSheet("Contact").getRow(2).getCell(2).toString();
        		String lastName = wb.getSheet("Contact").getRow(2).getCell(3).toString();
        		
        		
        		
        		//generate random number for multiple organization creation with phone number
        		Random rn = new Random();
        		int randomInt = rn.nextInt(100);
                
                //Create Contact with mandatory fields
                driver.findElement(By.name("firstname")).sendKeys(firstName+randomInt);
                driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastName+randomInt);
                driver.findElement(By.name("button")).click();
                
                String hradermessage = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
               String fn = driver.findElement(By.name("firstname")).getText();
               String ln=driver.findElement(By.xpath("//input[@name='lastname']")).getText();
               
               String name = fn+" "+ln;
               System.out.println(name);
                
                if(hradermessage.contains(name)) {
                	System.out.println(name+"contact is created TEST====>PASS");
                }
                else {
                	System.out.println(name+"contact is not created TEST====>FAIL");
                }
                
                Actions action = new Actions(driver);
                WebElement adminImage = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
               action.moveToElement(adminImage).perform();
               driver.findElement(By.linkText("Sign Out")).click();
               driver.quit();
        		

	}

}
