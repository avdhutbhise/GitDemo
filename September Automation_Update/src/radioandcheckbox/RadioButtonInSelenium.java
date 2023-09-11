package radioandcheckbox;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtonInSelenium {

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
		driver.get("https://demo.guru99.com/test/radio.html");
	}
	
	public void validate_radio() throws InterruptedException
	{
		WebElement radio_opt1=driver.findElement(By.id("vfb-7-1"));
		System.out.println(radio_opt1.getAttribute("value"));
		radio_opt1.click();
		
		Thread.sleep(3000);
		driver.findElement(By.id("vfb-7-2")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.id("vfb-7-3")).click();
	}

	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		RadioButtonInSelenium r1=new RadioButtonInSelenium();
		r1.setup_chrome();
		r1.validate_radio();
	}

}
