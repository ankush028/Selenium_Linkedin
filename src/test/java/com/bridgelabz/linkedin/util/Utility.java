package com.bridgelabz.linkedin.util;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 * @author Ankush Kumar Agrawal
 *@purpose Reusable methods 
 */
public class Utility {
	
	/**
	 * @declaration page load time
	 */
	public static final long pageLoad=30;
	
	/**
	 * @declaration implicit time
	 */
	public static final long implicit =20;
	

	/**
	 * @purpose To upload items from System to application
	 * @param path
	 * @return Clipboard
	 */
	public static Clipboard uploadItems(String path) {
		StringSelection strsel = new StringSelection(path);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(strsel,null);
		Robot robot;
		try {
			robot = new Robot();
			robot.delay(1000);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);	
			robot.keyRelease(KeyEvent.VK_ENTER);	
			robot.delay(1000);
		} catch (AWTException e) {
			e.printStackTrace();
		}	
		return clipboard;
	}
	
	/**
	 * @purpose To take screen shot of test cases
	 * @param driver
	 * @param screenShotName
	 */
	public static void captureScreenShot(WebDriver driver,String screenShotName) {
			
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);	
		try {
			FileUtils.copyFile(src,new File("/home/admin1/Desktop/JavaAdvanced/"
					+ "Linkedin/FailedTestScreenShot"+"/"+screenShotName+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
}
