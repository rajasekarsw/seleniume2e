package utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import actiondriver.Action;
import base.BaseClass;

public class Listener extends Extentmanager implements ITestListener{

	Action action =new Action();
	@Override
	public void onTestStart(ITestResult result) {
		test=extentReports.createTest(result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(Status.PASS, "The passed tc is "+ result.getName());
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE)
		{
			test.log(Status.FAIL,MarkupHelper.createLabel("The failed tc is "+ result.getName(), ExtentColor.RED));
			
			test.log(Status.FAIL, MarkupHelper.createLabel("The failed tc is"+result.getThrowable(), ExtentColor.RED));
			
			String imgpath=action.screenShot(BaseClass.getDriver(), result.getName());
			test.fail("The tc is failed", MediaEntityBuilder.createScreenCaptureFromPath(imgpath).build());
			
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		if(result.getStatus()==ITestResult.SKIP)
		{
			test.log(Status.SKIP, "The skipped tc is "+ result.getName());
		}
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
	
	}

	@Override
	public void onStart(ITestContext context) {
	
	}

	@Override
	public void onFinish(ITestContext context) {
		
	}
	

}
