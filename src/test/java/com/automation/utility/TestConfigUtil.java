package com.automation.utility;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestConfigUtil {

	public static String GetConfigValue(String key) throws IOException {
		Properties prop = new Properties();
		FileInputStream fileInputStream = new FileInputStream(
				System.getProperty("user.dir") + "/src/test/java/com/automation/resources/TestConfig.properties");
		prop.load(fileInputStream);
		return String.valueOf(prop.getProperty(key));

	}

    public static void ClearText(WebElement element) throws InterruptedException {
    	element.click();
    	element.sendKeys(Keys.CONTROL + "a");
    	element.sendKeys(Keys.DELETE);
    	Thread.sleep(1000);
    }

	public static String getScreenshot(WebDriver driver, String screenshotName) throws Exception {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + dateName
				+ ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}
	
	public static String GenerateTimeStamp() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYYMMDD_HHMMSS");
		Date date = new Date();
		return String.valueOf(dateFormat.format(date));
	}
}
