package Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import TestCase.BaseClass;

public class Extendreports implements ITestListener {
	
	public static ExtentSparkReporter sp;
	public static ExtentReports reports;
	public static ExtentTest test;
	// time stamp
	String timestamp= new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
	
	 public void onStart(ITestContext context) {
		    // Set the document path
		 sp = new ExtentSparkReporter(System.getProperty("user.dir")+"\\Extentreports\\"+timestamp+"report1.html");
		 // set the title of document
		 sp.config().setDocumentTitle("Testing Report");
		 sp.config().setReportName("Functional test report");
		 sp.config().setTheme(Theme.STANDARD);
		 // using reports set common values 
		 reports= new ExtentReports();
		 reports.attachReporter(sp);
		 reports.setSystemInfo("TesterName", "Mahesh");
		 
		  }
	 
	 public void onTestSuccess(ITestResult result) {
		    test= reports.createTest(result.getName());
		    test.log(Status.PASS, "Test pass");
		  }
	 
	 public void onTestFailure(ITestResult result) {
		    test= reports.createTest(result.getName());
		    test.log(Status.FAIL, result.getName());
		   try {
		    String imagepath= new BaseClass().screenshot(result.getName());
		    test.addScreenCaptureFromPath(imagepath);
		   }catch(Exception e) {
			   e.getStackTrace();
		   }
		  }
	 
	 public void onTestSkipped(ITestResult result) {
		 test= reports.createTest(result.getName());
		    test.log(Status.SKIP, "Test skipped");
		  }
	 public void onFinish(ITestContext context) {
		    reports.flush();
		  }
	 

}
