package testing.testng;

import constants.Paths;
import constants.WebDriver_Props;
import drivers.DriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import utils.Result;
import pages.CommonPage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;


public class TestAnnotations extends CommonPage {
    private static final Logger LOGGER = LogManager.getLogger(TestAnnotations.class);

    @BeforeTest()
    @Parameters({"browser", "platform", "remote"})
    public void setup(@Optional("Firefox") String browser, @Optional("Window 10") String platform, @Optional("false") boolean remote) {
        LOGGER.info("Testing start on browser: " + browser);
        killDriversBeforeRun();
        this.driver = DriverFactory.runOnBrowser(browser).runOnRemote(remote);
        this.driver.manage().timeouts().implicitlyWait(WebDriver_Props.IMPLICITLY_WAIT, TimeUnit.SECONDS);
        this.wait = new WebDriverWait(this.driver, WebDriver_Props.EXPLICITLY_WAIT);
        this.actions = new Actions(this.driver);
        java.util.logging.Logger.getLogger("org.openqa.selenium").setLevel(Level.SEVERE);
        this.driver.manage().window().maximize();
        this.driver.get(Paths.URL);

    }

    @AfterMethod
    public void clearResult() {
        Result.resetResult();
    }

    @AfterTest()
    public void clearDriver() {
        this.driver.close();
        this.driver.quit();
    }

    private void killDriversBeforeRun() {
        try {
            Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
            Runtime.getRuntime().exec("taskkill /F /IM geckodriver.exe /T");
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
    }


}
