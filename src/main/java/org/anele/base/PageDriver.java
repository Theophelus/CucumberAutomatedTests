package org.anele.base;

import org.openqa.selenium.WebDriver;

public class PageDriver {
    private static final ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();
    //define private attribute of pageDriver class
    private static PageDriver instance = null;

    //define private constructor to restrict recreate of object outside class
    private PageDriver() {

    }

    //restring to one WebDriver object
    public static PageDriver getInstance() {
        if (instance == null) {
            instance = new PageDriver();
        }
        return instance;
    }

    //set drivers
    public void setWebDriver(WebDriver driver) {
        webDriver = driver;
    }

    //get drivers
    public WebDriver getDriver() {
        return webDriver.get();
    }

}
