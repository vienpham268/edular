package pages;

import models.JobAllocationModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testing.DriverActions;
import testing.Results;
import testing.Verify;


public class JobAllocationDetailsPage extends DriverActions {
    private static final Logger LOGGER = LogManager.getLogger(JobAllocationDetailsPage.class);

    public JobAllocationDetailsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//span[text()='Resource']/../../div[2]//div[@class='slds-grid']//span")
    WebElement txtResource;

    @FindBy(xpath = "//span[text()='Status']/../../div[2]//slot/*")
    WebElement txtStatus;



    public JobAllocationDetailsPage verifyJobAllocationDetails(JobAllocationModel allocation) {
        LOGGER.info("Verifying Job Allocation details...");
        try {
            new Verify(driver).verifyTextValueEquals(txtResource,"Resource",allocation.getResource());
            new Verify(driver).verifyTextValueEquals(txtStatus,"Status",allocation.getStatus());
        } catch (Exception e) {
            new Results(driver).setFailedBy(e.getMessage());
        }
        return new JobAllocationDetailsPage(driver);
    }


}
