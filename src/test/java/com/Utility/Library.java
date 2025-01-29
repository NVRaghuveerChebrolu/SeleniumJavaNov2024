package com.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Library {
	public static WebDriver driver;
	public static Properties objProperties;

	public static void LaunchBrowser() {
		String browserChosen = objProperties.getProperty("browser");
		switch (browserChosen.toLowerCase()) {
		case "edge":
			driver = new EdgeDriver();
			break;
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "internetexplorer":
			driver = new InternetExplorerDriver();
			break;
		default:
			System.out.println("please provide valid broswer name");
		}
		driver.manage().window().maximize();
	}

	public static void ReadPropertiesFile() throws IOException {
		File objFile = new File(System.getProperty("user.dir") + "//src//test//resources//configuration.properties");
		FileInputStream objFileInput = new FileInputStream(objFile);
		objProperties = new Properties();
		objProperties.load(objFileInput);
		System.out.println(objProperties.getProperty("browser"));
		System.out.println(objProperties.getProperty("GreenMountainAppURL"));
	}

	public void PageLoadTimeOut(int pageTimeOut) {
		// TODO Auto-generated method stub
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageTimeOut));
	}
	
	public void ScrollIntoView(WebElement element) {
		 JavascriptExecutor js = (JavascriptExecutor)driver;
		 js.executeScript("arguments[0].scrollIntoView(true)",element);
	}
	
	public int randomCalenderDayvalue() {
		Random random = new Random();   
		// Generates random integers 0 to 31 
		int x = random.nextInt(32); 
		if(x==0) {
			x=1;
		}
		System.out.println("random day generated is:"+x);
		return x;
	}
	
	public void selectRequiredValueFromDropDown(List<WebElement> AllDropDownValues, String DropDownValueToBeSelected) {
		int NumberOfDropDownValues = AllDropDownValues.size();
		for(int i = 1;i<=NumberOfDropDownValues;i++) {
			String IndividualDropDownValue=AllDropDownValues.get(i).getText();
			if(IndividualDropDownValue.equals(DropDownValueToBeSelected)) {
				AllDropDownValues.get(i).click();
				break;
			}
		}
	}

}
