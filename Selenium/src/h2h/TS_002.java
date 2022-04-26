package h2h;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TS_002 {

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
		System.out.println("TS_002 has been start");
	}

	@Test(priority = 1)
	public void TC_01_Check_click_the_user_Registration_parent_menu ()
	    throws InterruptedException {	
		//1.click the "user Registration" parent menu 
		WebElement UsernameField = driver.findElement(By.id("txtUserId"));
		UsernameField.sendKeys("ADMIN002");
		WebElement PasswordField = driver.findElement(By.id("txtPwd"));
		PasswordField.sendKeys("Login@123" + Keys.ENTER);
		Thread.sleep(5000);
		WebElement parentmenu = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div/ul/li[1]/a/i"));
		parentmenu.click();	
		//Result ---- It shows child menu - "User Registraion and Reset password"
	}

	@Test(priority = 2)
	public void TC_02_Check_click_the_user_Registration_child_menu () 
			throws InterruptedException {
		//2.Check- click the "user Registration" child  menu 	
		WebElement Userregistration = driver.findElement(By.xpath("//*[@id=\"userregistration\"]/ul/li[1]/a/span"));
		Thread.sleep(3000);
		Userregistration.click();	
		//Result --- It navigate "User Registration " page	
	}

	@Test(priority = 3)
	public void TC_03_In_User_Registration_check_the_organization_code_field ()
		throws InterruptedException {
		//3.check the organization code field	
		WebElement attribute = driver.findElement(By.id("torgcd"));
		String getattribute = attribute.getAttribute("value");
		Thread.sleep(3000);	
		if (getattribute.equals("EXIM")) {
		}
		else {
		}
		//Result --- It will be label as "EXIM"
	}

	@Test(priority = 4)
	public void TC_04_User_Registration_check_the_User_ID_field_whether_it_allows_an_alphanumeric_and_special_characters_or_not () 
		throws InterruptedException {
		//4.check the [UserID] field whether it allows an alphanumeric and special characters or not
		WebElement userid =  driver.findElement(By.id("tuserid"));
		userid.sendKeys("abcABC123!@#efg");         //alphanumeric value and special character = abcABC123!@#efg
		Thread.sleep(3000);	
		//Result --- It should allow alphanumeric and special characters
		userid.clear();
	}

	@Test(priority = 5)
	public void TC_05_In_User_Registration_Check_the_User_ID_field_it_should_not_allow_more_than_20_characters () 
		throws InterruptedException {
		//5.Check the [UserID] field it should not allow more than 20 characters.
		WebElement userid =  driver.findElement(By.id("tuserid"));
		userid.sendKeys("12345678912345678912");   //12345678912345678912
		Thread.sleep(3000);	
		//Result --- It allows less than or equal to 20 characters.
		userid.clear();
	}

	@Test(priority = 6)
	public void TC_06_In_User_Registration_check_the_User_Name_field_whether_it_allows_an_alphanumeric_and_special_characters_or_not () 
		throws InterruptedException {
		//6.check the [UserName] field whether it allows an alphanumeric and special characters or not
		WebElement username =  driver.findElement(By.id("tusernme"));
		username.sendKeys("abcABC123!@#efg");   // alphanumeric and special characters = abcABC123!@#efg	
		Thread.sleep(3000);
		//Result --- It should allow alphanumeric and special characters
		username.clear();
	}

	@Test(priority = 7)
	public void TC_07_In_User_Registration_Check_the_User_Name_field_it_should_not_allow_more_than_20_characters ()
		throws InterruptedException {
		//7.Check the [UserName] field it should not allow more than 20 characters.
		WebElement username =  driver.findElement(By.id("tusernme"));
		username.sendKeys("12345678912345678912");   //12345678912345678912 along with 20characters
		Thread.sleep(3000);
		//Result --- It allows less than or equal to 20 characters.
		username.clear();	
	}

	@Test(priority = 8)
	public void TC_08_In_User_Registration_Check_the_Date_field_allows_manual_input_in_the_given_format_dd_mm_yyyy () 
		throws InterruptedException {
		//8.Check the [Date] field allows manual input in the given format(dd-mm-yyyy).
		WebElement DOB =  driver.findElement(By.id("tbirthdate"));
		DOB.sendKeys("18122000");   //Ramdom Birthday date = 18-12-2000(18th dec,2000)
		Thread.sleep(3000);
		//Result --- It should be allow manual input through keyboard.
		DOB.clear();
	}

	@Test(priority = 9)
	public void TC_09_In_User_Registration_Check_the_Date_field_whether_future_date_should_be_freeze () 
		throws InterruptedException {
		//9.Check the [Date] field  whether future date should be freeze 
		WebElement FutureDate =  driver.findElement(By.id("tbirthdate"));
		FutureDate.sendKeys("18122025");   //FutureDate = 18-12-2025(18th dec,2025) current date =(29-12-2021)
		Thread.sleep(3000);
		//Result --- It does not allow to select future dates and it should be in freezed format.
		FutureDate.clear();
	}


	@Test(priority = 10)
	public void TC_10_In_User_Registration_Check_the_Date_field_shows_the_calander_icon_in_the_dropdown_format () 
		throws InterruptedException {
		//10.Check the [Date] field shows the calander icon in the dropdown format.
			WebElement FutureDate =  driver.findElement(By.id("tbirthdate"));                    // ????????????????????????
			Thread.sleep(3000);
			FutureDate.click();  
			Thread.sleep(3000);
		//Result ---- It should be visible calender icon.
	}


	@Test(priority = 11)
	public void TC_11_In_User_Registration_check_the_primary_mobile_number_field_allows_only_a_numeric_value_or_not () 
		throws InterruptedException {
		//11. check the [primary mobilenumber] field allows only a numeric value or not 
		WebElement Numvalue =  driver.findElement(By.id("tmobile"));
		Numvalue.sendKeys("9087369066");   //Mobile No =9087369066
		Thread.sleep(3000);
		//Result --- It should allow only numeric value
		Numvalue.clear();
	}

	@Test(priority = 12)
	public void TC_12_In_User_Registration_check_the_primary_mobile_number_field_should_not_allow_more_than_10_digits () 
		throws InterruptedException {
		//12. check the [primary mobilenumber] field  should not allow more than 10-digits
			WebElement Numvalue =  driver.findElement(By.id("tmobile"));
			Numvalue.sendKeys("9087369066");   //Mobile No =9087369066 along with only 10characters
			Thread.sleep(3000);
		//Result --- It should not allow more than 10-digits
			Numvalue.clear();
	}


	@Test(priority = 13)
	public void TC_13_In_User_Registration_check_the_primary_Email_Id_should_allow_Email_text_type ()
		throws InterruptedException {
		//13.check the primary Email Id should allow Email text type.
		WebElement Emailvalue =  driver.findElement(By.id("temail"));
		Emailvalue.sendKeys("Mukesh@hdsoftwaresystems.com");
		Thread.sleep(3000);
		//Result --- It should allow the Email text type.
		Emailvalue.clear();
	}

	@Test(priority = 14)
	public void TC_14_In_User_Registration_Check_the_eye_button_working_or_not_in_the_Password_field ()
		throws InterruptedException {
		//14. Check the eye button working or not in the Password field
			WebElement Passfield =  driver.findElement(By.id("tpwd"));
			Passfield.sendKeys("Login@123");
			Thread.sleep(3000);
			WebElement Passeyeicon =  driver.findElement(By.id("toggle"));
			Passeyeicon.click();
			Thread.sleep(3000);
		//Result --- If we click the eye button in the password field, the typed password is visible instead of dots.
			Passfield.clear();
	}

	@Test(priority = 15)
	public void TC_15_In_User_Registration_Check_the_Password_field_it_should_be_hidden_by_dots_instead_of_alphanumeric_and_special_characters () 
		throws InterruptedException {
		//15.  Check the Password field it should be hidden by dots instead of alphanumeric and special characters.
		WebElement Passfield =  driver.findElement(By.id("tpwd"));
		Passfield.sendKeys("abcABC123!@#efg");     //alphanumeric value and special character = abcABC123!@#efg
		Thread.sleep(3000);
		WebElement Passeyeicon =  driver.findElement(By.id("toggle"));
		Passeyeicon.click();
		Thread.sleep(3000);
		//Result --- When we type the password it should be in hidden format instead of alphanumeric and special characters field shown dots only.
		Passfield.clear();
	}

	@Test(priority = 16) 
	public void TC_16_In_User_Registration_Check_the_eye_button_working_or_not_in_the_Re_Enter_Password_field () 
		throws InterruptedException {
		//16. Check the eye button working or not in the [Re-Enter Password] field.
			WebElement Re_Passfield =  driver.findElement(By.id("tconfirmpwd"));
			Re_Passfield.sendKeys("Login@123");
			Thread.sleep(3000);
			WebElement Re_Passeyeicon =  driver.findElement(By.id("toggle1"));
			Re_Passeyeicon.click();
			Thread.sleep(3000);
		//Result --- If we click the eye button in the Re-Enter password field, the typed password is visible instead of dots.
			Re_Passfield.clear();
	}

	@Test(priority = 17)
	public void TC_17_In_User_Registration_Check_the_Re_Enter_Password_field_it_should_be_hidden_by_dots_instead_of_alphanumeric_and_special_characters()
	    throws InterruptedException {
		//17. Check the     Re-Enter Password field it should be hidden by dots instead of alphanumeric and special characters.
			WebElement Re_Passfield =  driver.findElement(By.id("tconfirmpwd"));
			Re_Passfield.sendKeys("abcABC123!@#efg");     //alphanumeric value and special character = abcABC123!@#efg
			Thread.sleep(3000);
			WebElement Re_Passeyeicon =  driver.findElement(By.id("toggle1"));
			Re_Passeyeicon.click();
			Thread.sleep(3000);
		//Result --- When we type the password it should be in hidden format instead of alphanumeric and special characters field shown dots only.
		Re_Passfield.clear();
	}

	@Test(priority = 18)
	public void TC_18_In_User_Registration_Check_the_Role_code_should_be_in_the_dropdown_field_and_it_contain_different_role_like_Admin_Maker_Checker_etc ()
    throws InterruptedException {
		//18.Check the Role code should be in the dropdown field and it contain different role like Admin,Maker,Checker etc
		WebElement dropdownindex = driver.findElement(By.id("trolecd"));
		Select selectDD = new Select (dropdownindex);
		selectDD.selectByIndex(1);    //MAKR -  Peer Role
		Thread.sleep(2000);
		selectDD.selectByIndex(2); 	  //ADMIN -  Admin User
		Thread.sleep(2000);
		selectDD.selectByIndex(3);    //CHKR -  check User
		Thread.sleep(2000);	
		//Result --- It should be in the dropdown field and it contains the different roles like Admin,Maker,Checker etc.
		selectDD.selectByIndex(0);    // for resume the position of dropdown
	}

	@Test(priority = 19)
	public void TC_19_In_User_Registration_Check_the_Role_code_dropdown_field_it_shows_a_label_select ()
		throws InterruptedException {
		//19.Check the Role code dropdown field it shows a label "select". 
		WebElement dropdownindex = driver.findElement(By.id("trolecd"));
		Select selectDD = new Select (dropdownindex);
		selectDD.selectByIndex(1);                                 //MAKR -  Peer Role
		Thread.sleep(2000);
		WebElement dropdown1 = selectDD.getFirstSelectedOption();
		String dropdownvalue1 = dropdown1.getText();
		System.out.println(dropdownvalue1);
		selectDD.selectByIndex(2); 	                               //ADMIN -  Admin User
		Thread.sleep(2000);
		WebElement dropdown2 = selectDD.getFirstSelectedOption();
		String dropdownvalue2 = dropdown2.getText();
		System.out.println(dropdownvalue2);
		selectDD.selectByIndex(3);                                 //CHKR -  check User	
		Thread.sleep(2000);
		WebElement dropdown3 = selectDD.getFirstSelectedOption();
		String dropdownvalue3 = dropdown3.getText();
		System.out.println(dropdownvalue3);
		//Result --- It shows the label "select"
	}

	@Test(priority = 20)
	public void TC_20_In_User_Registration_Check_the_Role_code_dropdown_field_allow_to_select_the_listed_Role_code () 
		throws InterruptedException {
		//20. Check the Role code dropdown field allow to select the listed Role code
		WebElement dropdownindex = driver.findElement(By.id("trolecd"));
		Select selectDD = new Select (dropdownindex);
		selectDD.selectByIndex(1);    //MAKR -  Peer Role
		Thread.sleep(2000);
		selectDD.selectByIndex(2); 	  //ADMIN -  Admin User
		Thread.sleep(2000);
		selectDD.selectByIndex(3);    //CHKR -  check User
		Thread.sleep(2000);
		//Result ---It should be allow to select a Role code already listed in the dropdown field.
		selectDD.selectByIndex(0);    // for resume the position of dropdown
	}

	@Test(priority = 21)
	public void TC_21_In_User_Registration_Check_the_Registration_Date_whether_future_date_are_not_shown () 
		throws InterruptedException {
		//21.Check the Registration Date whether future date are not shown
		WebElement RegDate =  driver.findElement(By.id("tregdate"));
		RegDate.sendKeys("30122021");   //Regsitration Date =  current date =(30-12-2021)
		Thread.sleep(3000);
		RegDate.clear();
	}

	@Test(priority = 22)
	public void TC_22_In_User_Registration_Check_the_Branch_code_should_be_in_the_dropdown_field_and_it_contain_several_number_of_branch_codes () 
		throws InterruptedException {
		//22.Check the Branch code should be in the dropdown field and it contain several number of branch codes. 
		WebElement dropdownindex = driver.findElement(By.id("branchcd"));
		Select selectDD = new Select (dropdownindex);
		selectDD.selectByIndex(1);    //1 -  EBTL, Exim Tower
		Thread.sleep(1000);
		selectDD.selectByIndex(2); 	  //2 -  EBTL, Mtwara
		Thread.sleep(1000);
		selectDD.selectByIndex(3);    //3 -  EBTL, Arusha
		Thread.sleep(1000);
		//Result --- It should be in the dropdown field and it contains the several number of branch codes.
		selectDD.selectByIndex(0);    // for resume the position of dropdown
	}

	@Test(priority = 23)
	public void TC_23_In_User_Registration_Check_the_Branch_code_dropdown_field_it_shows_a_label_select ()
		throws InterruptedException {
		//23.Check the Branch code dropdown field it shows a label "select".
		WebElement dropdownindex = driver.findElement(By.id("branchcd"));
		Select selectDD = new Select (dropdownindex);
		selectDD.selectByIndex(1);                                //1 -  EBTL, Exim Tower
		Thread.sleep(2000);
		WebElement dropdown1 = selectDD.getFirstSelectedOption();
		String dropdownvalue1 = dropdown1.getText();
		System.out.println(dropdownvalue1);
		selectDD.selectByIndex(2); 	                              //2 -  EBTL, Mtwara
		Thread.sleep(2000);
		WebElement dropdown2 = selectDD.getFirstSelectedOption();
		String dropdownvalue2 = dropdown2.getText();
		System.out.println(dropdownvalue2);
		selectDD.selectByIndex(3);                                 //3 -  EBTL, Arusha
		WebElement dropdown3 = selectDD.getFirstSelectedOption();
		String dropdownvalue3 = dropdown3.getText();
		System.out.println(dropdownvalue3);
		//Result --- It shows the label "select"
		selectDD.selectByIndex(0);    // for resume the position of dropdown
	}

	@Test(priority = 24)
	public void TC_24_In_User_Registration_Check_the_branch_code_dropdown_field_allow_to_select_the_listed_branch_code() 
		throws InterruptedException {
		//24.Check the branch code dropdown field allow to select the listed branch code
		WebElement dropdownindex = driver.findElement(By.id("branchcd"));
		Select selectDD = new Select (dropdownindex);
		selectDD.selectByIndex(1);    //1 -  EBTL, Exim Tower
		Thread.sleep(2000);
		selectDD.selectByIndex(2); 	  //2 -  EBTL, Mtwara
		Thread.sleep(2000);
		selectDD.selectByIndex(3);    //3 -  EBTL, Arusha
		//Result --- It should be allow to select a branch code already listed in the dropdown field.
		selectDD.selectByIndex(0);    // for resume the position of dropdown
	}

	@Test(priority = 25)
	public void TC_25_In_User_Registration_Check_the_Submit_Button_to_confirm_the_entries() 
		throws InterruptedException {
		//25. Check the Submit Button to confirm the entries.
		WebElement userid =  driver.findElement(By.id("tuserid"));             //userid
		userid.sendKeys("ADMIN002");   
		Thread.sleep(1000);	

		WebElement username =  driver.findElement(By.id("tusernme"));          //username      
		username.sendKeys("Tester003");   	
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
		RegDate.sendKeys("30122021");   
		Thread.sleep(1000);

		WebElement dropdownbranchcd = driver.findElement(By.id("branchcd"));    //Branch Code
		Select selectDD1 = new Select (dropdownbranchcd);
		selectDD1.selectByIndex(1);    //1 -  EBTL, Exim Tower
		Thread.sleep(1000);

		WebElement submitbtn = driver.findElement(By.xpath("//*[@id=\'colour_body\']/div[2]/div/div[1]/button"));   //Submit Button
		submitbtn.click();
		Thread.sleep(3000);
		WebElement resetbtn = driver.findElement(By.xpath("//*[@id=\'colour_body\']/div[2]/div/div[2]/button"));   //Reset Button for clear the field 
		resetbtn.click();
		//Result --- It should be submit the Record and leave a message as "Record Submitted Succesffully" 

	}


	@Test(priority = 26)
	public void TC_26_In_User_Registration_Check_the_Cancel_Button_to_remove_the_entries_in_all_fileds()
		throws InterruptedException {
		//26.Check the "Cancel" Button to remove the entries in all fileds.
		WebElement userid =  driver.findElement(By.id("tuserid"));             //userid
		userid.sendKeys("ADMIN002");   
		Thread.sleep(1000);	

		WebElement username =  driver.findElement(By.id("tusernme"));          //username      
		username.sendKeys("Tester003");   	
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
		Thread.sleep(3000);

		WebElement Re_Passfield =  driver.findElement(By.id("tconfirmpwd"));   //Re-Enter password
		Re_Passfield.sendKeys("Login@123");
		Thread.sleep(1000);

		WebElement dropdownindex = driver.findElement(By.id("trolecd")); 		//Role Code - MAKR 
		Select selectDD = new Select (dropdownindex);
		selectDD.selectByIndex(3);    
		Thread.sleep(1000);

		WebElement RegDate =  driver.findElement(By.id("tregdate"));			//Current Date 
		RegDate.sendKeys("30122021");   
		Thread.sleep(1000);

		WebElement dropdownbranchcd = driver.findElement(By.id("branchcd"));    //Branch Code
		Select selectDD1 = new Select (dropdownbranchcd);
		selectDD1.selectByIndex(1);    //1 -  EBTL, Exim Tower
		Thread.sleep(1000);
		
		WebElement resetbtn = driver.findElement(By.xpath("//*[@id=\'colour_body\']/div[2]/div/div[2]/button"));   //Reset Button
		resetbtn.click();
		Thread.sleep(2000);
	}

	
	@AfterSuite
	public void closebrowser() {
	 	driver.close();
	}
	
	
	

}
