package drivers;

import constants.Paths;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;

public class DriverFirefox extends DriverBase {
    public final String hubUrl = "http://ip:port/wd/hub";

    public DriverFirefox() {

    }

    @Override
    public void setLocalDriver() {
        System.setProperty("webdriver.gecko.driver", Paths.DRIVER_GECKO);
        System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"true");
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        FirefoxOptions opts = new FirefoxOptions();
        this.driver = new FirefoxDriver(opts);
    }

    @Override
    public void setRemoteDriver() {


    }

}
