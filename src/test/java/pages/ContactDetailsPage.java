package pages;

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

public class PersonalContactPage extends DriverActions {
    private static final Logger LOGGER = LogManager.getLogger(PersonalContactPage.class);

    public PersonalContactPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//button[text()='Schedule Job']")
    WebElement btnScheduleJob;

    public JobDetailsModal clickOnScheduleJobButton() {
        try {
            clickOnWithAction(btnScheduleJob, "Button Schedule Job");
            return new JobDetailsModal(driver);
        } catch (Exception e) {
            new Results(driver).setFailedBy(e.getMessage());
            Assert.assertTrue(Results.result);
        }
        return null;
    }




}
