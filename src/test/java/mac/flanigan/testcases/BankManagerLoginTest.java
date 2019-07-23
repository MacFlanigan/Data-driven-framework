package mac.flanigan.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import mac.flanigan.base.TestBase;

import org.openqa.selenium.By;

public class BankManagerLoginTest extends TestBase{
	
	@Test
	public void loginAsBankManager() throws InterruptedException {
		
		driver.findElement(By.cssSelector(OR.getProperty("bmlBtn"))).click();
		Assert.assertTrue(isElementPresent(By.cssSelector(OR.getProperty("addCustBtn"))));
		log.debug("Login successfully executed");
		
		Assert.fail("Login not successfull");
	}
}
