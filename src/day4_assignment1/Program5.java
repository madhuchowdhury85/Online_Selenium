package day4_assignment1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Program5 {

	public static void main(String[] args) 
	{


		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.google.co.in");
		
		 
		
	    String google_title= driver.getTitle();
	    System.out.println("Google title is "+google_title);
	    
	    String google_url= driver.getCurrentUrl();
	    
	    System.out.println("Google url is "+google_url);
	    
	    driver.navigate().to("https://www.yahoo.com/");
		
	    String yahoo_title= driver.getTitle();
	    System.out.println("Yahoo title is "+yahoo_title);
	    
	    String page_url= driver.getCurrentUrl();
	    
	    System.out.println("Yahoo url is "+page_url);
	    
	    driver.navigate().refresh();
	    driver.navigate().back();
	    System.out.println("Back to Google page");
	    driver.close();
	    
	    System.out.println("Browser closed");
	
	

	}

}
