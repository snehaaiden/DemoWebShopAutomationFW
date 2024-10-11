package com.demoshop.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FilterBookAddToCompareList extends BaseTest {

	@Test
	public void UserIsAbleToFilterBookAndAddToCompareList()
	{
		loginPage.navigateToLoginSection();

		loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		shoppingCartPage.filterBook();
		shoppingCartPage.book();
		String compareList = shoppingCartPage.compareTheList();
		
		System.out.println(compareList);
		Assert.assertEquals(compareList,prop.getProperty("compareList"), "Your product is not present in the compare product list");

	}
}
