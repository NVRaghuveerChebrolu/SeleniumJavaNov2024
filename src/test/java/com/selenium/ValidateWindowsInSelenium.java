package com.selenium;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.POM.MultipleWindowsPOM;
import com.Utility.Library;

public class ValidateWindowsInSelenium extends Library {

	@Test(priority = -1)
	public void ValidateLaunchOfDemoQABrowserWindows() {
		System.out.println("inside ValidateLaunchOfDemoQABrowserWindows");
		driver.get(objProperties.getProperty("DemoQANewTabWindow"));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		Assert.assertEquals(driver.getTitle(),objProperties.getProperty("DemoQABrowserWindowTitile"));
	}
	
	@Test(priority=1)
	public void ValidateNewTab() throws InterruptedException {
		System.out.println("inside ValidateNewTab");
		MultipleWindowsPOM objMultipleWindowsPOM = new MultipleWindowsPOM(driver);
		String MainWindow = driver.getWindowHandle();
		ScrollIntoView(objMultipleWindowsPOM.newTab);
		objMultipleWindowsPOM.newTab.click();
		
		//Explicit wait: wait for a paticular web element based on the condition specified
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
				
		Thread.sleep(4000);
		Set<String> AllWindows = driver.getWindowHandles();
		for(String window:AllWindows) {
			driver.switchTo().window(window);
			System.out.println("URL of window:"+driver.getCurrentUrl());
			if(driver.getCurrentUrl().equalsIgnoreCase(objProperties.getProperty("newTabURL"))) {
				String Heading=objMultipleWindowsPOM.newTabHeading.getText();
				Assert.assertEquals(Heading, objProperties.getProperty("newTabHeading"));
				driver.close();//close the browser window that is currently active
				break;
			}
		}
		driver.switchTo().window(MainWindow);
		
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("inside beforeMethod");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("inside afterMethod");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("inside beforeClass");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("inside afterClass");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("inside beforeTest");
		LaunchBrowser();
	}

	@AfterTest
	public void afterTest() {
		System.out.println("inside afterTest");
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
		System.out.println("inside afterSuite");
	}
}
