package stepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import PageObjects.CookiePolicy;
import PageObjects.ScoutHomepage;
import PageObjects.UltimateGuidesPage;
import Resources.base;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition extends base{
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	CookiePolicy cp;
	ScoutHomepage sh;
	UltimateGuidesPage ugp;

	@Given("^I initialize the browser with chrome$")
	public void i_initialize_the_browser_with_chrome() throws Throwable {
		driver = initializeDriver();
	}

	@And("^I navigate to (.+)$")
    public void i_navigate_to(String url) throws Throwable {
		driver.get(url);
		log.info("Navigated to homepage");
    }

	@Given("^I accept the cookie policy$")
	public void i_accept_the_cookie_policy() throws Throwable {
		cp = new CookiePolicy(driver);
		cp.acceptCookieButton().click();
		log.info("Cookie policy accepted");
	}
	
	@When("^I click on the (.+) link$")
    public void i_click_on_the_link(String linkname) throws Throwable {
		sh = new ScoutHomepage(driver);
		if (linkname.equals("Ultimate Guides"))
		{
		sh.ultimateGuideLink().click();
		log.info("Ultimate guide link clicked");
		}
	}

	@Then("^The (.+) page title should be correct$")
    public void the_page_title_should_be_correct(String pagetitle) throws Throwable {
		ugp = new UltimateGuidesPage(driver);
		if (pagetitle.equals("Ultimate Guides")) 
		{
			Assert.assertEquals("Ultimate Guidess", ugp.ultimateGuideTitle().getText());
			log.info("Ultimate guide title is correct");	
		}
	}
}
