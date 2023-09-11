package waitsinselenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitInSelenium {

	WebDriver driver;
	public void setup_chrome()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ip-slim-3\\eclipse-workspace\\DCTC DEC-21\\September Automation\\Driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/select-menu");
	}
	
	public void validate_dropdown() throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
		//waiting for correct web page title
		wait.until(ExpectedConditions.titleContains("DEMOQA"));
		
		System.out.println(driver.getTitle());
		
		//waiting for correct visibility of web element
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("oldselectmenu")));
		System.out.println("Condition Satisfied");
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		ExplicitWaitInSelenium d=new ExplicitWaitInSelenium();
		d.setup_chrome();
		d.validate_dropdown();
	}

}
