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


public class AddNewUserPOM {
private WebDriver driver; 
JavascriptExecutor js = (JavascriptExecutor)driver;
	
	public AddNewUserPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(@href,'user_add.php')]")
	public WebElement addAuser; 
	
	@FindBy(xpath="//a[@title='Administration']")
	public WebElement Administartion;
	
	@FindBy(id="firstname")
	public WebElement firstName; 
	
	@FindBy(id="lastname")
	public WebElement lastName; 
	
	@FindBy(id="email")
	public WebElement email; 
	
	@FindBy(id="phone")
	public WebElement phone; 
	
	@FindBy(id="username")
	public WebElement userName; 
	
	@FindBy(xpath="//input[contains(@name,password) and @value='0']")
	public WebElement enterpassword; 
	
	@FindBy(id="password")
	public WebElement password; 
	
	@FindBy(xpath="//button[@data-id='status_select']")
	public WebElement profile; 
	
	@FindBy(xpath="//button[@name='submit']")
	public WebElement submit;
	
	@FindBy(xpath="//div[@class='alert alert-info']")
	public WebElement alertInfo;
	
	
	@FindBy(id="search_simple_keyword")
	public WebElement searchbox;
	
	@FindBy(id="search_simple_submit")
	public WebElement serachSubmit;
	
	@FindBy(xpath="//img[@alt='vivek Dhotre']")
	public WebElement addeduser;
	
	@FindBy(xpath="//img[@alt='Delete']")
	public WebElement deletesercheduser;
	
	
	public void clickAddAUser() {
		addAuser.click();
	}
	
	public void enterfirstname(String firstname) {
		firstName.clear();
		firstName.sendKeys(firstname);
	}
	
	public void enterlastname(String lastname) {
		lastName.clear();
		lastName.sendKeys(lastname);
	}
	
	public void enteremail(String val) {
		email.clear();
		email.sendKeys(val);
	}
	
	public void enterphone(String val) {
		phone.clear();
		phone.sendKeys(val);
	}
	
	public void enteruserName(String val) {
		userName.clear();
		userName.sendKeys(val);
	}
	
	public void seelctenterpassword_radio() {
		enterpassword.click();
	}
	
	public void enterpassword(String val) {
		password.clear();
		password.sendKeys(val);
	}
	
	public void selectProfileBytext(String val) {
		Select sel = new Select(profile);
		sel.selectByVisibleText(val);
	}
	
	public void clickSubmit() {
		submit.click();
	}
	
	public void entersearchCriteria(String val) {
		searchbox.clear();
		searchbox.sendKeys(val);
	}
	
	public void ClickSearch() {
		serachSubmit.click();
	}
	
	public void alertAccept() {
		Alert alt = driver.switchTo().alert();
		alt.accept();
		driver.switchTo().defaultContent();
	}

	public void SelectTrainerAsProfile() {
		js. executeScript("arguments[0]. scrollIntoView(true);", profile);
		js.executeScript("arguments[0].click();", profile);
		Actions action = new Actions(driver); 
		action.sendKeys(Keys.ARROW_UP).build().perform();
		action.sendKeys(Keys.ENTER).build().perform();
	}
	
	public void scrollToBottomOfPage() {
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

}
