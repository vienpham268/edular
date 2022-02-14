package drivers;

import constants.Paths;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;

import java.util.logging.Level;

public class DriverChrome extends DriverBase {

    public DriverChrome() {

    }

    @Override
    public WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", Paths.DRIVER_CHROME);
        System.setProperty("webdriver.chrome.args", "--disable-logging");
        System.setProperty("webdriver.chrome.silentOutput", "true");

        LoggingPreferences loPreferences = new LoggingPreferences();
        loPreferences.enable(LogType.PERFORMANCE, Level.ALL);
        ChromeOptions opt = new ChromeOptions();
        opt.setCapability(CapabilityType.LOGGING_PREFS, loPreferences);

        driver = new ChromeDriver(opt);
        return driver;
    }



}
