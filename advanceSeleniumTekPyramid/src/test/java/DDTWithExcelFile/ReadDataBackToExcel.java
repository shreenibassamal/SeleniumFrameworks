package DDTWithExcelFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataBackToExcel {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream("./src/test/resources/basicDDTdata/tsetScriptData.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		
      Cell cel = wb.getSheet("org").getRow(0).createCell(6);
    		  
      cel.setCellType(CellType.STRING);
      cel.setCellValue("filename");
      
     FileOutputStream fos = new FileOutputStream("./src/test/resources/basicDDTdata/tsetScriptData.xlsx");
     wb.write(fos);
       
        
		wb.close();
		System.out.println("all data in row_1 col_3 added");


	}

}
