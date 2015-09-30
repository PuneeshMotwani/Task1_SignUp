/** This is this class that contains the actual implementation of test class - “SignUpRebtelTest.java”.
 * 
 */

package Page;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

import Utility.LogUtil;
import Utility.MySpreadsheetIntegration;

public class SignUpRebtelPage extends CommonPageActions{

	public static Log logger = LogUtil.getLog(SignUpRebtelPage.class); 
	
	/**
	 * This method opens the signup page from the home page
	 */
	
	public void goToSignUpPage(){
		clickOnElement("signUpButtonHomePage");
		waitForElementToAppear("signUpH1Text");
	}

	
	/**
	 * This method verifies a couple of field names on the Sign up page
	 */

	public void verifyFieldNamesOnSignUpPage() {
		verifyText("signUpH1Text");
		verifyText("alreayHaveAccountText");
		verifyText("loginLink");
		verifyText("weWillNeverPostText");
		verifyText("rebtelHomeFooterlink");
		verifyText("supportFooterLink");
	}

	/**
	 * This method clicks on Sign In link
	 */

	public void verifyClickingOnSignInLink() {
		clickOnElement("loginLink");
		waitForElementToAppear("SignUpLinkOnLoginPage");
		validateElementPresent("SignUpLinkOnLoginPage");
	}


	/**
	 * This method returns to the signup page after clicking the LoginLink
	 */
	public void returnToSignUpPage() {
		clickOnElement("SignUpLinkOnLoginPage");
		waitForElementToAppear("loginLink");
		validateElementPresent("loginLink");
	}



	/**
	 * This method verifies the dynamic country phone code depending upon the data selected in the country input box.  
	 * The data(country and country code) is taken from the sheet(csv) and passed thorough data provider to this method 
	 * @param country
	 * @param coutryCode
	 */

	public void verifyCountryCode(String country, String countryCode) {
		enterText("CountryInputBox", country);
		getElementByXpath("CountryInputBox").sendKeys(Keys.TAB);
		waitForElementToAppear("countryCode");
		verifyText("countryCode", "+"+countryCode);
		
		// Applying this sleep, just to slow down the speed of execution in order to clearly visualize this test while running.
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


	/**
	 * This method completes the signup process. I am not clicking the Create New Account button 
	 * as I do not want to create an account on prod
	 */
	public void verifyCompletingSignup() {
		enterText("emailTextbox","puneesh@gmail.com");
		enterText("CountryInputBox","Norway");
		getElementByXpath("CountryInputBox").sendKeys(Keys.TAB);
		enterText("phoneNumber","2169279600");
		enterText("pinInputBox","1234");
		clickOnElement("termsCheckbox");
		//clickOnElement("createNEwAccountButton"); 
		logger.info("not clicking the signup button as I do not want to create a user in prod enviroment");
	}
	
	
}
