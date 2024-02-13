package org.anele.base;

import org.openqa.selenium.WebDriver;

public class PageDriver {
    private static final ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();
    //define private attribute of pageDriver class
    private static PageDriver instance = null;
    //define private constructor to restrict recreate of object outside class
    private PageDriver() {
    }
    //set drivers
    public static void setWebDriver(WebDriver driver) {
        webDriver.set(driver);
    }
    //get drivers
    public static WebDriver getWebDriver() {
        return webDriver.get();
    }


}
