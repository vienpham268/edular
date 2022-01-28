package testing.testcases;

import data.DP;
import org.testng.annotations.Test;
import pages.CityPage;
import pages.NavBar;
import pages.SearchResultPage;
import testing.testng.TestAnnotations;
import testing.testng.TestFrame;

public class VerifyLocalWeather extends TestAnnotations {

    @Test(dataProvider = "valid_queries", dataProviderClass = DP.class,priority = 1)
    public void validSearch(String validQuery) {
        new TestFrame("001") {
            @Override
            public void steps() {
                new NavBar().searchLocation(validQuery);
                new SearchResultPage().clickOnCityLink();
                new CityPage().verifyPageShownCorrectly(validQuery);
            }
        }.run();
    }

    @Test(dataProvider = "invalid_queries", dataProviderClass = DP.class,priority = 2)
    public void invalidSearch(String invalidQuery) {
        new TestFrame("002") {
            @Override
            public void steps() {
                new NavBar().searchLocation(invalidQuery);
                new SearchResultPage().verifyNotFoundShown();
            }
        }.run();
    }

    @Test(enabled = false)
    public void emptySearch() {
        new TestFrame("003") {
            @Override
            public void steps() {
                new NavBar().searchLocation("");
                new SearchResultPage().clickOnCityLink();
            }
        }.run();
    }

}
