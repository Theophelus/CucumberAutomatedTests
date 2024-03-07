package org.anele.pages;

import com.aventstack.extentreports.util.Assert;
import org.anele.utils.BaseCore;
import org.anele.utils.GetWebElements;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BaseCore {
    private String dashboardHeader = "//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']";
    private String listOfEl = "//ul[@class=\"oxd-main-menu\"]//li//span";
    private String listOfLinks = "//ul[@class=\"oxd-main-menu\"]//li//a";

    public String validateText() throws Exception {
        System.out.println("Home page Dashboard text: " + BaseCore.getText(dashboardHeader));
        return BaseCore.getText(dashboardHeader);

    }

    public List<String> validateSideLinks(List<String> expectedLink) {
        List<WebElement> elements = GetWebElements.getWebElementsByXpath(listOfEl);
        List<String> matchingText = new ArrayList<>();
        int index = 0;

        if (elements.size() != expectedLink.size()) {
            System.out.println("List of elements doesn't match");
        }

        for (WebElement element : elements) {
            String actualValue = element.getText();
            if (actualValue.equalsIgnoreCase(expectedLink.get(index))) {
                matchingText.add(actualValue);
                index++;
            } else
                System.out.println("Provided '" + expectedLink + "' do not match: " + "Expected: " +
                        "'" + expectedLink + "', Actual '" + actualValue + "' ");
        }

        return matchingText;
    }

    public Boolean validateOnLandingFromHomePageDashboardIsPreSelected(String value){

        List<WebElement> elementList = GetWebElements.getWebElementsByXpath(listOfLinks);

        for (WebElement element: elementList){

            boolean linkWithActiveStatus = element.getAttribute("class").contains("active");
            if (linkWithActiveStatus && element.getText().equalsIgnoreCase(value)){
                System.out.println("It's match");
                return true;
            }
        }

        return false;
    }
}
