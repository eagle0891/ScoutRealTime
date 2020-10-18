package ScoutMaven;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.CookiePolicy;
import PageObjects.Search;
import Resources.base;

public class SearchTests extends base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	Search s;
	CookiePolicy cp;
	
	/*@BeforeTest
	public void initializeTest() throws IOException
	{
		driver = initializeDriver();
	}*/

	@Test (dataProvider="getData")
	public void basePageNavigation(String searchTerm) throws IOException, Throwable
	{		
		driver = initializeDriver();
		//driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("sealantVsWaxUrl"));
		s = new Search(driver);
		cp = new CookiePolicy(driver);
		
		cp.acceptCookieButton().click();
		log.info("Cookie policy accepted");
		s.sidebarSearchFieldInput().sendKeys(searchTerm);
		log.info("Search term entered");
		//Assert.assertEquals(s.sidebarSearchFieldInput().getText(), searchTerm);
		
		driver.close();
		log.info("Browser closed");
	}
	
	/*@AfterTest
	public void tearDown()
	{
		driver.close();
	}*/
	
	@DataProvider
	public Object[][] getData()
	{
		//row stands for how many different data types test should run
		//column stands for how many values per each test
		Object[][] data = new Object[2][1];
		//0th row
		data[0][0]="testsearch";
		//data[0][1]="some more string";
		//1th row
		data[1][0]="test search term 2";
		//data[1][1]="some more string from second set";
		
		return data;
	}
}
