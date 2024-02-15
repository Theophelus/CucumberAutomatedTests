package org.anele.locators;

public interface LoginPageLocators {
    public String dashboardLocator = "//h6[@class=\"oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module\"]";
    public String emailInput = "//input[@placeholder='Username']";
    public String passwordInput = "//input[@placeholder='Password']";
    public String loginBtn = "//button[@type='submit']";
    public String requiredField = "//span[@class=\"oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message\"]";
    public String infoMessage = "//p[@class='oxd-text oxd-text--p oxd-alert-content-text']";

}

