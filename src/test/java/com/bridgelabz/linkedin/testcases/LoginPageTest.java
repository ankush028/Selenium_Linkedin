package com.bridgelabz.linkedin.testcases;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.bridgelabz.linkedin.base.BaseClass;
import com.bridgelabz.linkedin.pages.Login;
import com.bridgelabz.linkedin.util.ReadExcel;


public class LoginPageTest extends BaseClass{
	
	/**
	 * @Constructor
	 */
	public LoginPageTest() {
		super(); 
	}	
	Login login;
	
	/**
	 * @purpose Execute first before every method
	 */
	@BeforeMethod
	public void setUp() {		
		initialization();
		login = new Login();
	}
	
	/**
	 * @purpose To provide data from excelsheet to login method
	 * @return data from excel sheet
	 */
	@DataProvider(name= "login")
	public Object[][] loginData(){
		Object[][] data =ReadExcel.getData("Login");
		return data;
	}
	
	
	/**
	 * @purpose To test login functionality
	 * @param username
	 * @param password
	 */
	@Test(dataProvider = "login")
	public void loginTest(String username,String password) {
		login.login(username,password);
	}
	
	/**
	 * @purpose Execute after every method
	 */
	@AfterMethod
	public void tearDown() {
	//	recorder.stop();
		driver.quit();
	
	}
}
