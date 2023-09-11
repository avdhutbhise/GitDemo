package windowinselenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TabsInSelenium {
	
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
		driver.get("https://demoqa.com/browser-windows");
	}
	
	public void validate_tabs() throws InterruptedException
	{
		String main_tab=driver.getWindowHandle();	
		WebElement new_tab=driver.findElement(By.id("tabButton"));
		new_tab.click();
		
		Set<String> all_tabs = driver.getWindowHandles();
		System.out.println("All Window Handles");
		
		for(String x:all_tabs)
		{
			if(!x.equals(main_tab))
			{
				driver.switchTo().window(x);
				WebElement h1_tag=driver.findElement(By.id("sampleHeading"));
				System.out.println(h1_tag.getText());
				Thread.sleep(3000);
				//driver.close();
			}
		}
		
		Thread.sleep(3000);
		driver.quit();
	}
	
	public static void main(String[] args) throws InterruptedException, IOException {
		
		TabsInSelenium f=new TabsInSelenium();
		f.setup_chrome();
		f.validate_tabs();
	}
}