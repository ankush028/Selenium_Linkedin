package com.bridgelabz.linkedin.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bridgelabz.linkedin.base.BaseClass;
import com.bridgelabz.linkedin.pages.HomePage;
import com.bridgelabz.linkedin.pages.JoinNowPage;

public class JoinNowPageTest extends BaseClass{
	JoinNowPage joinnow;
	 public JoinNowPageTest() {
		super();
	} 
	
	@BeforeMethod
	public void setUp() {
		initialization();
		joinnow= new JoinNowPage();
	}
	
	@Test(priority = 1)
	public void joinNowTest() {
		HomePage home =joinnow.JoinNow(property.getProperty("first"), property.getProperty("last"),
				property.getProperty("email"),property.getProperty("password"));
		
		System.out.println(home);
	}
	@Test(priority = 2)
	public void privacypolicyTest() throws InterruptedException {
		joinnow.privacypolicy();
	}
	@Test(priority = 3)
	public void cookie() {
		joinnow.cookie();
	}
	@Test(priority = 4)
	public void userAgreementTest() {
		joinnow.userAgreement();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
