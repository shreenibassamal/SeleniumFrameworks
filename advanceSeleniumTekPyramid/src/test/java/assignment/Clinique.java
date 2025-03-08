package assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Clinique {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		
		driver.get("https://www.clinique.in/");
		driver.findElements(By.xpath("//button[@id='onetrust-accept-btn-handler']")).
		 driver.switchTo().alert().accept();
		
		 WebElement skincare = driver.findElement(By.xpath("//a[@aria-label='View Skincare menu']"));
		
		
		Actions action = new Actions(driver);
		action.moveToElement(skincare).build().perform();
		
		List<WebElement> skincareType = driver.findElements(By.xpath("Skin Care _ Clinique _ Official Site"));
		for(WebElement elements:skincareType) {
			System.out.println(elements.toString());
		}
		
		
		
		
		driver.quit();
		

	}

}
