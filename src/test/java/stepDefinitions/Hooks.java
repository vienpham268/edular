package stepDefinitions;

import constants.Environments;
import drivers.DriverManagerFactory;
import drivers.manager.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Hooks {

    private DriverManager driverManager;
    private static WebDriver driver;
    private DesiredCapabilities capability;
    private String sBrowser, sVersion, sPlatform, username, accesskey,gridURL, sEnvi;
    private boolean bRemote;


    @Before
    public void setUp() {
        Logger.getLogger("org.openqa.selenium").setLevel(Level.SEVERE);
        username = System.getenv("LT_USERNAME") == null ? "vienpham268" : System.getenv("LT_USERNAME");
        accesskey = System.getenv("LT_ACCESS_KEY") == null ? "2ENVs1KxpPr24K1UIHV2bM3vuMMysDs6ALxqUHuHCSFbg1rS8e" : System.getenv("LT_ACCESS_KEY");

        sBrowser = System.getProperty("browser", "chrome");
        sVersion = System.getProperty("version", "99");
        sPlatform = System.getProperty("platform", "Windows 10");
        bRemote = System.getProperty("remote") == null ? false : true;
        sEnvi = System.getProperty("envi", "");

        capability = new DesiredCapabilities();
        capability.setCapability(CapabilityType.BROWSER_NAME, sBrowser);
        capability.setCapability(CapabilityType.VERSION, sVersion);
        capability.setCapability(CapabilityType.PLATFORM_NAME, sPlatform);
        capability.setCapability("build", "Auto NAU");
        gridURL = "https://" + username + ":" + accesskey + "@hub.lambdatest.com/wd/hub";

        driverManager = DriverManagerFactory.getManager(sBrowser);
        driver = !bRemote ? driverManager.getLocalDriver() : driverManager.getRemoteDriver(gridURL, capability);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        new Environments(sEnvi);
    }

    public static WebDriver getDriver() {
        return driver;
    }

    @After
    public void tearDown(Scenario scenario) {
        if(scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png","");
        }
        if (driver != null) {
            driver.quit();
        }

    }

}
