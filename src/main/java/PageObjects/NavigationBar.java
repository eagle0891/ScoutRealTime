package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NavigationBar {
	
	WebDriver driver;
	
	public NavigationBar (WebDriver driver)
	{
		this.driver = driver;
	}
	
	private By siteLogo = By.xpath("//img[@data-srcset='https://i1.wp.com/fourwheelscout.com/wp-content/uploads/2020/08/cropped-Four-Wheel-Scout2.png?resize=85%2C98&ssl=1 85w, https://i1.wp.com/fourwheelscout.com/wp-content/uploads/2020/08/cropped-Four-Wheel-Scout2.png?w=92&ssl=1 92w']");
	
	public WebElement siteLogoImage() 
	{
		return driver.findElement(siteLogo);
	}
}
