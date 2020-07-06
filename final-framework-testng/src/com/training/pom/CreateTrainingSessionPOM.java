package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateTrainingSessionPOM {
	private WebDriver driver; 
	
	public CreateTrainingSessionPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(@href,'session_list.php')]")
	private WebElement TrainingSessionList;
	
	@FindBy(id="search_simple_keyword")
	private WebElement sessionsearchbox;
	
	
	@FindBy(id="search_simple_submit")
	private WebElement searchButton;


	@FindBy(xpath="//img[@alt='Delete']")
	private WebElement deleteSession;
	
	
	@FindBy(xpath="//a[@href='http://elearningm1.upskills.in/main/session/session_add.php']")
	private WebElement addTrainingSession;
	
	
	@FindBy(id="add_session_name")
	private WebElement sessionName;
	
	@FindBy(id="select2-coach_username-container")
	private WebElement coachNameObject; 
	
	
	@FindBy(xpath="//input[@class='select2-search__field']")
	private WebElement coachName; 
	
	@FindBy(id="add_session_submit")
	private WebElement sessionSubmitNextStep;
	
	@FindBy(id="origin")
	private WebElement courseList; 
	
	
	@FindBy(name="add_course")
	private WebElement addCoursearrow; 
	
	@FindBy(name="next")
	private WebElement addCourseNextStep; 
	
	@FindBy(id="user_to_add")
	private WebElement addusertoseesionsearchbox; 
	
	@FindBy(name="next")
	private WebElement finishsessioncreation; 
	
	@FindBy(xpath="//div[@class='alert alert-info'] | //div[@class='alert alert-success']")
	public WebElement alertmessagearea; 
	
	@FindBy(xpath="//button[@class='close']")
	public WebElement addpopupclose; 
	
	@FindBy(xpath="//a[contains(@href,'http://elearningm1.upskills.in/courses/ABCD/index.php?id_session')]")
	public WebElement courseTitle;
	
	public void entersessionName(String name) {
		this.sessionName.clear();
		this.sessionName.sendKeys(name);
	}
	
	public void entercouchname(String name) throws InterruptedException {
		Thread.sleep(3000);
		coachNameObject.click();
		coachName.sendKeys("sele");
		Thread.sleep(3000);
		Actions action = new Actions(driver); 
		action.sendKeys(Keys.ENTER).build().perform();
	}
	
	public void clickaddTrainingSession() throws InterruptedException {
		if(addpopupclose.isDisplayed())
			addpopupclose.click();
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		js.executeScript("arguments[0].click();", addTrainingSession);
		//this.addTrainingSession.click(); 
	}
	
	public void clicksessionSubmitNextStep() {
		this.sessionSubmitNextStep.click(); 
	}
	
	public void f_SelectvalueFromCourseList(String str) {
		Select sel = new Select(courseList);
		sel.selectByValue(str);
		
	}
	
	public void clickaddCoursearrow() {
		this.addCoursearrow.click(); 
	}
	
	public void clickaddCourseNextStep() {
		this.addCourseNextStep.click(); 
	}
	
	public void enteraddusertoseesionsearchbox(String str) {
		addusertoseesionsearchbox.sendKeys(str);
		Actions action = new Actions(driver); 
		action.sendKeys(Keys.TAB).build().perform();
		action.sendKeys(Keys.ENTER).build().perform();
		
	}
	
	public void clickfinishsessioncreation() {
		this.finishsessioncreation.click(); 
	}
	
	public boolean f_verifalertmessage(String val) {
		boolean flag=false;
		String val1 =alertmessagearea.getText();
		if(val1.contains(val))
			flag=true;
		return flag;
	}
	
	public boolean f_verifycourseTitle(String val) {
		boolean flag=false;
		String val1 =courseTitle.getText();
		if(val1.contains(val))
			flag=true;
		return flag;
	}
	public void deletesessionList(String str) throws InterruptedException {
		TrainingSessionList.click();
		sessionsearchbox.sendKeys(str);
		searchButton.click();
		Thread.sleep(5000);
		if(deleteSession.isDisplayed())
		{
			deleteSession.click();
			Alert alt = driver.switchTo().alert();
			alt.accept();
		}
	}
}
