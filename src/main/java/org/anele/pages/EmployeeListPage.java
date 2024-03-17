package org.anele.pages;

import org.anele.utils.BaseCore;
import org.anele.utils.GetWebElements;
import org.openqa.selenium.WebElement;

import java.util.List;

public class EmployeeListPage {
    private String employeeListTab = "//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[2]";
    private String recordsFound = "//div[@class=\"orangehrm-horizontal-padding orangehrm-vertical-padding\"]/span";
    private String personalDetailsHeader = "//h6[normalize-space()='Personal Details']";
    public boolean validateEmployeeListTabPreselected() {
        WebElement element = GetWebElements.getXpathElement(employeeListTab);
        BaseCore.waitForElementPresent(element);
        return element.getAttribute("class").contains("visited");
    }

    public Boolean validateNumberOfRecords(String value) throws Exception {

        WebElement xpathElement = GetWebElements.getXpathElement(recordsFound);
        return xpathElement.getText().contains(value) ? true : null;

    }

    public void clickEditOnSelectedRecord(String value) throws InterruptedException {
        String leftNextButton = "//i[@class=\"oxd-icon bi-chevron-right\"]";
        List<WebElement> elementForNextBtn = GetWebElements.getWebElementsByXpath(leftNextButton);
        String listOfRecords = "//div[@class=\"oxd-table-card\"]//div[normalize-space()= '"+value+"']//following-sibling::div";
        List<WebElement> elementList = GetWebElements.getWebElementsByXpath(listOfRecords);

        System.out.println("Return true: 1 " +!elementList.isEmpty());

        boolean controlLoop = false;

        while (!controlLoop) {

            if (!elementList.isEmpty()) controlLoop = true;

            else if (!elementForNextBtn.isEmpty()) {
                WebElement clickNextBtn = GetWebElements.getXpathElement("//i[@class=\"oxd-icon bi-chevron-right\"]");
                clickNextBtn.click();
                Thread.sleep(5000);
            }else {
                System.out.println("Record not found:" + value);
                controlLoop = true;
            }

            WebElement clickEditBtn = GetWebElements.getXpathElement("//div[@class=\"oxd-table-card\"]//div[normalize-space()= '"+value+"']//following-sibling::div//button[2]");
            if (clickEditBtn !=null){
                System.out.println("To be clicked: "+clickEditBtn.isDisplayed());
                clickEditBtn.click();
                controlLoop = true;
            }
        }


    }

    public String validatePersonalDetailsHeader() throws Exception {
       return BaseCore.getText(personalDetailsHeader);
    }
}
