package org.anele.pages;

import org.anele.locators.FooterLocators;
import org.anele.locators.LandingPageElements;
import org.anele.utils.GetWebElements;
//import org.massimoDutti.utils.Navigates;
import org.anele.utils.Navigations;
import org.anele.utils.BaseCore;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.anele.utils.Navigations.*;

public class FooterPage extends BaseCore {
    public String getMassimoDuttiTextHeader(String text) throws Exception {
        WebElement text1 = GetWebElements.getXpathElement(FooterLocators.massimoDuttiHeader);
        return (text1.getText().equals(text)) ? text1.getText() : "";
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
    //handle default Market pop up 
    public void switchToPopupAndAccept(String element) {
        WebElement popup = GetWebElements.getXpathElement(LandingPageElements.defaultMarketPopup);
        String yesBtn = GetWebElements.getXpathElement(LandingPageElements.clickYesText).getText();
        switchToPopupAndClick(popup, yesBtn.equalsIgnoreCase(element));
    }
}
