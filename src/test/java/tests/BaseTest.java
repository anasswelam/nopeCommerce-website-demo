package tests;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.junit.runner.notification.Failure;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import Utilities.Helper;
import cucumber.api.testng.AbstractTestNGCucumberTests;

public class BaseTest extends AbstractTestNGCucumberTests{
	public static WebDriver driver;
	public static String downloadpath= System.getProperty("user.dir")+"/Download";

	public static ChromeOptions chromoption() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		HashMap<String, Object> chromprefs = new HashMap<String, Object>();
		chromprefs.put("profile.default.content_sitting.popups", 0);
		chromprefs.put("download.default_directory", downloadpath);
		options.setExperimentalOption("prefs", chromprefs);
		options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		return options;
	}
	public static FirefoxOptions firefox() {
		FirefoxOptions options= new FirefoxOptions();
		//intvalue
		options.addPreference("browser.download.folderlist", 2);
		options.addPreference("browser.download.dir", downloadpath);
		options.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf");
		options.addPreference("browser.download.manager.showWhenStarting", false);
		options.addPreference("pdfjs.disabled", true);
		return options;
		
	}
	
	@BeforeSuite
	@Parameters({"browser"})
	public static void StartTest(@Optional ("chrome") String browserName) {
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
			driver= new ChromeDriver(chromoption());
		}
		if(browserName.equalsIgnoreCase("chrome-headless")) {
			System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("--window-size=1920,1080");
			driver= new ChromeDriver(options); }
			
		else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");
			driver= new FirefoxDriver(firefox());
		}
		else if (browserName.equalsIgnoreCase("ie")) 
		{
			System.setProperty("webdriver.ie.driver","Drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver(); 
		}

		else if (browserName.equalsIgnoreCase("safari")) {
			driver = new SafariDriver(); 
	}
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("http://demo.nopcommerce.com/");
	
	}
	@AfterMethod
	public static void TakeScreenshot(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE);
		{
		System.out.println("Failure..");
		System.out.println("Taking Screenshot..");
		Helper.capturescreenshot(driver, result.getName());
		}
	}
	
	@AfterSuite
	public void closedriver() {
		driver.quit();
	}

}
