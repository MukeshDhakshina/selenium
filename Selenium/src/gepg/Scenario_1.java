package gepg;

//import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.Select;

public class Scenario_1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver(2).exe");

		// we open the new chrome browser
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("http://192.168.3.252:8090/H2H_new/");

		//Login page - maker role

		WebElement UsernameField   = driver.findElement(By.id("txtUserId"));
		UsernameField.sendKeys("MAKER");

		WebElement PasswordField   = driver.findElement(By.id("txtPwd"));
		PasswordField.sendKeys("Login@123"+Keys.ENTER);

		
		Thread.sleep(3000);
		driver.get("http://192.168.3.252:8090/H2H_new/Payment/GepgPayment");
		
		WebElement invoiceno = driver.findElement(By.id("billno"));
		invoiceno.sendKeys("991043380283");
		
		WebElement outstanding = driver.findElement(By.id("outamountcur"));
		String Amount = outstanding.getText();
		System.out.println(Amount);

		WebElement Getbill = driver.findElement(By.xpath("//*[@id=\"tab_card\"]/div[1]/div[1]/div[1]/div[3]/button"));
		Getbill.click();
		
		WebElement Invoicedate = driver.findElement(By.id("outamountcur"));
		String date = Invoicedate.getText();
		System.out.println(date);
		 
		Thread.sleep(3000);
		
		
	}

}
