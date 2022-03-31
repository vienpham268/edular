package ex_report;

import com.relevantcodes.extentreports.ExtentReports;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Extent_Manager {
    private static ExtentReports extent;

    public synchronized static ExtentReports getReported() {
        if (extent == null) {
            extent = new ExtentReports("target/extent_report/" + System.getProperty("suite") + "-auto-"
                    + new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + "-"
                    + new SimpleDateFormat("HHmmss").format(new Date().getTime()) + ".html", false);
        }
        return extent;
    }

}
