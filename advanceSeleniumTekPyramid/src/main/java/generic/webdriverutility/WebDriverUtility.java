package generic.webdriverutility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	public void waitForPageToLoad(WebDriver driver, int time) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	}
	
public void waitForElementPresent(WebDriver driver,int time,WebElement element) {
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
	wait.until(ExpectedConditions.visibilityOf(element));
		
	}


public void switchToTabOnTitle(WebDriver driver ,String partialTitle) {
	Set<String> windows = driver.getWindowHandles();
	Iterator<String> it = windows.iterator();
	while(it.hasNext()) {
	String WindowID = it.next();
	driver.switchTo().window(WindowID);
	
	String  actUrl = driver.getTitle();
	if(actUrl.contains(partialTitle)) {
		break;
			}
	}
}

public void switchToFrame(WebDriver driver, int index) {
	driver.switchTo().frame(index);
	
}

public void switchToFrame(WebDriver driver, String nameID ) {
	driver.switchTo().frame(nameID);
}

public void switchToFrame(WebDriver driver, WebElement element ) {
	driver.switchTo().frame(element);
}

public void switchToAlertAndAccept(WebDriver driver) {
	driver.switchTo().alert().accept();
	
}

public void switchToAlertAndCancel(WebDriver driver) {
	driver.switchTo().alert().dismiss();
}


public void select(WebElement element, String text) {
	Select sel = new Select (element);
	sel.selectByVisibleText(text);
}

public void select(WebElement element, int index) {
	Select sel = new Select (element);
	sel.deselectByIndex(index);
}

public void mouseMoverOnElement(WebDriver driver, WebElement element) {
	Actions act = new Actions(driver);
	act.moveToElement(element).perform();	
}


public void doubleClick(WebDriver driver, WebElement element) {
	Actions act = new Actions(driver);
	act.doubleClick();
}






}
