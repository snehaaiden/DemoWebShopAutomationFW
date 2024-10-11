package com.demoshop.pageObject;




import org.openqa.selenium.JavascriptExecutor;
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
	
	@FindBy(css="[name=\"removefromcart\"]")		
	private WebElement removeBtn;
	
	@FindBy(css="[name=\"updatecart\"]")
	private WebElement updateCart;
	
	@FindBy(css=".order-summary-content")
	private WebElement emptyMessage;
	
	@FindBy(css="#termsofservice")
	private WebElement checkbox1;
	
	@FindBy(css="#CountryId")
	public WebElement selectCountry;
	
	@FindBy(css="#checkout")
	public WebElement checkOutBtn;
	
	@FindBy(css="[data-val-required=\"Country is required.\"]")
	public WebElement selectCountryBilling;		
	
	
	@FindBy(css="#BillingNewAddress_City")
	public WebElement city;
	
	
	@FindBy(css="[data-val-required=\"Street address is required\"]")
	public WebElement address;
	
	
	@FindBy(css="#BillingNewAddress_ZipPostalCode")
	public WebElement zipCode;
	
	
	@FindBy(css="[data-val-required=\"Phone is required\"]")
	public WebElement phoneNo;
	
	@FindBy(css="[onclick=\"Billing.save()\"]")
	public WebElement contBtn;
	
	
			
	@FindBy(css="[onclick=\"Shipping.save()\"]")
	public WebElement ShippingcontBtn;
	

	@FindBy(css="[onclick=\"ShippingMethod.save()\"]")
	public WebElement ShippingcontMethodBtn;
	
	@FindBy(css="[onclick=\"PaymentMethod.save()\"]")
	public WebElement paymentcontBtn;	
	

	@FindBy(css="[class=\"button-1 payment-info-next-step-button\"]")
	public WebElement paymentInfoBtn;	
	
	@FindBy(css="[onclick=\"ConfirmOrder.save()\"]")
	public WebElement confirmBtn;	
	
	@FindBy(xpath="//*[contains(text(),'Your order has been successfully processed!')]")
	public WebElement confirmMessage;
	
	@FindBy(xpath="//*[contains(text(),'Click here for order details')]")
	public WebElement orderDetails;
	
	@FindBy(xpath="//*[contains(text(),'Blue Jeans')]")
	public WebElement orderName;
	
	@FindBy(xpath="//*[contains(text(),'Books')]")
	public WebElement book;
	
	@FindBy(xpath="//*[contains(text(),'Over')]")
	public WebElement filter;
	
	@FindBy(css="[alt=\"Picture of Science\"]")
	public WebElement selectBook;
	
	@FindBy(css="[value=\"Add to compare list\"]")
	public WebElement addCompareList;
	
	@FindBy(css="[class=\"page-title\"]")
	public WebElement compareList;
	
	/*@FindBy(xpath="//*[contains(text(),'Blog')]")
	public WebElement desiredElement;
	
	@FindBy(xpath="//*[contains(text(),'Comments')]")
	public WebElement comment;
	
	@FindBy(css="#AddNewComment_CommentText")
	public WebElement commentText;*/
	
	

	
	
	public void selectCheckbox()
	{
		clickElement(checkbox1);
		}
	public void removeFrmCart()
	{
		clickElement(removeBtn);
		clickElement(updateCart);

	}
	public String message()
	{
		return getElementText(emptyMessage);
	}
	
	public void selectCountry(WebElement dropdown, String visibleText)
	{
		handleStaticDrowpdown(selectCountry,"India");
	}
	public void checkOut()
	{
		clickElement(checkOutBtn);
		}
	public void selectCountrybilling(WebElement dropdown, String visibleText)
	{
		handleStaticDrowpdown(selectCountryBilling,"India");
	}
	public void setUserData() {
		city.sendKeys("ekm");
		address.sendKeys("sweet home");
		zipCode.sendKeys("587946");
		phoneNo.sendKeys("9874563");
		//String address,Int zipcode,Int phoneno
	}
	public void contnue()
	{
		clickElement(contBtn);
		}
	public void contnueShipping()
	{
		clickElement(ShippingcontBtn);
		}
	public void contnueShippingMethod()
	{
		clickElement(ShippingcontMethodBtn);
		}
	public void contnuePaymentMethod()
	{
		clickElement(paymentcontBtn);
		}
	public void paymentInfo()
	{
		clickElement(paymentInfoBtn);
		}
	public void confirm()
	{
		clickElement(confirmBtn);
		}
	public String confirmMessage()
	{
		return getElementText(confirmMessage);
	}
	public void orderDetail()
	{
		clickElement(orderDetails);
		}
	public String ordercheck()
	{
		return getElementText(orderName);
	}
	public void filterBook()
	{
		clickElement(book);
		clickElement(filter);
		}
	public void book()
	{
		clickElement(selectBook);
		clickElement(addCompareList);
		}
	
	public String compareTheList()
	{
		return getElementText(compareList);
	}
	
	
}
