package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Verifications;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CityPage extends Selenium {

    public CityPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//div[@class='current-container mobile-padding']/div[1]/span[@class='orange-text']")
    WebElement txt_Date;

    @FindBy(xpath = "//div[@class='current-container mobile-padding']/div[1]/h2")
    WebElement txt_CityName;

    @FindBy(xpath = "//div[@class='current-temp']/span[@class='heading']")
    WebElement txt_CurrentTemp;

    private String getCurrentDate() {
        SimpleDateFormat format = new SimpleDateFormat("MMMM dd ");
        String[] currentDateArr = format.format(new Date()).split(" ");
        String month = currentDateArr[0].substring(0, 3);
        return month.concat(" ").concat(currentDateArr[1]);
    }


    public void verifyPageShownCorrectly(String sCity) {
        new Verifications(driver).verifyTextValueContains(txt_Date, "Date", getCurrentDate());
        new Verifications(driver).verifyTextValueContains(txt_CityName, "City Name", sCity);
        new Verifications(driver).verifyElementDisplay(txt_CurrentTemp, "Current Temp");
    }
}
