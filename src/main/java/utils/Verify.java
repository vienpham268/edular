package utils;

import constants.WaitTimes;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class Verify {
    private static final Logger LOGGER = LogManager.getLogger(Verify.class);
    WebDriver driver;

    public Verify(WebDriver driver) {
        this.driver = driver;
    }

    public boolean verifyAttributeValue(WebElement we, String weName, String sAttribute, String expectedValue) {
        new UIInteractions(driver).driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        try {
            if (we.getAttribute(sAttribute).contains(expectedValue)) {
                this.driver.manage().timeouts().implicitlyWait(WaitTimes.IMPLICITLY_WAIT, TimeUnit.SECONDS);
                return true;
            }
            LOGGER.error("Attribute:'" + sAttribute + "' has actual value is: " + we.getAttribute(sAttribute)
                    + " , It should be: " + expectedValue + " as expected");
            new Results(driver).setFailedBy("Attribute:'" + sAttribute + "' has actual value is: " + we.getAttribute(sAttribute)
                    + " , It should be: " + expectedValue + " as expected");
            this.driver.manage().timeouts().implicitlyWait(WaitTimes.IMPLICITLY_WAIT, TimeUnit.SECONDS);
            return false;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            LOGGER.error(
                    "Exception when try to verify Attribute:'" + sAttribute + "' of " + weName + " " + we.toString());
            new Results(driver).setFailedBy(
                    "Exception when try to verify Attribute:'" + sAttribute + "' of " + weName + " " + we.toString());
            this.driver.manage().timeouts().implicitlyWait(WaitTimes.IMPLICITLY_WAIT, TimeUnit.SECONDS);
            return false;
        }
    }

    public boolean verifyCSSValue(WebElement we, String weName, String CSSproperty, String expectedValue) {
        try {
            if (we.getCssValue(CSSproperty).trim().contains(expectedValue)) {
                return true;
            }
            LOGGER.error("CSS property:'" + CSSproperty + "' has actual value is: " + we.getCssValue(CSSproperty)
                    + " , It should be: " + expectedValue + " as expected");
            new Results(driver).setFailedBy("CSS property:'" + CSSproperty + "' has actual value is: " + we.getCssValue(CSSproperty)
                    + " , It should be: " + expectedValue + " as expected");
            return false;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            LOGGER.error("Exception when try to verify CSS value of property:'" + CSSproperty + "' of " + weName + " "
                    + we.toString());
            new Results(driver).setFailedBy("Exception when try to verify CSS value of property:'" + CSSproperty + "' of " + weName
                    + " " + we.toString());
            return false;
        }
    }

    public void verifyTextValueContains(WebElement we, String weName, String expectedValue) {
        try {
            if (!we.getText().trim().contains(expectedValue.trim())) {
                LOGGER.error("------>Verify " + weName + ": Actual text is: " + we.getText() + " , It should be: " + expectedValue
                        + " as expected");
                new Results(driver).setFailedBy("------>Verify " + weName + ": Actual text is: " + we.getText() + " , It should be: " + expectedValue
                        + " as expected");
            } else {
                LOGGER.info("------>Verify " + weName + " contains: " + expectedValue + " :PASSED");
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            new Results(driver).setFailedBy(e.getMessage());
        }
    }

    public boolean verifyTextValueEquals(WebElement we, String weName, String expectedValue) {
        LOGGER.info("------>Verify " + weName + " is " + expectedValue);
        try {
            if (we.getText().trim().equals(expectedValue.trim())) {
                return true;
            }
            LOGGER.error(weName + ": Actual text is: " + we.getText() + " , It should be: " + expectedValue
                    + " as expected");
            new Results(driver).setFailedBy(weName + ": Actual text is: " + we.getText() + " , It should be: " + expectedValue
                    + " as expected");

            return false;

        } catch (Exception e) {
            System.err.println(e.getMessage());
            LOGGER.error("Exception when try to verify text of " + weName + " " + we.toString());
            new Results(driver).setFailedBy("Exception when try to verify text of " + weName + " " + we.toString());
            return false;
        }
    }

    public void verifyElementDisplay(WebElement we, String weName) {
        try {
            we.isDisplayed();
            LOGGER.info("------>Verify " + weName + " display: PASSED");
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            new Results(driver).setFailedBy(e.getMessage());
        }

    }

    public boolean verifyElementNotDisplay(WebElement we, String weName) {
        LOGGER.info("------>Verify element not display " + weName);
        try {
            this.driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
            we.isDisplayed();
            LOGGER.error(weName + we.toString() + " is still displayed");
            new Results(driver).setFailedBy(weName + we.toString() + " is still displayed");
            this.driver.manage().timeouts().implicitlyWait(WaitTimes.IMPLICITLY_WAIT, TimeUnit.SECONDS);
            return false;
        } catch (Exception e) {
            this.driver.manage().timeouts().implicitlyWait(WaitTimes.IMPLICITLY_WAIT, TimeUnit.SECONDS);
            return true;
        }

    }

    public boolean verifyElementEnable(WebElement we, String weName) {
        try {
            if (we.isEnabled()) {
                return true;
            } else {
                LOGGER.error(weName + we.toString() + " is still disabled");
                new Results(driver).setFailedBy(weName + we.toString() + " is still disabled");
                return false;
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
            LOGGER.error("Exception when try to verify " + we.toString());
            new Results(driver).setFailedBy("Exception when try to verify " + we.toString());
            return false;
        }
    }

    public boolean verifyElementDisable(WebElement we, String weName) {
        try {
            if (!we.isEnabled()) {
                return true;
            } else {
                LOGGER.error(weName + we.toString() + " is still enabled");
                new Results(driver).setFailedBy(weName + we.toString() + " is still enabled");
                return false;
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
            LOGGER.error("Exception when try to verify " + we.toString());
            new Results(driver).setFailedBy("Exception when try to verify " + we.toString());
            return false;
        }
    }

    public boolean verifyElementIsUnclickable(WebElement we, String weName) {
        try {
            this.driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
            we.click();
            LOGGER.error(weName + we.toString() + "is clickable!");
            new Results(driver).setFailedBy(weName + we.toString() + "is still clickable!");
            this.driver.manage().timeouts().implicitlyWait(WaitTimes.IMPLICITLY_WAIT, TimeUnit.SECONDS);
            return false;
        } catch (Exception e) {
            this.driver.manage().timeouts().implicitlyWait(WaitTimes.IMPLICITLY_WAIT, TimeUnit.SECONDS);
            return true;
        }
    }

    public boolean verifyElementIsClickable(WebElement we, String weName) {
        try {
            this.driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
            we.click();
            this.driver.manage().timeouts().implicitlyWait(WaitTimes.IMPLICITLY_WAIT, TimeUnit.SECONDS);
            return true;

        } catch (Exception e) {
            System.err.println(e.getMessage());
            LOGGER.error(weName + we.toString() + "is UnClickable!");
            new Results(driver).setFailedBy(weName + we.toString() + "is still UnClickable!");
            this.driver.manage().timeouts().implicitlyWait(WaitTimes.IMPLICITLY_WAIT, TimeUnit.SECONDS);
            return false;
        }
    }


}
