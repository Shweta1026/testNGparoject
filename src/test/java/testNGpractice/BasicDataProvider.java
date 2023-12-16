package testNGpractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BasicDataProvider {
	
	@Test(dataProvider="datasupplier1",dataProviderClass=DataProvider.class)
	public void logInOrangeHRM(String username,String password) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String expectedUr="https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//header[@class='oxd-topbar']/div/div/span")));
		Thread.sleep(3000);
		String actualUrl=driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUr);
		driver.close();
	}
	
	@DataProvider(name="logInDataProvider")
	public Object[][] logInData() {
		Object[][] data=new Object[][] {
			{"Admin","admin123"},
	        {"Admin","test123"}
		};
		return data;
	}

}
