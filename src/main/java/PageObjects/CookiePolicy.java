package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CookiePolicy {
	
	WebDriver driver;
	
	public CookiePolicy (WebDriver driver)
	{
		this.driver = driver;
	}
	
	private By acceptCookie = By.xpath(".//*[@class='iubenda-cs-accept-btn iubenda-cs-btn-primary']");
	
	public WebElement acceptCookieButton()
	{
		return driver.findElement(acceptCookie);
	}
}
