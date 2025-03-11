package test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class assignment6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();	
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
				
		driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[1]/input")).click();
		String opt = driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[1]")).getText();
		WebElement dropdown = driver.findElement(By.id("dropdown-class-example"));
		Select s= new Select(dropdown);
		s.selectByContainsVisibleText(opt);
		
		//enter value in text box
		driver.findElement(By.id("name")).sendKeys(opt);
		
		driver.findElement(By.id("alertbtn")).click();
		
		String alertmsg = driver.switchTo().alert().getText();
	if(alertmsg.contains(opt)) {
		System.out.println("Success");
	}else
	{
		System.out.println("Fail");	
	}
		//System.out.println(alertmsg);
		
		
		
		
		
		
		
		
}
}