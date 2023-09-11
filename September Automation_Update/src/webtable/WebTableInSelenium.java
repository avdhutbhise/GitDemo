package webtable;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebTableInSelenium {
	
	WebDriver driver;
	public void setup_chrome()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ip-slim-3\\eclipse-workspace\\DCTC DEC-21\\September Automation\\Driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/web-table-element.php");
	}
	
	public void display_table() throws InterruptedException
	{
		List<WebElement> table = driver.findElements(By.xpath("//table[@class='dataTable']//tbody//tr"));
		System.out.println("Displayed Table");
		
		for(WebElement x:table)
		{
			String comp_name=x.findElement(By.xpath("td[1]")).getText();
			String curr_price=x.findElement(By.xpath("td[4]")).getText();
			
			if(comp_name.contains("Paints"))
			{
				System.out.println(comp_name+" : "+curr_price);
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		WebTableInSelenium wt=new WebTableInSelenium();
		wt.setup_chrome();
		wt.display_table();
	}

}
