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

	@Test
	public void AddNewUserAsTrainer() throws InterruptedException {
		Thread.sleep(3000);
		Assert.assertEquals(driver.getCurrentUrl(),
				"http://elearningm1.upskills.in/main/admin/index.php","Verifying user should be on Admin Page");
		screenShot.captureScreenShot("Second");
		addnewuserPOM.clickAddAUser();
		Assert.assertEquals(addnewuserPOM.password.isDisplayed(), true,
				"Verifying Add User page should be displayed");
		screenShot.captureScreenShot("Third");
		addnewuserPOM.enterfirstname("vivek");
		//String str = driver.findElement(By.id("firstname")).getText();
		Assert.assertTrue((addnewuserPOM.firstName.getText().equals("vivek")),"Verifying entered first name displays as entered");
		addnewuserPOM.enterlastname("Dhotre");
		//Assert.assertTrue((addnewuserPOM.lastName.getText().equals("Dhotre")),"Verifying entered last name displays as entered");
		addnewuserPOM.enteremail("demo@demo.com");
		//Assert.assertTrue((addnewuserPOM.email.getText().equals("demo@demo.com")),"Verifying entered email displays as entered");
		addnewuserPOM.enterphone("1234567890");
		//Assert.assertTrue((addnewuserPOM.phone.getText().equals("1234567890")),"Verifying entered Phone number displays as entered");
		addnewuserPOM.enteruserName("vivek1232");
		//Assert.assertTrue((addnewuserPOM.userName.getText().equals("vivek1232")),"Verifying entered user name displays as entered");
		addnewuserPOM.seelctenterpassword_radio();
		//Assert.assertTrue(addnewuserPOM.enterpassword.isSelected(),"Verifying entered user name displays as entered");
		addnewuserPOM.enterpassword("vivek");
		//Assert.assertTrue((addnewuserPOM.password.getText().equals("vivek")),"Verifying entered password displays as entered");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js. executeScript("arguments[0]. scrollIntoView(true);", driver.findElement(By.xpath("//button[@data-id='status_select']")));
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//button[@data-id='status_select']")));
		Actions action = new Actions(driver); 
		action.sendKeys(Keys.ARROW_UP).build().perform();
		action.sendKeys(Keys.ENTER).build().perform();
		
		//addnewuserPOM.selectProfileBytext("Trainer");
		//Select select = new Select(addnewuserPOM.profile);
		//WebElement option = select.getFirstSelectedOption();
		//Assert.assertTrue((option.getText().equals("Trainer")),"Verifying selected profile");
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		addnewuserPOM.clickSubmit();
		Assert.assertEquals(addnewuserPOM.alertInfo.getText(), "The user has been added: vivek Dhotre", "verifying msg - The user has been added ");
		addnewuserPOM.entersearchCriteria("vivek1232");
		addnewuserPOM.ClickSearch();
		Assert.assertEquals(addnewuserPOM.addeduser.isDisplayed(), true,"Verifying user added successfully in user list");
		
		
		

	}

}
