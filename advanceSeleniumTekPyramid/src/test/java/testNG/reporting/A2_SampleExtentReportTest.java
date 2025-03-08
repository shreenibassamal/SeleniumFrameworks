package testNG.reporting;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class A2_SampleExtentReportTest {

	@Test
	public void createContactTest() {

		// spaerk report config
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/A2_SampleExtentReportTest.html"); // it create a file in project when we pass path
		spark.config().setDocumentTitle("CRM Test Suite Results "); // create a Title for Report
		spark.config().setReportName("CRM Report"); // set the report name
		spark.config().setTheme(Theme.DARK); // set theme of UI

		// add ENV information & create test
		ExtentReports report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-10");
		report.setSystemInfo("BROWSER", "Chrome-100");
		ExtentTest test = report.createTest("");

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


		report.flush();
	}

}
