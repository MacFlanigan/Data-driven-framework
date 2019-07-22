package mac.flanigan.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import mac.flanigan.utilities.ExcelReader;

public class TestBase {

	/*
	 * WebDriver ==> OK,
	 * Properties ==> OK,
	 * Logs,
	 * ExtentReports, ReportNG
	 * DB,
	 * Excel,
	 * Mail,
	 * Jenkins
	 */

	private static final String USER_DIR = "user.dir";
	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static ExcelReader excel = 
			new ExcelReader(System.getProperty(USER_DIR) + "/src/test/resources/excel/testData.xlsx");
	public static WebDriverWait wait;

	@BeforeSuite
	public void setup() {
		if (driver == null) {
			try {
				fis = new FileInputStream(
						System.getProperty(USER_DIR) + "/src/test/resources/properties/Config.properties");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				config.load(fis);
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				fis = new FileInputStream(
						System.getProperty(USER_DIR) + "/src/test/resources/properties/OR.properties");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				OR.load(fis);
			} catch (IOException e) {
				e.printStackTrace();
			}

			if (config.getProperty("browser").equals("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty(USER_DIR) + "/src/test/resources/executables/chromedriver");
				driver = new ChromeDriver();
			} else if (config.getProperty("browser").equals("firefox")) {
				System.setProperty("webdriver.gecko.driver",
						System.getProperty(USER_DIR) + "/src/test/resources/executables/geckodriver");
				driver = new FirefoxDriver();
			}

			driver.get(config.getProperty("testsiteurl"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),
					TimeUnit.SECONDS);
			wait = new WebDriverWait(driver, 5);

		}
	}
	
	
	public boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	@AfterSuite
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}


















