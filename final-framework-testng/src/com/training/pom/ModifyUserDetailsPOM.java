package com.training.pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ModifyUserDetailsPOM {
	private WebDriver driver; 
	
	public ModifyUserDetailsPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@href='user_list.php']")
	private WebElement userList; 
	
	@FindBy(id="search_simple_keyword")
	private WebElement searchTextBox;
	
	@FindBy(id="search_simple_submit")
	private WebElement searchSubmit;
	
	@FindBy(xpath="//img[@alt='Edit']")
	private WebElement editlink_user; 
	
	@FindBy(id="user_edit_email")
	private WebElement useremail;
	
	@FindBy(xpath="//input[@name='active' and @value='0']")
	private WebElement inactiveRadioOption;
	
	@FindBy(id="user_edit_submit")
	private WebElement usereditSubmit;
	
	@FindBy(xpath="//div[@class='alert alert-info'] | //div[@class='alert alert-success']")
	public WebElement alertmessagearea;
	
	
	
	public void clickuserList() {
		userList.click();
	}
	
	public void entersearchvalue(String val) {
		this.searchTextBox.clear(); 
		this.searchTextBox.sendKeys(val); 
	}
	
	public void clicksearchSubmit() {
		searchSubmit.click();
	}
	
	public void clickeditlink_user() {
		this.editlink_user.click(); 
	}
	
	public void clearemailvalue() {
		this.useremail.clear(); 
		
	}
	
	public void enteremailvalue(String val) {
			this.useremail.sendKeys(val); 
	}
	
	public void selectinactiveradiobutton() {
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", inactiveRadioOption);
		//js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		boolean val = inactiveRadioOption.isSelected(); 
		if(val)
			js.executeScript("arguments[0].click();", inactiveRadioOption);
}
	
	public void clickusereditSubmit() {
		usereditSubmit.click();
	}
	
	public boolean f_verifalertmessage(String val) {
		boolean flag=false;
		String val1 =alertmessagearea.getText();
		if(val1.contains(val))
			flag=true;
		return flag;
	}
}
