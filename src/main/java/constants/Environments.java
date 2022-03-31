package constants;

import org.jetbrains.annotations.NotNull;

public class Environments {
    public static String baseURL;


    public Environments(@NotNull String sEnvi) {
        switch (sEnvi.toUpperCase()) {
            case "PROD":
                this.baseURL = "https://google.com.vn";
                break;
            case "STAGING":
                this.baseURL = "http://bongda.com.vn";
                break;
            case "DEV":
                this.baseURL = "https://tinhte.vn";
                break;
            default:
                this.baseURL = "https://nau.edular.app/";
                break;
        }
    }



}
