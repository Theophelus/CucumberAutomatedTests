package org.massimoDutti.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GetWebElements {
    private static WebDriver driver = null;
    public GetWebElements(WebDriver driver){
        this.driver = driver;
    }
    public static WebElement getXpathElement(String elements){
        return driver.findElement(By.xpath(elements));
    }
    public static WebElement getByClasName(String elements){
        return driver.findElement(By.className(elements));
    }
    public static WebElement getById(String element){
        return driver.findElement(By.id(element));
    }
    public static WebElement getByName(String element){
        return driver.findElement(By.name(element));
    }
    public static WebElement getByLink(String element){
        return driver.findElement(By.linkText(element));
    }
    public static List<WebElement> getWebElementsByXpath(String elements){
        return driver.findElements(By.xpath(elements));
    }
}
