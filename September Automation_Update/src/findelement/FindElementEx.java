package findelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementEx {

	
	WebDriver driver;
	
	public void setup_chrome() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ip-slim-3\\eclipse-workspace\\DCTC DEC-21\\September Automation\\Driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("test@test.com");
		
		WebElement pwd = driver.findElement(By.name("pass"));
		pwd.sendKeys("test12345");
		
		WebElement btn_login = driver.findElement(By.name("login"));
		//btn_login.click();
		
		Thread.sleep(3000);
		email.clear();
		
		Thread.sleep(3000);
		pwd.clear();
	}
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		FindElementEx f=new FindElementEx();
		f.setup_chrome();
	}

}
