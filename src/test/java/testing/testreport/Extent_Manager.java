package testing.testreport;

import com.relevantcodes.extentreports.ExtentReports;
import constants.Paths;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Extent_Manager {
    private static ExtentReports extent;

    public synchronized static ExtentReports getReported() {
        if (extent == null) {
            extent = new ExtentReports(Paths.REPORT_LOCATION + System.getProperty("suite") + "-auto-"
                    + new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + "-"
                    + new SimpleDateFormat("HHmmss").format(new Date().getTime()) + ".html", false);
        }
        return extent;
    }

}
