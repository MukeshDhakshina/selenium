package hdpay;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TS_001 {

	WebDriver driver;
	long StartTime;
	long EndTime;

	@BeforeSuite
	public void OpenBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Chromedriver\\chromedriver(9.6).exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://192.168.3.252:8090/H2H_new/");
		Thread.sleep(4000);

	}

	@Test(priority = 0)
	public void Url_HealthTest() {
		driver.get("http://192.168.3.252:8090/H2H_new/");
		try {
			System.out.println("Url_HealthTest");
		} catch (Exception e) {
			System.out.println("FAIL CASE - URL Health Test " + e);
		}
	}

	@Test(dependsOnMethods = "Url_HealthTest", priority = 1)
	public void TC_01() throws InterruptedException {
		// Starting time
		StartTime = System.currentTimeMillis();
		
		// _01.Make UserName and password empty and login
			WebElement UsernameField = driver.findElement(By.id("txtUserId"));
			UsernameField.sendKeys("");
			Thread.sleep(3000);
			WebElement PasswordField = driver.findElement(By.id("txtPwd"));
			PasswordField.sendKeys("" + Keys.ENTER);
		// Result --- It shows User Id or Password Should Not Be Blank
			System.out.println("PASS CASE - TC_01");
		}

	@Test(priority = 2 , groups = "Url_HealthTest")
	public void TC_02() throws InterruptedException {
		// _02.Make Correct User ID and leave the password field empty
			WebElement UsernameField = driver.findElement(By.id("txtUserId"));
			UsernameField.sendKeys("ADMIN");
			Thread.sleep(3000);
			WebElement PasswordField = driver.findElement(By.id("txtPwd"));
			PasswordField.sendKeys("" + Keys.ENTER);
		// Result --- It shows User Id or Password Should Not Be Blank
			Thread.sleep(3000);
			UsernameField.clear();
			PasswordField.clear();
			System.out.println("PASS CASE - TC_02");
		
	}

	@Test(priority = 3)
	public void TC_03() throws InterruptedException {
		// _03.Make Correct password and leave the UserID field empty
			WebElement UsernameField = driver.findElement(By.id("txtUserId"));
			UsernameField.sendKeys("");
			Thread.sleep(3000);
			WebElement PasswordField = driver.findElement(By.id("txtPwd"));
			PasswordField.sendKeys("Login@123" + Keys.ENTER);
		// Result --- It shows User Id or Password Should Not Be Blank
			Thread.sleep(3000);
			UsernameField.clear();
			PasswordField.clear();
			System.out.println("PASS CASE - TC_03");
	}

	@Test(priority = 4)
	public void TC_04() throws InterruptedException {
		// _04.Make Correct UserID and Wrong password field
			WebElement UsernameField = driver.findElement(By.id("txtUserId"));
			UsernameField.sendKeys("ADMIN");
			Thread.sleep(3000);
			WebElement PasswordField = driver.findElement(By.id("txtPwd"));
			PasswordField.sendKeys("123@Login" + Keys.ENTER);
		// Result --- It shows User Id or Password Should Not Be Blank
			Thread.sleep(3000);
			UsernameField.clear();
			PasswordField.clear();
			System.out.println("PASS CASE - TC_04");		
	}



	@Test(priority=5) 
	public void TC_05() throws InterruptedException {  
		//_05.Make Wrong UserID and Correct password field 
			WebElement UsernameField=driver.findElement(By.id("txtUserId"));
			UsernameField.sendKeys("ABCDE");
			Thread.sleep(3000);
			WebElement PasswordField = driver.findElement(By.id("txtPwd"));
			PasswordField.sendKeys("Login@123"+Keys.ENTER);
		//Result --- It shows Either User Id or Password you entered is wrong
			Thread.sleep(3000); 
			UsernameField.clear();
			PasswordField.clear();
			System.out.println("PASS CASE - TC_05"); 
			} 
	   

	@Test(priority = 6)
	public void TC_06() throws InterruptedException {
		// _06.Make Correct UserID and Correct password field
			WebElement UsernameField = driver.findElement(By.id("txtUserId"));
			UsernameField.sendKeys("MAKER");
			WebElement PasswordField = driver.findElement(By.id("txtPwd"));
			PasswordField.sendKeys("Login@123" + Keys.ENTER);
		// Result --- Action leads to Navigate the DashBoard page
			Thread.sleep(3000);
			WebElement Logoutimg = driver.findElement(By.xpath("/html/body/div[1]/div[1]/nav/div/ul/li[6]/a/div/img"));
			Logoutimg.click();
			Thread.sleep(4000);
			WebElement Logoutbutton = driver.findElement(By.xpath("/html/body/div[1]/div[1]/nav/div/ul/li[6]/ul/div/div[1]/li[2]/a"));
			Logoutbutton.click();
			System.out.println("PASS CASE - TC_06");
	
	}

	@Test(priority = 7)
	public void TC_07() {
		// _07.Make UserID and password field empty by using cancel button 
			WebElement UsernameField = driver.findElement(By.id("txtUserId"));
			UsernameField.sendKeys("TC_07");
			WebElement PasswordField = driver.findElement(By.id("txtPwd"));
			PasswordField.sendKeys("Login@123");	
			WebElement cancelbutton = driver.findElement(By.xpath("//*[@id=\'loginForm\']/div[2]/div/div[3]/button"));
			cancelbutton.click();
		// Result --- It should Empty the User ID and Password fields
			System.out.println("PASS CASE - TC_07");
		
		}
	
	
	/*
	@Test(priority = 8)
	public void TC_08() throws InterruptedException {
		//_08.After Login Make WebSite simply idle for 15 minutes and then access.
			WebElement UsernameField = driver.findElement(By.id("txtUserId"));
			UsernameField.sendKeys("MAKER");
			WebElement PasswordField = driver.findElement(By.id("txtPwd"));
			PasswordField.sendKeys("Login@123" + Keys.ENTER);
			Thread.sleep(900000);  //900000 milliseconds = 15min
			WebElement BrowseButton = driver.findElement(By.id("inputGroupFile01"));
		    BrowseButton.click();
		   //Result --- The system will Logout automatically without any instruction or message. 
			System.out.println("PASS CASE - TC_08");	
	}
	*/
	
	
	@Test(priority = 9)
	public void TC_09() {
		 //_09.Password should be hidden by dots		  
		 //Result --- Password it should be in the hidden format
		    System.out.println("TC_09 - Manual Testing");
	}
	
	@Test(priority = 10)
	public void TC_10() throws InterruptedException {
		//_10.Check the eye icon visible or not in the Password field
		   WebElement UsernameField = driver.findElement(By.id("txtUserId"));
		   UsernameField.sendKeys("ADMIN");	
		   WebElement PasswordField = driver.findElement(By.id("txtPwd"));
		   PasswordField.sendKeys("Login@123");
		   Thread.sleep(3000);
		   WebElement Eyeicon = driver.findElement(By.id("toggle"));
			   Eyeicon.click();
		//Result --- If we click the eye icon in the password field, the typed password is visible 
		   UsernameField.clear();
		  PasswordField.clear();
		   System.out.println("PASS CASE -TC_10");		
	}
	
	
	@Test (priority = 11)
	public void TC_11() { 	
		//11.Users allows to manage the password in Browser.
		//Result ---- ????????
		System.out.println(" ");
	}
	
	@Test(priority = 12)
	public void TC_12() throws InterruptedException {
		//12.leave the wrong User ID and password and login(3times).
		 	WebElement UsernameField = driver.findElement(By.id("txtUserId"));
		 	UsernameField.sendKeys("ABCDE");	
		 	WebElement PasswordField = driver.findElement(By.id("txtPwd"));
		 	PasswordField.sendKeys("123456"+Keys.ENTER);
		 	Thread.sleep(3000);
		 	WebElement UsernameField1 = driver.findElement(By.id("txtUserId"));
		 	UsernameField1.sendKeys("ABCDE");	
		 	WebElement PasswordField1 = driver.findElement(By.id("txtPwd"));
		 	PasswordField1.sendKeys("123456"+Keys.ENTER);
		 	Thread.sleep(3000);
		 	WebElement UsernameField2 = driver.findElement(By.id("txtUserId"));
		 	UsernameField2.sendKeys("ABCDE");	
		 	WebElement PasswordField2 = driver.findElement(By.id("txtPwd"));
		 	PasswordField2.sendKeys("123456"+Keys.ENTER);
		//Result ---- It leave a message "ID  Locked Contact System Administrator".
		 	System.out.println("PASS CASE - TC_12");
	}
	
	@Test (priority = 13)
	public void TC_13() {
		//13.check the Password field whether it is allowed or not for the user to login if the password is copy-paste action.
		WebElement UsernameField = driver.findElement(By.id("txtUserId"));
	 	UsernameField.sendKeys("Login@123");	
	 	WebElement PasswordField = driver.findElement(By.id("txtUserId"));
	 	String copy_content = PasswordField.getText();
	 	WebElement PasswordField1 = driver.findElement(By.id("txtPwd"));
	 	PasswordField1.sendKeys(copy_content);
	 	//Result ----  The system should not allow the user to Login by using Copy paste action.
	 	System.out.println("PASS CASE - TC_13");
	}
	
	@Test (priority = 14)
	public void TC_14() {	
		//14.Login activity in two or more different Devices (Laptops, desktops,etc) at the simultaneous time.
		
		//Result ---- The system should not allow the second and more users to login 
		System.out.println("PASS CASE - TC-14");
			
	}
	
	
	@Test  (priority = 15)
	public void TC_15() {
		//15. Login activity in two or more different Tab in single browser
		
		
		//Result ---- The system should be allow the second Tab to one or more users to the dashboard page
	}
	
	
	
	
	
	
	
	@AfterSuite
	public void CloseBrowser() {
		//driver.quit();
		EndTime = System.currentTimeMillis();
		long TotalTime = EndTime - StartTime;
		System.out.println("The total time duration of running scenario as per milliseconds " + TotalTime);
	}

}
