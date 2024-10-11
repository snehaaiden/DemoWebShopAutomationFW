package com.demoshop.tests;

import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoshop.utils.UniqueGenerator;

public class EmailAFriendTest extends BaseTest {

	@Test
	public void UserIsAbleToEmailAProductToAFriend()
	{
		loginPage.navigateToLoginSection();

		loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		loginPage.searchProduct(prop.getProperty("productToSearch"));
		 productPage.getSearchedProduct();
		 productPage.sentProductDetailsAsEmail(prop.getProperty("friendEmail"),prop.getProperty("friendMessage"));
		 String displayedMessage = productPage.message();
		 System.out.println(displayedMessage);
		 
			boolean isMessageMatched= false;
			if(displayedMessage.equals(prop.getProperty("displayedMessageAfterEmailIsSent"))) 
				isMessageMatched=true;
			
			Assert.assertTrue(isMessageMatched, "Message is not matching");

	}
}
