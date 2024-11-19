package listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.basedata;
import utilities.ExtentReport;

public class ITestListeners extends basedata implements ITestListener {

	ExtentReports extentreport=ExtentReport.getReport();
	ThreadLocal<ExtentTest> threadlocal=new ThreadLocal<ExtentTest>();
	public ExtentTest extenttest ;
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		String testname = result.getName();
	
		 extenttest = extentreport.createTest(testname +"Execution started");
			threadlocal.set(extenttest);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		//extenttest.log(Status.PASS, "Execution is success");
		threadlocal.get().log(Status.PASS, "Execution is success");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		WebDriver driver = null ;
		//extenttest.fail(result.getThrowable());
		threadlocal.get().fail(result.getThrowable());
		
		String testname = result.getName();
		
		
				try {
					 driver=(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		
		try {
			String screenshot = takescreenshot(testname, driver);
			threadlocal.get().addScreenCaptureFromPath(screenshot,testname);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	
	

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extentreport.flush();
		
	}

	
}

