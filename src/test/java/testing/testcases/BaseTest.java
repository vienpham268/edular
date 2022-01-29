package testing.testcases;

import constants.Paths;
import constants.WebDriver_Props;
import drivers.DriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utils.Results;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;


public class BaseTest {
    private static final Logger LOGGER = LogManager.getLogger(BaseTest.class);
    WebDriver driver;


    @BeforeTest()
    @Parameters({"browser", "platform", "remote"})
    public void setUp(@Optional("Chrome") String browser, @Optional("Window 10") String platform, @Optional("false") boolean remote) {
        LOGGER.info("Running on : " + browser);
        killDriversBeforeRun();
        driver = DriverFactory.runOnBrowser(browser);
        driver.manage().timeouts().implicitlyWait(WebDriver_Props.IMPLICITLY_WAIT, TimeUnit.SECONDS);
        java.util.logging.Logger.getLogger("org.openqa.selenium").setLevel(Level.SEVERE);
        driver.manage().window().maximize();
        driver.get(Paths.URL);

    }

    @AfterMethod
    public void clearResult() {
        new Results(driver).resetResult();
    }

    @AfterTest()
    public void tearDown() {
        LOGGER.info("Closing drivers..");
        if (driver != null) {
            driver.quit();
            driver = null;
        }
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
