package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {

	public static ExtentReports getReport() {
		// TODO Auto-generated method stub
String path = System.getProperty("user.dir")+"\\reports\\extentreport.html";
		ExtentSparkReporter report = new ExtentSparkReporter(path);
		report.config().setDocumentTitle("Freshdesk Application");
		report.config().setReportName("ContactApp");
		
		
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("OS", "Windows 7");
		 extent.setSystemInfo("created by", "Pranali");
		return extent;
		 
		
	}

}
