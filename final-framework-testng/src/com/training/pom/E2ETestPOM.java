package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class E2ETestPOM {
	private WebDriver driver; 
	
	public E2ETestPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'My courses')]")
	private WebElement myCourse; 
	

	@FindBy(xpath="//a[contains(@href,'http://elearningm1.upskills.in/courses/VIVEKSELENIUM/')]")
	private WebElement Vivek_Selenium_CourseLink; 
	
	@FindBy(id="toolimage_21053")
	private WebElement Tests;
	
	@FindBy(xpath="//a[@class='btn btn-primary']")
	private WebElement CreateANewTest_btn; 
	
	@FindBy(id="exercise_title")
	private WebElement TestName; 
	
	@FindBy(id="advanced_params")
	private WebElement advanceSettings_btn;
	
	@FindBy(xpath="//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")
	private WebElement ContextToTest; 
	
	@FindBy(id="exerciseType_0")
	private WebElement facebook_AtTheEndOfTest;
	
	@FindBy(name="activate_start_date_check")
	private WebElement enableStartTime_chk; 
	
	@FindBy(xpath="//p[@id='start_time_alt_text']")
	private WebElement StartTime; 
	
	
	@FindBy(xpath="//button[@class='ui-datepicker-current ui-state-default ui-priority-secondary ui-corner-all']")
	private WebElement Time_Now_btn; 
	
	
	@FindBy(id="pass_percentage")
	private WebElement passPercentage; 
	
	@FindBy(id="exercise_admin_submitExercise")
	private WebElement proceedToQuestion_btn;
	
	@FindBy(xpath="//img[@title='Multiple choice']")
	private WebElement multichoiceIcon; 
	
	@FindBy(id="question_admin_form_questionName")
	private WebElement Question; 
	
	@FindBy(xpath="//html//body")
	private WebElement firstAnswer;
	
	
	@FindBy(xpath="//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")
	private WebElement secondAnswer;
	
	@FindBy(xpath="//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")
	private WebElement thirdAnswer;
	
	@FindBy(xpath="//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")
	private WebElement fourthAnswer;
	
	@FindBy(xpath="//input[@type='radio' and @value='1']")
	private WebElement firstAndRadioButton; 
	
	@FindBy(id="submit-question")
	private WebElement addQuestiontothetest; 
	
	@FindBy(xpath="//img[@title='Preview']")
	private WebElement PreviewOption;
	
	@FindBy(xpath="//a[@class='btn btn-success btn-large']")
	private WebElement startTest_btn; 
	
	@FindBy(xpath="//span[@class='caret']")
	private WebElement toggleDropdown; 
	
	@FindBy(id="logout_button")
	private WebElement logoutBtn;
	
	@FindBy(xpath="//a[contains(@href,'courses.php') and @xpath='2']")
	private WebElement courseCatalog; 
	
	@FindBy(name="search_term")
	private WebElement searchtextbox; 
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement search_btn;
	
	@FindBy(xpath="//a[@title='Subscribe']")
	private WebElement Subscribe_Btn; 
	
	@FindBy(xpath="//a[contains(text(),'sample_selenium')]")
	private WebElement testName_sample_selenium;
	
	@FindBy(xpath="(//div[@class='question_options']/label/input)[1]")
	private WebElement answer1ofquest; 
	
	
	@FindBy(name="save_now")
	private WebElement nextquestion; 
	
	
	@FindBy(name="save_now")
	private WebElement submitTest; 
	
	@FindBy(xpath="//img[@title='Results and feedback']")
	private WebElement ResultandFeedback;
	
	@FindBy(xpath="//img[@title='Grade activity']")
	private WebElement gradeActivity;
	
	@FindBy(name="send_notification")
	private WebElement sendEmail;
	
	@FindBy(id="form-email_submit")
	private WebElement correctTest;
	
	@FindBy(xpath="//span[@class='label label-success']")
	private WebElement validated_key;
	
	public void clickmycourse() {
		this.myCourse.click(); 
	}
	

	
	
	public void clickVivek_Selenium_CourseLink() {
		Vivek_Selenium_CourseLink.click();
	}
	
	public void clickTests() {
		Tests.click();
	}
	
	public void clickCreateANewTest_btn() {
		CreateANewTest_btn.click();
	}
	public void sendTestName(String testName) {
		this.TestName.clear(); 
		this.TestName.sendKeys(testName); 
	}
	
	public void clickadvanceSettings_btn() throws InterruptedException {
		this.advanceSettings_btn.click(); 
		Thread.sleep(3000);
	}
	
	public void sendContextToTest(String val) throws InterruptedException {
		Thread.sleep(5000);
		driver.switchTo().frame(0);
		this.ContextToTest.clear(); 
		this.ContextToTest.sendKeys(val); 
		driver.switchTo().defaultContent();
	}
	
	public void clickfacebook_AtTheEndOfTest() {
		
			this.facebook_AtTheEndOfTest.click();
	}
	
	public void checkenableStartTime_chk() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", enableStartTime_chk);
		if(!enableStartTime_chk.isSelected())
			enableStartTime_chk.click();
	}
	
	public void clickStartTimeObj() {
		this.StartTime.click(); 
	}
	
	public void clickTime_Now_btn() {
		this.Time_Now_btn.click(); 
	}
	
	public void sendpassPercentage(String val) {
		this.passPercentage.clear(); 
		this.passPercentage.sendKeys(val); 
	}
	
	public void clickproceedToQuestion_btn() {
		this.proceedToQuestion_btn.click(); 
	}
	
	public void clickmultichoiceIcon() {
		this.multichoiceIcon.click(); 
	}
	
	public void sendQuestion(String val) {
		this.Question.clear(); 
		this.Question.sendKeys(val); 
	}
	
	public void sendfirstAnswer(String val) {
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//input[@id='question_admin_form_weighting[1]']")));
		driver.switchTo().frame(0);
		this.firstAnswer.clear(); 
		this.firstAnswer.sendKeys(val); 
		driver.switchTo().defaultContent();
	}
	
	public void sendsecondAnswer(String val) {
		this.secondAnswer.clear(); 
		this.secondAnswer.sendKeys(val); 
	}
	
	public void sendthirdAnswer(String val) {
		this.thirdAnswer.clear(); 
		this.thirdAnswer.sendKeys(val); 
	}
	
	public void sendfourthAnswer(String val) {
		this.fourthAnswer.clear(); 
		this.fourthAnswer.sendKeys(val); 
	}
	
	public void clickfirstAndRadioButton() {
		this.firstAndRadioButton.click(); 
	}
	
	public void clickaddQuestiontothetest() {
		this.addQuestiontothetest.click(); 
	}
	
	public void clickPreviewOption() {
		this.PreviewOption.click(); 
	}
	
	public void clickstartTest_btn() {
		this.startTest_btn.click(); 
	}
	
	public void clicktoggleDropdown() {
		this.toggleDropdown.click(); 
	}
	
	public void clicklogoutBtn() {
		this.logoutBtn.click(); 
	}
	
	public void clickcourseCatalog() {
		this.courseCatalog.click(); 
	}
	
	public void sendsearchtextbox(String val) {
		this.searchtextbox.clear(); 
		this.searchtextbox.sendKeys(val); 
	}
	
	public void clicksearch_btn() {
		this.search_btn.click(); 
	}
	
	public void clickSubscribe_Btn() {
		if(Subscribe_Btn.isEnabled())
		this.Subscribe_Btn.click(); 
	}
	
	public void clicktestName_sample_selenium() {
		this.testName_sample_selenium.click(); 
	}
	
	public void clickanswer1ofquest() {
		this.answer1ofquest.click(); 
	}
	
	public void clicknextquestion() {
		this.nextquestion.click(); 
	}
	
	public void clicksubmitTest() {
		this.submitTest.click(); 
	}
	
	public void clickResultandFeedback() {
		this.ResultandFeedback.click(); 
	}
	
	public void clickgradeActivity() {
		this.gradeActivity.click(); 
	}
	
	public void checksendEmail() {
		
		if(sendEmail.isSelected())
			sendEmail.click();
	}
	
	public void clickcorrectTest() {
		this.correctTest.click(); 
	}
	
	public boolean verifyTextOnPage(String str) {
		boolean flag = false;
		String bodyText = driver.findElement(By.tagName("body")).getText();
		if(bodyText.contains(str))
			flag=true;
		return flag;
	}
	
	public boolean verifystatus( String val) {
		boolean flag = false;
		if (this.validated_key.getText().equalsIgnoreCase(val))
			flag=true;
		return flag;
			
					
	}

}
