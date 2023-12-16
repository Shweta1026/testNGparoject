package abc;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import utilities.SeleniumUtility;

public class Flipkart extends SeleniumUtility{
	public static void main(String[] args) throws InterruptedException {
		SeleniumUtility sel=new SeleniumUtility();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.name("q")).sendKeys("samsung mobiles",Keys.ENTER);
		List<WebElement> mobList=driver.findElements(By.xpath("//div[@class='_1YokD2 _3Mn1Gg']/div"));
		for(WebElement mob:mobList) {
			if(mob.getText().contains("₹12,490")) {
				mob.click();
				break;
			}
		}
		
		driver.findElement(By.xpath("//button[text()='Buy Now']")).click();
	
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("pardeshishweta26@gmail.com");
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _20xBvF _3AWRsL']")).click();
		driver.findElement(By.xpath("//span[text()='Delivery Address']")).sendKeys("Pune");
		driver.findElement(By.xpath("//span[text()='Order Summary']")).sendKeys("abcd");
		driver.findElement(By.xpath("//span[text()='Payment Options']")).sendKeys("COD");
		
	}

}
