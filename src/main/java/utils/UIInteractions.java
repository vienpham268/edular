package utils;

import constants.WaitTimes;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UIInteractions {
    private static final Logger LOGGER = LogManager.getLogger(UIInteractions.class);
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    public UIInteractions(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, WaitTimes.EXPLICITLY_WAIT);
        actions = new Actions(driver);
    }

    public void openURL(String url) {
        try {
            driver.get(url);
        } catch (Exception e) {

        }
    }

    public void waitUntilClickable(WebElement we) throws NoSuchElementException {
        try {
            this.wait.until(ExpectedConditions.elementToBeClickable(we));
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw e;

        }
    }

    public void waitUntilVisibility(WebElement we) throws Exception {
        try {
            this.wait.until(ExpectedConditions.visibilityOf(we));
            System.out.println(we + " is visible");
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw e;

        }
    }

    public void clickOn(WebElement we, String weName) throws NoSuchElementException {
        try {
            waitUntilClickable(we);
            LOGGER.info("Click on " + weName);
            we.click();
        } catch (NoSuchElementException e) {
            LOGGER.error(e.getMessage());
            throw e;
        }
    }

    public void clickOnWithAction(WebElement we, String weName) throws NoSuchElementException {
        try {
            waitUntilClickable(we);
            LOGGER.info("Click on " + weName);
            actions.click(we).perform();
        } catch (NoSuchElementException e) {
            LOGGER.error(e.getMessage());
            throw e;
        }
    }

    public void sendText(WebElement we, String weName, String sText) throws NoSuchElementException {
        try {
            waitUntilClickable(we);
            LOGGER.info("Send text on " + weName + " is: " + sText);
            we.clear();
            we.sendKeys(sText);
            we.click();
        } catch (NoSuchElementException e) {
            LOGGER.error(e.getMessage());
            throw e;
        }
    }

    public void sendTextWithAction(WebElement we, String weName, String sText) throws NoSuchElementException {
        try {
            waitUntilClickable(we);
            LOGGER.info("Send text on " + weName + " is: " + sText);
            actions.click(we).perform();
            we.clear();
            we.sendKeys(sText);
        } catch (NoSuchElementException e) {
            LOGGER.error(e.getMessage());
            throw e;
        }
    }


}
