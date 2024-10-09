package com.demoshop.pageObject;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoshop.utils.PageActions;

public class LoginPage extends PageActions {
	
private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//a[@class='ico-login']")
	private WebElement loginHeader;
	
	@FindBy(xpath="//a[@class='ico-register']")
	private WebElement registerHeader;
	
	@FindBy(xpath="//*[@id='Email']")
	private WebElement emailInput;
	
	@FindBy(id="Password")
	private WebElement passwordInput;
	

	@FindBy(xpath="//*[@class='buttons']/*[@value='Log in']")
	private WebElement loginBtn;
	
	@FindBy(css=".account")
	private WebElement loggedEmail;
	
	@FindBy(id="newsletter-email")
	private WebElement newsLetterEmail;
	
	@FindBy(id="newsletter-subscribe-button")
	private WebElement newsLetterSubscribeBtn;
	
	@FindBy(id="newsletter-result-block")
	private WebElement newsLetterSubscribeText;
	
	@FindBy(id="small-searchterms")
	private WebElement searchInput;
	
	@FindBy(css="[value='Search']")
	private WebElement searchBtn;
	
	
	
	
	
	public void navigateToLoginSection() {
		clickElement(loginHeader);
	}
	
	public void navigateToRegisterationSection() {
		//registerHeader.click();
		clickElement(registerHeader);
	}
	
	public void login(String email, String pass) {
		emailInput.sendKeys(email);
        passwordInput.sendKeys(pass);
       // loginBtn.click();
      /*  setTextBox(emailInput, email);
		setTextBox(passwordInput, pass);*/
        clickElement(loginBtn);
	}
	
	public String getLoggedEmail() {
		//return loggedEmail.getText();
		return getElementText(loggedEmail);
	}
	
	public String verifyNewsLetterEmail(String uniqueEmail) throws InterruptedException {
	/*	newsLetterEmail.sendKeys(uniqueEmail);
		newsLetterSubscribeBtn.click();
		Thread.sleep(2000);
		return newsLetterSubscribeText.getText();*/
		setTextBox(newsLetterEmail, uniqueEmail);
	    clickElement(newsLetterSubscribeBtn);
		waitUntilVisible(newsLetterSubscribeText);
		Thread.sleep(2000);
		return getElementText(newsLetterSubscribeText);
	}
	
	public void searchProduct(String productName)
	{
		setTextBox(searchInput,productName);
		clickElement(searchBtn);
	}
	}
