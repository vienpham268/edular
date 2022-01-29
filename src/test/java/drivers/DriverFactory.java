package drivers;

import org.openqa.selenium.WebDriver;

public class DriverFactory {

    public static WebDriver runOnBrowser(String sEnvi) {
        WebDriver driver;
        switch (sEnvi) {
            case "Firefox":
                driver = new DriverFirefox().getDriver();
                break;

            default:
                driver = new DriverChrome().getDriver();
                break;
        }

        return driver;
    }


}
