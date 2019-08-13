package demo.site.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.testng.listener.ExtentITestListenerAdapter;

import utils.ExtentTestBase;
import utils.WaitTool;


@Listeners({ExtentITestListenerAdapter.class})
public class CamelotDemoTest2 extends ExtentTestBase {
	
	WebDriver driver;
	//TODO Remote driver?
	@BeforeSuite
	private void testReportSetup() {
		initLoggerReport();
		
	}
	@AfterMethod
	private void flushResults() {
		extent.flush();
		
	}
	@AfterSuite
	private void driverTierDown() {
		//driver.quit();
	}
	// Method 1 : 
	@Test(priority = 0,enabled = false)
	private void siteLogIn() {
		test = extent.createTest("Log in to demo site");
		test.assignCategory("Camelot Demo Site");
		System.setProperty("webdriver.chrome.driver", "webdrivers/chromedriver.exe");
		driver = new ChromeDriver();
		WaitTool.setImplicitWait(driver, 5);
		driver.get("https://iwg.camelot.tech/catalog");
		test.pass("Demo site is loaded");
		driver.findElement(By.id("username")).sendKeys("demo");
		driver.findElement(By.id("pass")).sendKeys("p0rt@l");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		test.pass("Log in sucssesful");
		
	}
	
	
	
	
	@Test
	private void testParent() {
		test = extent.createTest("Parent");
		ExtentTest node = test.createNode("node");
		node.pass("pass");
		System.out.println(node.getStatus());
		node.fail("fail");
		System.out.println(node.getStatus());
		node.error("Skip");
		System.out.println(node.getStatus());
		
		
		
		
		
	}
	
//	// Method 2 : 
//	@Test(priority = 1)
//	private void getGamesCount() {
//		WaitTool.waitForElement(driver, By.id("games"), 5);
//		WebElement element = driver.findElement(By.id("games"));
//		Collection<WebElement> allElements =  element.findElements(By.xpath("//div[@class='game']//div[@class='title']")) ;
//		System.out.println(allElements.size());
//		for (int i = 68; i < allElements.size(); i++) {
//			driver.findElement(By.xpath("//div[@id='games']//div["+i+"]")).click();
//			WaitTool.waitForElement(driver, By.xpath("//iframe[@id='iwg-game']"), 10);
//			try {
//				Thread.sleep(10000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//				
//			}
//			driver.get("https://iwg.camelot.tech/catalog/");
//			
//		}
//		
//		
//	}
//	@Test (priority =3)
//	private void sikulixTest() {
//		
//		Screen s = new Screen();
//		s.findWord("camelot").highlight();
//		
//	}
	
	
	
	

}
