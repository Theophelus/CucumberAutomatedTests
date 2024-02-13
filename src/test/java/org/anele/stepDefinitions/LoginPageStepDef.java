package org.anele.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.anele.base.PageDriver;
import org.anele.pages.LoginPage;
import org.anele.utils.Constant;

public class LoginPageStepDef {
    private LoginPage LOGIN_PAGE = null;

    @Given("user landing to Orange HRM login Page")
    public void user_landing_to_orange_hrm_login_page() throws InterruptedException {
        LOGIN_PAGE = new LoginPage();

    }

    @When("the user enter username email {string} and password {string}")
    public void the_user_enter_username_email_and_password(String email, String password) throws Exception {
        LOGIN_PAGE.loginUsingCredentials(email, password);
        Thread.sleep(60000);
    }

}
