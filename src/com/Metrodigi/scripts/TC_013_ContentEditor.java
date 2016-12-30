/*==============================================================================================================================
 File Name    : Demo.java
 ClassName    : Demo
 Summary      : Contains demo test to login.
 ===============================================================================================================================
 History      :   Company            Created By     
                  360logica                         

 ===============================================================================================================================
 Remarks      :   Tests - 
 ===============================================================================================================================*/

package com.Metrodigi.scripts;
import java.lang.reflect.Field;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.Metrodigi.pagehelper.ContentEditorHelper;
import com.Metrodigi.pagehelper.EditProjectsHelper;
import com.Metrodigi.pagehelper.HeaderHelper;
import com.Metrodigi.pagehelper.HomePageHelper;
import com.Metrodigi.pagehelper.LoginPageHelper;
import com.Metrodigi.util.DriverTestCase;


@Test
public class TC_013_ContentEditor extends DriverTestCase
{	
	private LoginPageHelper loginpageHelper;
	private HeaderHelper headerHelper;
	private ContentEditorHelper contenteditorHelper;
	
	/**
	 * 
	 * @author 360logica
	 * @version 1.0
	 * <br>Date Created:  04/12/2016
	 * <br>Test Case: Login
	 * <br>Priority: P1
	 * <br>Status: Active
	 * <br>Automated: Yes
	 * <br>JiraProject: Demo Jira Project
	 * <br>JiraIssue: Demo Jira test case ID
	 * <br>Jira Open Bug: Mention if any
	 * <br>Execution Time: 1 minutes.
	 * <br><b>Steps:</b>
	 * Step 1: Launch web browser (FireFox,IE, Chrome).
	 * Step 2: Login into the application
	 * Step 3: Click on New Project button to add New Project
	 * Step 4: Add Collection Details
	 * Step 5: Click on Add New Project button
	 * Step 6: Add Project Details
	 * Step 7: Save Project
	 * Step 9: Verify the created Collection and Project
	 * Step 10: Open Project
	 * Step 11: Reach Content Editor page
	 * Step 12: Enter Text
	 * Step 13: Update Text
	 * Step 14: Delete Text
	 * @param none
	 * @return None.
	 * @throws Exception 
	 * @exception None.
	 */
	public void logintest() throws Exception {
		try {
		
		loginpageHelper = new LoginPageHelper(getWebDriver());
		headerHelper = new HeaderHelper(getWebDriver());
		contenteditorHelper = new ContentEditorHelper(getWebDriver());
		getWebDriver().get(application_url);
		loginpageHelper.Login(username1, password1);
		homepageHelper = new HomePageHelper(getWebDriver());
		Thread.sleep(10000);
		homepageHelper.AddProject();			
		editProjectsHelper = new EditProjectsHelper(getWebDriver());
		String collectionName = editProjectsHelper.CollectionDetails();
		String projectName = editProjectsHelper.Newproject();
		Reporter.log("Added " +projectName +" Project in collection " +collectionName, true );
		editProjectsHelper.savebutton();
		boolean textavailable1 = isTextAvailable(collectionName);
  	    System.out.println("Created collection is available "+textavailable1);
  	    boolean textavailable2 = isTextAvailable(projectName);
	    System.out.println("Created Project is available "+textavailable2);
	    homepageHelper.Openproject();
	    //contenteditorhelper.Entertext();
	     List<WebElement> iframes_element =  driver.findElements(By.tagName("iframe"));
		int iframes =  iframes_element.size();
		System.out.println("The total number of iframes are " + iframes);
		driver.switchTo().frame(0);
	    WebElement editable = driver.switchTo().activeElement();
	    editable.sendKeys("In the last couple years everything we know about getting from point A to point B has changed. Less than a decade ago you either had to have your own car, use public transportation, or try to flag down a cab – too all an order during rush hour ");
	   
	    for( int i=0; i<60; i++)
	    {
	      editable.sendKeys(Keys.ARROW_LEFT);
	      if(i == 59)
	      {
	    	  editable.sendKeys(Keys.TAB," Metro Digi ");
	    	  System.out.println("Update Text and add Metro Digi");
	      }
	    }
	    for( int k=0; k<12; k++)
	    {
	      editable.sendKeys(Keys.ARROW_LEFT);
	    }
	    System.out.println("Delete 20 characters");
	    for(int j=0; j<20; j++){
	    	editable.sendKeys(Keys.BACK_SPACE);
	    	System.out.println("Go back "+j+"space");
	    }
	   Thread.sleep(6000);
	   contenteditorhelper.SelectText(editable,getWebDriver());
	   
	   //Click on Bold icon and make some text bold 
	   contenteditorhelper.ClickBoldIcon();
	   System.out.println("Click on Bold icon");
	   editable.sendKeys(Keys.BACK_SPACE);
	   System.out.println("Bold text deleted");
	  
	  //Select Text and do Italic
	   
	   
	   contenteditorhelper.SelectText(editable,getWebDriver());
	   contenteditorhelper.ClickItalicIcon();  
	   System.out.println("Click on Italic icon");
	   editable.sendKeys(Keys.BACK_SPACE);
	   System.out.println("Italic text deleted");
	   
	   // Remove all formatting
	   
	   contenteditorhelper.SelectText(editable,getWebDriver());
	   contenteditorhelper.ClickBoldIcon();
	   contenteditorhelper.ClickItalicIcon();  
	   System.out.println("Click on Bold and Italic icon");
	   Thread.sleep(3000);
	   editable.sendKeys(Keys.chord(Keys.CONTROL,"a"));
	   contenteditorhelper.ClickRemoveFormattingIcon();   
	   System.out.println("Click on Remove Formatting icon");
  }catch (Exception e) {
		e.printStackTrace();
	}
 }
}
