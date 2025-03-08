package practice.test;

import java.io.File;
import java.time.Duration;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Browser;

public class JioMart {

	public static void main(String[] args) throws Throwable {
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--headless");
		chromeOptions.addArguments("true");
		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.jiomart.com/");
		String title = driver.getTitle();
		String url = driver.getCurrentUrl();
		String sesonId = driver.getWindowHandle();
		System.out.println(title);
		System.out.println(url);
		System.out.println(sesonId);
		
	    TakesScreenshot ts = (TakesScreenshot)driver;
	   File src = ts.getScreenshotAs(OutputType.FILE);
	   File dest = new File("./Screenshots/headlessh.png");
    	 src.renameTo(dest);
		 
		 File src1 = driver.findElement(By.xpath("//input[@id='autocomplete-0-input']")).getScreenshotAs(OutputType.FILE);
		 File dest1 = new File("./Screenshots/headless element1.png");
		 src1.renameTo(dest1);
		 
		 File src2= driver.findElement(By.xpath("//body[@class='jio-web cms-home jiomart_home home_overflow_hidden']")).getScreenshotAs(OutputType.FILE);
		 File dest2 = new File("./Screenshots/bodysch.png");
		 src2.renameTo(dest2);
		 
		driver.quit();

	}

}
