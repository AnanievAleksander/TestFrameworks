package demo.site.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerAdapter;

import utils.ExtentTestBase;


@Listeners({ExtentITestListenerAdapter.class})
public class CamelotDemoTest extends ExtentTestBase {
	
	WebDriver driver;
	//TODO Remote driver?
	@BeforeSuite
	private void testReportSetup() {
		initLoggerReport();
		System.setProperty("webdriver.chrome.driver", "webdrivers/chromedriver.exe");
	}
	@AfterMethod
	private void flushAndQuit() {
		extent.flush();
		driver.quit();
	}
	
	@Test
	private void siteLogIn() {
		test = extent.createTest("Log in to demo site");
		test.assignCategory("Camelot Demo Site");
		driver = new ChromeDriver();
		driver.get("https://iwg.camelot.tech/catalog");
		test.pass("Demo site is loaded");
		driver.findElement(By.id("username")).sendKeys("demo");
		driver.findElement(By.id("pass")).sendKeys("p0rt@l");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		test.pass("Log in sucssesful");
		
	}
	
	
	

}
