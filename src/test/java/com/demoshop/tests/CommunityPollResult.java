package com.demoshop.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoshop.utils.DataUtils;

public class CommunityPollResult extends BaseTest {
	
	@Test
	public void userIsAbleToDoCommunityPoll() {
		loginPage.navigateToRegisterationSection();
		
		DataUtils.initUserData();
		registerPage.setUserData(DataUtils.firstName, DataUtils.lastName, DataUtils.uniqueEmail,DataUtils.password);
		
		registerPage.continueWithRegisteredUser();
		
		String communityPollResult = registerPage.communityPollresult();
		System.out.println(communityPollResult);

		boolean isResultMatched= false;
		if(communityPollResult.contains(prop.getProperty("result"))) 
			isResultMatched=true;
		
		Assert.assertTrue(isResultMatched, "Message is not matching");
		}
		
		
	}
	
	



