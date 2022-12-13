package neoStoxPOM1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import neoStoxUtility1.UtilityClass;

public class NeoStoxHomePage1 {

	@FindBy(xpath="(//a[text()='OK'])[2]") private WebElement OKButton;
	
	@FindBy(xpath="(//a[@class='neobutton'])[25]") private WebElement CloseButton;
	
	@FindBy(xpath="//span[@id='lbl_username']") private WebElement UserName;
	
	@FindBy (xpath="//span[@id='lbl_curbalancetop']")private WebElement Balance;
	
	@FindBy (xpath="//span[text()='Logout']") private WebElement Logout;
	
	public NeoStoxHomePage1(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void popUpHandle(WebDriver driver)
	{
		UtilityClass.wait(driver, 4000);
		OKButton.click();
		UtilityClass.scrollIntoView(driver, CloseButton);
		UtilityClass.wait(driver, 7000);
		CloseButton.click();
		Reporter.log("Handling popup",true);
	}
	
	public String getUserName()
	{
		String actualUserName=UserName.getText();
		Reporter.log("getting user Name",true);
		return actualUserName;
	}
	public String getBalance(WebDriver driver) {
		UtilityClass.wait(driver, 1000);
		String actualbalance=Balance.getText();
		Reporter.log("Getting actual balance",true);
		return actualbalance;
	}
	
	public void logoutFromNeoStox1(WebDriver driver) {
		UtilityClass.wait(driver, 1000);
		UserName.click();
		UtilityClass.wait(driver, 1000);
		Logout.click();
		Reporter.log("Logging out from NeoStox",true);
	}
}
