package DDTfromCMD_LINE;

import org.testng.annotations.Test;

public class ReadRuntimeMavenParameterTest {
	@Test
	public void runtimeParameterTest() {
		
		String url = System.getProperty("url");
		String un= System.getProperty("un");
		String pw= System.getProperty("pw");
		String browser= System.getProperty("browser");
		
		System.out.println("Evv==data>URL ==>"+url);
		System.out.println("username==data>URL ==>"+un);
		System.out.println("password==data>URL ==>"+pw);
		System.out.println("browser==data>URL ==>"+browser);
	}

}
