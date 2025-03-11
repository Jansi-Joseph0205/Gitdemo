package Jansi.PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Jansi.AbstractClass.AbstractClass;

public class LandingPage extends AbstractClass{
	
	WebDriver driver;
	public LandingPage(WebDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement userPassword;
	
	@FindBy(id="login")
	WebElement submit;
	
	
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errormsg;
	
	public ProductCatelog loginApplication(String email, String password) {
		
		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		submit.click();
		ProductCatelog productCatelog =new ProductCatelog(driver);
		return productCatelog;
		
	}
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public String errormessage() {
		WaitforWebElementToAppear(errormsg);
		return errormsg.getText();
	}

	
	
	
	
	
	
}
