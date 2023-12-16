package testNGpractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utilities.SeleniumUtil;

public class SwagLabs extends SeleniumUtil {
	WebDriver driver;

	@BeforeTest
	public void startUp() {
		driver = setUp("chrome", "https://www.saucedemo.com");

		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
	}

	@Test(priority = 1)
	public void logInValidation() {
		String expectedHomePageUrl = "https://www.saucedemo.com/inventory.html";
		String actualHomePageUrl = getApplicationUrl();
		Assert.assertEquals(actualHomePageUrl, expectedHomePageUrl, "swag labs home page not opened");
	}

	@Test(priority = 2)
	public void addToCart() {
		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
	}

	@Test(priority = 3)
	public void addToCartValidation() {
		driver.findElement(By.className("shopping_cart_link")).click();
		List<WebElement> productList = driver
				.findElements(By.cssSelector(".cart_list>.cart_item>.cart_item_label>a>div"));
		System.out.println("no.of products added " + productList.size());

		for (int i = 0; i < productList.size(); i++) {
			System.out.println((i + 1) + ") " + productList.get(i).getText());

		}
		System.out.println("*************************");
	}
	@Test(priority = 4)
	public void checkOut() {
		driver.findElement(By.id("checkout")).click();
	}
	@Test(priority = 5)
	public void checkOutValidation() {
		String expectedCheckOutPageUrl = "https://www.saucedemo.com/checkout-step-one.html";
		String actualCheckOutPageUrl = getApplicationUrl();
		Assert.assertEquals(expectedCheckOutPageUrl,actualCheckOutPageUrl , "'Your information' page not opened");
	}
	@Test(priority = 6)
	public void information() {
		driver.findElement(By.id("first-name")).sendKeys("PQR");
		driver.findElement(By.id("last-name")).sendKeys("XYZ");
		driver.findElement(By.id("postal-code")).sendKeys("411057");
		driver.findElement(By.id("continue")).click();
	}
	@Test(priority = 7)
	public void informationValidation() {
		String expectedPaymentPageUrl = "https://www.saucedemo.com/checkout-step-two.html";
		String actualPaymentPageUrl = getApplicationUrl();
		Assert.assertEquals(expectedPaymentPageUrl,actualPaymentPageUrl , "Payment page not opened");
	}
	@Test(priority = 8)
	public void finish() {
		driver.findElement(By.id("finish")).click();
		driver.findElement(By.id("back-to-products")).click();
	}
	@Test(priority = 9)
	public void backHomeValidation() {
		String expectedBackHomePageUrl = "https://www.saucedemo.com/inventory.html";
		String actualBackHomePageUrl = getApplicationUrl();
		Assert.assertEquals(expectedBackHomePageUrl,actualBackHomePageUrl , "Home page not opened");
	}
	@Test(priority = 10)
	public void logOut() {
		clickOnElement(driver.findElement(By.id("react-burger-menu-btn")));
		clickOnElement(driver.findElement(By.id("logout_sidebar_link")));
	}
	@Test(priority = 11)
	public void logOutValidation() {
		String expectedLogInPageUrl = "https://www.saucedemo.com/";
		String actualLogInPageUrl = getApplicationUrl();
		Assert.assertEquals(expectedLogInPageUrl,actualLogInPageUrl , "log in  page not opened");
	}
	@AfterTest
	public void tearDown(){
		driver.close();
	}
}
