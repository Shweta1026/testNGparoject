package TestngScreenshot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


import utilities.SeleniumUtility;

public class ITestListenerClass implements ITestListener {
	public static WebDriver driver;

	public void onStart(ITestContext context) {
		System.out.println("starts...");
	}

	public void onFinish(ITestContext context) {
		System.out.println("finish...");
	}
	

	public void onTestStart(ITestResult result) {
		System.out.println("Test has been started...");
	}

	public void onTestSuccess(ITestResult result) {
        System.out.println(result.getMethod().getMethodName()+" SUCCESSFUL...");
	}

	public void onTestFailure(ITestResult result) {
		TakesScreenshot ts=(TakesScreenshot)driver;
        File src= ts.getScreenshotAs(OutputType.FILE);
        File screenshot=new File(".\\screenshots\\"+result.getMethod().getMethodName()+".png");
        
			try {
				FileUtils.copyFile(src,screenshot);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		 
        System.out.println("failed");
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+" SKIPPED...");
	}

}
