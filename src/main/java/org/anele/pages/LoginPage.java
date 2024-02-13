package org.anele.pages;

import org.anele.base.PageDriver;
import org.anele.locators.LoginPageLocators;
import org.anele.utils.ReusableMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.anele.locators.LoginPageLocators.*;
import static org.anele.utils.GetWebElements.getByLink;
import static org.anele.utils.GetWebElements.getXpathElement;
import static org.anele.utils.ReusableMethods.*;

public class LoginPage extends ReusableMethods {
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
