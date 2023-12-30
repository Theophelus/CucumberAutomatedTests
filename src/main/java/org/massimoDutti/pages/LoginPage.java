package org.massimoDutti.pages;

import org.massimoDutti.locators.LoginPageLocators;
import org.massimoDutti.utils.GetWebElements;
import org.massimoDutti.utils.ReusableMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Objects;

import static org.massimoDutti.locators.LoginPageLocators.*;
import static org.massimoDutti.utils.GetWebElements.getByLink;
import static org.massimoDutti.utils.GetWebElements.getXpathElement;
import static org.massimoDutti.utils.ReusableMethods.*;

public class LoginPage {

    public static final GetWebElements GET_WEB_ELEMENTS = null;

    public LoginPage(WebDriver driver) {
        new ReusableMethods(driver);
    }

    public boolean validateText(String value) throws Exception {
       return getText(LoginPageLocators.loginTitle).equals(value);
    }
    public void loginUsingCredentials(String email, String password) throws Exception {
        WebElement emailElements = getXpathElement(LoginPageLocators.emailInput);
        WebElement passwordElements = getXpathElement(LoginPageLocators.passwordInput);
        setRequiredField(emailElements, email);
        setRequiredField(passwordElements, password);
    }
    public void clickOnLoginBtn(String element) throws InterruptedException {

        WebElement btn = getXpathElement(LoginPageLocators.loginBtn);
        if (btn.getText().equals(element)){
            btn.click();
            Thread.sleep(10000);
        }
    }

    public String validateMyAccountLink(){
        WebElement byLink = getByLink(myAccountLink);
        return validateLinks(byLink);
    }
    public String validateWarningErrorMessage(){
        WebElement requiredFieldWarningMessage = getXpathElement(emailInfoMessage);
        return validateLinks(requiredFieldWarningMessage);
    }
}
