package drivers;

import constants.Paths;
import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;

public class DriverChrome extends DriverBase {
    public final String hubUrl = "http://ip:port/wd/hub";

    public DriverChrome() {

    }

    @Override
    public void setLocalDriver() {
        System.setProperty("webdriver.chrome.driver", Paths.DRIVER_CHROME);
        System.setProperty("webdriver.chrome.args", "--disable-logging");
        System.setProperty("webdriver.chrome.silentOutput", "true");

        LoggingPreferences loPreferences = new LoggingPreferences();
        loPreferences.enable(LogType.PERFORMANCE, Level.ALL);
        ChromeOptions opt = new ChromeOptions();
        opt.setCapability(CapabilityType.LOGGING_PREFS, loPreferences);
        this.driver = new ChromeDriver(opt);
    }

    @Override
    public void setRemoteDriver() {
        System.setProperty("webdriver.chrome.args", "--disable-logging");
        System.setProperty("webdriver.chrome.silentOutput", "true");
        DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
        ChromeOptions opt = new ChromeOptions();
        LoggingPreferences loPreferences = new LoggingPreferences();
        loPreferences.enable(LogType.PERFORMANCE, Level.ALL);
        opt.setCapability(CapabilityType.LOGGING_PREFS, loPreferences);
        desiredCapabilities.setCapability("chromeOptions", opt);
        desiredCapabilities.setBrowserName("chrome");
        desiredCapabilities.setPlatform(Platform.WINDOWS);
        try {
            this.driver = new RemoteWebDriver(new URL(hubUrl), desiredCapabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

}
