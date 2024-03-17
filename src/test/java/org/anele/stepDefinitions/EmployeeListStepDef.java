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
    }
    @Then("^the Employee List Tab should be pre selected$")
    public void employeeListTabIsPreSelected() {
        Assert.assertTrue(EMPLOYEE_LIST_PAGE.validateEmployeeListTabPreselected(),
                "Employee List Tab is not preselected");
    }

    @Then("^the (.*) text is visible$")
    public void theTextIsVisible(String value) throws Exception {
        Assert.assertTrue(EMPLOYEE_LIST_PAGE.validateNumberOfRecords(value),
                "No records found");
    }

    @Then("^click on the (.*) record from the list$")
    public void clickOnTheRecordFromTheList(String value) throws InterruptedException {
        EMPLOYEE_LIST_PAGE.clickEditOnSelectedRecord(value);
    }

    @Then("the User validates {string} header text")
    public void theUserValidatesHeaderText(String value) throws Exception {
        Assert.assertEquals(EMPLOYEE_LIST_PAGE.validatePersonalDetailsHeader(), value,
                " '"+value+"' did not match: ");
    }
}
