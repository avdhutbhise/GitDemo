package waitsinselenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ImplicitWaitInSelenium {

	WebDriver driver;
	public void setup_chrome()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ip-slim-3\\eclipse-workspace\\DCTC DEC-21\\September Automation\\Driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/select-menu");
	}
	
	public void validate_dropdown() throws InterruptedException
	{
		WebElement sel_tag=driver.findElement(By.id("oldSelectMenu"));
		
		Select select=new Select(sel_tag);
		Thread.sleep(3000);
		select.selectByIndex(2);	
		
		Thread.sleep(3000);
		select.selectByValue("6");
		
		Thread.sleep(3000);
		select.selectByVisibleText("Indigo");
		
		driver.get("https://demo.guru99.com/test/newtours/register.php");
		WebElement sel_country=driver.findElement(By.name("country"));
		
		Select select_country=new Select(sel_country);
		Thread.sleep(3000);
		select_country.selectByValue("AUSTRALIA");
		Thread.sleep(3000);
		select_country.selectByValue("BANGLADESH");
		Thread.sleep(3000);
		select_country.selectByValue("BELGIUM");
		Thread.sleep(3000);
		select_country.selectByValue("BRUNEI");
		Thread.sleep(3000);
		select_country.selectByValue("CAMEROON");
		Thread.sleep(3000);
		select_country.selectByValue("INDIA");
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		ImplicitWaitInSelenium d=new ImplicitWaitInSelenium();
		d.setup_chrome();
		d.validate_dropdown();
	}

}
