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

public class ResourceAllocationModal extends DriverActions {
    private static final Logger LOGGER = LogManager.getLogger(ResourceAllocationModal.class);

    public ResourceAllocationModal(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//button[text()='Allocate Resources']")
    WebElement btnAllocateResources;

    public JobDetailsPage clickOnAllocateResourceButton() {
        try {
            clickOnWithAction(btnAllocateResources, "Button Allocate Resource");
            return new JobDetailsPage(driver);
        } catch (Exception e) {
            new Results(driver).setFailedBy(e.getMessage());
            Assert.assertTrue(Results.result);
        }
        return null;
    }

}
