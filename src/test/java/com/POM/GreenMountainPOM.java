package com.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GreenMountainPOM {
	public WebDriver driver;//instance variable

	//Constructor : to initialize the instance variables
	public GreenMountainPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "bSubmit")
	public WebElement EnterGmoOnline;
	
	@FindBy(name = "QTY_GLASSES")
	public WebElement QTY_Glasses;
	
	@FindBy(name = "bSubmit")
	public WebElement PlaceAnorder;
	
	@FindBy(xpath = "//table[@border='1']/tbody/tr[2]/td[4]")
	public WebElement UnitPrice;
	
	@FindBy(xpath = "//table[@border='1']/tbody/tr[2]/td[5]")
	public WebElement totalPriceDisplayed;
	
	

}
