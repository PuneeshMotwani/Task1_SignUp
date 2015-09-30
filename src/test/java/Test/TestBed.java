/** No implementations in this class. It is the top level class which contains the object declarations which can be 
 * accessed any where in the framework. This saves me from passing the object parameters while creating  page objects.
 */

package Test;

import org.openqa.selenium.WebDriver;

import Utility.MySpreadsheetIntegration;

public class TestBed {
	public static WebDriver driver;
	public static MySpreadsheetIntegration sheet;

}
