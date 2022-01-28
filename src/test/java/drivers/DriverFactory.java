package drivers;

public class DriverFactory {

    public static DriverBase runOnBrowser(String sEnvi) {
        DriverBase baseDriver;
        switch (sEnvi) {
            case "Firefox":
                baseDriver = new DriverFirefox();
                break;

            default:
                baseDriver = new DriverChrome();
                break;
        }

        return baseDriver;
    }
}
