package testNG.reporting;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class A3_SampleExtentReportWithAnnotationFTest {
	ExtentReports report;
	@BeforeSuite
	public void configBs() {
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/createContactTestusing@BS&@AS.html"); //it create a file in project when we pass path 
		spark.config().setDocumentTitle("Extent Report Suite Result "); // create a Title for Report
		spark.config().setReportName("Extent Test Report"); //set the report name
		spark.config().setTheme(Theme.DARK);   // set theme of UI
		//add ENV information & create test 
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("BROWSER", "Chrome-100");
	}
	@AfterSuite
	public void ConFigAs() {
		report.flush();
	}

	@Test
	public void createContactTest() {
		
          

		
		ExtentTest test = report.createTest("createContactTestusing@BS&@AS");

		//

		test.log(Status.INFO, "step-1-LogIn To app");

		test.log(Status.INFO, "step-2-navigate to contact page");
		if ("HOME".equals("HOME")) {

			test.log(Status.PASS, "step-3-Contact created");
		} else {
			test.log(Status.FAIL, "step-3-contact is not created");
			

		}
	
		test.log(Status.WARNING, "step-4");

		test.log(Status.INFO, "step-5");

		test.log(Status.INFO, "step-6");
		

	}

}
