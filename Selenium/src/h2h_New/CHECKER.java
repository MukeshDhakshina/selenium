package h2h_New;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;



								//Before Run this File

								// * submit a gepg payment to receipt print     --- TS_Checker-Reports_15
								// * submit a record for authorize the record   --- TS_Checker-Approval_06			


public class CHECKER {
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
	
	@Test(priority = 0)
	public void Url_HealthTest() {
		System.out.println("TS_001 has been start");
		driver.get(H2H_url);
		try {
		} catch (Exception e) {
			System.out.println("FAIL CASE - URL Health Test " + e);
		}
	}
	 
								//TS_Checker_Reports_01 ----------- Removed from H2H
	
	 
	@Test(priority = 2)
	public void TS_Checker_Reports_02_Check_click_the_Administrator_parent_menu()
		throws InterruptedException {
		//TS_Checker-Reports_02.""In Reset Password- Check the ""Re-Enter Password"" field."
			WebElement UsernameField = driver.findElement(By.id("txtUserId"));
			UsernameField.sendKeys("siva003");
			WebElement PasswordField = driver.findElement(By.id("txtPwd"));
			PasswordField.sendKeys("Login@123");
			Thread.sleep(9000);
			PasswordField.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			WebElement threedots = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/button/i"));
			threedots.click();
			Thread.sleep(3000);
			WebElement reports = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div/ul/li[5]/a"));
			reports.click();
			Thread.sleep(3000);
		//Result --"It shows child menu - ""My profile,edit profile,settings""."       

	}
	
	@Test(priority = 3)
	public void TS_Checker_Reports_03_In_Reports_click_the_Receipt_invoice_Print_child_menu ()   
		throws InterruptedException {
		//TS_Checker-Reports_03."In Reports- click the ""Receipt invoice Print"" child menu."
			WebElement RIP = driver.findElement(By.xpath("//*[@id=\"rpt\"]/ul/li[1]/a"));
			RIP.click();
			Thread.sleep(3000);
		//Result --"It navigate ""Receipt invoice Print"" page"

	}
	
	@Test(priority = 4)
	public void TS_Checker_Reports_04_In_Receipt_invoice_Print_check_the_Invoice_Reciept_for_field()   
		throws InterruptedException {
		//TS_Checker-Reports_04."In Receipt invoice Print- check the ""Invoice Reciept for"" field"
			WebElement DP_field = driver.findElement(By.id("inrecfor"));
			DP_field.click();
			Thread.sleep(3000);
		//Result --"It will be a dropdown field"

	}
	
	
	@Test(priority = 5)
	public void TS_Checker_Reports_05_In_Receipt_invoice_Print_check_the_Invoice_Recipt_for_field_are_allow_manual_input_or_not()   
		throws InterruptedException {
		//TS_Checker-Reports_05."In Receipt invoice Print- check the ""Invoice Recipt for"" field are allow manual input or not."
			WebElement DP_field = driver.findElement(By.id("inrecfor"));
			DP_field.click();
			Thread.sleep(3000);
		//Result --It should not allow the manual input

	}
	
	@Test(priority = 6)
	public void TS_Checker_Reports_06_In_Receipt_invoice_Print_check_the_Customer_group_field() 
		throws InterruptedException {
		//TS_Checker-Reports_06."In Receipt invoice Print- check the ""Customer group"" field."() 
			WebElement customer_group = driver.findElement(By.id("custgroup"));
			customer_group.sendKeys("ABCDabcd123!@#");
			Thread.sleep(5000);
			customer_group.clear();
		//Result --It should be a text or keypad field.

	}
	
	@Test(priority = 7)
	public void TS_Checker_Reports_07_In_Receipt_invoice_Print_check__the_Invoice_Number_field() 
		throws InterruptedException {
		//TS_Checker-Reports_07."In Receipt invoice Print- check the ""Invoice Number"" field."() 
			WebElement Invoice_no = driver.findElement(By.id("invno"));
			Invoice_no.sendKeys("1234567890");
			Thread.sleep(5000);
			Invoice_no.clear();
		//Result --"It should be a number field and it should not allow any other text."

	}
		
	@Test(priority = 8)
	public void TS_Checker_Reports_08_In_Receipt_invoice_Print_check_the_Invoice_Date_field_whether_it_should_allow_manual_input_or_not() 
		throws InterruptedException {
		//TS_Checker-Reports_08."In Receipt invoice Print- check the ""Invoice Date"" field whether it should allow manual input or not." 
			WebElement invoice_date =  driver.findElement(By.id("invdate"));			//Current Date     
			// Create object of SimpleDateFormat class and decide the format
			 DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			 
			 //get current date time with Date()
			 Date date = new Date(); 										// passing System current date (dd/MM/yyyy)
			 
			 // Now format the date
			 String date1= dateFormat.format(date);
			 
			invoice_date.sendKeys(date1);   
			Thread.sleep(1000);
			invoice_date.clear();
		//Result --"It should be a number field and it should not allow any other text."

	}
	
	@Test(priority = 9)
	public void TS_Checker_Reports_09_In_Receipt_invoice_Print_check_the_Invoice_Date_field_whether_it_should_allow_manual_input_or_not() 
		throws InterruptedException {
		//TS_Checker-Reports_09."In Receipt invoice Print- check the ""Invoice Date"" field whether it should allow manual input or not." 
			WebElement invoice_date = driver.findElement(By.id("invdate"));
			invoice_date.sendKeys("abcdef");
			Thread.sleep(5000);
			invoice_date.clear();
		//Result --"It should be a number field and it should not allow any other text."

	}
	
	 									              //TS_Checker_Reports_10 ------ future date check should be manual test
													  //TS_Checker_Reports_11 ------ future date check should be manual test
	
	@Test(priority = 12)
	public void TS_Checker_Reports_12_In_Receipt_invoice_Print_Check_the_Pay_serial_field() 
		throws InterruptedException {
		//TS_Checker-Reports_12.""In Receipt invoice Print- Check the ""Pay serial"" field ."
			WebElement pay_srl = driver.findElement(By.id("paysral"));
			pay_srl.sendKeys("Editable field");
			Thread.sleep(3000);
			pay_srl.clear();
			Thread.sleep(3000);
		//Result --"It should be text input or keypad input."

	}
	
	@Test(priority = 13)
	public void TS_Checker_Reports_13_In_Receipt_invoice_Print_Check_the_Duplicate_field() 
		throws InterruptedException {
		//TS_Checker-Reports_13."In Receipt invoice Print- Check the ""Duplicate"" field ."
			WebElement check_box = driver.findElement(By.id("dup"));
			check_box.click();
			Thread.sleep(3000);
		//Result --"It should be check box field."

	}
	
	@Test(priority = 14)
	public void TS_Checker_Reports_14_In_Receipt_invoice_Print_Check_the_Duplicate_field_whether_it_allow_to_click_or_not() 
		throws InterruptedException {
		//TS_Checker-Reports_14."In Receipt invoice Print- Check the ""Duplicate"" field whether it allow to click or not."
			WebElement check_box = driver.findElement(By.id("dup"));
			check_box.click();
			Thread.sleep(3000);
			WebElement Reset_Tab = driver.findElement(By.id("reset"));
			Reset_Tab.click();
			Thread.sleep(3000);
		//Result --It should be allow to check or click.
	}
	
	@Test(priority = 15)
	public void TS_Checker_Reports_15_In_Receipt_invoice_Print_Check_the_Print_Button() 
		throws InterruptedException {
		//TS_Checker-Reports_15."In Receipt invoice Print- Check the ""Print"" Button."
			WebElement DP_field = driver.findElement(By.id("inrecfor"));
			Select selectDD = new Select (DP_field);
			selectDD.selectByVisibleText("GEPGPAY");      //GEPGPAY
			Thread.sleep(2000);    
			WebElement customer_group = driver.findElement(By.id("custgroup"));
			customer_group.sendKeys("GEPGPAY");
			Thread.sleep(3000);
			WebElement Invoice_no = driver.findElement(By.id("invno"));
			Invoice_no.sendKeys("991900002503");
			Thread.sleep(3000);
			Invoice_no.sendKeys(Keys.TAB);
			Thread.sleep(3000); 
			WebElement print_btn = driver.findElement(By.id("print"));
			print_btn.click();
			Thread.sleep(10000);
		//Result --It should download the receipt invoice in our system by pdf 

	}
	
	@Test(priority = 16)
	public void TS_Checker_Reports_16_In_Receipt_invoice_Print_Check_the_Reset_Button() 
		throws InterruptedException {
		//TS_Checker-Reports_16."In Receipt invoice Print- Check the ""Reset"" Button."
			WebElement reset_btn = driver.findElement(By.id("reset"));
			reset_btn.click();
			Thread.sleep(3000);
		//Result --It should download the receipt invoice in our system by pdf 

	}
	
	@Test(priority = 17)
	public void TS_Checker_Reports_17_In_Reports_click_the_Invoice_Payment_Status_field() 
		throws InterruptedException {
		//TS_Checker-Reports_17."In Reports- click the ""Invoice Payment Status"" field."
			WebElement threedots = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/button/i"));
			threedots.click();
			Thread.sleep(3000);
			WebElement IPS = driver.findElement(By.xpath("//*[@id=\"rpt\"]/ul/li[2]/a/span"));
			IPS.click();
			Thread.sleep(3000);
		//Result --"It navigate ""Invoice Payment Status"" page"

	}
	
	@Test(priority = 18)
	public void TS_Checker_Reports_18_In_Invoice_Payment_Status_check_the_Invoice_Payment_Status_field() 
		throws InterruptedException {
		//TS_Checker-Reports_18."In Invoice Payment Status- check the ""Invoice Payment Status"" field."
			WebElement Dp_field = driver.findElement(By.id("s1"));
			Dp_field.click();
			Thread.sleep(3000);
		//Result --"It should be a dropdown suggestion fields."

	}
	
	@Test(priority = 19)
	public void TS_Checker_Reports_19_In_Invoice_Payment_Status_check_the_Invoice_Payment_Status_field() 
		throws InterruptedException {
		//TS_Checker-Reports_19."In Invoice Payment Status- check the ""Invoice Payment Status"" field."
			WebElement Dp_field = driver.findElement(By.id("s1"));
			Dp_field.click();
			Thread.sleep(3000);
		//Result --"It should not allow the manual input"

	}
	
	@Test(priority = 20)
	public void TS_Checker_Reports_20_In_Invoice_Payment_Status_check_the_Invoice_Type_field() 
		throws InterruptedException {
		//TS_Checker-Reports_20."In Invoice Payment Status- check the ""Invoice Type"" field."
			WebElement Invoice_type = driver.findElement(By.id("s2"));
			Invoice_type.click();
			Thread.sleep(3000);
		//Result --"It should be a dropdown suggestion fields."

	}
	
	@Test(priority = 21)
	public void TS_Checker_Reports_21_In_Invoice_Payment_Status_check_the_Invoice_Type_field() 
		throws InterruptedException {
		//TS_Checker-Reports_21."In Invoice Payment Status- check the ""Invoice Type"" field."
			WebElement Invoice_type = driver.findElement(By.id("s2"));
			Invoice_type.click();
			Thread.sleep(3000);
		//Result --"It should not allow the manual input"

	}
	
	@Test(priority = 22)
	public void TS_Checker_Reports_22_In_Invoice_Payment_Status_click_the_From_Date_field_whether_it_should_allow_manual_input_or_not() 
		throws InterruptedException {
		//TS_Checker-Reports_22."In Invoice Payment Status- click the ""From Date"" field whether it should allow manual input or not."
			WebElement From_date = driver.findElement(By.id("d1"));
			From_date.click();
			Thread.sleep(3000);
		//Result --"It should be allow manual input through keyboard."

	}
	
	
	
															 	//TS_Checker_Reports_23 ------ future date check should be manual test
																//TS_Checker_Reports_24 ------ future date check should be manual test
	
	
	@Test(priority = 25)
	public void TS_Checker_Reports_25_In_Invoice_Payment_Status_check_the_To_Date_field_whether_it_should_allow_manual_input_or_not() 
		throws InterruptedException {
		//TS_Checker-Reports_25."In Invoice Payment Status- check the ""To Date"" field whether it should allow manual input or not."
			WebElement To_date = driver.findElement(By.id("d2"));
			To_date.click();
			Thread.sleep(3000);
		//Result --"It should be allow manual input through keyboard ."

	}
	
																//TS_Checker_Reports_26 ------ future date check should be manual test
																//TS_Checker_Reports_27 ------ future date check should be manual test
	
	
	
	@Test(priority = 28)
	public void TS_Checker_Reports_28_In_Invoice_Payment_Status_Check_the_Get_Bill_Detail_button() 
		throws InterruptedException {
		//TS_Checker-Reports_28."In Invoice Payment Status- Check the ""Get Bill Details"" button."
			WebElement IPS = driver.findElement(By.id("s1"));
			Select selectDD = new Select (IPS);
			selectDD.selectByVisibleText("Success");
			Thread.sleep(3000);
			WebElement IT = driver.findElement(By.id("s2"));
			Select selectDD1 = new Select (IT);
			selectDD1.selectByVisibleText("GEPGPAY");
			Thread.sleep(3000);
			WebElement From_Date = driver.findElement(By.id("d1"));
			From_Date.sendKeys("01022022");
			// Create object of SimpleDateFormat class and decide the format
			
			Thread.sleep(3000);
			WebElement To_Date = driver.findElement(By.id("d2"));
			// Create object of SimpleDateFormat class and decide the format
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			 
			 //get current date time with Date()
			 Date date = new Date(); 										
			 // passing System current date (dd/MM/yyyy)
			 
			 // Now format the date
			 String current_date= dateFormat.format(date);
			To_Date.sendKeys(current_date);
			Thread.sleep(3000);
			WebElement GBD = driver.findElement(By.id("getBill"));
			GBD.click();
			Thread.sleep(7000);
			WebElement IPS1 = driver.findElement(By.id("s1"));
			Select selectDD2 = new Select (IPS1);
			selectDD2.selectByVisibleText("Reject");
			Thread.sleep(3000);
			GBD.click();
			Thread.sleep(7000);
			WebElement IPS2 = driver.findElement(By.id("s1"));
			Select selectDD3 = new Select (IPS2);
			selectDD3.selectByVisibleText("Pending");
			Thread.sleep(3000);
			GBD.click();
			Thread.sleep(5000);
		//Result --"It should be allow manual input through keyboard ."

	}
	
	
	@Test(priority = 29)
	public void TS_Checker_Reports_29_In_Invoice_Payment_Status_Check_the_Reset_button() 
		throws InterruptedException {
		//TS_Checker-Reports_29."In Invoice Payment Status- Check the ""Reset"" button."
			WebElement Reset = driver.findElement(By.xpath("//*[@id=\"tab_card\"]/div[3]/div/div/div[2]/div/input"));
			Reset.click();
			Thread.sleep(3000);
		//Result --It should clear all the above fields

	}
	
	         
									//TS_Checker_Reports_30 ------ Wrong scenario need to change sceanrio
	
	
	@Test(priority = 31)
	public void TS_Checker_Reports_31_In_Invoice_Payment_Status_Check_the_Download_button() 
		throws InterruptedException ,AWTException  {
		//TS_Checker-Reports_31."In Invoice Payment Status- Check the ""Download"" button."
			WebElement IPS = driver.findElement(By.id("s1"));
			Select selectDD = new Select (IPS);
			selectDD.selectByVisibleText("Success");
			Thread.sleep(3000);
			WebElement IT = driver.findElement(By.id("s2"));
			Select selectDD1 = new Select (IT);
			selectDD1.selectByVisibleText("GEPGPAY");
			Thread.sleep(3000);
			WebElement From_Date = driver.findElement(By.id("d1"));
			From_Date.sendKeys("01112021");
			Thread.sleep(3000);
			WebElement To_Date = driver.findElement(By.id("d2"));
			To_Date.sendKeys("03022022");
			Thread.sleep(3000);
			WebElement GBD = driver.findElement(By.id("getBill"));
			GBD.click();
			Thread.sleep(5000);
			WebElement EXCEL_btn = driver.findElement(By.xpath("//*[@id=\"example_wrapper\"]/div[1]/div[2]/div/a[1]"));
			EXCEL_btn.click();
			Thread.sleep(3000);
			WebElement PDF_btn = driver.findElement(By.xpath("//*[@id=\"example_wrapper\"]/div[1]/div[2]/div/a[2]"));
			PDF_btn.click();
			Thread.sleep(3000);
			WebElement CSV_btn = driver.findElement(By.xpath("//*[@id=\"example_wrapper\"]/div[1]/div[2]/div/a[3]"));
			CSV_btn.click();
			Thread.sleep(3000);
			WebElement Print_btn = driver.findElement(By.xpath("//*[@id=\"example_wrapper\"]/div[1]/div[2]/div/a[4]"));
			Print_btn.click();
			Thread.sleep(3000);
			//close the TabS
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_ESCAPE);
			r.keyRelease(KeyEvent.VK_ESCAPE);		
			Thread.sleep(5000);
		//Result --It should preview the status of Invoice in table by below order Success,Reject and Pending

	}
	
	
	
	/*
	 * @Test(priority = 32) public void
	 * TS_Checker_Reports_32_In_Reports_Click_the_Report_Generation_child_menu()
	 * throws InterruptedException { //TS_Checker-
	 * Reports_32."In Reports- Click the ""Report Generation"" child menu."
	 * WebElement threedots =
	 * driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/button/i"));
	 * threedots.click(); Thread.sleep(3000); WebElement Report_generator =
	 * driver.findElement(By.xpath("//*[@id=\"rpt\"]/ul/li[3]/a"));
	 * Report_generator.click(); Thread.sleep(3000); //Result
	 * --"It navigate to ""Report Generation"" page"
	 * 
	 * }
	 * 
	 * @Test(priority = 33) public void
	 * TS_Checker_Reports_33_In_Report_Generation_Check_the_Report_Name_Field()
	 * throws InterruptedException { //TS_Checker-
	 * Reports_33."In Report Generation- Check the ""Report Name"" Field."
	 * WebElement select_DD =
	 * driver.findElement(By.xpath("//*[@id=\"tab_card\"]/div/div[2]/div/select"));
	 * select_DD.click(); Thread.sleep(3000); WebElement Report_generator =
	 * driver.findElement(By.xpath("//*[@id=\"rpt\"]/ul/li[3]/a"));
	 * Report_generator.click(); Thread.sleep(3000); //Result --It should be
	 * dropdown field.
	 * 
	 * }
	 */
	
	
								//  TS_Checker-Reports_32 ------ old frame scenario need to change the scenario
								//  TS_Checker-Reports_33 ------ old frame scenario need to change the scenario
								//  TS_Checker-Reports_34 ------ old frame scenario need to change the scenario		
								//  TS_Checker-Reports_35 ------ Dashboard design scenarios
	
	
	
	@Test(priority = 36) 
	public void TS_Checker_Approval_02_In_Approval_Click_to_verify_Authorization_child_menu()
	  throws InterruptedException { 
		//TS_Checker_Reports_02.In Approval- Click to verify "Authorization" child menu.
		  WebElement threedots = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/button/i"));
		  threedots.click(); 
		  Thread.sleep(3000); 
		  WebElement Approval_parent = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div/ul/li[3]/a"));
		  Approval_parent.click(); 
		  Thread.sleep(3000); 
	  //Result--It navigate "Authorization" page.
	
	}
	
	@Test(priority = 37) 
	public void TS_Checker_Approval_03_In_Authorization_Check_the_Program_Name_Field()
	  throws InterruptedException { 
		//TS_Checker_Reports_03.In Authorization- Check the "Program Name" Field.
		  WebElement Authorization = driver.findElement(By.id("approval"));
		  Authorization.click(); 
		  Thread.sleep(3000);
	  //Result--It should be dropdown suggession field.
	
	}
	
	
	@Test(priority = 38) 
	public void TS_Checker_Approval_04_In_Authorization_Check_the_Program_Name_field_whether_it_should_allow_manual_input_or_not()
	  throws InterruptedException { 
		//TS_Checker_Reports_04.In Authorization- Check the "Program Name" field whether it should allow manual input or not.
		  WebElement program_name = driver.findElement(By.id("txtPgmId"));
		  program_name.click(); 
		  Thread.sleep(3000); 
	  //Result--It should not allow manual input.
	
	}
	
	@Test(priority = 39)
	public void TS_Checker_Approval_05_In_Approval_check_the_Search_Value_field()
		throws InterruptedException {
		//TS_Checker-Approval_05.In Approval- check the "Search  Value"  field 
			WebElement searchvalue = driver.findElement(By.id("searchkey"));
			searchvalue.sendKeys("Editable field"); //sendKeys("ABCDEFG");
			Thread.sleep(3000);
			searchvalue.clear();
			Thread.sleep(3000);
		//Result --- It will be a text field or keypad field
	}
	
	@Test(priority = 40)
	public void TS_Checker_Approval_06_In_Approval_check_the_Entered_by_field()
		throws InterruptedException{
		//TS_Checker-Approval_06.In Approval- check the "Entered by" field
			WebElement searchvalue = driver.findElement(By.id("searchkey"));
			searchvalue.sendKeys("ABCDabcd123!@#"); //sendKeys("ABCDEFG");
			Thread.sleep(3000);
			WebElement Enteredby = driver.findElement(By.id("enteredby"));
			Enteredby.sendKeys("ABCDabcd123!@#");
			Thread.sleep(3000); 
			Enteredby.clear();
			Thread.sleep(3000);
			searchvalue.clear();
			Thread.sleep(3000);
			WebElement Gepgpay = driver.findElement(By.id("txtPgmId")); 		
			Select selectDD = new Select (Gepgpay);
			selectDD.selectByVisibleText("GePG Payment");
			Thread.sleep(2000);
			WebElement invoice_search = driver.findElement(By.id("searchkey"));
			invoice_search.sendKeys("991900002503"); 
			Thread.sleep(3000);
			WebElement checkbox = driver.findElement(By.xpath("//*[@id=\"example\"]/tbody/tr[1]/td[1]"));
			checkbox.click();
			Thread.sleep(3000);
			WebElement Authorize = driver.findElement(By.id("auth"));
			Authorize.click();
			Thread.sleep(3000);
			WebElement Yesbtn = driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/button[1]"));
			Yesbtn.click();
			Thread.sleep(2000);
		//Result --- It will be a text field or keypad field
	}
	
	
	
	
	
	
	
	
	
	@AfterSuite
	public void closebrowser() {        
	 	driver.close();
	}
	
	
	
}
