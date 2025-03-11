package test;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.decorators.WebDriverDecorator;

public class testclass {

	public static void main(String[] args) {
		
		//Invoking Browser
		//System.setProperty("webdriver.chrome.driver", "/Users/asus/Documents/chrome/chromedriver-win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		
		//Firefox driver
		//WebDriver driver = new FirefoxDriver();
		
		//Edge driver
		//		WebDriver driver = new EdgeDriver();
		
		driver.get("https://rahulshettyacademy.com");
		
	}

}
