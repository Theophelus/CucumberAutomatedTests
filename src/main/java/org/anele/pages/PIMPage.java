package org.anele.pages;

import org.anele.utils.BaseCore;
import org.anele.utils.GetWebElements;
import org.openqa.selenium.WebElement;

public class PIMPage extends BaseCore {

    private String clickPIMLink = "//span[normalize-space()='PIM']";

    public static EmployeeListPage employeeListPage(){
        return new EmployeeListPage();
    }

    public void clickPIM(String link)
    {
        WebElement linkToBeClicked = GetWebElements.getXpathElement(clickPIMLink);
        System.out.println(linkToBeClicked.getText());
        if (linkToBeClicked.getText().equalsIgnoreCase(link)){
            BaseCore.clickElementsUsingJavascript(linkToBeClicked);
        }else
            System.out.println("Values do not match: ");
    }
}
