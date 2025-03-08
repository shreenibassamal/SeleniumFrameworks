package testNG.assert_verificationTest;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class A4_HardAssertAndSoftAssertInOneMethodTest {
	@Test
	public void aAssertTest(Method mtd) {
		System.out.println(mtd.getName()+" ===============Test Start================");
		SoftAssert assertObj= new SoftAssert();
		System.out.println("step-1");
		assertObj.assertEquals("title", "title1"); //here value is false but due to soft assert it it will not stop the execution 
		System.out.println("step-2");
		Assert.assertEquals("Home", "Home");      //here value is true
		System.out.println("step-3");
		System.out.println("step-4");
		Assert.assertEquals("Home", "Home Page"); //here value is false
		
		System.out.println("step-5");
		System.out.println(mtd.getName()+" ===============Test End================");
		
	}
	
	
	@Test
	public void bAssertTest(Method mtd) {
		System.out.println(mtd.getName()+" ===============Test Start================");
		SoftAssert assertObj= new SoftAssert();
		System.out.println("step-1");
		System.out.println("step-2");
		assertObj.assertTrue(false, "The test sep is failed");
		System.out.println("step-3");
		assertObj.assertTrue(true, "The test sep is passed");
		System.out.println("step-4");
		Assert.assertEquals("Home", "Home Page"); //here value is false so due to hard  assert it will not excute the scripts
		System.out.println("step-5");
		System.out.println(mtd.getName()+" ===============Test End================");
		assertObj.assertAll();
	}
	
}
