package commons;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentAventReporter;
import com.aventstack.extentreports.reporter.ExtentKlovReporter;
import com.aventstack.extentreports.reporter.ExtentLoggerReporter;
import com.aventstack.extentreports.testng.listener.ExtentITestListenerAdapter;

@Listeners({ExtentITestListenerAdapter.class})
public class AppTest {
	
	
	ExtentReports extent;
	ExtentLoggerReporter logger;
	ExtentTest test;
	
	@BeforeSuite
	public void init() {
		 logger = new ExtentLoggerReporter("testing/target");
		//ExtentKlovReporter klov = new ExtentKlovReporter("project", "build");
		
		extent = new ExtentReports();
		extent.attachReporter(logger);
		//extent.attachReporter(klov);
		
	}

	@AfterMethod
	public void flush() {
		extent.flush();
	}
	
	@Test
	public void test1() {
		test = extent.createTest("MyFirstTest");
		test.pass("details");
		test.assignCategory("test");
		Assert.assertTrue(true);
		String [][] data = {
				{"Tab1","Tab2"},
				{ "Value1","Value2"}
		};
		Markup m = MarkupHelper.createTable(data);
		test.pass(m);
		
		
	}
	
	@Test
	public void test2() {
		test = extent.createTest("MySecondTest");
		test.fail("just fail");
		test.assignCategory("fail");
		//test.log(Status.FAIL, "fail");
		Assert.assertTrue(false);
		
		
		
	}	
}


