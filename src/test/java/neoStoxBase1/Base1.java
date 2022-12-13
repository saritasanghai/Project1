package neoStoxBase1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

import neoStoxUtility1.UtilityClass;

public class Base1 {
	
	protected WebDriver driver;
	
	public void launchBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\\\selenium\\\\selenium-java-4.4.0\\\\chromedriver.exe");
		
		driver=new ChromeDriver();
		
		driver.get("https://neostox.com/sign-up");
		
		driver.manage().window().maximize();
		
		Reporter.log("Launching browser",true);
		
		UtilityClass.wait(driver,1000);
		
		
	}
	
	public static void closingBrowser(WebDriver driver) throws InterruptedException
	{
		Reporter.log("closing browser",true);
		Thread.sleep(2000);
		driver.close();
	}

}
