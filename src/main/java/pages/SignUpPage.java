package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * This class consist all the methods which are related to Sign Up Page
 */
public class SignUpPage {

	WebDriver driver;
	
	By emailTextBox=By.cssSelector(".adb-text__full_width");
	By signupButton=By.cssSelector("button[id^=id]"); //
	By signupPageHeader=By.cssSelector(".adb-container_header>h3");
	By signupLoginLink =By.cssSelector("#signupLoginLink>a");
	By partnerRegisterLink= By.cssSelector("#partnerRegisterLink>a");
	By ErrorMsg=By.cssSelector(".js-content>p");
	/**
	 * @param driver
	 */
	public SignUpPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean setEmailTextBox(String emailAddress) {
		WebDriverWait wait= new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(emailTextBox));
			driver.findElement(emailTextBox).clear();
			driver.findElement(emailTextBox).sendKeys(emailAddress);
			return true;
	}
	public boolean clickSignupButton(){
		
			driver.findElement(signupButton).click();
			return true;
		
	}
	public void clickSignupLoginLink(){
		
		if(driver.findElement(signupLoginLink).isEnabled()){
			driver.findElement(signupLoginLink).click();
		}
		
	}
	
	public void clickPartnerRegisterLink(){
		if(driver.findElement(partnerRegisterLink).isEnabled()){
			driver.findElement(partnerRegisterLink).click();
		}
		
	}
	public String getSignUPPageHeaderContent(){
		
		WebDriverWait wait= new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(signupPageHeader));
		return driver.findElement(signupPageHeader).getText();
		
	}
	/*
	 * Return Error text when user is already registered
	 */
	public String returnErrorText(){
		WebDriverWait wait= new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorMsg));
		return(driver.findElement(ErrorMsg).getText());
		
	
}
	// ^[^@ ]+@[^@ ]+\.[^@ ]+$
}
