package objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.fileutility.ExcelUtility;
import generic.webdriverutility.WebDriverUtility;

public class LoginPage extends WebDriverUtility {// Rule-1 create a separate java class
	                    // Rule-2 Object identification
	
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="user_name")
	private WebElement usernameEdit;
	
	@FindBy(name="user_password")
	private WebElement passwordEdit;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;

	                   //Rule-3 Object initialization
	
	//Rule-4 ObjectEcapsulation
	public WebElement getUsernameEdit() {
		return usernameEdit;
	}

	public WebElement getPasswordEdit() {
		return passwordEdit;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	//Rule-5 provide Action
	
	public void loginToApp(String url,String username, String password) throws Throwable {
		waitForPageToLoad(driver, 15);
	     driver.get(url);
	     driver.manage().window().maximize();
		getUsernameEdit().sendKeys(username);
		getPasswordEdit().sendKeys(password);
		getLoginBtn().click();
	}
	
	
	
	
	                  

}
