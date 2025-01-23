package com.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MouseOperationsPOM {
	WebDriver driver;
	
	public MouseOperationsPOM(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()='right click me']")
	public WebElement rightClickBox;
	
	@FindBy(xpath="//span[text()='Edit']")
	public WebElement EditOption; 
	
	@FindBy(xpath="//span[text()='Cut']")
	public WebElement CutOption; 
	
	@FindBy(xpath="//span[text()='Copy']")
	public WebElement CopyOption; 
	
	@FindBy(xpath="//span[text()='Paste']")
	public WebElement PasteOption; 
	
	@FindBy(xpath="//span[text()='Delete']")
	public WebElement DeleteOption; 
	
	@FindBy(xpath="//span[text()='Quit']")
	public WebElement QuitOption; 
	
	@FindBy(xpath="//iframe")
	public WebElement iframe;
	
	@FindBy(xpath="//span[text()='Double click the block']/preceding-sibling::div")
	public WebElement DoubleClickBox;
	
	@FindBy(id="draggable")
	public WebElement DragMeToMyTarget;
	
	@FindBy(id="droppable")
	public WebElement DropHere;
	
	
	
	
	
	

}
