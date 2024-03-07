package org.anele.stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.anele.pages.HomePage;
import org.anele.utils.TestContext;
import org.testng.Assert;

import java.util.List;

public class HomeStepDef {
    private final TestContext homePage;
    public HomeStepDef(TestContext context){
        this.homePage = context;
    }

    @Then("^the User should be successfully logged in and directed to the Dashboard, where the (.*) header text is verified.$")
    public void theUserShouldBeSuccessfullyLoggedInAndDirectedToTheDashboardWhereTheHeaderTextIsVerified(String value) throws Exception {
        Assert.assertEquals(homePage.getHomePage().validateText(), value,
                "Dashboard header text could not be validated.");
        Thread.sleep(10000);
    }

    @Then("^the user validates all the sidebar navigation links on OrangeHRM Management page site:$")
    public void theUserValidatesAllTheSidebarNavigationLinksOnOrangeHRMManagementPageSite(List<String> sideBarLinks) {
        System.out.println("List of side bars: " + sideBarLinks.size());
        List<String> list = homePage.getHomePage().validateSideLinks(sideBarLinks);
        Assert.assertEquals(sideBarLinks.size(), list.size(), "List size doesn't match.");
    }

    @Then("^dashboard on the sidebar navigation should be pre-selected (.*)$")
    public void dashboardOnTheSidebarNavigationShouldBePreSelectedDashboard(String value) {
        Boolean activeSidebarLink = homePage.getHomePage().validateOnLandingFromHomePageDashboardIsPreSelected(value);
        Assert.assertTrue(activeSidebarLink,
                "'"+value+"' is not what is expected");

    }
}
