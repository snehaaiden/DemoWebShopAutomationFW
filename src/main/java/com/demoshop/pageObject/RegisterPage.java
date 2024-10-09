package com.demoshop.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.demoshop.utils.PageActions;

public class RegisterPage extends PageActions {
	
private WebDriver driver;
	
	public RegisterPage(WebDriver driver) {
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(id="gender-male")
	private WebElement genderMale;
	
	@FindBy(id="FirstName")
	private WebElement firstName;
	
	@FindBy(id="LastName")
	private WebElement lastName;
	
	@FindBy(id="Email")
	private WebElement email;
	
	@FindBy(id="Password")
	private WebElement password;
	
	@FindBy(id="ConfirmPassword")
	private WebElement confirmPassword;
	
	@FindBy(id="register-button")
	private WebElement registerBtn;
	
	
	@FindBy(css="[value=\"Continue\"]")
	private WebElement continueBtn;
	
	
	@FindBy(css="#pollanswers-1")
	private WebElement excellentBtn;
	

			
	@FindBy(css="[value=\"Vote\"]")
	private WebElement VoteBtn;
	
	
	@FindBy(css=".poll-results")
	private WebElement pollResult;

	@FindBy(css = ".ico-logout")
	private WebElement logoutBtn;
	
	public void setUserData(String fName, String lName, String emailVal, String passVal) {
		genderMale.click();
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		email.sendKeys(emailVal);
		password.sendKeys(passVal);
		confirmPassword.sendKeys(passVal);
		registerBtn.click();
	}
	
	public void continueWithRegisteredUser()
	{
		clickElement(continueBtn);
		waitUntilClickable(excellentBtn);
		clickElement(excellentBtn);
		clickElement(VoteBtn);

	}
	
	public String communityPollresult()
	{
		return getElementText(pollResult);
	}
	
	public void logout() {
		clickElement(logoutBtn);
	}

}