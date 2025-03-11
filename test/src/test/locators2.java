package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;



//import dev.failsafe.internal.util.Assert;

public class locators2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		String name ="Jansi";
		WebDriver driver = new ChromeDriver();	
		//Firefox driver
		//		WebDriver driver = new FirefoxDriver();
		
		//WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String password = getpassword(driver);
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		driver.findElement(By.name("inputPassword")).sendKeys(password);
		driver.findElement(By.className("signInBtn")).click();
		Thread.sleep(1000);
	//	driver.findElement(By.tagName("p")).getText();
	Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
	//driver.findElement(By.cssSelector(div[class=login-container] h2))
	Assert.assertEquals(driver.findElement(By.cssSelector("div[class=login-container] h2")).getText(), "Hello "+name+",");
	driver.findElement(By.xpath("//*[text()='Log Out']")).click();
	driver.close();


	}
	
	
	
	public static String getpassword(WebDriver driver) throws InterruptedException
	{
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@class='reset-pwd-btn']")).click();
		
		String passwordText = driver.findElement(By.xpath("//p[@class='infoMsg']")).getText();
		String[] passwordArray = passwordText.split("'");
		String passwordArray2 = passwordArray[1].split("'")[0];
		return passwordArray2;
		
		
		
	}

}
