package org.anele.utils;

import org.anele.locators.LandingPageElements;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.NoSuchElementException;

public class Navigations {
    private static WebDriver wedriver = null;

    public Navigations(WebDriver driver) {
        wedriver = driver;
    }

    public void navigateBack() {
        wedriver.navigate().back();
    }

    /*
    define  a method with 2 parameters, one for the link to be clicked, another to the list of links
    filter the list check the current link from the list is equals the value of the link to be clicked
    if true extract the href attribute of the link,
    check if the href contains a value
    then open the window on new tab
    else fail the method
     */
    public static void openLinkOnANewTabUsingJavaScript(String linkToBeClicked,
                                                        List<WebElement> elements) throws InterruptedException {
        for (WebElement element : elements) {
            try {
                if (element.getText().trim().equalsIgnoreCase(linkToBeClicked.trim())) {
                    //get attribute of the element/link
                    String linkUrl = element.getAttribute("href");
                    if (linkUrl != null && !linkUrl.isEmpty()) {
                        //call open new tab method
                        openNewTab(element);
                        return;
                    } else
                        throw new NoSuchElementException("Link " + linkToBeClicked + " is not visible in the given elements.");
                }

            } catch (Exception e) {
                System.out.println("Exception occurred: " + e.getMessage());
            }
        }
    }

    //Click the list of web elements using Actions object
    public static void openAListOfLinksUsingActions(String linkToBeClicked,
                                                    List<WebElement> elements) {

        Actions actions = new Actions(wedriver);

        for (WebElement element : elements) {
            if (element.getText().trim().equalsIgnoreCase(linkToBeClicked.trim())) {
                actions
                        .moveToElement(element)
                        .contextClick()
                        .sendKeys(Keys.CONTROL)
                        .sendKeys(Keys.RETURN)
                        .build()
                        .perform();
                return;
            }
            // If the loop completes without finding the link, log an error
            System.out.println("Link '" + linkToBeClicked + "' is not visible in the given elements.");
        }
    }

    /*
   define  a method with 1 parameter, with the list of links
   define another list of static links to be clicked and stringBuilder to build links not found, and index to control the static list
   filter the list check the current link from the list is equals the value of the link to be clicked
   if true extract the href attribute of the link,
   check if the href contains a value
   then open the window on new tab
   increment the i
   else fail the method
    */
    public static void clickAllTheSocialMediaLinksAndOpenOnNewTab(List<WebElement> elements) {
        String[] staticLinks = {"INSTAGRAM", "X", "TIKTOK", "FACEBOOK", "PINTEREST", "YOUTUBE"};
        int i = 0;
        StringBuilder builder = new StringBuilder();

        if (!elements.isEmpty()) {
            for (WebElement element : elements) {
                if (element.getText().trim().equalsIgnoreCase(staticLinks[i])) {

                    String currentLinkToBeOpen = element.getAttribute("href");
                    JavascriptExecutor js = (JavascriptExecutor) wedriver;
                    js.executeScript("window.open('" + currentLinkToBeOpen + "', '_blank')");
                    i++;

                } else {
                    builder.append(staticLinks[i]).append(", ");
                    System.out.println("Link " + staticLinks[i] + " is not visible in the given elements.");
                }
            }
        }
        if (builder.length() > 0) {
            throw new NoSuchElementException("Link " + staticLinks[i] + " is not visible in the given elements.");
        }
    }
    /*
    get attribute of the element and open in new tab using switchTo().newWindow()
     */
    public static void openNewTab(WebElement element) {
        String hrefLink = element.getAttribute("href");
        wedriver.switchTo().newWindow(WindowType.TAB).get(hrefLink);
    }

    //handle popups using frames
    public static WebElement handlePopup(WebElement element) {
        return element;
    }

    public static void switchToPopupAndClick(WebElement decisionBtn, boolean clickYes) {
        try {
            BaseCore.customWaitForSingleElement(decisionBtn, 10);
            handlePopup(decisionBtn);
            if (clickYes) {
                GetWebElements.getXpathElement(LandingPageElements.clickYesText).click();
            } else {
                GetWebElements.getXpathElement(LandingPageElements.clickNoText).click();
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }
}
