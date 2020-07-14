package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegisterStudentDetailsPOM {
	private WebDriver driver; 
	
	public RegisterStudentDetailsPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Sign up')]")
	private WebElement signUpLink;
	
	@FindBy(xpath="//input[@name='status' and @value='5']")
	private WebElement followCourse;
	
	
	@FindBy(id="registration_firstname")
	private WebElement firstName;


	@FindBy(id="registration_lastname")
	private WebElement lastName;
	
	
	@FindBy(id="registration_email")
	private WebElement email;
	
	
	@FindBy(id="username")
	private WebElement username;
	
	@FindBy(id="pass1")
	private WebElement password; 
	
	@FindBy(id="pass2")
	private WebElement confirmpassword; 
	
	@FindBy(id="registration_phone")
	private WebElement phone; 
	
	@FindBy(xpath="//div[@class='filter-option']")
	private WebElement languageobject;
	
	@FindBy(xpath="//div[@class='bs-searchbox']//input[@class='form-control']")
	private WebElement languagesearchbox;
	
	
	@FindBy(id="registration_submit")
	private WebElement registerSubmit; 
	
	
	@FindBy(xpath="//span[@class='caret']")
	private WebElement toggleDropdown; 
	
	@FindBy(id="logout_button")
	private WebElement logoutBtn; 
	
	@FindBy(xpath="//a[@href='http://elearningm1.upskills.in/main/auth/profile.php']")
	private WebElement editProfile; 
	
	@FindBy(xpath="//div[@class='email-overflow']")
	private WebElement emailoneditpage; 
	
		
	public void clicksignUpLink() {
		signUpLink.click();
	}
	
	public void clickfollowCourse() {
		followCourse.click();
	}
	
	public void enterfirsttName(String str) {
		firstName.clear();
		firstName.sendKeys(str);
	}
	public void enterlastName(String str) {
		lastName.clear();
		lastName.sendKeys(str);
	}
	public void enterphoneNumber(String str) {
		phone.clear();
		phone.sendKeys(str);
	}
	public void enteremail(String str) {
		email.clear();
		email.sendKeys(str);
	}
	
	public void enterusername(String str) {
		username.clear();
		username.sendKeys(str);
	}
	
	public void enterpassword(String str) {
		password.clear();
		password.sendKeys(str);
	}
	
	public void enterconfirmpassword(String str) {
		confirmpassword.clear();
		confirmpassword.sendKeys(str);
	}
	
	public void clickregisterSubmit() {
		registerSubmit.click(); 
	}
	
	public void f_SelectvalueFromLanguageList(String str) throws InterruptedException {
		Thread.sleep(3000);
		languageobject.click();
		languagesearchbox.sendKeys(str);
		Thread.sleep(3000);
		Actions action = new Actions(driver); 
		action.sendKeys(Keys.ENTER).build().perform();
	}
	
	public void clicktoggleDropdown() {
		toggleDropdown.click(); 
	}
	
	public void clicklogoutBtn() {
		logoutBtn.click(); 
	}
	
	public void clickeditProfile() {
		editProfile.click(); 
	}
	
	public void scrolldowntoThePage() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	
	public boolean verifyTextOnPage(String str) {
		boolean flag = false;
		String bodyText = driver.findElement(By.tagName("body")).getText();
		if(bodyText.contains(str))
			flag=true;
		return flag;
	}
	
}
