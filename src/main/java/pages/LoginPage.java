package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * This class consist all the methods which are related to Login Page
 */
public class LoginPage {
	WebDriver driver;
	
	By Sign_up_for_an_account=By.cssSelector(".adb-footnote>p>a");
	By loginPageHeaderContent=By.cssSelector(".adb-container_header>h3");
	
	public LoginPage(WebDriver driver){
		this.driver=driver;
	}
	public boolean ClicksignUpButtonFromLoginPage(){
		
		WebDriverWait wait= new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(Sign_up_for_an_account));
			driver.findElement(Sign_up_for_an_account).click();
			return true;
		
	}
	
	public String getLoginPageHeaderContent(){
		
		WebDriverWait wait= new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(loginPageHeaderContent));
		return driver.findElement(loginPageHeaderContent).getText();
			
		}
	}

