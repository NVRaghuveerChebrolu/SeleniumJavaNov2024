package com.selenium;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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

import com.POM.DropDownAndCalnderPOM;
import com.POM.MultipleWindowsPOM;
import com.Utility.Library;

public class ValidateDropDOwnsAndCalnederInSeleium extends Library {

	@Test(priority = -1)
	public void ValidateLaunchOfDemoQAPractiseForm() {
		System.out.println("inside ValidateLaunchOfDemoQAPractiseForm");
		driver.get(objProperties.getProperty("DropDownUrl"));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		Assert.assertEquals(driver.getTitle(),objProperties.getProperty("TitleOfToolsQA"));
	}
	
	@Test(priority=1)
	public void ValidateDropDown() throws InterruptedException {
		System.out.println("inside ValidateDropDown");
		DropDownAndCalnderPOM objDropDownAndCalnderPOM = new DropDownAndCalnderPOM(driver);
		ScrollIntoView(objDropDownAndCalnderPOM.dateOfBirth);
		objDropDownAndCalnderPOM.dateOfBirth.click();
//		Select objSelect = new Select(objDropDownAndCalnderPOM.MonthDropDown); 
//		objSelect.selectByVisibleText(objProperties.getProperty("DropDownMonth"));
//		Select objSelect1 = new Select(objDropDownAndCalnderPOM.YearDropDown); 
//		objSelect1.selectByVisibleText(objProperties.getProperty("DropDownYear"));
		
		objDropDownAndCalnderPOM.MonthDropDown.click();
		selectRequiredValueFromDropDown(objDropDownAndCalnderPOM.AllMonthOptions, objProperties.getProperty("DropDownMonth"));
		
		objDropDownAndCalnderPOM.YearDropDown.click();
		selectRequiredValueFromDropDown(objDropDownAndCalnderPOM.AllYearOptions, objProperties.getProperty("DropDownYear"));
		
		List<WebElement>AllCalenderDays = objDropDownAndCalnderPOM.AllDays;
		for(int i=0;i<=AllCalenderDays.size()-1;i++) {
			String DayFromCalender=AllCalenderDays.get(i).getText();
			if(DayFromCalender.equals(objProperties.getProperty("CalenderDay"))) {
				AllCalenderDays.get(i).click();
				break;
			}
//			if(DayFromCalender.equals(String.valueOf(randomCalenderDayvalue()))) {
//				AllCalenderDays.get(i).click();
//				break;
//			}
		}
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
