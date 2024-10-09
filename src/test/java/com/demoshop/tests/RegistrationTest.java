package com.demoshop.tests;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoshop.utils.ExcelReader;
import com.demoshop.utils.UniqueGenerator;
import com.github.javafaker.Faker;



public class RegistrationTest extends BaseTest{

	@Test
	public void  verifyRegisteredUsercanVoteInCommunityPoll() throws IOException {
		
		
		loginPage.navigateToRegisterationSection();
		
		Faker faker= new Faker();
		String firstName= faker.name().firstName();
		String lastName= faker.name().lastName();
		String uniqueEmail = faker.internet().emailAddress();
		String password= faker.internet().password();
	
		registerPage.setUserData(firstName, lastName, uniqueEmail, password);
		
		registerPage.continueWithRegisteredUser();
		
		String communityPollResult = registerPage.communityPollresult();

		boolean isResultMatched= false;
		if(communityPollResult.contains(prop.getProperty("result"))) 
			isResultMatched=true;
		
		Assert.assertTrue(isResultMatched, "Message is not matching");
		}
}	
	





// String expectedEmail = loginPage.getLoggedEmail(); line 30
				//Assert.assertEquals(uniqueEmail, expectedEmail, "Registered email is differents");line31
			/*loginPage.navigateToRegisterationSection();
			String firstName= 	ExcelReader.getCellValue(1, 0);
			String lastName= 	ExcelReader.getCellValue(1, 1);
			String uniqueEmail =ExcelReader.getCellValue(1, 2)+UniqueGenerator.getCurrentDateTime()+"@gmail.com";
			String password= ExcelReader.getCellValue(1, 3);
			registerPage.setUserData(firstName, lastName, uniqueEmail, password);
		    String expectedEmail = loginPage.getLoggedEmail();
			Assert.assertEquals(uniqueEmail, expectedEmail, "Registered email is differents");*/
			
		
		

