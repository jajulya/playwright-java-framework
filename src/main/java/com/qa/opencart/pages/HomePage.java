package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class HomePage  {
	
	private Page page;
	
	//1.String locators: OR(Object Repository)
	private String search = "input[name='search']";
	private String searchIcon = "div#search button";
	private String searchPageHeader = "div#content h1";
	private String loginLink = "a:text('Login')";
	private String myAccountLink = "a[title='My Account']";
	
	
	//2.Page constructor
	public HomePage(Page page) {
		this.page = page;
	}
	
	//3.Page Actions/methods
	public String HomePageTitle() {
		System.out.println("Home Page title is: " + page.title());
		return page.title();
	    
		}
	
	public String HomePageURL() {
		System.out.println("Home Page url is: " + page.url());
		return page.url();
	    
		}
	
	public String doSearch(String productName) {
		page.fill(search, productName);
		page.click(searchIcon);
	    String header = page.textContent(searchPageHeader);
	    System.out.println("Search page header is: " + header);
	    return header;
		}
	
	public LoginPage navigateToLoginPage() {
		page.click(myAccountLink);
		page.click(loginLink);
		return new LoginPage(page);
	}
	}
	
	
	
	
		

