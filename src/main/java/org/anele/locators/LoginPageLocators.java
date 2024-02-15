package org.anele.locators;

public interface LoginPageLocators {
    public String dashboardLocator = "//h6[@class=\"oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module\"]";
    public String emailInput = "//input[@placeholder='Username']";
    public String passwordInput = "//input[@placeholder='Password']";
    public String forgotPassword = "//a[@class='p-s ttu']";
    public String loginBtn = "//button[@type='submit']";
    public String loginWithFacebook = ".btn.btn-facebook.btn-social.btn--full";
    public String rememberMeCheckbox = "//label[@for='rememberMe']";
    public String requiredField = "//span[@class=\"oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message\"]";
    public String passwordInfoMessage = "//div[@class=\"help p-s is-flex\"][1]";
    //    public String landingPageHeader = "//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']";
    public String fieldRequiredWarningMessage = "//*[@id=\"ItxCategoryPage\"]/body/app-root/layout-simple/div[2]/login/div/div/div/div[2]/div/div[1]/div/form/div/div[1]/input-email/div/div/validation-error/div/div/span";

}

