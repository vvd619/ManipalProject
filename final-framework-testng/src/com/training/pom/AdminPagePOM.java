package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPagePOM {
private WebDriver driver; 
	
	public AdminPagePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(@href,'user_list.php')]")
	public WebElement userList; 
	
	@FindBy(xpath="//a[@title='Administration']")
	public WebElement Administartion;
	
	@FindBy(xpath="//a[contains(@href,'admin/user_edit.php?user_id=774')]")
	public WebElement user774Edit; 
	
	@FindBy(id="user_edit_firstname")
	public WebElement firstname; 
	
	@FindBy(id="user_edit_lastname")
	public WebElement lastname; 
	
	@FindBy(id="user_edit_email")
	public WebElement email; 
	
	@FindBy(id="search_simple_keyword")
	public WebElement searchsimplekeyword; 
	
	public void clickuserList() {
		userList.click();
	}
	
	public void clickAdmin() {
		Administartion.click();
	}
	
	public void clickuser774Edit() {
		user774Edit.click();
	}
	

}
