package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class framestest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		WebDriver driver = new ChromeDriver();	
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/draggable/");
		WebElement a=driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(a);
		
		
		//demo-frame

	}

}
