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
import PageObjects.SealantVsWaxPost;
import PageObjects.UltimateGuidesPage;
import Resources.base;

public class UltimateGuides extends base {
	
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	CookiePolicy cp;
	ScoutHomepage sh;
	UltimateGuidesPage ugp;
	SealantVsWaxPost swp;
	
	@BeforeTest
	public void initializeTest() throws IOException
	{
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}

	@Test
	public void UltimateGuidePosts() throws IOException, Throwable
	{				
		cp = new CookiePolicy(driver);
		sh = new ScoutHomepage(driver);
		ugp = new UltimateGuidesPage(driver);
		swp = new SealantVsWaxPost(driver);
		
		cp.acceptCookieButton().click();
		log.info("Cookie policy accepted");
		sh.ultimateGuideLink().click();
		log.info("Ultimate guide link clicked");
		ugp.sealantVsWaxLink().click();
		log.info("Sealant vs Wax post link clicked");
		Assert.assertEquals(swp.getSealantVsWaxTitle().getText(), "Sealant Vs Wax: What’s The Difference?");
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
		log.info("Browser closed");
	}
		
}
