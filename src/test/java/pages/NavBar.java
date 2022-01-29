package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.Results;

public class NavBar extends Selenium {
    private static final Logger LOGGER = LogManager.getLogger(NavBar.class);
    public NavBar(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//div[@id='desktop-menu']/form/input[@type='text']")
    WebElement input_Search;


    public void searchLocation(String query) {
        try {
            LOGGER.info("Searching " + query + " ...");
            this.sendTextOnElement(input_Search, query);
            input_Search.sendKeys(Keys.ENTER);
        } catch (Exception e) {
            new Results(driver).setFailedBy(e.getMessage());
            Assert.assertTrue(Results.result);
        }
    }


}
