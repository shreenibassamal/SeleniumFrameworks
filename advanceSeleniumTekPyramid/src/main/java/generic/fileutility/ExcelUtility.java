package generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String getDataFromExcel(String shreetName, int rowNum, int celNum) throws Throwable {
		
        FileInputStream fis =new FileInputStream("./configAppData/vTigerScriptData.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(shreetName).getRow(rowNum).getCell(celNum).toString();
		wb.close();
		
		return data;
		
	}
	
	public int getRowCount(String shreetName ) throws Throwable {
		 FileInputStream fis =new FileInputStream("./configAppData/AvTigerScriptData.xlsx");
			
	     Workbook wb = WorkbookFactory.create(fis);
	     int rowCount=wb.getSheet(shreetName).getLastRowNum();
		return rowCount;
		
	}
	
	public void setDataIntoExcel(String seetName, int rowNum, int celNum,String data) throws Throwable {
      FileInputStream fis = new FileInputStream("./CommcastCRMGUIFramework/configAppData/vTigerScriptData.xlsx");
	  Workbook wb = WorkbookFactory.create(fis);
	  wb.getSheet(seetName).getRow(rowNum).createCell(celNum).setCellValue(data);                                                                                                                               
      
      FileOutputStream fos = new FileOutputStream("./configAppData/AvTigerScriptData.xlsx");
      wb.write(fos); 
	  wb.close();
		
		
	}

}
