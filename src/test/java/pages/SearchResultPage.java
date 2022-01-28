package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.Result;
import utils.Verifications;

import java.util.List;

public class SearchResultPage extends CommonPage{
    private static final Logger LOGGER = LogManager.getLogger(SearchResultPage.class);


    public SearchResultPage() {
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//*[@id='forecast_list_ul']//tbody/tr")
    List<WebElement> listItem;

    @FindBy(xpath = "//*[@id='forecast_list_ul']//tbody/tr[1]//td[2]/b")
    WebElement cityLink;

    @FindBy(xpath = "//*[@id='forecast_list_ul']/div[contains(@class,'alert-warning')]")
    WebElement txt_NotFound;

    @FindBy(id = "pbar")
    WebElement progressbar;


    public void clickOnCityLink() {
        try {
            LOGGER.info("Clicking on first link...");
            this.clickOnElement(cityLink);
        } catch (Exception e) {
            Result.setFailedBy(e.getMessage());
            Assert.assertTrue(Result.result);
        }

    }


    public SearchResultPage verifyNotFoundShown() {
        new Verifications().verifyTextValueContains(txt_NotFound, "Not found text", "Not found");
        return this;
    }
}
