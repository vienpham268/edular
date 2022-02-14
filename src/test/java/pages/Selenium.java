package pages;

import constants.WaitTimes;
import drivers.DriverBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Selenium extends DriverBase {
    private static final Logger LOGGER = LogManager.getLogger(Selenium.class);

    public Selenium(WebDriver driver){
        this.driver =driver;
        this.wait = new WebDriverWait(driver, WaitTimes.EXPLICITLY_WAIT);
    }

    public void waitUntilClickable(WebElement we) {
        try {
            this.wait.until(ExpectedConditions.elementToBeClickable(we));
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw e;

        }
    }

    public void clickOnElement(WebElement we) throws Exception {
        try {
            waitUntilClickable(we);
            we.click();
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw e;
        }

    }

    public void sendTextOnElement(WebElement we, String sText) throws Exception {
        try {
            we.clear();
            we.sendKeys(sText);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw e;
        }

    }


}
