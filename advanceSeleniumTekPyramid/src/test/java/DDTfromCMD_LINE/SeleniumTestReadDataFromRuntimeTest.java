package DDTfromCMD_LINE;

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
import org.testng.annotations.Test;

public class SeleniumTestReadDataFromRuntimeTest {

	@Test
	public void seleniumtest() {

		// read data from command-line using maven and testNG

		String BROWSER = System.getProperty("browser");
		String URL = System.getProperty("url");
		String UN = System.getProperty("un");
		String PW = System.getProperty("pw");

		System.out.println("browser==data>URL ==>" + BROWSER);
		System.out.println("Evv==data>URL ==>" + URL);
		System.out.println("username==data>URL ==>" + UN);
		System.out.println("password==data>URL ==>" + PW);


		WebDriver driver = null;

		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.equals("safari")) {
			driver = new SafariDriver();
		} else {
			System.out.println("fix your browser instance");
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		// navigate to url
		driver.get(URL);

		driver.findElement(By.name("user_name")).sendKeys(UN); // enter user name
		driver.findElement(By.name("user_password")).sendKeys(PW); // enter password
		driver.findElement(By.id("submitButton")).click(); // click on submit button

		driver.quit();

	}

}
