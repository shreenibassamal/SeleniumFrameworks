package listenerUtility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import generic.baseutility.BaseClassIListener;

public abstract class ListenerImpClass implements ITestListener, ISuiteListener{

	@Override
	public  void onStart(ISuite suite) {
		System.out.println("Report configuration");
	}
		
	@Override
	public  void onFinish(ISuite suite) {
		System.out.println("Report Backup ");
	}
	
	

	@Override
	public  void onTestStart(ITestResult result) {
		System.out.println("==============>"+result.getMethod().getMethodName()+"<======START========");
		
	}

	@Override
	public  void onTestSuccess(ITestResult result) {
		System.out.println("==============>"+result.getMethod().getMethodName()+"<=====END=========");
	}

	@Override
	public  void onTestFailure(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		System.out.println("method name is"+testName);
		TakesScreenshot ts = (TakesScreenshot)BaseClassIListener.sdriver;
       File temporary1 = ts.getScreenshotAs(OutputType.FILE);
	   File dest1 = new File("./Screenshots/"+testName+".png");
	   try {
		FileHandler.copy(temporary1, dest1);
	} catch (IOException e) {
		e.printStackTrace();
	}
		
	}

	@Override
	public  void onTestSkipped(ITestResult result) {
	}

	

	
	
}
