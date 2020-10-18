package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base {
	
	public WebDriver driver; //static will work for sequencial testing only, as only one instance will be available. Will only work if a local copy of the class is initialized. Static is advantageous in sequential execution due to less memory being used 
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException
	{
		String root = System.getProperty("user.dir");
		prop = new Properties();
		FileInputStream fis = new FileInputStream(root+"\\src\\main\\java\\Resources\\data.properties");
		
		prop.load(fis);
		//mvn test -Dbrowser=chrome
		
		//String browserName = System.getProperty("browser");
		String browserName = prop.getProperty("browser");
		
		if (browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", root+"\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if (browserName.equals("chromeheadless"))
		{
			System.setProperty("webdriver.chrome.driver", root+"\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			System.out.println("headless found");
			driver = new ChromeDriver(options);
		}
		else if (browserName.equals("firefox"))
		{
			//firefox code
			System.setProperty("webdriver.gecko.driver", root+"\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if (browserName.equals("IE"))
		{
			//ie code
			System.setProperty("webdriver.ie.driver", root+"\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;		
	}
	
	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
	}

}
