package TestngScreenshot;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ITestListenerClass.class)
public class NewTest{
	
	 
	  @Test
	  public void LogInOrangeHRM() {
		  WebDriver driver=new ChromeDriver();
		  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		  driver.findElement(By.name("username")).sendKeys("Admin");
		  driver.findElement(By.name("password")).sendKeys("admin123",Keys.ENTER);
		  String expectedUrl="https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		  String actualUrl=driver.getCurrentUrl();
		  Assert.assertEquals(actualUrl, expectedUrl);
		  System.out.println("OrngeHRM login successful...");
		 driver.close();
	  }
	  
	@Test
	  public void LoginFacebook(){
		WebDriver driver=new ChromeDriver();
		 driver.get("https://www.facebook.com");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		  driver.findElement(By.id("email")).sendKeys("pardeshishweta26@gmail.com");
		  driver.findElement(By.id("pass")).sendKeys("shweta",Keys.ENTER);
		  
		  String expectedTitle="Facebook";
		  String actualTitle=driver.getTitle();
		  Assert.assertEquals(actualTitle, expectedTitle);
		  driver.close();
		  
	  }
	   
	  @Test
	  public void LoginVtiger() {
		  WebDriver driver=new ChromeDriver();
		  driver.get("https://demo.vtiger.com/vtigercrm/index.php");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		  WebElement userInputField=driver.findElement(By.name("username"));
		  userInputField.sendKeys("admin");
		  WebElement passwordInputField=driver.findElement(By.id("password"));
		  passwordInputField.sendKeys("admin");
		  driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		  String expectedTitle="Dashboard";
		  String actualTitle=driver.getTitle();
		  Assert.assertEquals(actualTitle, expectedTitle);
		  driver.close();
	  }

}
