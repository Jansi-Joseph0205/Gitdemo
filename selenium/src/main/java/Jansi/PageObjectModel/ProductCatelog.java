package Jansi.PageObjectModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Jansi.AbstractClass.AbstractClass;

public class ProductCatelog extends AbstractClass{
	
	WebDriver driver;
	public ProductCatelog(WebDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement scroll;
	
	
	
	
	By productsBy = By.cssSelector(".mb-3");
	By productNameBy = By.cssSelector("b");
	By addToCartBy = By.cssSelector(".card-body button:last-of-type");
	By toastBy = By.cssSelector("#toast-container");
	
	public List<WebElement> getProductsList() {
		WaitforElementToAppear(productsBy);
		return products;
		
		
	}
	
	
	
	
	public WebElement getProductByName(String productName) {
		WebElement prod = getProductsList().stream().filter(item -> item.findElement( By.cssSelector("b")).getText().equalsIgnoreCase(productName)).findFirst().orElse(null);
		return prod;
	}
	
	
	
	public void addProductToCart(String productName) {
		WebElement product = getProductByName(productName);
		product.findElement(addToCartBy).click();
		WaitforElementToAppear(toastBy);
		WaitforElementToDisappear(scroll);
		
		
		
	}
		
	}
	
	

	
	
	
	
	
	

