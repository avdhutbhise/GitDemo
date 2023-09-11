package findelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//Actual and Relative Xpath in Selenium
public class FindElement5 {

	WebDriver driver;
	public void setup_chrome()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ip-slim-3\\eclipse-workspace\\DCTC DEC-21\\September Automation\\Driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		//Relative Xpath
		driver.get("https://demoqa.com/webtables");
		WebElement table_dept=driver.findElement(By.xpath("//div[contains(text(),'alden@example.com')]//following-sibling::div[2]"));
		System.out.println(table_dept.getText());
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FindElement5 f2=new FindElement5();
		f2.setup_chrome();
	}

}
