package alex.testing;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({ExtentITestListenerClassAdapter.class})
public class AppTest {
	@Test(groups = { "tagName", "t:another-tagName", "a:authorName", "d:deviceName" })
	public void test1(String user, String password) {
		Assert.assertTrue(true);
	}
	
	@Test(groups = { "tagName", "tag:another-tagName", "author:authorName", "device:deviceName" })
	public void test2(String user, String password) {
		Assert.assertTrue(false);
	}	
}


