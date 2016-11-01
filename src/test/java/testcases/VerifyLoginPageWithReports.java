package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.HomePage;
import pages.LoginPage;

public class VerifyLoginPageWithReports {
	
	WebDriver driver;
	
	ExtentReports report;
	ExtentTest logger;
	
	
	
	@BeforeMethod
	public void setUp(){
		
		report = new ExtentReports("./Reports/LoginPageReport.html", true);
		logger = report.startTest("Verify Login Page");
		
		driver = BrowserFactory.getBrowser("firefox");
		driver.get(DataProviderFactory.getConfig().getApplicatonUrl());	
		logger.log(LogStatus.INFO, "Application is up and running");
	}
	
	@Test
	public void testHomePage(){
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		String title = home.getTitle();
		Assert.assertTrue(title.contains("Home Page"));
		logger.log(LogStatus.PASS, "Home page loaded succesfully and verified");
		
		home.clickOnMyAccountLink();
		logger.log(LogStatus.INFO, "Click on MyAccountLink");
		
		
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);	
		//login.loginApplication("testuser1", "testpwd1");
		login.loginApplication(DataProviderFactory.getExcel().getData(0, 0, 0)
				              ,DataProviderFactory.getExcel().getData(0, 0, 1));	
		logger.log(LogStatus.INFO, "Login to application");
		login.verifyLogOutLink();
		logger.log(LogStatus.PASS, "LogOutLink is present");
		
	}
	
	
	@AfterMethod
	public void tearDown(){
		BrowserFactory.closeBrowser();
		report.endTest(logger);
		report.flush();
	}
	
}
