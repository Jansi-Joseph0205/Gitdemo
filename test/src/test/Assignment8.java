package test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Assignment8 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();	
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.id("autocomplete")).sendKeys("ind");
		Thread.sleep(3000);
		List<WebElement> options = driver.findElements(By.cssSelector(".ui-menu-item"));
		int menuSize= options.size();
		for(int i=1; i<=menuSize; i++)
		{
			//for(WebElement option: options) {
				
				Actions a= new Actions(driver);
				a.moveToElement(driver.findElement(By.xpath("//li[@class='ui-menu-item']["+i+"]"))).build().perform();
				//System.out.println(driver.findElement(By.xpath("//li[@class='ui-menu-item']["+i+"]")).getText());
				String item = driver.findElement(By.xpath("//li[@class='ui-menu-item']["+i+"]")).getText();
				if(item.equalsIgnoreCase("India")) {
					a.moveToElement(driver.findElement(By.xpath("//li[@class='ui-menu-item']["+i+"]"))).click().build().perform();
					break;
				}
			//	}
		}
		Thread.sleep(2000);
		driver.findElement(By.id("autocomplete")).clear();
		driver.findElement(By.id("autocomplete")).sendKeys("uni");
		Thread.sleep(3000);
		List<WebElement> options2 = driver.findElements(By.cssSelector(".ui-menu-item"));
		int menuSize2= options2.size();
		for(int i=1; i<=menuSize2; i++)
		{
			
				
				Actions a= new Actions(driver);
				a.moveToElement(driver.findElement(By.xpath("//li[@class='ui-menu-item']["+i+"]"))).build().perform();
				//System.out.println(driver.findElement(By.xpath("//li[@class='ui-menu-item']["+i+"]")).getText());
				String item = driver.findElement(By.xpath("//li[@class='ui-menu-item']["+i+"]")).getText();
				if(item.equalsIgnoreCase("United Kingdom (UK)")) {
					a.moveToElement(driver.findElement(By.xpath("//li[@class='ui-menu-item']["+i+"]"))).click().build().perform();
					break;
				}
		
		}

	}

}
