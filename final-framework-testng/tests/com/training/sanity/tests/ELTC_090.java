package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.*;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC_090 {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private E2ETestPOM e2eTestPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.FIREFOX);
		loginPOM = new LoginPOM(driver);
		e2eTestPOM = new E2ETestPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
		driver.manage().window().maximize();
		
	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();
	}
//Test Case Objective:To verify whether application allows teacher to author a test for a course, student to take the test & teacher to review & send the response
	@Test
	public void E2ETest() throws InterruptedException {
		//loging in as teacher
		loginPOM.sendUserName("vivekteacher");
		loginPOM.sendPassword("QAgroup123");
		loginPOM.clickLoginBtn();
		e2eTestPOM.clickmycourse();
		e2eTestPOM.clickVivek_Selenium_CourseLink();
		e2eTestPOM.clickTests();
		//adding new test in a course
		e2eTestPOM.clickCreateANewTest_btn();
		e2eTestPOM.sendTestName("sample_selenium");
		e2eTestPOM.clickadvanceSettings_btn();
		e2eTestPOM.sendContextToTest("sample selenium");
		e2eTestPOM.clickfacebook_AtTheEndOfTest();
		e2eTestPOM.checkenableStartTime_chk();
		e2eTestPOM.clickStartTimeObj();
		e2eTestPOM.clickTime_Now_btn();
		e2eTestPOM.sendpassPercentage("50");
		e2eTestPOM.clickproceedToQuestion_btn();
		e2eTestPOM.clickmultichoiceIcon();
		//adding first question and its answer
		e2eTestPOM.sendQuestion("What is your country name?");
		e2eTestPOM.sendfirstAnswer("India");
		e2eTestPOM.sendsecondAnswer("Canada");
		e2eTestPOM.sendthirdAnswer("USA");
		e2eTestPOM.sendfourthAnswer("Russia");
		e2eTestPOM.clickfirstAndRadioButton();
		e2eTestPOM.clickaddQuestiontothetest();
		e2eTestPOM.clickmultichoiceIcon();
		//adding second question and its answer
		e2eTestPOM.sendQuestion("What is fav sport name?");
		e2eTestPOM.sendfirstAnswer("Cricket");
		e2eTestPOM.sendsecondAnswer("Football");
		e2eTestPOM.sendthirdAnswer("Tennis");
		e2eTestPOM.sendfourthAnswer("Boxing");
		e2eTestPOM.clickfirstAndRadioButton();
		e2eTestPOM.clickaddQuestiontothetest();
		e2eTestPOM.clickPreviewOption();
		e2eTestPOM.clicktoggleDropdown();
		e2eTestPOM.clicklogoutBtn();
		//loging in as student
		loginPOM.sendUserName("vv33");
		loginPOM.sendPassword("QAgroup123");
		loginPOM.clickLoginBtn();
		//searching course and subscribing to it
		e2eTestPOM.clickcourseCatalog();
		e2eTestPOM.sendsearchtextbox("Vivek_selenium");
		e2eTestPOM.clicksearch_btn();
		e2eTestPOM.clickSubscribe_Btn();
		e2eTestPOM.clickmycourse();
		e2eTestPOM.clickVivek_Selenium_CourseLink();
		//student giving test
		e2eTestPOM.clickTests();
		e2eTestPOM.clicktestName_sample_selenium();
		e2eTestPOM.clickstartTest_btn();
		e2eTestPOM.clickanswer1ofquest();
		e2eTestPOM.clicknextquestion();
		e2eTestPOM.clickanswer1ofquest();
		e2eTestPOM.clicksubmitTest();
		e2eTestPOM.clicktoggleDropdown();
		e2eTestPOM.clicklogoutBtn();
		//loging in as a teacher and grading student
		loginPOM.sendUserName("vivekteacher");
		loginPOM.sendPassword("QAgroup123");
		loginPOM.clickLoginBtn();
		e2eTestPOM.clickVivek_Selenium_CourseLink();
		e2eTestPOM.clickTests();
		e2eTestPOM.clickResultandFeedback();
		e2eTestPOM.clickgradeActivity();
		e2eTestPOM.checksendEmail();
		e2eTestPOM.clickcorrectTest();
		Assert.assertEquals((e2eTestPOM.verifyTextOnPage("Message Sent") & e2eTestPOM.verifystatus("Validated")),true,"Verifying user registered successfully");
		
		
		
		
		
		
		
		
		
		

	}

}
