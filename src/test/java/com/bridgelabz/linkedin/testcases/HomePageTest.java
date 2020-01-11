package com.bridgelabz.linkedin.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.bridgelabz.linkedin.base.BaseClass;
import com.bridgelabz.linkedin.pages.HomePage;
import com.bridgelabz.linkedin.pages.Login;
import com.bridgelabz.linkedin.util.CustomListener;

/**
 * @author Ankush kumar agrawal
 * @purpose To test the Home page functionality
 *
 */
@Listeners(CustomListener.class)
public class HomePageTest extends BaseClass{
	Login login;
	HomePage homePage;
	
	/**
	 * @Constructor
	 */
	public HomePageTest() {
		super();
	}
	
	/**
	 * @purpose this method will execute before every methods
	 */
	@BeforeMethod
	public void setUp() {
		initialization();
		login = new Login();
		login.login(property.getProperty("username"),property.getProperty("password"));
		homePage = new HomePage();
	}
	
	/**
	 * @throws InterruptedException
	 */
//	@Test(priority = 1)
	public void createImagePostTest() throws InterruptedException   {
	   homePage.imagePostStory(property.getProperty("imageStory"));
	   Thread.sleep(4000);
	}
	
	/**
	 * @throws InterruptedException
	 */
//	@Test(priority = 2)
	public void createVideoPostTest() throws InterruptedException {
		homePage.videoPostStory(property.getProperty("videoStory"));
	}
	
	/**
	 * @throws InterruptedException
	 */
//	@Test(priority = 3)
	public void createDocumentPostTest() throws InterruptedException {
		homePage.documentPostStory(property.getProperty("postTitle"),property.getProperty("docTitle"));
	}
	
	
	/**
	 * @purpose this method will execute after every method sucessfully done
	 */
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
