package com.selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;

import com.POM.GreenMountainPOM;

public class GreenMoutainOutPost2 {
	static WebDriver driver;
	static Properties objProperties;
	public static void main(String[] args) throws IOException {
		ReadPropertiesFile();
		launchBrowser();
		driver.get(objProperties.getProperty("GreenMountainAppURL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		String titileOfHomePage = driver.getTitle();
		System.out.println("titileOfHomePage:"+titileOfHomePage);
		Assert.assertEquals(titileOfHomePage,objProperties.getProperty("TitleOfGreenMountainOutPost"));
		GreenMountainPOM objGreenMountainPOM = new GreenMountainPOM(driver);
		objGreenMountainPOM.EnterGmoOnline.click();
		objGreenMountainPOM.QTY_Glasses.clear();
		objGreenMountainPOM.QTY_Glasses.sendKeys(objProperties.getProperty("QTY_SunGlasses"));
		objGreenMountainPOM.PlaceAnorder.click();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		String palceOrdePageTitle= driver.getTitle();
		System.out.println("palceOrdePageTitle:"+palceOrdePageTitle);
		Assert.assertEquals(palceOrdePageTitle, objProperties.getProperty("PlaceOrderTitle"));
		String UnitPrice = objGreenMountainPOM.UnitPrice.getText();
		System.out.println("UnitPrice:"+UnitPrice);
		String ExtractedValueOfUnitPrice=UnitPrice.substring(2);
		float UnitPricefloatValue=Float.parseFloat(ExtractedValueOfUnitPrice);
		float calculatedtotalPrice=UnitPricefloatValue*Float.parseFloat(objProperties.getProperty("QTY_SunGlasses"));
		System.out.println("calculatedtotalPrice:"+calculatedtotalPrice);
		float totalPriceDisplayed = Float.parseFloat(objGreenMountainPOM.totalPriceDisplayed.getText().substring(2));
		Assert.assertEquals(calculatedtotalPrice, totalPriceDisplayed);
		System.out.println("totalPriceDisplayed:"+totalPriceDisplayed);
		
		//driver.close();
	}
	
	private static void launchBrowser() {
		String browserChosen=objProperties.getProperty("browser");
		switch(browserChosen.toLowerCase()) {
		case "edge":
			driver=new EdgeDriver();
			break;
		case "chrome":
			driver=new ChromeDriver();
			break;
		case "firefox":
			driver=new FirefoxDriver();
			break;
		case "internetexplorer":
			driver=new InternetExplorerDriver();
			break;
		default:
			System.out.println("please provide valid broswer name");
		}	
	}
	
	private static void ReadPropertiesFile() throws IOException {
		File objFile = new File(System.getProperty("user.dir")+"//src//test//resources//configuration.properties");
		FileInputStream objFileInput = new FileInputStream(objFile);
		objProperties = new Properties();
		objProperties.load(objFileInput);
		System.out.println(objProperties.getProperty("browser"));
		System.out.println(objProperties.getProperty("GreenMountainAppURL"));
	}

}
