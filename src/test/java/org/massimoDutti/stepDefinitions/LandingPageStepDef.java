package org.massimoDutti.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.massimoDutti.pages.LandingPage;
import org.massimoDutti.utils.Constant;

import org.testng.Assert;

import static org.massimoDutti.hooks.Hooks.driver;

public class LandingPageStepDef {
    private static LandingPage landingPage;

    @Given("User landing on Massimo Dutti landing page and accept cookies")
    public void userLandingOnMassimoDuttiLandingPageAndAcceptCookies() {
        driver.get(Constant.URL);
        landingPage = new LandingPage(driver);
        landingPage.acceptCookies();
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
    public void theUserClicksOnTheButton(String value) throws InterruptedException {
        landingPage.clickOnGenderButtons(value);
    }

    @Then("the home page partial link is validated.")
    public void theHomePagePartialLinkIsValidated() {
        Assert.assertTrue(landingPage.validateLink());
    }
}
