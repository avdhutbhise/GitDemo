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

public class WindowInSelenium {
	
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
	
	public void validate_windows() throws InterruptedException
	{
		String main_window=driver.getWindowHandle();	
		WebElement new_window=driver.findElement(By.id("windowButton"));
		new_window.click();
		
		Set<String> all_windows = driver.getWindowHandles();
		System.out.println("All Window Handles");
		
		for(String x:all_windows)
		{
			if(!x.equals(main_window))
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
		
		WindowInSelenium f=new WindowInSelenium();
		f.setup_chrome();
		f.validate_windows();
	}
}