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
		Assert.assertEquals(titileOfHomePage, "Welcome to Green Mountain Outpost");
		driver.findElement(By.name("bSubmit")).click();
		driver.findElement(By.name("QTY_GLASSES")).clear();
		driver.findElement(By.name("QTY_GLASSES")).sendKeys("2");
		driver.findElement(By.name("bSubmit")).click();
		String palceOrdePageTitle= driver.getTitle();
		System.out.println("palceOrdePageTitle:"+palceOrdePageTitle);
		Assert.assertEquals(palceOrdePageTitle, "Place Order");
		String UnitPrice = driver.findElement(By.xpath("//table[@border='1']/tbody/tr[2]/td[4]")).getText();
		System.out.println("UnitPrice:"+UnitPrice);
		String ExtractedValueOfUnitPrice=UnitPrice.substring(2);
		float UnitPricefloatValue=Float.parseFloat(ExtractedValueOfUnitPrice);
		float calculatedtotalPrice=UnitPricefloatValue*2;
		System.out.println("calculatedtotalPrice:"+calculatedtotalPrice);
		float totalPriceDisplayed = Float.parseFloat(driver.findElement(By.xpath("//table[@border='1']/tbody/tr[2]/td[5]")).getText().substring(2));
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
