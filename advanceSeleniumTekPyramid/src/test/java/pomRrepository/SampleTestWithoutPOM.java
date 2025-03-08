package pomRrepository;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SampleTestWithoutPOM {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("http://localhost:8888/");
	
		//we first store the element for code reusability
	WebElement WebEle1 = driver.findElement(By.name("user_name"));    
	WebElement WebEle2 = driver.findElement(By.name("user_password"));
	WebElement WebEle3 = driver.findElement(By.id("submitButton"));
	
	System.out.println("current page element adress: "+WebEle1);
	String beforeRefresh = driver.getWindowHandle();
	System.out.println(beforeRefresh);
	
	//action before refresh 
	//webElement address are refer to existing current page or session id
	WebEle1.sendKeys("admin");
	WebEle2.sendKeys("admin");
	
	driver.navigate().refresh();
	System.out.println("after refresh page the adress of the element: "+WebEle1);
	String afterRefresh = driver.getWindowHandle();
	System.out.println(afterRefresh);
	//action after refresh
	//now the element address will stale/old after refresh
	WebEle1.sendKeys("admin");
	WebEle2.sendKeys("admin");
	WebEle3.click();
	
	
	driver.quit();

	}

}
