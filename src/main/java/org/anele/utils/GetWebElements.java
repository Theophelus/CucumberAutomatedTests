package org.anele.utils;

import org.anele.base.PageDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GetWebElements {

    //    public GetWebElements(WebDriver driver){
//        PageDriver.getWebDriver() = driver;
//    }
    public static WebElement getXpathElement(String elements) {
        return PageDriver.getWebDriver().findElement(By.xpath(elements));
    }

    public static WebElement getByClasName(String elements) {
        return PageDriver.getWebDriver().findElement(By.className(elements));
    }

    public static WebElement getById(String element) {
        return PageDriver.getWebDriver().findElement(By.id(element));
    }

    public static WebElement getByName(String element) {
        return PageDriver.getWebDriver().findElement(By.name(element));
    }

    public static WebElement getByLink(String element) {
        return PageDriver.getWebDriver().findElement(By.linkText(element));
    }

    public static List<WebElement> getWebElementsByXpath(String elements) {
        return PageDriver.getWebDriver().findElements(By.xpath(elements));
    }
}
