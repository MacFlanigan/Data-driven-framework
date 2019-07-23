package mac.flanigan.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import mac.flanigan.base.TestBase;

public class TestUtil extends TestBase {
	
	public static String screenshotPath = System.getProperty("user.dir") + "/target/surefire-reports/html/";
	public static String screenshotName;
	
	public static void captureScreenshot() throws IOException {
		Date d = new Date();
		screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File(screenshotPath + screenshotName));
	}

}
