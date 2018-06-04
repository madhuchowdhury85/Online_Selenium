package day4_assignment2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Verify_user_registration_form {

	public static void main(String[] args) throws InterruptedException
	{

		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://demoqa.com/");
		
		String page_title= driver.getTitle();
		
		//Validation -title should contain WordPress keyword
		if(page_title.contains("WordPress"))
		{
			System.out.println("Application is loaded");
		}
		else
		{
			System.out.println("Application is not loaded properly");
		}
		
		WebElement registartion_btn=driver.findElement(By.xpath("//a[text()='Registration']"));
		
		//Verify registration link is enabled and after click new page 
		boolean status= registartion_btn.isEnabled();
		if (status)
		{
			System.out.println("Registration button is enabled");
			registartion_btn.click();
		}
		
		else
		{
			System.out.println("Registration button is not enabled");
		}
		
		Thread.sleep(3000);
		
		// page url should have registration keyword
		if(driver.getCurrentUrl().contains("registration"))
		{
			System.out.println("Landed to registration page");
		}
		
		//registration form 		
		WebElement first_name=driver.findElement(By.name("first_name"));
		WebElement last_name= driver.findElement(By.name("last_name"));
		WebElement marital_status=driver.findElement(By.xpath("//input[@value='married' and @type='radio']"));
		WebElement hobby= driver.findElement(By.xpath("//input[@value='reading' and @type='checkbox']"));
		WebElement country=driver.findElement(By.xpath("//*[contains(@id,'dropdown')]"));
		WebElement DOB_month=driver.findElement(By.xpath("//*[contains(@id,'mm_date')]"));
	    WebElement DOB_day=driver.findElement(By.xpath("//*[contains(@id,'dd_date')]"));
		WebElement DOB_year=driver.findElement(By.xpath("//*[contains(@id,'yy_date')]"));
		WebElement phn_no=driver.findElement(By.xpath("//input[contains(@id,'phone')]"));
		WebElement username=driver.findElement(By.id("username"));
		WebElement email= driver.findElement(By.xpath("//input[contains(@id,'email')]"));
		WebElement profile_pic= driver.findElement(By.xpath("//input[contains(@id,'profile_pic')]"));
		WebElement password= driver.findElement(By.name("password"));
		WebElement conf_pwd=driver.findElement(By.xpath("//input[contains(@id,'confirm_password') and @type='password']"));
		WebElement submit_btn= driver.findElement(By.xpath("//input[@name='pie_submit' and @type='submit']"));
		
		
		//actions
		first_name.sendKeys("m_Test");
		last_name.sendKeys("c_Test");
		marital_status.click();
		hobby.click();
		
		Select sel_country= new Select(country);
		Select sel_month= new Select(DOB_month);
		Select sel_day= new Select(DOB_day);
		Select sel_year= new Select(DOB_year);
		sel_country.selectByVisibleText("India");
		sel_month.selectByVisibleText("10");
		sel_day.selectByVisibleText("6");
		sel_year.selectByVisibleText("1985");
		
		phn_no.sendKeys("1234567898");
		username.sendKeys("Test_d_e");
		email.sendKeys("test_d_e@gmail.com");
		profile_pic.sendKeys("C:\\Users\\Owner\\Pictures\\Saved Pictures\\tulip.jpeg");
		password.sendKeys("test@123");
		conf_pwd.sendKeys("test@123");
		
		//submit the form		
		submit_btn.click();
		
		Thread.sleep(3000);
		
		//Verify registration success
		WebElement confirm_registration= driver.findElement(By.xpath("//p[contains(text(),'Thank you for your registration')]"));
		String confirm_registration_text= confirm_registration.getText();
		
		if(confirm_registration_text.equals("Thank you for your registration"))
			
		{
			System.out.println("Registration completed");
		}
		
		else
		{
			System.out.println("Error occured during registration");
		}
		
		driver.quit();

	}

}
