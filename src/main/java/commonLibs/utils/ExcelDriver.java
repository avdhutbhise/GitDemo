package commonLibs.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class ExcelDriver {
	
	private InputStream fileReader;
	private Workbook excelWorkbook;
	public void openWorkbook(String excelFileName)throws Exception
	{
		excelFileName.trim();
		
		File file=new File(excelFileName);
		
		if(!file.exists())
		{
			throw new Exception("File Does not exist");
		}
		
		fileReader=new FileInputStream(file);
		excelWorkbook=WorkbookFactory.create(fileReader);
	}
	
	public int getRowCount(String sheetName) throws Exception
	{
		sheetName=sheetName.trim();
		Sheet sheet=excelWorkbook.getSheet(sheetName);
		
		if(sheet==null)
		{
			throw new Exception("Invalid sheet Name");
		}
		
		return sheet.getLastRowNum();
	}
	
	public int getCellCountFromARow(String sheetname, int rowNumber) throws Exception
	{
		sheetname=sheetname.trim();
		Sheet sheet=excelWorkbook.getSheet(sheetname);
		
		if(sheet==null)
		{
			throw new Exception("Invalid sheet Name");
		}
		if(rowNumber<0)
		{
			throw new Exception("Invalid Row Number");
		}
		Row row=sheet.getRow(rowNumber);
		
		if(row==null)
		{
			return 0;
		}
		
		return row.getLastCellNum();
	}

	public String getCellData(String sheetname, int rowNumber, int cellNumber) throws Exception
	{
		sheetname=sheetname.trim();
		Sheet sheet=excelWorkbook.getSheet(sheetname);
		
		if(sheet==null)
		{
			throw new Exception("Invalid sheet Name");
		}
		if(rowNumber<0 || cellNumber < 0)
		{
			throw new Exception("Invalid Row Number or Cell Number");
		}
		
		Row row=sheet.getRow(rowNumber);
		
		if(row==null)
		{
			return "";
		}
		
		Cell cell=row.getCell(cellNumber);
		
		if(cell==null)
		{
			return "";
		}
		if(cell.getCellType()==CellType.NUMERIC)
		{
			return String.valueOf(cell.getNumericCellValue());
		}
		else
		{
			return cell.getStringCellValue();
		}
	}

}
