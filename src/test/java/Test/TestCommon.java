/** This class will act as common(parent) class to all the test driving class. This class contains methods which 
 * should be executed at the beginning of test suite and test classes. They also have the data providers which are used 
 * to parameterize the child classes.
 */

package Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import Utility.LogUtil;
import Utility.MySpreadsheetIntegration;

public class TestCommon extends TestBed{
	public static Log logger = LogUtil.getLog(TestCommon.class); 
	
	/**
	 * This method instantiates object needed at the start of testing suite
	 * @throws MalformedURLException 
	 */
	@BeforeSuite()
	public void beforeSuite() throws MalformedURLException{
		
		driver = new FirefoxDriver();
		sheet = new MySpreadsheetIntegration();
		
	}
	
	
	/**
	 * This method starts the driver and get the url to application
	 */
	@BeforeClass()
	public void beforeClass(){
		driver.get("https://rebtel.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	
	/**
	 * This provides data to test method to verify the dynamic country code 
	 * @return
	 */
	@DataProvider
	public Object[][] countryList(){
		HashMap<String, String> countryList = sheet.getcountryInfoFromSheet();
		Object[][] arr = new Object [countryList.size()][2];
		
		Iterator<String> iter = countryList.keySet().iterator();
		int i=0;
		while(iter.hasNext()){	
			String key = iter.next();
			arr[i][0] = key;
			arr[i][1] = countryList.get(key);
			i++;
		}
		return arr;
	}
	
	
	
	/**
	 * This method quits the driver at the end of every class
	 */
	@AfterClass()
	public void afterClass(){
		driver.quit();
		
	}
	

	
}
