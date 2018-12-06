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

/**
 * @author Lenovo
 *
 */
public class TestCase01 extends BaseClass {

	ExtentTest logger;

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

		for (int i = 0; i < 490; i++) {

			boolean isMatchedProduct = homePage.getHomePageDetails("Ssky K7");

			if (isMatchedProduct)

				break;

			System.out.println(i + " " + "Next page clicked ");
		}

	}

}
