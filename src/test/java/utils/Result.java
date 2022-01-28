package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.CommonPage;

import java.util.ArrayList;

public class Result {
    public static boolean result = true;
    public static String base64Screenshot;
    public static ArrayList<String> messages = new ArrayList<String>();
    public static ArrayList<String> screenshots = new ArrayList<String>();

    public static void setFailedBy(String msg) {
        result = false;
        messages.add(msg);
        screenshots.add(base64Screenshot = "data:image/png;base64,"
                + ((TakesScreenshot) new CommonPage().driver).getScreenshotAs(OutputType.BASE64));
    }

    public static void resetResult() {
        result = true;
        messages = new ArrayList<String>();
        screenshots = new ArrayList<String>();
    }

}
