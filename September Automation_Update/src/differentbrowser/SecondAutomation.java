package differentbrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SecondAutomation {

	
	WebDriver driver;
	
	public void setup_chrome()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ip-slim-3\\eclipse-workspace\\DCTC DEC-21\\September Automation\\Driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.close();
	}
	
	public void setup_firefox()
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\ip-slim-3\\eclipse-workspace\\DCTC DEC-21\\September Automation\\Driver\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.close();
	}
	
	public void setup_edge()
	{
		System.setProperty("webdriver.edge.driver", "C:\\Users\\ip-slim-3\\eclipse-workspace\\DCTC DEC-21\\September Automation\\Driver\\msedgedriver.exe");
		driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.close();
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SecondAutomation f=new SecondAutomation();
		f.setup_chrome();
		f.setup_edge();
		f.setup_firefox();
	}

}
