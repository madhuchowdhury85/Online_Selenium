package day4_assignment1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Program6 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.google.co.in");
		Thread.sleep(5000);
		
		driver.navigate().refresh();
		System.out.println("First Refresh");
		
		Thread.sleep(5000);
		
		driver.findElement(By.id("lst-ib")).sendKeys(Keys.F5);
		System.out.println("Second Refresh");
		
		Thread.sleep(5000);
		
		Actions act= new Actions(driver);
		act.sendKeys(Keys.F5).perform();
		
		System.out.println("Third Refresh");
		
		driver.quit();
		
	}

}
