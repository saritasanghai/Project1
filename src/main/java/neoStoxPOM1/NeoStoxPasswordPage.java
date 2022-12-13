package neoStoxPOM1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import neoStoxUtility1.UtilityClass;

public class NeoStoxPasswordPage {

	@FindBy(xpath="//input[@id='txt_accesspin']")private WebElement PasscodeField;
	
	@FindBy(xpath="//a[@id='lnk_submitaccesspin']") private WebElement SubmitButton;
	
	public NeoStoxPasswordPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void sendPassword(WebDriver driver,String pass)
	{
		UtilityClass.wait(driver,1000);
		PasscodeField.sendKeys(pass);
		Reporter.log("sending password",true);
		
	}
	
	public void clickonSubmitButton(WebDriver driver)
	{
		UtilityClass.wait(driver, 1000);
		SubmitButton.click();
		Reporter.log("Clicking on Submit Button",true);
	}
	
	
}
