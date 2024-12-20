package SwapnaAssignmentsPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GreenMountainPOm {
public WebDriver drive;//instance variable

public GreenMountainPOm(WebDriver driver) {//constructor to intialize the intance variable
	this.drive = driver;
	PageFactory.initElements( driver,this);
}

@FindBy(name ="bSubmit")
public WebElement Entergmo;
}
