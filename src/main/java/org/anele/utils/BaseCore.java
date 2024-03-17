package org.anele.utils;

import org.anele.base.PageDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import static org.anele.locators.LandingPageElements.*;
import static org.anele.utils.GetWebElements.*;

public class BaseCore {

    public static void setValues(By input, String value) {
        WebElement element = PageDriver.getWebDriver().findElement(input);
        String value1 = element.getAttribute("value");
        if (!value1.isEmpty()) {
            element.clear();
        } else
            element.sendKeys(value);
    }

    public static void clickOnBtn(String element) {
        customWaitForSingleElement(getXpathElement(element), 10);
        getXpathElement(element).click();
    }

    public static String checkText(String value) {
        return getByName(value).getText();
    }

    public static boolean checkPartialLink(String link) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return PageDriver.getWebDriver().getCurrentUrl().equals(link);
    }

    public static String validateHeader(String locator) {

        return PageDriver.getWebDriver().findElement(By.name(locator)).getText();
    }

    public static String hasButtonValue(String value) {
        return "//button[normalize-space()='" + value + "']";
    }

    public static String hasLinkValue(String value) {
        return "//a[normalize-space()='" + value + "']";
    }

    //define an explicit wait method
    public static void customWaitForAListOfElements(List<WebElement> element, int waitInSeconds) {
        WebDriverWait wait = new WebDriverWait(PageDriver.getWebDriver(), Duration.ofSeconds(waitInSeconds));
        wait.until(ExpectedConditions.visibilityOfAllElements(element));
    }

    public static void filterList(List<WebElement> elements, String value) {

        if (!elements.isEmpty()) {
            for (WebElement list : elements) {
                if (list.isDisplayed() && list.getText().equals(value)) {
                    list.click();
                    break;
                }
            }
        } else
            throw new NoSuchElementException("Provided " + value + " can not be located");
    }

    public static void customWaitForSingleElement(WebElement element, int waitInSeconds) {
        WebDriverWait wait = new WebDriverWait(PageDriver.getWebDriver(), Duration.ofSeconds(waitInSeconds));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void clickBtn(String btn) {
        boolean displayed = getXpathElement(hasButtonValue(btn)).isDisplayed();

        try {
            if (displayed) {
                getXpathElement(hasButtonValue(btn)).click();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void clickLinks(String value) {
        WebElement xpathElement = getXpathElement(value);
        try {
            if (xpathElement.getText().equalsIgnoreCase(value)) {
                xpathElement.click();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void waitForElementToBeClicked(WebElement element, int timeInSeconds) {
        WebDriverWait wait = new WebDriverWait(PageDriver.getWebDriver(), Duration.ofSeconds(timeInSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static String getText(String element) throws Exception {
        try {

            customWaitForSingleElement(getXpathElement(element), 10);
            WebElement selectedElement = getXpathElement(element);
            return selectedElement.getText();

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Validation failed: " + e.getMessage());
        }
    }

    public static void enter(String element) throws Exception {

        WebElement element1 = getXpathElement(element);

        try {
            if (element1.isDisplayed())
                element1.sendKeys(Keys.ENTER);
            else
                element1.click();

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Validation failed: " + e.getMessage());
        }
    }

    public static void setRequiredField(WebElement webElement,
                                        String userInput) throws Exception {
        String valueAttribute = getValue(webElement);
        try {
            if (!valueAttribute.isEmpty()) {
                webElement.sendKeys(Keys.BACK_SPACE.toString().repeat(valueAttribute.length()));
            }
            webElement.sendKeys(userInput);

        } catch (Exception e) {
            String message = e.getMessage();
            System.out.println("Value is not available: " + message);
        }
    }

    public static String getValue(WebElement element) {
        return element.getAttribute("value");
    }

    public static String validateLinks(WebElement element) {

        WebElement linkToBeVerified = waitForElementPresent(element);
        try {
            if (linkToBeVerified.isDisplayed())
                return linkToBeVerified.getText();

        } catch (Exception e) {
            System.out.printf("Link to be verified " + element.getText() + " can't be found " + e.getMessage() + "");
        }
        return null;
    }

    public static WebElement waitForElementPresent(WebElement element) {
        WebDriverWait wait = new WebDriverWait(PageDriver.getWebDriver(), Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void smoothScrollToElement() {
        JavascriptExecutor js = (JavascriptExecutor) PageDriver.getWebDriver();
        js.executeScript("window.scrollTo({ top: document.body.scrollHeight, behavior: 'smooth' });");
        // Wait for a moment to allow the scroll to complete
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void clickElementsUsingJavascript(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor)
                PageDriver.getWebDriver();
        waitForElementToBeClicked(element, 10);
        js.executeScript("arguments[0].click();", element);

    }
}


