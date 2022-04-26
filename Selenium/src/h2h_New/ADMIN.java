package h2h_New;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

												
					//Before Run this File
					
					// * clear all the entries in user registration and block&unblock
					// * unblock the (TESTER1) for wrong password  		-----TS_001_12
					// * change the username for Auth & Reject       	-----TS_002_25 
					// * change the profile pic to jgp              	-----TS_003_08
					// * block the Userid TESTER001				    	-----TS_003_25
					// * change the password for selenium_A             	-----TC_04_09






public class ADMIN {

	WebDriver driver;
	String H2H_url = "http://192.168.1.6:18080/H2H/";

	
	@BeforeSuite
	public void OpenBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Chromedriver\\chromedriver(9.8).exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(H2H_url);    
		Thread.sleep(2000);
	}
	
	/*
	 * @Test(priority = 0) public void Url_HealthTest() {
	 * System.out.println("TS_001 has been start");
	 * driver.get(H2H_url); try { } catch (Exception e) {
	 * System.out.println("FAIL CASE - URL Health Test " + e); } }
	 */
	
	                       
	
									//TS_001-Logoin page 																						
	
	
	
	@Test( priority = 1) // dependsOnMethods = "Url_HealthTest",
	public void TS_001_01_To_verify_the_fields_login_and_password_make_empty_and_click_login_button_or_Press_Enter ()				 		
	        throws InterruptedException {
		// TS_001_01.Make UserName and password empty and login
			WebElement UsernameField = driver.findElement(By.id("txtUserId"));
			UsernameField.sendKeys("");
			WebElement PasswordField = driver.findElement(By.id("txtPwd"));
			PasswordField.sendKeys("");
			Thread.sleep(3000);
			PasswordField.sendKeys(Keys.ENTER);
		// Result --- It shows User Id or Password Should Not Be Blank
			Thread.sleep(5000);
		}
	
	@Test(priority = 2)
	public void TS_001_02_To_verify_input_of_correct_User_ID_and_leave_the_password_fied_empty_and_click_login_button_or_Press_Enter ()			
	        throws InterruptedException {
		// _TS_001_02.Make Correct User ID and leave the password field empty
			WebElement UsernameField = driver.findElement(By.id("txtUserId"));
			UsernameField.sendKeys("selenium_A");
			WebElement PasswordField = driver.findElement(By.id("txtPwd"));
			PasswordField.sendKeys("");
			Thread.sleep(3000);
			PasswordField.sendKeys(Keys.ENTER);
		// Result --- It shows User Id or Password Should Not Be Blank
			Thread.sleep(5000);
			UsernameField.clear();
	}
	
	@Test(priority = 3)
	public void TS_001_03_To_verify_leave_the_User_ID_field_empty_and_enter_the_correct_password_and_click_login_button_or_Press_Enter ()     
			throws InterruptedException {
		// _TS_001_03.Make Correct password and leave the UserID field empty
			WebElement UsernameField = driver.findElement(By.id("txtUserId"));
			UsernameField.sendKeys("");
			WebElement PasswordField = driver.findElement(By.id("txtPwd"));
			PasswordField.sendKeys("selenium");
			Thread.sleep(3000);
			PasswordField.sendKeys(Keys.ENTER);
		// Result --- It shows User Id or Password Should Not Be Blank
			Thread.sleep(5000);
			PasswordField.clear();
	}
	
	@Test(priority = 4)
	public void TS_001_04_To_verify_input_of_correct_User_ID_and_wrong_Password_and_click_login_button_or_Press_Enter () 					 
			throws InterruptedException {
		// TS_001_04.Make Correct UserID and Wrong password field
			WebElement UsernameField = driver.findElement(By.id("txtUserId"));
			UsernameField.sendKeys("selenium_A");
			WebElement PasswordField = driver.findElement(By.id("txtPwd"));
			PasswordField.sendKeys("wrong password");
			WebElement Eyeicon = driver.findElement(By.id("toggle"));
			Eyeicon.click();
			Thread.sleep(3000);
			PasswordField.sendKeys(Keys.ENTER);
			Thread.sleep(3000);
		// Result --- Either User ID or Password you entered is incorrect.
			UsernameField.clear();
			PasswordField.clear();
			Thread.sleep(3000);
	}
	
	@Test(priority=5) 
	public void TS_001_05_To_verify_input_of_wrong_User_ID_and_correct_Password_and_click_login_button_or_Press_Enter () 
			throws InterruptedException {  
		//TS_001_05.Make Wrong UserID and Correct password field 
			WebElement UsernameField = driver.findElement(By.id("txtUserId"));
			UsernameField.sendKeys("wrong userid");
			WebElement PasswordField = driver.findElement(By.id("txtPwd"));
			PasswordField.sendKeys("selenium");
			WebElement Eyeicon = driver.findElement(By.id("toggle"));
			Eyeicon.click();
			Thread.sleep(3000);
			PasswordField.sendKeys(Keys.ENTER);
			Thread.sleep(3000);
		//Result --- It shows Either User Id or Password you entered is wrong
			Thread.sleep(3000); 
			UsernameField.clear();
			PasswordField.clear();	
	} 
	
	@Test(priority = 6)
	public void TS_001_06_To_verify_input_of_correct_ADMIN_User_ID_and_correct_Password_and_click_login_button_or_Press_Enter () 
			throws InterruptedException {
		// TS_001_06.Make Correct UserID and Correct password field
			WebElement UsernameField = driver.findElement(By.id("txtUserId"));
			UsernameField.sendKeys("selenium_A");
			Thread.sleep(2000);
			WebElement PasswordField = driver.findElement(By.id("txtPwd"));
			PasswordField.sendKeys("selenium");
			Thread.sleep(3000);
			PasswordField.sendKeys(Keys.ENTER);
		// Result --- Action leads to Navigate the DashBoard page
			Thread.sleep(6000);
			WebElement Logoutimg = driver.findElement(By.id("userimg"));
			Logoutimg.click();
			Thread.sleep(5000);
			WebElement Logoutbutton = driver.findElement(By.id("sessionlogout"));
			Logoutbutton.click();
			Thread.sleep(4000);
	}
	
	@Test(priority = 7)
	public void TS_001_07_Input_valid_or_invalid_entries_in_User_ID_and_password_and_if_you_click_cancel_button_in_the_login_Page () throws InterruptedException {
		// TS_001_07.Make UserID and password field empty by using cancel button 
			WebElement UsernameField = driver.findElement(By.id("txtUserId"));
			UsernameField.sendKeys("selenium_A");
			WebElement PasswordField = driver.findElement(By.id("txtPwd"));
			PasswordField.sendKeys("selenium");	
			Thread.sleep(3000);
			PasswordField.sendKeys(Keys.TAB);
			Thread.sleep(3000);
			WebElement Loginbutton = driver.findElement(By.id("loginbtn")); 
			Loginbutton.sendKeys(Keys.TAB);
			Thread.sleep(3000);
			WebElement cancelbutton = driver.findElement(By.id("cancelbtn")); 
			cancelbutton.sendKeys(Keys.ENTER);
			/*
			 * WebElement cancelbutton =  driver.findElement(By.xpath("//*[@id=\'loginForm\']/div[2]/div/div[3]/button"));
			 *  cancelbutton.click();
			 */
			Thread.sleep(5000);
		// Result --- It should Empty the User ID and Password fields
	}
	
	@Test(priority = 8)
	public void TS_001_09_Check_the_Password_field_it_should_be_hidden_by_dots_instead_of_alphanumeric () throws InterruptedException {
		 //TS_001_09.Password should be hidden by dots		
			WebElement PasswordField = driver.findElement(By.id("txtPwd"));
			PasswordField.sendKeys("Hidden format check");
			WebElement Eyeicon = driver.findElement(By.id("toggle"));
			Eyeicon.click();
			Thread.sleep(3000);
			PasswordField.clear();
		 //Result --- Password it should be in the hidden format
	}
	
	@Test(priority = 9)
	public void TS_001_10_Check_the_eye_icon_visible_or_not_in_the_Password_field ()
			throws InterruptedException {
		//TS_001_10.Check the eye icon visible or not in the Password field
		   WebElement UsernameField = driver.findElement(By.id("txtUserId"));
		   UsernameField.sendKeys("selenium_A");	
		   WebElement PasswordField = driver.findElement(By.id("txtPwd"));
		   PasswordField.sendKeys("selenium");
		   Thread.sleep(3000);
		   WebElement Eyeicon = driver.findElement(By.id("toggle"));
		   Eyeicon.click();
		   Thread.sleep(3000);
		//Result --- If we click the eye icon in the password field, the typed password is visible 
		   UsernameField.clear();
		   PasswordField.clear();
	}
	
	@Test(priority = 10)
	public void TS_001_11_check_the_eye_icon_visible_or_not_in_the_Password_field_if_the_user_allows_the_manage_password_in_his_her_Browser () throws InterruptedException{ 	
		//TS_001_11.Users allows to manage the password in Browser.
		   WebElement PasswordField = driver.findElement(By.id("txtPwd"));
		   PasswordField.sendKeys("selenium");
		   Thread.sleep(3000);
		   WebElement Eyeicon = driver.findElement(By.id("toggle"));
		   Eyeicon.click();
		   Thread.sleep(3000);
		   PasswordField.clear();		   
		//Result ---- If the User allow the Browser to manage user id and password then the eye icon is not visible.
	}
	
	@Test(priority = 11)
	public void TS_001_13_check_the_Password_field_whether_it_is_allowed_or_not_for_the_user_to_login_if_the_password_is_copy_paste_action () 
		throws InterruptedException {
		//TS_001_13.check the Password field whether it is allowed or not for the user to login if the password is copy-paste action.
			WebElement UsernameField = driver.findElement(By.id("txtUserId"));
		 	UsernameField.sendKeys("copy-paste action");	
		 	WebElement UsernameField1 = driver.findElement(By.id("txtUserId"));
		 	String copy_content = UsernameField1.getText();
			Thread.sleep(3000);
		 	WebElement PasswordField1 = driver.findElement(By.id("txtPwd"));
		 	PasswordField1.sendKeys(copy_content);
			Thread.sleep(5000);
			WebElement Eyeicon = driver.findElement(By.id("toggle"));
		    Eyeicon.click();
	 	//Result ----  The system should not allow the user to Login by using Copy paste action.
		    UsernameField.clear();
		    Thread.sleep(3000);
	}
	
	
	//TS_001_14.Login activity in two or more different Devices (Laptops, desktops,etc) at the simultaneous time.

	
	
	@Test(priority = 13)
	public void TS_001_15_Check_the_Login_activity_in_two_or_more_different_Tab_in_single_browser () 
		throws InterruptedException {
	 //TS_001_15.Login activity in two or more different Tab in single browser
		WebElement UsernameField = driver.findElement(By.id("txtUserId"));
		UsernameField.sendKeys("selenium_A");
		Thread.sleep(2000);
		WebElement PasswordField = driver.findElement(By.id("txtPwd"));
		PasswordField.sendKeys("selenium");
		Thread.sleep(5000);
		PasswordField.sendKeys(Keys.ENTER);
		Thread.sleep(7000);
		((JavascriptExecutor) driver).executeScript("window.open('"+H2H_url+"','_blank');");
		Thread.sleep(5000);
		//close the TabS
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		Thread.sleep(2000);
		driver.close();
	 //Result ---- The system should be allow the second Tab to one or more users to the dashboard page
		//Logout code
		driver.switchTo().window(tabs.get(0));
		Thread.sleep(3000);
		WebElement Logoutimg = driver.findElement(By.id("userimg"));
		Logoutimg.click();
		Thread.sleep(5000);
		WebElement Logoutbutton = driver.findElement(By.id("sessionlogout"));
		Logoutbutton.click();
		Thread.sleep(5000);
//		WebElement TC_15 = driver.findElement(By.id("FAIL_ID"));              		//For fail scenario
//		TC_15.click();
//		Thread.sleep(3000);
	}
	
	/*@Test(priority = 14)
	public void TS_001_08_Input_valid_login_credentials_and_it_navigate_home_page_or_Dash_board_and_leave_the_web_application_simply_idle_for_15_minutes ()
			throws InterruptedException {
		//TS_001_08.After Login Make WebSite simply idle for 15 minutes and then access.
			WebElement UsernameField = driver.findElement(By.id("txtUserId"));
			UsernameField.sendKeys("selenium_A");
			Thread.sleep(3000);
			WebElement PasswordField = driver.findElement(By.id("txtPwd"));
			PasswordField.sendKeys("selenium");
			Thread.sleep(3000);
			PasswordField.sendKeys(Keys.ENTER); 
			Thread.sleep(9000);  //900000 milliseconds = 15min
			WebElement Week = driver.findElement(By.id("week"));
			Week.click();
		    Thread.sleep(2000);
		    WebElement month = driver.findElement(By.id("month"));
		    month.click();
		  //Result --- The system will Logout automatically without any instruction or message. 
		    Thread.sleep(3000);
		    Thread.sleep(5000);
			WebElement Logoutimg = driver.findElement(By.id("userimg"));
			Logoutimg.click();
			Thread.sleep(5000);
			WebElement Logoutbutton = driver.findElement(By.id("sessionlogout"));
			Logoutbutton.click();
			Thread.sleep(3000);
	}*/
	
	@Test(priority = 15)
	public void TS_001_12_Check_leave_the_wrong_User_ID_and_password_and_note_how_many_times_it_took_to_block_user_id ()
			throws InterruptedException {
		//TS_001_12.leave the wrong User ID and password and login(3times).
		 	WebElement UsernameField = driver.findElement(By.id("txtUserId"));
		 	UsernameField.sendKeys("TESTER1");	
		 	WebElement PasswordField = driver.findElement(By.id("txtPwd"));
		 	PasswordField.sendKeys("wrong password - 1");
		 	Thread.sleep(2000);
		 	WebElement Eyeicon = driver.findElement(By.id("toggle"));
			Eyeicon.click();
			Thread.sleep(2000);
		 	PasswordField.sendKeys(Keys.ENTER);
		 	Thread.sleep(3000);
		 	UsernameField.clear();
		 	WebElement UsernameField1 = driver.findElement(By.id("txtUserId"));
		 	UsernameField1.sendKeys("TESTER1");	
		 	WebElement PasswordField1 = driver.findElement(By.id("txtPwd"));
		 	PasswordField1.sendKeys("wrong password - 2");
		 	Thread.sleep(2000);
			Eyeicon.click();
			Thread.sleep(2000);
		 	PasswordField.sendKeys(Keys.ENTER);
		 	Thread.sleep(3000);
		 	UsernameField1.clear();
		 	WebElement UsernameField2 = driver.findElement(By.id("txtUserId"));
		 	UsernameField2.sendKeys("TESTER1");
		 	WebElement PasswordField2 = driver.findElement(By.id("txtPwd"));
		 	PasswordField2.sendKeys("wrong password - 3");
		 	Thread.sleep(2000);
			Eyeicon.click();
		 	Thread.sleep(3000);
		 	PasswordField.sendKeys(Keys.ENTER);
		 	Thread.sleep(2000);
		 	UsernameField.clear();
		 	Thread.sleep(5000);
		//Result ---- It leave a message "ID  Locked Contact System Administrator".
	}
	
									// TS_001_16 - TS_001_19  - 3cases + TS_001_11 - 1case = 4cases
	
	@Test(priority = 16)
	public void TS_001_20_Check_the_Forget_Password_button_is_working_or_not()
	        throws InterruptedException {
		//TS_001_20.Check the Forget Password button is working or not
			WebElement forgetpass = driver.findElement(By.id("forgetpass"));
			forgetpass.click();			
			Thread.sleep(6000);
		// Result --- If  we click the "Forget Password" Button, it should navigate to forget password recover page. 
			
	}
	
	@Test(priority = 17)
	public void TS_001_21_In_Forget_Password_recover_page_Check_the_Username_field()
	        throws InterruptedException {
	    //TS_001_21.In Forget Password recover page - Check the Username field.
			WebElement FP_Username = driver.findElement(By.id("txtUserId"));
			FP_Username.sendKeys("Editable filed");		
			Thread.sleep(4000);
			FP_Username.clear();
		// Result --- "Username Field" must be in editable format. 
			
	}
	
	@Test(priority = 18)
	public void TS_001_22_In_Forget_Password_Recover_page_Check_the_Username_field_allows_alphanumeric_and_special_characters()
	        throws InterruptedException {
		//TS_001_22.In Forget Password Recover page - Check the Username field allows alphanumeric and special characters
			WebElement FP_Username = driver.findElement(By.id("txtUserId"));
			FP_Username.sendKeys("ABCDabcd123!@#");		
			Thread.sleep(4000);
			FP_Username.clear();
		// Result --- Username Field" should allows alphanumeric and special characters. 
			
	}
		
	@Test(priority = 19)
	public void TS_001_23_In_Forget_Password_Recover_page_Check_the_Send_OTP_through_EMail_field ()
	        throws InterruptedException {
		//TS_001_23.In Forget Password Recover page - Check the Send OTP through E-Mail field.
			WebElement FP_Username_tab = driver.findElement(By.id("txtUserId"));
			FP_Username_tab.sendKeys("pwd01");
			Thread.sleep(3000);   
			WebElement get_otp = driver.findElement(By.id("gtotp"));
			get_otp.click();
			Thread.sleep(20000);
		// Result --- If we click the "send OTP through E-Mail". It has to send six digit OTP for registered E-Mail at the time of User Registration.
			
	}
	
	@Test(priority = 20)
	public void TS_001_24_In_Forget_Password_Recover_Page__Check_the_validate_OTP_field_with_wrong_OTP ()
	        throws InterruptedException {
		//TS_001_24.In Forget Password Recover Page - Check the validate OTP field with wrong OTP.
		/*
		 * WebElement FP_Username = driver.findElement(By.id("txtUserId"));
		 * FP_Username.sendKeys("Pwd01"); Thread.sleep(3000); WebElement FP_Username_tab
		 * = driver.findElement(By.id("txtUserId")); FP_Username_tab.sendKeys(Keys.TAB);
		 * Thread.sleep(3000);
		 */   
			WebElement Enter_wrongotp = driver.findElement(By.id("otp"));
			Enter_wrongotp.sendKeys("000000");
			Thread.sleep(5000);
			WebElement Validate_otp = driver.findElement(By.id("valid"));
			Validate_otp.click();
			Thread.sleep(5000);
		// Result --- If we input wrong OTP in "Validate OTP field", the system need to trigger a message "Invalid OTP!!!"
			
	}
	           
	 						//TS_001_25  - Manual Test because OTP Generate to email by automatically 
	
	
	/*@Test(priority = 22)
	public void TS_001_26_In_Forget_Password_Recover_page_Check_the_Get_OTP_Button ()        // -------------------Pending
	        throws InterruptedException {
		//TS_001_26.In Forget Password Recover page - Check the "Get OTP" Button. 
			WebElement FP_Username_tab = driver.findElement(By.id("txtUserId"));
			FP_Username_tab.sendKeys("pwd01");
			Thread.sleep(3000);   
			WebElement get_otp = driver.findElement(By.id("gtotp"));
			get_otp.click();
			Thread.sleep(20000);
		// Result --- Aftern submitting the Username and Send OTP through - If we click the "Get OTP" Button, it should send OTP to the respective input, it navigate another page input OTP.
			
	}*/
	
	@Test(priority = 23)
	public void TS_001_27_In_Forget_Password_Recover_page_Check_the_Cancel_Button ()
	        throws InterruptedException {
		//TS_001_27.In Forget Password Recover page - Check the "Cancel" Button. 
			WebElement cancel_btn = driver.findElement(By.id("cancelPass"));
			cancel_btn.click();
			Thread.sleep(7000);
		// Result ---If we click the cancel button, it navigate to login Page
			
	}
	
	
										 //TS_002- User Registration
	
	
	
	@Test(priority = 25)
	public void TS_002_01_Check_click_the_user_Registration_parent_menu()
	        throws InterruptedException {
		 //TS_002_01."Check- click the ""user Registration" "parent menu"
			WebElement UsernameField = driver.findElement(By.id("txtUserId"));
			UsernameField.sendKeys("selenium_A");
			Thread.sleep(3000);
			WebElement PasswordField = driver.findElement(By.id("txtPwd"));
			PasswordField.sendKeys("selenium");
			Thread.sleep(4000);
			PasswordField.sendKeys(Keys.ENTER);
			Thread.sleep(6000);
			WebElement tooglebtn = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/button/i"));
			tooglebtn.click();
			Thread.sleep(4000);
			WebElement parent_Userreg= driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div/ul/li[2]/a"));
			parent_Userreg.click();
		// Result --- "It shows child menu - ""User Registraion and Reset password"
		}
	
	@Test(priority = 26)
	public void TS_002_02_Check_click_the_user_Registration_child_menu()
	        throws InterruptedException {
		 //TS_002_02.""It navigate ""User Registration "" page"
		Thread.sleep(7000);
		WebElement child_Userreg= driver.findElement(By.xpath("//*[@id=\"userregistration\"]/ul/li[1]/a"));
		child_Userreg.click();
		Thread.sleep(3000);
		// Result --- ""It navigate ""User Registration "" page"
		}
	
	@Test(priority = 27)
	public void TS_002_03_In_User_Registration_check_the_organization_code_field()
	        throws InterruptedException {
		 //TS_002_03."In User Registration - check the organization code field"
			WebElement Label_cont = driver.findElement(By.id("torgcd"));
			Label_cont.click();
			Thread.sleep(3000);
		// Result --- It will be label as "EXIM"
		}
	
	@Test(priority = 28)
	public void TS_002_04_In_User_Registration_check_the_User_ID_field_whether_it_allows_an_alphanumeric_and_special_characters_or_not()
	        throws InterruptedException {
		 //TS_002_04."In User Registration- check the User ID field whether it allows an alphanumeric and special characters or not"
			WebElement Userid = driver.findElement(By.id("tuserid"));
			Userid.sendKeys("ABCDabc123!@#");
			Thread.sleep(3000);
			Userid.clear();
		// Result --- "It should allow alphanumeric and special characters"
		}

	@Test(priority = 29)
	public void TS_002_05_In_User_Registration_Check_the_User_ID_field_it_should_not_allow_more_than_20_characters()
	        throws InterruptedException {
		 //TS_002_05."In User Registration- Check the User ID field it should not allow more than 20 characters."
			WebElement User_id  = driver.findElement(By.id("tuserid"));
			User_id.sendKeys("12345678912345678912");
			Thread.sleep(3000);
			User_id.clear();
		// Result --- "It allows less than or equal to 20 characters."
		}
	
	@Test(priority = 30)
	public void TS_002_06_In_User_Registration_check_the_User_Name_field_whether_it_allows_an_alphanumeric_and_special_characters_or_not()
	        throws InterruptedException {
		 //TS_002_06."In User Registration- check the User Name field whether it allows an alphanumeric and special characters or not"."
			WebElement username =  driver.findElement(By.id("tusernme"));
			username.sendKeys("abcABC123!@#efg");   // alphanumeric and special characters = abcABC123!@#efg	
			Thread.sleep(3000);
			username.clear();
		// Result --- "It should allow alphanumeric and special characters"
		}
	
	@Test(priority = 31)
	public void TS_002_07_In_User_Registration_Check_the_User_Name_field_it_should_not_allow_more_than_20_characters()
	        throws InterruptedException {
		 //TS_002_07."In User Registration- Check the User Name field it should not allow more than 20 characters."
			WebElement username =  driver.findElement(By.id("tusernme"));
			username.sendKeys("12345678912345678912");   // alphanumeric and special characters = abcABC123!@#efg	
			Thread.sleep(3000);
			username.clear();
		// Result --- "It allows less than or equal to 20 characters."
		}
	
	@Test(priority = 32)
	public void TS_002_08_In_User_Registration_Check_the_Date_field_allows_manual_input_in_the_given_format_dd_mm_yyyy()
	        throws InterruptedException {
		 //TS_002_08."In User Registration- Check the User Name field it should not allow more than 20 characters."
			WebElement DOB =  driver.findElement(By.id("tbirthdate"));
			DOB.sendKeys("18122000");   //Ramdom Birthday date = 18-12-2000(18th dec,2000)
			Thread.sleep(3000);
		// Result --- "It should be allow manual input through keyboard"
		}
	
	@Test(priority = 33)
	public void TS_002_09_In_User_Registration_Check_the_Date_field_whether_future_date_should_be_freeze()
	        throws InterruptedException {
		 //TS_002_09."In User Registration- Check the Date Of Birth field whether future date should be freeze"
			WebElement FutureDate =  driver.findElement(By.id("tbirthdate"));
			FutureDate.sendKeys("18122025");   //FutureDate = 18-12-2025(18th dec,2025) current date =(29-12-2021)
			Thread.sleep(3000);
			FutureDate.clear();
		// Result --- "Actual result are not same as expected results it shown the future dates."
		}
	
	@Test(priority = 34)
	public void TS_002_10_In_User_Registration_Check_the_Date_field_shows_the_calander_icon_in_the_dropdown_format()
	        throws InterruptedException {
		 //TS_002_10."In User Registration- Check the Date field shows the calander icon in the dropdown format."
			WebElement FutureDate =  driver.findElement(By.id("tbirthdate"));                    // ????????????????????????
			Thread.sleep(3000);
			FutureDate.click();  
			Thread.sleep(3000);
		// Result --- "Actual result are not same as expected results it shown the future dates."
		}
	
	@Test(priority = 35)
	public void TS_002_11_In_User_Registration_check_the_primary_mobile_number_field_allows_only_a_numeric_value_or_not()
	        throws InterruptedException {
		 //TS_002_11."In User Registration-check the primary mobile number field allows only a numeric value or not"
			WebElement Numvalue =  driver.findElement(By.id("tmobile"));
			Numvalue.sendKeys("9087369066");   //Mobile No =9087369066
			Thread.sleep(3000);
			Numvalue.clear();
		// Result --- "It should allow only numeric value"
		}
	
	@Test(priority = 36)
	public void TS_002_12_In_User_Registration_check_the_primary_mobile_number_field_should_not_allow_more_than_10_digits()
	        throws InterruptedException {
		 //TS_002_12.""In User Registration-check the primary mobile number field should not allow more than 10-digits""
			WebElement Numvalue =  driver.findElement(By.id("tmobile"));
			Numvalue.sendKeys("1234567890");   //Mobile No =1234567890 along with only 10characters
			Thread.sleep(3000);
			Numvalue.clear();
		// Result --- "It should not allow more than 10-digits"
		}
	
	@Test(priority = 37)
	public void TS_002_13_In_User_Registration_check_the_primary_mobile_number_field_should_not_allow_more_than_10_digits()
	        throws InterruptedException {
		 //TS_002_13."In User Registration- check the primary Email Id should allow Email text type."
			WebElement Emailvalue =  driver.findElement(By.id("temail"));
			Emailvalue.sendKeys("Mukesh@hdsoftwaresystems.com");
			Thread.sleep(3000);
			Emailvalue.clear();
		// Result --- "It should allow the Email text type."
		}
	
	@Test(priority = 38)
	public void TS_002_14_In_User_Registration_Check_the_eye_button_working_or_not_in_the_Password_field()
	        throws InterruptedException {
		 //TS_002_14."In User Registration- Check the eye button working or not in the Password field"
			WebElement Passfield =  driver.findElement(By.id("tpwd"));
			Passfield.sendKeys("Login@123");
			Thread.sleep(3000);
			WebElement Passeyeicon =  driver.findElement(By.id("toggle"));
			Passeyeicon.click();
			Thread.sleep(3000);
			Passfield.clear();
		// Result --- "If we click the eye button in the password field, the typed password is visible instead of dots."
		}
	
	@Test(priority = 39)
	public void TS_002_15_In_User_Registration_Check_the_Password_field_it_should_be_hidden_by_dots_instead_of_alphanumeric_and_special_characters()
	        throws InterruptedException {
		 //TS_002_15.""In User Registration- Check the Password field it should be hidden by dots instead of alphanumeric and special characters."
			WebElement Passfield =  driver.findElement(By.id("tpwd"));
			Passfield.sendKeys("abcABC123!@#efg");     //alphanumeric value and special character = abcABC123!@#efg
			Thread.sleep(3000);
			WebElement Passeyeicon =  driver.findElement(By.id("toggle"));
			Passeyeicon.click();
			Thread.sleep(3000);		
			Passfield.clear();
		// Result --- ""When we type the password it should be in the hidden format instead of alphanumeric and special characters field shown dots only.""
		}
	 
	@Test(priority = 40)
	public void TS_002_16_In_User_Registration_Check_the_eye_button_working_or_not_in_the_Re_Enter_Password_field()
	        throws InterruptedException {
		 //TS_002_16."In_User_Registration_Check_the_eye_button_working_or_not_in_the_Re_Enter_Password_field"
			WebElement Re_Passfield =  driver.findElement(By.id("tconfirmpwd"));
			Re_Passfield.sendKeys("Login@123");
			Thread.sleep(3000);
			WebElement Re_Passeyeicon =  driver.findElement(By.id("toggle1"));
			Re_Passeyeicon.click();
			Thread.sleep(3000);
			Re_Passfield.clear();
		// Result --- "If we click the eye button in the Re-Enter password field, the typed password is visible instead of dots."
		}
	
	@Test(priority = 41)
	public void TS_002_17_In_User_Registration_Check_the_Re_Enter_Password_field_it_should_be_hidden_by_dots_instead_of_alphanumeric_and_special_characters ()
	        throws InterruptedException {
		 //TS_002_17."In_User_Registration_Check_the_eye_button_working_or_not_in_the_Re_Enter_Password_field"
			WebElement Re_Passfield =  driver.findElement(By.id("tconfirmpwd"));
			Re_Passfield.sendKeys("abcABC123!@#efg");     //alphanumeric value and special character = abcABC123!@#efg
			Thread.sleep(3000);
			WebElement Re_Passeyeicon =  driver.findElement(By.id("toggle1"));
			Re_Passeyeicon.click();
			Thread.sleep(3000);
			Re_Passfield.clear();
		// Result --- "If we click the eye button in the Re-Enter password field, the typed password is visible instead of dots."
		}
	
	@Test(priority = 42)
	public void TS_002_18_In_User_Registration_Check_the_Role_code_should_be_in_the_dropdown_field_and_it_contain_different_role_like_Admin_Maker_Checker_etc ()
    throws InterruptedException {
		//TS_002_18."In User Registration-Check the Role code should be in the dropdown field and it contain different role like Admin,Maker,Checker etc."
			WebElement dropdownindex = driver.findElement(By.id("trolecd"));
			Select selectDD = new Select (dropdownindex);
			selectDD.selectByIndex(1);    //MAKR -  Peer Role
			Thread.sleep(2000);
			selectDD.selectByIndex(2); 	  //ADMIN -  Admin User
			Thread.sleep(2000);
			selectDD.selectByIndex(3);    //CHKR -  check User
			Thread.sleep(2000);	
			selectDD.selectByIndex(0);    // for resume the position of dropdown
		//Result --- It should be in the dropdown field and it contains the different roles like Admin,Maker,Checker etc.
		
	}
	
	@Test(priority = 43)
	public void TS_002_19_In_User_Registration_Check_the_Role_code_dropdown_field_it_shows_a_label_select ()
		throws InterruptedException {
		//TS_002_19.Check the Role code dropdown field it shows a label "select". 
			WebElement dropdownindex = driver.findElement(By.id("trolecd"));
			Select selectDD = new Select (dropdownindex);
			selectDD.selectByIndex(1);                                 //MAKR -  Peer Role
			Thread.sleep(2000);
				//WebElement dropdown1 = selectDD.getFirstSelectedOption();
				//String dropdownvalue1 = dropdown1.getText();
				//System.out.println(dropdownvalue1);
			selectDD.selectByIndex(2); 	                               //ADMIN -  Admin User
			Thread.sleep(2000);
				//WebElement dropdown2 = selectDD.getFirstSelectedOption();
				//String dropdownvalue2 = dropdown2.getText();
				//System.out.println(dropdownvalue2);
			selectDD.selectByIndex(3);                                 //CHKR -  check User	
			Thread.sleep(2000);
				//WebElement dropdown3 = selectDD.getFirstSelectedOption();
				//String dropdownvalue3 = dropdown3.getText();
				//System.out.println(dropdownvalue3);
		//Result --- It shows the label "select"
	}
	
	@Test(priority = 44)
	public void TS_002_20_In_User_Registration_Check_the_Role_code_dropdown_field_allow_to_select_the_listed_Role_code () 
		throws InterruptedException {
		//TS_002_20. Check the Role code dropdown field allow to select the listed Role code
			WebElement dropdownindex = driver.findElement(By.id("trolecd"));
			Select selectDD = new Select (dropdownindex);
			selectDD.selectByIndex(1);    //MAKR -  Peer Role
			Thread.sleep(2000);
			selectDD.selectByIndex(2); 	  //ADMIN -  Admin User
			Thread.sleep(2000);
			selectDD.selectByIndex(3);    //CHKR -  check User
			Thread.sleep(2000);
			selectDD.selectByIndex(0);    // for resume the position of dropdown
		//Result ---It should be allow to select a Role code already listed in the dropdown field.
	}
	
	@Test(priority = 45)
	public void TS_002_21_In_User_Registration_Check_the_Registration_Date_whether_future_date_are_not_shown () 
		throws InterruptedException {
		//TS_002_21.Check the Registration Date whether future date are not shown
			WebElement RegDate =  driver.findElement(By.id("tregdate"));
			
			// Create object of SimpleDateFormat class and decide the format
			 DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			 
			 //get current date time with Date()
			 Date date = new Date(); 										// passing System current date (dd/MM/yyyy)
			 
			 // Now format the date
			 String date1= dateFormat.format(date);
			 
			RegDate.sendKeys(date1);   //Regsitration Date
			Thread.sleep(3000);
			RegDate.clear();
		//Result - "It does not allow the future dates or It does not shown the future dates"
	}
	
	@Test(priority = 46)
	public void TS_002_22_In_User_Registration_Check_the_Branch_code_should_be_in_the_dropdown_field_and_it_contain_several_number_of_branch_codes () 
		throws InterruptedException {
		//TS_002_22.Check the Branch code should be in the dropdown field and it contain several number of branch codes. 
			WebElement dropdownindex = driver.findElement(By.id("branchcd"));
			Select selectDD = new Select (dropdownindex);
			selectDD.selectByIndex(1);    //1 -  EBTL, Exim Tower
			Thread.sleep(1000);
			selectDD.selectByIndex(2); 	  //2 -  EBTL, Mtwara
			Thread.sleep(1000);
			selectDD.selectByIndex(3);    //3 -  EBTL, Arusha
			Thread.sleep(1000);
			selectDD.selectByIndex(0);    // for resume the position of dropdown
		//Result --- It should be in the dropdown field and it contains the several number of branch codes.
	}
	
	@Test(priority = 47)
	public void TS_002_23_In_User_Registration_Check_the_Branch_code_dropdown_field_it_shows_a_label_select ()
		throws InterruptedException {
		//TS_002_23.Check the Branch code dropdown field it shows a label "select".
			WebElement dropdownindex = driver.findElement(By.id("branchcd"));
			Select selectDD = new Select (dropdownindex);
			selectDD.selectByIndex(1);                                //1 -  EBTL, Exim Tower
			Thread.sleep(2000);
				//WebElement dropdown1 = selectDD.getFirstSelectedOption();
				//String dropdownvalue1 = dropdown1.getText();
				//System.out.println(dropdownvalue1);
			selectDD.selectByIndex(2); 	                              //2 -  EBTL, Mtwara
			Thread.sleep(2000);
				//WebElement dropdown2 = selectDD.getFirstSelectedOption();
				//String dropdownvalue2 = dropdown2.getText();
				//System.out.println(dropdownvalue2);
			selectDD.selectByIndex(3);                                 //3 -  EBTL, Arusha
			Thread.sleep(2000);
				//WebElement dropdown3 = selectDD.getFirstSelectedOption();
				//String dropdownvalue3 = dropdown3.getText();
				//System.out.println(dropdownvalue3);
			selectDD.selectByIndex(0);    // for resume the position of dropdown
		//Result --- It shows the label "select"
	}
	
	@Test(priority = 48)
	public void TS_002_24_In_User_Registration_Check_the_branch_code_dropdown_field_allow_to_select_the_listed_branch_code() 
		throws InterruptedException {
		//TS_002_24.Check the branch code dropdown field allow to select the listed branch code
			WebElement dropdownindex = driver.findElement(By.id("branchcd"));
			Select selectDD = new Select (dropdownindex);
			selectDD.selectByIndex(1);    //1 -  EBTL, Exim Tower
			Thread.sleep(2000);
			selectDD.selectByIndex(2); 	  //2 -  EBTL, Mtwara
			Thread.sleep(2000);
			selectDD.selectByIndex(3);    //3 -  EBTL, Arusha
			Thread.sleep(2000);
			selectDD.selectByIndex(0);    // for resume the position of dropdown
		//Result --- It should be allow to select a branch code already listed in the dropdown field.
	}
	
	@Test(priority = 49)
	public void TS_002_25_In_User_Registration_Check_the_Submit_Button_to_confirm_the_entries() 
		throws InterruptedException {
		//TS_002_25. Check the Submit Button to confirm the entries.
			WebElement userid =  driver.findElement(By.id("tuserid"));             //userid
			userid.sendKeys("Authorize_Record");   
			Thread.sleep(1000);	
	
			WebElement username =  driver.findElement(By.id("tusernme"));          //username      
			username.sendKeys("Mukesh");   	
			Thread.sleep(1000);
	
			WebElement DOB =  driver.findElement(By.id("tbirthdate"));             //DOB
			DOB.sendKeys("18122000");   
			Thread.sleep(1000);
	
			WebElement Numvalue =  driver.findElement(By.id("tmobile"));		   //Mobile No 
			Numvalue.sendKeys("9087369066");   
			Thread.sleep(1000);
	
			WebElement Emailvalue =  driver.findElement(By.id("temail"));		   //Email ID
			Emailvalue.sendKeys("Mukesh@hdsoftwaresystems.com");
			Thread.sleep(1000);
	
			WebElement Passfield =  driver.findElement(By.id("tpwd"));             //password
			Passfield.sendKeys("Login@123");
			Thread.sleep(1000);
	
			WebElement Re_Passfield =  driver.findElement(By.id("tconfirmpwd"));   //Re-Enter password
			Re_Passfield.sendKeys("Login@123");
			Thread.sleep(1000);
	
			WebElement dropdownindex = driver.findElement(By.id("trolecd")); 		//Role Code - MAKR 
			Select selectDD = new Select (dropdownindex);
			selectDD.selectByIndex(1);    
			Thread.sleep(1000);
	
			WebElement RegDate =  driver.findElement(By.id("tregdate"));			//Current Date     
			// Create object of SimpleDateFormat class and decide the format
			 DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			 
			 //get current date time with Date()
			 Date date = new Date(); 										// passing System current date (dd/MM/yyyy)
			 
			 // Now format the date
			 String date1= dateFormat.format(date);
			 
			RegDate.sendKeys(date1);   
			Thread.sleep(1000);
	
			WebElement dropdownbranchcd = driver.findElement(By.id("branchcd"));    //Branch Code
			Select selectDD1 = new Select (dropdownbranchcd);
			selectDD1.selectByIndex(1);    //1 -  EBTL, Exim Tower
			Thread.sleep(3000);
			dropdownbranchcd.sendKeys(Keys.TAB);
			Thread.sleep(3000);
	
			WebElement submitbtn = driver.findElement(By.id("submit"));   //Submit Button
			submitbtn.click();
			Thread.sleep(7000);
			WebElement resetbtn = driver.findElement(By.xpath("//*[@id=\'colour_body\']/div[2]/div/div[2]/button"));   //Reset Button for clear the field 
			resetbtn.click();
			Thread.sleep(3000);
			
            //TO Reject the Authorize 
			
			WebElement userid1 =  driver.findElement(By.id("tuserid"));             //userid
			userid1.sendKeys("Reject_Record");   
			Thread.sleep(1000);	
	
			WebElement username1 =  driver.findElement(By.id("tusernme"));          //username      
			username1.sendKeys("Mukesh");   	
			Thread.sleep(1000);
	
			WebElement DOB1 =  driver.findElement(By.id("tbirthdate"));             //DOB
			DOB1.sendKeys("18122000");   
			Thread.sleep(1000);
	
			WebElement Numvalue1 =  driver.findElement(By.id("tmobile"));		   //Mobile No 
			Numvalue1.sendKeys("9087369066");   
			Thread.sleep(1000);
	
			WebElement Emailvalue1 =  driver.findElement(By.id("temail"));		   //Email ID
			Emailvalue1.sendKeys("Mukesh@hdsoftwaresystems.com");
			Thread.sleep(1000);
	
			WebElement Passfield1 =  driver.findElement(By.id("tpwd"));             //password
			Passfield1.sendKeys("Login@123");
			Thread.sleep(1000);
	
			WebElement Re_Passfield1 =  driver.findElement(By.id("tconfirmpwd"));   //Re-Enter password
			Re_Passfield1.sendKeys("Login@123");
			Thread.sleep(1000);
	
			WebElement dropdownindex1 = driver.findElement(By.id("trolecd")); 		//Role Code - MAKR 
			Select selectDD2 = new Select (dropdownindex1);
			selectDD2.selectByIndex(1);    
			Thread.sleep(1000);
	
			WebElement RegDate1 =  driver.findElement(By.id("tregdate"));			//Current Date     
			// Create object of SimpleDateFormat class and decide the format
			 DateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
			 
			 //get current date time with Date()
			 Date date2 = new Date(); 										// passing System current date (dd/MM/yyyy)
			 
			 // Now format the date
			 String date3= dateFormat1.format(date2);
			 
			RegDate1.sendKeys(date3);   
			Thread.sleep(1000);
	
			WebElement dropdownbranchcd1 = driver.findElement(By.id("branchcd"));    //Branch Code
			Select selectDD3 = new Select (dropdownbranchcd1);
			selectDD3.selectByIndex(1);    //1 -  EBTL, Exim Tower
			Thread.sleep(3000);
			dropdownbranchcd1.sendKeys(Keys.TAB,Keys.ENTER);
			Thread.sleep(3000);
	
			//WebElement submitbtn1 = driver.findElement(By.id("submit"));   //Submit Button
			//submitbtn1.click();
			//Thread.sleep(7000);
		//Result --- It should be submit the Record and leave a message as "Record Submitted Succesffully" 

	}
	
	@Test(priority = 50)
	public void TS_002_26_In_User_Registration_Check_the_Cancel_Button_to_remove_the_entries_in_all_fileds()
		throws InterruptedException {
		//TS_002_26.Check the "Cancel" Button to remove the entries in all fileds.
		
			WebElement userid1 =  driver.findElement(By.id("tuserid"));             //userid
			userid1.sendKeys("TESTING1");   
			Thread.sleep(1000);	
	
			WebElement username1 =  driver.findElement(By.id("tusernme"));          //username      
			username1.sendKeys("Mukesh");   	
			Thread.sleep(1000);
	
			WebElement DOB1 =  driver.findElement(By.id("tbirthdate"));             //DOB
			DOB1.sendKeys("18122000");   
			Thread.sleep(1000);
	
			WebElement Numvalue1 =  driver.findElement(By.id("tmobile"));		   //Mobile No 
			Numvalue1.sendKeys("9087369066");   
			Thread.sleep(1000);
	
			WebElement Emailvalue1 =  driver.findElement(By.id("temail"));		   //Email ID
			Emailvalue1.sendKeys("Mukesh@hdsoftwaresystems.com");
			Thread.sleep(1000);
	
			WebElement Passfield1 =  driver.findElement(By.id("tpwd"));             //password
			Passfield1.sendKeys("Login@123");
			Thread.sleep(3000);
	
			WebElement Re_Passfield1 =  driver.findElement(By.id("tconfirmpwd"));   //Re-Enter password
			Re_Passfield1.sendKeys("Login@123");
			Thread.sleep(1000);
	
			WebElement dropdownindex1 = driver.findElement(By.id("trolecd")); 		//Role Code - MAKR 
			Select selectDD2 = new Select (dropdownindex1);
			selectDD2.selectByIndex(3);    
			Thread.sleep(2000);
	
			WebElement RegDate =  driver.findElement(By.id("tregdate"));			//Current Date 
			// Create object of SimpleDateFormat class and decide the format
			 DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			 
			 //get current date time with Date()
			 Date date = new Date(); 										// passing System current date (dd/MM/yyyy)
			 
			 // Now format the date
			 String date1= dateFormat.format(date);
			RegDate.sendKeys(date1);   
			Thread.sleep(1000);
			
			WebElement dropdownbranchcd1 = driver.findElement(By.id("branchcd"));    //Branch Code
			Select selectDD3 = new Select (dropdownbranchcd1);
			selectDD3.selectByIndex(1);    //1 -  EBTL, Exim Tower
			Thread.sleep(1000);
			
			WebElement resetbtn = driver.findElement(By.xpath("//*[@id=\'colour_body\']/div[2]/div/div[2]/button"));   //Reset Button
			resetbtn.click();
			Thread.sleep(5000);
			
				
		//Result - It should be cancel the all fileds
	}
	
	
	@Test(priority = 51)
	public void TS_002_29_In_H2H_Dash_Board_Check_the_Click_to_Authorize_Button_is_working_or_not() 
		throws InterruptedException {
		//TS_002_29.In H2H - Dash Board - Check the " Click to Authorize" Button is working or not
			WebElement threedots = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/button"));
			threedots.click();
			Thread.sleep(5000);
			WebElement Dash = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div/ul/li[1]/a"));
			Dash.click();		
			Thread.sleep(5000);
			WebElement H2H_Dash = driver.findElement(By.xpath("//*[@id=\"dashboard\"]/ul/li/a"));
			H2H_Dash.click();
			Thread.sleep(5000);
			WebElement Click_Auth = driver.findElement(By.xpath("//*[@id=\"colour_body\"]/div/div[2]/div[2]/div/div/div[3]"));
			Click_Auth.click();
		//Result --- Click the " Click to Authorize" Button, It Should navigate to authorization page
	}
	

	@Test(priority = 52)
	public void TS_002_30_In_H2H__Check_the_Back_Button () 
		throws InterruptedException {
		//TS_002_30.In H2H - Check the Back Button 
			driver.navigate().back();
		    Thread.sleep(3000);
		//Result ---If we click the Back Button, it should be Log out instead of going back to previous page.
	}
	
	@Test(priority = 53)
	public void TS_003_01_Check_click_the_Setting_parental_menu () 
		throws InterruptedException {	
		//TS_003_01. click the "Setting" parental menu 
			WebElement tooglebtn = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/button/i"));
			tooglebtn.click();
	        Thread.sleep(3000);	
	        WebElement Settings = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div/ul/li[3]/a"));
	        Settings.click();
	        Thread.sleep(3000);
	        //driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		//Result ---- It shows child menu -  *"Profile image upload" *"Approval"*"Report Generator"
		//  *"Admin program"*"Block/Unblock user"*"Ledger Map"  *"User password Reset"                
		//   *"Invoice code" *"Invoice subcode".                                  
	}
	
	@Test(priority = 54)
	public void TS_003_02_Check_click_the_Profile_image_upload_child_menu() 
		throws InterruptedException {
		//TS_003_02."Check- click the ""Profile image upload"" child menu"
			WebElement PIU = driver.findElement(By.xpath("//*[@id=\"setting\"]/ul/li[1]/a/span"));
			PIU.click();
	        Thread.sleep(3000);	
		//Result ---"It navigate "Profile image upload"" page
	}
	
	@Test(priority = 55)
	public void TS_003_03_In_Profile_image_upload_check_the_profile_photo_field () throws InterruptedException {
		//TS_003_03.check the "profile photo" field
            //			WebElement PIU = driver.findElement(By.id("preview"));  
            //			PIU.click();
			WebElement Highlight_alert = driver. findElement(By.id("preview"));          // Highligh "preview"
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			jsExecutor. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",Highlight_alert);
	        Thread.sleep(3000);	
		//Result --- It shows the default avator pic.
	}
	
	@Test(priority = 56)
	public void TS_003_04_In_Profile_image_upload_check_the_Upload_photo_are_changed_or_not () throws InterruptedException {
		//TS_003_04."In Profile image upload- check the ""Upload photo"" are changed or not."
			WebElement fileInput = driver.findElement(By.id("inputGroupFile01"));
			fileInput.sendKeys("C:\\Users\\HD SOFT\\avatar (M2).png");
	        Thread.sleep(3000);	
		//Result --- "when we upload photo means profie photo should be changed."
	}
	
	@Test(priority = 57)
	public void TS_003_05_In_Profile_image_upload_check_the_Upload_photo_field () throws InterruptedException {
		//TS_003_05.""In Profile image upload - check the ""Upload photo""field"."
			WebElement fileInput = driver.findElement(By.id("inputGroupFile01"));
			fileInput.sendKeys("C:\\Users\\HD SOFT\\avatar (M1).png");
	        Thread.sleep(3000);	
		//Result --- "It will be a file input or browse field."
	}
	
	@Test(priority = 58)
	public void TS_003_06_In_Profile_image_upload_check_the_Upload_photo_field_whether_it_support_or_not () throws InterruptedException {
		//TS_003_06."""In Profile image upload- check the ""Upload photo""field whether it support or not."."
		WebElement JPGfile = driver.findElement(By.id("inputGroupFile01"));          //JPG Type of file
		JPGfile.sendKeys("C:\\Users\\HD SOFT\\JPG,JPEG,PNG\\JPG.jpg");    
		Thread.sleep(2000);
		WebElement JFIFfile = driver.findElement(By.id("inputGroupFile01"));          //JFIF Type of file
		JFIFfile.sendKeys("C:\\Users\\HD SOFT\\JPG,JPEG,PNG\\JFIF.jfif");
		Thread.sleep(2000);
		WebElement JPEGfile = driver.findElement(By.id("inputGroupFile01"));          //JPEG Type of file
		JPEGfile.sendKeys("C:\\Users\\HD SOFT\\JPG,JPEG,PNG\\JPEG.jpeg");
		Thread.sleep(2000);
		WebElement PNGfile = driver.findElement(By.id("inputGroupFile01"));          //PNG Type of file
		PNGfile.sendKeys("C:\\Users\\HD SOFT\\JPG,JPEG,PNG\\PNG.png");
		Thread.sleep(2000);		
		//Result --- "It will be a file input or browse field."
	}
	
	@Test(priority = 59)
	public void TS_003_07_In_Profile_image_upload_check_the_Upload_photo_field_whether_it_support_the_size_of_image () throws InterruptedException {
		//TS_003_07."In Profile image upload- check the ""Upload photo""field whether it support the size of image.".
			WebElement PNGfile = driver.findElement(By.id("inputGroupFile01"));          //Large file 
			PNGfile.sendKeys("C:\\Users\\HD SOFT\\JPG,JPEG,PNG\\More than 1MB.jpg");	
			Thread.sleep(2000);
			WebElement submitbtn = driver.findElement(By.xpath("//*[@id=\'colour_body\']/div[2]/div/div[1]/button"));         
			submitbtn.click();
			Thread.sleep(3000);	
			driver.navigate().refresh();
		//Result --- ""Image size should be less than or equal to 1 MB.""
	}
	
	@Test(priority = 60)
	public void TS_003_08_In_Profile_image_upload_Check_the_Submit_Button_to_confirm_the_entries() throws InterruptedException {
		//TS_003_08.""In Profile image upload- Check the ""Submit"" Button to confirm the entries.".
			WebElement PNGfile = driver.findElement(By.id("inputGroupFile01"));          //Submit PNG file
			PNGfile.sendKeys("C:\\Users\\HD SOFT\\JPG,JPEG,PNG\\PNG.png");
			Thread.sleep(5000);	
			WebElement submitbtn = driver.findElement(By.id("submit"));         
			submitbtn.click();
			Thread.sleep(3000);
			WebElement Highlight_alert = driver. findElement(By.id("userimg"));          // Highligh "preview"
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			jsExecutor. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",Highlight_alert);			
			Thread.sleep(4000);
		//Result --- "It should be upload photo in profile photo."
	}
	
	@Test(priority = 61)
	public void TS_003_09_In_Profile_image_upload_Check_the_Cancel_Button_to_remove_the_entries_in_all_field() throws InterruptedException {
		//TS_003_09.""In Profile image upload- Check the ""Submit"" Button to confirm the entries.".
			WebElement JPEGfile = driver.findElement(By.id("inputGroupFile01"));          
			JPEGfile.sendKeys("C:\\Users\\HD SOFT\\JPG,JPEG,PNG\\JPEG.jpeg");
			Thread.sleep(2000);
			WebElement canceltab = driver.findElement(By.id("submit"));         
			canceltab.sendKeys(Keys.TAB,Keys.ENTER);
			Thread.sleep(3000);
			WebElement Highlight_alert = driver. findElement(By.id("userimg"));          // Highligh "preview"
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			jsExecutor. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",Highlight_alert);			
			Thread.sleep(4000);
		//Result --- "It should be clear pictures in upload photo field."
	}
	
	@Test(priority = 62)
	public void TS_003_10_In_Approval_check_the_Program_Name_field()
		throws InterruptedException {
		//TS_003_10.In Approval mneu- check the "Program Name" field 		
			WebElement threedots = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/button"));
			threedots.click();
			Thread.sleep(5000);
			WebElement Approval = driver.findElement(By.xpath("//*[@id=\"setting\"]/ul/li[2]/a/span"));
			Approval.click();		
			Thread.sleep(5000);
		//Result --- It should be a dropdown suggestion field.
	}
	
	@Test(priority = 63)
	public void TS_003_11_InApproval_check_the_Program_Name_field_are_allow_manual_input_or_not()
		throws InterruptedException {
		//TS_003_11.InApproval- check the "Program Name" field are allow manual input or not.
			WebElement programname = driver.findElement(By.id("txtPgmId"));
			programname.click(); 
			Thread.sleep(3000);
		//Result --- It should not allow the manual input
	}
	
	@Test(priority = 64)
	public void TS_003_12_In_Approval_check_the_Search_Value_field ()
		throws InterruptedException {
		//TS_003_12.In Approval- check the "Search  Value"  field 
			WebElement searchvalue = driver.findElement(By.id("searchkey"));
			searchvalue.sendKeys("ABCDabcd123!@#"); //sendKeys("ABCDEFG");
			Thread.sleep(3000);
		//Result --- It will be a text field or keypad field
	}
	
	@Test(priority = 65)
	public void TS_003_13_In_Approval_check_the_Entered_by_field ()
		throws InterruptedException{
		//TS_003_13.In Approval- check the "Entered by" field 
			WebElement Enteredby = driver.findElement(By.id("enteredby"));
			Enteredby.sendKeys("ABCDabcd123!@#");
			Thread.sleep(3000);
		//Result --- It will be a text field or keypad field
	}
	
	@Test(priority = 66)
	public void TS_003_14_In_Approval_check_the_Reset_icon_button () throws InterruptedException {
		//TS_003_14.In Approval- check the "Reset icon button" 
			WebElement Reseticon_tab = driver.findElement(By.id("enteredby"));
			Reseticon_tab.sendKeys(Keys.TAB,Keys.ENTER);
			Thread.sleep(5000);
		//Result --- It will be refresh the Approval page
	}
	
	@Test(priority = 67)
	public void TS_003_15_In_Approval_check_the_row_per_page_field() 
		throws InterruptedException {
		//TS_003_15.In Approval- check the "row per page" field
			WebElement userregDD = driver.findElement(By.id("txtPgmId")); 		
			Select selectDD = new Select (userregDD);
			selectDD.selectByVisibleText("User Registration");
			Thread.sleep(3000);
			WebElement shown_entries = driver.findElement(By.name("example_length"));
			Select selectDD1 = new Select (shown_entries);
			selectDD1.selectByVisibleText("All");   
			Thread.sleep(3000);
		//Result --- it will be a dropdown suggestion field
	}
	
	@Test(priority = 68)
	public void TS_003_16_In_Approval_check_the_Authorize_button() 
		throws InterruptedException {
		//TS_003_16.In Approval- check the "Authorize"  button.
			WebElement userregDD = driver.findElement(By.id("txtPgmId")); 		
			Select selectDD = new Select (userregDD);
			selectDD.selectByVisibleText("User Registration");
			Thread.sleep(3000);
			WebElement search_field = driver.findElement(By.id("searchkey"));	
			search_field.sendKeys("Authorize_Record");
			Thread.sleep(3000);
			WebElement checkbox = driver.findElement(By.xpath("//*[@id=\"example\"]/tbody/tr[1]/td[1]"));
			checkbox.click();
			Thread.sleep(3000);
			WebElement Authorize = driver.findElement(By.id("auth"));
			Authorize.click();
			Thread.sleep(3000);
			WebElement Yesbtn = driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/button[1]"));
			Yesbtn.click();
			Thread.sleep(3000);
		//Result --- It will approve the payment
	}
	
	@Test(priority = 69)
	public void TS_003_17_In_Approval_check_the_Reject_button()
		throws InterruptedException {
		//TS_003_17.In Approval- check the "Reject" button
			driver.navigate().refresh();
			WebElement userregDD = driver.findElement(By.id("txtPgmId")); 		
			Select selectDD = new Select (userregDD);
			selectDD.selectByVisibleText("User Registration");
			Thread.sleep(3000);
			WebElement search_field = driver.findElement(By.id("searchkey"));	
			search_field.sendKeys("Reject_Record");
			Thread.sleep(3000);
			WebElement checkbox = driver.findElement(By.xpath("//*[@id=\"example\"]/tbody/tr[1]/td[1]"));
			checkbox.click();
			Thread.sleep(3000);
			WebElement Rejectbtn = driver.findElement(By.id("reject"));
			Rejectbtn.click(); 
			Thread.sleep(3000);
			WebElement textarea = driver.findElement(By.id("txtReason"));
			textarea.sendKeys("For Testing");   
			Thread.sleep(4000);
			WebElement submitbtn = driver.findElement(By.xpath("//*[@id=\"Modal\"]/div/div/div[3]/button"));
			submitbtn.click();
			Thread.sleep(3000);
			WebElement yesbtn = driver.findElement(By.xpath("/html/body/div[4]/div/div[3]/button[1]"));
			yesbtn.click();			
			Thread.sleep(3000);	
		//Result --- It will Reject the payment		 
	}
	
										// TS_003_18 ------- TS_003_24  - 7cases
	 
	@Test(priority = 70)
	public void TS_003__25_In_Block_unblock_User_Check_the_User_ID_field ()
		throws InterruptedException {
		//TS_003_25.In Block/unblock User - Check the "User ID" field
			WebElement threedots = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/button/i"));
			threedots.click();			
			Thread.sleep(2000);
			WebElement BUblock = driver.findElement(By.xpath("//*[@id=\'setting\']/ul/li[3]/a/span"));
			BUblock.click();	
			Thread.sleep(2000);
			WebElement userid = driver.findElement(By.id("tuserid"));
			userid.sendKeys("TESTER001");
			Thread.sleep(2000);
			WebElement Tab = driver.findElement(By.id("tuserid"));
			Tab.sendKeys(Keys.TAB);
			Thread.sleep(3000);
		//Result --- It will be a text field or keypad field
	}
	
	@Test(priority = 71)	
	public void TC_003_26_In_Block_unblock_User_verify_the_Check_box_field () throws InterruptedException {
		//TC_003_26.In Block/unblock User - verify the  "Check box" field.
			WebElement checkbox = driver.findElement(By.id("tbublock_label"));
			checkbox.click();
			Thread.sleep(3000);
		//Result --- click to verify the check box.
	}
	
	@Test(priority = 72)	
	public void TC_003_27_In_Block_unblock_User_Check_the_Submit_Button_to_confirm_the_entries () 
		throws InterruptedException {
		//TC_003_27.In Block/unblock User- Check the "Submit" Button to confirm the entries.
			WebElement submitbtn = driver.findElement(By.id("proceed"));
			submitbtn.click();	
			driver.switchTo().alert().accept();
			Thread.sleep(3000);
		//Result --- Requried block and unblock userid should add in Approval to waiting for Authorize.
	}
	
	@Test(priority = 73)	
	public void TC_003_28_In_Block_unblock_User_Check_the_Cancel_Button () 
		throws InterruptedException {
		//TC_003_28.In Block/unblock User- Check the "Cancel" Button  
			WebElement userid = driver.findElement(By.id("tuserid"));
			userid.clear();
			userid.sendKeys("TESTER001");
			Thread.sleep(2000);		
			WebElement Tab = driver.findElement(By.id("tuserid"));
			Tab.sendKeys(Keys.TAB);
			WebElement checkbox = driver.findElement(By.id("tbublock_label"));
			checkbox.click();	
			Thread.sleep(2000);
			WebElement cancelbtn = driver.findElement(By.xpath("//*[@id=\"colour_body\"]/div[2]/div/div[2]/button"));
			cancelbtn.click();	
			Thread.sleep(2000);
		//Result ---  It will remove the entries in all fileds.
	}
	
	@Test(priority = 74)
	public void TC_003_29_In_Ledger_Map_Check_the_Payment_Vendor_fileds () 
		throws InterruptedException {
		//TC_003_29.In Ledger Map- Check the "Payment Vendor"  fileds.
			WebElement threedots = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/button/i"));
			threedots.click();			
			Thread.sleep(2000);
			WebElement Ledgermap = driver.findElement(By.xpath("//*[@id=\'setting\']/ul/li[4]/a/span"));
			Ledgermap.click();	
			Thread.sleep(2000);
			WebElement paymentvendor = driver.findElement(By.id("inv_code"));
			paymentvendor.sendKeys("ABCDEF");
			Thread.sleep(2000);
			paymentvendor.clear();
			Thread.sleep(2000);
		//Result --- It will be a text field or keypad field
	}
	
	@Test(priority = 75)
	public void TC_003_30_In_Ledger_Map_Check_the_Invoice_Subcode_fileds () 
		throws InterruptedException {
		//TC_003_30.In Ledger Map- Check the "Invoice  Subcode"  fileds.  
			WebElement Subcode = driver.findElement(By.id("subcode1"));
			Subcode.sendKeys("ABCDEF");
			Thread.sleep(2000);
			Subcode.clear();
			Thread.sleep(2000);
		//Result --- It will be a text field or keypad field
	}
	
	@Test(priority = 76)
	public void TC_003_31_In_Ledger_Map_Check_the_Transaction_Type_fileds() 
		throws InterruptedException {
		//TC_003_31.In Ledger Map- Check the "Transaction  Type"  fileds.
			WebElement Transaction = driver.findElement(By.id("Transaction_type"));
			Transaction.click();
			Thread.sleep(2000);
		//Result --- It will be a dropdown suggestion field
	}
	
	@Test(priority = 77)
	public void TC_003_32_In_Ledger_Map_Check_the_Debit_Credit_fileds ()
		throws InterruptedException {
		//TC_003_32.In Ledger Map- Check the "Debit / Credit"  fileds.
			WebElement Debit_Credit = driver.findElement(By.id("Debit_Credit"));
			Debit_Credit.click();
			Thread.sleep(2000);
		//Result --- It will be a dropdown suggestion field
	}
	
	@Test(priority = 78)
	public void TC_003_33_In_Ledger_Map_Check_the_Currency_fileds ()
		throws InterruptedException { 
		//TC_003_33.In Ledger Map- Check the  "Currency"  fileds.
			WebElement Currency = driver.findElement(By.id("Currency"));
			Currency.click();
			Thread.sleep(3000);
		//Result --- It will be a dropdown suggestion field
	}
	
	@Test(priority = 79)
	public void TC_003_34_In_STP_Check_the_STP_check_box_field () 
		throws InterruptedException {
		//TC_003_34.In STP - Check the " STP "(check box) field
			WebElement STP = driver.findElement(By.id("STP"));
			STP.click();
			Thread.sleep(2000);
		//Result --- click to verify the check box.
	}
	
	@Test(priority = 80)
	public void TC_003_35_In_Account_Name_Check_the_Account_Name_field ()
		throws InterruptedException {
		//TC_003_35.In Account Name - Check the  "Account Name" field
			WebElement Acc_Name = driver.findElement(By.id("Acc_Name"));
			Acc_Name.sendKeys("ABCDEF");
			Thread.sleep(2000);
			Acc_Name.clear();
		//Result --- It will be a text field or keypad field
	}
	
	@Test(priority = 81)
	public void TC_003_36_In_Ledger_Map_Check_the_Submit_Button_to_confirm_the_entries ()
		throws InterruptedException {
		//TC_003_36.In Ledger Map- Check the "Submit" Button to confirm the entries.
			WebElement paymentvendor = driver.findElement(By.id("inv_code"));
			paymentvendor.sendKeys("GEPGPAY");
			Thread.sleep(4000);
			WebElement Subcode = driver.findElement(By.id("subcode1"));
			Subcode.sendKeys("1");
			Thread.sleep(4000);
			WebElement Transaction = driver.findElement(By.id("Transaction_type"));
			Select selectDD = new Select (Transaction);
			selectDD.selectByIndex(1);		
			Thread.sleep(4000);
			WebElement Debit_Credit = driver.findElement(By.id("Debit_Credit"));
			Select selectDD2 = new Select (Debit_Credit);
			selectDD2.selectByIndex(1);		
			Thread.sleep(4000);
			WebElement Currency = driver.findElement(By.id("Currency"));
			Select selectDD3 = new Select (Currency);
			selectDD3.selectByIndex(1);	
			Thread.sleep(3000);
			Currency.sendKeys(Keys.TAB);
			Thread.sleep(4000);
	//		WebElement Debit_Acc = driver.findElement(By.id("Debit_Acc"));
	//		Debit_Acc.sendKeys("5462127774");
	//		Thread.sleep(4000); //
	//		WebElement Acc_Name = driver.findElement(By.id("Acc_Name"));
	//		Acc_Name.sendKeys("GEPGPAY Debit Acc");
	//		Thread.sleep(5000);
			WebElement Submitbtn = driver.findElement(By.id("ledgesubmit"));
			Submitbtn.click();
			Thread.sleep(5000);
			WebElement Resetbtn = driver.findElement(By.id("form_reset"));
			Resetbtn.click();
			Thread.sleep(5000);
		//Result --- "It will allow only if the data is correct otherwise it wont be allow."
	}
	
	@Test(priority = 82)
	public void TC_003_37_In_Ledger_Map_Check_the_Reset_button_to_remove_the_entries_in_all_filed () 
		throws InterruptedException {
		//TC_003_37.In Ledger Map- Check the "Reset" Button to remove the entries in all filed.
			WebElement paymentvendor = driver.findElement(By.id("inv_code"));
			paymentvendor.clear();
			paymentvendor.sendKeys("TIGOPAY");
			Thread.sleep(2000);
			WebElement Subcode = driver.findElement(By.id("subcode1"));
			Subcode.clear();
			Subcode.sendKeys("1");
			Thread.sleep(2000);
			WebElement Transaction = driver.findElement(By.id("Transaction_type"));
			Select selectDD = new Select (Transaction);
			selectDD.selectByIndex(1);		
			Thread.sleep(2000);
			WebElement Debit_Credit = driver.findElement(By.id("Debit_Credit"));
			Select selectDD2 = new Select (Debit_Credit);
			selectDD2.selectByIndex(1);		
			Thread.sleep(2000);
			WebElement Currency = driver.findElement(By.id("Currency"));
			Select selectDD3 = new Select (Currency);
			selectDD3.selectByIndex(1);		
			Thread.sleep(4000);
			WebElement Credit_Acc = driver.findElement(By.id("Debit_Acc"));
			Credit_Acc.clear();
			Credit_Acc.sendKeys("6721087002");
			Thread.sleep(2000); //
			WebElement Acc_Name = driver.findElement(By.id("Acc_Name"));
			Acc_Name.sendKeys("PEER TO PEER GL");
			Thread.sleep(2000);
			WebElement Resetbtn = driver.findElement(By.id("form_reset"));
			Resetbtn.click();
			Thread.sleep(5000);
		//Result --- It should be Clear the fileds.
	}
	
	@Test(priority = 83)
	public void TC_003_38_In_User_Password_Reset_Check_the_User_id_field ()
		throws InterruptedException {
		//TC_003_38.In User Password Reset - Check the  "User id" field.  
			WebElement threedots = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/button/i"));
			threedots.click();			
			Thread.sleep(2000);
			WebElement User_Password_Reset = driver.findElement(By.xpath("//*[@id=\"setting\"]/ul/li[5]/a/span"));
			User_Password_Reset.click();	
			Thread.sleep(2000);
			WebElement uid = driver.findElement(By.id("uid"));
			uid.sendKeys("Test1");	
			Thread.sleep(4000);
			uid.clear();
			Thread.sleep(2000);
		//Result --- It will be a text field or keypad field
	}
	
	@Test(priority = 84)
	public void TC_003_39_In_User_Password_Reset_Check_the_New_Password_field () 
		throws InterruptedException {
		//TC_003_39.In User Password Reset - Check the  "New Password" field.
			WebElement New_Password = driver.findElement(By.id("topwd"));
			New_Password.sendKeys("ABCDabc123!@#");	
			Thread.sleep(3000);	
			WebElement Eye_icon = driver.findElement(By.id("toggle"));
			Eye_icon.click();
			Thread.sleep(3000);	
			New_Password.clear();
		//Result --- It will be a text field or keypad field
	}
	
	@Test(priority = 85)
	public void TC_003_40_In_User_Password_Reset_Check_the_Re_Enter_Password_field () 
		throws InterruptedException {
		//TC_003_40.In User Password Reset - Check the  "Re-Enter Password " field.
			WebElement Re_Password = driver.findElement(By.id("tpwd"));
			Re_Password.sendKeys("ABCDabc123!@#");
			Thread.sleep(3000);	
			WebElement Eye_icon = driver.findElement(By.id("toggle1"));
			Eye_icon.click();
			Thread.sleep(3000);		
			Re_Password.clear();
		//Result --- It will be a text field or keypad field
	}
	
	@Test(priority = 86)
	public void TC_003_41_In_User_Password_Reset_Check_the_Submit_Button_to_confirm_the_entries ()
		throws InterruptedException {
		//TC_003_41.In User Password Reset - Check the "Submit" Button to confirm the entries.
			WebElement uid = driver.findElement(By.id("uid"));
			uid.sendKeys("Test1");	
			Thread.sleep(2000);
			WebElement New_Password = driver.findElement(By.id("topwd"));
			New_Password.sendKeys("Login@123");	
			Thread.sleep(2000);	
			WebElement Eye_icon = driver.findElement(By.id("toggle"));
			Eye_icon.click();
			WebElement Re_Password = driver.findElement(By.id("tpwd"));
			Re_Password.sendKeys("Login@123");	
			Thread.sleep(2000);	
			WebElement Eye_icon1 = driver.findElement(By.id("toggle1"));
			Eye_icon1.click();
			Thread.sleep(2000);	
			WebElement sumbitbtn = driver.findElement(By.xpath("//*[@id=\"custom_card_action\"]/div/div/input[1]"));
			sumbitbtn.click();	
			Thread.sleep(5000);		
		//Result --- In User Password Reset - Check the "Reset" Button to remove the entries in all filed.
	}
	
	@Test(priority = 87)
	public void TC_003_42_In_User_Password_Reset_Check_the_Reset_Button_to_remove_the_entries_in_all_filed () 
		throws InterruptedException {
		//TC_003_42.In User Password Reset - Check the "Reset" Button to remove the entries in all filed.
			WebElement uid = driver.findElement(By.id("uid"));
			uid.sendKeys("Test1");	
			Thread.sleep(2000);
			WebElement New_Password = driver.findElement(By.id("topwd"));
			New_Password.sendKeys("Login@123");	
			Thread.sleep(2000);	
			WebElement Eye_icon = driver.findElement(By.id("toggle"));
			Eye_icon.click();
			WebElement Re_Password = driver.findElement(By.id("tpwd"));			
			Re_Password.sendKeys("Login@123");	
			WebElement Eye_icon1 = driver.findElement(By.id("toggle1"));
			Eye_icon1.click();
			Thread.sleep(2000);	
			WebElement Resetbtn = driver.findElement(By.xpath("//*[@id=\"custom_card_action\"]/div/div/input[2]"));
			Resetbtn.click();	
			Thread.sleep(2000);		
		//Result --- It should be Clear the fileds.
	}
	
	@Test(priority = 88)
	public void TC_03_43_In_Invoice_Code_Check_whether_the_new_invoice_code()
		throws InterruptedException {
		//TC_03_43.In Invoice Code - Check whether the new invoice code.
			WebElement threedots = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/button/i"));
			threedots.click();			
			Thread.sleep(2000);
			WebElement invoice_code_menu = driver.findElement(By.xpath("//*[@id=\"setting\"]/ul/li[6]/a/span"));
			invoice_code_menu.click();
	        Thread.sleep(3000);
			WebElement Invoice_code = driver.findElement(By.id("invcode"));
			Invoice_code.sendKeys("GEPGPAY");
			Thread.sleep(3000);
			WebElement submit_btn = driver.findElement(By.id("Inv_submit"));
			submit_btn.click();
			Thread.sleep(3000);
		//Result --- It will auto suggestion in Invoice subcode or not     

	}
	
	
	@Test(priority = 89)
	public void TC_03_44_In_Invoice_SubCode_check_the_submit_button()
		throws InterruptedException {
		//TC_03_44."In Invoice SubCode - check the submit button"
			WebElement threedots = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/button/i"));
			threedots.click();			
			Thread.sleep(2000);
			WebElement invoice_subcode_menu = driver.findElement(By.xpath("//*[@id=\"setting\"]/ul/li[7]/a/span"));
			invoice_subcode_menu.click();
	        Thread.sleep(3000);
			WebElement code_field = driver.findElement(By.id("inv_code"));
			code_field.sendKeys("GEPGPAY");
			Thread.sleep(3000);
			WebElement subcode1_field = driver.findElement(By.id("subcode1"));
			subcode1_field.sendKeys("1");
			Thread.sleep(3000);
			WebElement subcode2_field = driver.findElement(By.id("subcode2"));
			subcode2_field.sendKeys("2");
			Thread.sleep(3000);
			WebElement subcode3_field = driver.findElement(By.id("subcode3"));
			subcode3_field.sendKeys("3",Keys.TAB);
			Thread.sleep(3000);
			WebElement submit = driver.findElement(By.id("Sub_submit"));
			submit.click();
			Thread.sleep(3000);
		//Result --- "It will be allow only when they all fields are filled."

	}
	
	@Test(priority = 90)
	public void TC_04_01_Check_click_the_Profile_parent_menu()
		throws InterruptedException {
		//TC_04_01."Check- click the "Profile" parent menu 
			WebElement threedots = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/button/i"));
			threedots.click();			
			Thread.sleep(2000);
			WebElement Profile_menu = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div/ul/li[4]/a"));
			Profile_menu.click();
			Thread.sleep(2000);		
		//Result --- It shows child menu -Profile image upload,-Reset Password.                          

	}
	
	@Test(priority = 91)
	public void TC_04_02_Check_click_the_Profile_image_upload_child_menu()
		throws InterruptedException {
		//TC_04_02."Check- click the "Profile" parent menu 
			WebElement PIU_menu = driver.findElement(By.xpath("//*[@id=\"profile\"]/ul/li[1]/a"));
			PIU_menu.click();
			Thread.sleep(3000);
		//Result --- "It should navigate to ""Profile image upload"" page"                       

	}
	
	@Test(priority = 92)
	public void TC_04_03_In_Profile_image_upload_check_the_Upload_photo_field()
		throws InterruptedException {
		//TC_04_03."In Profile image upload- check the Upload photo field"		
			WebElement fileInput = driver.findElement(By.id("inputGroupFile01"));
			fileInput.sendKeys("D:\\Selenium\\Source File\\avatar (M2).png");
	        Thread.sleep(3000);	
		//Result --- It will be a file input or browse field                         

	}
	
	@Test(priority = 93)
	public void TC_04_04_In_Profile_image_upload_Check_the_Submit_Button_to_confirm_the_entries()
		throws InterruptedException {
		//TC_04_04.""In Profile image upload- Check the Submit Button to confirm the entries.""	
			WebElement submit = driver.findElement(By.id("submit"));
			submit.click();
	        Thread.sleep(3000);	
		//Result ---"It should be change the admin profile photo picture."                   

	}
	
	@Test(priority = 94)
	public void TC_04_05_In_Profile_image_upload_Check_the_Cancel_Button_to_remove_the_entries_in_all_fileds()
		throws InterruptedException {
		//TC_04_05."In Profile image upload- Check the ""Cancel""Button to remove the entries in all fileds."
			WebElement fileInput = driver.findElement(By.id("inputGroupFile01"));
			fileInput.sendKeys("D:\\Selenium\\Source File\\avatar (M2).png");
	        Thread.sleep(3000);	
			WebElement cancel_tab = driver.findElement(By.id("submit"));
			cancel_tab.sendKeys(Keys.TAB,Keys.ENTER);
	        Thread.sleep(3000);	
		//Result ---"It should be cancel the admin profile photo"                  
	}
	
	@Test(priority = 95)
	public void TC_04_06_In_Reset_Password_Check_the_New_Password_field()
		throws InterruptedException {
		//TC_04_06.""In Reset Password- Check the""New Password"" field."
			WebElement threedots = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/button/i"));
			threedots.click();			
			Thread.sleep(2000);
			WebElement New_pass = driver.findElement(By.xpath("//*[@id=\"profile\"]/ul/li[2]/a/span"));
			New_pass.click();
			Thread.sleep(2000);		
			WebElement New_Password = driver.findElement(By.id("topwd"));
			New_Password.sendKeys("ABCDabcd123!@#");
	        Thread.sleep(2000);	
	        WebElement eye_icon = driver.findElement(By.id("toggle"));
	        eye_icon.click();
	        Thread.sleep(3000);		
		//Result ---"It will be a text field or keypad field"                  
	}
	
	@Test(priority = 96)
	public void TC_04_07_In_Reset_Password_Check_the_Re_Enter_Password_field()
		throws InterruptedException {
		//TC_04_07.""In Reset Password- Check the ""Re-Enter Password"" field."
			WebElement re_Password = driver.findElement(By.id("tpwd"));
			re_Password.sendKeys("ABCDabcd123!@#");
	        Thread.sleep(2000);	
	        WebElement eye_icon = driver.findElement(By.id("toggle1"));
	        eye_icon.click();
	        Thread.sleep(3000);
		//Result ---"It will be a text field or keypad field"                

	}
	
	@Test(priority = 97)
	public void TC_04_09_In_Reset_Password_Check_the_Clear_Button()
		throws InterruptedException {
		//TC_04_09."In Reset Password-- Check the ""Submit""Button to confirm the entries."
			WebElement New_Password = driver.findElement(By.id("topwd"));
			New_Password.sendKeys("Passw0rd");
	        WebElement eye_icon = driver.findElement(By.id("toggle"));
	        eye_icon.click();
	        Thread.sleep(2000);
			WebElement re_Password = driver.findElement(By.id("tpwd"));
			re_Password.sendKeys("Passw0rd");
	        WebElement eye_icon1 = driver.findElement(By.id("toggle1"));
	        eye_icon1.click();
	        Thread.sleep(3000);          
	        WebElement Reset = driver.findElement(By.xpath("//*[@id=\"custom_card_action\"]/div/div/input[2]"));
	        Reset.click();
		//Result ---  "It should be change the New password."                  

	}
	
	@Test(priority = 98)
	public void TC_04_08_In_Reset_Password_Check_the_Submit_Button_to_confirm_the_entries()
		throws InterruptedException {
		//TC_04_08."In Reset Password-- Check the ""Submit""Button to confirm the entries."
			WebElement New_Password = driver.findElement(By.id("topwd"));
			New_Password.sendKeys("Passw0rd");
	        WebElement eye_icon = driver.findElement(By.id("toggle"));
	        eye_icon.click();
	        Thread.sleep(2000);
			WebElement re_Password = driver.findElement(By.id("tpwd"));
			re_Password.sendKeys("Passw0rd");
	        WebElement eye_icon1 = driver.findElement(By.id("toggle1"));
	        eye_icon1.click();
	        Thread.sleep(3000);          
	        WebElement submit = driver.findElement(By.xpath("//*[@id=\"custom_card_action\"]/div/div/input[1]"));
	        submit.click();
	        Thread.sleep(5000);
			WebElement Logoutimg = driver.findElement(By.id("userimg"));
			Logoutimg.click();
			Thread.sleep(5000);
			WebElement Logoutbutton = driver.findElement(By.id("sessionlogout"));
			Logoutbutton.click();
			Thread.sleep(4000);
			WebElement UsernameField = driver.findElement(By.id("txtUserId"));
			UsernameField.sendKeys("selenium_A");
			WebElement PasswordField = driver.findElement(By.id("txtPwd"));
			PasswordField.sendKeys("Passw0rd");
			Thread.sleep(3000);
			PasswordField.sendKeys(Keys.ENTER);
			Thread.sleep(3000);
		//Result ---  "It should be change the New password."                  

	}
	
	
										  //TC_04_10 -------- desgin scenario
	
	
	
	
	@AfterSuite
	public void closebrowser() {
    driver.close();
	}
	
	
	
	
	
	
}
