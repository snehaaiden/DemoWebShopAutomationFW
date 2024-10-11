package com.demoshop.tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddCommentInWebsite extends BaseTest {
	
	
	@Test
	public void verifyIfUserIsAbleToAddComments() {
		
		loginPage.navigateToLoginSection();

		loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		
		loginPage.selectBlog();
		loginPage.clickComment();
		loginPage.addComment();
		String checkTheComment = loginPage.checkAddedComment();
		 
	Assert.assertEquals(checkTheComment,prop.getProperty("comment"), "Your comment is not displayed");

		
	}

}
