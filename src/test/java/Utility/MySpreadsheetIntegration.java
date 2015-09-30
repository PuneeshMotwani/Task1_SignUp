
package Utility;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

 
public class MySpreadsheetIntegration {
	String csvFile = System.getProperty("user.dir")+"//Files//TestData.csv";
	BufferedReader br = null;
	String line = "";
	String cvsSplitBy = ",";

	
	/** This method returns the xpath value from the sheet for the searchKey
	 * 
	 * @param searchKey
	 * @return
	 */
	public String getXpathValue(String searchKey){
		String xPathValue = getDataFromSheet(searchKey, 2);
		return xPathValue;
	}
	
	
	/** This method returns the expected value from sheet for the search key
	 * 
	 * @param searchKey
	 * @return
	 */
	public String getExpectedValue(String searchKey){
		String expectedValue = getDataFromSheet(searchKey, 3);
		return expectedValue;
		
	}
	
	

	/**
	 * this method returns the values from sheet depending upon coulm name and search key.
	 * @param searchKey
	 * @param ColNum
	 * @return
	 */
  public String getDataFromSheet(String searchKey, int ColNum) {
	  String xPathValue="";
	  try {
		br = new BufferedReader(new FileReader(csvFile));
		while ((line = br.readLine()) != null) {				
		        // use comma as separator
			String[] dataArray = line.split(cvsSplitBy);
			if(dataArray[1].equalsIgnoreCase(searchKey)){
				xPathValue = dataArray[ColNum];
				break;
			}
		}
 
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} 

	finally {
		if (br != null) {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	return xPathValue;
  }
 
  
  
 /**
  * This method takes the country phone code data from spreadsheet and returns the hashMap to data provider method
  * @return
  */
  public HashMap<String, String> getcountryInfoFromSheet() {	
	  HashMap<String, String> countryCodeMap = new HashMap<String, String>();
	  try {
		br = new BufferedReader(new FileReader(csvFile));
		while ((line = br.readLine()) != null) {				
		        // use comma as separator
			String[] dataArray = line.split(cvsSplitBy);
			if(dataArray[4].equalsIgnoreCase("<Last>")){
				break;
			}
			countryCodeMap.put(dataArray[4], dataArray[5] );
		}
 
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} 

	finally {
		if (br != null) {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}	  
	return countryCodeMap;
  }
  
  
  
  
}