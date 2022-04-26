package basic_concept;



import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ButtonExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("http://leafground.com/pages/Button.html");
		
	 //1.click the button
		//WebElement clickbutton = driver.findElement(By.xpath("/html/body/div/div/div[3]/section/div[1]/div/div/button"));
		//clickbutton.click();
		
	//2.Get the XY position
		WebElement getbuttonposition = driver.findElement(By.id("position"));
		Point xypoint = getbuttonposition.getLocation();
		int xValue=xypoint.getX();
		int yValue=xypoint.getY();
		System.out.println("value of x :"+ xValue+ "value of y :" + yValue);
		
	//3.Get the colour of Button
		//WebElement getcolor = driver.findElement(By.id("color"));
		//String color =getcolor.getCssValue("background-color");
		//System.out.println("Color of the button : "+color);
		
	//4.Get the Height and width of the button
		WebElement getHandW = driver.findElement(By.id("size"));
		int buttonHeight=getHandW.getSize().getHeight();
		int buttonwidth=getHandW.getSize().getWidth();
		
		System.out.println("Height: "+buttonHeight+"Width: "+buttonwidth);
		
	
		
	}

}
