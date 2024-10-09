package com.demoshop.pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoshop.utils.PageActions;

public class ProductPage extends PageActions {
	
private WebDriver driver;
	
	public ProductPage(WebDriver driver) {
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css=".product-title a")
	private List<WebElement> productList;
	
			
	@FindBy(css="[src=\"https://demowebshop.tricentis.com/content/images/thumbs/0000029_black-white-diamond-heart_125.jpg\"]")
	private WebElement product;		
	
	
	@FindBy(css="[value='Email a friend']")
	private WebElement EmailFrdBtn;
	
	
	
	@FindBy(css=".friend-email")
	private WebElement EmailFrd;
	
	
	
	@FindBy(css=".personal-message")
	private WebElement personalMessg;
	
	
			
	@FindBy(css="[name=\"send-email\"]")
	private WebElement sendMailBtn;	
	
	
	
	@FindBy(css=".result")
	private WebElement EmailSentMsg;	
	
	@FindBy(css="[value='Add to cart']")
	private WebElement addToCartBtn;
	
	@FindBy(css=".header-links .ico-cart ")
	private WebElement shoppingCartHeader;
	
	
	@FindBy(css=".product-title ")
	private WebElement productTitle;

	public List<String> getSearchedProductList()
	{
		return getElementTextList(productList);
		
	}
	public void getSearchedProduct()
	{
		clickElement(product);
		clickElement(EmailFrdBtn);
}
	
	
	public void sentProductDetailsAsEmail(String email,String Message)
	{
		EmailFrd.sendKeys(email);
		personalMessg.sendKeys(Message);
		clickElement(sendMailBtn);
		}
	public String message()
	{
		return getElementText(EmailSentMsg);
	}
	
	
	public ProductPage clickAddToCartButton() {
		clickElement(addToCartBtn);
		return this;
	}
	
	public void navigateToCart() {
		clickElement(shoppingCartHeader);
	}
	
	public String title()
	{
		return getElementText(productTitle);
	}
}