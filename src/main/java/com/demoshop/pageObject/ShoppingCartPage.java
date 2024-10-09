package com.demoshop.pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoshop.utils.PageActions;

public class ShoppingCartPage  extends PageActions {
	
private WebDriver driver;
	
	public ShoppingCartPage(WebDriver driver) {
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//td[@class='remove-from-cart']")
	private WebElement removeBtn;
	
	
	@FindBy(css="//div[@class='terms-of-service']")
	private WebElement checkbox1;
	
	@FindBy(css=".country-input")
	private WebElement selectCountry;
	
	public void selectCheckbox()
	{
		clickElement(checkbox1);
		
}
	/*public void selectCountry(WebElement dropdown, String visibleText)
	{
		handleStaticDrowpdown(selectCountry,"India");
	}
	*/
}
