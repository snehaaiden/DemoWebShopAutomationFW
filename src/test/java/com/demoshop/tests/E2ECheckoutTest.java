
package com.demoshop.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoshop.utils.DataUtils;

public class E2ECheckoutTest extends BaseTest {
	
		
		@Test(groups="Smoke")
		public void verifyNewUserRegistersAndCheckoutProduct() {
			//Registering user
			DataUtils.initUserData();
		    loginPage.navigateToRegisterationSection();
			registerPage.setUserData(DataUtils.firstName, DataUtils.lastName, DataUtils.uniqueEmail, DataUtils.password);
		    String expectedEmail = loginPage.getLoggedEmail();
			Assert.assertEquals(DataUtils.uniqueEmail, expectedEmail, "Registered email is differents");
			
			//Searching product
			loginPage.searchProduct("Jeans");
			//put assertion it's blue jeans
			Assert.assertEquals(productPage.title(),prop.getProperty("productTitle"), "The product titles are different");
			
			
			productPage.clickAddToCartButton().navigateToCart();
			shoppingCartPage.selectCheckbox();
			//assert that it moved to checkoutpage
			//shoppingCartPage.selectCountry(shoppingCartPage.selectCountry,"India");
			//checkout , billing
		
		
	}

}
