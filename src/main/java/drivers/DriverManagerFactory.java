package drivers;

import drivers.manager.ChromeDriverManager;
import drivers.manager.DriverManager;
import drivers.manager.FirefoxDriverManager;
import drivers.manager.SafariDriverManager;

public class DriverManagerFactory {

    public static DriverManager getManager(String driverType) {
        DriverManager manager;
        switch (driverType.toUpperCase()) {
            case "SAFARI":
                manager = new SafariDriverManager();
                break;
            case "FIREFOX":
                manager = new FirefoxDriverManager();
                break;
            default:
                manager = new ChromeDriverManager();
                break;
        }

        return manager;
    }


}
