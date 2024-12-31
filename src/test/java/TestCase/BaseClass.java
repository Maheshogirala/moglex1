package TestCase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

public class BaseClass {
 public static WebDriver driver;
 public ResourceBundle rb;
 @BeforeSuite()
 public void invockbrowser() {
	 ChromeOptions options= new ChromeOptions();
	 options.addArguments("--disable-notifications");
	 rb= ResourceBundle.getBundle("config");
	 driver = new ChromeDriver();
	 
	 driver.get("https://www.moglix.com/");
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 
 }
 @AfterSuite()
 public void closebrowser() {
	 driver.close();
 }
	
 public String screenshot(String tname) throws IOException {
	 // time stamp
	 
	 String timestamp= new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
	 TakesScreenshot ts= (TakesScreenshot)driver;
	 File source= ts.getScreenshotAs(OutputType.FILE);
	 String destination = System.getProperty("user.dir")+"\\Screenshots\\"+tname+timestamp+"img12.png";
	try {
	 FileUtils.copyFile(source, new File(destination));
	}catch(Exception e) {
		e.getMessage();
	}
	 return destination;
	 
 }
	
}
