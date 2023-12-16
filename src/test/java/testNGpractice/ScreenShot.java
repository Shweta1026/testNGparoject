package testNGpractice;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utilities.SeleniumUtility;

public class ScreenShot extends SeleniumUtility {
	WebDriver driver=new ChromeDriver();
	@BeforeTest
	public void startUp() {
	driver.get("https://www.saucedemo.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@Test
	public void screenShot() throws IOException {
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File trg=new File(".\\screenshots\\swaglab.png");
		FileUtils.copyFile(src, trg);
		
	}
	
	@Test
	public void screenShot2() throws IOException, InterruptedException {
		WebElement section=driver.findElement(By.xpath("//div[@class='login_wrapper-inner']"));
		File src=section.getScreenshotAs(OutputType.FILE);
		File trg=new File(".\\screenshots\\section.png");
		FileUtils.copyFile(src, trg);
		Thread.sleep(30);
	}
	
	@Test
	public void elementScreenShot() throws IOException {
		WebElement ele=driver.findElement(By.xpath("//h4[text()='Accepted usernames are:']"));
		File src=ele.getScreenshotAs(OutputType.FILE);
		File trg=new File(".\\screenshots\\element.png");
		FileUtils.copyFile(src, trg);
		
	}
	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
