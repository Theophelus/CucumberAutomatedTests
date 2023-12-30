package org.massimoDutti.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.massimoDutti.pages.LoginPage;
import org.massimoDutti.utils.Constant;
import org.testng.Assert;

import static org.massimoDutti.hooks.Hooks.driver;
import static org.massimoDutti.utils.ReusableMethods.acceptCookies;

public class LoginPageStepDef {

    public LoginPage LOGIN_PAGE = null;


    @Given("user landing on Massimo Dutti login Page and accept cookies")
    public void user_landing_on_massimo_dutti_login_page_and_accept_cookies() {
        driver.get(Constant.LOGIN_URL);
        LOGIN_PAGE = new LoginPage(driver);
        acceptCookies();

    }
    @When("the user validate the {string} title")
    public void the_user_validate_the_title(String string) throws Exception {
        LOGIN_PAGE.validateText(string);

    }
    @When("the user enter valid {string} and {string}")
    public void the_user_enter_valid_and(String string, String string2) throws Exception {
        LOGIN_PAGE.loginUsingCredentials(string, string2);
    }

    @And("the user clicks on the {string} buttons.")
    public void theUserClicksOnTheButtons(String arg0) throws Exception {
        LOGIN_PAGE.clickOnLoginBtn(arg0);
        Thread.sleep(7000);
    }

    @Then("the user verify {string} link from navigation bar")
    public void theUserVerifyLinkFromNavigationBar(String myAccountLink) {
        Assert.assertEquals(myAccountLink,LOGIN_PAGE.validateMyAccountLink());
    }

    @Given("the user enter username email {string} and password {string}")
    public void theUserEnterUsernameEmailAndPassword(String email, String password) throws Exception {
        LOGIN_PAGE.loginUsingCredentials(email, password);
    }

    @Then("the user validate the {string} error message")
    public void theUserValidateTheErrorMessage(String errorMessage) throws Exception {
        Assert.assertEquals(errorMessage, LOGIN_PAGE.validateWarningErrorMessage(),
                "validating error message for incorrect credentials");
    }
}
