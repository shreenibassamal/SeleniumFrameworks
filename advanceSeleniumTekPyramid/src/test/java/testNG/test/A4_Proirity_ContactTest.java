package testNG.test;

import org.testng.annotations.Test;

/*
   When ever we execute testNG class, by default all the test method will be execute based on the Alphabetical Order ,
   in order the changes  the Order of Execution, we go for priority.
 */

public class A4_Proirity_ContactTest { 
	
//	@Test
//	public void createContactTest() {                    // 1st step
//		System.out.println("Create HDFC Contact");
//		
//	}
//	
//	@Test
//public void modifyContactTest() {                        // 2d step
//		System.out.println("HDFC===modified===>ICCI");
//		
//	}
//	@Test
//public void deleteContactTest() {                         // 3rd step 
//		System.out.println("Delete ICCI");
//}
	
	/*
	 But The output is--- 
	 
	 Create HDFC Contact        // 1st step
     Delete ICCI                 // 3rd step 
     HDFC===modified===>ICCI     // 2d step
     
     
     because TestNG always execute the method in alphabetical order.
     
     so it need to be priorities the TestNG methods
	 */
	
	
	
	
//	@Test(priority = 0)
//	public void createContactTest() {                    // 1st step
//		System.out.println("Create HDFC Contact");
//		
//	}
//	
//
//	@Test(priority = 1)
//public void modifyContactTest() {                        // 2d step
//		System.out.println("HDFC===modified===>ICCI");
//		
//	}
//
//	@Test(priority = 2)
//public void deleteContactTest() {                         // 3rd step 
//		System.out.println("Delete ICCI");
//}
	
	
	
	/*
	 If the one of the dependency method is not working then rest method will not work so we don't prefer  to giving priority.
	 
	 By making every test cases independent we can overcome the dependency
	 */
	
//	
//	@Test(priority = 0)
//	public void createContactTest() {                    // 1st step
//		System.out.println("Create HDFC Contact");
//		
//	}
//	
//
//	@Test(priority = 1)
//public void modifyContactTest() {                        // 2d step
//		System.out.println("Create contact   ICCI");
//		System.out.println("ICCI===modified to ===>ICCI");
//		
//	}
//
//	@Test(priority = 2)
//public void deleteContactTest() {                         // 3rd step 
//		System.out.println("Create UPI contact ");
//		System.out.println("Execute Delete contact Test UPI");
//}
	
	
	/*
	 But this individual test case making style  it increase the run time 
	 
	 so we can use another scenario by using  database we can manipulate the data
	 */
	
	
	@Test(priority = 0)
	public void createContactTest() {                    // 1st step
		System.out.println("Create HDFC Contact");
		
	}
	

	@Test(priority = 1)
public void modifyContactTest() {                        // 2d step
		System.out.println("Update the Contacvt HDFC==> to ==> ICCI");
		System.out.println("ICCI===modified to ===>ICCI");
		
	}

	@Test(priority = 2)
public void deleteContactTest() {                         // 3rd step 
		System.out.println("Insert UPI contact to DATAABSE ");
		System.out.println("Execute Delete contact Test UPI");
}
	

}
