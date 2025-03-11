package test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class assingment7 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();	
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		List<WebElement> rows= driver.findElements(By.xpath("//table[@class='table-display']/tbody/tr"));
		int rowcnt = rows.size();
		System.out.println("Rows count"+rowcnt);
		List<WebElement> columns= driver.findElements(By.xpath("//table[@class='table-display']/tbody/tr/th"));
		int colcnt = columns.size();
		System.out.println("Column count"+colcnt);
		
		int rowrqd=2;
		for (int i=1; i<=colcnt; i++) {
			
			List<WebElement> items= driver.findElements(By.xpath("//table[@class='table-display']/tbody/tr/td["+i+"]"));
			
			System.out.println(items.get(rowrqd-1).getText());
			
			
		}
		
		
		
	}

}
