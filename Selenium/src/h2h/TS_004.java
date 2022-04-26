package h2h;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TS_004 {
	WebDriver driver;
	

	@BeforeSuite
	public void OpenBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Chromedriver\\chromedriver(9.6).exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://192.168.3.252:8090/H2H_new/");
		Thread.sleep(2000);
	}

	@Test(priority = 1)
	public void TC_01_Check_click_the_Profile_parent_menu ()
		throws InterruptedException {
		//1.Check- click the "Profile" parent menu 
		WebElement UsernameField = driver.findElement(By.id("txtUserId"));
		UsernameField.sendKeys("ADMIN002");
		WebElement PasswordField = driver.findElement(By.id("txtPwd"));
		PasswordField.sendKeys("Login@123" + Keys.ENTER);
		Thread.sleep(5000);
		WebElement threedots = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/button/i"));
		threedots.click();
		Thread.sleep(5000);
		//Result --- It shows child menu -                                     
										//-Profile image upload,                                      
										//-Reset Password.                          
	}

	@Test(priority = 2)
	public void TC_02_Check_click_the_Profile_image_upload_child_menu ()
		throws InterruptedException {
		//2.Check- click the Profile image upload child menu 
		WebElement PIU = driver.findElement(By.xpath("//*[@id=\"profile\"]/ul/li[1]/a/span"));
		PIU.click();
		Thread.sleep(3000);
		//Result --- It should navigate  to "Profile image upload" page
	}

	@Test(priority = 3)
	public void TC_03_In_Profile_image_upload_check_the_Upload_photo_field () {
		//3.In Profile image upload- check the Upload photo field
		WebElement fileInput = driver.findElement(By.id("inputGroupFile01"));     //PNG image
		fileInput.sendKeys("C:\\Users\\HD SOFT\\Pictures\\avatar (M2).png");
		//Result --- It will be a file input or browse field
	}

	@Test(priority = 4)
	public void TC_04_In_Profile_image_upload_Check_the_Submit_Button_to_confirm_the_entries () 
		throws InterruptedException {  
		//4.In Profile image upload- Check the Submit Button to confirm the entries.
		WebElement submitbtn = driver.findElement(By.xpath("//*[@id=\"colour_body\"]/div[2]/div/div[1]/button"));
		submitbtn.click();
		Thread.sleep(3000);
		//Result --- It should be change the admin profile photo picture.
	}

	@Test(priority = 5)
	public void TC_05_In_Profile_image_upload_Check_the_Cancel_Button_to_remove_the_entries_in_all_fileds () 
		throws InterruptedException {
		//5.In Profile image upload- Check the "Cancel" Button to remove the entries in all fileds.
		WebElement JPGfile = driver.findElement(By.id("inputGroupFile01"));          //JPG Type of file
		JPGfile.sendKeys("C:\\Users\\HD SOFT\\Pictures\\JPG,JPEG,PNG\\JPG.jpg");    
		Thread.sleep(2000);
		WebElement Resetbtn = driver.findElement(By.xpath("//*[@id=\"colour_body\"]/div[2]/div/div[2]/button"));
		Resetbtn.click();
		//Result --- It should be cancel the admin profile photo
	}

	@Test (priority = 6)
	public void TC_06_In_Reset_Password_Check_the_New_Password_field ()
		throws InterruptedException {
		//6.In Reset Password- Check the "New Password" field.
		WebElement threedots = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/button/i"));
		threedots.click();
		Thread.sleep(3000);   
		WebElement Resetpass = driver.findElement(By.xpath("//*[@id=\"profile\"]/ul/li[2]/a/span"));
		Resetpass.click();
		Thread.sleep(3000);   
		WebElement newpass = driver.findElement(By.id("topwd"));
		newpass.sendKeys("Login@123");
		Thread.sleep(2000);
		WebElement toggle = driver.findElement(By.id("toggle"));
		toggle.click();
		Thread.sleep(2000);
		//Result --- It will be a text field or keypad field
	}
	
	@Test(priority = 7)
	public void TC_07_In_Reset_Password_Check_the_Re_Enter_Password_field ()
		throws InterruptedException {
		//7.In Reset Password- Check the "Re-Enter Password" field.
		WebElement Re_pass = driver.findElement(By.id("tpwd"));
		Re_pass.sendKeys("Login@123");
		Thread.sleep(2000);
		WebElement toggle1 = driver.findElement(By.id("toggle1"));
		toggle1.click();
		Thread.sleep(2000);
		//Result --- It will be a text field or keypad field
	}
	
	@Test (priority = 8)
	public void TC_08_In_Reset_Password_Check_the_Submit_Button_to_confirm_the_entries () { 
		//8.In Reset Password-- Check the "Submit"Button to confirm the entries.
		WebElement submit = driver.findElement(By.xpath("//*[@id=\"custom_card_action\"]/div/div/input[1]"));
		submit.click();
		//Result --- It should be change the New password.
	}

	@Test (priority = 9)
	public void TC_09_In_Reset_Password_Check_the_Clear_Button () 
		throws InterruptedException {
		//9.In Reset Password-- Check the "Clear" Button 
		WebElement newpass = driver.findElement(By.id("topwd"));
		newpass.sendKeys("Login@123");
		Thread.sleep(2000);
		WebElement Re_pass = driver.findElement(By.id("tpwd"));
		Re_pass.sendKeys("Login@123");
		Thread.sleep(2000);
		WebElement Reset = driver.findElement(By.xpath("//*[@id=\"custom_card_action\"]/div/div/input[2]"));
		Reset.click();
		//Result --- It will to remove the entries in the all input field.
	}


	@AfterSuite
	public void closebrowser() {
		driver.close();
	}





}
