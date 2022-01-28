package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverBase {
    public WebDriver driver;
    public WebDriverWait wait;


    public void setLocalDriver() {

    }

    public void setRemoteDriver() {

    }

    public WebDriver runOnRemote(boolean bRemote) {
        if (driver == null) {
            if (bRemote) {
                setRemoteDriver();
            } else {
                setLocalDriver();
            }
        }
        return this.driver;
    }

}
