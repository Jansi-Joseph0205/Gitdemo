package TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Jansi.PageObjectModel.LandingPage;

public class BaseClass {
	public WebDriver driver;
	public LandingPage landingPage;
	
	public WebDriver IntializeDriver() throws IOException {
		
		
		//properties class
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\Resources\\GlobalData.properties");
		prop.load(fis);
		//String browserName = prop.getProperty("browser");
		String browserName = System.getProperty("browser")!= null ? System.getProperty("browser"): prop.getProperty("browser");
		if(browserName.contains("chrome")) {
			ChromeOptions options = new ChromeOptions();
			if(browserName.contains("headless")) {
				options.addArguments("headless");
			}
			
			driver = new ChromeDriver(options);
			driver.manage().window().setSize(new Dimension(1440,900));
		}
		else if(browserName.equalsIgnoreCase("firefox")){
			//firefox code
			 driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("edge")){
			//edge code
		}
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;

	}
	public String getScreenshot(String testcaseName, WebDriver driver) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source= ts.getScreenshotAs(OutputType.FILE);
		File file= new File(System.getProperty("user.dir")+"//reports//"+testcaseName+".png");
		FileUtils.copyFile(source, file);
			
		
		
		return System.getProperty("user.dir")+"//reports//"+testcaseName+".png";
		
	}
	
	
		
		public List<HashMap<String,String>> getJsontoMap(String FilePath) throws IOException{
		
		String jsonContent = FileUtils.readFileToString(new  File(FilePath), StandardCharsets.UTF_8);
			ObjectMapper mapper = new ObjectMapper();
			List<HashMap <String,String>> data= mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>(){
				
			});
			return data;
			
	}

	
	
	
	
	@BeforeMethod(alwaysRun=true)
	public LandingPage lanchApplication() throws IOException {
		driver =IntializeDriver();
		landingPage = new LandingPage(driver);
		landingPage.goTo();
		return landingPage;
	}
	
	@AfterMethod(alwaysRun=true)
	public void tearDown() {
		driver.close();
	}

}
