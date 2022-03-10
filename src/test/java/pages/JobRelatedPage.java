package pages;

import models.JobDetailsModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import testing.DriverActions;
import testing.Results;
import testing.Verify;

public class JobRelatedPage extends DriverActions {
    private static final Logger LOGGER = LogManager.getLogger(JobRelatedPage.class);

    public JobRelatedPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }


    @FindBy(xpath = "//span[contains(text(),'JA')]")
    WebElement jobAllocationId;



    public JobAllocationDetailsPage openJobAllocationDetails() {
        LOGGER.info("Opening Job Allocation Details...");
        try {
            clickOnWithAction(jobAllocationId, "JobAllocationId");
        } catch (Exception e) {
            new Results(driver).setFailedBy(e.getMessage());
            Assert.assertTrue(Results.result);
        }
        return new JobAllocationDetailsPage(driver);
    }


}
