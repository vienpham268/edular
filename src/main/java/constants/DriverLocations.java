package constants;

public class DriverLocations {

    public static class Windows {
        public static final String CHROME_DRIVER = System.getProperty("user.dir") + "/src/main/resources/drivers/window/chromedriver.exe";
        public static final String FIREFOX_DRIVER = System.getProperty("user.dir") + "/src/main/resources/drivers/window/geckodriver.exe";
    }

    public static class Mac {
        public static final String CHROME_DRIVER = System.getProperty("user.dir") + "/src/main/resources/drivers/mac/chromedriver";
    }


}
