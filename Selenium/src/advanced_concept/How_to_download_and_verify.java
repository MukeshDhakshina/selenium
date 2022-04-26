package advanced_concept;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.remote.server.handler.FindElement;


public class How_to_download_and_verify {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Chromedriver\\chromedriver(9.6).exe");

		// we open the new Chrome browser
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("http://leafground.com/pages/download.html");
		
		File fileLocations = new File("E:\\HDsoft\\MANUAL TESTING\\GEPG\\GEPG Testing Scenario.xlsx");
		
		WebElement select = driver.findElement(By.xpath(""));
		
		select.click();
		
		File[] Totalfile = fileLocations.listFiles();
		
		for (File file : Totalfile) {
			
			     if (file.getName().equals("GEPG Testing Scenario.xlsx")) {
			    	 System.out.println("correct file");
					break;
				} else {
			    	 System.out.println("Wrong file");
				}
			
		}
		
		
	}

}
