package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScoutHomepage {
	
	public WebDriver driver;
	public ScoutHomepage(WebDriver driver) 
	{
		
		this.driver = driver;
	}
	
	private By ultimateGuideButton = By.xpath(".//*[@class='elementor-button-text']/*[text()='Read Ultimate Guides']");
	private By reviewsButton = By.xpath(".//*[@class='elementor-button-text']/*[text()='Read Reviews Here']");	
	private By title = By.xpath("//h1[@class='elementor-heading-title elementor-size-default']/strong");
	
	public WebElement ultimateGuideLink()
	{
		return driver.findElement(ultimateGuideButton);
	}
	
	public WebElement reviewsLink()
	{
		return driver.findElement(reviewsButton);
	}
	
	public WebElement getTitleText()
	{
		return driver.findElement(title);
	}

}
