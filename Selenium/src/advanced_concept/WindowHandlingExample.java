package advanced_concept;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandlingExample {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub


		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver(2).exe");

		// we open the new Chrome browser
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("http://leafground.com/pages/Window.html");
		
		//1.switch to new window

		WebElement oldwindow = driver.findElement(By.id("home"));
		oldwindow.click();

		String oldWindow = driver.getWindowHandle();

		Set<String> handles = driver.getWindowHandles();

		for (String newwindow : handles) {

			driver.switchTo().window(newwindow);
		}

		WebElement editlink = driver.findElement(By.xpath("//*[@id=\'post-153\']/div[2]/div/ul/li[1]/a"));
		editlink.click();

		driver.close();

		driver.switchTo().window(oldWindow);
		
		//2.Find the Number of windows opened

		WebElement multiplewindow = driver.findElement(By.xpath("//*[@id=\'contentblock\']/section/div[2]/div/div/button"));
		multiplewindow.click();
		
		int NumberofWindow = driver.getWindowHandles().size();
		System.out.println("Overall windows opened "+NumberofWindow);
		
		//3.close all Except this window
		
		WebElement dontcloseme = driver.findElement(By.id("color"));
		dontcloseme.click();
		
		Set<String> newhandles = driver.getWindowHandles();
	
		for (String smallwindow : newhandles) {
			
			if (!smallwindow.equals(oldWindow)) {
				driver.switchTo().window(smallwindow);
				Thread.sleep(2000);
				driver.close();
				
			}
			
		}
		
		
			
		}
		
		
	}





