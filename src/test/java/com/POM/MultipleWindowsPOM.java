package com.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MultipleWindowsPOM {
	WebDriver driver;
	
	public MultipleWindowsPOM(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="tabButton")
	public WebElement newTab;
	
	@FindBy(id="windowButton")
	public WebElement newWindow;
	
	@FindBy(id="messageWindowButton")
	public WebElement newWindowMessage;
	
	@FindBy(id="sampleHeading")
	public WebElement newTabHeading;
	

	
	

}
