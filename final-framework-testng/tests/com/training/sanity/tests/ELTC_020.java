package com.training.sanity.tests;

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

public class ELTC_020 {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private AddNewUserPOM addnewuserPOM;
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
		addnewuserPOM = new AddNewUserPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn();
		screenShot.captureScreenShot("First");
	}

	@AfterMethod
	public void tearDown() throws Exception {
		addnewuserPOM.deletesercheduser.click();
		addnewuserPOM.alertAccept();
		Thread.sleep(1000);
		driver.quit();
	}
//Test Case Objective:To verify whether application allows admin to add new user as a trainer by entering valid credentials in mandatory fields only
	@Test
	public void AddNewUserAsTrainer() throws InterruptedException {
		//Verifying user should be on Admin Page
		Assert.assertEquals(driver.getCurrentUrl(), "http://elearningm1.upskills.in/main/admin/index.php",
				"Verifying user should be on Admin Page");
		screenShot.captureScreenShot("Second");
		addnewuserPOM.clickAddAUser();
		//Verifying Add User page should be displayed
		Assert.assertEquals(addnewuserPOM.password.isDisplayed(), true, "Verifying Add User page should be displayed");
		screenShot.captureScreenShot("Third");
		//Entering data on add user page
		addnewuserPOM.enterfirstname("vivek");
		addnewuserPOM.enterlastname("Dhotre");
		addnewuserPOM.enteremail("demo@demo.com");
		addnewuserPOM.enterphone("1234567890");
		addnewuserPOM.enteruserName("vivek1232");
		addnewuserPOM.seelctenterpassword_radio();
		addnewuserPOM.enterpassword("vivek");
		addnewuserPOM.SelectTrainerAsProfile();
		addnewuserPOM.scrollToBottomOfPage();
		addnewuserPOM.clickSubmit();
		//verifying pop up msg - The user has been added 
		Assert.assertEquals(addnewuserPOM.alertInfo.getText(), "The user has been added: vivek Dhotre",
				"verifying msg - The user has been added ");
		addnewuserPOM.entersearchCriteria("vivek1232");
		addnewuserPOM.ClickSearch();
		//Verifying user added successfully in user list
		Assert.assertEquals(addnewuserPOM.addeduser.isDisplayed(), true,
				"Verifying user added successfully in user list");

	}

}
