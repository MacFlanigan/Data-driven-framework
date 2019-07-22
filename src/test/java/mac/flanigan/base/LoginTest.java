package mac.flanigan.base;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;

public class LoginTest extends TestBase{
	
	@Test
	public void loginAsBankManager() throws InterruptedException {
		
		driver.findElement(By.cssSelector(OR.getProperty("bmlBtn"))).click();
		Assert.assertTrue(isElementPresent(By.cssSelector(OR.getProperty("addCustBtn"))));
		
	}
}
