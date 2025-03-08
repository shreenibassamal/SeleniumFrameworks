package testNG.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class B1_ConfigAnnotation_BC_AC_Test {
	
	@BeforeClass
	public void configBC() {
		System.out.println("executeBeforeClass");
	}
	
	@AfterClass
	public void configAC() {
		System.out.println("executeAfterClass");
	}
	
	@Test
	public void createContact() {
		System.out.println("execute createContact");
	}
	
	@Test
	public void createContactWithMobileNumber() {
		System.out.println("execute createContactWithMobileNumber");
	}
	
	
	@BeforeMethod
	public void configBeforeMethod() {
		System.out.println("execute BM");
	}
	@AfterMethod
	public void configAfterMethod() {
		System.out.println("execute AM");
	}

}
