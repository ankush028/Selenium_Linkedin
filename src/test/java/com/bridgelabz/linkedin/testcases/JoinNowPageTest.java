package com.bridgelabz.linkedin.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.bridgelabz.linkedin.base.BaseClass;
import com.bridgelabz.linkedin.pages.HomePage;
import com.bridgelabz.linkedin.pages.JoinNowPage;
import com.bridgelabz.linkedin.util.CustomListener;

/**
 * @purpose To test functionality of JoinNow Registration Page
 * @author Ankush Kumar Agrawal
 *
 */
@Listeners(CustomListener.class)
public class JoinNowPageTest extends BaseClass{
	JoinNowPage joinnow;
	
	 /**
	 * @Constructor
	 */
	public JoinNowPageTest() {
		super();
	} 
	
	/**
	 * @purpose Execute first before every method
	 */
	@BeforeMethod
	public void setUp() {
		initialization();
		joinnow= new JoinNowPage();
	}
	
	/**
	 * @purpose To test registration functionality
	 */
//	@Test(priority = 1)
	public void joinNowTest() {
		HomePage home =joinnow.JoinNow(property.getProperty("first"), property.getProperty("last"),
				property.getProperty("email"),property.getProperty("password"));
		System.out.println(home);
	}
	/**
	 * @purpose To test privacy policy functionality
	 * @throws InterruptedException
	 */
//	@Test(priority = 2)
	public void privacypolicyTest() throws InterruptedException {
		joinnow.privacypolicy();
	}
	/**
	 * @purpose To test cookie functionality
	 * @throws InterruptedException
	 */
//	@Test(priority = 3)
	public void cookie() {
		joinnow.cookie();
	}
	/**
	 * @purpose To test user Agreement functionality
	 * @throws InterruptedException
	 */
//	@Test(priority = 4)
	public void userAgreementTest() {
		joinnow.userAgreement();
	}
	/**
	 * @purpose Execute method after every method
	 * @throws InterruptedException
	 */
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
