package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class endtoend {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();	
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println(driver.findElements(By.tagName("a")).size());
		System.out.println(driver.findElements(By.cssSelector("div[id='gf-BIG'] a")).size());

	}

}
