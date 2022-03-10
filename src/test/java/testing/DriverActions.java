package utils;

import constants.WaitTimes;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverActions {
    private static final Logger LOGGER = LogManager.getLogger(DriverActions.class);
    protected WebDriver driver;
    WebDriverWait wait;

    public DriverActions(WebDriver driver) {
        this.driver = driver;
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

    public void clickOnElement(WebElement we) throws NoSuchElementException {
        try {
            waitUntilClickable(we);
            we.click();
        } catch (NoSuchElementException e) {
            LOGGER.error(e.getMessage());
            throw e;
        }

    }

    public void sendTextOnElement(WebElement we, String sText) throws NoSuchElementException {
        try {
            waitUntilClickable(we);
            we.clear();
            we.sendKeys(sText);
            we.click();
        } catch (NoSuchElementException e) {
            LOGGER.error(e.getMessage());
            throw e;
        }

    }


}
