package actionsinselenium;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class ActionsInSelenium {
	
	WebDriver driver;
	String path="";
	String actual_path="";
	
	public void setup_chrome()
	{
		path=System.getProperty("user.dir");
		actual_path=path+"\\Driver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", actual_path);
		
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		
		driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/test/simple_context_menu.html");
	}
	
	public void actions_methods() throws InterruptedException
	{
		WebElement btn_right_click=driver.findElement(By.xpath("//span[contains(text(),'right click me')]"));
		
		Actions ac=new Actions(driver);
		ac.moveToElement(btn_right_click).contextClick().build().perform();		//right click 
		
		Thread.sleep(3000);
		WebElement li_edit=driver.findElement(By.xpath("//span[contains(text(),'Edit')]"));
		//li_edit.click();
		ac.moveToElement(li_edit).click().build().perform();					//simple click
		
		Alert x=driver.switchTo().alert();
		Thread.sleep(3000);
		System.out.println(x.getText());
		x.accept();
		
		WebElement btn_double_click=driver.findElement(By.xpath("//button[contains(text(),'Double-Click Me To See Alert')]"));
		ac.moveToElement(btn_double_click).doubleClick().build().perform();		//double click
		
		x=driver.switchTo().alert();
		Thread.sleep(3000);
		System.out.println(x.getText());
		x.accept();
		
	}
	
	public static void main(String[] args) throws InterruptedException, IOException {
		
		ActionsInSelenium a=new ActionsInSelenium();
		a.setup_chrome();
		a.actions_methods();
	}
}