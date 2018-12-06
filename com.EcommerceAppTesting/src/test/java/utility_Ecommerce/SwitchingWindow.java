/**
 * 
 */
package utility_Ecommerce;

import java.util.Set;

import org.openqa.selenium.WebDriver;

/**
 * @author Lenovo
 *
 */
public class SwitchingWindow {

	static WebDriver driver;
	
	public static void getSwitchingWindow(){
		
		String parentId = driver.getWindowHandle();
		
		System.out.println("The Current window is:"+parentId);
		
		Set<String> allWindows = driver.getWindowHandles();
		
		System.out.println("The total child window are:"+(allWindows.size()-1));
		
		for(String child:allWindows){
			
			if(!parentId.equalsIgnoreCase(child)){
				
				driver.switchTo().window(child);
				
				driver.close();
			}
		}
		
		
		
	}
	
	
}
