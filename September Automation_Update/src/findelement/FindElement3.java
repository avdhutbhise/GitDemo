package findelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElement3 {

	WebDriver driver;
	public void setup_chrome()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ip-slim-3\\eclipse-workspace\\DCTC DEC-21\\September Automation\\Driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		
		WebElement input_tag = driver.findElement(By.tagName("input"));
		String txt_name=input_tag.getAttribute("name");
		System.out.println(txt_name);
		
		WebElement form_tag = driver.findElement(By.className("_9vtf"));
		txt_name=form_tag.getAttribute("action");
		System.out.println(txt_name);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FindElement3 f2=new FindElement3();
		f2.setup_chrome();
	}

}
