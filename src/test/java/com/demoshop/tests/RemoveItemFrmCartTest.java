package com.demoshop.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.demoshop.pageObject.ShoppingCartPage;



public class RemoveItemFrmCartTest extends BaseTest {

	
	@Test
	public void verifyUserCanRemoveItemFromCart()
	{
		loginPage.navigateToLoginSection();

		loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		loginPage.searchProduct("Jeans");
		productPage.clickAddToCartButton().navigateToCart();
		shoppingCartPage.removeFrmCart();
		//Object message = shoppingCartPage.message();
		
		boolean isResultMatched= false;
		System.out.println(shoppingCartPage.message());
		System.out.println((prop.getProperty("emptyCartMessg")));
		
		if(shoppingCartPage.message().contains(prop.getProperty("emptyCartMessg"))) 
			isResultMatched=true;
		
		Assert.assertTrue(isResultMatched, "Message is not matching");
		//Assert.(message,prop.getProperty("emptyCartMessg"), "The cart is not empty");

	}
}
