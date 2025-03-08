package testNG.test;

import org.testng.annotations.Test;

public class A6_InvocationCount_OrderTest {
	@Test(invocationCount = 10)  //using for loop we can get the result but it trate as 1-testcase and 10 itteration then the result show only on 1 test case
	                             // but by using invocation method it trat as 10 test cases and give the result of 10 test cases
	public void createContactTest() {                    // 1st step
		System.out.println("Create HDFC Contact");
		
	}
	
	@Test(dependsOnMethods = "createContactTest")
public void modifyContactTest() {                        // 2d step
		System.out.println("HDFC===modified===>ICCI");
		
	}
	@Test(enabled = false) //it will not participate in execution
public void deleteContactTest() {                         // 3rd step 
		System.out.println("Delete ICCI");

}
}
