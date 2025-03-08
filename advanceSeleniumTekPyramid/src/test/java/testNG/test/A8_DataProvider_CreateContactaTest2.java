package testNG.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class A8_DataProvider_CreateContactaTest2 {
	@Test(dataProvider ="getData" )
	public void createContactTest(String firstname, String lastname, long phoneNuber) {
		System.out.println("fullname is : "+firstname+" "+lastname+"  mobile number is:"+phoneNuber); 
	}
	
	@DataProvider
	public Object[][] getData(){
		Object[][] objArr = new Object[3][3];  //here first array show number of execution and second one for arguments/parameters
		
		objArr[0][0]="shreenibas";
		objArr[0][1]="samal";
		objArr[0][2]=123456789l;
		
		objArr[1][0]="Arun";
		objArr[1][1]="sahu";
		objArr[1][2]=1245786l;
		
		objArr[2][0]="kadambini";
		objArr[2][1]="sahoo";
		objArr[2][2]=4578124l;
		
		
		
		
		return objArr;
		
		
	}

}
