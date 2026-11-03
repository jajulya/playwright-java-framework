package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.ApplicationConstants;

public class HomePageTest extends BaseTest{


	
	@Test
	public void HomePageTitleTest() {
		// Verify the home page title
		String actualTitle = homePage.HomePageTitle();
		Assert.assertEquals(actualTitle, ApplicationConstants.HOME_PAGE_TITLE);
	}
	
	@Test
	public void HomePageURLTest() {
		// Verify the home page title
		String actualURL = homePage.HomePageURL();
		Assert.assertEquals(actualURL, prop.getProperty("url").trim());
	}
	
	@DataProvider
	public Object[][] getProductData() {
		return new Object[][] {
				{ "Macbook" }, 
				{ "iMac" }, 
				{ "Samsung" }
		};
	}
	
	@Test(dataProvider = "getProductData")
	public void SearchTest(String productName) {
		// Verify the home page title
		String actualSearchHeader = homePage.doSearch(productName);
		Assert.assertEquals(actualSearchHeader, "Search - " + productName);
	}
	

}
