package calendarinselenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CalendarInSelenium {
	
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
		driver.get("https://demoqa.com/date-picker");
	}
	
	public void validate_calendar() throws InterruptedException
	{
		driver.findElement(By.id("datePickerMonthYearInput")).click();
		
		Thread.sleep(3000);
		WebElement sel_year=driver.findElement(By.className("react-datepicker__year-select"));
		Select s_year=new Select(sel_year);
		s_year.selectByVisibleText("2010");
		
		Thread.sleep(3000);
		WebElement sel_month=driver.findElement(By.className("react-datepicker__month-select"));
		Select s_month=new Select(sel_month);
		s_month.selectByVisibleText("June");
		
		Thread.sleep(3000);
		WebElement day=driver.findElement(By.xpath("//div[@class='react-datepicker__day react-datepicker__day--024']"));
		day.click();
		
	}
	
	public static void main(String[] args) throws InterruptedException, IOException {
		
		CalendarInSelenium f=new CalendarInSelenium();
		f.setup_chrome();
		f.validate_calendar();
	}
}