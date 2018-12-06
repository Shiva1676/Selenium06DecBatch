/**
 * 
 */
package testCases_Ecommerce;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;

import factory_Ecommerce.BrowserFactory;
import provider_Ecommerce.Config;
import utility_Ecommerce.CustomDateAndTimeFormat;

/**
 * @author Lenovo
 *
 */
public class BaseClass {

	ExtentReports reports;
	
	WebDriver driver;

	@BeforeSuite
	public void reporting() {

		String path = System.getProperty("user.dir") + "/Reports_Ecommerce/Flipkart" + CustomDateAndTimeFormat.getCustomDate()
				+ ".html";

		reports = new ExtentReports(path);

	}
	
	@AfterSuite
	public void flushReport(){
		
		reports.flush();
	}
	
	
	@BeforeTest
	public void startBrowserandURL(){
		
		System.out.println("==============Browser and App are about to start=============");
		
		driver = BrowserFactory.getBrowserAndURL(Config.getConfig().getBrowser(), Config.getConfig().getURL());
		
		System.out.println("==============Browser & app are up and running================");
		
	}
	
	@AfterTest
	public void closeBrowser(){
		
		driver.quit();
		
		System.out.println("===================Browser closed=================");
	}
	

}
