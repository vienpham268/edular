package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverBase {
    public WebDriver driver;
    public WebDriverWait wait;
    public Actions actions;

    public WebDriver getDriver() {
        return this.driver;
    }

//    public void setRemoteDriver() {
//
//    }

//    public WebDriver getDriver(boolean bRemote) {
//        if (driver == null) {
//            if (bRemote) {
//                setRemoteDriver();
//            } else {
//                setLocalDriver();
//            }
//        }
//        return this.driver;
//    }

}
