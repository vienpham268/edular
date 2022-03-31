package drivers.manager;

import constants.DriverLocations;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;

import java.util.logging.Level;

public class FirefoxDriverManager extends DriverManager {

    @Override
    protected void createLocalDriver() {
        System.setProperty("webdriver.gecko.driver", DriverLocations.Windows.FIREFOX_DRIVER);
        FirefoxOptions opt = new FirefoxOptions();
        opt.addArguments("disable-popup-blocking");
        driver = new FirefoxDriver(opt);
    }

    @Override
    protected void createRemoteDriver(String gridURL, Capabilities cap) {

    }
}
