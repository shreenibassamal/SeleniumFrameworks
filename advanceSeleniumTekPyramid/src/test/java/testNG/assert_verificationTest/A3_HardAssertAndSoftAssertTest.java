package testNG.assert_verificationTest;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class A3_HardAssertAndSoftAssertTest {
	@Test
	public void hardAssertTest(Method mtd) {
		System.out.println(mtd.getName()+" ===============Test Start================");
		System.out.println("HardAssert_step-1");
		System.out.println("HardAssert_step-2");
		Assert.assertEquals("Home", "Home Page"); //here value is false
		System.out.println("HardAssert_step-3");
		Assert.assertEquals("Home", "Home");      //here value is true
		System.out.println("HardAssert_step-4");
		System.out.println("HardAssert_step-5");
		System.out.println(mtd.getName()+" ===============Test End================");
		
	}
	
	
	@Test
	public void softAssertTest(Method mtd) {
		System.out.println(mtd.getName()+" ===============Test Start================");
		SoftAssert assertObj= new SoftAssert();
		System.out.println("SoftAssert_step-1");
		System.out.println("SoftAssert_step-2");
		assertObj.assertTrue(false, "The test sep is failed");
		System.out.println("SoftAssert_step-3");
		assertObj.assertTrue(true, "The test sep is passed");
		System.out.println("SoftAssert_step-4");
		System.out.println("SoftAssert_step-5");
		System.out.println(mtd.getName()+" ===============Test End================");
		assertObj.assertAll();
	}
	
}
