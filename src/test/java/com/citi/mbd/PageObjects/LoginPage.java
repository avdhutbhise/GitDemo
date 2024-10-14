package com.citi.mbd.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;

	@FindBy(id="user-name")
	WebElement txtUserName;
	
	@FindBy(id="password")
	WebElement txtPassword;

	@FindBy(id="login-button")
	WebElement btnSubmit;

	public LoginPage(WebDriver ldriver) {
		// TODO Auto-generated constructor stub
		
		this.ldriver=ldriver;
		PageFactory.initElements(ldriver, this);
	}
	
	public void setUserName(String user)
	{
		txtUserName.sendKeys(user);
	}
	
	public void setPassword(String password)
	{
		txtPassword.sendKeys(password);
	}
	
	public void clickOnSubmit()
	{
		btnSubmit.click();
	}
}
