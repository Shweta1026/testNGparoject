package testNGpractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertions {
	WebDriver driver=new ChromeDriver();
	@Test
	public void facebookLogIn() throws InterruptedException {
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.id("email")).sendKeys("abc",Keys.ENTER);
		Thread.sleep(30);
		
		//title verification
		String expectedTitle="Log in to Facebook";
		String actualTitle=driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle,"Title mismatched");
		
		//url verification
		String expectedUrl="Log in to Facebook";
		String actualUrl=driver.getTitle();
		Assert.assertEquals(actualUrl, expectedUrl,"URL mismatched");
		
		//TEXT verifiaction
		String expectedText=driver.findElement(By.id("email")).getAttribute("value");
		String actualText="";
		Assert.assertEquals(actualText, expectedText,"Text mismatched");
		
		//border mismatched
		String expectedBorder=driver.findElement(By.id("email")).getCssValue("border");
		String actualBorder="1px solid rgb(240, 40, 73)";
		Assert.assertEquals(actualBorder, expectedBorder,"BORDER mismatched");
		
		//ERROR MESSAGE MISMATCH
		String expectedErrorMessage=driver.findElement(By.xpath("(//div[@id='email_container']/div)[last()]")).getText();
		String actualErrorMessage="The email address or mobile number you entered isn't connected to an account. Find your account and log in.";
		Assert.assertEquals(expectedErrorMessage,actualErrorMessage,"error msg mismatched");
		driver.quit();
	}

}
