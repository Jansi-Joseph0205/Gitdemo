package Jansi.AbstractClass;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Jansi.PageObjectModel.CartPage;
//import Jansi.PageObjectModel.OrdersPage;
import Jansi.PageObjectModel.OrdersPage;

public class AbstractClass {
	
	WebDriver driver;

	public AbstractClass(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(css="button[routerlink*=\"cart\"]")
	WebElement addToCart;
	
	@FindBy(css="button[routerlink*=\"myorders\"]")
	WebElement orders;

	
	public void WaitforElementToAppear(By FindBy) {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(FindBy));
	}
	
	public void WaitforWebElementToAppear(WebElement FindBy) {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(FindBy));
	}
	
	public void WaitforElementToDisappear(WebElement scroll) {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(scroll));
	}
	
	public CartPage goToCartPage() {
		addToCart.click();
		CartPage cartPage = new CartPage(driver);
		return cartPage;
	}
	
	public OrdersPage goToOrdersPage() {
		orders.click();
		OrdersPage ordersPage = new OrdersPage(driver);
		return ordersPage;
	}
	
}
