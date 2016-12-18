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

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.Metrodigi.locators.LocatorReader;
import com.Metrodigi.util.DriverHelper;
import com.Metrodigi.util.PropertyReader;

public class EditProjectsHelper extends DriverHelper 
{
	public LocatorReader editprojectsLocator;	

	int random= this.getRandomInteger(1, 99999);
	PropertyReader propertyReader = new PropertyReader();
	public EditProjectsHelper(WebDriver driver)
	{
		super(driver);
		editprojectsLocator = new LocatorReader("EditProjects.xml");
	}
	/**
	 * @description This method is used to Edit Collection Details to the application
	 * @return none
	 */
	public String NewCollection() {
		String collectionname = null; 
		try {
		 String CollectionName = editprojectsLocator.getLocator("EditProjects.Collection.CollectionName");
		 collectionname = propertyReader.readApplicationFile("Collectionname1")+String.valueOf(getRandomInteger(1,999));
		 String AddProjectButton = editprojectsLocator.getLocator("EditProjects.Collection.AddProjectButton");
		 sendKeys(CollectionName, collectionname);
		 WaitForElementNotPresent(AddProjectButton, 20);
		 Reporter.log("New Collection Name is :"+collectionname, true);
		 String savebutton = editprojectsLocator.getLocator("EditProjects.NewProject.Savebutton");
		 clickOn(savebutton);
		}catch (Exception e) {
			 e.printStackTrace();
		 } return collectionname;
	}
	/**
	 * @description This method is used to Add Collection details
	 * @return none
	 */
	public String CollectionDetails () {
		String collectionname = null; 
		try {
		 String CollectionName = editprojectsLocator.getLocator("EditProjects.Collection.CollectionName");
		 collectionname = propertyReader.readApplicationFile("Collectionname1")+String.valueOf(getRandomInteger(1,999));
		 String AddProjectButton = editprojectsLocator.getLocator("EditProjects.Collection.AddProjectButton");
		 sendKeys(CollectionName, collectionname);
		 WaitForElementNotPresent(AddProjectButton, 20);
		 Reporter.log("New Collection Name is :"+collectionname, true);
		 clickOn(AddProjectButton);
		 Reporter.log("Click on Add Project button:"+AddProjectButton, true);
		 WaitForElementNotPresent(AddProjectButton, 10);
		 } catch (Exception e) {
			 e.printStackTrace();
		 } return collectionname;
	}
	/**
	 * @description This method is used to click on Add Project button
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
		 {
			 String projectName = null;
			 try{
				 //Click on Reflowable button
				 
				 String reflowable = editprojectsLocator.getLocator("EditProjects.NewProject.Reflowable");
				 //WaitForElementNotPresent(reflowable, 20);
				 clickOn(reflowable);
				 Reporter.log("Click on Reflowable radio button:"+reflowable, true);
				 
				 /*
				  Click on Fixed layout radio button
				 String fixedlayout = editprojectsLocator.getLocator("EditProjects.NewProject.Fixedlayout");
				 clickOn(reflowable);
				 Reporter.log("Click on fixedlayout radio button:"+fixedlayout, true);*/
				 
				 // Click on Do you have files to convert? Yes or No radio button
				 
				 /*String yes = editprojectsLocator.getLocator("EditProjects.NewProject.Yes");
				 clickOn(yes);
				 Reporter.log("Click on Yes radio button:"+yes, true);
				 */
				 String no = editprojectsLocator.getLocator("EditProjects.NewProject.No");
				 clickOn(no);	
				 Reporter.log("Click on No radio button:"+no, true);
				 				 
				 //Add Project Details
				 
				 String Projectname = editprojectsLocator.getLocator("EditProjects.NewProject.ProjectName");								 
				 projectName = propertyReader.readApplicationFile("Projectname1")+String.valueOf(getRandomInteger(1,999));
				 sendKeys(Projectname, projectName);
				 Reporter.log("New Project Name is :"+projectName, true);
				 
			 }catch (Exception e) {
				 e.printStackTrace();
			 }return projectName;
		 }
		 /**
			 * @description This method is used to upload document file
			 * @return none
			 */
			 public void uploaddocument()
			 {  try{
				 String locatefiles = editprojectsLocator.getLocator("EditProjects.NewProject.LocateFilesButton");
			     String savebutton = editprojectsLocator.getLocator("EditProjects.NewProject.Savebutton");	 
			 // Upload Files
				 clickOn(locatefiles);
				 uploadDocxfile();
				 //waitForElementLoad(50);
				 WaitForElementNotPresent(savebutton, 50);
				 
				 //Click on Save Button
				 clickOn(savebutton);
				 Reporter.log("Click on Save button is :"+savebutton, true);
				 Thread.sleep(90000);
			 }catch (Exception e) {
				 e.printStackTrace();
			 }
		 }
			 /**
				 * @description This method is used to upload media files
				 * @return none
				 */
			 public void uploadmedia()
			 {  try{
				 String locatefiles = editprojectsLocator.getLocator("EditProjects.NewProject.LocateFilesButton");
			     String savebutton = editprojectsLocator.getLocator("EditProjects.NewProject.Savebutton");	 
			     // Upload Files
				 clickOn(locatefiles);
				 uploadAudiofile();
				 clickOn(locatefiles);
				 uploadimagefile();
				 clickOn(locatefiles);
				 uploadVideofile();
				 //waitForElementLoad(50);
				 WaitForElementNotPresent(savebutton, 50);
				 
				 //Click on Save Button
				 clickOn(savebutton);
				 Reporter.log("Click on Save button is :"+savebutton, true);
				 Thread.sleep(80000);
			 }catch (Exception e) {
				 e.printStackTrace();
			 }
		 }
}



