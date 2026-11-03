package com.qa.opencart.base;

import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.microsoft.playwright.Page;
import com.qa.opencart.factory.PlaywrightFactory;
import com.qa.opencart.pages.HomePage;
import com.qa.opencart.pages.LoginPage;


public class BaseTest {
	
	PlaywrightFactory playwrightFactory;
	Page page;
	protected HomePage homePage;
	protected LoginPage loginPage;
	protected Properties prop;
	
 @BeforeTest
	public void setup() {
		// Initialize the browser and navigate to the home page
		playwrightFactory = new PlaywrightFactory();
		prop = playwrightFactory.init_prop();//initialize properties from config file
		page = playwrightFactory.initBrowser(prop);
		homePage =  new HomePage(page);
		
	}
	
	@AfterTest
	public void tearDown() {
		// Close the browser after each test
		 page.context().browser().close();
	  
	}
}
