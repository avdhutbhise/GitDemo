package findelement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsEx {

	WebDriver driver;
	public void setup_chrome()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ip-slim-3\\eclipse-workspace\\DCTC DEC-21\\September Automation\\Driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		
		System.out.println("---------------------");
		WebElement y = driver.findElement(By.tagName("a"));
		System.out.println(y.getText()+" : "+y.getAttribute("href"));
		System.out.println("---------------------");
		
		List<WebElement> a_tag = driver.findElements(By.tagName("a"));
		
		for(WebElement x:a_tag)
		{
			System.out.println(x.getText()+" : "+x.getAttribute("href"));
		}
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FindElementsEx f2=new FindElementsEx();
		f2.setup_chrome();
	}

}
