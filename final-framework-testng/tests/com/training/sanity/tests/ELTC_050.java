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

public class ELTC_050 {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private CreateTrainingSessionPOM createTrainingSessionPOM;
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
		createTrainingSessionPOM = new CreateTrainingSessionPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
		driver.manage().window().maximize();
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn();
		screenShot.captureScreenShot("First");
	}

	@AfterMethod
	public void tearDown() throws Exception {
		createTrainingSessionPOM.deletesessionList("vivek");
		driver.quit();
	}
//Test Case Objective:TO verify whether application allows admin to add classes, subscribe user to class, subscribe class to course & subscribe class to sessions
	@Test
	public void AddNewcoursandclass() throws InterruptedException {
		//Verifying user should be on Admin Page
		Assert.assertEquals(driver.getCurrentUrl(), "http://elearningm1.upskills.in/main/admin/index.php",
				"Verifying user should be on Admin Page");
		screenShot.captureScreenShot("Second");
		createTrainingSessionPOM.clickaddTrainingSession();
		//Adding data on add training session page
		createTrainingSessionPOM.entersessionName("Vivek Selenium");
		createTrainingSessionPOM.entercouchname("sele");
		createTrainingSessionPOM.clicksessionSubmitNextStep();
		//selecting course list
		createTrainingSessionPOM.f_SelectvalueFromCourseList("818");
		createTrainingSessionPOM.clickaddCoursearrow();
		createTrainingSessionPOM.clickaddCourseNextStep();
		//subscribing user 
		createTrainingSessionPOM.enteraddusertoseesionsearchbox("sunil");
		createTrainingSessionPOM.clickfinishsessioncreation();
		
		//Verifying session added successfully
		boolean val1 = createTrainingSessionPOM.f_verifalertmessage("Update successful");
		Assert.assertEquals((createTrainingSessionPOM.f_verifycourseTitle("abcd (ABCD)") & val1), true,"Verifying session added successfully");
		
		
		

	}

}
