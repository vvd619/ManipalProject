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

public class ELTC_049 {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private AddClassCoursesAndSubscribePOM addClassCoursesAndSubscribePOM;
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
		addClassCoursesAndSubscribePOM = new AddClassCoursesAndSubscribePOM(driver);
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
		addClassCoursesAndSubscribePOM.f_DeleteClass();
		driver.quit();
	}
//Test Case Objective:TO verify whether application allows admin to add classes, subscribe user to class, subscribe class to course & subscribe class to sessions
	@Test
	public void AddNewcoursandclass() throws InterruptedException {
		//Verifying user should be on Admin Page
		Assert.assertEquals(driver.getCurrentUrl(), "http://elearningm1.upskills.in/main/admin/index.php",
				"Verifying user should be on Admin Page");
		screenShot.captureScreenShot("Second");
		addClassCoursesAndSubscribePOM.f_clickClasses();
		addClassCoursesAndSubscribePOM.f_clickaddClass();
		//Adding data on add class page
		addClassCoursesAndSubscribePOM.f_Enteraddclassname("viveksel");
		addClassCoursesAndSubscribePOM.f_Enteraddclassdescription("Demo selenium");
		addClassCoursesAndSubscribePOM.f_Selectgrouppermission("Open");
		addClassCoursesAndSubscribePOM.f_clickaddclasssubmit();
		//Verifying class added successfully
		boolean val1 = addClassCoursesAndSubscribePOM.f_verifalertmessage("Item added");
		Assert.assertEquals((addClassCoursesAndSubscribePOM.f_verifyClassAdded() & val1), true,"Verifying class added successfully");
		addClassCoursesAndSubscribePOM.f_clicksubcribeusertoClassvivekSelenium();
		screenShot.captureScreenShot("Three");
		//subcribing user to Class
		addClassCoursesAndSubscribePOM.f_SelectvalueFromuseronplatformselection("962");
		addClassCoursesAndSubscribePOM.f_clickSubUserToClass_arrowRight();
		addClassCoursesAndSubscribePOM.f_clickSubUserToClass_SubmitButton();
		//Verifying user subcribed to Class
		boolean val2 = addClassCoursesAndSubscribePOM.f_verifalertmessage("Update successful");
		Assert.assertEquals((addClassCoursesAndSubscribePOM.f_verifyuserCount_vivekSelenium("1") &val2), true,"Verifying user count");
		screenShot.captureScreenShot("Fourth");
		//subcribing class to course
		addClassCoursesAndSubscribePOM.f_clicksubcribeClasstoCoursevivekSelenium();
		addClassCoursesAndSubscribePOM.f_SelectvalueFromuseronplatformselection("818");
		addClassCoursesAndSubscribePOM.f_clickSubUserToClass_arrowRight();
		addClassCoursesAndSubscribePOM.f_clickSubUserToClass_SubmitButton();
		//Verifying class subcribed to Course
		boolean val3 = addClassCoursesAndSubscribePOM.f_verifalertmessage("Update successful");
		Assert.assertEquals((addClassCoursesAndSubscribePOM.f_verifycourseCount_vivekSelenium("1") & val3), true,"Verifying course count");
		screenShot.captureScreenShot("Fifth");
		
		

	}

}
