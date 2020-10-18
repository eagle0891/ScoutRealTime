package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UltimateGuidesPage {
	
	public WebDriver driver;
	public UltimateGuidesPage (WebDriver driver)
	{
		this.driver = driver;
	}
	
	private By sealantVsWaxLink = By.xpath("//*[@class='entry-title']/*[text()='Sealant vs Wax: What’s the difference?']");
	private By dualActionPolisherLink = By.xpath("//*[@class='entry-title']/*[text()='Best Dual Action Polisher: Honest Guide']");
	private By ultimateGuideTitleText = By.xpath("//*[@class='page-title ast-archive-title']");
	
	public WebElement sealantVsWaxLink()
	{
		return driver.findElement(sealantVsWaxLink);
	}
	
	public WebElement dualActionPolisherLink()
	{
		return driver.findElement(dualActionPolisherLink);
	}
	
	public WebElement ultimateGuideTitle() 
	{
		return driver.findElement(ultimateGuideTitleText);
	}

}
