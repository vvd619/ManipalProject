package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
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

public class ELTC_019 {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private AdminPagePOM adminPagePOM;
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
		adminPagePOM = new AdminPagePOM(driver);
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
		Thread.sleep(1000);
		driver.quit();
	}

	//Test Case Objective: To verify whether application allows admin to view details of user
	@Test
	public void UserDetails() {
		adminPagePOM.clickAdmin();
		//Verifying user should be on Admin Page
		Assert.assertEquals("http://elearningm1.upskills.in/main/admin/", driver.getCurrentUrl(),
				"Verifying user should be on Admin Page");
		screenShot.captureScreenShot("Second");
		adminPagePOM.clickuserList();
		//Verifying registed user list should be displayed
		Assert.assertEquals(adminPagePOM.searchsimplekeyword.isDisplayed(), true,
				"Verifying registed user list should be displayed");
		screenShot.captureScreenShot("Third");
		adminPagePOM.clickuser774Edit();
		boolean val = (driver.getCurrentUrl()
				.equals("http://elearningm1.upskills.in/main/admin/user_edit.php?user_id=774"))
				& (adminPagePOM.firstname.isDisplayed());
		//Verifying user details should be displayed
		Assert.assertEquals(val, true, "Verifying user details should be displayed");
		screenShot.captureScreenShot("Fourth");

	}

}
