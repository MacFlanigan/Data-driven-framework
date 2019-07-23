package mac.flanigan.testcases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import mac.flanigan.base.TestBase;

import org.openqa.selenium.By;

public class BankManagerLoginTest extends TestBase{
	
	@Test
	public void loginAsBankManager() throws InterruptedException {
		
		// to see the links in reportng html report
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		
		driver.findElement(By.cssSelector(OR.getProperty("bmlBtn"))).click();
		Assert.assertTrue(isElementPresent(By.cssSelector(OR.getProperty("addCustBtn"))));
		log.debug("Login successfully executed");
		Reporter.log("Login successfully executed");
		Reporter.log("<a target='_blank' href='/Users/nleclerc/Downloads/burger.jpg'>Screenshot</a>");
	}
}
