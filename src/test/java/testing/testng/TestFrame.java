package testing.testng;

import org.testng.Assert;
import utils.Result;

public abstract class TestFrame {
    public String testID;

    public abstract void steps();

    public TestFrame(String testID) {
        this.testID = testID;
    }

    public void run() {
        steps();
        verify();
    }

    private void verify() {
        Assert.assertTrue(Result.result);
    }

}
