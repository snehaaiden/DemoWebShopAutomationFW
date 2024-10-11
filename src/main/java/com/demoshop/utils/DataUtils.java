package com.demoshop.utils;

import com.github.javafaker.Faker;

public class DataUtils {
public static String firstName, lastName, uniqueEmail, password;
	
	public static void initUserData() {
		Faker faker= new Faker();
		firstName= faker.name().firstName();
		lastName= faker.name().lastName();
	    uniqueEmail = faker.internet().emailAddress();
		password= faker.internet().password();

}
	/*city,address,postalcode,phoneno
	public static void billingAddressData() {
		Faker faker= new Faker();
		firstName= faker.name().firstName();
		lastName= faker.name().lastName();
	    uniqueEmail = faker.internet().emailAddress();
		city= faker.internet().city;
		address=faker.internet().address;*/

}
