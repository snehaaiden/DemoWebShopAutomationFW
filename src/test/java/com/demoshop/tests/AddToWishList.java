package com.demoshop.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToWishList  extends BaseTest{

	@Test
	public void verifyUserCanAddItemToWishList() {

	loginPage.navigateToLoginSection();

	loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
	loginPage.aparelShoesMenu();
	productPage.selectPrd();
	productPage.wishList();
	productPage.viewwishList();
	String productName = productPage.prdTxt();
	System.out.println(productName);
	Assert.assertEquals(productName,prop.getProperty("productInWishlist"), "The product is not present in the wishlist");

	
}
}