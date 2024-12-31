package Pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Loginpage extends Basepage {
public WebDriver driver;
public Loginpage(WebDriver driver) {
	super(driver);
}
  @FindBy(xpath="//p[text()='Login Now']")WebElement login;
  @FindBy(xpath="//button[text()='CONTINUE WITH EMAIL-ID']") WebElement throughtemail;
  @FindBy(xpath="//div[@ class='outline-input-label mb-25']/label") WebElement enteremail;
  @FindBy(xpath="//button[text()='CONTINUE']") WebElement submite;
  @FindBy(xpath="//div[@ class='outline-input-label mb-25']/label") WebElement enterpassword;

  public void Login() {
	  login.click();
  }
  public void Throught_Email() {
	  throughtemail.click();
  }
  public void Enter_Email(String email) {
	  enteremail.sendKeys(email);
  }
  public void Continue() {
	  /*WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
	  
		 WebElement enteremail1= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='CONTINUE']")));
		 
		 enteremail1.click();*/
	  
	  submite.click();
  }
  public void Enter_Password(String password) {
	  enterpassword.sendKeys(password);
  }
  public void Submite() {
	  submite.click();
  }
  
  
}
