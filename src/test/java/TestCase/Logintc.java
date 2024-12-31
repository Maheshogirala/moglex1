package TestCase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Pageobjects.Loginpage;

public class Logintc extends BaseClass {
	@Test(priority=1)
	public void TC1() throws InterruptedException {
		Loginpage lg=new  Loginpage(driver);
		lg.Login();
		lg.Throught_Email();
		
		/*WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
		  
		 WebElement enteremail1= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Enter Email-ID']")));
		 
		 enteremail1.click();
		 enteremail1.sendKeys("maheshogirala828@gmail.com"); */
		
		
		/*WebElement e1= driver.findElement(By.xpath("//span[text()='Enter Email-ID']"));
		JavascriptExecutor js=  (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", e1);
		e1.sendKeys(rb.getString("email"));*/
		
		
		/*WebDriverWait wait1= new WebDriverWait(driver,Duration.ofSeconds(20));
		wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[text()='Enter Email-ID']")));
		WebElement e2= driver.findElement(By.xpath("//span[text()='Enter Email-ID']"));
		e2.click();
		e2.sendKeys("maheshogirala828@gmail.com");*/
		//lg.Enter_Email(rb.getString("email"));
		
		/*Actions actions = new Actions(driver);
		WebElement element = driver.findElement(By.id("//span[text()='Enter Email-ID']"));
		actions.moveToElement(element).sendKeys("maheshogirala828@gmail.com").perform();
		*/
		
		/*WebElement element = driver.findElement(By.id("//span[text()='Enter Email-ID']"));
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", element);
		element.sendKeys("maheshogirala828@gmail.com");
		//((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		 * 
		 */
		//driver.findElement(By.xpath("//div[@ class='outline-input-label mb-25']/label")).sendKeys("maheshogirala828@gmail.com");
		lg.Enter_Email(rb.getString("email"));
		driver.findElement(By.xpath("//div[@ class='left-txt']")).click();
		lg.Continue();
		lg.Enter_Password(rb.getString("pass"));
		driver.findElement(By.xpath("//div[@ class='left-txt']")).click();
		lg.Submite();
	}

}
