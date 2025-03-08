package testNG.reporting;

import java.lang.reflect.Method;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class A1_ReporterLogTest {
	@Test
	public void reporting1Test(Method mtd) {
		Reporter.log(mtd.getName()+" ===============Test Start================");
		Reporter.log("step-1",true);
		Reporter.log("step-2",true);
		Reporter.log("step-3",true);
		Reporter.log("step-4",true);
		Reporter.log("step-5",true);
		Reporter.log(mtd.getName()+" ===============Test End================");	
	}
	
	
	@Test
	public void reporting2Test(Method mtd) {
		Reporter.log(mtd.getName()+" ===============Test Start================");
		Reporter.log("step-1",true);
		Reporter.log("step-2",true);
		Reporter.log("step-3",true);
		Reporter.log("step-4",true);
		Reporter.log("step-5",true);
		Reporter.log(mtd.getName()+" ===============Test End================");
	}
	
}
