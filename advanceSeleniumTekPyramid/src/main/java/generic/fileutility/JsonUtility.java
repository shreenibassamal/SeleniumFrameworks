package generic.fileutility;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonUtility {
	public String getDataFromJsonFile(String key) throws Throwable  {
		
	       //step1 : parse Json Physical file in to java Object using JsonParse class (in Simle Json jar file)
	
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(new FileReader("./configAppData/vTigerCommonDataJSONfile.json"));
			
			//step2 : convert java object into JsonObject using down-casting
			JSONObject map = (JSONObject)obj;
			//step3 : get the value from JSON file using key
			String data = map.get(key).toString();
		
		return data;
		
	}

}
