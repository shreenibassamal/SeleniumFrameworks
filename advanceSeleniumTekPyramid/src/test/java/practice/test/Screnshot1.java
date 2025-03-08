package practice.test;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Screnshot1 {
	public static void main(String[] args) throws Exception {
		
		ChromeDriver driver1= new ChromeDriver();
		WebDriver driver2 = new ChromeDriver();
		driver1.manage().window().maximize();
		driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver1.get("https://demowebshop.tricentis.com/");
		Thread.sleep(2000);
		
		 TakesScreenshot ts =  driver1;
//		File src = ts.getScreenshotAs(OutputType.FILE);
//		File dest = new File("./Screenshots/chrome.png");
//		FileHandler.copy(src, dest);
		
	
		ts= (TakesScreenshot)driver1;
		File src1 = ts.getScreenshotAs(OutputType.FILE);
		File dest1 = new File("./Screenshots/Chrome123.png");
		FileHandler.copy(src1, dest1);
		
		
		driver1.quit();
		
		
		
	}

	
}
