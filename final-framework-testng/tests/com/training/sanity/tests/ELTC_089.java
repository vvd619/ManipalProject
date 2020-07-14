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

import com.training.dataproviders.LoginDataProviders;
import com.training.dataproviders.RegisterUserDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.*;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC_089 {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private RegisterStudentDetailsPOM registerStudentDetailsPOM;
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
		registerStudentDetailsPOM = new RegisterStudentDetailsPOM(driver);
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
//Test Case Objective:TO verify whether registered student details get stored in database
	@Test(dataProvider = "db-inputs", dataProviderClass = RegisterUserDataProviders.class)
	public void RegisterStudent(String firstName, String lastName, String email,String username, String password, String confirmpassword, String phonenumber,String language) throws InterruptedException {
		//entering/selecting data on register user page
		registerStudentDetailsPOM.clicksignUpLink();
		registerStudentDetailsPOM.enterfirsttName(firstName);
		registerStudentDetailsPOM.enterlastName(lastName);
		registerStudentDetailsPOM.enteremail(email);
		registerStudentDetailsPOM.enterusername(username);
		registerStudentDetailsPOM.enterpassword(password);
		registerStudentDetailsPOM.enterconfirmpassword(confirmpassword);
		registerStudentDetailsPOM.enterphoneNumber(phonenumber);
		registerStudentDetailsPOM.scrolldowntoThePage();
		registerStudentDetailsPOM.f_SelectvalueFromLanguageList(language);
		registerStudentDetailsPOM.clickregisterSubmit();
		String str1 = "Dear "+firstName+" "+lastName;
		//Verifying Message - Dear karthik Kash,Your personal settings have been registered
		Assert.assertEquals((registerStudentDetailsPOM.verifyTextOnPage(str1) &registerStudentDetailsPOM.verifyTextOnPage("Your personal settings have been registered")), true,"Verifying user registered successfully");
	}

}
