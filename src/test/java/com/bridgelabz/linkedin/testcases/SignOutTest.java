package com.bridgelabz.linkedin.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.bridgelabz.linkedin.base.BaseClass;
import com.bridgelabz.linkedin.pages.Login;
import com.bridgelabz.linkedin.pages.SignOut;
import com.bridgelabz.linkedin.util.CustomListener;

/**
 * @author Ankush Kumar Agrawal
 * @purpose To test Signout functionality
 */


@Listeners(CustomListener.class)
public class SignOutTest extends BaseClass{
	
	Login login;
	SignOut signout ;
	
	public SignOutTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		login  = new Login();
		login.login(property.getProperty("username"),property.getProperty("password"));
		signout = new SignOut();
	}
	
	@Test(priority = 1)
	public void signOutTest() throws InterruptedException {
		signout.signOut();
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
