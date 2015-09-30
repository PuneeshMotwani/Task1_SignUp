/** This class is a wrapper on webDriver methods. So, ideally when completed, this class can be taken to any 
 * other project/application, and can be used to automate the application using selenium. As of now, this just has a 
 * couple of methods that I used for this small assignment.
 */

package Page;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import Test.TestBed;
import Utility.LogUtil;
import Utility.SoftAssertor;

public class PageLibrary extends TestBed{
	public static Log logger = LogUtil.getLog(PageLibrary.class);


	/**
	 * This method finds the element on a webpage by its xPathIdentifier specified in the spreadsheet
	 * @param xPathIdentifier
	 * @return
	 */
	public WebElement getElementByXpath(String xPathIdentifier){
		WebElement element;
	
		 element = driver.findElement(By.xpath(sheet.getXpathValue(xPathIdentifier)));
		return element;
	}
	
	
	/**
	 * This method click the element
	 * @param xPathIdentifier
	 */
	 
	public void clickOnElement(String xPathIdentifier){
		getElementByXpath(xPathIdentifier).click();
	}

	
	/**
	 * This method validates that the element is present on webpage
	 * @param xPathIdentifier
	 */
	public void validateElementPresent(String xPathIdentifier){
		Assert.assertTrue(getElementByXpath(xPathIdentifier).isDisplayed(), xPathIdentifier+" is Not Present");
		logger.info("Validated "+xPathIdentifier+" is Present on Page");
	}
	
	
	
	/** Verifies text from the specified xPathIdentifier
	 * 
	 * @param xPathIdentifier
	 * 
	 */
	public void verifyText(String xPathIdentifier){
		String elementText = getElementByXpath(xPathIdentifier).getText();
		SoftAssertor.assertEquals(elementText, sheet.getExpectedValue(xPathIdentifier),"Text for "+xPathIdentifier+" does not match"+" - actual text = "+elementText+ "... Expcted Text = "+sheet.getExpectedValue(xPathIdentifier));
		logger.info("Verified text for element "+ xPathIdentifier+ "... Expected - "+sheet.getExpectedValue(xPathIdentifier)
								+ " --- Actual - "+ elementText);
	}
	
	
	/**
	 * This is overloaded method for verifying text with a specific expected value
	 * @param xPathIdentifier
	 * @param expectedValue
	 */
	public void verifyText(String xPathIdentifier, String expectedValue){
		String elementText = getElementByXpath(xPathIdentifier).getText();
		SoftAssertor.assertEquals(elementText, expectedValue,"Text for "+xPathIdentifier+" does not match"+" - actual text = "+elementText+ "... Expcted Text = "+ expectedValue);
		logger.info("Verified text for element "+ xPathIdentifier);
	}
	
	
	/** This method waits for an element explicitly to appear.
	 * 
	 * @param xPathIdentifier
	 */
	public void waitForElementToAppear(String xPathIdentifier) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sheet.getXpathValue(xPathIdentifier))));
	}

	
	/**
	 * This method send the keys to element
	 * @param xPathIdentifier
	 * @param string
	 */
	public void enterText(String xPathIdentifier, String string) {
		getElementByXpath(xPathIdentifier).sendKeys(string);
	}
}
