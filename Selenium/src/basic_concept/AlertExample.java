package basic_concept;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertExample {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("http://leafground.com/pages/Alert.html");
		
		//1.Normal Alert 
		WebElement alertbutton = driver.findElement(By.xpath("//*[@id=\'contentblock\']/section/div[1]/div/div/button"));
		
		alertbutton.click();
	
		Alert alertbox = driver.switchTo().alert();
		 
		alertbox.accept();
		
		//2.ConfirmButton Alert

		WebElement confirmbutton = driver.findElement(By.xpath("//*[@id=\'contentblock\']/section/div[2]/div/div/button"));
		
		confirmbutton.click();
		
		Alert confirmbuttoAlert = driver.switchTo().alert();
		
		confirmbuttoAlert.dismiss();
		
		//3.PromptButton Alert
		
		WebElement promptbutton = driver.findElement(By.xpath("//*[@id=\'contentblock\']/section/div[3]/div/div/button"));
		
		promptbutton.click();
		
		Alert promptboxbutton = driver.switchTo().alert();
		
		promptboxbutton.sendKeys("Mukesh");
		
		promptboxbutton.accept();

	}

}
