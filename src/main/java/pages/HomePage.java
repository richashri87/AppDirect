/**
 * 
 */
package pages;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;



/**
 * @author richa.b.shrivastava
 *This class consist all the methods which are related to Home Page
 */
public class HomePage {
	
	WebDriver driver;
	
	 By loginLink=By.cssSelector(".login>a>span");
	
	
	
	public HomePage(WebDriver driver){
		this.driver=driver;
	}
	
	public void clickLoginFromHomePage(){
		
		WebDriverWait wait= new WebDriverWait(driver,40);
		wait.until(ExpectedConditions.elementToBeClickable(loginLink));
		//fluentWait(loginLink);
			driver.findElement(loginLink).click();
			//return true;
		
	}
}
