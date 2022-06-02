package com.automation.utility;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Base {
	
	protected WebDriver driver;
	protected static ExtentReports extent;
	protected static ExtentTest logger;
	
	
	public WebDriver initializeDriver() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\java\\com\\automation\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		return driver;
	}
	
	public String GetScreenshotPath(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationPath = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
		File file = new File(destinationPath);
					
		FileUtils.copyFile(source, file);
		return destinationPath;
	}
	
	
	@BeforeSuite
	public static void InitializeReport() throws IOException {
		
		InetAddress addr;
	    addr = InetAddress.getLocalHost();
	    String hostname = addr.getHostName();
	    
		extent = new ExtentReports(System.getProperty("user.dir") + "/test-output/x-tent/" + TestConfigUtil.GenerateTimeStamp() + ".html",true);
		extent.addSystemInfo("Host Name", hostname)
						 .addSystemInfo("Environment", TestConfigUtil.GetConfigValue("ENVIRONMENT"))
						 .addSystemInfo("User Name", System.getProperty("user.name"));
		extent.loadConfig(new File(System.getProperty("user.dir") + "\\extent-config.xml"));
		
		
	}
	
	@AfterSuite
	public void GenerateReport() {
		extent.flush();
		extent.close();
	}

}
