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

public class NestedFramesInSelenium {
	
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
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_iframe");
	}
	
	public void validate_frame() throws InterruptedException
	{
				
		WebElement frame1=driver.findElement(By.id("iframeResult"));
		driver.switchTo().frame(frame1);
		Thread.sleep(3000);
		WebElement h1_tag=driver.findElement(By.tagName("h1"));
		System.out.println(h1_tag.getText());
		
		WebElement nested_frame1=driver.findElement(By.xpath("//iframe[@title='W3Schools Free Online Web Tutorials']"));
		driver.switchTo().frame(nested_frame1);
		Thread.sleep(3000);
		driver.findElement(By.linkText("Log in")).click();
		
		driver.switchTo().defaultContent();
	}
	
	public static void main(String[] args) throws InterruptedException, IOException {
		
		NestedFramesInSelenium f=new NestedFramesInSelenium();
		f.setup_chrome();
		f.validate_frame();
	}
}