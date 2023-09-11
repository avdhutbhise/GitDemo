package findelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElement2 {

	WebDriver driver;
	public void setup_chrome()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ip-slim-3\\eclipse-workspace\\DCTC DEC-21\\September Automation\\Driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		
		WebElement link_forgot_pwd = driver.findElement(By.linkText("Forgotten password?"));
		link_forgot_pwd.click();
		
		driver.get("https://msbte.org.in/");
		driver.findElement(By.partialLinkText("NIELIT")).click();
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FindElement2 f2=new FindElement2();
		f2.setup_chrome();
	}

}
