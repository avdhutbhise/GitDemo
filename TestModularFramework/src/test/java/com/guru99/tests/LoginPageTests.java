package com.guru99.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.guru99.pages.LoginPage;
import com.guru99.utils.TestDataProvider;

import commonLibs.implementation.CommonDriver;


public class LoginPageTests {

	String url="https://demo.guru99.com/v4/";
	CommonDriver cmnDriver;
	LoginPage loginPage;
	
	@BeforeMethod
	public void setup() throws Exception
	{
		cmnDriver=new CommonDriver("chrome");
		cmnDriver.setElementLocatedTime(20);
		cmnDriver.navigateToURL(url);
		loginPage=new LoginPage(cmnDriver.getDriver());
	}
	
	/*
	@Test
	public void verifyLogin() throws Exception
	{
		String UserID="mngr520004";
		String password="qerYses";
		loginPage.loginToApplication(UserID, password);
		Thread.sleep(3000);
	}*/
	
	@Test(dataProvider="getData",dataProviderClass = TestDataProvider.class)
	public void verifyLoginDataProvider(String userName, String password) throws Exception
	{
		loginPage.loginToApplication(userName, password);
		Thread.sleep(3000);
		
		String expectedTitle="Guru99 Bank Manager HomePage";
		String actualTitle=cmnDriver.getTitle();
		
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@AfterMethod
	public void cleanUp() throws Exception
	{
		cmnDriver.closeAllBrowser();
	}
}