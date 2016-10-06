/**
 * 
 */
package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * @author richa.b.shrivastava
 *This class performs activities related to start up and tear down
 */
public class BaseClassTest {
	WebDriver driver;
	@BeforeMethod
	public void setup(){
		Reporter.log("Driver session started",true);
		//driver= new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", "C:\\softwares\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.appdirect.com");
		Reporter.log("application staerted",true);
	}
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
