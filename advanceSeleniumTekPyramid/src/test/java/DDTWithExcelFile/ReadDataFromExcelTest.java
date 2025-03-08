package DDTWithExcelFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelTest {

	public static void main(String[] args) throws Throwable {
		//step 1:get the excel path location & java object of the physical excel file
		FileInputStream fis = new FileInputStream("./src/test/resources/basicDDTdata/tsetScriptData.xlsx");
		
		//step 2:open workbook in read mode
		Workbook wb = WorkbookFactory.create(fis);
		
		//step 3:get the control ofv the sheet name
		Sheet sh = wb.getSheet("org");
		
		//step 4:get the control of the row
		Row row = sh.getRow(1);
		
		//step 5:get the contril of the cell
		Cell cel = row.getCell(2);
		
		//fetch the cell value for verification 
		String data = cel.getStringCellValue();
		//print the cell value
		System.out.println(data);
		
		//step 6:close the workbook
		wb.close();

	}

}
