package org.anele.pages;

import org.anele.utils.BaseCore;
import org.anele.utils.GetWebElements;
import org.openqa.selenium.WebElement;

public class PIMPage extends BaseCore {

    private String clickPIMLink = "//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a";

    public static EmployeeListPage employeeListPage(){
        return new EmployeeListPage();
    }

    public void clickPIM(String link)
    {
        WebElement linkToBeClicked = GetWebElements.getXpathElement(clickPIMLink);
        if (linkToBeClicked.getText().equalsIgnoreCase(link)){
            BaseCore.clickLinks(clickPIMLink);
        }else
            System.out.println("Values do not match: ");
    }
}
