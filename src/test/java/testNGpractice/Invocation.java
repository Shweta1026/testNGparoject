package testNGpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Invocation {
	@Test(invocationCount=4,threadPoolSize=2)
	public void test1() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://randomuser.me/");
		//driver.manage().window().maximize();
		
		Thread.sleep(10000);
		driver.findElement(By.xpath("//ul[@id='values_list']/li[1]")).click();
		WebElement name=driver.findElement(By.xpath("//div[@class='details']/p[2]"));
		System.out.println("name is : "+name.getText());
		driver.findElement(By.xpath("//ul[@id='values_list']/li[2]")).click();
		WebElement email=driver.findElement(By.xpath("//div[@class='details']/p[2]"));
		System.out.println("email addr is : "+email.getText());
		driver.close();
	}

}
