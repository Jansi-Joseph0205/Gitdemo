package Jansi.PageObjectModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.testng.Assert;

import Jansi.AbstractClass.AbstractClass;

public class CheckOutPage extends AbstractClass{

	
	WebDriver driver;
	public CheckOutPage(WebDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css="input[placeholder=\'Select Country\']")
	WebElement countryTextField;
	
	@FindBy(css=".ta-item:nth-of-type(2)")
	WebElement country;
	

	@FindBy(css=".action__submit")
	WebElement checkoutButton;
	
	@FindBy(css=".hero-primary")
	WebElement message;
	
	By countryBy =  By.cssSelector(".ta-results");
	
	public void selectCountry(String countryName) {
		
		
		Actions a = new Actions(driver);
		a.sendKeys(countryTextField, countryName).build().perform();
		WaitforElementToAppear(countryBy);
				
		country.click();
	}
	
	public void checkOut() {
		checkoutButton.click();
	}
	
	
	public String checkForOrderSuccess() {
		
		String msg= message.getText();
		return msg;
	}


	
	
}
