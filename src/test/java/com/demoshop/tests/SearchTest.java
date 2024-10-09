package com.demoshop.tests;

import java.util.List;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoshop.pageObject.LoginPage;

public class SearchTest extends BaseTest {
	
	@Test
	
	public void verifyUserIsAbletoSearchDesiredProducts() {
		loginPage.searchProduct(prop.getProperty("productToSearch"));
		List<String> productNamesList = productPage.getSearchedProductList();
		
		boolean istextMatched= true;
		for(String productName : productNamesList) {
			if(!productName.contains(prop.getProperty("productToSearch"))) {
				istextMatched=false;
				break;
			}
		}
		
		Assert.assertTrue(istextMatched, "Product is not matching");

}
}
