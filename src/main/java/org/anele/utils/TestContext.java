package org.anele.utils;

import org.anele.pages.EmployeeListPage;
import org.anele.pages.HomePage;
import org.anele.pages.LoginPage;
import org.anele.pages.PIMPage;

public class TestContext {
    LoginPage loginPage;
    HomePage homePage;
    PIMPage pimPage;
    EmployeeListPage employeeListPage;
    public TestContext(){
        loginPage = new LoginPage();
        homePage = new HomePage();
        pimPage = new PIMPage();
        employeeListPage = new EmployeeListPage();
    }
    public LoginPage getLoginPage() {
        return loginPage;
    }
    public HomePage getHomePage() {
        return homePage;
    }
    public PIMPage getPimPage() {
        return pimPage;
    }

    public EmployeeListPage getEmployeeListPage() {
        return employeeListPage;
    }
}
