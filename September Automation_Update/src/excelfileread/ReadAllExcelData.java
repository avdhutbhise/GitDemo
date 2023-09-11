package excelfileread;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadAllExcelData {

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

		int n=sheet.getPhysicalNumberOfRows();
		
		for(int i=0;i<n;i++)
		{
			String name_label=sheet.getRow(i).getCell(0).getStringCellValue();
			String actual_value=sheet.getRow(i).getCell(1).getStringCellValue();
			
			System.out.println(name_label+" : "+actual_value);
		}
		
		
		

	}
	
	public static void main(String[] args) throws IOException {
		ReadAllExcelData r=new ReadAllExcelData();
		r.read_excel_file();
	}

}


