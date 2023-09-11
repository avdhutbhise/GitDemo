package propertiesinjava;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WritePropertiesInSelenium {
	
	WebDriver driver;
	String path="";
	String actual_path="";
	String file_path="";
	String url="";
	String search_text="";
	public void write_properties_file() throws IOException
	{
		path=System.getProperty("user.dir");		
		file_path=path+"\\Resource\\Test_update.properties";
		
		//Providing File for Writing Purpose
		File f=new File(file_path);
		FileOutputStream fout=new FileOutputStream(f);
		
		//loading file in properties
		Properties p=new Properties();
		p.setProperty("userid", "vinay@test.com");
		p.setProperty("password", "Test@1234567890");
		p.store(fout, "updated userID and Password");
		System.out.println("File is processed");
		
	}
	
	public static void main(String[] args) throws InterruptedException, IOException {
		
		WritePropertiesInSelenium n=new WritePropertiesInSelenium();
		n.write_properties_file();
	}

}
