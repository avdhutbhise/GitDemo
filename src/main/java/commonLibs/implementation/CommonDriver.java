package commonLibs.implementation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonDriver {

	private FirefoxOptions foptions;
	private ChromeOptions options;
	private WebDriver driver;
	private int pageloadTimeout;
	private int elementDetectionTimeout;
	
	public CommonDriver(String browserType) throws Exception {

		pageloadTimeout = 60;
		elementDetectionTimeout = 10;
		
		
		if (browserType.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			options=new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);
		} else if (browserType.equalsIgnoreCase("mozilla")) {
			
			WebDriverManager.firefoxdriver().setup();
			//foptions=new FirefoxOptions();
			//foptions.addArguments("--remote-allow-origins=*");
			driver=new FirefoxDriver();
			
		} else {
			throw new Exception("Invalid Browser Type");
		}

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setPageloadTimeout(int pageloadTimeout) {
		this.pageloadTimeout = pageloadTimeout;
	}

	public void setElementDetectionTimeout(int elementDetectionTimeout) {
		this.elementDetectionTimeout = elementDetectionTimeout;
	}

	
	public void navigateToFirstUrl(String url) throws Exception {

		driver.manage().timeouts().pageLoadTimeout(pageloadTimeout, TimeUnit.SECONDS);

		driver.manage().timeouts().implicitlyWait(elementDetectionTimeout, TimeUnit.SECONDS);

		url = url.trim();

		driver.get(url);

	}

	
	public String getTitle() throws Exception {
		String title = driver.getTitle();
		return title;
	}

	
	public String getCurrentUrl() throws Exception {

		return driver.getCurrentUrl();
	}

	
	public String getPageSource() throws Exception {

		return driver.getPageSource();
	}

	
	public void navigateToUrl(String url) throws Exception {

		url = url.trim();
		driver.navigate().to(url);

	}

	
	public void navigateForward() throws Exception {
		driver.navigate().forward();

	}

	
	public void navigateBackward() throws Exception {
		driver.navigate().back();

	}

	
	public void refresh() throws Exception {
		driver.navigate().refresh();

	}

	
	public void closeBrowser() throws Exception {

		if (driver != null) {
			driver.close();

		}
	}

	
	public void closeAllBrowsers() throws Exception {
		if (driver != null) {
			driver.quit();
		}

	}


}
