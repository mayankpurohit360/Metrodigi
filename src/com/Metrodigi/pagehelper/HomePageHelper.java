/*==============================================================================================================================
 File Name    : HomePageHelper.java
 ClassName    : HomePageHelper
 Summary      : Contains methods of Home Page.
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

public class HomePageHelper extends DriverHelper 
{
	public LocatorReader homepageLocator;	

	int random= this.getRandomInteger(1, 99999);
	PropertyReader propertyReader = new PropertyReader();
	public HomePageHelper(WebDriver driver)
	{
		super(driver);
		homepageLocator = new LocatorReader("HomePage.xml");
	}
	/**
	 * @description This method is used to perform Add New Project to the application
	 * @return none
	 */
	public void AddProject () {
		 try {
		 String Newprojectbutton = homepageLocator.getLocator("Homepage.NewProjectButton");
		 WaitForElementPresent(Newprojectbutton, 30);
		 clickOn(Newprojectbutton);
		 Reporter.log("Click on New Project in button:"+Newprojectbutton, true);
		 WaitForElementNotPresent(Newprojectbutton, 80);
		 } catch (Exception e) {
			 e.printStackTrace();
		 }
	 }


}
