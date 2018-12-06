/**
 * 
 */
package factory_Ecommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * @author Lenovo
 *
 */
public class BrowserFactory {

	static WebDriver driver;
	
	public static WebDriver getBrowserAndURL(String browser, String url){
		
		
		if(browser.equalsIgnoreCase("Chrome")){
			
			driver = new ChromeDriver();
			
			driver.manage().window().maximize();
			
			System.out.println("The following script is running on:"+browser);
			
		}else if (browser.equalsIgnoreCase("Firefox")) {
			
			driver = new FirefoxDriver();
			
			driver.manage().window().maximize();
			
			System.out.println("The following script is running on:"+browser);
			
		}else if (browser.equalsIgnoreCase("IE")) {
			
			driver = new InternetExplorerDriver();
			
			driver.manage().window().maximize();
			
			System.out.println("The following script is running on:"+browser);
			
		}
	
		driver.get(url);
		
		return driver;
	
	}
	
}
