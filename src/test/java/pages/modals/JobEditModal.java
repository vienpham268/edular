package pages.modals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.ContactDetailsPage;
import testing.DriverActions;
import testing.Results;

public class JobEditModal extends DriverActions {
    private static final Logger LOGGER = LogManager.getLogger(JobEditModal.class);

    public JobEditModal(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//button[text()='Remain on Contact Record']")
    WebElement btnRemain;

    public ContactDetailsPage goToPersonalContactPage() {
        try {
            clickOnWithAction(btnRemain, "Button Remain on Contact Record");
            return new ContactDetailsPage(driver);
        } catch (Exception e) {
            new Results(driver).setFailedBy(e.getMessage());
            Assert.assertTrue(Results.result);
        }
        return null;
    }

}
