package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class dropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();	
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		WebElement dropdownbox = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		
		Select dropdownb = new Select(dropdownbox);
		dropdownb.selectByIndex(3);
		Thread.sleep(2000);
		System.out.println(dropdownb.getFirstSelectedOption().getText());
		dropdownb.selectByVisibleText("AED");
		System.out.println(dropdownb.getFirstSelectedOption().getText());
		dropdownb.selectByValue("INR");

	}

}
