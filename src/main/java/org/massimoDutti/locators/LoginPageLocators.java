package org.massimoDutti.locators;

public interface LoginPageLocators {
    public String loginTitle = "//h2[contains(., \"Log in\")]";
    public String emailInput = "//input[@id='emailInput']";
    public String passwordInput = "//input[@id='passwordInput']";
    public String forgotPassword = "//a[@class='p-s ttu']";
    public String loginBtn = "//button[@type='submit']";
    public String loginWithFacebook = ".btn.btn-facebook.btn-social.btn--full";
    public String rememberMeCheckbox = "//label[@for='rememberMe']";
    public String emailInfoMessage = "//div[@class=\"help p-s is-flex\"][1]";
    public String passwordInfoMessage = "//div[@class=\"help p-s is-flex\"][1]";
    public String myAccountLink = "MY ACCOUNT";
    public String fieldRequiredWarningMessage = "//*[@id=\"ItxCategoryPage\"]/body/app-root/layout-simple/div[2]/login/div/div/div/div[2]/div/div[1]/div/form/div/div[1]/input-email/div/div/validation-error/div/div/span";

}

