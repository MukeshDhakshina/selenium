package h2h;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TS_007 {
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
	public void TC_01_Check_click_the_Administrator_parent_menu ()
			throws InterruptedException {		
		// _01.Check- click the "Administrator" parent menu 
			WebElement UsernameField = driver.findElement(By.id("txtUserId"));
			UsernameField.sendKeys("check");
			WebElement PasswordField = driver.findElement(By.id("txtPwd"));
			PasswordField.sendKeys("Login@123" + Keys.ENTER);
			Thread.sleep(5000);
			WebElement threedots = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/button/i"));
			threedots.click();
			Thread.sleep(5000);
		// Result --- It shows child menu - "My profile,edit profile,settings".	
	}
	
	@Test(priority = 2)
	public void TC_02_In_Approval_Click_to_verify_Authorization_child_menu () 
			throws InterruptedException {		
		// _02.In Approval- Click to verify "Authorization" child menu.
			WebElement Approval = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div/ul/li[2]/a"));
			Approval.click();
			Thread.sleep(3000);
			WebElement Authorization = driver.findElement(By.xpath("//*[@id=\"approval\"]/ul/li/a/span"));
			Authorization.click();
			Thread.sleep(3000);
		// Result --- It navigate "Authorization" page.
	}
	
	@Test(priority = 3)
	public void TC_03_In_Authorization_Check_the_Program_Name_Field () 
			throws InterruptedException {		
		// _03.In Authorization- Check the "Program Name" Field.
		WebElement program_name = driver.findElement(By.id("txtPgmId"));
		program_name.click();
		Thread.sleep(3000);
		// Result --- It should be dropdown suggession field.
	}
	
	@Test(priority = 4)
	public void TC_04_In_Authorization_Check_the_Program_Name_field_whether_it_should_allow_manual_input_or_not () 
			throws InterruptedException {		
		// _04.In Authorization- Check the "Program Name" field whether it should allow manual input or not.
		WebElement program_name = driver.findElement(By.id("txtPgmId"));
		program_name.sendKeys("abcABC123!@#efg");
		Thread.sleep(3000);
		// Result --- It should not allow manual input.
	}
	
	@Test(priority = 5)
	public void TC_05_In_Authorization_Check_the_Search_Value_field ()
			throws InterruptedException {		
		// _05.In Authorization- Check the "Search Value" field.
		WebElement Search_value = driver.findElement(By.id("searchkey"));
		Search_value.sendKeys("abcABC123!@#efg");
		Thread.sleep(3000);
		// Result --- It should be text input or keypad input.
	}
	
	@Test(priority = 6)
	public void TC_06_In_Authorization_Check_the_Entered_By_field ()
	throws InterruptedException {		
		// _06.In Authorization- Check the "Entered By" field.
		WebElement Entered_By = driver.findElement(By.id("enteredby"));
		Entered_By.sendKeys("abcABC123!@#efg");
		Thread.sleep(3000);
		// Result --- It should be text input field or keypad input.
	}
	
	
	
	
	

	@AfterSuite
	public void closebrowser() {
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
