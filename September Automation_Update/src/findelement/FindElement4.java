package findelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//Actual and Relative Xpath in Selenium
public class FindElement4 {

	WebDriver driver;
	public void setup_chrome()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ip-slim-3\\eclipse-workspace\\DCTC DEC-21\\September Automation\\Driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		
		//Actual Xpath
		WebElement email=driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/form/div[1]/div[1]/input"));
		email.sendKeys("vinay87@gmail.com");
		
		WebElement pwd=driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/form/div[1]/div[2]/div[1]/input"));
		pwd.sendKeys("Vinay@12345");
		
		//Relative Xpath
		//WebElement btn_login=driver.findElement(By.xpath("//button[@data-testid='royal_login_button']"));
		//btn_login.click();
		
		driver.get("https://www.google.com/");
		WebElement search=driver.findElement(By.xpath("//input[@name='q' and @title='Search']"));
		search.sendKeys("cricbuzz");
		
		driver.findElement(By.xpath("//input[@name='btnK']")).submit();
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FindElement4 f2=new FindElement4();
		f2.setup_chrome();
	}

}
