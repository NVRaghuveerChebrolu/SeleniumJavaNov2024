package com.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class framesPOM {
	public WebDriver driver;
	
	public framesPOM(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="singleframe")
	public WebElement singleFrame;
	
	@FindBy(xpath="//input[@type='text']")
	public WebElement singleFrameTextBox;
	
	@FindBy(xpath="//a[contains(text(),'Iframe with in')]")
	public WebElement IframeWithIframeButton;

}
