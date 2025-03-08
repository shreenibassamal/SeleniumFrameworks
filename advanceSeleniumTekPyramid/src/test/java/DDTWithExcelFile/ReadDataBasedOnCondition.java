package DDTWithExcelFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataBasedOnCondition {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis =new FileInputStream("./src/test/resources/basicDDTdata/BasedOncondition.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		
		int rowCount = wb.getSheet("org").getLastRowNum();
		
		for(int i =1;i<rowCount;i++) {
			try {
				String data = wb.getSheet("org").getRow(i).getCell(0).toString();
				System.out.println(data);
				}catch(Exception e) {}
		}
		
		
	}
	}
	
