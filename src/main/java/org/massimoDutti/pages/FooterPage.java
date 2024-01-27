package org.massimoDutti.pages;

import org.massimoDutti.locators.FooterLocators;
import org.massimoDutti.utils.GetWebElements;
//import org.massimoDutti.utils.Navigates;
import org.massimoDutti.utils.Navigations;
import org.massimoDutti.utils.ReusableMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.massimoDutti.locators.LandingPageElements.acceptCookies;
import static org.massimoDutti.utils.Navigations.*;
import static org.massimoDutti.utils.ReusableMethods.*;

public class FooterPage {
    public FooterPage(WebDriver driver) {
        new Navigations(driver);
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

    //open specific social link on a new tab
    public void openNewWindow(String social) throws InterruptedException {
        List<WebElement> elements = GetWebElements.getWebElementsByXpath(FooterLocators.socialLinks);
        openLinkOnANewTabUsingJavaScript(social, elements);
    }

    //open all social media links in a new tab
    public void openAllSocialMediaLinksInOneSession() {
        List<WebElement> elements = GetWebElements.getWebElementsByXpath(FooterLocators.socialLinks);
        Navigations.clickAllTheSocialMediaLinksAndOpenOnNewTab(elements);
    }
}
