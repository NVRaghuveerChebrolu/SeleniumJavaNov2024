package com.selenium;

import org.testng.annotations.Test;

import com.POM.AlertsPOM;
import com.POM.MouseOperationsPOM;
import com.POM.framesPOM;
import com.Utility.Constants;
import com.Utility.Library;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class ValidateMouseOperations extends Library{
  
 @Test(priority=-1)
 public void ValidateJqueryPageLoaded() {
	 System.out.println("inside ValidateJqueryPageLoaded");
	 driver.get(objProperties.getProperty("mouseOpeartionRightClick"));
	 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	 String title = driver.getTitle();
	 Assert.assertEquals(title, objProperties.getProperty("JQeryTitle"));
 }
 
 @Test
 public void ValidateRightClickOperation() {
	 System.out.println("inside ValidateRightClickOperation");
	 MouseOperationsPOM objMouseOperationsPOM = new MouseOperationsPOM(driver);
	 Actions objAction = new Actions(driver);
	 //contextClick means right click operation
	 objAction.contextClick( objMouseOperationsPOM.rightClickBox).build().perform();
	 objAction.click(objMouseOperationsPOM.PasteOption).build().perform();
	 Alert objAlert = driver.switchTo().alert();
	 String AlertMessageText = objAlert.getText();
	 Assert.assertEquals(AlertMessageText, objProperties.getProperty("mouseOpeartionRightclick_PasteOptionAlertText"));
	 objAlert.accept();
 }
 
 @Test(priority=1)
 public void ValidateDoubleClickOperation() {
	 System.out.println("inside ValidateDoubleClickOperation");
	 driver.navigate().to(objProperties.getProperty("mouseOpeartionDoubleClick"));
	 MouseOperationsPOM objMouseOperationsPOM = new MouseOperationsPOM(driver);
	 JavascriptExecutor js = (JavascriptExecutor)driver;
	 js.executeScript("arguments[0].scrollIntoView(true)",objMouseOperationsPOM.iframe);
	 driver.switchTo().frame(objMouseOperationsPOM.iframe);
	 Actions objAction = new Actions(driver);
	 objAction.doubleClick(objMouseOperationsPOM.DoubleClickBox).build().perform();
 }
 
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }

  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("inside beforeTest");
	  LaunchBrowser();
  }

  @AfterTest
  public void afterTest() {
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("inside beforeSuite");
	  try {
		ReadPropertiesFile();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
  }

  @AfterSuite
  public void afterSuite() {
  }

}
