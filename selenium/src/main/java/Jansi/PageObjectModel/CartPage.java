package Jansi.PageObjectModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.testng.Assert;
//test for github integation

import Jansi.AbstractClass.AbstractClass;

public class CartPage extends AbstractClass{

	
	WebDriver driver;
	public CartPage(WebDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css=".cartSection h3")
	List<WebElement> cartprods;
	
	@FindBy(css=".totalRow button")
	WebElement checkout;
	
	
	public Boolean checkForProductinList(String productName) {
		Boolean text= cartprods.stream().anyMatch(cartprod -> cartprod.getText().equalsIgnoreCase(productName));
		return text;
		
	}
	
	public CheckOutPage moveToCheckout() {
		
		checkout.click();
		 CheckOutPage checkOutPage = new CheckOutPage(driver);
		return checkOutPage;
		
	}
	
	
	
	
	
	
	
}
