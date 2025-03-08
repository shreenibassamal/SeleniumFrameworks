package testNG.Listener;

import org.testng.Assert;

import org.testng.annotations.Test;
import generic.baseutility.BaseClassIListener;
//@Listeners(listenerUtility.ListenerImpClass.class)
public class ListenerInvoiceTest extends BaseClassIListener{
	
	@Test
	public void createInvoiceTest() {
		System.out.println("execute createInvoiceTest");
		
		String actTitle = driver.getTitle();
		System.out.println("before verification"+actTitle);
		Assert.assertEquals(actTitle, "Login");
		System.out.println("after verification"+actTitle);
		
		
		
	}
	
	@Test
	public void createInvoiceWithContactTest() {
		System.out.println("execute createInvoiceWithContactTest");
		
	}

}
