package neoStoxPOM1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import neoStoxUtility1.UtilityClass;


public class NeoStoxSignup1 {

	
	@FindBy (xpath="//input[@id='MainContent_signinsignup_txt_mobilenumber']") private WebElement MobilenoField;
	
	@FindBy(xpath="//a[@id='lnk_signup1']") private WebElement SignINButton;
	
	public NeoStoxSignup1(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void sendMobileNum(WebDriver driver,String mobNum) {
		
		UtilityClass.wait(driver,1000);
		MobilenoField.sendKeys(mobNum);
		Reporter.log("sending mobile number",true);
	}
	
	public void clickonSignIn(WebDriver driver) {
		UtilityClass.wait(driver, 1000);
		SignINButton.click();
		Reporter.log("Clicking on sign in button",true);
	}
	
	
	
	
}
