package robotclass;

import java.io.IOException;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;

import java.awt.event.KeyEvent;

import java.awt.datatransfer.StringSelection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RobotInSelenium {
	
	WebDriver driver;
	String path="";
	String actual_path="";
	String file_path="";
	public void setup_chrome()
	{
		path=System.getProperty("user.dir");
		actual_path=path+"\\Driver\\chromedriver.exe";
		file_path=path+"\\Resource\\TestFile.xlsx";
		
		System.setProperty("webdriver.chrome.driver", actual_path);
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/upload/");
	}
	
	public void validate_file() throws InterruptedException, AWTException
	{
		WebElement file_upload=driver.findElement(By.id("uploadfile_0"));
		
		Actions ac=new Actions(driver);
		ac.moveToElement(file_upload).click().build().perform();
		
		StringSelection str=new StringSelection(file_path);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str,null);		//ctrl + c
		
		Thread.sleep(3000);
		
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		
		r.keyPress(KeyEvent.VK_ENTER);
		
		Thread.sleep(3000);
		driver.findElement(By.id("terms")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.id("submitbutton")).click();
	}
	
	public static void main(String[] args) throws InterruptedException, IOException, AWTException {
		
		RobotInSelenium f=new RobotInSelenium();
		f.setup_chrome();
		f.validate_file();
	}
}