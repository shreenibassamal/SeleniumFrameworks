package testNG.test;

import org.testng.annotations.Test;

public class A5_DependsOn_CreateOrderTest {
//	@Test
//	public void createOrderTest() {
//		System.out.println("Execute createOrderTest===>123");
//		
//	}
//	
//	@Test()
//	public void billingAnOrderTest() {
//		System.out.println("Execute billingOrderTest===>123");
//	}
	
	/*
	 The output of above script is----
	 Execute billingOrderTest===>123
     Execute createOrderTest===>123
     
	 but  the order of execution should different
	 Execute createOrderTest===>123
	 Execute billingOrderTest===>123
	 
	 so we using dependsOn       below--------------------------------------------------------------------------------------------
	 
	 */
//	@Test
//	public void createOrderTest() {
//		System.out.println("Execute createOrderTest===>123");
//		
//	}
//	
//	@Test(dependsOnMethods ="createOrderTest" )
//	public void billingAnOrderTest() {
//		System.out.println("Execute billingOrderTest===>123");
//	}
	
	
	
	/*
	 lets take a negative scenarios---------------------------------------------------------------------------------------------
	 */
	
//	@Test
//	public void createOrderTest() {
//		System.out.println("Execute createOrderTest===>123");
//		String str = null;
//		System.out.println(str.equals("123"));
//	}
//	
//	@Test(dependsOnMethods ="createOrderTest" )
//	public void billingAnOrderTest() {
//		System.out.println("Execute billingOrderTest===>123");
//	}
	
	
	/*
	 lets take create contact scenarios and use depends on method-------------------------------------------------------------------
	 */
	@Test
	public void createContactTest() {                    // 1st step
		System.out.println("Create HDFC Contact");
		
	}
	
	@Test(dependsOnMethods = "createContactTest")
public void modifyContactTest() {                        // 2d step
		System.out.println("HDFC===modified===>ICCI");
		
	}
	@Test(dependsOnMethods = "modifyContactTest")
public void deleteContactTest() {                         // 3rd step 
		System.out.println("Delete ICCI");
}
	
	

}
