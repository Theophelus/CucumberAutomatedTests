package org.anele.pages;

import org.anele.utils.GetWebElements;
import org.openqa.selenium.WebElement;

public class EmployeeListPage {
    private String employeeListTab = "//a[normalize-space()='Employee List']";
    public boolean validateEmployeeListTabPreselected(){
        WebElement element = GetWebElements.getXpathElement(employeeListTab);
        return element.getAttribute("class").contains("active");

    }

}
