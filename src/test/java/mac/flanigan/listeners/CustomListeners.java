package mac.flanigan.listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import mac.flanigan.utilities.TestUtil;

public class CustomListeners implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailure(ITestResult result) {
		// to see the links in reportng html report
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		
		Reporter.log("Capturing screenshot");
		try {
			TestUtil.captureScreenshot();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Reporter.log("<br/>");
		Reporter.log("<a target='_blank' href='" + TestUtil.screenshotName +"'>Screenshot</a>");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
 
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

}
