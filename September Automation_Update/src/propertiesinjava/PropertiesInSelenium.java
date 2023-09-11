package propertiesinjava;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PropertiesInSelenium {
	
	WebDriver driver;
	String path="";
	String actual_path="";
	String file_path="";
	String url="";
	String search_text="";
	public void read_properties_file() throws IOException
	{
		path=System.getProperty("user.dir");
		actual_path=path+"\\Driver\\chromedriver.exe";
		
		file_path=path+"\\Resource\\Test.properties";
		
		//Providing File for Reading Purpose
		File f=new File(file_path);
		FileInputStream fin=new FileInputStream(f);
		
		//loading file in properties
		Properties p=new Properties();
		p.load(fin);
		
		url=p.getProperty("url_qa");
		search_text=p.getProperty("search_text");
		
	}
	
	public void setup_chrome()
	{
		System.setProperty("webdriver.chrome.driver", actual_path);
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		
		WebElement search=driver.findElement(By.name("q"));
		search.sendKeys(search_text);
		search.sendKeys(Keys.ENTER);
	}
	
	
	
	public static void main(String[] args) throws InterruptedException, IOException {
		
		PropertiesInSelenium n=new PropertiesInSelenium();
		n.read_properties_file();
		n.setup_chrome();
	}

}
