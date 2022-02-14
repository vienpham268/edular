package data;

import org.testng.annotations.DataProvider;

public class DP {
    @DataProvider(name = "valid_queries")
    public Object[][] getQueriesInput() {
        return new Object[][]{{"Hanoi"}, {"Ha Noi"}, {"HA NOI"}, {"Ha Noi, vn"}, {"HA NOI, VN"}, {"Hanoi,vn"}};
    }

    @DataProvider(name = "invalid_queries")
    public Object[][] getInvalidQueriesInput() {
        return new Object[][]{{"Hanoiii"}, {"Hanoi,us"}, {"Hanoi.vn"}, {"Ha    noi"}, {"31212121"}};
    }
}
