package testing.testng;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class TestRetry implements IRetryAnalyzer {
    int count = 0;

    @Override
    public boolean retry(ITestResult result) {
        if (!result.isSuccess()) {
            while (count <= 1) {
                result.setStatus(ITestResult.FAILURE);
                System.out.println("Failed on case: " + result.getName());
                System.out.println("Retrying: " + (count + 1));
                count++;
                return true;
            }

        } else {
            result.setStatus(ITestResult.SUCCESS);
        }
        return false;
    }

}
