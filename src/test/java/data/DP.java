package data;

import org.testng.annotations.DataProvider;

public class DP {
    @DataProvider(name = "valid_queries")
    public Object[][] getQueriesInput() {
        return new Object[][]{{"Miami"}, {"Miami, US"}};
    }

    @DataProvider(name = "invalid_queries")
    public Object[][] getInvalidQueriesInput() {
        return new Object[][]{{"Miamimi"}, {"Miami, VN"}};
    }
}
