package org.anele.pages;
import org.anele.locators.LoginPageLocators;
import org.anele.utils.ReusableMethods;
import org.openqa.selenium.WebElement;
import static org.anele.locators.LoginPageLocators.*;
import static org.anele.utils.GetWebElements.getXpathElement;

public class LoginPage extends ReusableMethods {
    public String validateText() throws Exception {
        return getText(LoginPageLocators.dashboardLocator);
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
        }
    }

    public void landingPageLoginButton(String element) throws InterruptedException {
        clickBtn(element);
    }

    public String validateWarningErrorMessage(){
        WebElement requiredFieldWarningMessage = getXpathElement(requiredField);
        return validateLinks(requiredFieldWarningMessage);
    }
}
