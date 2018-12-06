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
public class HomePage2 {

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

	public HomePage2(WebDriver driver) {

		this.driver = driver;
	}

	public void getCancelAlertandPassinginfo(String data) throws InterruptedException {

		SyncElement.getWaitforElement(driver, cancelButton).click();

		SyncElement.getWaitforElement(driver, input).sendKeys(data);

		input.submit();

		Thread.sleep(1000);
	}

	public void getHomePageDetails(String info) throws InterruptedException {

		// SwitchingWindow.getSwitchingWindow();

		
		
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

					ele.click();

					System.out.println(textValue + " " + "Matches the product:" + info);

					break;

				}

			} else {

				System.out.println(textValue + " " + "Not matching the product:" + info);
			}

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

	}

}
