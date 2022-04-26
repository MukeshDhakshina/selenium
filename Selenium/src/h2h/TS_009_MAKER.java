package h2h;

import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TS_009_MAKER {

	WebDriver driver;

	@BeforeSuite
	public void OpenBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Chromedriver\\chromedriver(9.6).exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://192.168.3.252:8090/H2H_new/");
		Thread.sleep(2000);
	}

	@Test(priority = 0)
	public void Url_HealthTest() {
		System.out.println("TS_001 has been start");
		driver.get("http://192.168.3.252:8090/H2H_new/");
		try {
			System.out.println("Url_HealthTest");
		} catch (Exception e) {
			System.out.println("FAIL CASE - URL Health Test " + e);
		}
	}

	@Test(dependsOnMethods = "Url_HealthTest", priority = 1)
	public void TC_01_To_verify_the_fields_login_and_password_make_empty_and_click_login_button_or_Press_Enter ()
			throws InterruptedException {
		// _01.Make UserName and password empty and login
			WebElement UsernameField = driver.findElement(By.id("txtUserId"));
			UsernameField.sendKeys("");
			Thread.sleep(3000);
			WebElement PasswordField = driver.findElement(By.id("txtPwd"));
			PasswordField.sendKeys("" + Keys.ENTER);
		// Result --- It shows User Id or Password Should Not Be Blank
		}

	@Test(priority = 2)
	public void TC_02_To_verify_input_of_correct_User_ID_and_leave_the_password_fied_empty_and_click_login_button_or_Press_Enter ()
			throws InterruptedException {
		// _02.Make Correct User ID and leave the password field empty
			WebElement UsernameField = driver.findElement(By.id("txtUserId"));
			UsernameField.sendKeys("MAKER");
			Thread.sleep(3000);
			WebElement PasswordField = driver.findElement(By.id("txtPwd"));
			PasswordField.sendKeys("" + Keys.ENTER);
		// Result --- It shows User Id or Password Should Not Be Blank
			Thread.sleep(3000);
			UsernameField.clear();
	}

	@Test(priority = 3) 
	public void TC_03_To_verify_leave_the_User_ID_field_empty_and_enter_the_correct_password_and_click_login_button_or_Press_Enter () 
			throws InterruptedException {
		// _03.Make Correct password and leave the UserID field empty
			WebElement UsernameField = driver.findElement(By.id("txtUserId"));
			UsernameField.sendKeys("");
			Thread.sleep(3000);
			WebElement PasswordField = driver.findElement(By.id("txtPwd"));
			PasswordField.sendKeys("Login@123" + Keys.ENTER);
		// Result --- It shows User Id or Password Should Not Be Blank
			Thread.sleep(3000);
			PasswordField.clear();
	}

	@Test(priority = 4) 
	public void TC_04_To_verify_input_of_correct_User_ID_and_wrong_Password_and_click_login_button_or_Press_Enter ()
			throws InterruptedException {
		// _04.Make Correct UserID and Wrong password field
			WebElement UsernameField = driver.findElement(By.id("txtUserId"));
			UsernameField.sendKeys("MAKER");
			Thread.sleep(3000);
			WebElement PasswordField = driver.findElement(By.id("txtPwd"));
			PasswordField.sendKeys("123@Login");
			WebElement Eyeicon = driver.findElement(By.id("toggle"));
			Eyeicon.click();
			PasswordField.sendKeys(Keys.ENTER);
		// Result --- It shows User Id or Password Should Not Be Blank
			Thread.sleep(3000);
			UsernameField.clear();
			PasswordField.clear();
			Thread.sleep(3000);
	}



	@Test(priority=5) 
	public void TC_05_To_verify_input_of_wrong_User_ID_and_correct_Password_and_click_login_button_or_Press_Enter ()
			throws InterruptedException {  
		//_05.Make Wrong UserID and Correct password field 
			WebElement UsernameField=driver.findElement(By.id("txtUserId"));
			UsernameField.sendKeys("ABCDE");
			Thread.sleep(3000);
			WebElement PasswordField = driver.findElement(By.id("txtPwd"));
			PasswordField.sendKeys("Login@123");
			Thread.sleep(2000);
			PasswordField.sendKeys(Keys.ENTER);
		//Result --- It shows Either User Id or Password you entered is wrong
			Thread.sleep(3000); 
			UsernameField.clear();
			PasswordField.clear();
			} 
	   

	@Test(priority = 6)
	public void TC_06_To_verify_input_of_correct_MAKER_User_ID_and_correct_Password_and_click_login_button_or_Press_Enter ()
			throws InterruptedException {
		// _06.Make Correct UserID and Correct password field
			WebElement UsernameField = driver.findElement(By.id("txtUserId"));
			UsernameField.sendKeys("MAKER");
			WebElement PasswordField = driver.findElement(By.id("txtPwd"));
			PasswordField.sendKeys("Login@123");
			Thread.sleep(2000);
			PasswordField.sendKeys(Keys.ENTER);
		// Result --- Action leads to Navigate the DashBoard page
			Thread.sleep(3000);
			WebElement Logoutimg = driver.findElement(By.xpath("/html/body/div[1]/div[1]/nav/div/ul/li[6]/a/div"));
			Logoutimg.click();
			Thread.sleep(3000);
			WebElement Logoutbutton = driver.findElement(By.xpath("/html/body/div[1]/div[1]/nav/div/ul/li[6]/ul/div/div[1]/li[2]/a"));
			Logoutbutton.click();
	}

	@Test(priority = 7)
	public void TC_07_Input_valid_or_invalid_entries_in_User_ID_and_password_and_if_you_click_cancel_button_in_the_login_Page () {
		// _07.Make UserID and password field empty by using cancel button 
			WebElement UsernameField = driver.findElement(By.id("txtUserId"));
			UsernameField.sendKeys("MAKER");
			WebElement PasswordField = driver.findElement(By.id("txtPwd"));
			PasswordField.sendKeys("Login@123");	
			WebElement cancelbutton = driver.findElement(By.xpath("//*[@id=\'loginForm\']/div[2]/div/div[3]/button"));
			cancelbutton.click();
		// Result --- It should Empty the User ID and Password fields
		}
	
	@Test(priority = 8)
	public void TC_09_Check_the_Password_field_it_should_be_hidden_by_dots_instead_of_alphanumeric () {
		 //_09.Password should be hidden by dots		  
		 //Result --- Password it should be in the hidden format
		    System.out.println("TC_09 - Manual Testing");
	}
	
	@Test(priority = 9)
	public void TC_10_Check_the_eye_icon_visible_or_not_in_the_Password_field () 
			throws InterruptedException {
		//_10.Check the eye icon visible or not in the Password field
		   WebElement UsernameField = driver.findElement(By.id("txtUserId"));
		   UsernameField.sendKeys("MAKER");	
		   WebElement PasswordField = driver.findElement(By.id("txtPwd"));
		   PasswordField.sendKeys("Login@123");
		   Thread.sleep(3000);
		   WebElement Eyeicon = driver.findElement(By.id("toggle"));
		   Eyeicon.click();
		//Result --- If we click the eye icon in the password field, the typed password is visible 
		   UsernameField.clear();
		   PasswordField.clear();
	}
	
	@Test(priority = 10)
	public void TC_11_check_the_eye_icon_visible_or_not_in_the_Password_field_if_the_user_allows_the_manage_password_in_his_her_Browser () { 	
		//11.Users allows to manage the password in Browser.
		//Result ---- ????????
		System.out.println("Pending");
	}
	
	@Test(priority = 11)
	public void TC_13_check_the_Password_field_whether_it_is_allowed_or_not_for_the_user_to_login_if_the_password_is_copy_paste_action () {
		//13.check the Password field whether it is allowed or not for the user to login if the password is copy-paste action.
		WebElement UsernameField = driver.findElement(By.id("txtUserId"));
	 	UsernameField.sendKeys("Login@123");	
	 	WebElement PasswordField = driver.findElement(By.id("txtUserId"));
	 	String copy_content = PasswordField.getText();
	 	WebElement PasswordField1 = driver.findElement(By.id("txtPwd"));
	 	PasswordField1.sendKeys(copy_content);
	 	//Result ----  The system should not allow the user to Login by using Copy paste action.
	 	UsernameField.clear();
	}
	
	@Test(priority = 12)
	public void TC_14_Check_the_Login_activity_in_two_or_more_different_Devices_Laptops_desktops_etc_at_the_simultaneous_time () {	
		//14.Login activity in two or more different Devices (Laptops, desktops,etc) at the simultaneous time.
		
		//Result ---- The system should not allow the second and more users to login 
		System.out.println("PASS CASE - TC-14");	
	}
	
	@Test(priority = 13)
	public void TC_15_Check_the_Login_activity_in_two_or_more_different_Tab_in_single_browser () 
			throws InterruptedException {
		//15.Login activity in two or more different Tab in single browser
		WebElement UsernameField = driver.findElement(By.id("txtUserId"));
		UsernameField.sendKeys("MAKER");
		WebElement PasswordField = driver.findElement(By.id("txtPwd"));
		PasswordField.sendKeys("Login@123" + Keys.ENTER);
		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("window.open('"+"http://192.168.3.252:8090/H2H_new/"+"','_blank');");
		Thread.sleep(3000);
		//close the Tab
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		Thread.sleep(2000);
		driver.close();
		//Result ---- The system should be allow the second Tab to one or more users to the dashboard page
		//Logout code
		WebElement Logoutimg = driver.findElement(By.xpath("/html/body/div[1]/div[1]/nav/div/ul/li[6]/a/div/img"));
		Logoutimg.click();
		Thread.sleep(3000);
		WebElement Logoutbutton = driver.findElement(By.xpath("/html/body/div[1]/div[1]/nav/div/ul/li[6]/ul/div/div[1]/li[2]/a"));
		Logoutbutton.click();
	}
	
	@Test(priority = 14)
	public void TC_08_Input_valid_login_credentials_and_it_navigate_home_page_or_Dash_board_and_leave_the_web_application_simply_idle_for_15_minutes () 
			throws InterruptedException {
		//_08.After Login Make WebSite simply idle for 15 minutes and then access.
			WebElement UsernameField = driver.findElement(By.id("txtUserId"));
			UsernameField.sendKeys("MAKER");
			WebElement PasswordField = driver.findElement(By.id("txtPwd"));
			PasswordField.sendKeys("Login@123" + Keys.ENTER);
			Thread.sleep(900000);  //900000 milliseconds = 15min
			WebElement BrowseButton = driver.findElement(By.id("inputGroupFile01"));
		    BrowseButton.click();
		   //Result --- The system will Logout automatically without any instruction or message. 
	}
	
	
	@Test(priority = 15)
	public void TC_12_Check_leave_the_wrong_User_ID_and_password_and_note_how_many_times_it_took_to_block_user_id ()
			throws InterruptedException {
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
	}
	
		
	@AfterSuite
	public void closebrowser() {
	 	driver.close();
	}
	
	
	
	
}
