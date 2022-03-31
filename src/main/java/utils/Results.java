package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class Results {
    WebDriver driver;
    public static boolean result = true;
    public static String base64Screenshot;
    public static ArrayList<String> messages = new ArrayList<String>();
    public static ArrayList<String> screenshots = new ArrayList<String>();

    public Results(WebDriver driver){
        this.driver = driver;
    }
    public  void setFailedBy(String msg) {
        result = false;
        messages.add(msg);
        screenshots.add(base64Screenshot = "data:image/png;base64,"
                + ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64));
    }

    public static void resetResult() {
        result = true;
        messages = new ArrayList<String>();
        screenshots = new ArrayList<String>();
    }

}
