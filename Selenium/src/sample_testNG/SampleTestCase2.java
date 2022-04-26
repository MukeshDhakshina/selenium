package sample_testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class SampleTestCase2 {

	WebDriver driver;
	long StartTime;
	long EndTime ;

	@BeforeSuite
	public void OpenBrowser() {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver(2).exe");
		driver = new ChromeDriver();
	}

	@Test(priority=0)
	public void openbing() {
		StartTime = System.currentTimeMillis();
		driver.get("https://www.bing.com");
	}

	@Test(priority=1)
	public void google() {
		driver.get("https://www.google.co.in");
	}

	@Test(priority=2)
	public void h2h_without_vpn() {
		driver.get("http://192.168.3.252:8090/H2H_new/");
	}

	@AfterSuite
	public void closebrowser() {
		driver.quit();
		EndTime = System.currentTimeMillis();
	    long TotalTime =  EndTime-StartTime ;
		System.out.println("Total duration is "+TotalTime);
	}

}
