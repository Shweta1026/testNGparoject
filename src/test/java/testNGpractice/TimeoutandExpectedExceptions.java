package testNGpractice;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TimeoutandExpectedExceptions {
	@Test(timeOut=10000)
	public void test1() {
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.quit();
	}
	
	@Test(expectedExceptions= {NoSuchElementException.class,ArithmeticException.class})
	public void test2() {
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		//System.out.println(5/0);
		
		driver.quit();
	}

}
