package drivers.manager;

import constants.DriverLocations;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;

import java.util.logging.Level;

public class SafariDriverManager extends DriverManager {


    @Override
    protected void createLocalDriver() {

    }

    @Override
    protected void createRemoteDriver(String gridURL, Capabilities cap) {

    }




}
