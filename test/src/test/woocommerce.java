package test;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class woocommerce {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();	
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		Thread.sleep(3000);
		String[] itemsNeeded = {"Brocolli", "Carrot"};
		
		List<WebElement> products = driver.findElements(By.cssSelector("h4[class='product-name']"));
		int j=0;
		for(int i=0; i<products.size(); i++){
			String[] name= products.get(i).getText().split("-");
			String formattedName = name[0].trim();
			List items = Arrays.asList(itemsNeeded);
			if(items.contains(formattedName)) {
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if(j==itemsNeeded.length) {
					break;
				}
			}
		}
		

	}

}
