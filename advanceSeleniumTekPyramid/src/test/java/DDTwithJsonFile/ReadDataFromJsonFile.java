package DDTwithJsonFile;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class ReadDataFromJsonFile {

	public static void main(String[] args) throws Throwable, IOException, ParseException {
		//step1 : parse Json Physical file in to java Object using JsonParse class (in Simle Json jar file)
		
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader("./src/test/resources/vTigerCommonDataJSONfile.json"));
		
		//step2 : convert java object into JsonObject using down-casting
		JSONObject map = (JSONObject)obj;
		//step3 : get the value from json file using key
		String browser = map.get("browser").toString();
		String url = map.get("url").toString();
		String username = map.get("username").toString();
		String password = map.get("password").toString();
		long timeOut = (long) map.get("timeOut");
		
		System.out.println(browser);
		System.out.println(url);
		System.out.println(username);
		System.out.println(password);
		System.out.println(timeOut);
		
		//login v tiger application through commondata from JSON file; 
WebDriver driver = null;
		
		if(browser.equals("chrome")) {
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
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeOut));
		
		driver.get(url);
		
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
		
		driver.quit();
		
	}

}
