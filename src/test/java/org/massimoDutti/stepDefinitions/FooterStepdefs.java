package org.massimoDutti.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.massimoDutti.pages.FooterPage;
import org.massimoDutti.utils.Constant;
import org.testng.Assert;

import static org.massimoDutti.hooks.Hooks.driver;

public class FooterStepdefs {

    private static FooterPage FOOTER_PAGE;

    @Given("User landing on Massimo Dutti home page and accept cookies")
    public void userLandingOnMassimoDuttiHomePageAndAcceptCookies() throws InterruptedException {
        driver.get(Constant.HOME_PAGE_URL);
        FOOTER_PAGE = new FooterPage(driver);
        FOOTER_PAGE.acceptCookies();
    }

    @When("the user check of {string} header is visible")
    public void theUserCheckOfHeaderIsVisible(String element) throws Exception {
        FOOTER_PAGE.getMassimoDuttiTextHeader(element);
    }

    @When("the user smooth scroll to the social network footer container")
    public void theUserSmoothScrollToTheSocialNetworkFooterContainer() throws InterruptedException {
        FOOTER_PAGE.scrollToBottomOfTheScreen();
        Thread.sleep(4000);
    }

    @Then("the user validate all the social networks on Massimo dutti site {string}")
    public void theUserValidateAllTheSocialNetworksOnMassimoDuttiSite(String social) {
        Assert.assertTrue(FOOTER_PAGE.validateSocials(social), "Socials validated");
    }

    @Then("the user open social media links in a new tab {string}")
    public void theUserOpenSocialMediaLinksInANewTab(String value) throws InterruptedException {
        FOOTER_PAGE.openNewWindow(value);
        Thread.sleep(5000);
    }

    @Then("the user open all the social media links in a new tab")
    public void theUserOpenAllTheSocialMediaLinksInANewTab() throws InterruptedException {
        FOOTER_PAGE.openAllSocialMediaLinksInOneSession();
        Thread.sleep(1000);
    }
}
