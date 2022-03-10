package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import testing.DriverActions;
import testing.Results;

import java.util.List;

public class NavBar extends DriverActions {
    private static final Logger LOGGER = LogManager.getLogger(NavBar.class);

    public NavBar(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//input[@placeholder='Search...']")
    WebElement inputSearch;

    @FindBy(xpath = "//div[@class='listContent']/ul[@role='presentation']/li")
    List<WebElement> listContact;

    public PersonalContactPage searchValidContact(String contactName) {
        LOGGER.info("Searching contact " + contactName + " ...");
        try {
            sendText(inputSearch, "Search Form", contactName);
            clickOn(listContact.get(1), "First result on List");
            return new PersonalContactPage(driver);
        } catch (Exception e) {
            new Results(driver).setFailedBy(e.getMessage());
            Assert.assertTrue(Results.result);
        }
        return null;
    }

}
