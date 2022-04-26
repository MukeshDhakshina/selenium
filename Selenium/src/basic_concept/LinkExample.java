package basic_concept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();


		driver.get("http://leafground.com/pages/Link.html");

		driver.findElement(By.partialLinkText("Home Page")).click();
		
		//driver.findElement(By.linkText("Go to Home Page"));
		
		

	}

}
