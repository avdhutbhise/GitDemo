package com.guru99.utils;

import org.testng.annotations.DataProvider;

import commonLibs.utils.ExcelDriver;

public class TestDataProvider {

	//Its used for getting data from Object Array
	@DataProvider(name="getData")
	public Object[][] getData()
	{
		Object[][] data=new Object[3][2];
		
		data[0][0]="mngr509706";
		data[0][1]="bAnyjub";
		
		data[1][0]="mngr509706";
		data[1][1]="bAnyjub";
		
		data[2][0]="mngr509708";
		data[2][1]="bAnyjub";
		return data;
	}
	
	@DataProvider
	public Object[][] getDataFromExcel() throws Exception
	{
		String excelFileName=System.getProperty("user.dir")+"\\testDataInputFiles\\TestData.xlsx";
		
		ExcelDriver excelDriver=new ExcelDriver();
		excelDriver.openWorkbook(excelFileName);
		
		Object[][] data;
		
		String sheetName="TestData";
		int rowCount=excelDriver.getRowCount(sheetName);
		
		int cellCount=excelDriver.getCellCountFromARow(sheetName, 1);
		
		data=new Object[rowCount+1][cellCount];
		
		for(int row=0; row<=rowCount; row++)
		{
			for(int cell=0; cell<cellCount; cell++)
			{
				data[row][cell]=excelDriver.getCellData(sheetName, row, cell);
			}
		}
		
		return data;
	}
}
