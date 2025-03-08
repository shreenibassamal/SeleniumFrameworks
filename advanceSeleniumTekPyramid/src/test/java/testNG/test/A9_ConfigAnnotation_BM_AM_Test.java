package testNG.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class A9_ConfigAnnotation_BM_AM_Test {
	
//	
//	@Test
//	public void createContact() {
//		System.out.println("execute createContact");
//	}
//	
//	
//	@BeforeMethod
//	public void configBeforeMethod() {
//		System.out.println("execute BM");
//	}
//	@AfterMethod
//	public void configAfterMethod() {
//		System.out.println("execute AM");
//	}
	
	/* by using @BeforeMethod and @AfterMethod with single script THE OUTPUT is below
	 
	 execute BM
     execute createContact
     execute AM
     
     let us use for multiple script
	 */
	

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
	
	/* by using @BeforeMethod and @AfterMethod with multiple script THE OUTPUT is below
	 
	 execute BM
     execute createContact
     execute AM
     execute BM
     execute createContactWithMobileNumbe
     execute AM
    
	 */

}
