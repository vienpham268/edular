package drivers.manager;

import constants.DriverLocations;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;

public class ChromeDriverManager extends DriverManager {


    @Override
    protected void createLocalDriver() {
        System.setProperty("webdriver.chrome.driver", DriverLocations.Windows.CHROME_DRIVER);
        System.setProperty("webdriver.chrome.args", "--disable-logging");
        System.setProperty("webdriver.chrome.silentOutput", "true");

        LoggingPreferences loPreferences = new LoggingPreferences();
        loPreferences.enable(LogType.PERFORMANCE, Level.ALL);
        ChromeOptions opt = new ChromeOptions();
        opt.setCapability(CapabilityType.LOGGING_PREFS, loPreferences);
        opt.addArguments("disable-popup-blocking");
        driver = new ChromeDriver(opt);
    }

    @Override
    protected void createRemoteDriver(String gridURL, Capabilities cap) {
        try {
            driver = new RemoteWebDriver(new URL(gridURL), cap);
        } catch (MalformedURLException e) {
            System.out.println("Invalid grid URL");
        }

    }


}
