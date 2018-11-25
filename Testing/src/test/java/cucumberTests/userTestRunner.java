package cucumberTests;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.relevantcodes.extentreports.ExtentReports;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/addUser.feature")
public class userTestRunner {
	
	public static WebDriver driver;
	public static ExtentReports report = new ExtentReports("/Documents/Project/QAProject/Testing/src/test/addUserTests.html", true);
	
	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.gecko.driver",
				"/home/joseph/Downloads/geckodriver-v0.23.0-linux32/geckodriver");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@AfterClass
	public static void tearDown() {
		driver.close();
		driver.quit();
		report.flush();
}
	
}