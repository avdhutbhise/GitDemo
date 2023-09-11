package excelfileread;

import java.io.FileInputStream;
import java.io.IOException;

import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadAllTypesOfData {

	String path="";
	String file_path="";
	public void geekforgeeks() throws IOException{
			
		path=System.getProperty("user.dir");
		file_path=path+"\\Resource\\TestFile.xlsx";
			
			FileInputStream file = new FileInputStream(file_path);
			XSSFWorkbook wb=new XSSFWorkbook(file);
			XSSFSheet sheet=wb.getSheet("Sheet3");
	
			// Iterate each row one by one
			Iterator<Row> rIterator = sheet.iterator();
			while (rIterator.hasNext())
			{
				Row row = rIterator.next();
				
				// For each row, iterate through all the columns
				Iterator<Cell> Cell = row.cellIterator();
				
				while (Cell.hasNext())
				{
					Cell cell = Cell.next();
					
					// Check the cell type
					switch(cell.getCellType())
					{
					case STRING:
						System.out.print(cell.getStringCellValue());
						break;
						
					case NUMERIC:
						System.out.print(cell.getNumericCellValue());
						break;
						
					case FORMULA:
						System.out.print(cell.getNumericCellValue());
						break;
					}
					System.out.print("|");
				}
				System.out.println();			
			}
			wb.close();
			file.close();
	}
	
	public static void main(String[] args) throws IOException {
		ReadAllTypesOfData g=new ReadAllTypesOfData();
		g.geekforgeeks();
	}
	
}