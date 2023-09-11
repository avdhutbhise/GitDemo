package excelfileread;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {

	String path="";
	String file_path="";
	
	public void read_excel_file() throws IOException
	{
		path=System.getProperty("user.dir");
		file_path=path+"\\Resource\\TestFile.xlsx";
		
		File f=new File(file_path);
		FileInputStream fis=new FileInputStream(f);
		
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("test1");
		
		String name_label=sheet.getRow(0).getCell(0).getStringCellValue();
		String actual_name=sheet.getRow(0).getCell(1).getStringCellValue();
		
		System.out.println(name_label+" : "+actual_name);
		
		String des_label=sheet.getRow(4).getCell(0).getStringCellValue();
		String des_value=sheet.getRow(4).getCell(1).getStringCellValue();
		
		System.out.println(des_label+" : "+des_value);
		
		//Number of Rows
		System.out.println("Count of Actual Rows Containing Data :"+sheet.getPhysicalNumberOfRows());
		
		System.out.println("Count of Last row Number including Empty Rows:"+sheet.getLastRowNum());
		
		int n=sheet.getRow(0).getLastCellNum();
		System.out.println("Last Column Number : "+n);
	}
	
	public static void main(String[] args) throws IOException {
		ReadExcelFile r=new ReadExcelFile();
		r.read_excel_file();
	}

}


