package sample_notes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ResultExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver(2).exe");

		// we open the new Chrome browser
		WebDriver driver = new ChromeDriver();
		
		String baseUrl = "http://leafground.com/pages/Alert.html";
        String expectedTitle = "TestLeaf - Interact with Alerts";
        String actualTitle = "";
		
        
        driver.manage().window().maximize();
        
        driver.get(baseUrl);
        
        actualTitle = driver.getTitle();
        
        
        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("1.Test Passed");
        } else {
            System.out.println("1.Test Failed(X)");
        }
       
        driver.close();
        
	}

}
