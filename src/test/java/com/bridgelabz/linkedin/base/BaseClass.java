package com.bridgelabz.linkedin.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.bridgelabz.linkedin.util.Utility;
//import atu.testrecorder.ATUTestRecorder;


/**
 * @author Ankush Kumar Agrawal
 *@purpose 
 */
public class BaseClass {

	public static WebDriver driver;
	public static Properties property;
	public static JavascriptExecutor js;
//	public static ATUTestRecorder recorder;
	
		/**
		 * @Constructor
		 * @Motive To load the config.properties file 
		 */
		public BaseClass()  {
			property = new Properties();
			FileInputStream fis;
			try {
				fis = new FileInputStream(
						"/home/admin1/Desktop/JavaAdvanced/Linkedin/src/test/java/com/bridgelabz/linkedin/repository/config.properties");
				property.load(fis);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}				

	/**
	 * @Purpose  Open browser with sepecific operations
	 */
	public static void initialization(){
		String browsername =property.getProperty("browser");
		if(browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"/home/admin1/Desktop/SeleniumDriver/chromedriver_linux64/chromedriver");
			driver = new ChromeDriver();
	
			
			
//	
//			DateFormat dateFormat = new SimpleDateFormat("yy-mm-dd HH-mm-ss");
//			Date date = new Date();
//			try {
//				recorder = new ATUTestRecorder("/home/admin1/Desktop/JavaAdvanced/Linkedin/TestRecording/","Test-"+dateFormat.format(date),false);
//				recorder.start();
//			} catch (ATUTestRecorderException e) {
//				e.printStackTrace();
//			}
//	
			js = (JavascriptExecutor) driver;
		}else {
			System.out.println(property.getProperty("invalid"));
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Utility.pageLoad,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Utility.implicit,TimeUnit.SECONDS);		
		driver.get(property.getProperty("url"));
	}
	
	
	
}
