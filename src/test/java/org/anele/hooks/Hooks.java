package org.anele.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.anele.base.Config;
import org.anele.base.DriverFactory;
import org.anele.base.PageDriver;


public class Hooks {
    @Before
    public void setup() throws InterruptedException {
//        String browser = Config.browser;
        DriverFactory.getWebDriver();
        //set drivers
        System.out.println("Drivers to be set: " + PageDriver.getWebDriver());
        System.out.println("Driver instantiated" + PageDriver.getWebDriver().getTitle());
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }

}
