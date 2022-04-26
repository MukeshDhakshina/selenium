package basic_concept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TextBoxExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("http://leafground.com/pages/Edit.html");
		
		driver.findElement(By.id("email")).sendKeys("Mukesh@hdsoftwaresystems.com");
		
		driver.findElement(By.xpath("/html/body/div/div/div[3]/section/div[2]/div/div/input")).sendKeys("Mukesh");
		
		//WebElement Gettext= driver.findElement(By.name("username"));
		//String value= Gettext.getAttribute("value");
		
		String value =driver.findElement(By.name("username")).getAttribute("value");
		System.out.println(value);
		
		driver.findElement(By.xpath("/html/body/div/div/div[3]/section/div[4]/div/div/input")).clear();
	}

}
