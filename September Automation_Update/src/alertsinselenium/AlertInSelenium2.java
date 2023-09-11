package alertsinselenium;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertInSelenium2 {
	
	WebDriver driver;
	public void setup_chrome()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ip-slim-3\\eclipse-workspace\\DCTC DEC-21\\September Automation\\Driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/alerts");
	}
	
	public void validate_alert() throws InterruptedException
	{
		driver.findElement(By.id("promtButton")).click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		
		Alert a3=driver.switchTo().alert();
		a3.sendKeys("Automation Testing");
		Thread.sleep(3000);
		a3.accept();
				
		driver.findElement(By.id("timerAlertButton")).click();
		wait.until(ExpectedConditions.alertIsPresent());
		a3=driver.switchTo().alert();
		Thread.sleep(3000);
		a3.accept();
		
	
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		AlertInSelenium2 ais=new AlertInSelenium2();
		ais.setup_chrome();
		ais.validate_alert();
	}

}
