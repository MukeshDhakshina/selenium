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

public class TS_003 {
	WebDriver driver;
	long StartTime;
	long EndTime;

	@BeforeSuite
	public void OpenBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Chromedriver\\chromedriver(9.6).exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://192.168.3.252:8090/H2H_new/");
		Thread.sleep(2000);
	}

	@Test(priority = 1)
	public void TC_01_Check_click_the_Setting_parental_menu () 
		throws InterruptedException {	
		//1. click the "Setting" parental menu 
			WebElement UsernameField = driver.findElement(By.id("txtUserId"));
			UsernameField.sendKeys("ADMIN");
			WebElement PasswordField = driver.findElement(By.id("txtPwd"));
			PasswordField.sendKeys("Login@123" + Keys.ENTER);
			Thread.sleep(5000);
			WebElement tooglebtn = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/button/i"));
			tooglebtn.click();
			Thread.sleep(7000);									//driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		//Result ---- It shows child menu -  *"Profile image upload" *"Approval"*"Report Generator"
		//  *"Admin program"*"Block/Unblock user"*"Ledger Map"  *"User password Reset"                
		//   *"Invoice code" *"Invoice subcode".                                  
	}

	@Test(priority = 2)
	public void TC_02_Check_click_the_Profile_image_upload_child_menu ()
	    throws InterruptedException {  
		//2.click the "Profile image upload" child  menu
		WebElement profile = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div/ul/li[2]/a/i"));
		profile.click();
		Thread.sleep(3000);
		WebElement PIU = driver.findElement(By.xpath("//*[@id=\"setting\"]/ul/li[1]/a/span"));
		PIU.click();	
		Thread.sleep(5000);
		//Result --- It navigate "Profile image upload" page 
	}

	@Test(priority = 3)
	public void TC_03_In_Profile_image_upload_check_the_profile_photo_field () {
		//3.check the "profile photo" field
		WebElement PIU = driver.findElement(By.id("preview"));  
		PIU.click();
		//Result --- It shows the default avator pic.
	}

	@Test(priority = 4)
	public void TC_04_In_Profile_image_upload_check_the_Upload_photo_are_changed_or_not() {
		//4.check the "Upload photo"  are changed or not.
			WebElement fileInput = driver.findElement(By.id("inputGroupFile01"));
			fileInput.sendKeys("C:\\Users\\HD SOFT\\Pictures\\avatar (M2).png");	
		//Result --- when we upload photo means profie photo should be changed.
	}

	@Test(priority = 5)
	public void TC_05_In_Profile_image_upload_check_the_Upload_photo_field () {
		//5.check the "Upload photo"field
		WebElement fileInput = driver.findElement(By.id("inputGroupFile01"));
		fileInput.sendKeys("C:\\Users\\HD SOFT\\Pictures\\avatar (M1).png");
		//Result --- It will be a file input or browse field.
	}

	@Test(priority = 6)
	public void TC_06_In_Profile_image_upload_check_the_Upload_photo_field_whether_it_support_or_not ()
		throws InterruptedException {
		//6.check the "Upload photo"field whether it support or not. 
			WebElement JPGfile = driver.findElement(By.id("inputGroupFile01"));          //JPG Type of file
			JPGfile.sendKeys("C:\\Users\\HD SOFT\\Pictures\\JPG,JPEG,PNG\\JPG.jpg");    
			Thread.sleep(1000);
			WebElement JFIFfile = driver.findElement(By.id("inputGroupFile01"));          //JFIF Type of file
			JFIFfile.sendKeys("C:\\Users\\HD SOFT\\Pictures\\JPG,JPEG,PNG\\JFIF.jfif");
			Thread.sleep(1000);
			WebElement JPEGfile = driver.findElement(By.id("inputGroupFile01"));          //JPEG Type of file
			JPEGfile.sendKeys("C:\\Users\\HD SOFT\\Pictures\\JPG,JPEG,PNG\\JPEG.jpeg");
			Thread.sleep(1000);
			WebElement PNGfile = driver.findElement(By.id("inputGroupFile01"));          //PNG Type of file
			PNGfile.sendKeys("C:\\Users\\HD SOFT\\Pictures\\JPG,JPEG,PNG\\PNG.png");
			Thread.sleep(2000);		
		//Result --- It should support all type of extensions(JPG,JFIF,JPEG,PNG).
	}

	@Test(priority = 7)
	public void TC_07_In_Profile_image_upload_check_the_Upload_photo_field_whether_it_support_the_size_of_image()
		throws InterruptedException {
		//7.check the "Upload photo"field whether it support the size of image.
			WebElement PNGfile = driver.findElement(By.id("inputGroupFile01"));          //Large file 
			PNGfile.sendKeys("C:\\Users\\HD SOFT\\Pictures\\JPG,JPEG,PNG\\More than 1MB.jpg");	
			Thread.sleep(1000);
			WebElement submitbtn = driver.findElement(By.xpath("//*[@id=\'colour_body\']/div[2]/div/div[1]/button"));         
			submitbtn.click();
			Thread.sleep(3000);
		//Result --- Image size should be less than or equal to 1 MB.
	}

	@Test(priority = 8)
	public void TC_08_In_Profile_image_upload_Check_the_Submit_Button_to_confirm_the_entries () 
		throws InterruptedException {
		//8.Check the "Submit" Button to confirm the entries.
			WebElement PNGfile = driver.findElement(By.id("inputGroupFile01"));          //Submit PNG file
			PNGfile.sendKeys("C:\\Users\\HD SOFT\\Pictures\\JPG,JPEG,PNG\\PNG.png");
			Thread.sleep(1000);	
			WebElement submitbtn = driver.findElement(By.xpath("//*[@id=\'colour_body\']/div[2]/div/div[1]/button"));         
			submitbtn.click();
			Thread.sleep(4000);
		//Result --- It should be upload photo in profile photo.
	}

	@Test(priority = 9)
	public void TC_09_In_Profile_image_upload_Check_the_Cancel_Button_to_remove_the_entries_in_all_field () 
		throws InterruptedException {
		//9.Check the "Cancel" Button to remove the entries in all field.  
			WebElement JPEGfile = driver.findElement(By.id("inputGroupFile01"));          
			JPEGfile.sendKeys("C:\\Users\\HD SOFT\\Pictures\\JPG,JPEG,PNG\\JPEG.jpeg");
			Thread.sleep(2000);
			WebElement Cancelbtn = driver.findElement(By.xpath("//*[@id=\'colour_body\']/div[2]/div/div[2]/button"));  //Cancel JGEG file       
			Cancelbtn.click();
			Thread.sleep(5000);
		//Result --- It should be clear pictures in upload photo field. 
	}

	@Test(priority = 10)
	public void TC_10_In_Approval_check_the_Program_Name_field ()
		throws InterruptedException {
		//10.In Approval mneu- check the "Program Name" field 		
		WebElement threedots = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/button"));
		threedots.click();
		Thread.sleep(3000);
		WebElement settings = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div/ul/li[2]/a"));
		settings.click();
		WebElement Approval = driver.findElement(By.xpath("//*[@id=\"setting\"]/ul/li[2]/a/span"));
		Approval.click();		
		Thread.sleep(2000);
		//Result --- It should be a dropdown suggestion field.
	}
	
	@Test(priority = 11)
	public void TC_11_InApproval_check_the_Program_Name_field_are_allow_manual_input_or_not() 
		throws InterruptedException {
		//11.InApproval- check the "Program Name" field are allow manual input or not.
			WebElement programname = driver.findElement(By.id("txtPgmId"));
			programname.click(); //sendKeys("ABCDEFG");
		Thread.sleep(3000);
		//Result --- It should not allow the manual input
	}
	
	@Test(priority = 12)
	public void TC_12_In_Approval_check_the_Search_Value_field () 
		throws InterruptedException {
		//12.In Approval- check the "Search  Value"  field 
			WebElement searchvalue = driver.findElement(By.id("searchkey"));
			searchvalue.sendKeys("ABCDEF");//sendKeys("ABCDEFG");
			Thread.sleep(3000);
		//Result --- It will be a text field or keypad field
	}
	
	@Test(priority = 13)
	public void TC_13_In_Approval_check_the_Entered_by_field ()
		throws InterruptedException{
		//13.In Approval- check the "Entered by" field 
		WebElement Enteredby = driver.findElement(By.id("enteredby"));
		Enteredby.sendKeys("ABCDEF");
		Thread.sleep(3000);
		//Result --- It will be a text field or keypad field
	}
	
	@Test(priority = 14)
	public void TC_14_In_Approval_check_the_Reset_icon_button () {
		//14.In Approval- check the "Reset icon button" 
		WebElement Reseticon = driver.findElement(By.xpath("//*[@id=\"colour_body\"]/div/div[1]/div[4]/div/div/div/button"));
		Reseticon.click();
		//Result --- It will be refresh the Approval page
	}
	
	@Test(priority = 15)
	public void TC_15_In_Approval_check_the_row_per_page_field() 
		throws InterruptedException {
		//15.In Approval- check the "row per page" field
		WebElement rowpage = driver.findElement(By.id("page_len"));
		rowpage.click();
		Thread.sleep(3000);
		//Result --- it will be a dropdown suggestion field
	}
	
	@Test(priority = 16)
	public void TC_16_In_Approval_check_the_Authorize_button() 
		throws InterruptedException {
		//16.In Approval- check the "Authorize"  button.
		WebElement userregDD = driver.findElement(By.id("txtPgmId")); 		
		Select selectDD = new Select (userregDD);
		selectDD.selectByIndex(10);
		Thread.sleep(2000);
		WebElement someclick = driver.findElement(By.xpath("//*[@id=\"colour_body\"]/div/div[1]/div[2]/div/div[1]/div/label"));
		someclick.click();
		Thread.sleep(3000);
		WebElement checkbox = driver.findElement(By.xpath("//*[@id=\"example\"]/tbody/tr[1]/td[1]"));
		checkbox.click();
		Thread.sleep(3000);
		WebElement Authorize = driver.findElement(By.xpath("//*[@id=\'colour_body\']/div/div[2]/div[3]/div/div[1]/div/button"));
		Authorize.click();
		Thread.sleep(3000);
		WebElement Yesbtn = driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/button[1]"));
		Yesbtn.click();
		Thread.sleep(3000);
		//Result --- It will approve the payment
	}
	
	@Test(priority = 17)
	public void TC_17_In_Approval_check_the_Reject_button()
		throws InterruptedException {
		//17.In Approval- check the "Reject" button
		WebElement userregDD = driver.findElement(By.id("txtPgmId")); 		
		Select selectDD = new Select (userregDD);
		selectDD.selectByIndex(10);
		Thread.sleep(3000);
		WebElement someclick = driver.findElement(By.xpath("//*[@id=\"colour_body\"]/div/div[1]/div[2]/div/div[1]/div/label"));
		someclick.click();
		Thread.sleep(3000);
		WebElement checkbox = driver.findElement(By.xpath("//*[@id=\"example\"]/tbody/tr[1]/td[1]"));
		checkbox.click();
		Thread.sleep(3000);
		WebElement Rejectbtn = driver.findElement(By.xpath("//*[@id=\"colour_body\"]/div/div[2]/div[3]/div/div[2]/div/button"));
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
		Thread.sleep(4000);
		WebElement Xbtn = driver.findElement(By.xpath("//*[@id=\'Modal\']/div/div/div[1]/button/span"));
		Xbtn.click();
		Thread.sleep(3000);
		
		//Result --- It will Reject the payment		 
	}

	 // ---------------------------------//TC_18 to TC_24 Has been not enabled-----------------------------------------
	
	@Test(priority = 25)
	public void TC_25_In_Block_unblock_User_Check_the_User_ID_field ()
		throws InterruptedException {
		//25.In Block/unblock User - Check the "User ID" field
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
		//Result --- It will be a text field or keypad field
	}
	
	@Test(priority = 26)	
	public void TC_26_In_Block_unblock_User_verify_the_Check_box_field () {
		//26.In Block/unblock User - verify the  "Check box" field.
		WebElement checkbox = driver.findElement(By.id("tbublock_label"));
		checkbox.click();	
		//Result --- click to verify the check box.
	}
	
	@Test(priority = 27)	
	public void TC_27_In_Block_unblock_User_Check_the_Submit_Button_to_confirm_the_entries () 
		throws InterruptedException {
		//27.In Block/unblock User- Check the "Submit" Button to confirm the entries.
		WebElement submitbtn = driver.findElement(By.id("proceed"));
		submitbtn.click();	
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		//Result --- Requried block and unblock userid should add in Approval to waiting for Authorize.
	}
	
	@Test(priority = 28)	
	public void TC_28_In_Block_unblock_User_Check_the_Cancel_Button () 
		throws InterruptedException {
		//28.In Block/unblock User- Check the "Cancel" Button  
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
	
	@Test(priority = 29)
	public void TC_29_In_Ledger_Map_Check_the_Payment_Vendor_fileds () 
		throws InterruptedException {
		//29.In Ledger Map- Check the "Payment Vendor"  fileds.
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
		//Result --- It will be a text field or keypad field
	}
	
	@Test(priority = 30)
	public void TC_30_In_Ledger_Map_Check_the_Invoice_Subcode_fileds () 
		throws InterruptedException {
		//30.In Ledger Map- Check the "Invoice  Subcode"  fileds.  
		WebElement Subcode = driver.findElement(By.id("subcode1"));
		Subcode.sendKeys("ABCDEF");
		Thread.sleep(2000);
		Subcode.clear();
		//Result --- It will be a text field or keypad field
	}
	
	@Test(priority = 31)
	public void TC_31_In_Ledger_Map_Check_the_Transaction_Type_fileds() 
		throws InterruptedException {
		//31.In Ledger Map- Check the "Transaction  Type"  fileds.
		WebElement Transaction = driver.findElement(By.id("Transaction_type"));
		Transaction.click();
		Thread.sleep(2000);
		//Result --- It will be a dropdown suggestion field
	}
	
	@Test(priority = 32)
	public void TC_32_In_Ledger_Map_Check_the_Debit_Credit_fileds ()
		throws InterruptedException {
		//32.In Ledger Map- Check the "Debit / Credit"  fileds.
		WebElement Debit_Credit = driver.findElement(By.id("Debit_Credit"));
		Debit_Credit.click();
		Thread.sleep(2000);
		//Result --- It will be a dropdown suggestion field
	}
	
	@Test(priority = 33)
	public void TC_33_In_Ledger_Map_Check_the_Currency_fileds ()
		throws InterruptedException { 
		//33.In Ledger Map- Check the  "Currency"  fileds.
		WebElement Currency = driver.findElement(By.id("Currency"));
		Currency.click();
		Thread.sleep(3000);
		//Result --- It will be a dropdown suggestion field
	}
	
	@Test(priority = 34)
	public void TC_34_In_STP_Check_the_STP_check_box_field () 
		throws InterruptedException {
		//34.In STP - Check the " STP "(check box) field
		WebElement STP = driver.findElement(By.id("STP"));
		STP.click();
		Thread.sleep(2000);
		//Result --- click to verify the check box.
	}
			
	@Test(priority = 35)
	public void TC_35_In_Account_Name_Check_the_Account_Name_field ()
		throws InterruptedException {
		//35.In Account Name - Check the  "Account Name" field
			WebElement Acc_Name = driver.findElement(By.id("Acc_Name"));
			Acc_Name.sendKeys("ABCDEF");
			Thread.sleep(2000);
			Acc_Name.clear();
		//Result --- It will be a text field or keypad field
	}
	
	@Test(priority = 36)
	public void TC_36_In_Ledger_Map_Check_the_Submit_Button_to_confirm_the_entries ()
		throws InterruptedException {
		//36.In Ledger Map- Check the "Submit" Button to confirm the entries.
		WebElement paymentvendor = driver.findElement(By.id("inv_code"));
		paymentvendor.sendKeys("TIGOPAY");
		Thread.sleep(2000);
		WebElement Subcode = driver.findElement(By.id("subcode1"));
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
		Thread.sleep(2000);
		WebElement Credit_Acc = driver.findElement(By.id("Credit_Acc"));
		Credit_Acc.sendKeys("6721087002");
		Thread.sleep(2000); //
		WebElement Acc_Name = driver.findElement(By.id("Acc_Name"));
		Acc_Name.sendKeys("PEER TO PEER GL");
		Thread.sleep(2000);
		WebElement Submitbtn = driver.findElement(By.id("ledgesubmit"));
		Submitbtn.click();
		Thread.sleep(2000);
		//Result --- "It will allow only if the data is correct otherwise it wont be allow."
	}
	
	@Test(priority = 37)
	public void TC_37_In_Ledger_Map_Check_the_Reset_button_to_remove_the_entries_in_all_filed () 
		throws InterruptedException {
		//37.In Ledger Map- Check the "Reset" Button to remove the entries in all filed.
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
		Thread.sleep(2000);
		WebElement Credit_Acc = driver.findElement(By.id("Debit_Acc"));
		Credit_Acc.clear();
		Credit_Acc.sendKeys("6721087002");
		Thread.sleep(2000); //
		WebElement Acc_Name = driver.findElement(By.id("Acc_Name"));
		Acc_Name.sendKeys("PEER TO PEER GL");
		Thread.sleep(2000);
		WebElement Resetbtn = driver.findElement(By.id("form_reset"));
		Resetbtn.click();
		Thread.sleep(2000);
		//Result --- It should be Clear the fileds.
	}
	
	@Test(priority = 38)
	public void TC_38_In_User_Password_Reset_Check_the_User_id_field ()
		throws InterruptedException {
		//38.In User Password Reset - Check the  "User id" field.  
		WebElement threedots = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/button/i"));
		threedots.click();			
		Thread.sleep(2000);
		WebElement User_Password_Reset = driver.findElement(By.xpath("//*[@id=\"setting\"]/ul/li[5]/a/span"));
		User_Password_Reset.click();	
		Thread.sleep(2000);
		WebElement uid = driver.findElement(By.id("uid"));
		uid.sendKeys("Test1");	
		Thread.sleep(2000);
		uid.clear();
		//Result --- It will be a text field or keypad field
	}
	
	@Test(priority = 39)
	public void TC_39_In_User_Password_Reset_Check_the_New_Password_field () 
		throws InterruptedException {
		//39.In User Password Reset - Check the  "New Password" field.
			WebElement New_Password = driver.findElement(By.id("topwd"));
			New_Password.sendKeys("Login@123");	
			Thread.sleep(2000);	
			New_Password.clear();
		//Result --- It will be a text field or keypad field
	}
	
	@Test(priority = 40)
	public void TC_40_In_User_Password_Reset_Check_the_Re_Enter_Password_field () 
		throws InterruptedException {
		//40.In User Password Reset - Check the  "Re-Enter Password " field.
		WebElement Re_Password = driver.findElement(By.id("tpwd"));
		Re_Password.sendKeys("Login@123");	
		Thread.sleep(2000);		
		Re_Password.clear();
		//Result --- It will be a text field or keypad field
	}
	
	@Test(priority = 41)
	public void TC_41_In_User_Password_Reset_Check_the_Submit_Button_to_confirm_the_entries ()
		throws InterruptedException {
		//41.In User Password Reset - Check the "Submit" Button to confirm the entries.
			WebElement uid = driver.findElement(By.id("uid"));
			uid.sendKeys("Test1");	
			Thread.sleep(2000);
			WebElement New_Password = driver.findElement(By.id("topwd"));
			New_Password.sendKeys("Login@123");	
			Thread.sleep(2000);	
			WebElement Re_Password = driver.findElement(By.id("tpwd"));
			Re_Password.sendKeys("Login@123");	
			Thread.sleep(2000);	
			WebElement sumbitbtn = driver.findElement(By.xpath("//*[@id=\"custom_card_action\"]/div/div/input[1]"));
			sumbitbtn.click();	
			Thread.sleep(5000);		
		//Result --- In User Password Reset - Check the "Reset" Button to remove the entries in all filed.
	}
	
	@Test(priority = 42)
	public void TC_42_In_User_Password_Reset_Check_the_Reset_Button_to_remove_the_entries_in_all_filed () 
		throws InterruptedException {
		//42.In User Password Reset - Check the "Reset" Button to remove the entries in all filed.
		WebElement uid = driver.findElement(By.id("uid"));
		uid.clear();
		uid.sendKeys("Test1");	
		Thread.sleep(2000);
		WebElement New_Password = driver.findElement(By.id("topwd"));
		New_Password.clear();
		New_Password.sendKeys("Login@123");	
		Thread.sleep(2000);	
		WebElement Re_Password = driver.findElement(By.id("tpwd"));
		Re_Password.clear();
		Re_Password.sendKeys("Login@123");	
		Thread.sleep(2000);	
		WebElement Resetbtn = driver.findElement(By.xpath("//*[@id=\"custom_card_action\"]/div/div/input[2]"));
		Resetbtn.click();	
		Thread.sleep(2000);		
		//Result --- It should be Clear the fileds.
	}
	
	
	
	
	
	
	@AfterSuite
	public void closebrowser() {
		driver.close();
	}
	
	
	
}
