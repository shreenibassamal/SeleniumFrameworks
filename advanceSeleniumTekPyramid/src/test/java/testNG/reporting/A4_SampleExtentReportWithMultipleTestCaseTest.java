package testNG.reporting;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class A4_SampleExtentReportWithMultipleTestCaseTest {
	ExtentReports report;
	@BeforeSuite
	public void configBs() {
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/MultipleTestCase.html"); //it create a file in project when we pass path 
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

		
		ExtentTest test = report.createTest("createContactTestusing@BS&@AS001");

		//

		test.log(Status.INFO, "step-1-LogIn To app");

		test.log(Status.INFO, "step-2-navigate to contact page");
		if ("HOME".equals("HOME")) {

			test.log(Status.WARNING, "step-3-Contact created");
		} else {
			test.log(Status.FAIL, "step-3-contact is not created");

		}
		test.log(Status.WARNING, "step-4");

		test.log(Status.INFO, "step-5");

		test.log(Status.INFO, "step-6");

	}
	@Test
public void createLinktTest() {

		
		ExtentTest test = report.createTest("createContactTestusing@BS&@AS002");

		//

		test.log(Status.INFO, "step-1-LogIn To app");

		test.log(Status.INFO, "step-2-navigate to contact page");
		if ("HOME".equals("HOME")) {

			test.log(Status.WARNING, "step-3-Contact created");
		} else {
			test.log(Status.FAIL, "step-3-contact is not created");

		}
		test.log(Status.WARNING, "step-4");

		test.log(Status.INFO, "step-5");

		test.log(Status.INFO, "step-6");

	}
	@Test
public void createOrgTest() {

	
	ExtentTest test = report.createTest("createContactTestusing@BS&@AS003");

	//

	test.log(Status.INFO, "step-1-LogIn To app");

	test.log(Status.INFO, "step-2-navigate to contact page");
	if ("HOME".equals("HOME")) {

		test.log(Status.WARNING, "step-3-Contact created");
	} else {
		test.log(Status.FAIL, "step-3-contact is not created");

	}
	test.log(Status.WARNING, "step-4");

	test.log(Status.INFO, "step-5");

	test.log(Status.INFO, "step-6");

}

}
