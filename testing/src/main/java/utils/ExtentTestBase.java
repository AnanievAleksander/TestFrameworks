package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentLoggerReporter;

public class ExtentTestBase {

	protected static ExtentReports extent;
	protected static ExtentLoggerReporter logger;
	protected static ExtentTest test;
	
	
	protected static void initLoggerReport() {
		logger = new ExtentLoggerReporter("testing/target");
		extent = new ExtentReports();
		extent.attachReporter(logger);
	}
	
}
