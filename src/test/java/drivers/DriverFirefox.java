package drivers;

import constants.Paths;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFirefox extends DriverBase {
    public final String hubUrl = "http://ip:port/wd/hub";

    public DriverFirefox() {

    }

    @Override
    public WebDriver getDriver() {
        System.setProperty("webdriver.gecko.driver", Paths.DRIVER_GECKO);
        System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        FirefoxOptions opts = new FirefoxOptions();
        driver = new FirefoxDriver(opts);
        return driver;
    }

}
