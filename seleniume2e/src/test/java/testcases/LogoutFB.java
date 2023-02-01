package testcases;



import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import pageobjects.FBLoginPage;
import pageobjects.FBLogoutPage;



public class LogoutFB extends BaseClass
{
	
	FBLogoutPage fbLogoutPage;
	
	@BeforeClass
	void initPage()
	{
		fbLogoutPage=new FBLogoutPage();
	}
	
	@Test(priority=3)
	public void verifyTitle()
	{
		System.out.println(fbLogoutPage.getTitle());
		Assert.assertTrue(fbLogoutPage.getTitle().toLowerCase().contains("facebook"));
	}
	
	@Test(priority=4)
	public void logout()
	{
		fbLogoutPage.clickProfile();
		Assert.assertTrue(fbLogoutPage.clickLogout());
		
	}
	

}
