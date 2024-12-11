package com.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class GreenMoutainOutPost {
	static WebDriver driver;
	public static void main(String[] args) {
		driver= new ChromeDriver();
		driver.get("https://demo.borland.com/gmopost/");
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
		//driver.close();
	}

}
