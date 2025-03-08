package DDTwithPropertiesFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class LoginVtiger {

	public static void main(String[] args) throws Throwable {
		
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
		
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		
		driver.quit();

	}
	

}
