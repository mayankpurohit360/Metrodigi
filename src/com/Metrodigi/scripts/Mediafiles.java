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

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.Metrodigi.pagehelper.EditProjectsHelper;
import com.Metrodigi.pagehelper.EditProjects_ExistingCollectionHelper;
import com.Metrodigi.pagehelper.HomePageHelper;
import com.Metrodigi.pagehelper.LoginPageHelper;
import com.Metrodigi.util.DriverTestCase;


public class Mediafiles extends DriverTestCase
{	
	private LoginPageHelper loginpageHelper;
	
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
	 * Step 4: Create Collection
	 * Step 5: Create New Project
	 * Step 6: Open Project
	 * Step 7: Delete Project
	 * Step 8: Delete Collection
	 * @param none
	 * @return None.
	 * @throws Exception 
	 * @exception None.
	 */
	@Test
	public void logintest() throws Exception {	
		loginpageHelper = new LoginPageHelper(getWebDriver());

		//System.out.println("Metro Digi");
		getWebDriver().get(application_url);
		loginpageHelper.Login(username1, password1);
		
		homepageHelper = new HomePageHelper(getWebDriver());
		Thread.sleep(10000);
		//homepageHelper.AddProject();
				
		/*editprojects_imageHelper = new EditProjects_ImageHelper(getWebDriver());
		editprojects_imageHelper.CollectionDetails();
		editprojects_imageHelper.Newproject();*/
		
		/*editprojects_audioHelper = new EditProjects_AudioHelper(getWebDriver());
		editprojects_audioHelper.CollectionDetails();
		editprojects_audioHelper.Newproject();
		*/
		/*editprojects_videoHelper = new EditProjects_VideoHelper(getWebDriver());
		editprojects_videoHelper.CollectionDetails();
		editprojects_videoHelper.Newproject();*/
		
		/*editProjectsHelper = new EditProjectsHelper(getWebDriver());
		//editProjectsHelper.CollectionDetails();
		editProjectsHelper.Newproject();*/
		
		//homepageHelper.Openproject();	
		//homepageHelper.DeleteProject();
		//homepageHelper.DeleteCollection();
		homepageHelper.OpenExistingCollection();
		editprojects_existingcollectionHelper = new EditProjects_ExistingCollectionHelper(getWebDriver());
		editprojects_existingcollectionHelper.AddProject();
		editprojects_existingcollectionHelper.Newproject();
	}
}
