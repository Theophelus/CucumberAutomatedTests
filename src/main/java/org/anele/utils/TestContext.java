package org.anele.utils;

import org.anele.models.employees.AddEmployee;
import org.anele.pages.*;

public class TestContext {
    LoginPage loginPage;
    HomePage homePage;
    PIMPage pimPage;
    EmployeeListPage employeeListPage;
    AddEmployeePage addEmployeePage;
    public TestContext(){
        loginPage = new LoginPage();
        homePage = new HomePage();
        pimPage = new PIMPage();
        employeeListPage = new EmployeeListPage();
        addEmployeePage = new AddEmployeePage();
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
    public AddEmployeePage getAddEmployee() {
        return addEmployeePage;
    }
}
