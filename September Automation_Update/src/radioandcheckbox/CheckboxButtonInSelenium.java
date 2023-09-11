package radioandcheckbox;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckboxButtonInSelenium {

	WebDriver driver;
	public void setup_chrome()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ip-slim-3\\eclipse-workspace\\DCTC DEC-21\\September Automation\\Driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/radio.html");
	}
	
	public void validate_checkbox() throws InterruptedException
	{
		WebElement check_opt1=driver.findElement(By.id("vfb-6-0"));
		System.out.println(check_opt1.getAttribute("value"));
		check_opt1.click();
		
		Thread.sleep(3000);
		WebElement check_opt2=driver.findElement(By.id("vfb-6-1"));
		check_opt2.click();
		
		Thread.sleep(3000);
		driver.findElement(By.id("vfb-6-2")).click();
		
		Thread.sleep(3000);
		check_opt1.click();
		
		Thread.sleep(3000);
		check_opt2.click();
	}

	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		CheckboxButtonInSelenium c1=new CheckboxButtonInSelenium();
		c1.setup_chrome();
		c1.validate_checkbox();
	}

}
