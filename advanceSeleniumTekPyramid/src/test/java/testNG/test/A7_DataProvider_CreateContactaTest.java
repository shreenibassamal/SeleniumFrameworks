package testNG.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class A7_DataProvider_CreateContactaTest {
	@Test(dataProvider ="getData" )
	public void createContactTest(String firstname, String lastname) {
		System.out.println(firstname+" "+lastname); 
	}
	
	@DataProvider
	public Object[][] getData(){
		Object[][] objArr = new Object[3][2];  //here first array show number of execution and second one for arguments/parameters
		
		objArr[0][0]="shreenibas";
		objArr[0][1]="samal";
		
		objArr[1][0]="Arun";
		objArr[1][1]="sahu";
		
		objArr[2][0]="kadambini";
		objArr[2][1]="sahoo";
		
		
		
		
		return objArr;
		
		
	}

}
