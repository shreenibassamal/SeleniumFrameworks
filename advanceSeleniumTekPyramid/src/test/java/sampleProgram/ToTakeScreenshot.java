package sampleProgram;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class ToTakeScreenshot {

	public static void main(String[] args) throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("http://localhost:8888/");
		
		//Type cast to get the capabilities of takescreenshot interface to the WebDriver instance
				//Typecasting -downcasting
				TakesScreenshot ts = (TakesScreenshot)driver;
				//Temporary location
		       File temporary1 = ts.getScreenshotAs(OutputType.FILE);
		       //Destination location
			   File dest1 = new File("./Screenshots/searchButton.png");
			   FileHandler.copy(temporary1, dest1);	

			   driver.quit();
	}

}
