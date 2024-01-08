package mypackage;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {

	public static void main(String[] args) throws IOException  {
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://demoqa.com/broken");
		driver.manage().window().maximize();
		
		List<WebElement> links=driver.findElements(By.tagName("a"));
		int brokenLink=0;
		
		System.out.println("number of links : "+links.size());
		
		for(WebElement ele:links) {
			String url=ele.getAttribute("href");
			
			if(url==null|| url.isEmpty()) {
				System.out.println(url+"this link is empty");
				continue;
			}
			
			URL link=new URL(url);
			try {
				HttpURLConnection HttpUrlConnect=(HttpURLConnection) link.openConnection();
				HttpUrlConnect.setConnectTimeout(5000);
				HttpUrlConnect.connect();
				if(HttpUrlConnect.getResponseCode()>=400) {
					System.out.println(link+" is broken link");
					brokenLink++;
				}
				else {
					System.out.println(link+" is valid link");
				}
				
				
			} catch (IOException e) {
			
			}
			
			
			
		}
		System.out.println("number of broken links are : "+brokenLink);
		
	}

}
