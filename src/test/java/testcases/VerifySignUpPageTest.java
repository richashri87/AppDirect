/**
 * 
 */
package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.SignUpPage;

/**
 * @author richa.b.shrivastava This Test Class consist all the validation
 *         functions related to SignUP page
 */

public class VerifySignUpPageTest extends BaseClassTest {

	/*
	 * This function validate the success message when user Sign UP with valid
	 * email id. Which is in format of xyz@email.com
	 */
	@Test(priority = 3)
	@Parameters("validEmail")
	public void signUpwithValidEmail(String validEmail) {
		By successMessageLine1 = By.xpath(".//*[@class='signupConfirmationPanel']/div/section/div/h3");
		By successMessageLine2 = By.xpath(".//*[@class='signupConfirmationPanel']/div/section/div/p[1]");
		By successMessageLine3 = By.xpath(".//*[@class='signupConfirmationPanel']/div/section/div/p[2]");

		HomePage hPage = new HomePage(driver);
		hPage.clickLoginFromHomePage();

		LoginPage loginPage = new LoginPage(driver);
		boolean l = loginPage.ClicksignUpButtonFromLoginPage();

		SignUpPage spage = new SignUpPage(driver);
		spage.setEmailTextBox(validEmail);
		spage.clickSignupButton();

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(successMessageLine1));
		String actualSuccessMessage1 = driver.findElement(successMessageLine1).getText();
		String actualSuccessMessage2 = driver.findElement(successMessageLine2).getText();
		String actualSuccessMessage3 = driver.findElement(successMessageLine3).getText();
		Assert.assertEquals(actualSuccessMessage1, "Thanks for registering.");
		Assert.assertEquals(actualSuccessMessage2, "We have sent a verification email to " + validEmail + ".");
		Assert.assertEquals(actualSuccessMessage3,
				"Please check your inbox and click the link to activate your account.");

	}

	/*
	 * This function validate the error message when user Sign UP with already
	 * registered email id.
	 */
	@Test(priority = 4)
	public void signUpwithAlreadyRegisteredEmailAdd() {
		String alreadyRegisteredEmail = "valid@email.com";
		HomePage hPage = new HomePage(driver);
		hPage.clickLoginFromHomePage();

		LoginPage loginPage = new LoginPage(driver);
		boolean l = loginPage.ClicksignUpButtonFromLoginPage();

		SignUpPage spage = new SignUpPage(driver);
		spage.setEmailTextBox(alreadyRegisteredEmail);
		spage.clickSignupButton();
		spage.returnErrorText();
		Assert.assertEquals(spage.returnErrorText(),
				"This email address has already been registered in our system. Please register with a new email address.");
	}

	/*
	 * This function validate if Login Link on home page is navigating to Login
	 * page or not
	 */
	@Test(priority = 1)
	public void verifyLoginLinkOnHomescreen() {
		HomePage hPage = new HomePage(driver);
		hPage.clickLoginFromHomePage();

		LoginPage loginPage = new LoginPage(driver);
		String loginHeader = loginPage.getLoginPageHeaderContent();
		Assert.assertEquals(loginHeader, "LOG IN TO YOUR ACCOUNT");

	}

	/*
	 * This function validate if sign up Link on Login page is navigating to
	 * Sign Up page or not
	 */
	@Test(priority = 2)
	public void verifySignUpButtonOnLoginscreen() {
		HomePage hPage = new HomePage(driver);
		hPage.clickLoginFromHomePage();

		LoginPage loginPage = new LoginPage(driver);
		loginPage.ClicksignUpButtonFromLoginPage();

		SignUpPage spage = new SignUpPage(driver);
		String str = spage.getSignUPPageHeaderContent();
		Assert.assertEquals(spage.getSignUPPageHeaderContent(), "SIGN UP");

	}

}
