package basic_concept;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Open_firefox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		System.setProperty("webdriver.gecko.driver", "D:\\Selenium\\geckodriver.exe");

		WebDriver driver = new FirefoxDriver();

		driver.get("http://192.168.3.251:8090/Portal/HDPAY/login");

		//driver.manage().window().maximize();

		driver.findElement(By.name("uname")).sendKeys("ADMIN");
		driver.findElement(By.name("psw")).sendKeys("Login@123"+Keys.ENTER);




		
	}

}
