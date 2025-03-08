package objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformationPage {
	WebDriver driver;
	public OrganizationInformationPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id = "dtlview_Organization Name")
	private WebElement orginfoNameEdit;
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headderMsg;
	
	
	public WebElement getOrginfoNameEdit() {
		return orginfoNameEdit;
	}

	public WebElement getHeadderMsg() {
		return headderMsg;
	}
	
	

}
