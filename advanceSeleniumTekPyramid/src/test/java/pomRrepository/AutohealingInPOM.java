package pomRrepository;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class AutohealingInPOM {
	
	@FindAll({@FindBy(name="user_name"), @FindBy(xpath = "//input[@type='text']")}) //it treat as "OR" operator"
	private WebElement ele1;

	@FindBys({@FindBy(name="user_password"), @FindBy(xpath="//input[@type='password']")}) //it treat as "AND" operator"
	private WebElement ele2;
	
	@FindAll({@FindBy(id="submitButton"), @FindBy(xpath = "(//input[@value='Login'])[2]")}) //it treat as "OR" operator"
	 WebElement ele3;
	
	@Test
	public void sampleTest() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("http://localhost:8888/");
		
	AutohealingInPOM s = PageFactory.initElements( driver ,AutohealingInPOM.class);
	
	
	//navigating to v-tiger by using object repository and auto-healing annotation.  
	s.ele1.sendKeys("admin");
	s.ele2.sendKeys("admin");
	s.ele3.click();
	
	
	
	driver.quit();

	}


}
