package com.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
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

}
