package actionsinselenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsInSelenium2 {
	
	WebDriver driver;
	String path="";
	String actual_path="";
	
	public void setup_chrome()
	{
		path=System.getProperty("user.dir");
		actual_path=path+"\\Driver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", actual_path);
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/drag_drop.html");
	}
	
	public void actions_methods() throws InterruptedException
	{
		WebElement bank_drag=driver.findElement(By.id("credit2"));
		WebElement bank_drop=driver.findElement(By.id("bank"));
		
		WebElement amt_drag=driver.findElement(By.id("fourth"));
		WebElement amt_drop=driver.findElement(By.id("amt7"));
		
		Actions ac=new Actions(driver);
		Thread.sleep(3000);
		ac.dragAndDrop(bank_drag, bank_drop).build().perform();
		
		Thread.sleep(3000);
		ac.dragAndDrop(amt_drag, amt_drop).build().perform();
	}
	
	public static void main(String[] args) throws InterruptedException, IOException {
		
		ActionsInSelenium2 a=new ActionsInSelenium2();
		a.setup_chrome();
		a.actions_methods();
	}
}