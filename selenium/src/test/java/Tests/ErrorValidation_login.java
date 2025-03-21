package Tests;

import java.io.IOException;
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
import org.testng.annotations.Test;

import Jansi.PageObjectModel.CartPage;
import Jansi.PageObjectModel.CheckOutPage;
import Jansi.PageObjectModel.LandingPage;
import Jansi.PageObjectModel.OrdersPage;
import Jansi.PageObjectModel.ProductCatelog;
import TestComponents.BaseClass;
import TestComponents.Retry;

public class ErrorValidation_login extends BaseClass{
	
	String productName = "ZARA COAT 3";

	@Test(groups= {"ErrorValid"},retryAnalyzer= Retry.class)
	public void ErrorValidation_login()  throws IOException {
		// TODO Auto-generated method stub
	
		String countryName = "India";
		
		landingPage.loginApplication("jansimmm@gmail.com", "*Selenium123");
		
		String errormes = landingPage.errormessage();
		System.out.println(errormes);
		
		Assert.assertTrue(errormes.equalsIgnoreCase("Incorrect email or password."));

		
	
		
						//div[@class='ng-tns-c4-18 ng-star-inserted ng-trigger ng-trigger-flyInOut ngx-toastr toast-error']
	}
	
	@Test
	public void ProductpageErrorValidation()  throws IOException {
		// TODO Auto-generated method stub
		
		
		
		ProductCatelog productCatelog = landingPage.loginApplication("vimala@gmail.com", "*Selenium1");

	
		 List<WebElement> products = productCatelog.getProductsList();
		 productCatelog.addProductToCart(productName);
		 CartPage cartPage= productCatelog.goToCartPage();
		 
		
		 Boolean check = cartPage.checkForProductinList("ZARA COAT 55");
		 Assert.assertFalse(check);
		 
			}
	
	



	
}