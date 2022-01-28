package pages;

import constants.WebDriver_Props;
import drivers.DriverBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Result;

import java.util.concurrent.TimeUnit;

public class CommonPage extends DriverBase {
    private static final Logger LOGGER = LogManager.getLogger(CommonPage.class);
    public Actions actions;
    public CommonPage() {

    }


    /**
     * @param sDynamicXpath:should be insert %s into dynamicString
     * @param sInput
     * @return
     */
    public WebElement getDynamicElement(String sDynamicXpath, String sInput) {
        return this.driver.findElement(By.xpath(String.format(sDynamicXpath, sInput)));
    }

    public String getAttributeValue(WebElement we, String attribute) {
        try {
            return we.getAttribute(attribute);
        } catch (Exception e) {
            LOGGER.error("Exception when try to get attribute of " + we.toString());
            Result.setFailedBy("Exception when try to get attribute of " + we.toString());
            return null;
        }

    }

    public String getText(WebElement we) {
        try {
            return we.getText();
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            Result.setFailedBy(e.getMessage());
        }
        return null;
    }

    public String getCSSValue(WebElement we, String CSS) {
        try {
            return we.getCssValue(CSS);
        } catch (Exception e) {
            LOGGER.error("Exception when try to get CSS of " + we.toString());
            Result.setFailedBy("Exception when try to get CSS of " + we.toString());
            return null;
        }

    }

    public void waitForCSSValueChange(WebElement we, String cssValue) {
        try {
            this.wait.until(ExpectedConditions.attributeContains(we, "style", cssValue));
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            Result.setFailedBy(e.getMessage());
        }
    }

    public void waitUntilVisibility(WebElement we) throws Exception {
        try {
            this.wait.until(ExpectedConditions.visibilityOf(we));
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw e;
        }
    }

    public boolean waitUntilDisplay(WebElement we, String sWe) {
        int count = 0;
        boolean isDisplayed = false;
        try {
            this.driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
            if (we.isDisplayed()) {
                this.driver.manage().timeouts().implicitlyWait(WebDriver_Props.IMPLICITLY_WAIT, TimeUnit.SECONDS);
                isDisplayed = true;
            }

        } catch (Exception e) {
            while (count <= 2) {
                try {
                    if (we.isDisplayed()) {
                        this.driver.manage().timeouts().implicitlyWait(WebDriver_Props.IMPLICITLY_WAIT, TimeUnit.SECONDS);
                        isDisplayed = true;
                        break;
                    }
                } catch (Exception e2) {
                    count++;
                }
            }

        }
        this.driver.manage().timeouts().implicitlyWait(WebDriver_Props.IMPLICITLY_WAIT, TimeUnit.SECONDS);
        return isDisplayed;
    }

    public boolean waitUntilNotDisplay(WebElement we, String sWe) {
        try {
            this.driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
            while (we.isDisplayed()) {

            }
            return false;
        } catch (Exception e) {
            this.driver.manage().timeouts().implicitlyWait(WebDriver_Props.IMPLICITLY_WAIT, TimeUnit.SECONDS);
            return true;
        }
    }

    public void waitUntilInvisibility(WebElement we) throws Exception {
        try {
            this.wait.until(ExpectedConditions.invisibilityOf(we));
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw e;
        }
    }

    public void waitUntilClickable(WebElement we) {
        try {
            this.wait.until(ExpectedConditions.elementToBeClickable(we));
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw e;

        }
    }


    public boolean waitForAttributeChange(WebElement we, String attrName, String attrValue) {
        try {
            this.wait.until(ExpectedConditions.attributeContains(we, attrName, attrValue));
            return true;
        } catch (Exception e) {
            LOGGER.error("Attribute " + attrName + " of " + we.toString() + " Does not contain " + attrValue);
            Result.setFailedBy("Attribute " + attrName + " of " + we.toString() + " Does not contain " + attrValue);
            return false;
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
