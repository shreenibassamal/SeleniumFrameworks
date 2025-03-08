package testNG.assert_verificationTest;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class A2_HomePageVerificationWithAssertTest {
	@Test
	public void homepageTest(Method mtd) {
		System.out.println(mtd.getName()+" ===============Test Start================");
//		String exptectedPage= "Home"; //comment it for making test NG fail for next parameter
		
		String exptectedPage= "Home Page"; //here value is change from "Home" to "Home Page" for making testNg fail with Assert methods
		/*console result is fail as "Home Page pagr is not verifyrd===FAIL"
		  But TestNG report showing  below as
		 ===============================================
         Default suite
         Total tests run: 2, Passes: 1, Failures: 1, Skips: 0
         ===============================================
         
         we go for assert 
         beacuse  if-elese block is not capable to make testNG tset-case fail
		 */
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8888/");
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		String actTitle = driver.findElement(By.xpath("//a[contains(text(),'Home')]")).getText();
		
		//Hard assert
		Assert.assertEquals(actTitle, exptectedPage);
		
		driver.quit();
		System.out.println(mtd.getName()+" ===============Test End================");
		
		
		
	}
	
	
	@Test
	public void verifyLogoHomePageTest(Method mtd) {
		System.out.println(mtd.getName()+" ===============Test Start================");
	
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8888/");
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		boolean status = driver.findElement(By.xpath("//img[@title='vtiger-crm-logo.gif']")).isEnabled();
		
		//Hard assert
//		Assert.assertEquals(true, status);
		Assert.assertTrue(status);         //thios method takle single argument
		
		
		driver.quit();
		System.out.println(mtd.getName()+" ===============Test End================");
		
	
	}
	
}
