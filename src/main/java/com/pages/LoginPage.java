package com.pages;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class LoginPage {
	
	//locators
	By username_loc=By.id("user-name");
	By password_loc=By.id("password");
	By login_btn=By.id("login-button");
	By homepage_txt=By.xpath("//div[@class='header_secondary_container']/span");
	
	public WebDriver driver;
	
	public void launch_browser()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ip-slim-3\\eclipse-workspacenew\\CucumberTraining\\Driver\\chromedriver.exe");
		
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--remote-allow-origins=*");
		
		driver=new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.saucedemo.com/");
	}
	
	public void enter_username(String username)
	{
		driver.findElement(username_loc).clear();
		driver.findElement(username_loc).sendKeys(username);
	}
	
	public void enter_password(String password)
	{
		driver.findElement(password_loc).clear();
		driver.findElement(password_loc).sendKeys(password);
	}
	
	public void click_login()
	{
		driver.findElement(login_btn).click();
	}
	
	public void verify_home_page()
	{
		assertEquals("Products", driver.findElement(homepage_txt).getText());
		System.out.println("Product is verified");
	}
	
	public void close()
	{
		driver.close();
	}
}
