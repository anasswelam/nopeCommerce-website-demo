package tests;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import Utilities.Helper;

public class BaseTest2 {

	public static String BaseURL="https://demo.nopcommerce.com/";
	
	protected ThreadLocal<RemoteWebDriver> driver = null;
	
	@BeforeClass
	@Parameters({"browser"})
	public void Setup(@Optional("chrome") String browser)  throws MalformedURLException  {
		
		driver = new ThreadLocal<RemoteWebDriver>();		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("browserName", browser);
		driver.set(new RemoteWebDriver(new java.net.URL("http://localhost:4444/wd/hub"), caps));
		getdriver().navigate().to(BaseURL);
	}
	
	public WebDriver getdriver() {
		return driver.get();
	}
	
	@AfterClass
	public void stopdriver() {
		getdriver().quit();
		driver.remove();
	}
	
	@AfterMethod
	public void screenshotOnFailure(ITestResult result) 
	{
		if (result.getStatus() == ITestResult.FAILURE)
		{
			System.out.println("Failed!");
			System.out.println("Taking Screenshot....");
			Helper.capturescreenshot(getdriver(), result.getName());
		}
	}
}
