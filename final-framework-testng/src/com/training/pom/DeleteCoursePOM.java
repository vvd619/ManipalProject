package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteCoursePOM {
	private WebDriver driver; 
	
	public DeleteCoursePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@href='course_list.php']")
	public WebElement courselist; 
	
	@FindBy(xpath="(//img[@alt='Delete'])[1]")
	public WebElement deletefirstcourse;
	
	@FindBy(xpath="//a[@xpath='1']")
	public WebElement firstcoursename; 
	
	@FindBy(xpath="//div[@class='alert alert-info']")
	public WebElement alertInfo;
	
	public void clickcourselist() {
		this.courselist.click(); 
	}
	
	public void clickdeletefirstcourse() {
		this.deletefirstcourse.click(); 
	}
	
	public String getalerttext() {
		Alert alt = driver.switchTo().alert();
		String str =alt.getText();
		return str;
		
	}
	
	public void alertAccept() {
		Alert alt = driver.switchTo().alert();
		alt.accept();
		driver.switchTo().defaultContent();
	}
}
