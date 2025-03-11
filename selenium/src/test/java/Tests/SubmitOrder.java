package Tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Jansi.PageObjectModel.CartPage;
import Jansi.PageObjectModel.CheckOutPage;
import Jansi.PageObjectModel.LandingPage;
import Jansi.PageObjectModel.OrdersPage;
import Jansi.PageObjectModel.ProductCatelog;
import TestComponents.BaseClass;

public class SubmitOrder extends BaseClass{
	String productName = "ZARA COAT 3";

	@Test(dataProvider = "getData", groups="smoke")
	public void submitOrder(HashMap<String,String> input)  throws IOException {
		// TODO Auto-generated method stub
		
		String countryName = "India";
		
		ProductCatelog productCatelog = landingPage.loginApplication(input.get("email"), input.get("Password"));

	
		 List<WebElement> products = productCatelog.getProductsList();
		 productCatelog.addProductToCart(input.get("productName"));
		 CartPage cartPage= productCatelog.goToCartPage();
		 
		
		 Boolean check = cartPage.checkForProductinList(input.get("productName"));
		 Assert.assertTrue(check);
		 
		 CheckOutPage checkOutPage =cartPage.moveToCheckout();
		 
		 		
		checkOutPage.selectCountry("India");
		
		checkOutPage.checkOut();
	
		
		String successmsg = checkOutPage.checkForOrderSuccess();
		Assert.assertTrue(successmsg.equalsIgnoreCase("Thankyou for the order."));

	}
	
	@Test(dependsOnMethods= {"submitOrder"})
	public void OrdersHistoryTest()  throws IOException {
		// TODO Auto-generated method stub
		
		
		
		ProductCatelog productCatelog = landingPage.loginApplication("jansi@gmail.com", "*Selenium1");
		OrdersPage ordersPage=productCatelog.goToOrdersPage();
		Assert.assertTrue(ordersPage.verifyOrderDisplay(productName));

	
		 
		 
	}
	
	public String getScreenshot(String testcaseName) throws IOException {
		TakesScreenshot ts= (TakesScreenshot)driver;
		File source= ts.getScreenshotAs(OutputType.FILE);
		File file= new File(System.getProperty("user.dir")+"//reports//"+testcaseName+".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir")+"//reports//"+testcaseName+".png";
		
	}
	
	
	
	@DataProvider
	public Object[][] getData() throws IOException{
		/*
		 * HashMap<String,String> map= new HashMap<String, String>(); map.put("email",
		 * "jansi@gmail.com"); map.put("Password", "*Selenium1"); map.put("productName",
		 * "ZARA COAT 3");
		 * 
		 * HashMap<String,String> map1= new HashMap<String, String>(); map1.put("email",
		 * "vimala@gmail.com"); map1.put("Password", "*Selenium1");
		 * map1.put("productName", "IPHONE 13 PRO");
		 */
		List<HashMap<String,String>> data= getJsontoMap(System.getProperty("user.dir")+"\\src\\main\\java\\DataSet\\PurchaseOrder.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}
	
	
	/*
	 * @DataProvider public Object[][] getData(){ return new Object[][]
	 * {{"jansi@gmail.com","*Selenium1","ZARA COAT 3"},{"vimala@gmail.com",
	 * "*Selenium1","IPHONE 13 PRO"}}; }
	 */

}
	


	


