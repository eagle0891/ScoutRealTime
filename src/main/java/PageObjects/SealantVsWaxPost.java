package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SealantVsWaxPost {
	public WebDriver driver;
	public SealantVsWaxPost (WebDriver driver)
	{
		this.driver = driver;
	}

	private By sealantVsWaxTitle = By.xpath("//h1[@class='entry-title'][text()='Sealant vs Wax: What’s the difference?']");
	
	public WebElement getSealantVsWaxTitle()
	{
		return driver.findElement(sealantVsWaxTitle);
	}
}
