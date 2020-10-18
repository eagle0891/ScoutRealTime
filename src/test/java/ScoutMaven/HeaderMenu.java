package ScoutMaven;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.NavigationBar;
import Resources.base;

public class HeaderMenu extends base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	NavigationBar nb;
	
	@BeforeTest
	public void initializeTest() throws IOException
	{
		driver = initializeDriver();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to homepage successfully");
	}
	
	@Test
	public void basePageNavigation() throws IOException, Throwable
	{	
		nb = new NavigationBar(driver);
		
		Assert.assertTrue(nb.siteLogoImage().isDisplayed());
		log.info("Site Logo image is displayed successfully");
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
		log.info("Browser closed");
	}
}