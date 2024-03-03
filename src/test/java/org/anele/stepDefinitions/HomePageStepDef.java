package org.anele.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.anele.pages.HomePage;
import org.testng.Assert;

public class HomePageStepDef {
    private HomePage HOME_PAGE;
    @Given("User accesses the OrangeHRM Management Login page")
    public void userAccessesTheOrangeHRMManagementLoginPage() {
        HOME_PAGE = new HomePage();
    }

    @When("the User enters Admin Credentials and clicks Login btn")
    public void theUserEntersAdminCredentialsAndClicksLoginBtn() {
        HOME_PAGE.fillInLoginFormAsAdmin();
        HOME_PAGE.clickOnLoginBtn();
    }

    @Then("the User should be successfully logged in and directed to the Dashboard, where the {string} header text is verified.")
    public void theUserShouldBeSuccessfullyLoggedInAndDirectedToTheDashboardWhereTheHeaderTextIsVerified(String value) throws Exception {
        Assert.assertEquals(HOME_PAGE.validateText(), value,
                "Dashboard header text could not be validated.");
    }
}
