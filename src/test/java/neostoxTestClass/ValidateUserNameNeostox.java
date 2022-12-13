package neostoxTestClass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import neoStoxBase1.Base1;
import neoStoxPOM1.NeoStoxHomePage1;
import neoStoxPOM1.NeoStoxPasswordPage;
import neoStoxPOM1.NeoStoxSignup1;
import neoStoxUtility1.UtilityClass;

public class ValidateUserNameNeostox extends Base1 {
  
 NeoStoxSignup1 SignUp;
 NeoStoxPasswordPage password;
 NeoStoxHomePage1 home;
 
 @BeforeClass
 public void launchNeoStox() {
	 launchBrowser();
	 SignUp=new NeoStoxSignup1(driver);
	 password=new NeoStoxPasswordPage (driver);
	 home=new NeoStoxHomePage1 (driver);
	 
 }
 
 @BeforeMethod
 public void NeoStoxSignup1() throws IOException, InterruptedException {
	 SignUp.sendMobileNum(driver, UtilityClass.ReaddataFromProperty("mno"));
	 
	 SignUp.clickonSignIn(driver);
	 
	 Thread.sleep(1000);
	 
	 password.sendPassword(driver, UtilityClass.ReaddataFromProperty("pass"));
	 password.clickonSubmitButton(driver);
	 Thread.sleep(1000);
	 home.popUpHandle(driver);
	 
	 
 }
 
 @Test
 public void ValidateUserName() throws IOException {
	 
	 Assert.assertEquals(home.getUserName(),UtilityClass.ReaddataFromProperty("username"),"TC Failed aactual and expected user names are not matching");
	 UtilityClass.Screenshot(driver, home.getUserName());
}
 
@AfterMethod

public void Logout() {
	home.logoutFromNeoStox1(driver);
}

@AfterClass

public void closebrowser() throws InterruptedException {
	
	closingBrowser(driver);
}




}
