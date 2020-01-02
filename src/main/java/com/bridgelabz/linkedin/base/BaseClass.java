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

public class BaseClass {

	public static WebDriver driver;
	public static Properties property;
	public static JavascriptExecutor js;
//	public static XSSFSheet excelSheet;
//	public static XSSFWorkbook xWorkBook;
		public BaseClass()  {
			property = new Properties();
			FileInputStream fis;
			try {
				fis = new FileInputStream(
						"/home/admin1/Desktop/JavaAdvanced/Linkedin/src/main/java/com/bridgelabz/linkedin/config/config.properties");
				property.load(fis);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		
	public static void initialization(){
		String browsername =property.getProperty("browser");
		if(browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"/home/admin1/Desktop/SeleniumDriver/chromedriver_linux64/chromedriver");
			driver = new ChromeDriver();
			js = (JavascriptExecutor) driver;
		}else {
			System.out.println("Enter correct Browser name");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Utility.pageLoad,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Utility.implicit,TimeUnit.SECONDS);
		
		driver.get(property.getProperty("url"));
	}
	

}
