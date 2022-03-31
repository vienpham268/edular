package stepDefinitions;

import constants.Environments;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.NoSuchElementException;
import pages.LoginPage;


public class LoginStep extends BaseStep {
    LoginPage loginPage = new LoginPage(driver);

    @Given("User open webapp")
    public void userOpenWebapp() {
        try {
            driver.get(Environments.baseURL);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @And("User press Login Tab")
    public void userPressLoginTab() {
    }


    @When("User input his email {string}")
    public void userInputHisEmail(String email) {
        try {
            loginPage.sendText(loginPage.inputEmail, "Input Email", email);
        } catch (NoSuchElementException e) {
            e.getMessage();
        }

    }


    @And("User input his password {string}")
    public void userInputHisPassword(String pass) {
        try {
            loginPage.sendText(loginPage.inputPassword, "Input Password", pass);
        } catch (NoSuchElementException e) {
            e.getMessage();
        }
    }


    @And("User press Login button")
    public void userPressLoginButton() {

    }

    @And("User press Agree button on Privacy modal")
    public void userPressAgreeButtonOnPrivacyModal() {

    }


    @Then("User go into Home page successfully")
    public void userGoIntoHomePageSuccessfully() {

    }


}
