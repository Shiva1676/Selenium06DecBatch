/**
 * 
 */
package pages_Ecommerce;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import utility_Ecommerce.SyncElement;

/**
 * @author Lenovo
 *
 */
public class HomePage {

	WebDriver driver;

	@FindBy(how = How.XPATH, using = ".//button[@class= '_2AkmmA _29YdH8']")
	WebElement cancelButton;

	@FindBy(how = How.XPATH, using = ".//input[@type= 'text']")
	WebElement input;

	// @FindBy(how = How.XPATH, using = ".//button[@class= 'vh79eN']")
	// WebElement searchButton;

	@FindBy(how = How.XPATH, using = ".//div[@class= '_3wU53n']")
	List<WebElement> mobileList;

	@FindBy(how = How.XPATH, using = ".//span[text()= 'Next']")
	WebElement nextButton;

	boolean productStatus = false;

	public HomePage(WebDriver driver) {

		this.driver = driver;
	}

	public void getCancelAlertandPassinginfo(String data) throws InterruptedException {

		SyncElement.getWaitforElement(driver, cancelButton).click();

		SyncElement.getWaitforElement(driver, input).sendKeys(data);

		input.submit();

		Thread.sleep(1000);
	}

	public boolean getHomePageDetails(String info) throws InterruptedException {

		// SwitchingWindow.getSwitchingWindow();

		/*String parentID = driver.getWindowHandle();

		System.out.println("The parentID is:" + parentID);

		Set<String> allWindow = null;*/

		boolean isMatchedProduct = false;

		for (WebElement ele : mobileList) {

			String textValue = ele.getAttribute("innerHTML");

			if (textValue.equalsIgnoreCase(info)) {

				/*
				 * Actions action = new Actions(driver);
				 * 
				 * Action builder =
				 * action.moveToElement(SyncElement.getWaitforElement(driver,
				 * ele)).click().build();
				 * 
				 * builder.perform();
				 */

				productStatus = ele.isDisplayed();

				if (productStatus == true) {

					System.out.println(textValue + " " + "Matches the product:" + info);

					ele.click();

					/*allWindow = driver.getWindowHandles();

					System.out.println("Total child windows:" + (allWindow.size() - 1));*/

					isMatchedProduct = true;
				}

			} else {

				System.out.println(textValue + " " + "Not matching the product:" + info);
			}

			if (isMatchedProduct) {

				/*for (String child : allWindow) {

					if (!parentID.equalsIgnoreCase(child)) {

						driver.switchTo().window(child);

						System.out.println("The title of the page is:" + driver.getTitle());

//						driver.close();
					}
				}*/

				// System.out.println(textValue + " " + "Matches the product and
				// we skip from the loop" + info);

				break;

			}

//			driver.switchTo().window(parentID);
			
		}

		
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",
				mobileList.get(mobileList.size() - 1));

		// move slightly up as blue header comes in the picture
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-100)");

		SyncElement.getWaitforElement(driver, nextButton).click();

		// PageDown.getPageDown(driver, nextButton);

		WebElement OfferZone = driver.findElement(By.xpath(".//*[text()= 'Offer Zone']"));

		SyncElement.getWaitforElement(driver, OfferZone).isDisplayed();

		Thread.sleep(2000);

		return isMatchedProduct;

	}

}
