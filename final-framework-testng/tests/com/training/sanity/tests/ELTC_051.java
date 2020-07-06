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

public class ELTC_051 {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private ModifyUserDetailsPOM modifyUserDetailsPOM;
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
		modifyUserDetailsPOM = new ModifyUserDetailsPOM(driver);
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
		driver.quit();
	}
//Test Case Objective:TO verify whether application allows admin to add classes, subscribe user to class, subscribe class to course & subscribe class to sessions
	@Test
	public void AddNewcoursandclass() throws InterruptedException {
		//Verifying user should be on Admin Page
		Assert.assertEquals(driver.getCurrentUrl(), "http://elearningm1.upskills.in/main/admin/index.php",
				"Verifying user should be on Admin Page");
		screenShot.captureScreenShot("Second");
		//clicking user list link
		modifyUserDetailsPOM.clickuserList();
		//entering value in search sriteria
		modifyUserDetailsPOM.entersearchvalue("Simba");
		modifyUserDetailsPOM.clicksearchSubmit();
		//click edit link of user
		modifyUserDetailsPOM.clickeditlink_user();
		//Clear email text value
		modifyUserDetailsPOM.clearemailvalue();
		//enter email text value
		modifyUserDetailsPOM.enteremailvalue("val@v.com");
		//clicking selecting radio option
		modifyUserDetailsPOM.selectinactiveradiobutton();
		//Clcking submit option
		modifyUserDetailsPOM.clickusereditSubmit();
		//Verifying user information updated successfully
		Assert.assertEquals(modifyUserDetailsPOM.f_verifalertmessage("User updated: Simba V (simba)"), true,"Verifying user information updated successfully");
		
		
		

	}

}
