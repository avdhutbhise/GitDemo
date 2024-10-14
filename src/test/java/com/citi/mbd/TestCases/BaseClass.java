package com.citi.mbd.TestCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;

import com.city.mbd.Utility.ReadConfig;


public class BaseClass {
	
	public static WebDriver driver;
	public static Logger log;
	
	ReadConfig readconfig = new ReadConfig();
	
	public String baseURL=readconfig.getApplicationURL();
	public String username=readconfig.getUserName();
	public String password=readconfig.getPassword();
	
	/*public String planName=readconfig.getPlanName();
	public String gcFileLoc=readconfig.getGCFileLoc();
	public String rdmFileLoc=readconfig.getRDMFileLoc();
	public String vintageFileLoc=readconfig.getVintageFileLoc();
	public String nodeStr=readconfig.getNodeStr();
	public String appFrom=readconfig.getAppFrom();
	public String appTo=readconfig.getAppTo();
	public String manGeo=readconfig.getManGeo();
	public String manSeg=readconfig.getManSeg();
	public String treasuryDrpDwnValue=readconfig.getTreasDrpDwnVal();
	public String initiativeFileLoc=readconfig.getInitiativeFileLoc();
	public String dataFilePath=readconfig.getDataFilePath();
	public String downloadPath=readconfig.getDownloadPath();
	*/
	
	private static int counter = 0;

	public static int getCounter() {
		return counter;
	}

	public static void setCounter(int counter) {
		BaseClass.counter = counter;
	}

	
	
	@BeforeTest(alwaysRun = true, groups = { "sanity", "regression" })
	public void setup() {
		
		log = Logger.getLogger("TestEclipseMaven");
		PropertyConfigurator.configure("log4j.properties");

		// File scrSht=new File(System.getProperty("user.dir")+"/Screenshots/");

		/*
		 * try { FileUtils.cleanDirectory(scrSht);
		 * 
		 * } catch (Exception e) { // TODO: handle exception e.printStackTrace(); }
		 */
		// if(br.equals("chrome"))
		// {
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popus", 0);
		chromePrefs.put("profile.default_content_settings.exceptions.automatioc_downloads.*.setting", 1);

		ChromeOptions coptions = new ChromeOptions();
		coptions.setExperimentalOption("prefs", chromePrefs);
		coptions.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		coptions.addArguments("--remote-allow-origins=*");

		System.setProperty("web.chrome.driver", "D:\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		coptions.addArguments("start-maximized");

		driver = new ChromeDriver(coptions);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// }
	}

	@AfterClass()
	public void tearDown() {
		System.out.println("Application Tear Down");
	}

	/*
	 * public void captureScreen(WebDriver driver, String tname) throws IOException{
	 * 
	 * //String dateName = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new
	 * Date()); TakesScreenshot ts = (TakesScreenshot) driver; File source =
	 * ts.getScreenshotAs(OutputType.FILE); //File target = new
	 * File(System.getProperty("user.dir")+ "/Screenshots/"+ tname + dateName +
	 * ".png");
	 * 
	 * File target = new File(System.getProperty("user.dir")+ "/Screenshots/"+ tname
	 * + ".png");
	 * //System.out.println("screenshotPath value from Reporting class -- "
	 * +screenshotpath);
	 * 
	 * FileUtils.copyFile(source, target); System.out.println("Screenshot taken"); }
	 */

}
