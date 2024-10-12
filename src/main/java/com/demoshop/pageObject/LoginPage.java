package com.demoshop.pageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoshop.utils.PageActions;
import com.demoshop.utils.WaitUtils;

public class LoginPage extends PageActions {
	
private WebDriver driver;
JavascriptExecutor js = (JavascriptExecutor)driver;

	
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);

		
	}
	
	@FindBy(xpath="//a[@class='ico-login']")
	private WebElement loginHeader;
	
	@FindBy(xpath="//a[@class='ico-register']")
	private WebElement registerHeader;
	
	@FindBy(xpath="//*[@id='Email']")
	private WebElement emailInput;
	
	@FindBy(id="Password")
	private WebElement passwordInput;
	

	@FindBy(xpath="//*[@class='buttons']/*[@value='Log in']")
	private WebElement loginBtn;
	
	@FindBy(css=".account")
	private WebElement loggedEmail;
	
	@FindBy(id="newsletter-email")
	private WebElement newsLetterEmail;
	
	@FindBy(id="newsletter-subscribe-button")
	private WebElement newsLetterSubscribeBtn;
	
	@FindBy(id="newsletter-result-block")
	private WebElement newsLetterSubscribeText;
	
	@FindBy(id="small-searchterms")
	private WebElement searchInput;
	
	@FindBy(css="[value='Search']")
	private WebElement searchBtn;
	
	@FindBy(xpath="//*[@class='list'] /li[4]\r\n"
			+ "")
	private WebElement apparelShoesMenu;
	
	@FindBy(xpath="//*[contains(text(),'Blog')]")
	public WebElement desiredElement;
	
	@FindBy(xpath="//*[contains(text(),'Comments')]")
	public WebElement comment;
	
	@FindBy(css="#AddNewComment_CommentText")
	public WebElement commentText;
	
	@FindBy(css="[value=\"New comment\"]")
	public WebElement addComment;	
	
	@FindBy(xpath="(//div[@class=\"comment-body\"])[last()]")
	public WebElement desiredElement2;

		
	public void navigateToLoginSection() {
		clickElement(loginHeader);
	}
	
	public void navigateToRegisterationSection() {
		//registerHeader.click();
		clickElement(registerHeader);
	}
	
	public void login(String email, String pass) {
		emailInput.sendKeys(email);
        passwordInput.sendKeys(pass);
       // loginBtn.click();
      /*  setTextBox(emailInput, email);
		setTextBox(passwordInput, pass);*/
        clickElement(loginBtn);
	}
	
	public String getLoggedEmail() {
		//return loggedEmail.getText();
		return getElementText(loggedEmail);
	}
	
	public String verifyNewsLetterEmail(String uniqueEmail,String expectedText) throws InterruptedException {
	/*	newsLetterEmail.sendKeys(uniqueEmail);
		newsLetterSubscribeBtn.click();
		Thread.sleep(2000);
		return newsLetterSubscribeText.getText();*/
		setTextBox(newsLetterEmail, uniqueEmail);
	    clickElement(newsLetterSubscribeBtn);
	//	waitUntilVisible(newsLetterSubscribeText);
		//Thread.sleep(2000);
	    WaitUtils.waitUntilTextShows(newsLetterSubscribeText, driver, expectedText);
		return getElementText(newsLetterSubscribeText);
	}
	
	public void searchProduct(String productName)
	{
		setTextBox(searchInput,productName);
		clickElement(searchBtn);
	}
	public void aparelShoesMenu()
	{
		clickElement(apparelShoesMenu);
		}
	public void selectBlog()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", desiredElement);
		clickElement(desiredElement);
	}
	public void clickComment()
	{
		clickElement(comment);
	
		}
	public void addComment() {
	 setTextBox(commentText,"Great info"); 
	 clickElement(addComment);
		
	}
	public String checkAddedComment() {
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView(true);", desiredElement2);
	return getElementText(desiredElement2);

}
}
