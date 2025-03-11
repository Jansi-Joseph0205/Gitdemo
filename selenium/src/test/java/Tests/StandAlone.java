package Tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class StandAlone {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client");
		
		driver.findElement(By.id("userEmail")).sendKeys("jansi@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("*Selenium1");
		driver.findElement(By.id("login")).click();
		
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		
		List<WebElement> items= driver.findElements(By.cssSelector(".mb-3"));
		WebElement product = items.stream().filter(item -> item.findElement(By.cssSelector("b")).getText().equalsIgnoreCase("ZARA COAT 3")).findFirst().orElse(null);
		product.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		driver.findElement(By.cssSelector("button[routerlink*=\"cart\"]")).click();
		
		List<WebElement> cartprods =driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean text= cartprods.stream().anyMatch(cartprod -> cartprod.getText().equalsIgnoreCase("ZARA COAT 3"));
		Assert.assertTrue(text);
		
		driver.findElement(By.cssSelector(".totalRow button")).click();
		
		Actions a= new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("input[placeholder=\"Select Country\"]")), "India").build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();
		
		driver.findElement(By.cssSelector(".action__submit")).click();
		String successmsg = driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(successmsg.equalsIgnoreCase("Thankyou for the order."));
		
		
		

	}

}
