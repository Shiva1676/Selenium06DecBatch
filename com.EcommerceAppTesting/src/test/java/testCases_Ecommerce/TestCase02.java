/**
 * 
 */
package testCases_Ecommerce;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import pages_Ecommerce.HomePage;
import provider_Ecommerce.Config;

/**
 * @author Lenovo
 *
 */
public class TestCase02 extends BaseClass {

	ExtentTest logger;

	boolean isMatchedProduct = false;

	@BeforeMethod
	public void setUpReporting() {

		logger = reports.startTest("Verifying Flipkart application");

	}

	@AfterMethod
	public void closeReporting() {

		reports.endTest(logger);
	}

	@Test
	public void VerifyFlipkartApp() throws InterruptedException {

		HomePage homePage = PageFactory.initElements(driver, HomePage.class);

		homePage.getCancelAlertandPassinginfo("Mobiles");

		int rows = Config.getExcel().getRows("Sheet1");

		System.out.println("The number of rows are available in:" + rows);

		int columns = Config.getExcel().getColumns("Sheet1");

		System.out.println("The number of Columns are available in:" + columns);

		String data = "";

//		boolean isMatchedProduct = false;

		for (int i = 0; i < 490; i++) {

			for (int j = 0; j < rows; j++) {

				for (int k = 0; k < columns; k++) {

					if (k == 0)

						data = Config.getExcel().getData("Sheet1", j, k);

					isMatchedProduct = homePage.getHomePageDetails(data);
			}
				
				if (isMatchedProduct)

					break;

				System.out.println(i + " " + "Next page clicked ");	

		}
			
			
	}
		
	

	
	}
}
