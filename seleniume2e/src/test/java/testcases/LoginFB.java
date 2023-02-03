package testcases;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseClass;
import pageobjects.FBLoginPage;
import utility.Log;



public class LoginFB extends BaseClass
{
	
	FBLoginPage fbLoginPage;

	@Parameters("browser")
	@BeforeTest
	public void openBrowser(String browserName)
	{
		launchSite(browserName);
	}
	
	@BeforeClass
	void initPage()
	{
		fbLoginPage=new FBLoginPage();
	}
	
	@Test(priority=1)
	public void openFBLoginPage() 
	{
		
		Log.startTestcase("openFBLoginPage");
		fbLoginPage.enterUserName(prop.getProperty("username"));
		fbLoginPage.enterPassword(prop.getProperty("password"));
		fbLoginPage.clickLogin();
		Log.endTestcase("openFBLoginPage");
	}
	
	@AfterTest
	public void afterTest()
	{
		
		getDriver().close();
	
	}
	

}
