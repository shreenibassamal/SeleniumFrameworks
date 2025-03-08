package sampleProgram;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.decorators.WebDriverDecorator;

@SuppressWarnings("rawtypes")
public class MyWebDriverDecorator extends WebDriverDecorator {
	 WebDriver original = new FirefoxDriver();
	 @SuppressWarnings("unchecked")
	WebDriver decorated = new MyWebDriverDecorator().decorate(original);
	
	}

