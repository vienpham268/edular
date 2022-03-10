package testing.testng;

import com.relevantcodes.extentreports.LogStatus;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import testing.testreport.Extent_Manager;
import testing.testreport.Extent_Test_Manager;
import testing.Results;

public class TestListeners implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {

        Extent_Test_Manager.startTest(result.getName(), "");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Extent_Test_Manager.getTest().log(LogStatus.PASS, "PASSED");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        for (int i = 0; i < Results.messages.size(); i++) {
            System.err.println("FAILED by: " + Results.messages.get(i));
            Extent_Test_Manager.getTest().log(LogStatus.FAIL, Results.messages.get(i),
                    Extent_Test_Manager.getTest().addBase64ScreenShot(Results.screenshots.get(i)));
        }

    }

    @Override
    public void onTestSkipped(ITestResult result) {
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
