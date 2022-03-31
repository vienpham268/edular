package stepDefinitions;

import org.openqa.selenium.WebDriver;

public class BaseStep {
    protected WebDriver driver;

    public BaseStep() {
        driver = Hooks.getDriver();
    }

}
