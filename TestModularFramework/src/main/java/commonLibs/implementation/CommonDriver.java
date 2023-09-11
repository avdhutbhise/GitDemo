package commonLibs.implementation;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonDriver {
	
	private WebDriver driver;
	private ChromeOptions options;
	private FirefoxOptions foptions;
	private int elementLocateTime;
	
	public CommonDriver(String browserType) throws Exception
	{
		if(browserType.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			options=new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver=new ChromeDriver(options);
		}
		else if(browserType.equalsIgnoreCase("mozilla"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else
		{
			throw new Exception("Invalid Browser Type");
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	public WebDriver getDriver()
	{
		return driver;
	}

	public String getTitle()
	{
		String title=driver.getTitle();
		return title;
	}
	
	public void closeBrowser() throws Exception
	{
		if(driver!=null)
		{
			driver.close();
		}
		
	}
	
	public void closeAllBrowser() throws Exception
	{
		if(driver!=null)
		{
			driver.quit();
		}
	}
	
	public void setElementLocatedTime(int elementLocateTime)
	{
		this.elementLocateTime=elementLocateTime;
	}
	public void navigateToURL(String url) throws Exception
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(elementLocateTime));
		driver.get(url);
	}
}



