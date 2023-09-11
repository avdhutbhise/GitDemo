package uploadfile;

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

public class FileUploadInSelenium {
	
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
	
	public void validate_file() throws InterruptedException
	{
		WebElement file_upload=driver.findElement(By.id("uploadfile_0"));
		file_upload.sendKeys(file_path);
		
		Thread.sleep(3000);
		driver.findElement(By.id("terms")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.id("submitbutton")).click();
	}
	
	public static void main(String[] args) throws InterruptedException, IOException {
		
		FileUploadInSelenium f=new FileUploadInSelenium();
		f.setup_chrome();
		f.validate_file();
	}
}