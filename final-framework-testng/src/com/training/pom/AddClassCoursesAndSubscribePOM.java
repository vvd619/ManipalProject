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


public class AddClassCoursesAndSubscribePOM {
private WebDriver driver; 

	
	public AddClassCoursesAndSubscribePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(@href,'usergroups.php')]")
	public WebElement classes; 
	
	@FindBy(xpath="//img[@title='Add classes']")
	public WebElement addClass;
	
	@FindBy(id="usergroup_name")
	public WebElement addclass_name; 
	
	@FindBy(id="usergroup_description")
	public WebElement addclass_description; 
	
	@FindBy(xpath="//button[@data-id='usergroup_visibility']")
	public WebElement addclass_groupPermission; 
	
	@FindBy(id="usergroup_submit")
	public WebElement addclass_submit; 
	
	@FindBy(xpath="//div[@class='alert alert-info'] | //div[@class='alert alert-success']")
	public WebElement alertmessagearea; 
	
	@FindBy(xpath="//td[contains(text(),'viveksel')]")
	public WebElement addedclassname_vivekSelenium; 
	
	@FindBy(xpath="//td[@title='viveksel']/ancestor::tr/td[2]/a")
	public WebElement userCount_vivekSelenium; 
	
	@FindBy(xpath="//td[@title='viveksel']/ancestor::tr/td[3]")
	public WebElement CoursesCount_vivekSelenium; 
	
	@FindBy(xpath="//span[@class='ui-icon ui-icon-seek-next']")
	public WebElement pagenext; 
	
	@FindBy(xpath="//td[@title='viveksel']/ancestor::tr/td[6]/a[1]")
	public WebElement subcribeusertoclass_vivekSelenium; 
	
	@FindBy(xpath="//td[@title='viveksel']/ancestor::tr/td[6]/a[5]")
	public WebElement delete_vivekSelenium; 
	
	@FindBy(xpath="//td[@title='viveksel']/ancestor::tr/td[6]/a[2]")
	public WebElement subcribeClasstoCourse_vivekSelenium; 
	
	@FindBy(id="elements_not_in")
	public WebElement useronplatformselection; 
	
	@FindBy(xpath="//em[@class='fa fa-arrow-right']")
	public WebElement SubUserToClass_arrowRight;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	public WebElement SubUserToClass_SubmitButton;
	
	
	public void f_clickClasses() {
		classes.click();
	}
	
	public void f_clickaddClass() {
		addClass.click();
	}
	
	public void f_Enteraddclassname(String str) {
		addclass_name.clear();
		addclass_name.sendKeys(str);
	}
	
	public void f_Enteraddclassdescription(String str) {
		addclass_description.clear();
		addclass_description.sendKeys(str);
	}
	
	public void f_Selectgrouppermission(String str) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		js.executeScript("arguments[0].click();", addclass_groupPermission);
		Actions action = new Actions(driver); 
		if(str.equalsIgnoreCase("Open")) {
		action.sendKeys(Keys.ARROW_UP).build().perform();
		action.sendKeys(Keys.ENTER).build().perform();
		}
	}
	
	public void f_clickaddclasssubmit() {
		addclass_submit.click();
	}

	public boolean f_verifyClassAdded() {
		boolean flag = false;
		for(int i=0;i<8;i++) {
			if(addedclassname_vivekSelenium.isDisplayed()) {
				flag=true;
				break;
			}
			pagenext.click();
		}
		return flag;

		}
	
	public void f_DeleteClass() {
		for(int i=0;i<8;i++) {
			if(delete_vivekSelenium.isDisplayed()) {
				delete_vivekSelenium.click();
				Alert alt = driver.switchTo().alert();
				alt.accept();				
				break;
			}
			pagenext.click();
		}

		}
	
	
	public void f_clicksubcribeusertoClassvivekSelenium() {
		subcribeusertoclass_vivekSelenium.click();
	}

	public void f_SelectvalueFromuseronplatformselection(String str) throws InterruptedException {
		Thread.sleep(3000);
		Select sel = new Select(useronplatformselection);
		sel.selectByValue(str);;
		
	}
	
	public void f_clickSubUserToClass_arrowRight() {
		SubUserToClass_arrowRight.click();
	}
	
	public void f_clickSubUserToClass_SubmitButton() {
		SubUserToClass_SubmitButton.click();
	}
	
	public boolean f_verifyuserCount_vivekSelenium(String val) {
		boolean flag=false;
		String val1 =userCount_vivekSelenium.getText();
		if(val1.equals(val))
			flag=true;
		return flag;
	}
	
	public void f_clicksubcribeClasstoCoursevivekSelenium() {
		subcribeClasstoCourse_vivekSelenium.click();
	}
	
	public boolean f_verifycourseCount_vivekSelenium(String val) {
		boolean flag=false;
		String val1 =CoursesCount_vivekSelenium.getText();
		if(val1.equals(val))
			flag=true;
		return flag;
	}
	
	public boolean f_verifalertmessage(String val) {
		boolean flag=false;
		String val1 =alertmessagearea.getText();
		if(val1.contains(val))
			flag=true;
		return flag;
	}
	

}
