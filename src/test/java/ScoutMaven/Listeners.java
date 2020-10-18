package ScoutMaven;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Resources.ExtentReporterNG;
import Resources.base;

public class Listeners extends base implements ITestListener {
	ExtentTest test;
	ExtentReports extent = ExtentReporterNG.getReportObject();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>(); //to make thread safe for running parallel tests
	
	public void onTestStart(ITestResult result) {
		// Start Extent report
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test); //In following methods replace "test" with "extentTest.get()"
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.get().log(Status.PASS, "Test Passed!!!");
	}

	public void onTestFailure(ITestResult result) {
		//Failure log
		extentTest.get().log(Status.FAIL, "Test Failed");
		extentTest.get().fail(result.getThrowable());
		
		// Capture screenshot
		WebDriver driver = null;
		String testMethodName = result.getMethod().getMethodName();
		
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) 
		{
		} 
		
		try {
			extentTest.get().addScreenCaptureFromPath(getScreenShotPath(testMethodName, driver), result.getMethod().getMethodName());
			getScreenShotPath(testMethodName, driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// Stop extent report
		extent.flush();
		
	}
//note - later versions of TestNG you may not see an error in the above class. In this case you will then need to add the below methods via right-click on Listeners > Source > Override/Implement methods..., then tick the methods under ITestLister to be added
	

}
