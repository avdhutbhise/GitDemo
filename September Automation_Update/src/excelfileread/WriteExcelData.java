package excelfileread;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelData {

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

		int n=sheet.getLastRowNum();
		
		for(int i=0;i<=n;i++)
		{
			Row row=sheet.getRow(i);
			Cell cell=row.createCell(2);
			
			cell.setCellValue("Lets Write");
		}
		
		FileOutputStream fos=new FileOutputStream(f);
		workbook.write(fos);
		fos.close();
		
		System.out.println("Data Written");

	}
	
	public static void main(String[] args) throws IOException {
		WriteExcelData r=new WriteExcelData();
		r.read_excel_file();
	}

}


