package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.HomePage;
import pages.LoginPage;

public class VerifyLoginPage {
	
	WebDriver driver;
	@BeforeMethod
	public void setUp(){
		driver = BrowserFactory.getBrowser("firefox");
		driver.get(DataProviderFactory.getConfig().getApplicatonUrl());
	}
	
	@Test
	public void testHomePage(){
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		String title = home.getTitle();
		Assert.assertTrue(title.contains("Home Page"));
		
		home.clickOnMyAccountLink();
		
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);	
		//login.loginApplication("testuser1", "testpwd1");
		login.loginApplication(DataProviderFactory.getExcel().getData(0, 0, 0)
				              ,DataProviderFactory.getExcel().getData(0, 0, 1));	
		login.verifyLogOutLink();
		
	}
	
	
	@AfterMethod
	public void tearDown(){
		BrowserFactory.closeBrowser();
	}
	
}
