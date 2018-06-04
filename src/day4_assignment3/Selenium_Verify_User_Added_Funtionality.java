package day4_assignment3;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Selenium_Verify_User_Added_Funtionality {

	public static void main(String[] args) throws InterruptedException 
	{

		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		
		//Open Below application
		driver.get("http://opensource.demo.orangehrmlive.com/");
		
		String parent_window=driver.getWindowHandle();
				
		//Validation -Page title should be OrangeHRM
		if(driver.getTitle().equals("OrangeHRM"))
		{
			System.out.println("OrangeHRM application is loaded");
		}

		//Validation- All Social media link should point to respective url---Not sure
		driver.findElement(By.xpath("//a[contains(@href,'www.linkedin.com')]")).click();
		
		driver.findElement(By.xpath("//a[contains(@href,'www.facebook.com')]")).click();
		
		driver.findElement(By.xpath("//a[contains(@href,'twitter.com')]")).click();
		driver.findElement(By.xpath("//a[contains(@href,'www.youtube.com')]")).click();
		
		Set <String> child_windows=driver.getWindowHandles();
		
		for(String child:child_windows)
		{
			if(!parent_window.equalsIgnoreCase(child))
			{
				driver.switchTo().window(child);
				
				System.out.println(driver.getTitle());
				
				driver.close();
			}
				
 		}
		
		driver.switchTo().window(parent_window); 
		
		//login page- Login with below credentials
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin");
		driver.findElement(By.id("btnLogin")).click();
		
		WebElement admin_tab= driver.findElement(By.xpath("//a[@id='menu_admin_viewAdminModule']"));
		String welcome_txt= driver.findElement(By.xpath("//a[@id='welcome']")).getAttribute("innerHTML");
		
		//Validation 1- Url should contain dashboard keyword		
		if(driver.getCurrentUrl().contains("dashboard"))
		{
			System.out.println("User is logged in successfully");
		}
		
		//Validation 2- Admin tab should display
		if (admin_tab.isDisplayed())
		{
			System.out.println("Admin tab is displayed");
		}
		
		//Validation 3- Welcome Admin should display at right panel
		if(welcome_txt.equals("Welcome Admin"))
		{
			System.out.println("Welcome Admin is displayed at right panel");
		}
		
		//Click on Admin tab
		admin_tab.click();	
		
		//Admin Page
		//Validation 1- url should contain admin/viewSystemUsers
		if(driver.getCurrentUrl().contains("admin/viewSystemUsers"))
		{
			System.out.println("User is landed to Admin page");
		}
		
		WebElement add_btn=driver.findElement(By.xpath("//input[@id='btnAdd' and @value='Add']"));
	    WebElement delete_btn=driver.findElement(By.xpath("//input[@id='btnDelete' and @value='Delete']"));
	    WebElement search_btn=driver.findElement(By.xpath("//input[@id='searchBtn' and @value='Search']"));
	    WebElement reset_btn=driver.findElement(By.xpath("//input[@id='resetBtn' and @value='Reset']"));
	    
	    //Validation 2- Add, Delete, Search, Reset button should be displayed
	    if(add_btn.isDisplayed())
	    {
	    	System.out.println("Add button is displayed");
	    }
	    if(delete_btn.isDisplayed())
	    {
	    	System.out.println("Delete button is displayed");
	    }
	    if(search_btn.isDisplayed())
	    {
	    	System.out.println("Search button is displayed");
	    }
	    if(reset_btn.isDisplayed())
	    {
	    	System.out.println("Reset button is displayed");
	    }
	    
	    
	    //Click on Add button
	    add_btn.click();
	    
	    //Add User Page
	    //Validation 1- url should contain saveSystemUser
	    if(driver.getCurrentUrl().contains("saveSystemUser"))
	    {
	    	System.out.println("User is landed to Add user page");
	    }
	    
	    String add_user_header= driver.findElement(By.xpath("//h1[@id='UserHeading']")).getAttribute("innerHTML");
	    
	    //Validation 2- Add User H1 should display 
	    if(add_user_header.equals("Add User"))
	    {
	    	System.out.println("Add User header is displayed");
	    }
	    
	    WebElement user_role=driver.findElement(By.id("systemUser_userType"));
	    WebElement emp_name=driver.findElement(By.id("systemUser_employeeName_empName"));
	    WebElement username=driver.findElement(By.id("systemUser_userName"));
	    WebElement status=driver.findElement(By.id("systemUser_status"));
	    WebElement password=driver.findElement(By.id("systemUser_password"));
	    WebElement confirm_pwd=driver.findElement(By.id("systemUser_confirmPassword"));
	    WebElement save_btn=driver.findElement(By.id("btnSave"));
	    
	    String username_testdata="Selenium500";
	    String password_testdata="Selenium500";
	    String emp_name_testdata= "Jasmine Morgan";
	    
	    Select sel_status= new Select(status);
	    Select sel_role= new Select(user_role);
	    
	   //Validation 1- Verify Status dropdown is Selected to enable
	    if(sel_status.getFirstSelectedOption().getText().equals("Enabled"))
		   
	   {
		   System.out.println("Status dropdown is Selected to enable");
	   }
	    
	    //driver.manage().deleteAllCookies();
	    
	    //Fill Add User Form
	    sel_role.selectByVisibleText("ESS");
	    emp_name.sendKeys(emp_name_testdata);
	    username.sendKeys(username_testdata);
	    password.sendKeys(password_testdata);
	    confirm_pwd.sendKeys(password_testdata);
	    save_btn.click();
	    
	    Thread.sleep(3000);
	    
	   WebElement new_user= driver.findElement(By.xpath("//div[@class='inner']//td//a[text()='"+username_testdata+"']"));
	   
	   //User Management page
	   //Validation 2- User should be created
	   if(new_user.isDisplayed())
	   {
		   System.out.println("User is created");
	   }
	    
	   WebElement search_username=driver.findElement(By.xpath("//input[@id='searchSystemUser_userName' and @type='text']"));
	   WebElement search_btn_user= driver.findElement(By.xpath("//input[@id='searchBtn' and @type='button']"));
	   	   
	   search_username.sendKeys(username_testdata);
	   //Click on Search button
	   search_btn_user.click();
	   
	   Thread.sleep(3000);
	   
	   //Search result page
	   WebElement new_username_search= driver.findElement(By.xpath("//div[@class='inner']//td//a[text()='"+username_testdata+"']"));
	   WebElement new_emp_search= driver.findElement(By.xpath("//div[@class='inner']//td[text()='"+emp_name_testdata+"']"));
	   WebElement new_status_search= driver.findElement(By.xpath("//div[@class='inner']//td[text()='Enabled']"));
	   WebElement new_user_chkbox= driver.findElement(By.xpath("//div[@class='inner']//td//a[text()='"+username_testdata+"']//preceding::input[contains(@id,'ohrmList_chkSelectRecord')]"));
	   WebElement new_user_delete_btn=driver.findElement(By.xpath("//input[@id='btnDelete' and @value='Delete']"));
	     
	   
	   //Validation 1- Usersname should be Selenium***
	   if(new_username_search.getText().equals(username_testdata))
	   {
		   System.out.println("Usersname is "+username_testdata);
	   }
	   
	   //Validation 2- Employee Name should be XXXX
	   if(new_emp_search.getText().equals(emp_name_testdata))
	   {
		   System.out.println("Employee name is "+emp_name_testdata);
	   }
	   
	   //Validation 3- Status should be enabled
	   if(new_status_search.getText().equals("Enabled")) 
	   {
		   System.out.println("Status is enabled");
	   }
	   
	   //click on check box
	   new_user_chkbox.click();
	   
	   //click on Delete button 
	   new_user_delete_btn.click();
	   
	   //click on ok button for confirmation
	   driver.findElement(By.xpath("//input[@id='dialogDeleteBtn' and @value='Ok']")).click();
	   
	   Thread.sleep(3000);
       driver.findElement(By.id("searchSystemUser_userName")).sendKeys(username_testdata);
       
       //Click on Search button
       driver.findElement(By.id("searchBtn")).click();
	   
	     
	   Thread.sleep(2000);
	   
	   WebElement no_user_msg=driver.findElement(By.xpath("//div[@class='inner']//td[1]"));
	   
	   //You should get No Records Found message.
	   if(no_user_msg.getText().equalsIgnoreCase("No Records Found"))
	   {
		  System.out.println("User is deleted and no records found"); 
	   }
	   
	   //Click on Welcome Admin 
	   driver.findElement(By.xpath("//a[@id='welcome']")).click();
	   
	   Thread.sleep(2000);
	   
	   //Click on Logout
	   driver.findElement(By.xpath("//a[text()='Logout']")).click();
	   
	  //User should be logged out
	   //Validation 1- User should contain login
	   if(driver.getCurrentUrl().contains("login"))
		   
	   {
		   System.out.println("User is back to login page");
	   }
	   
	   
	   //Validation 2- Title should be OrangeHRM
	   if(driver.getTitle().equals("OrangeHRM"))
		   
	   {
		   System.out.println("User is logged out");
	   }
	   
	   driver.quit();
	   
	}
}
