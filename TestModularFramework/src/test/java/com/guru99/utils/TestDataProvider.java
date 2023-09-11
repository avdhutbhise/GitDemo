package com.guru99.utils;

import org.testng.annotations.DataProvider;

public class TestDataProvider {
	
	@DataProvider(name="getData")
	public Object[][] getData()
	{
		
		return new Object[][]{
			{"mngr520004","qerYses"},
			{"mngr520004","qerNses"},
			{"mngr520005","qerYses"}
		};
	}
}
