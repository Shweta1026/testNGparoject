package testNGpractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import utilities.SeleniumUtility;

public class OrangeHRM extends SeleniumUtility {
	@BeforeTest
	public void startUp() {
		driver = setUp("chrome", "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@Test(priority = 1)
	public void logIn() {
		typeInput(driver.findElement(By.name("username")), "Admin");
		typeInput(driver.findElement(By.name("password")), "admin123");
		clickOnElement(driver.findElement(By.className("orangehrm-login-button")));
	}

	@Test(priority = 2)
	public void logInValidation() {
		String expectedHomeTitle = "OrangeHRM";
		System.out.println("expected home page URL : " + expectedHomeTitle);
		String actualHomeTitle = driver.getTitle();
		//waitUntilPageTitleMatched(actualHomeTitle);
		Assert.assertEquals(actualHomeTitle, expectedHomeTitle, "log is not done successfully");
	}

	@Test(priority = 3)
	public void addEmployee() {
		clickOnElement(driver.findElement(By.cssSelector("ul.oxd-main-menu>*:nth-child(2)>a>span")));
		clickOnElement(driver.findElement(By.linkText("Add Employee")));
		typeInput(driver.findElement(By.name("firstName")), "Kirti");
		typeInput(driver.findElement(By.name("lastName")), "lonkar");
		WebElement empId = driver.findElement(By.xpath("//*[@class='oxd-grid-2 orangehrm-full-width-grid']/div/div/div[2]/input"));

		Actions act = new Actions(driver);
		act.click(empId).perform();
		act.doubleClick(empId).perform();
		act.sendKeys(Keys.BACK_SPACE).sendKeys("2000").perform();

		clickOnElement(driver.findElement(By.className("oxd-button--secondary")));
	}
	@Test(priority = 4)
	public void addEmployeeValidation() {
		clickOnElement(driver.findElement(By.cssSelector("ul.oxd-main-menu>*:nth-child(2)>a>span")));
		clickOnElement(driver.findElement(By.linkText("Employee List")));
		typeInput(driver.findElement(By.cssSelector("input[placeholder='Type for hints...']")),"Kirti lonkar");
		typeInput(driver.findElement(By.cssSelector(".oxd-form-row>div>*:nth-child(2)>div>*:nth-child(2)>input")),"2000");
        clickOnElement(driver.findElement(By.className("oxd-button--secondary")));
   }
	@Test(priority = 5)
	public void updateEmployee() {
		// update employee info
	     //clickOnElement(driver.findElement(By.cssSelector("orangehrm-container>div>*:nth-child(2)>div")));
	     clickOnElement(driver.findElement(By.cssSelector(".oxd-icon.bi-pencil-fill")));
	     clickOnElement(driver.findElement(By.linkText("Job")));
		 clickOnElement(driver.findElement(By.cssSelector(".oxd-select-text.oxd-select-text--active")));

		  List<WebElement> jobTitles = driver.findElements(By.xpath("//*[@role='listbox']/div"));
		  System.out.println(jobTitles.size());
		 for(int i=0;i<jobTitles.size();i++) {
			System.out.println(jobTitles.get(i).getText());
		 }
			    
			jobTitles = driver.findElements(By.xpath("//*[@role='listbox']/div"));
			try {
			 for (int i = 0; i < jobTitles.size(); i++) {
			if(driver.findElements(By.xpath("//*[@role='listbox']/div")).get(i).getText().contains("QA Lead")) {
			jobTitles.get(i).click();
					}
			}
			}
			catch(IndexOutOfBoundsException e) {
				
			}
		   clickOnElement(driver.findElement(By.xpath("//button[@type='submit']")));
	}
	@Test(priority = 6)
	public void updateValidation() {
		// Verify updated job title
				clickOnElement(driver.findElement(By.linkText("Employee List")));
				typeInput(driver.findElement(By.cssSelector("input[placeholder='Type for hints...']")),"Kirti lonkar");
				typeInput(driver.findElement(By.cssSelector(".oxd-form-row>div>*:nth-child(2)>div>*:nth-child(2)>input")),"2000");
				clickOnElement(driver.findElement(By.className("oxd-button--secondary")));

				String expectedJobTitle = "QA Lead";
				WebElement jTitle = driver.findElement(
						By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[5]/div"));
				String actualJobTitle = jTitle.getText();
			System.out.println("is job title updated? : " + expectedJobTitle.equals(actualJobTitle));
				
		
	}
	@Test(priority = 7)
	public void deleteEmployee() {
		//clickOnElement(driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[1]/div/div/label/span/i")));
		clickOnElement(driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[9]/div/button[1]/i")));
		clickOnElement(driver.findElement(By.xpath("//*[@id='app']/div[3]/div/div/div/div[3]/button[2]")));
	}
	@AfterTest
	public void logOut() {
		clickOnElement(driver.findElement(By.cssSelector(".oxd-topbar>div>*:nth-child(2)>ul>li>span")));
		clickOnElement(driver.findElement(By.cssSelector(".oxd-topbar>div>*:nth-child(2)>ul>li>ul>*:nth-child(4)")));
	}
	
}
