package com.bridgelabz.linkedin.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.bridgelabz.linkedin.base.BaseClass;
import com.bridgelabz.linkedin.pages.HomePage;
import com.bridgelabz.linkedin.pages.Login;

public class HomePageTest extends BaseClass{
	Login login;
	HomePage homePage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		login = new Login();
		login.login(property.getProperty("username"),property.getProperty("password"));
		homePage = new HomePage();
	}
	
	@Test(priority = 1)
	public void createImagePostTest() throws InterruptedException   {
	   homePage.imagePostStory("Selenium Automation Testing learning purpose");
	}
	
	@Test(priority = 2)
	public void createVideoPostTest() throws InterruptedException {
		homePage.videoPostStory("Selenium Automation Testing learning purpose");
	}
	
	@Test(priority = 3)
	public void createDocumentPostTest() throws InterruptedException {
		homePage.documentPostStory("Selenium Automation Testing learning purpose","Selenium learning pdf");
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
