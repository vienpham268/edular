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

public class AllJobsPage extends DriverActions {
    private static final Logger LOGGER = LogManager.getLogger(AllJobsPage.class);

    public AllJobsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//span[@title='Job Name']/../../../../../../tbody/tr[1]//th//a")
    WebElement aNewestJob;


    public JobDetailsPage openNewestJob() {
        LOGGER.info("Opening Newest job...");
        try {
            Thread.sleep(5000);
            clickOnWithAction(aNewestJob, "Newest Job");
        } catch (Exception e) {
            new Results(driver).setFailedBy(e.getMessage());
            Assert.assertTrue(Results.result);
        }
        return new JobDetailsPage(driver);
    }

    public void openSpecificJob(String jobName) {
        LOGGER.info("Opening Job name" + jobName);
        try {

        } catch (Exception e) {
            new Results(driver).setFailedBy(e.getMessage());
            Assert.assertTrue(Results.result);
        }
    }

}
