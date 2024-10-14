package com.city.mbd.Utility;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.citi.mbd.TestCases.BaseClass;

public class Reporting extends TestListenerAdapter {
	
	public ExtentSparkReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	
	//public WebDriver ldriver;
	
	BaseClass bc;
	ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();
	
	public void onStart(ITestContext testContext) {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repName="Test-Report-"+timeStamp+".html";
		//String repName="Test-Report.html";
		
		htmlReporter=new ExtentSparkReporter(System.getProperty("user.dir")+ "/test-output/"+repName);
		try {
			htmlReporter.loadXMLConfig(System.getProperty("user.dir")+ "/extent-config.xml/");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("user", "vinay");
		
		htmlReporter.config().setDocumentTitle("Business Planning");
		htmlReporter.config().setReportName("Functional Test Automation Report");
		htmlReporter.config().setTheme(Theme.DARK);
		
	}
	
	public void onTestSuccess(ITestResult tr) {
		logger=extent.createTest(tr.getName());
		extentTest.set(logger);
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
	}
	
	public void onTestFailure(ITestResult tr){
//        String screenShotName = tr.getName() + waitElement.uniqStr();
//        System.out.println("********"+ screenShotName);
//		try {
//			bc.captureScreen(BaseClass.driver, screenShotName);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
       // captureScreen(driver, uniqStr().concat("GCFileUploadLoop"));
        
		
		logger=extent.createTest(tr.getName());//create new entry in the report
		
		
		//BaseClass testClassObj = (BaseClass)tr.getInstance();
		
		
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED)); //send the passed infor to report with red highlighted color
		logger.log(Status.FAIL, tr.getThrowable());
		
		
		//String dateName =  new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		
		
		String screenshotpath=System.getProperty("user.dir"+"\\Screenshots\\")+tr.getName()+ BaseClass.getCounter() + ".png";
		//String screenshotpath=System.getProperty("user.dir")+"\\Screenshots\\"+screenShotName + ".png";
		
		System.out.println("screenshotPath value from Reporting class -- "+screenshotpath);
		
		File f = new File(screenshotpath);
		
		if(f.exists()) {
			System.out.println("File Exist" + f);
			logger.fail("Screenshot is below:" +logger.addScreenCaptureFromPath(screenshotpath));
		}
		
	}
	
	public void onTestSkipped(ITestResult tr) {
		logger=extent.createTest(tr.getName());//create new entry in report
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
	}
	
	public void onFinish(ITestContext testContext) {
		extent.flush();
	}
	
	public static String getScreenShot(WebDriver driver, String screenshotName) throws IOException {
		String dateName =  new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		String destination = System.getProperty("user.dir")+ "/Screenshots/"+ screenshotName + dateName + ".png";
		File finalDest = new File(destination);
		FileUtils.copyFile(source, finalDest);
		return destination;
	}

}