package org.anele.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.anele.pages.EmployeeListPage;
import org.anele.pages.PIMPage;
import org.anele.utils.TestContext;
import org.testng.Assert;

public class EmployeeListStepDef {

    private final PIMPage PIM_PAGE;
    private final EmployeeListPage EMPLOYEE_LIST_PAGE;

    public EmployeeListStepDef(TestContext context){
        this.PIM_PAGE = context.getPimPage();
        this.EMPLOYEE_LIST_PAGE = context.getEmployeeListPage();
    }
    @And("^the User navigates to (.*) page$")
    public void theUserClicksOnTheLink(String value) throws InterruptedException {
        PIM_PAGE.clickPIM(value);
        Thread.sleep(10000);
    }
    @Then("^the Employee List Tab should be pre selected$")
    public void employeeListTabIsPreSelected() {
        Assert.assertTrue(EMPLOYEE_LIST_PAGE.validateEmployeeListTabPreselected(),
                "Employee List Tab is not preselected");
    }
}
