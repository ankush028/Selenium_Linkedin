package com.bridgelabz.linkedin.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import com.bridgelabz.linkedin.base.BaseClass;
import com.bridgelabz.linkedin.pages.Login;
import com.bridgelabz.linkedin.pages.UploadProfile;
import com.bridgelabz.linkedin.util.CustomListener;

@Listeners(CustomListener.class)
public class UploadProfileTest extends BaseClass{
	
	
	public UploadProfile upload;
	
	@BeforeMethod
	public void setUp() {
		initialization();
		Login login = new Login();
		login.login(property.getProperty("username"),property.getProperty("password"));
		upload = new UploadProfile();
	}
	
	public void uploadImage() throws InterruptedException {
		upload.addProfile();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
