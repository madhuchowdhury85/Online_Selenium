package day4_assignment1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Program7 {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.gecko.driver", ".\\Drivers\\geckodriver.exe");
		WebDriver driver= new FirefoxDriver();
        driver.manage().window().maximize();
		
		driver.get("https://www.google.co.in");
				
	    System.out.println("Google title is "+driver.getTitle());
	    
	     
	    System.out.println("Google url is "+driver.getCurrentUrl());
	    
	    driver.navigate().to("https://www.yahoo.com/");
		
	    System.out.println("Yahoo title is "+driver.getTitle());
	    
	    System.out.println("Yahoo url is "+driver.getCurrentUrl());
	    
	    driver.navigate().refresh();
	    driver.navigate().back();
	    
	    System.out.println("Back to Google page");
	    driver.close();
	    
	    System.out.println("Browser closed");
	
	}

}
