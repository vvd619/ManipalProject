package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

public class ELTC_021 {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private AddNewUserPOM addnewuserPOM;
	private DeleteCoursePOM deletecoursePOM;
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
		deletecoursePOM = new DeleteCoursePOM(driver);
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

	@Test
	public void AddNewUserAsTrainer() throws InterruptedException {
		Thread.sleep(3000);
		Assert.assertEquals(driver.getCurrentUrl(),
				"http://elearningm1.upskills.in/main/admin/index.php","Verifying user should be on Admin Page");
		screenShot.captureScreenShot("Second");
		deletecoursePOM.clickcourselist();
		Assert.assertEquals(driver.getCurrentUrl(), "http://elearningm1.upskills.in/main/admin/course_list.php",
				"Verifying user list page should be displayed");
		screenShot.captureScreenShot("Third");
		deletecoursePOM.clickdeletefirstcourse();
		Assert.assertTrue(deletecoursePOM.getalerttext().equals("Please confirm your choice"),"Verifying alert text");
		deletecoursePOM.alertAccept();
		Assert.assertTrue((deletecoursePOM.alertInfo.getText()).equals("Deleted"),"Verifying user deleted");
		
		

	}

}
