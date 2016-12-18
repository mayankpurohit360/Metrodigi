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
	/**
	 * @description This method is used to Delete Project from Collection
	 * @return none
	 */
    public void DeleteProject(){
	      try{
	          String Deleteproject = homepageLocator.getLocator("Homepage.Deleteprojectbutton");
	          String ConfirmDelete = homepageLocator.getLocator("Homepage.Confirmdelete");
	          WaitForElementPresent(Deleteproject, 10);
	          clickOn(Deleteproject);
	          Reporter.log("Click on Delete Project button:"+Deleteproject, true);
	          WaitForElementPresent(ConfirmDelete, 10);
	          clickOn(ConfirmDelete);
	          Reporter.log("Click on Confirm Delete button:"+ConfirmDelete, true);
	          isElementPresent(ConfirmDelete);
	          Thread.sleep(10000);
	          }catch (Exception e) {
	            e.printStackTrace();
              }
	      }
	/**
	 * @description This method is used to Delete Collection from application
	 * @return none
	 */
    public void DeleteCollection(){
    	try{
    	    String Deletecollection = homepageLocator.getLocator("Homepage.Deletecollection");
    	    String Confirmdeletecollection = homepageLocator.getLocator("Homepage.ConfirmDeletecollection");
    	    WaitForElementPresent(Deletecollection, 10);
	        clickOn(Deletecollection);
	        Reporter.log("Click on Delete Collection Project button:"+Deletecollection, true);
	        WaitForElementPresent(Confirmdeletecollection, 10);
	        clickOn(Confirmdeletecollection);
	        Reporter.log("Click on Confirm Delete Collection button:"+Confirmdeletecollection, true);
	        isElementPresent(Confirmdeletecollection);
	        Thread.sleep(10000);
    	}catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
	 * @description This method is used to Open Project
	 * @return none
	 */
	public void Openproject()
	{
		try{
			String openproject = homepageLocator.getLocator("Homepage.ClickonProject");
			WaitForElementNotPresent(openproject, 20);
			clickOn(openproject);
			Reporter.log("Click on New Project:", true);
			Thread.sleep(50000);
		}catch (Exception e) {
            e.printStackTrace();
        }
	}
    
    /**
	 * @description This method is used to Open Existing Collection from application
	 * @return none
	 */
    
    public void OpenExistingCollection(){
    	try{
    		String Opencollection = homepageLocator.getLocator("Homepage.ClickonCollection");
    		clickOn(Opencollection);
    		Thread.sleep(10000);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }
}
