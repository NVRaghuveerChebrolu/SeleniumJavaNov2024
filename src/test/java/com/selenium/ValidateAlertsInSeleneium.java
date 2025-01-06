package com.selenium;

import org.testng.annotations.Test;

import com.POM.AlertsPOM;
import com.Utility.Constants;
import com.Utility.Library;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class ValidateAlertsInSeleneium extends Library{
  
  @Test(priority=0)
  public void ValidateLaunchAlertsOnDemoQA() {
	  driver.get(objProperties.getProperty("AlertsURL"));
	 // ExtTest=ExtReports.createTest(new Object() {}.getClass().getEnclosingMethod().getName());
	  PageLoadTimeOut(Constants.PageLoadTimeOut);
	  String title=driver.getTitle();
	  Assert.assertEquals(title, objProperties.getProperty("TitleOfDemoQA"));
  }
  

@Test(priority=1,dependsOnMethods= {"ValidateLaunchAlertsOnDemoQA"})
  public void ValidateNoramlAlertOnDemoQA() throws InterruptedException{
	  System.out.println("inside ValidateNoramlAlertOnDemoQA");
	 // ExtTest=ExtReports.createTest(new Object() {}.getClass().getEnclosingMethod().getName());
	  AlertsPOM objAlertsPOM = new AlertsPOM(driver);
	  objAlertsPOM.NormalAlert.click();
	  //driver.findElement(By.id("alertButton")).click();
	  Alert objAlert= driver.switchTo().alert();
	  Thread.sleep(3000);
	  String textOfNormalAlert= objAlert.getText();
	  Assert.assertEquals(textOfNormalAlert, objProperties.getProperty("TextMessageOfNormalAlert"));
	  objAlert.accept();
  }
  
  @Test(priority=2)
  public void ValidateTimerAlertOnDemoQA() throws InterruptedException {
	  System.out.println("inside ValidateTimerAlertOnDemoQA");
	  //ExtTest=ExtReports.createTest(new Object() {}.getClass().getEnclosingMethod().getName());
	  AlertsPOM objPOM= new AlertsPOM(driver);
	  objPOM.TimerAlert.click();
	  //explicit wait : applicable for one web element
	  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
	  wait.until(ExpectedConditions.alertIsPresent());
	  Alert objAlert =driver.switchTo().alert();
	 // Thread.sleep(3000);
	  String textOftimerAlert = objAlert.getText();
	  Assert.assertEquals(textOftimerAlert, objProperties.getProperty("TextMessageOfTimerAlert"));
	  objAlert.accept();//accepting the alert
	  //objAlert.dismiss();// cancel the alert
  }
  
  @Test(priority=3)
  public void ValidateConfirmBoxAlertOnDemoQA() {
	  System.out.println("inside ValidateConfirmBoxAlertOnDemoQA");
	//  ExtTest=ExtReports.createTest(new Object() {}.getClass().getEnclosingMethod().getName());
	  AlertsPOM objPOM = new AlertsPOM(driver);
	  objPOM.confirmButton.click();
	  Alert objAlert = driver.switchTo().alert();
	  String textOfConfirmBoxAlert = objAlert.getText();
	  Assert.assertEquals(textOfConfirmBoxAlert, objProperties.getProperty("TextMessageOfConfirmBoxAlert"));
	  objAlert.dismiss();//to click on cancel
	  boolean ConfirmAlertResult = objPOM.confirmResult.isDisplayed();
	  //Assert.assertEquals(ConfirmAlertResult, true);
	  Assert.assertTrue(ConfirmAlertResult, "ConfirmAlertResult message is not displayed");
  }
  
  @Test(priority=4)
  public void ValidatePromptBoxAlertonDemoQA() {
	  System.out.println("inisde ValidatePromptBoxAlertonDemoQA");
	 // ExtTest=ExtReports.createTest(new Object() {}.getClass().getEnclosingMethod().getName());
	  AlertsPOM objAlertsPOM =new AlertsPOM(driver);
	  objAlertsPOM.promtButton.click();
	  Alert objAlert = driver.switchTo().alert();
	  String TextDisplayed = objAlert.getText();
	  Assert.assertEquals(TextDisplayed, objProperties.getProperty("TextMessageOfPropmtBoxAlert"));
	  objAlert.sendKeys(objProperties.getProperty("PromptBoxMessageEntered"));
	  objAlert.accept();
	  String PromptBoxResultMessageDisplayed=objAlertsPOM.promptResult.getText();
	  Assert.assertEquals(PromptBoxResultMessageDisplayed, objProperties.getProperty("PrompBoxResult"));
  }
  
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod(ITestResult result) {
	  System.out.println("inside afterMethod");
	 // UpdatingResultInExtentReport(result);
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("inside beforeClass");
	 // StartExtentReport();
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("inside afterclass");
	 // FlushReport();
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
