package org.massimoDutti.pages;

import org.massimoDutti.locators.FooterLocators;
import org.massimoDutti.utils.GetWebElements;
import org.massimoDutti.utils.Navigates;
import org.massimoDutti.utils.ReusableMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.massimoDutti.locators.LandingPageElements.acceptCookies;
import static org.massimoDutti.utils.ReusableMethods.*;

public class FooterPage {
    public FooterPage(WebDriver driver) {
        new Navigates(driver);
        new ReusableMethods(driver);
    }

    public String getMassimoDuttiTextHeader(String text) throws Exception {
        WebElement text1 = GetWebElements.getXpathElement(FooterLocators.massimoDuttiHeader);
        return (text1.getText().equals(text)) ? text1.getText() : "";
    }

    public void acceptCookies() {
        clickBtnCookies(acceptCookies);
    }

    public void scrollToBottomOfTheScreen() {
        smoothScrollToElement();
    }

    public boolean validateSocials(String social) {
        List<WebElement> elements = GetWebElements.getWebElementsByXpath(FooterLocators.socialLinks);

        for (int i = 0; i < elements.size(); i++) {
            String currentElem = elements.get(i).getText();
            if (currentElem.equals(social)) {
                return true;
            }
        }
        return false;
    }
}
