package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Search {
	
	public WebDriver driver; 
	
	public Search (WebDriver driver)
	{
		this.driver = driver;
	}
	
	private By sidebarSearchInput = By.xpath("//aside[@id='search-2']/form[@class='search-form']/label/input");
	
	public WebElement sidebarSearchFieldInput()
	{
		return driver.findElement(sidebarSearchInput);
	}
	

}
