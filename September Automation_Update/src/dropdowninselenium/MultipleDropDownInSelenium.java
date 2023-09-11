package dropdowninselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MultipleDropDownInSelenium {

	WebDriver driver;
	public void setup_chrome()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ip-slim-3\\eclipse-workspace\\DCTC DEC-21\\September Automation\\Driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/select-menu");
	}
	
	public void validate_dropdown() throws InterruptedException
	{
		WebElement sel_tag_multiple=driver.findElement(By.id("cars"));
		
		Select select=new Select(sel_tag_multiple);
		Thread.sleep(3000);
		select.selectByValue("volvo");
		
		Thread.sleep(3000);
		select.selectByVisibleText("Audi");
		
		Thread.sleep(3000);
		select.selectByVisibleText("Saab");
		
		Thread.sleep(3000);
		select.deselectByVisibleText("Saab");
		
		Thread.sleep(3000);
		select.deselectAll();
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		MultipleDropDownInSelenium d=new MultipleDropDownInSelenium();
		d.setup_chrome();
		d.validate_dropdown();
	}

}
