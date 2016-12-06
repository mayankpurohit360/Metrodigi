/*==============================================================================================================================
 File Name    : LoginPageHelper.java
 ClassName    : LoginPageHelper
 Summary      : Contains methods of Login Page.
 ===============================================================================================================================
 History      :   Company            Created By     
                  360logica                         

 ===============================================================================================================================
 Remarks      :   Tests - 
 ===============================================================================================================================*/

package com.Metrodigi.pagehelper;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.Metrodigi.locators.LocatorReader;
import com.Metrodigi.util.DriverHelper;
import com.Metrodigi.util.PropertyReader;

public class LoginPageHelper extends DriverHelper 
{
	public LocatorReader loginpageLocator;	

	int random= this.getRandomInteger(1, 99999);
	PropertyReader propertyReader = new PropertyReader();
	public LoginPageHelper(WebDriver driver) {
		super(driver);
		loginpageLocator = new LocatorReader("LoginPage.xml");
	}

	
	/**
	 * @description This method is used to perform login to the application
	 * @author 360logica
	 * @param username
	 * @param password
	 * @return none
	 */
	 public void Login (String username, String password) {
		 try {
		 String usernametextbox = loginpageLocator.getLocator("Login.UserName");
		 String passwordtextbox = loginpageLocator.getLocator("Login.Password");
		 String loginbutton = loginpageLocator.getLocator("Login.LoginButton");
		 WaitForElementPresent(loginbutton, 30);
		 sendKeys(usernametextbox, username);
		 Reporter.log("Enter username '"+username+"' into username text box '"+usernametextbox+"'", true);
		 sendKeys(passwordtextbox, password);
		 Reporter.log("Enter password '"+password+"' into password text box '"+passwordtextbox+"'", true);
		 clickOn(loginbutton);
		 Reporter.log("Click on Log in button:"+loginbutton, true);
		 WaitForElementNotPresent(loginbutton, 80);
		 } catch (Exception e) {
			 e.printStackTrace();
		 }
	 }
}