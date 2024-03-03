package org.anele.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.anele.pages.LandingPage;
import org.anele.utils.Constant;

import org.testng.Assert;
public class LandingPageStepDef {
    private static LandingPage landingPage;

    @Given("User landing on Massimo Dutti landing page and accept cookies")
    public void userLandingOnMassimoDuttiLandingPageAndAcceptCookies() throws InterruptedException {
//        driver.get(Constant.BASE_URL);
        landingPage = new LandingPage();
    }
    @Given("the user clicks on the Select Location button")
    public void theUserClicksOnTheSelectLocationButton() {
        landingPage.clickSelectLocationBtn();
    }

    @And("the user selects a {string}, then clicks on the {string} and selects a {string}")
    public void theUserSelectsAThenClicksOnTheAndSelectsA(String region, String country, String language) throws InterruptedException {
        landingPage.selectLocation(region, country, language);
    }

    @Then("the select Location button should display {string}.")
    public void theSelectLocationButtonShouldDisplay(String value) throws Exception {
        Assert.assertEquals(landingPage.validateLocation(), value);
    }

    @And("the user clicks on the {string} button.")
    public void theUserClicksOnTheButton(String button) throws InterruptedException {
        landingPage.clicksOnLoginButton(button);
    }

    @Then("the home page partial link is validated.")
    public void theHomePagePartialLinkIsValidated() {
        Assert.assertTrue(landingPage.validateLink());
    }
}
