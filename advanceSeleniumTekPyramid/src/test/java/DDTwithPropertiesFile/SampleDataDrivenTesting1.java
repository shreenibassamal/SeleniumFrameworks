package DDTwithPropertiesFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class SampleDataDrivenTesting1 {
;
	public static void main(String[] args) throws Throwable  {
		// TODO Auto-generated method stub

//		FileInputStream fis = new FileInputStream("./src/test/resources/commondata.properties");
		FileInputStream fis = new FileInputStream("./src/test/resources/vtigerCommondata.properties");
		Properties obj = new Properties();
		
		obj.load(fis);
		System.out.println(obj.getProperty("browser"));
	}

}