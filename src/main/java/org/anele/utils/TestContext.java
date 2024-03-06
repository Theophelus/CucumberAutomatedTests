package org.anele.utils;

import org.anele.pages.HomePage;
import org.anele.pages.LoginPage;

public class TestContext {
    LoginPage loginPage;
    HomePage homePage;
    public TestContext(){
        loginPage = new LoginPage();
        homePage = new HomePage();
    }
    public LoginPage getLoginPage() {
        return loginPage;
    }

    public HomePage getHomePage() {
        return homePage;
    }
}
