package com.bridgelabz.linkedin.testcases;



import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bridgelabz.linkedin.base.BaseClass;
import com.bridgelabz.linkedin.pages.HomePage;
import com.bridgelabz.linkedin.pages.Login;

public class LoginPageTest extends BaseClass{
	
	public LoginPageTest() {
		super(); 
	}
	
	
	Login login;
	HomePage homePage;
	
	@BeforeMethod
	public void setUp() {		
		initialization();
		login = new Login();
	}
	
//	@Test(priority = 1)
//	public void loginPageTitleTest() {
//		String title =login.getLoginPageTitle();
//		assertEquals(title,property.get("expected"));
//	}
	@Test(priority = 1)
	public void loginTest() {
		
		homePage =login.login(property.getProperty("username"),property.getProperty("password"));
		System.out.println(homePage);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
