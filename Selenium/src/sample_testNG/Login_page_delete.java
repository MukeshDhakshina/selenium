package sample_testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Login_page_delete {
	
	WebDriver driver;
	long StartTime;
	long EndTime ;
	

	@BeforeSuite 
	public void OpenBrowser() {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Chromedriver\\chromedriver(9.6).exe");
		driver = new ChromeDriver();
		driver.get("http://192.168.3.252:8090/H2H_new/");
		driver.manage().window().maximize();

	}

	@Test(priority=0)
	public void Url_HealthTest() {
		driver.get("http://192.168.3.252:8090/H2H_new/");
		try {
			System.out.println("Url_HealthTest");
		} catch (Exception e) {
			
		}
		
	}

	
	@Test(dependsOnMethods = "Url_HealthTest",priority=1)
	public void Scenario_01() {
		//Starting time
		StartTime = System.currentTimeMillis();

		//_01.Make UserName and password empty and login		
		WebElement UsernameField =driver.findElement(By.id("txtUserId"));
		UsernameField.sendKeys("");
		WebElement PasswordField = driver.findElement(By.id("txtPwd"));
		PasswordField.sendKeys(""+Keys.ENTER);
		//Result --- It shows User Id or Password Should Not Be Blank
		try {
			System.out.println("Scenario_01");
		} catch (Exception e) {
			
		}
	}

	@Test(priority=2)
	public void Scenario_02() {
		//_02.Make Correct User ID and leave the password field empty	
		WebElement UsernameField =driver.findElement(By.id("txtUserId"));
		UsernameField.sendKeys("ADMIN");
		WebElement PasswordField = driver.findElement(By.id("txtPwd"));
		PasswordField.sendKeys("Login"+Keys.ENTER);
		//Result --- It shows User Id or Password Should Not Be Blank
		try {
			System.out.println("Scenario_02");
		} catch (Exception e) {
			
		}
	}	
	
	
	@Test(priority=3)
	public void Scenario_03() {
		  //_03.Make Correct password and leave the UserID field empty	
		  WebElement UsernameField =driver.findElement(By.id("txtUserId"));
		  UsernameField.sendKeys("");
		  WebElement PasswordField = driver.findElement(By.id("txtPwd"));
		  PasswordField.sendKeys("Login@123"+Keys.ENTER);		   
		  //Result --- It shows User Id or Password Should Not Be Blank
		  try {
				System.out.println("Scenario_03");
			} catch (Exception e) {
				
			}
	}
	
	@Test(priority=4)
	public void Scenario_04() {
		  //_04.Make Correct UserID and Wrong password field 	   
		  WebElement UsernameField =driver.findElement(By.id("txtUserId"));
		  UsernameField.sendKeys("ADMIN");
		  WebElement PasswordField = driver.findElement(By.id("txtPwd"));
		  PasswordField.sendKeys("123@Login"+Keys.ENTER);
		  //Result --- It shows User Id or Password Should Not Be Blank	
		  try {
				System.out.println("Scenario_04");
			} catch (Exception e) {
				
			}
	}
	
	@Test(priority=5)
	public void Scenario_05() {
		  //_05.Make Wrong UserID and Correct password field 
		  WebElement UsernameField =driver.findElement(By.id("txtUserId"));
		  UsernameField.sendKeys("");
		  WebElement PasswordField = driver.findElement(By.id("txtPwd"));
		  PasswordField.sendKeys("Login@123"+Keys.ENTER);
		  //Result --- It shows Either User Id or Password you entered is wrong 	
		  try {
				System.out.println("Scenario_05");
			} catch (Exception e) {
				
			}
	}

	
	
	@AfterSuite
	public void CloseBrowser() {
		driver.quit();
		EndTime = System.currentTimeMillis();
		long TotalTime =  EndTime-StartTime;
		System.out.println("Total duration of scenario is "+TotalTime);		
	}


	
	

}
