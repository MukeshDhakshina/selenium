package login_page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Loginpage {

	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		//we told to system we are using Chrome browser and set path 
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Chromedriver\\chromedriver(9.6).exe");

		// we open the new Chrome browser
		WebDriver driver = new ChromeDriver();

		//After opening the Chrome we need to maximize the window
		driver.manage().window().maximize();

		//In browser where we go to?
		driver.get("http://192.168.3.252:8090/H2H_V2/");
		
		//_01.Make UserName and password empty and login		
		   WebElement UsernameField   = driver.findElement(By.id("txtUserId"));
		   UsernameField.sendKeys("");
		   
		   WebElement PasswordField   = driver.findElement(By.id("txtPwd"));
		   PasswordField.sendKeys(""+Keys.ENTER);
		   //Result --- It shows User Id or Password Should Not Be Blank
		   
		   Thread.sleep(3000);
		   UsernameField.clear();
		   PasswordField.clear();
		   
		//_02.Make Correct User ID and leave the password field empty		   
		   UsernameField.sendKeys("ADMIN");		
		   PasswordField.sendKeys(""+Keys.ENTER);
		   //Result --- It shows User Id or Password Should Not Be Blank
		   Thread.sleep(3000);
		   
		   Thread.sleep(3000);
		   UsernameField.clear();
		   PasswordField.clear();		   		   
		   
       //_03.Make Correct password and leave the UserID field empty		   
		   UsernameField.sendKeys("");
		
		   PasswordField.sendKeys("Login@123"+Keys.ENTER);		   
		   //Result --- It shows User Id or Password Should Not Be Blank   
		   Thread.sleep(3000);
		   UsernameField.clear();
		   PasswordField.clear();
		   
      //_04.Make Correct UserID and Wrong password field 	   
		   UsernameField.sendKeys("ADMIN");
		
		   PasswordField.sendKeys("123@Login"+Keys.ENTER);
		   //Result --- It shows User Id or Password Should Not Be Blank   
		   Thread.sleep(3000);
		   UsernameField.clear();
		   PasswordField.clear();
		   
	 //_05.Make Wrong UserID and Correct password field 	   
		   UsernameField.sendKeys("ABCDE");
		
		   PasswordField.sendKeys("Login@123"+Keys.ENTER);
		   //Result --- It shows Either User Id or Password you entered is wrong  
		   Thread.sleep(3000);
		   UsernameField.clear();
		   PasswordField.clear();
		   
     //_06.Make Correct UserID and Correct password field 	   
		   UsernameField.sendKeys("ADMIN");
		
		   PasswordField.sendKeys("Login@123"+Keys.ENTER);
		   //Result --- Action leads to Navigate the DashBoard page  
		   Thread.sleep(3000);
		   WebElement Logoutimg = driver.findElement(By.xpath("/html/body/div[1]/div[1]/nav/div/ul/li[6]/a/div/img"));
		   Logoutimg.click();
		   Thread.sleep(3000);
		   WebElement Logoutbutton = driver.findElement(By.xpath("/html/body/div[1]/div[1]/nav/div/ul/li[6]/ul/div/div[1]/li[2]/a"));
		   Logoutbutton.click();
		   
     //_07.Make UserID and password field empty	by using cancel button 
		   
		   UsernameField = driver.findElement(By.id("txtUserId"));
		   UsernameField.sendKeys("ADMIN");
		   
		   PasswordField = driver.findElement(By.id("txtPwd"));
		   PasswordField.sendKeys("Login@123");
		   
		   Thread.sleep(3000);
		   WebElement cancelbutton =  driver.findElement(By.xpath("//*[@id=\'loginForm\']/div[2]/div/div[3]/button"));
		   cancelbutton.click();
		   //Result --- It should Empty the User ID and Password fields  	   
		   
     //_08.After Login Make WebSite simply idle for 15 minutes and then access.
		   
		   //Result --- The system will Logout automatically without any instruction or message. 
   
     //_09.Password should be hidden by dots
		   
		   //Result --- Password it should be in the hidden format 
		   	   
		   
     //_10.Check the eye icon visible or not in the Password field
		   UsernameField.sendKeys("ADMIN");
		   
		   PasswordField.sendKeys("Login@123");
		   Thread.sleep(3000);
		   
		   
		   WebElement Eyeicon = driver.findElement(By.id("toggle"));
		   Eyeicon.click();
		   
		   //Result --- If we click the eye icon in the password field, the typed password is visible  		  
	}

}



