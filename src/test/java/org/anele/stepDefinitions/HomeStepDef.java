package org.anele.stepDefinitions;

import io.cucumber.java.en.Then;
import org.anele.utils.TestContext;
import org.testng.Assert;

public class HomeStepDef {
    private final TestContext homePage;
    public HomeStepDef(TestContext context){
        this.homePage = context;
    }

    @Then("the User should be successfully logged in and directed to the Dashboard, where the (.*) header text is verified.$")
    public void theUserShouldBeSuccessfullyLoggedInAndDirectedToTheDashboardWhereTheHeaderTextIsVerified(String value) throws Exception {
        Assert.assertEquals(homePage.getHomePage().validateText(), value,
                "Dashboard header text could not be validated.");
        Thread.sleep(10000);
    }
}
