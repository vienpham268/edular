package pages;

import models.JobDetailsModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.modals.JobDetailsModal;
import testing.DriverActions;
import testing.Results;
import testing.Verify;

import java.util.List;

public class JobDetailsPage extends DriverActions {
    private static final Logger LOGGER = LogManager.getLogger(JobDetailsPage.class);

    public JobDetailsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//span[text()='Job Status']/../../div[2]/span//*[@slot='outputField']")
    WebElement txtJobStatus;

    @FindBy(xpath = "//span[text()='Start']/../../div[2]/span//*[@slot='outputField']")
    WebElement startTime;

    @FindBy(xpath = "//span[text()='Finish']/../../div[2]/span//*[@slot='outputField']")
    WebElement finishTime;

    @FindBy(xpath = "//a[@data-label='Related']")
    WebElement aRelated;



    public JobDetailsPage verifyJobDetails(JobDetailsModel job) {
        LOGGER.info("Verifying Job details...");
        try {
            verifyTime(job);
            verifyJobStatus();

        } catch (Exception e) {
            new Results(driver).setFailedBy(e.getMessage());
        }
        return new JobDetailsPage(driver);
    }



    private void verifyJobStatus() {
        new Verify(driver).verifyTextValueEquals(txtJobStatus, "Job Status", "Dispatched");
    }

    private void verifyTime(JobDetailsModel job) {
        new Verify(driver).verifyTextValueEquals(startTime, "Start time", job.getStartDate() + " " + job.getStartTime());
        new Verify(driver).verifyTextValueEquals(finishTime, "Finish time", job.getStartDate() + " " + job.getFinishTime());
    }

}
