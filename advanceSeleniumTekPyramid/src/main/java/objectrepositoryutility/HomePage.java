package objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {                     //Rule-1 create a separate java class
	                                        //object identification/creation
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}
	
	
	
	
	@FindBy(linkText = "Organizations")
	public WebElement orgLink;
	
	
	@FindBy(linkText = "contacts")
	public WebElement contactLink;
	
	
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	WebElement adminImage;
	
	@FindBy(linkText = "Sign Out")
	WebElement signOut;
	
	public void logout() {
		Actions action = new Actions(driver);
		action.moveToElement(adminImage).build().perform();
		signOut.click();
		
	}
	
	public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getContactLink() {
		return contactLink;
	}
	
	

}
