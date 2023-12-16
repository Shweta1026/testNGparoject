package testNGpractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class VtigerParameters {
	WebDriver driver;

	@Parameters("browsername")
	@BeforeTest
	public void initializeBrowser(@Optional("chrome") String browsername) {
		switch (browsername.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("browser is invalid");
			break;
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	// https://demo.vtiger.com/vtigercrm/index.php
	@Parameters("url")
	@Test
	public void launchApp(String url) {
		driver.get(url);
	}

	@Parameters({"username" , "password"})
	@Test
	public void logInApp(String username, String password) {
		WebElement userInputField = driver.findElement(By.id("username"));
		userInputField.clear();
		userInputField.sendKeys(username);

		WebElement passwordInputField = driver.findElement(By.id("password"));
		passwordInputField.clear();
		passwordInputField.sendKeys(password);

		driver.findElement(By.tagName("button")).click();
	}

	@Test
	public void logInValidation() {

		String expectedHomePageTitle = "Dashboard";

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.className("keyword-input")));

		System.out.println("expected Home Page Title : " + expectedHomePageTitle);
		String actualHomePageTitle = driver.getTitle();
		System.out.println(actualHomePageTitle);
		System.out.println("is log in successful : " + expectedHomePageTitle.equals(actualHomePageTitle));

	}
	
	@Test
	public void contactCreation() {
		driver.findElement(By.xpath("//div[@id='appnavigator']")).click();
		driver.findElement(By.xpath("//div[@id='app-menu']/div/div[2]/div[2]")).click();
		driver.findElement(By.xpath("//div[@id='mCSB_1_container']/li[3]")).click();
		driver.findElement(By.id("Contacts_listView_basicAction_LBL_ADD_RECORD")).click();
		driver.findElement(By.id("Contacts_editView_fieldName_firstname")).sendKeys("Raj");
		driver.findElement(By.id("Contacts_editView_fieldName_lastname")).sendKeys("Thakur");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Assert.assertTrue(driver.getPageSource().contains("Thakur"));
	}

}
