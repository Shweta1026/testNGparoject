package testNGpractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider1 {
	@Test(dataProvider="logInDataProvider")
	public void opencartRegisteration(String username,String password) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.vtiger.com/vtigercrm/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		WebElement userInputField=driver.findElement(By.id("username"));
		userInputField.clear();
		userInputField.sendKeys(username);
		
		WebElement passwordInputField=driver.findElement(By.id("password"));
		passwordInputField.clear();
		passwordInputField.sendKeys(password);
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String expectedTitle="Dashboard";
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.titleIs("Dashboard"));
		Thread.sleep(2000);
		String actualTitle=driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		System.out.println("validation done");
		driver.close();
	}
	
	@DataProvider(name="logInDataProvider")
	public Object[][] logInData(){
		Object[][] data=new Object[2][2];
		data[0][0]="admin";
		data[0][1]="admin";
		
		data[1][0]="admin";
		data[1][1]="test";
		return data;
	}

}
