package testing.testcases;

import data.DP;
import org.testng.annotations.Test;
import pages.CityPage;
import pages.NavBar;
import pages.SearchResultPage;
import testing.testng.TestFrame;

public class SearchWeatherTest extends BaseTest {

    @Test(dataProvider = "valid_queries", dataProviderClass = DP.class, priority = 1)

    public void validSearch(String validQuery) {
        new TestFrame("001") {
            @Override
            public void steps() {
                new NavBar(driver).searchLocation(validQuery);
                new SearchResultPage(driver).clickOnCityLink();
                new CityPage(driver).verifyPageShownCorrectly("Hanoi, VN");
            }
        }.run();
    }

    @Test(dataProvider = "invalid_queries", dataProviderClass = DP.class, priority = 2)
    public void invalidSearch(String invalidQuery) {
        new TestFrame("002") {
            @Override
            public void steps() {
                new NavBar(driver).searchLocation(invalidQuery);
                new SearchResultPage(driver).verifyNotFoundShown();
            }
        }.run();
    }

    @Test(enabled = false)
    public void emptySearch() {
        new TestFrame("003") {
            @Override
            public void steps() {
                new NavBar(driver).searchLocation("");
                new SearchResultPage(driver).clickOnCityLink();
            }
        }.run();
    }

}
