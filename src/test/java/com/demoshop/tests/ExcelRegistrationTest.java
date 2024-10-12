package com.demoshop.tests;

import java.io.IOException;


import org.testng.Assert;

import org.testng.annotations.Test;

import com.demoshop.pageObject.LoginPage;
import com.demoshop.pageObject.RegisterPage;
import com.demoshop.utils.DataUtils;
import com.demoshop.utils.ExcelReader;
import com.demoshop.utils.UniqueGenerator;
import com.github.javafaker.Faker;



public class ExcelRegistrationTest extends BaseTest{


	@Test
	public void verifyUserIsAbleToRegisterUsingCorrectCreds() {
		
		loginPage.navigateToRegisterationSection();
		DataUtils.initUserData();
		registerPage.setUserData(DataUtils.firstName, DataUtils.lastName, DataUtils.uniqueEmail, DataUtils.password);
	    String expectedEmail = loginPage.getLoggedEmail();
		Assert.assertEquals(DataUtils.uniqueEmail, expectedEmail, "Registered email is differents");
	}
}
