package ScoutMaven;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.CookiePolicy;
import PageObjects.ScoutHomepage;
import PageObjects.UltimateGuidesPage;
import Resources.base;

public class Homepage extends base {
	public WebDriver driver; //This allow static class declared in base to be copied locally to this class.  
	public static Logger log = LogManager.getLogger(base.class.getName());
	CookiePolicy cp;
	ScoutHomepage sh;
	UltimateGuidesPage ugp;
	
	@BeforeTest
	public void initializeTest() throws IOException
	{
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		log.info("Navigated to homepage");
		cp = new CookiePolicy(driver);
		cp.acceptCookieButton().click();
		log.info("Cookie policy accepted");
	}

	@Test
	public void ultimateGuideNavigation() throws IOException, Throwable
	{			
		sh = new ScoutHomepage(driver);
		ugp = new UltimateGuidesPage(driver);
		Assert.assertEquals("FOUR WHEEL SCOUT", sh.getTitleText().getText());
		sh.ultimateGuideLink().click();
		log.info("Ultimate guide link clicked");
		Assert.assertEquals("Ultimate Guides", ugp.ultimateGuideTitle().getText());
		log.info("Ultimate guide title is correct");
	} 
	
	@Test
	public void reviewsNavigation() throws IOException, Throwable
	{			
		sh = new ScoutHomepage(driver);
		sh.reviewsLink().click();
		log.info("Reviews link clicked");
		driver.get(prop.getProperty("url"));
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
		log.info("Browser closed");
	}
}
