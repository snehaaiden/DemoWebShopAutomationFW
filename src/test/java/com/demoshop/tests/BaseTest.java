package com.demoshop.tests;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;

import com.beust.jcommander.Parameters;
import com.demoshop.pageObject.LoginPage;
import com.demoshop.pageObject.ProductPage;
import com.demoshop.pageObject.RegisterPage;
import com.demoshop.pageObject.ShoppingCartPage;
import com.demoshop.utils.PageActions;
import com.demoshop.utils.TestProperties;

public class BaseTest {
	WebDriver driver= null;
	public Properties prop;
	
   @BeforeMethod(alwaysRun=true)
 //  @Parameters({"browserName"})
	public void initDriver(@Optional String browserName) throws IOException {
	    prop = TestProperties.getProperties();
	   System.out.println("In before Method");
	   
	   
	   if(browserName==null || browserName.isEmpty()) {
		 browserName = prop.getProperty("browser"); 
	   }
	   
	   System.out.println(browserName);
		getDriver(browserName);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String url=prop.getProperty(prop.getProperty("environment"));
		driver.get(url);
		initPages();
		
	}
	
	public WebDriver getDriver(String browserName) {
		if(browserName.equalsIgnoreCase("Chrome")) {
			 driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			 driver = new EdgeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
		 driver = new FirefoxDriver();
		}
		else {
			System.out.println("Please chooose correct browser");
		}
		return driver;
	}
	
	public LoginPage loginPage;
	public RegisterPage registerPage;
	public  ProductPage productPage;
	public ShoppingCartPage shoppingCartPage;
	
	public void initPages() {
		loginPage= new LoginPage(driver);
	    registerPage = new RegisterPage(driver);
	    productPage = new ProductPage(driver);
	}
	
	@AfterMethod(alwaysRun=true)
	public void tearDown() {
		//driver.quit();
	}
	

}