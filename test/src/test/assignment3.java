package test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class assignment3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();	
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		//driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS));
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
	
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("learning");
		driver.findElement(By.xpath("//input[@value='user']")).click();
		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='modal-footer justify-content-center']/button[@id='okayBtn']")));
		driver.findElement(By.xpath("//div[@class='modal-footer justify-content-center']/button[@id='okayBtn']")).click();
		WebElement option = driver.findElement(By.xpath("//select[@data-style='btn-info']"));
		
		Select s = new Select(option);
		s.selectByVisibleText("Consultant");
		driver.findElement(By.cssSelector("input[id='terms']")).click();
		driver.findElement(By.id("signInBtn")).click();
		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("h4[class='card-title']")));
		
		List<WebElement> products= driver.findElements(By.cssSelector("h4[class='card-title']"));
		
		for(int i=0; i<products.size(); i++)
		{
			
			driver.findElements(By.cssSelector("button[class*='btn-info']")).get(i).click();
			
			
			
			
		}
		
		driver.findElement(By.xpath("//a[contains(text(),'Checkout')]")).click();
		
		
		

	}

}
