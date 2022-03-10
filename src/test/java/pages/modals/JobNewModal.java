package pages.modals;

import models.JobDetailsModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import testing.DriverActions;
import testing.Results;

import java.util.List;

public class JobDetailsModal extends DriverActions {
    private static final Logger LOGGER = LogManager.getLogger(JobDetailsModal.class);

    public JobDetailsModal(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }


    @FindBy(xpath = "//input[@name='startDate']")
    WebElement inputStartDate;

    @FindBy(xpath = "//input[@name='startTime']")
    WebElement inputStartTime;

    @FindBy(xpath = "//input[@name='jobDuration']")
    WebElement inputDuration;

    @FindBy(xpath = "//textarea[@name='description']")
    WebElement textDescription;

    @FindBy(xpath = "//div[@class='sked-spinner-medium']")
    WebElement iconSpinner;

    @FindBy(xpath = "//label[text()=' Region ']/..//button[@title='Remove']")
    WebElement btnRegionRemove;

    @FindBy(xpath = "//label[text()=' Region ']/..//span[2]")
    WebElement txtRegionSelect;

    @FindBy(xpath = "//label[text()=' Address ']/..//button[@title='Remove']")
    WebElement btnAddressRemove;

    @FindBy(xpath = "//label[text()=' Address ']/..//span[2]")
    WebElement txtAddressSelect;

    @FindBy(xpath = "//input[@name='quantity-0']")
    WebElement inputQuantity;

    @FindBy(xpath = "//label[text()=' Tags ']/../div/div[2]/ul/li//button")
    List<WebElement> listBtnTagsRemove;

    @FindBy(xpath = "//button[text()='Create Job']")
    WebElement btnCreateJob;

    @FindBy(xpath = "//button[text()='Allocate']")
    WebElement btnAllocate;

    @FindBy(xpath = "//button[text()='Update Job']")
    WebElement btnUpdateJob;

    @FindBy(xpath = "//label[text()=' Address ']/../div//input")
    WebElement inputAddress;

    String sUrgency = "//select[@name='jobUrgency']/option[@label='%s']";

    String sAddressType = "//select[@name='addressType']/option[@label='%s']";

    String sBillable = "//select[@name='billableType']/option[@label='%s']";

    String sTravelArea = "//select[@name='travelArea']/option[@label='%s']";

    String sServiceSetting = "//select[@name='skedhealthcareLocationType']/option[@label='%s']";

    String sDeliveryMethod = "//select[@name='serviceDeliveryMethod-0']/option[@label='%s']";

    String sCategory = "//select[@name='serviceCategory-0']/option[@label='%s']";

    String sServiceAgreement = "//select[@name='serviceAgreementItem-0']/option[@label='%s']";

    String sListRegion = "//label[text()=' Region ']/../div[@class='slds-lookup__menu']/ul/li//div[@title='%s']";

    String sListAddress = "//label[text()=' Address ']/../div[@class='slds-lookup__menu']/ul/li//div[@title='%s']";

    String sAvailableResource = "//div[text()='Available Resources']/..//p[text()='%s']";

    public ResourceAllocationModal createScheduleJobFields(JobDetailsModel job) {
        LOGGER.info("Creating new schedule job..");
        try {
            
            Thread.sleep(20000);
            driver.switchTo().frame(0);
            sendTextWithAction(inputStartDate, "Start Date", job.getStartDate());
            sendTextWithAction(inputStartTime, "Start Time", job.getStartTime());
            sendTextWithAction(inputDuration, "Duration", job.getDuration());
            sendTextWithAction(textDescription, "Description", job.getDescription());
            clickOn(driver.findElement(By.xpath(String.format(sUrgency, job.getUrgency()))), "Option " + job.getUrgency());
            clickOn(driver.findElement(By.xpath(String.format(sAddressType, job.getAddressType()))), "Option " + job.getAddressType());
            clickOn(driver.findElement(By.xpath(String.format(sBillable, job.getBillable()))), "Option " + job.getBillable());
            clickOn(driver.findElement(By.xpath(String.format(sTravelArea, job.getTravelArea()))), "Option Remote ");
            selectRegion(job.getRegion());
            selectAddress(job.getAddress());
            clickOn(driver.findElement(By.xpath(String.format(sServiceSetting, job.getServiceSetting()))), "Option " + job.getServiceSetting());
            clickOn(driver.findElement(By.xpath(String.format(sDeliveryMethod, job.getDeliveryMethod()))), "Option " + job.getDeliveryMethod());
            sendTextWithAction(inputQuantity, "Quantity", job.getQuantity());
            clickOn(driver.findElement(By.xpath(String.format(sCategory, job.getCategory()))), "Option " + job.getCategory());
            selectServiceAgreement(job.getServiceAgreement());
            removeAllTags();
            clickOnWithAction(btnCreateJob, "Button Create Job");
            return new ResourceAllocationModal(driver);
        } catch (Exception e) {
            new Results(driver).setFailedBy(e.getMessage());
            Assert.assertTrue(Results.result);
        }
        return null;
    }

    public JobEditModal updateAllocatedResource(String resourceName) {
        LOGGER.info("Updating allocated resources..");
        try {
            Thread.sleep(5000);
            clickOnWithAction(driver.findElement(By.xpath(String.format(sAvailableResource, resourceName))), resourceName);
            clickOnWithAction(btnAllocate, "Button Allocate");
            clickOnWithAction(btnUpdateJob, "Button Update Job");
            return new JobEditModal(driver);
        } catch (Exception e) {
            new Results(driver).setFailedBy(e.getMessage());
            Assert.assertTrue(Results.result);
        }
        return null;
    }


    private void removeAllTags() throws Exception {
        try {
            Thread.sleep(1000);
            for (WebElement btnRemove : listBtnTagsRemove) {
                clickOnWithAction(btnRemove, "Button Tag remove");
            }
        } catch (NoSuchElementException|InterruptedException e) {
            LOGGER.error(e.getMessage());
            throw e;
        }
    }

    private void removeSpecificTags(List<String> tagsName) {

    }


    private void selectServiceAgreement(String service) throws Exception {
        try {
            Thread.sleep(1000);
            clickOn(driver.findElement(By.xpath(String.format(sServiceAgreement, service))), "Option " + service);
        } catch (NoSuchElementException | InterruptedException ex) {
            LOGGER.error(ex.getMessage());
            throw ex;
        }
    }

    private void selectAddress(String address) throws Exception {
        try {
            Thread.sleep(2000);
            clickOnWithAction(btnAddressRemove, "Button Address Remove");
            sendTextWithAction(inputAddress, "Input Address", address);
            Thread.sleep(200);
            clickOnWithAction(driver.findElement(By.xpath(String.format(sListAddress, address))), "Option " + address);
        } catch (NoSuchElementException | InterruptedException ex) {
            LOGGER.error(ex.getMessage());
            throw ex;
        }
    }

    private void selectRegion(String region) throws Exception {
        try {
            Thread.sleep(2000);
            clickOnWithAction(btnRegionRemove, "Button Region Remove");
            clickOnWithAction(driver.findElement(By.xpath(String.format(sListRegion, region))), "Option " + region);
        } catch (NoSuchElementException | InterruptedException ex) {
            LOGGER.error(ex.getMessage());
            throw ex;
        }
    }

}
