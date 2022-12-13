package neoStoxUtility1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class UtilityClass {

	// commonly used methods
	// excel reading ,screeshot,wait,scrolling
	
	public static String ReaddataFromProperty(String key) throws IOException {
		
		Properties prop=new Properties();
		FileInputStream myfile=new FileInputStream("C:\\Users\\atulkhude\\eclipse-workspace\\MavenProject\\MyProperty1.properties");
		prop.load(myfile);
		String value = prop.getProperty(key);
		Reporter.log("Entering values from properties file",true);
		return value;
	}
	
	public static void Screenshot(WebDriver driver,String Neostox) throws IOException {
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File("C:\\selenium\\selenium screenshot\\"+ Neostox +".png");
		
		FileHandler.copy(src, dest);
		Reporter.log("taking screenshot",true);
	}
	
	public static void scrollIntoView(WebDriver driver,WebElement element) {
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments.[0].scrollIntoView(true)", element);
		Reporter.log("Scrolling into view"+element.getText(),true);
	}
	
	public static void wait(WebDriver driver,int waittime)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(waittime));
		Reporter.log("waiting for"+waittime+"milis",true);
	}
	
	
	
	
	
}
