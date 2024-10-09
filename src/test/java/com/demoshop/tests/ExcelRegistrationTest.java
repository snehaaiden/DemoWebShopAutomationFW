package com.demoshop.tests;

import java.io.IOException;

import org.testng.Assert;

import org.testng.annotations.Test;

import com.demoshop.pageObject.LoginPage;
import com.demoshop.pageObject.RegisterPage;
import com.demoshop.utils.ExcelReader;
import com.demoshop.utils.UniqueGenerator;
import com.github.javafaker.Faker;



public class ExcelRegistrationTest extends BaseTest{


	@Test
	public void verifyUserIsAbleToRegisterUsingCorrectCreds() {
		
		loginPage.navigateToRegisterationSection();
		
		Faker faker= new Faker();
		String firstName= faker.name().firstName();
		String lastName= faker.name().lastName();
		String uniqueEmail = faker.internet().emailAddress();
		String password= faker.internet().password();
		registerPage.setUserData(firstName, lastName, uniqueEmail, password);
	    String expectedEmail = loginPage.getLoggedEmail();
		Assert.assertEquals(uniqueEmail, expectedEmail, "Registered email is differents");
	}
}
