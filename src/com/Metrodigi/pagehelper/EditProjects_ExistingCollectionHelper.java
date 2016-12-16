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

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.Metrodigi.locators.LocatorReader;
import com.Metrodigi.util.DriverHelper;
import com.Metrodigi.util.PropertyReader;

public class EditProjects_ExistingCollectionHelper extends DriverHelper 
{
	public LocatorReader editprojectsLocator;	

	int random= this.getRandomInteger(1, 99999);
	PropertyReader propertyReader = new PropertyReader();
	public EditProjects_ExistingCollectionHelper(WebDriver driver)
	{
		super(driver);
		editprojectsLocator = new LocatorReader("EditProjects.xml");
	}
	/**
	 * @description This method is used to Edit Collection Details to the application
	 * @return none
	 */
	public String AddProject() {
		String collectionname = null; 
		try {
		 String AddProjectButton = editprojectsLocator.getLocator("EditProjects.Collection.AddProjectButton");
		 clickOn(AddProjectButton);
		 Reporter.log("Click on Add Project button of existing Collection:"+AddProjectButton, true);
		 		 
		 } catch (Exception e) {
			 e.printStackTrace();
		 } return collectionname;
	}
	/**
	 * @description This method is used to Add New Project with Uploaded file to the application
	 * @return none
	 */
		 public String Newproject()
		 {  String projectName = null;
			 try{
				 JavascriptExecutor js = (JavascriptExecutor) driver;
				 //Click on Reflowable button
			
				   /*Thread.sleep(5000);
				   js.executeScript("document.querySelector('span.type-flo span.dot').click()");
				   Reporter.log("Click on Reflowable radio button:", true);
				   */
								 
				 //Click on Fixed layout radio button
				   Thread.sleep(5000);
				   js.executeScript("document.querySelector('span.type-fix span.dot').click()");
				   Reporter.log("Click on Fixed layout radio button:", true);
				 
				 // Click on Do you have files to convert? Yes or No radio button
				 
				   js.executeScript("document.querySelector('span.yes-import span.dot').click()");
				   Reporter.log("Click on Yes radio button:", true);
				 
				 /*
				   js.executeScript("document.querySelector('span.no-import span.dot').click()");
				   Reporter.log("Click on No radio button:", true);
				 */
				 
				 //Add Project Details
				 
				 String Projectname = editprojectsLocator.getLocator("EditProjects.NewProject.ProjectName");
				 String locatefiles = editprojectsLocator.getLocator("EditProjects.NewProject.LocateFilesButton");
				 String savebutton = editprojectsLocator.getLocator("EditProjects.NewProject.Savebutton");
								 
				 projectName = propertyReader.readApplicationFile("Projectname1")+String.valueOf(getRandomInteger(1,999));
				 sendKeys(Projectname, projectName);
				 Reporter.log("New Project Name is :"+projectName, true);
				 
				 // Upload Files
				 clickOn(locatefiles);
				 uploadDocxfile();
				 //waitForElementLoad(30);
				 WaitForElementNotPresent(savebutton, 30);
				 
				 //Click on Save Button
				 clickOn(savebutton);
				 Reporter.log("Click on Save button is :"+savebutton, true);
				 Thread.sleep(80000);
			 }catch (Exception e) {
				 e.printStackTrace();
			 }return projectName;
	}
}
