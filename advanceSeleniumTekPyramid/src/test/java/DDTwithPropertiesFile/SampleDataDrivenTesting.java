package DDTwithPropertiesFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class SampleDataDrivenTesting {

	public static void main(String[] args) throws Throwable  {
		//step1 : get java representation object of the physical file
		FileInputStream fis = new FileInputStream("./src/test/resources/basicDDTdata/commondata.properties");
		
		//step2 : using Properties class , load all the keys
		Properties pObj = new Properties();
		pObj.load(fis);
		
		//step3 : get the value based  based on the key
		System.out.println(pObj.getProperty("browser"));

	}

}
