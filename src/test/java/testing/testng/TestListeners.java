package testing.testng;

import com.relevantcodes.extentreports.LogStatus;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import testing.testreport.Extent_Manager;
import testing.testreport.Extent_Test_Manager;
import utils.Result;

public class TestListeners implements ITestListener {
//        Selenium selenium = Selenium.getInstance();
//    Selenium selenium = new Selenium();

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("-----------> " + result.getName() + " START!");
        Extent_Test_Manager.startTest(result.getName(), "");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("-----------> " + result.getName() + " PASSED!");
        Extent_Test_Manager.getTest().log(LogStatus.PASS, "PASSED");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("-----------> " + result.getName() + " FAILED!");
        for (int i = 0; i < Result.messages.size(); i++) {
            System.err.println("FAILED by: " + Result.messages.get(i));
            Extent_Test_Manager.getTest().log(LogStatus.FAIL, Result.messages.get(i),
                    Extent_Test_Manager.getTest().addBase64ScreenShot(Result.screenshots.get(i)));
        }

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("-----------> " + result.getName() + " SKIPPED!");
        Extent_Test_Manager.getTest().log(LogStatus.SKIP, "SKIPPED");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onStart(ITestContext context) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onFinish(ITestContext context) {
        Extent_Test_Manager.endTest();
        Extent_Manager.getReported().flush();
    }

}
