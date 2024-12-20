package SwapnaAssignments;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;

import SwapnaAssignmentsPages.GreenMountainPOm;



public class GMopost {
	public static WebDriver driver;
	public static Properties objProperties;// creating global variable
	public static Properties objpProperties;

	public static void main(String[] args) throws IOException {
		// driver = new ChromeDriver(); -instead of this we can create Launch browser
		// method
		
		ReadPropertiesFile();
		LaunchBrowser();
		// driver.get("https://demo.borland.com/gmopost/");
		driver.get(objProperties.getProperty("greenMountainApplicationUrl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		String MainPagetitle = driver.getTitle();// this is hard assertion
		System.out.println("homePageTitle : " + MainPagetitle);
		Assert.assertEquals(MainPagetitle, "Welcome to Green Mountain Outpost");

		// driver.findElement(By.xpath("//input[@name='bSubmit']")).click();
		// PageObjectModel can be used
		GreenMountainPOm objGreenMountainPOm = new GreenMountainPOm(driver);
		objGreenMountainPOm.Entergmo.click();

		driver.findElement(By.name("QTY_TENTS")).clear();
		driver.findElement(By.name("QTY_TENTS")).sendKeys("1");

		driver.findElement(By.name("QTY_BACKPACKS")).clear();
		driver.findElement(By.name("QTY_BACKPACKS")).sendKeys("2");

		driver.findElement(By.name("QTY_GLASSES")).clear();
		driver.findElement(By.name("QTY_GLASSES")).sendKeys("3");

		driver.findElement(By.name("QTY_SOCKS")).clear();
		driver.findElement(By.name("QTY_SOCKS")).sendKeys("4");

		driver.findElement(By.name("QTY_BOOTS")).clear();
		driver.findElement(By.name("QTY_BOOTS")).sendKeys("5");

		driver.findElement(By.name("QTY_SHORTS")).clear();
		driver.findElement(By.name("QTY_SHORTS")).sendKeys("6");

		driver.findElement(By.name("bSubmit")).click();

		String TileOFPlaceOrder = driver.getTitle();
		Assert.assertEquals(TileOFPlaceOrder, "Place Order");
		// tent
		String TentUnitPrice = driver.findElement(By.xpath("//table[@border='1']/tbody/tr[2]/td[4]")).getText();
		System.out.println("Tent Unit Price : " + TentUnitPrice);
		String ExtractedTentUnitPrice = TentUnitPrice.substring(2);
		float UPofTent = Float.parseFloat(ExtractedTentUnitPrice);
		float calculatedUp = UPofTent * 1;
		System.out.println("CalcualtedTent unitPrice :" + calculatedUp);
		String DisplayedPrice = driver.findElement(By.xpath("//table[@border='1']/tbody/tr[2]/td[5]")).getText();
		System.out.println("Displayed tent Price : " + DisplayedPrice);
		String ExtractedDp = DisplayedPrice.substring(2);
		float DisplayedTp = Float.parseFloat(ExtractedDp);
		Assert.assertEquals(calculatedUp, DisplayedTp);

		// Backpack
		String BackpackUnitPrice = driver.findElement(By.xpath("//table[@border='1']/tbody/tr[3]/td[4]")).getText();
		System.out.println("Backpack Unit Price : " + BackpackUnitPrice);
		String ExtractedBackpackUnitPrice = BackpackUnitPrice.substring(2);
		float UPofbackpack = Float.parseFloat(ExtractedBackpackUnitPrice);
		float calculatedBpp = UPofbackpack * 2;
		System.out.println("CalcualtedBackPack unitPrice :" + calculatedBpp);
		String DisplayedBpPrice = driver.findElement(By.xpath("//table[@border='1']/tbody/tr[3]/td[5]")).getText();
		System.out.println("Displayed backpack Price : " + DisplayedBpPrice);
		String ExtractedBackpackDp = DisplayedPrice.substring(2);
		float DisplayedBpp = Float.parseFloat(ExtractedBackpackDp);
		Assert.assertEquals(calculatedUp, DisplayedBpp);

		// SunGlasses
		String SunGlassesUnitPrice = driver.findElement(By.xpath("//table[@border='1']/tbody/tr[4]/td[4]")).getText();
		System.out.println("SunGlasses Unit Price : " + SunGlassesUnitPrice);
		String ExtractedSunGlassesUnitPrice = SunGlassesUnitPrice.substring(2);
		float UPofSunGlasses = Float.parseFloat(ExtractedSunGlassesUnitPrice);
		float calculatedsgp = UPofSunGlasses * 3;
		System.out.println("CalcualtedSunGlasses unitPrice :" + calculatedsgp);
		String DisplayedSGPrice = driver.findElement(By.xpath("//table[@border='1']/tbody/tr[4]/td[5]")).getText();
		System.out.println("Displayed SunGlasses Price : " + DisplayedSGPrice);
		String ExtractedSunGlassesDp = DisplayedSGPrice.substring(2);
		float DisplayedSGp = Float.parseFloat(ExtractedSunGlassesDp);
		Assert.assertEquals(calculatedsgp, DisplayedSGp);

		// Socks
		String SocksUnitPrice = driver.findElement(By.xpath("//table[@border='1']/tbody/tr[5]/td[4]")).getText();
		System.out.println("Socks Unit Price : " + SocksUnitPrice);
		String ExtractedSocksUnitPrice = SocksUnitPrice.substring(2);
		float UPofSocks = Float.parseFloat(ExtractedSocksUnitPrice);
		float calculatedsp = UPofSocks * 4;
		System.out.println("CalcualtedSocks unitPrice :" + calculatedsp);
		String DisplayedSPrice = driver.findElement(By.xpath("//table[@border='1']/tbody/tr[5]/td[5]")).getText();
		System.out.println("Displayed Socks Price : " + DisplayedSPrice);
		String ExtractedSocksDp = DisplayedSPrice.substring(2);
		float DisplayedSp = Float.parseFloat(ExtractedSocksDp);
		Assert.assertEquals(calculatedsp, DisplayedSp);

		// Boots
		String BootsUnitPrice = driver.findElement(By.xpath("//table[@border='1']/tbody/tr[6]/td[4]")).getText();
		System.out.println("Boots Unit Price : " + BootsUnitPrice);
		String ExtractedBootsUnitPrice = BootsUnitPrice.substring(2);
		float UPofBoots = Float.parseFloat(ExtractedBootsUnitPrice);
		float calculatedBp = UPofBoots * 5;
		System.out.println("CalcualtedBoots unitPrice :" + calculatedBp);
		String DisplayedBPrice = driver.findElement(By.xpath("//table[@border='1']/tbody/tr[6]/td[5]")).getText();
		System.out.println("Displayed Boots Price : " + DisplayedBPrice);
		String ExtractedBootsDp = DisplayedBPrice.substring(2);
		float DisplayedBp = Float.parseFloat(ExtractedBootsDp);
		Assert.assertEquals(calculatedBp, DisplayedBp);

		// Shorts
		String ShortsUnitPrice = driver.findElement(By.xpath("//table[@border='1']/tbody/tr[7]/td[4]")).getText();
		System.out.println("Shorts Unit Price : " + ShortsUnitPrice);

		String ExtractedShortsUnitPrice = ShortsUnitPrice.substring(2);
		System.out.println("Shorts unit price removimg $ " + ExtractedShortsUnitPrice);

		float UPofShorts = Float.parseFloat(ExtractedShortsUnitPrice);
		float calculatedshp = UPofShorts * 6;	
		System.out.println("Calcualted Shorts unitPrice :" + calculatedshp);
		BigDecimal price = new BigDecimal(Float.toString(calculatedshp));
        BigDecimal CalculatedroundedPrice = price.setScale(2, RoundingMode.HALF_UP);
        System.out.println("Calcualted Rounded Shorts unitPrice :" + CalculatedroundedPrice);
		

		String DisplayedSHPrice = driver.findElement(By.xpath("//table[@border='1']/tbody/tr[7]/td[5]")).getText();
		System.out.println("Displayed Shorts Price : " + DisplayedSHPrice);

		String ExtractedShortsDp = DisplayedSHPrice.substring(2);
		System.out.println("----NewPrice extracted price:" + ExtractedShortsDp);
		float DisplayedShortp = Float.parseFloat(ExtractedShortsDp);
		System.out.println("Displayed Expected Price : "+DisplayedShortp);
		 BigDecimal Price = new BigDecimal(Float.toString(DisplayedShortp));
	        BigDecimal roundedPrice = price.setScale(2, RoundingMode.HALF_UP);
	        System.out.println("Rounded Price :"+roundedPrice);
		Assert.assertEquals(CalculatedroundedPrice, roundedPrice);

	}

	private static void LaunchBrowser() {
		String browserChoosen = objProperties.getProperty("Browser");
		switch ((browserChoosen).toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "internetExplorer":
			driver = new InternetExplorerDriver();
			break;
		default:
			System.out.println("Please provide valid browser name");

		}
	}

	private static void ReadPropertiesFile() throws IOException {
		File objFile = new File(System.getProperty("user.dir") + "//src//test//resources//swapnaAssignmentResources//Configuration.properties");
		// in order to read we need to create obj and give path of that file.
		// for that we use system..as it gives whr that project is saved
		// inorder to read we need File input
		FileInputStream objFileInput = new FileInputStream(objFile);
		// as extention is .properties we take pro class
		objProperties = new Properties();
		objProperties.load(objFileInput);
		System.out.println(objProperties.getProperty("Browser"));
	}

	public static void ReadPPFile() throws IOException {
		File objFile1 = new File(System.getProperty("user.dir") + "//src//test//resources//swapnaAssignmentResources//PP");
		FileInputStream objFileInput = new FileInputStream(objFile1);
		objpProperties = new Properties();
		objpProperties.load(objFileInput);
	System.out.println(objpProperties.getProperty("price"));
	}

}
