package Jansi.PageObjectModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.testng.Assert;

import Jansi.AbstractClass.AbstractClass;

public class OrdersPage extends AbstractClass{

	
	WebDriver driver;
	public OrdersPage(WebDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> ProductNames;
	
	
	
	
	public Boolean verifyOrderDisplay(String productName) {
		Boolean text= ProductNames.stream().anyMatch(cartprod -> cartprod.getText().equalsIgnoreCase(productName));
		return text;
		
	}
	
	
	
	
	
	
	
	
	
}
