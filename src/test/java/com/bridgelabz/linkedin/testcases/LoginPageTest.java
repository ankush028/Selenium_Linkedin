package com.bridgelabz.linkedin.testcases;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.bridgelabz.linkedin.base.BaseClass;
import com.bridgelabz.linkedin.pages.Login;
import com.bridgelabz.linkedin.util.ReadExcel;

import atu.testrecorder.exceptions.ATUTestRecorderException;

public class LoginPageTest extends BaseClass{
	
	public LoginPageTest() {
		super(); 
	}
	
	
	Login login;
	
	@BeforeMethod
	public void setUp() {		
		initialization();
		login = new Login();
	}
	
	@DataProvider(name= "login")
	public Object[][] loginData(){
		Object[][] data =ReadExcel.getData("Login");
		return data;
	}
	
	
	@Test(dataProvider = "login")
	public void loginTest(String username,String password) {
		login.login(username,password);
	}
	
	@AfterMethod
	public void tearDown() throws ATUTestRecorderException {
		recorder.stop();
		driver.quit();
	
	}
}
