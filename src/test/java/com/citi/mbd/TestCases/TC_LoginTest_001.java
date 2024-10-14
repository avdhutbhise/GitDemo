package com.citi.mbd.TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.citi.mbd.PageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass{
	
	LoginPage lp;
	
	@BeforeMethod
	public void ObjectsClass() {
		System.out.println("1st line from create Objects from before method");
		lp = new LoginPage(driver);
		System.out.println("Before method from test case to initialize objects");
	}
	
	
	@Test(groups={"sanity", "regression"})
	public void loginTest() throws Exception
	{
		driver.get(baseURL);
		log.info("LOG MSG : URL opened successfully");
		
		lp.setUserName(username);
		log.info("Username entered");
		
		lp.setPassword(password);
		log.info("Password entered");
		
		lp.clickOnSubmit();
		log.info("LOG MSG : Clicked on submit button successfully");
		
		String urlAfterLogin = driver.getCurrentUrl();
		System.out.println(urlAfterLogin);
		Assert.assertEquals(urlAfterLogin, "https://www.saucedemo.com/inventory.html");
		log.info("LOG MSG : Assertion passed for current url");
	}

}