package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extentmanager {
	
	static ExtentSparkReporter reporter;
	static ExtentReports extentReports;
	static ExtentTest test;
	
	public static void setExtentReport()
	{
		
		reporter=new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/ExtentReport/"+"Myreport.html");
		extentReports=new ExtentReports();
		
		extentReports.attachReporter(reporter);
		
		extentReports.setSystemInfo("Tester", "Rajasekar");
		extentReports.setSystemInfo("Browser", "Chrome");
	}

	
	public static void endReport()
	{
		extentReports.flush();
	}
}
