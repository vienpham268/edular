package drivers.manager;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

public abstract class DriverManager {
    protected WebDriver driver;

    protected abstract void createLocalDriver();

    protected abstract void createRemoteDriver(String gridURL, Capabilities cap);

    public WebDriver getLocalDriver() {
        if (null == driver) {
            createLocalDriver();
        }
        return driver;
    }

    public WebDriver getRemoteDriver(String gridURL, Capabilities cap) {
        if (null == driver) {
            createRemoteDriver(gridURL, cap);
        }
        return driver;
    }


}
