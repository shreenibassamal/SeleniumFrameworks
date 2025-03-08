package testNG.test;

import org.testng.annotations.Test;

public class A3_MultipleTestNGmethodTest {
//	@Test
	public void createContactTest() {
		System.out.println("execute createContactTest");
		
	}
	
	@Test
     public void createContactWithMobileNumberTest() {
		System.out.println("execute  createContactWithMobileNumberTest ");
	}
	@Test
     public void createContactWithEmailTest() {
		System.out.println("execute createContactWithEmailTest");
}

}
