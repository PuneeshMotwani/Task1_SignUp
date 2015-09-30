/** This is the main driving class that lists all the TestNG test methods and ensure correct sequence of  execution. 
 * While the actual implementation of tests are in the page classes this test class make it easy for team to easily 
 * understand the scope of test on high level.
 */

package Test;


import org.apache.commons.logging.Log;
import org.testng.annotations.Test;



import Page.SignUpRebtelPage;
import Utility.LogUtil;
public class SignUpRebtelTest extends TestCommon {	 
	
	public static Log logger = LogUtil.getLog(SignUpRebtelTest.class); 
	
	
	/** This test method validates user is able to open the signup page from homepage
	 *  
	 */
	
	@Test(priority=1)
	public void testNavigationToSignUpPage(){
		SignUpRebtelPage pageObj = new SignUpRebtelPage();	
		pageObj.goToSignUpPage();	
		logger.info("*****Loaded the Signup Page successfully*****");
	}
	
	/** This test method verified a couple of field names on the signup page
	 *  
	 */
	
	@Test(priority=2)
	public void testFieldNamesOnSignUpPage(){
		SignUpRebtelPage pageObj = new SignUpRebtelPage();	
		pageObj.verifyFieldNamesOnSignUpPage();	
		logger.info("*****Verified the fields displayed on the signup page *****");
	}
	
	
	/** This test method validates the signIn link on the Signup page. Also, navigates back to SignUp page 
	 * 
	 */
	
	@Test(priority=3)
	public void testSignInLink(){
		SignUpRebtelPage pageObj = new SignUpRebtelPage();	
		pageObj.verifyClickingOnSignInLink();
		pageObj.returnToSignUpPage();
		logger.info("*****Verified clicking on SignIn Link *****");
	}

	/** This test method verifies the country code for each country selected. To test more countries we need to enter the  
	 * 	country name and code in the test data spreadsheet
	 * @param country
	 * @param countryCode
	 */
	
	
	@Test(priority=4, dataProvider = "countryList")
	public void testDynamicCountryCode(String country, String countryCode){
		SignUpRebtelPage pageObj = new SignUpRebtelPage();	
		pageObj.verifyCountryCode(country, countryCode);
		
		logger.info("*****Verified dynamic country code for "+ country +"*****");
	}
	
	
	/** This method completes the signup process. For now i am not clicking the Signup button as I do not want to create 
	 * an account on prod.
	 * 
	 */
	
	@Test(priority=5)
	public void testCompleteSignUp(){
		SignUpRebtelPage pageObj = new SignUpRebtelPage();	
		pageObj.verifyCompletingSignup();
		
		logger.info("*****Verified completing the signup flow*****");
	}
	

}
