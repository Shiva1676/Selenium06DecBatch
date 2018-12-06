/**
 * 
 */
package provider_Ecommerce;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author Lenovo
 *
 */
public class ExcelProvider {

	XSSFWorkbook wb;

	public ExcelProvider() {

		String pathname = System.getProperty("user.dir") + "/TestData_Ecommerce/FlipkartData.xlsx";

		try {
			File src = new File(pathname);

			FileInputStream fis = new FileInputStream(src);

			wb = new XSSFWorkbook(fis);
			
		} catch (Exception e) {
			
			System.out.println("============Unable to load the excel==============");
			
			System.out.println(e.getMessage());
		} 

	}

	
	public int getRows(String sheetname){
		
		int rows = wb.getSheet(sheetname).getPhysicalNumberOfRows();
		
		return rows;
	}
	
	
	public int getColumns(String sheetname){
		
		int columns = wb.getSheet(sheetname).getRow(0).getLastCellNum();
		
		return columns;
	}
	
	public String getData(String sheetname, int row, int column){
		
		String data = wb.getSheet(sheetname).getRow(row).getCell(column).getStringCellValue();
		
		return data;
	}
	
	
}
