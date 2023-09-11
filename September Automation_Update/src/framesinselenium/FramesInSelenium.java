package framesinselenium;

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

public class FramesInSelenium {
	
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
		driver.get("https://licindia.in/");
	}
	
	public void validate_frame() throws InterruptedException
	{
		driver.findElement(By.id("corover-cb-widget")).click();
				
		WebElement frame1=driver.findElement(By.id("corover-chat-frame"));
		driver.switchTo().frame(frame1);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary ant-btn-round ant-btn-lg']")).click();
		driver.switchTo().defaultContent();
	}
	
	public static void main(String[] args) throws InterruptedException, IOException {
		
		FramesInSelenium f=new FramesInSelenium();
		f.setup_chrome();
		f.validate_frame();
	}
}