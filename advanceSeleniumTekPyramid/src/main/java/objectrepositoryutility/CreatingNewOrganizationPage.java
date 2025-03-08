package objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewOrganizationPage {
	WebDriver driver;
	public CreatingNewOrganizationPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name = "accountname")
	private WebElement orgNameEdit;
	
	@FindBy(name = "button")
	private WebElement saveBtn;

	public WebElement getOrgNameEdit() {
		return orgNameEdit;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void createOrg(String orgName) {
		
		orgNameEdit.sendKeys(orgName);
		saveBtn.click();
	}
	
	
	

}
