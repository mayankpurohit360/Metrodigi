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

import java.io.File;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.Metrodigi.locators.LocatorReader;
import com.Metrodigi.util.DriverHelper;
import com.Metrodigi.util.PropertyReader;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;
import org.testng.Assert;



public class ContentEditorHelper extends DriverHelper 
{
	public LocatorReader contenteditorLocator;	
	public Screen screen = new Screen();
	String currentDir = System.getProperty("user.dir");
	File folder;
	
	int random= this.getRandomInteger(1, 99999);
	PropertyReader propertyReader = new PropertyReader();
	public ContentEditorHelper(WebDriver driver)
	{
		super(driver);
		contenteditorLocator = new LocatorReader("ContentEditor.xml");
	}
	/**
	 * @description This method is used to enter text under content editor page
	 * @return none
	 */
	
	public void Entertext() {
		try {
			WebElement Editable = switchFrame();
			Editable.sendKeys("In the last couple years everything we know about getting from point A to"
					+ " point B has changed. Less than a decade ago you either had to have your own car, use"
					+ " public transportation, or try to flag down a cab – too tall an order during rush hour");
		 }catch (Exception e) {
			 e.printStackTrace();
		 } 
	}
	
	/*public void updatetext(){
		try{
			for( int i=0; i<60; i++)
		    {
		      Editable.sendKeys(Keys.ARROW_LEFT);
		      if(i == 59)
		      {
		    	  Editable.sendKeys(Keys.TAB," Metro Digi ");
		    	  System.out.println("Update Text and add Metro Digi");
		      }
		    }
		    for( int k=0; k<10; k++)
		    {
		      Editable.sendKeys(Keys.ARROW_LEFT);
		    }
		    System.out.println("Delete 20 characters");
		    for(int j=0; j<20; j++){
		    	Editable.sendKeys(Keys.BACK_SPACE);
		    }
			
		}catch (Exception e) {
			 e.printStackTrace();
		 } 
	}
	public void Deletetext(){
		try{
			System.out.println("Press left key to delete text");     
		    
		    for( int k=0; k<10; k++)
		    {
		      Editable.sendKeys(Keys.ARROW_LEFT);
		    }
		    System.out.println("Delete 20 characters");
		    for(int j=0; j<20; j++){
		    	Editable.sendKeys(Keys.BACK_SPACE);
		    }
			
		}catch (Exception e) {
			 e.printStackTrace();
		 } 
	}
	/**
	 * @description This method is used to Add table under content editor page
	 * @return none
	 */
	public void AddTable(){
	try{
		String addtable = contenteditorLocator.getLocator("ContentEditor.Moretools");
		String table = contenteditorLocator.getLocator("ContentEditor.Table");
		WaitForElementNotPresent(addtable,10);
		clickOn(addtable);
		WaitForElementNotPresent(table,10);		
		clickOn(table);
	}catch (Exception e) {
		 e.printStackTrace();
	}
}
	// Click Bold icon
	public void ClickBoldIcon() throws Exception {
		boolean m = screen.exists("E:\\workspace\\Metrodigi\\images\\bold_icon.PNG") != null;
		if (m == false)
			Assert.fail("Body text window not present");
		System.out.println();
		try {
			screen.click("E:\\workspace\\Metrodigi\\images\\bold_icon.PNG");
			waitForElementLoad(2);
		} catch (FindFailed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		// Click Italic icon
		public void ClickItalicIcon() throws Exception {
			boolean m = screen.exists("E:\\workspace\\Metrodigi\\images\\italic_icon.PNG") != null;
			if (m == false)
				Assert.fail("Body text window not present");
			System.out.println();
			try {
				screen.click("E:\\workspace\\Metrodigi\\images\\italic_icon.PNG");
				waitForElementLoad(2);
			} catch (FindFailed e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
		// Click Remove Formatting icon
				public void ClickRemoveFormattingIcon() throws Exception {
					boolean m = screen.exists("E:\\workspace\\Metrodigi\\images\\removeformatting_icon.PNG") != null;
					if (m == false)
						Assert.fail("Body text window not present");
					System.out.println();
					try {
						screen.click("E:\\workspace\\Metrodigi\\images\\removeformatting_icon.PNG");
						waitForElementLoad(2);
					} catch (FindFailed e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		// Select Text
				public void SelectText(WebElement Editable,WebDriver driver){
					   Actions act1 = new Actions(driver);
					   act1.clickAndHold(Editable).build().perform();
					   act1.release().perform();
					   System.out.println("Click and hold");
					   act1.doubleClick(Editable).build().perform();
					   System.out.println("Double click");
					   act1.clickAndHold(Editable).build().perform();
					   System.out.println("Click and hold");
					   act1.moveToElement(Editable, 50, 50).build().perform();
					   System.out.println("Move to element");
					   act1.dragAndDropBy(Editable, 600, 650).build().perform();
					   act1.release().build().perform();
					   System.out.println("Drag drop and release");
				}
}




