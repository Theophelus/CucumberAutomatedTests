package org.anele.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.anele.base.PageDriver;
import org.anele.pages.LoginPage;
import org.anele.utils.Constant;
import org.testng.Assert;

public class LoginPageStepDef {
    private LoginPage LOGIN_PAGE = null;
    @Given("user landing to Orange HRM login Page")
    public void user_landing_to_orange_hrm_login_page() throws InterruptedException {
        LOGIN_PAGE = new LoginPage();

    }
    @When("the user enter username email {string} and password {string}")
    public void the_user_enter_username_email_and_password(String email, String password) throws Exception {
        LOGIN_PAGE.loginUsingCredentials(email, password);
    }

    @And("the user clicks on the {string} button on Landing page.")
    public void theUserClicksOnTheButtonOnLandingPage(String button) throws InterruptedException {
        LOGIN_PAGE.landingPageLoginButton(button);
        Thread.sleep(4000);
    }

    @Then("the user validate landing page text {string}")
    public void theUserValidateLandingPageText(String element) throws Exception {
        System.out.println("DashboardValue: " + LOGIN_PAGE.validateText());
        Assert.assertEquals(LOGIN_PAGE.validateText(), element, "Validating landing page Header is " + LOGIN_PAGE.validateText() + " ");
    }

}
