package com.POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DropDownAndCalnderPOM {
	WebDriver driver;
	
	public DropDownAndCalnderPOM(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="dateOfBirthInput")
	public WebElement dateOfBirth;
	
	@FindBy(xpath="//select[@class='react-datepicker__month-select']")
	public WebElement MonthDropDown;
	
	@FindBy(xpath="//select[@class='react-datepicker__month-select']/option")
	public List<WebElement> AllMonthOptions;
	
	@FindBy(xpath="//select[@class='react-datepicker__year-select']")
	public WebElement YearDropDown;
	
	@FindBy(xpath="//select[@class='react-datepicker__year-select']/option")
	public List<WebElement> AllYearOptions;
	
	@FindBy(xpath="//div[@class='react-datepicker__month']/div/div")
	public List<WebElement> AllDays;
	

	
	

}
