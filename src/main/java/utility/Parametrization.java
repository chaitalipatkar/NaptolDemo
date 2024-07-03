package utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Parametrization {
	public static String getTestData(int row,int cell, String sheetName) throws EncryptedDocumentException, IOException  {
		
   FileInputStream file = new FileInputStream("C:\\Users\\SWAPNIL\\eclipse-workspace\\NaptoolDemo\\src\\test\\resources\\TestData.xlsx");
	return WorkbookFactory.create(file).getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();	
			
	}
}
	


