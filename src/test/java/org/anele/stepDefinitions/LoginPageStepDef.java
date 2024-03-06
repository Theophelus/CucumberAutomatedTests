package org.anele.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.anele.utils.TestContext;

public class LoginPageStepDef {
    private final TestContext login;
     public LoginPageStepDef(TestContext context){
         this.login = context;
     }

    @Given("^User accesses the OrangeHRM Management Login page$")
    public void userAccessesTheOrangeHRMManagementLoginPage() {
    }
    @When("^the User enters Admin Credentials and clicks Login btn$")
    public void theUserEntersAdminCredentialsAndClicksLoginBtn() throws InterruptedException {
        login.getLoginPage().fillInLoginFormAsAdmin();
        login.getLoginPage().clickOnLoginBtn();
        Thread.sleep(5000);
    }

}
