package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import testing.DriverActions;
import testing.Results;

public class LoginPage extends DriverActions {
    private static final Logger LOGGER = LogManager.getLogger(LoginPage.class);

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(id = "username")
    WebElement inputUser;

    @FindBy(id = "password")
    WebElement inputPwd;

    @FindBy(id = "Login")
    WebElement btnLogin;

    public void enterCredentials(String username, String password) {
        LOGGER.info("Entering Salesforce credentials...");
        try {
            this.sendText(inputUser,"Username Form", username);
            this.sendText(inputPwd,"Password Form", password);
            this.clickOn(btnLogin, "Button Login");
        } catch (Exception e) {
            new Results(driver).setFailedBy(e.getMessage());
            Assert.assertTrue(Results.result);
        }
    }

}
