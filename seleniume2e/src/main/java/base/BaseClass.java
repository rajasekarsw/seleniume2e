package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.Extentmanager;

public class BaseClass {
	
	public static Properties prop;
	public static ThreadLocal<WebDriver> threadLocalDriver=new ThreadLocal<>();
	
	@BeforeSuite
	public void loadConfig()
	{
		
		DOMConfigurator.configure("log4j.xml");
		Extentmanager.setExtentReport();
		prop=new Properties();
		
		try {
			FileInputStream inputStream=new FileInputStream(new File(System.getProperty("user.dir")+"/Configuration/Config.properties"));
			prop.load(inputStream);
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	static public WebDriver getDriver()
	{
		return threadLocalDriver.get();
	}
	

	public void launchSite(String browserName)
	{
		if(browserName.equalsIgnoreCase("Chrome"))
		{
			
			
			
		WebDriverManager.chromedriver().setup();
		
        Map<String,Integer> mappref =new HashMap<>();
		
		mappref.put("profile.default_content_setting_values.notifications", 2);
		ChromeOptions option=new ChromeOptions();
		
		
		option.setExperimentalOption("prefs", mappref);
		
		
		threadLocalDriver.set(new ChromeDriver(option));
		}
		
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(prop.getProperty("implicitWait"))));
		
		getDriver().manage().window().maximize();
		
		getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Integer.parseInt(prop.getProperty("pageLoadTimeout"))));
		
		getDriver().get(prop.getProperty("url"));
	}
	
	
	@AfterSuite
	public void postSuite()
	{
		Extentmanager.endReport();
	}

}
