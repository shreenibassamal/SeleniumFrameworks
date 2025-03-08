package DDTWithExcelFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleRowDataFromExcelTest {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis =new FileInputStream("./src/test/resources/basicDDTdata/tsetScriptData.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		int rowCount = wb.getSheet("org").getLastRowNum();
		
		for(int i = 1;i<rowCount;i++) {
			String data1 = wb.getSheet("org").getRow(i).getCell(1).toString();
			String data2 = wb.getSheet("org").getRow(i).getCell(2).toString();
			System.out.println(data1+"   "+data2);
		}
		wb.close();

	}

}
