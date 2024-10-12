package com.demoshop.tests;

import java.io.IOException;



import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoshop.utils.ExcelReader;
import com.demoshop.utils.UniqueGenerator;



public class RegistrationTest extends BaseTest{

	@Test
	public void  verifyUserIsAbleToRegisterUsingCorrectCredsFromExcel() throws IOException {
		
		
		/*String value= 	ExcelReader.getCellValue(1, 2);
		System.out.println(value);*/
		loginPage.navigateToRegisterationSection();
		String firstName= 	ExcelReader.getCellValue(1, 0);
		String lastName= 	ExcelReader.getCellValue(1, 1);
		String uniqueEmail =ExcelReader.getCellValue(1, 2)+UniqueGenerator.getCurrentDateTime()+"@gmail.com";
		String password= ExcelReader.getCellValue(1, 3);
		registerPage.setUserData(firstName, lastName, uniqueEmail, password);
	    String expectedEmail = loginPage.getLoggedEmail();
		Assert.assertEquals(uniqueEmail, expectedEmail, "Registered email is differents");
		
	
	
				
		
}	
	
}




// String expectedEmail = loginPage.getLoggedEmail(); line 30
				//Assert.assertEquals(uniqueEmail, expectedEmail, "Registered email is differents");line31
			
		

